/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author User
 */
public class modelopago extends Pago{
  ConexionPG conpg = new ConexionPG();
  public modelopago(){
  
  }

    public modelopago(int pago_codigo, String deuda, String pag_rutina, Date fecha, int cod_cliente) {
        super(pago_codigo, deuda, pag_rutina, fecha, cod_cliente);
    }

  
  
    
      public SQLException crearPago() {
        String sql = "INSERT INTO Pago(pag_codigo, pag_rutina,pag_deuda,pag_fecha,pag_codcli) VALUES ('" + getPago_codigo()+ "', '" + getPag_rutina() + "', '"   + getDeuda()  +"','"+getFecha()+"', '"+getCod_cliente()+ "');";

        return conpg.accion(sql);
    }

    public SQLException modificarPago() {
        String sql = "UPDATE Pago SET pag_codigo = '"+getPago_codigo()+"', pag_rutina='" +getPag_rutina()+"',pag_deuda='"+getDeuda()+"' ,pag_fecha='"+getFecha()   +"' WHERE pag_codcli = '"+getCod_cliente()+"';";

        return conpg.accion(sql);
    }

    public List<Pago> listapagosTabla() {
        try {
            //Me retorna un "List" de "persona"
            List<Pago> lista = new ArrayList<>();

            String sql = "select * from pago";

            ResultSet rs = conpg.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                //Crear las instancias de las personas
            Pago pago = new Pago(pago_codigo, deuda, pag_rutina, fecha, cod_cliente);

                //Todo lo que haga en la sentencia define como voy a extraer los datos
               pago.setPago_codigo(rs.getInt("pag_codigo"));
               
                pago .setPag_rutina(rs.getString("pag_rutina"));
                pago.setDeuda(rs.getString("pag_deuda"));
                pago.setFecha(rs.getDate("pag_fecha"));
                pago .setCod_cliente(rs.getInt("pag_codcli"));
              

                lista.add(pago); //Agrego los datos a la lista
            }

            //Cierro la conexion a la BD
            rs.close();
            //Retorno la lista
            return lista;

        } catch (SQLException ex) {
             Logger.getLogger(modelopago.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Pago> buscarPagos(int cli_codper) {
        try {
            //Me retorna un "List" de "persona"
            List<Pago> lista = new ArrayList<>();

            String sql = "select * from pago where pag_codcli like '" + cod_cliente + "%'";

            ResultSet rs = conpg.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                //Crear las instancias de las personas
              Pago pago = new Pago();

                //Todo lo que haga en la sentencia define como voy a extraer los datos
               pago.setPago_codigo(rs.getInt("pag_codigo"));
                pago .setPag_rutina(rs.getString("pag_rutina"));
                pago .setDeuda(rs.getString("pag_deuda"));
                pago.setFecha(rs.getDate("pag_fecha"));
                pago.setCod_cliente(rs.getInt("pag_codcli"));
            }

            //Cierro la conexion a la BD
            rs.close();
            //Retorno la lista
            return lista;

        } catch (SQLException ex) {
            Logger.getLogger(modelopago.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int traerCodigodepago(int cod_clip) {
        int codigo = 0;
        try {

            String sql = "select pag_codcli from pago where pag_codcli = '" + getCod_cliente()+ "'";

            ResultSet rs = conpg.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                codigo = rs.getInt("pag_codcli"); //Trae el codigo de la persona recien creada

            }

            //Cierro la conexion a la BD
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(modelopago.class.getName()).log(Level.SEVERE, null, ex);

        }

        return codigo;
    }

    public int validarRepetidospago(int pagcod) { //Metodo que sirve para validar la cantidad de cedulas existentes en la BD
        int cantidad = 0;
        try {

            String sql = "select COUNT(*) from pago where pag_codigo='" + pagcod + "'";

            ResultSet rs = conpg.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                cantidad = rs.getInt("COUNT"); //Trae la cantidad de dni repetidos

            }

            //Cierro la conexion a la BD
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(modelopago.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cantidad;
    }
}

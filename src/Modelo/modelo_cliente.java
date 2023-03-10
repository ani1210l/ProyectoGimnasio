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
 * @author damian
 */
public class modelo_cliente extends Cliente{
     ConexionPG conpg = new ConexionPG();

    public modelo_cliente() {
    }

    public modelo_cliente(int cliente_codigo, Date fecha_ingreso, int cli_codper) {
        super(cliente_codigo, fecha_ingreso, cli_codper);
    }

    public modelo_cliente(int cliente_codigo, Date fecha_ingreso, int cli_codper, int cod_persona, String per_cedula, String per_nombre, String per_apellido, Date per_fechaNac, String per_telefono, String per_direccion) {
        super(cliente_codigo, fecha_ingreso, cli_codper, cod_persona, per_cedula, per_nombre, per_apellido, per_fechaNac, per_telefono, per_direccion);
    }

   

    

 
    
      public SQLException crearCliente() {
        String sql = "INSERT INTO Cliente(Cod_cliente, cliFecha_ingreso,cli_codper) VALUES ('" + getCliente_codigo()+ "', '" + getFecha_ingreso()+ "', '" + getCli_codper()  + "');";

        return conpg.accion(sql);
    }

    public SQLException modificarCliente() {
        String sql = "UPDATE Cliente SET Cod_cliente = '"+getCliente_codigo()+"' WHERE cli_codper = '"+getCli_codper()+"';";

        return conpg.accion(sql);
    }

    public List<Cliente> listaclientesTabla() {
        try {
            //Me retorna un "List" de "persona"
            List<Cliente> lista = new ArrayList<>();

            String sql = "select * from cliente";

            ResultSet rs = conpg.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                //Crear las instancias de las personas
                Cliente cliente = new Cliente();

                //Todo lo que haga en la sentencia define como voy a extraer los datos
               cliente.setCliente_codigo(rs.getInt("Cod_cliente"));
                cliente .setFecha_ingreso(rs.getDate("cliFecha_ingreso"));
                cliente .setCli_codper(rs.getInt("cli_codper"));
              

                lista.add(cliente); //Agrego los datos a la lista
            }

            //Cierro la conexion a la BD
            rs.close();
            //Retorno la lista
            return lista;

        } catch (SQLException ex) {
             Logger.getLogger(modelo_cliente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Cliente> buscarcliente(int cli_codper) {
        try {
            //Me retorna un "List" de "persona"
            List<Cliente> lista = new ArrayList<>();

            String sql = "select * from cliente where cli_codper like '" + cli_codper + "%'";

            ResultSet rs = conpg.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                //Crear las instancias de las personas
              Cliente cliente = new Cliente();

                //Todo lo que haga en la sentencia define como voy a extraer los datos
               cliente.setCliente_codigo(rs.getInt("Cod_cliente"));
                cliente .setFecha_ingreso(rs.getDate("cliFecha_ingreso"));
                cliente .setCli_codper(rs.getInt("cli_codper"));
            }

            //Cierro la conexion a la BD
            rs.close();
            //Retorno la lista
            return lista;

        } catch (SQLException ex) {
            Logger.getLogger(modelo_cliente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int traerCodigoDeclienteCrear(int Cod_cliente) {
        int codigo = 0;
        try {

            String sql = "select Cod_cliente from cliente where cli_codper = '" + getCli_codper() + "'";

            ResultSet rs = conpg.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                codigo = rs.getInt("Cod_cliente"); //Trae el codigo de la persona recien creada

            }

            //Cierro la conexion a la BD
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(modelo_cliente.class.getName()).log(Level.SEVERE, null, ex);

        }

        return codigo;
    }

    public int validarRepetidoscl(int cli_codper) { //Metodo que sirve para validar la cantidad de cedulas existentes en la BD
        int cantidad = 0;
        try {

            String sql = "select COUNT(*) from cliente where cli_codper='" + cli_codper + "'";

            ResultSet rs = conpg.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                cantidad = rs.getInt("COUNT"); //Trae la cantidad de dni repetidos

            }

            //Cierro la conexion a la BD
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(modelo_cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cantidad;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

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
public class Modelo_Cliserv extends ClienteServicio{
    ConexionPG conpg = new ConexionPG();

    public Modelo_Cliserv() {
        
    }
    
    
    public SQLException crearSERV_CLI() {
        String sql = "INSERT INTO Cliente_Servicio(Cliente_servicioCod, Servicio_cod,servcli_fechaingreso,servcli_fechafin,Cod_cliente) VALUES ('" + getCli_serv_cod()+ "', '" + getCli_serv_cod()+ "', '"   + getServcli_fechaingreso()+"','"+getServcli_fechafin()+"', '"+getCod_cliente()+ "');";

        return conpg.accion(sql);
    }

    public SQLException modificarSERV_CLI() {
        String sql = "UPDATE Cliente_Servicio SET Cliente_servicioCod = '"+getCli_serv_cod()+"', Servicio_cod='" +getServicio_cod()+"',servcli_fechaingreso='"+getFecha_ingreso()+"' ,servcli_fechafin='"+getServcli_fechafin()+"' WHERE Cod_cliente = '"+getCod_cliente()+"';";

        return conpg.accion(sql);
    }

    public List<ClienteServicio> listaliClienteServiciosTabla() {
        try {
            //Me retorna un "List" de "persona"
            List<ClienteServicio> lista = new ArrayList<>();

            String sql = "select * from Cliente_Servicio";

            ResultSet rs = conpg.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                //Crear las instancias de las personas
            ClienteServicio clienteServicio = new ClienteServicio();

                //Todo lo que haga en la sentencia define como voy a extraer los datos
               clienteServicio.setCli_serv_cod(rs.getInt("Cliente_servicioCod"));
               
                clienteServicio .setServicio_cod(rs.getInt("Servicio_cod"));
                clienteServicio.setFecha_ingreso(rs.getDate("servcli_fechaingreso"));
                clienteServicio.setServcli_fechafin(rs.getDate("servcli_fechafin"));
                clienteServicio .setCod_cliente(rs.getInt("pag_codcli"));
              

                lista.add(clienteServicio); //Agrego los datos a la lista
            }

            //Cierro la conexion a la BD
            rs.close();
            //Retorno la lista
            return lista;

        } catch (SQLException ex) {
             Logger.getLogger(Modelo_Cliserv.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<ClienteServicio> buscarclientesClienteServicios(int cliserv_codper) {
        try {
            //Me retorna un "List" de "persona"
            List<ClienteServicio> lista = new ArrayList<>();

            String sql = "select * from Cliente_Servicio where Cod_cliente like '" + cliserv_codper + "%'";

            ResultSet rs = conpg.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                //Crear las instancias de las personas
            ClienteServicio clienteServicio = new ClienteServicio();

                //Todo lo que haga en la sentencia define como voy a extraer los datos
               clienteServicio.setCli_serv_cod(rs.getInt("Cliente_servicioCod"));
               
                clienteServicio .setServicio_cod(rs.getInt("Servicio_cod"));
                clienteServicio.setFecha_ingreso(rs.getDate("servcli_fechaingreso"));
                clienteServicio.setServcli_fechafin(rs.getDate("servcli_fechafin"));
                clienteServicio .setCod_cliente(rs.getInt("pag_codcli"));
            }

            //Cierro la conexion a la BD
            rs.close();
            //Retorno la lista
            return lista;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Servicio.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

   
    
}

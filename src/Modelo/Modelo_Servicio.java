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
 * @author Taataiana Lalvay
 */
public class Modelo_Servicio extends Servicio {

    ConexionPG conpg = new ConexionPG();

    public Modelo_Servicio() {
    }

    public Modelo_Servicio(int ser_codigo, String ser_hora, String serv_tipo, String serv_detalle, Date serv_fechaIngreso) {
        super(ser_codigo, ser_hora, serv_tipo, serv_detalle, serv_fechaIngreso);
    }

    public SQLException crearServicio() {
        String sql = "INSERT INTO servicio(serv_cod, serv_tipo,serv_hora,serv_detalle,serv_fechaingreso) VALUES ('" + getSer_codigo() + "', '" + getServ_tipo() + "', '" + "', '" + getSer_hora() + "', '" + getServ_detalle() + "', '" + getServ_fechaIngreso() + "');";

        return conpg.accion(sql);
    }

    public SQLException modificarServicio() {
        String sql = "UPDATE servicio SET serv_tipo = '" + getServ_tipo() + "', serv_hora='" + getSer_hora() + "', serv_detalle='" + getServ_detalle() + "', serv_fechaingreso='" + getServ_fechaIngreso() + "' WHERE serv_cod = '" + getSer_codigo() + "';";

        return conpg.accion(sql);
    }

    public List<Servicio> listaserviciosTabla() {
        try {
            //Me retorna un "List" de "persona"
            List<Servicio> lista = new ArrayList<>();

            String sql = "select * from servicio";

            ResultSet rs = conpg.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                //Crear las instancias de las personas
                Servicio servicio = new Servicio();

                //Todo lo que haga en la sentencia define como voy a extraer los datos
                servicio.setSer_codigo(rs.getInt("serv_cod"));
                servicio.setServ_tipo(rs.getString("serv_tipo"));
                servicio.setSer_hora(rs.getString("serv_hora"));
                servicio.setServ_detalle(rs.getString("serv_detalle"));
                servicio.setServ_fechaIngreso(rs.getDate("serv_fechaingreso"));

                lista.add(servicio); //Agrego los datos a la lista
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

    public List<Servicio> buscarServicio(int codigo_serv) {
        try {
            //Me retorna un "List" de "persona"
            List<Servicio> lista = new ArrayList<>();

            String sql = "select * from servicio where serv_cod like '" + codigo_serv + "%'";

            ResultSet rs = conpg.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                Servicio servicio = new Servicio();

                //Todo lo que haga en la sentencia define como voy a extraer los datos
                servicio.setSer_codigo(rs.getInt("serv_cod"));
                servicio.setServ_tipo(rs.getString("serv_tipo"));
                servicio.setSer_hora(rs.getString("serv_hora"));
                servicio.setServ_detalle(rs.getString("serv_detalle"));
                servicio.setServ_fechaIngreso(rs.getDate("serv_fechaingreso"));
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

    
    
    //********DUDA
    
    public int traerCodigoDeServicioCrear(String servtipos) {
        int codigo = 0;
        try {

            String sql = "select serv_cod from servicio where serv_tipo = '" + servtipos + "'";

            ResultSet rs = conpg.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                codigo = rs.getInt("serv_cod"); //Trae el codigo de la persona recien creada

            }

            //Cierro la conexion a la BD
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Servicio.class.getName()).log(Level.SEVERE, null, ex);

        }

        return codigo;
    }

    public int validarRepetidoscl(int codigo_serv) { 
        int cantidad = 0;
        try {

            String sql = "select COUNT(*) from servicio where serv_cod='" + codigo_serv + "'";

            ResultSet rs = conpg.consulta(sql); //La consulta nos devuelve un "ResultSet"

            while (rs.next()) {
                cantidad = rs.getInt("COUNT");

            }

            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Servicio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cantidad;
    }

}

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
 * @author Frank
 */
public class Modelo_Horario extends Horario {

    ConexionPG conpg = new ConexionPG();

    public Modelo_Horario() {

    }

    public Modelo_Horario(int horario_codigo, String jornada, boolean estado) {
        super(horario_codigo, jornada, estado);
    }

    public SQLException crear_Horario() {
        String sql = "INSERT INTO Horario ( hor_jonarda) VALUES ('" + getJornada() + "');";

        return conpg.accion(sql);
    }

    public SQLException modificar_Horario() {
        String sql = "UPDATE Horario SET hor_jonarda= '" + getJornada() + "'";

        return conpg.accion(sql);
    }

    public List<Horario> listaHorariosTabla() {
        try {
            //Me retorna un "List" de "persona"
            List<Horario> lista = new ArrayList<>();

            String sql = "select * from horario";

            ResultSet rs = conpg.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                //Crear las instancias de las personas
                Horario hora = new Horario();

                //Todo lo que haga en la sentencia define como voy a extraer los datos
                hora.setHorario_codigo(rs.getInt("hor_codigo"));
                hora.setJornada(rs.getString("hor_jonarda"));

                lista.add(hora); //Agrego los datos a la lista
            }

            //Cierro la conexion a la BD
            rs.close();
            //Retorno la lista
            return lista;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Horario.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Horario> buscarHorario(String Jornada) {
        try {
            //Me retorna un "List" de "persona"
            List<Horario> lista = new ArrayList<>();

            String sql = "select * from horario where hor_codigo like '" + Jornada + "%'";

            ResultSet rs = conpg.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                //Crear las instancias de las personas
                Horario hora = new Horario();

                //Todo lo que haga en la sentencia define como voy a extraer los datos
                hora.setHorario_codigo(rs.getInt("hor_codigo"));
                hora.setJornada(rs.getString("hor_jonarda"));

                lista.add(hora); //Agrego los datos a la lista
            }

            //Cierro la conexion a la BD
            rs.close();
            //Retorno la lista
            return lista;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Horario.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int traerCodigoDeHorarioCrear(String Jornada) {
        int codigo = 0;
        try {

            String sql = "select * from horario where hor_codigo like '" + Jornada + "%'";

            ResultSet rs = conpg.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                codigo = rs.getInt("cod_persona"); //Trae el codigo de la persona recien creada

            }

            //Cierro la conexion a la BD
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Horario.class.getName()).log(Level.SEVERE, null, ex);

        }

        return codigo;
    }

    public int validarRepetidos(String Jornada) { //Metodo que sirve para validar la cantidad de cedulas existentes en la BD
        int cantidad = 0;
        try {

            String sql = "select COUNT(*) from horario where hor_codigo='" + Jornada + "'";

            ResultSet rs = conpg.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                cantidad = rs.getInt("COUNT"); //Trae la cantidad de dni repetidos

            }

            //Cierro la conexion a la BD
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Horario.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cantidad;
    }
}

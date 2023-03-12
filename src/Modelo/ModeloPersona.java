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
 * @author Tatiana Lalvay
 */
public class ModeloPersona extends Persona {
    ConexionPG conpg = new ConexionPG();

    public ModeloPersona() {
    }

    public ModeloPersona(int cod_persona, String per_cedula, String per_nombre, String per_apellido, Date per_fechaNac, String per_telefono, String per_direccion) {
        super(cod_persona, per_cedula, per_nombre, per_apellido, per_fechaNac, per_telefono, per_direccion);
    }

   

    public SQLException crearPersona() {
        String sql = "INSERT INTO persona( per_cedula, per_nombre,per_apellido, per_fechanac, per_telefono, per_direccion) VALUES ('" + getPer_cedula() + "', '" + getPer_nombre() + "', '"  + "', '" + getPer_apellido() + "', '"  + getPer_fechaNac() + "', '" + getPer_telefono() + "', '"  + getPer_direccion() + "');";

        return conpg.accion(sql);
    }

    public SQLException modificarPersona() {
        String sql = "UPDATE persona SET per_nombre= '"+getPer_nombre()+"', per_apellido='"+getPer_apellido()+"', per_fechanac='"+getPer_fechaNac()+"', per_telefono='"+getPer_telefono()+"', per_direccion='"+getPer_direccion()+"' WHERE per_cedula = '"+getPer_cedula()+"';";

        return conpg.accion(sql);
    }

    public List<Persona> listaPersonasTabla() {
        try {
            //Me retorna un "List" de "persona"
            List<Persona> lista = new ArrayList<>();

            String sql = "select * from persona";

            ResultSet rs = conpg.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                //Crear las instancias de las personas
                Persona persona = new Persona();

                //Todo lo que haga en la sentencia define como voy a extraer los datos
                persona.setPer_cedula(rs.getString("per_cedula"));
                persona.setPer_nombre(rs.getString("per_nombre"));
                persona.setPer_apellido(rs.getString("per_apellido"));
                persona.setPer_fechaNac(rs.getDate("per_fechanac"));
                persona.setPer_telefono(rs.getString("per_telefono"));
                persona.setPer_direccion(rs.getString("per_direccion"));

                lista.add(persona); //Agrego los datos a la lista
            }

            //Cierro la conexion a la BD
            rs.close();
            //Retorno la lista
            return lista;

        } catch (SQLException ex) {
             Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Persona> buscarPersona(String cedula) {
        try {
            //Me retorna un "List" de "persona"
            List<Persona> lista = new ArrayList<>();

            String sql = "select * from persona where per_cedula like '" + cedula + "%'";

            ResultSet rs = conpg.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                //Crear las instancias de las personas
                Persona persona = new Persona();

                //Todo lo que haga en la sentencia define como voy a extraer los datos
               persona.setCod_persona(rs.getInt("cod_persona"));
                persona.setPer_cedula(rs.getString("per_cedula"));
                persona.setPer_nombre(rs.getString("per_nombre"));
                persona.setPer_apellido(rs.getString("per_apellido"));
                persona.setPer_fechaNac(rs.getDate("per_fechanac"));
                persona.setPer_telefono(rs.getString("per_telefono"));
                persona.setPer_direccion(rs.getString("per_direccion"));

                lista.add(persona); //Agrego los datos a la lista
            }

            //Cierro la conexion a la BD
            rs.close();
            //Retorno la lista
            return lista;

        } catch (SQLException ex) {
            Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int traerCodigoDePersonaCrear(String cedula) {
        int codigo = 0;
        try {

            String sql = "select cod_persona from persona where per_cedula = '" + cedula + "'";

            ResultSet rs = conpg.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                codigo = rs.getInt("cod_persona"); //Trae el codigo de la persona recien creada

            }

            //Cierro la conexion a la BD
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);

        }

        return codigo;
    }

    public int validarRepetidos(String cedula) { //Metodo que sirve para validar la cantidad de cedulas existentes en la BD
        int cantidad = 0;
        try {

            String sql = "select COUNT(*) from persona where per_cedula='" + cedula + "'";

            ResultSet rs = conpg.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                cantidad = rs.getInt("COUNT"); //Trae la cantidad de dni repetidos

            }

            //Cierro la conexion a la BD
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cantidad;
    }
}

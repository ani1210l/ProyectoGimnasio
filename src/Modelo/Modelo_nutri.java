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
 * @author  Santiago Tapia 
 */
public class Modelo_nutri extends Nutricionista {
    ConexionPG conpg = new ConexionPG();
//
//    public Modelo_nutri() {
//    }
//
//    public Modelo_nutri(int nutricionista_codigo, String rutina) {
//        super(nutricionista_codigo, rutina);
//    }
//
//    public Modelo_nutri(int empleado_codigo, double salario_emp, int horario_codigo, int emp_codper) {
//        super(empleado_codigo, salario_emp, horario_codigo, emp_codper);
//    }
//



    public SQLException crearNutricionista() {
        String sql = "INSERT INTO nutricionista(nutri_codigo,nutri_rutina,nutri_codemp) VALUES ('" + getNutricionista_codigo()+ "', '" + getRutina()+ "', '"  + "', '" + getEmpleado_codigo()+"');";

        return conpg.accion(sql);
    }

    public SQLException modificarNutricionista() {
        String sql = "UPDATE nutricionista SET nutri_codigo= '"+getNutricionista_codigo()+"', nutri_rutina='"+getRutina()+"', nutri_codemp='"+getEmpleado_codigo()+"');";

        return conpg.accion(sql);
    }

    public List<Nutricionista> listaNutricionistaTabla() {
        try {
            //Me retorna un "List" de "nutricionista"
            List<Nutricionista> listaNutri = new ArrayList<>();

            String sql = "select * from nutricionista";

            ResultSet rs = conpg.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                //Crear las instancias de las empleados
                Nutricionista nutri = new Nutricionista();

                //Todo lo que haga en la sentencia define como voy a extraer los datos
                nutri.setEmpleado_codigo(rs.getInt("nutri_codigo"));
                nutri.setRutina(rs.getString("nutri_rutina"));
                nutri.setSalario_emp(rs.getInt("nutri_codemp"));                

                listaNutri.add(nutri); //Agrego los datos a la lista
            }

            //Cierro la conexion a la BD
            rs.close();
            //Retorno la lista
            return listaNutri;

        } catch (SQLException ex) {
             Logger.getLogger(Modelo_nutri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Nutricionista> buscarNutri(int nutri_codigo) {
        try {

            List<Nutricionista> listaNutriBs = new ArrayList<>();

            String sql = "select * from nutricionista where nutri_codigo like '" + nutri_codigo + "%'";

            ResultSet rs = conpg.consulta(sql);

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                //Crear las instancias de las empleados
                Nutricionista nutri = new Nutricionista();

                //Todo lo que haga en la sentencia define como voy a extraer los datos
                nutri.setEmpleado_codigo(rs.getInt("nutri_codigo"));
                nutri.setRutina(rs.getString("nutri_rutina"));
                nutri.setSalario_emp(rs.getInt("nutri_codemp"));                

                listaNutriBs.add(nutri); //Agrego los datos a la lista
            }

            //Cierro la conexion a la BD
            rs.close();
            //Retorno la lista
            return listaNutriBs;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_nutri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int traerCodigoDeNutriCrear(int nutricionisa_codigo) {
        int codigo = 0;
        try {

            String sql = "select nutri_codigo from nutricionista where nutri_codemp  = '" + getNutricionista_codigo()+ "'";

            ResultSet rs = conpg.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                codigo = rs.getInt("nutri_codigo"); 

            }

            //Cierro la conexion a la BD
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_nutri.class.getName()).log(Level.SEVERE, null, ex);

        }

        return codigo;
    }

    public int validarRepetidos(int nutricionista_codigo ) { //Metodo que sirve para validar la cantidad de cedulas existentes en la BD
        int cantidadnutri = 0;
        try {

            String sql = "select COUNT(*) from nutricionista where nutri_codigo='" + nutricionista_codigo + "'";

            ResultSet rs = conpg.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                cantidadnutri = rs.getInt("COUNT"); //Trae la cantidad de dni repetidos

            }

            //Cierro la conexion a la BD
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_nutri.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cantidadnutri;
    }
}

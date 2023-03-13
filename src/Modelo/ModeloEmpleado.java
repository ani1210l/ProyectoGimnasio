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
public class ModeloEmpleado extends Empleado {
    ConexionPG conpg = new ConexionPG();

    public ModeloEmpleado() {
    }

    public ModeloEmpleado(int empleado_codigo, double salario_emp, int horario_codigo, int emp_codper) {
        super(empleado_codigo, salario_emp, horario_codigo, emp_codper);
    }

    public ModeloEmpleado(int empleado_codigo, double salario_emp, int horario_codigo, int emp_codper, int cod_persona, String per_cedula, String per_nombre, String per_apellido, Date per_fechaNac, String per_telefono, String per_direccion) {
        super(empleado_codigo, salario_emp, horario_codigo, emp_codper, cod_persona, per_cedula, per_nombre, per_apellido, per_fechaNac, per_telefono, per_direccion);
    }



    public SQLException crearEmpleado() {
        String sql = "INSERT INTO empleado(emp_codigo, emp_codper,emp_salario,emp_horario) VALUES ('" + getEmpleado_codigo() + "', '" + getEmp_codper()+ "', '"  + "', '" + getSalario_emp() + "', '"  + getHorario_codigo() + "');";

        return conpg.accion(sql);
    }

    public SQLException modificarEmpleado() {
        String sql = "UPDATE empleado SET emp_codigo= '"+getEmpleado_codigo()+"', emp_codper='"+getEmp_codper()+"', emp_salario='"+getSalario_emp()+"', emp_horario='"+getHorario_codigo() + "');";

        return conpg.accion(sql);
    }

    public SQLException eliminarEmpleado(int Empleado_codigo) { //elimina 

        String sql = "DELETE FROM empleado WHERE emp_codigo = '" + Empleado_codigo + "';";

        return conpg.accion(sql);
    }
    
     public List<Empleado> listaEmpleado() {
        try {
            //Me retorna un "List" de "persona"
            List<Empleado> listaEmpleado = new ArrayList<>();

            String sql = "select emp_codigo,emp_codper,emp_salario,emp_horario from empleado";

            ResultSet rs = conpg.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                //Crear las instancias de las personas
                Empleado empleado = new Empleado();

                //Todo lo que haga en la sentencia define como voy a extraer los datos
                empleado.setEmpleado_codigo(rs.getInt("emp_codigo"));
                empleado.setEmp_codper(rs.getInt("emp_codper"));
                empleado.setSalario_emp(rs.getDouble("emp_salario"));
                empleado.setHorario_codigo(rs.getInt("emp_horario"));

                listaEmpleado.add(empleado);
            }

            rs.close();
            return listaEmpleado;

        } catch (SQLException ex) {
            Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
    public List<Empleado> listaEmpleadosTabla() {
        try {
            //Me retorna un "List" de "empleado"
            List<Empleado> listaEmpleado = new ArrayList<>();

            String sql = "select * from empleado";

            ResultSet rs = conpg.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                //Crear las instancias de las empleados
                Empleado empleado = new Empleado();

                //Todo lo que haga en la sentencia define como voy a extraer los datos
                empleado.setEmpleado_codigo(rs.getInt("emp_codigo"));
                empleado.setEmp_codper(rs.getInt("emp_codper"));
                empleado.setSalario_emp(rs.getDouble("emp_salario"));
                empleado.setHorario_codigo(rs.getInt("emp_horario"));
                

                listaEmpleado.add(empleado); //Agrego los datos a la lista
            }

            //Cierro la conexion a la BD
            rs.close();
            //Retorno la lista
            return listaEmpleado;

        } catch (SQLException ex) {
             Logger.getLogger(ModeloEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Empleado> buscarEmpleado(String empleado_codigo) {
        try {

            List<Empleado> listaEmpleadoBs = new ArrayList<>();

            String sql = "select * from empleado where emp_codigo like '" + empleado_codigo + "%'";

            ResultSet rs = conpg.consulta(sql);

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                //Crear las instancias de las personas
                Empleado empleado = new Empleado();

                //Todo lo que haga en la sentencia define como voy a extraer los datos
                empleado.setEmpleado_codigo(rs.getInt("emp_codigo"));
                empleado.setEmp_codper(rs.getInt("emp_codper"));
                empleado.setSalario_emp(rs.getDouble("emp_salario"));
                empleado.setHorario_codigo(rs.getInt("emp_emp"));
                
                listaEmpleadoBs.add(empleado); //Agrego los datos a la lista
            }

            //Cierro la conexion a la BD
            rs.close();
            //Retorno la lista
            return listaEmpleadoBs;

        } catch (SQLException ex) {
            Logger.getLogger(ModeloEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int traerCodigoDeEmpleadoCrear(String getEmp_codper) {
        int codigo = 0;
        try {

            String sql = "select emp_codigo from empleado where emp_codper = '" + getEmp_codper() + "'";

            ResultSet rs = conpg.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                codigo = rs.getInt("emp_codper"); 

            }

            //Cierro la conexion a la BD
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(ModeloEmpleado.class.getName()).log(Level.SEVERE, null, ex);

        }

        return codigo;
    }

    public int validarRepetidos(int empleado_codigo ) { //Metodo que sirve para validar la cantidad de cedulas existentes en la BD
        int cantidadEmpleado = 0;
        try {

            String sql = "select COUNT(*) from empleado where emp_codigo='" + empleado_codigo + "'";

            ResultSet rs = conpg.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                cantidadEmpleado = rs.getInt("COUNT"); //Trae la cantidad de dni repetidos

            }

            //Cierro la conexion a la BD
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(ModeloEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cantidadEmpleado;
    }

    
}

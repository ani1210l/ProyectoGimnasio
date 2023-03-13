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
 * @author Carla Leon
 */
public class Modelo_Instructor extends Instructor {

    ConexionPG conpg = new ConexionPG();

    public Modelo_Instructor() {
    }

    public Modelo_Instructor(int ins_codigo, String ins_areatrabajo, String descripcion, int ins_codemp) {
        super(ins_codigo, ins_areatrabajo, descripcion, ins_codemp);
    }

    public Modelo_Instructor(int ins_codigo, String ins_areatrabajo, String descripcion, int ins_codemp, int empleado_codigo, double salario_emp, int horario_codigo, int emp_codper) {
        super(ins_codigo, ins_areatrabajo, descripcion, ins_codemp, empleado_codigo, salario_emp, horario_codigo, emp_codper);
    }

    public Modelo_Instructor(int ins_codigo, String ins_areatrabajo, String descripcion, int ins_codemp, int empleado_codigo, double salario_emp, int horario_codigo, int emp_codper, int cod_persona, String per_cedula, String per_nombre, String per_apellido, Date per_fechaNac, String per_telefono, String per_direccion) {
        super(ins_codigo, ins_areatrabajo, descripcion, ins_codemp, empleado_codigo, salario_emp, horario_codigo, emp_codper, cod_persona, per_cedula, per_nombre, per_apellido, per_fechaNac, per_telefono, per_direccion);
    }

    public SQLException CrearInstructor() {
        String sql = "INSERT INTO instructor (ins_codigo, ins_areatrabajo, descripcion, ins_codemp) VALUES ('" + getIns_codigo() + "','" + getIns_areatrabajo() + "','" + getDescripcion() + "," + getIns_codemp() + "')";

        return conpg.accion(sql);
    }

    public SQLException modificarInstructor() {
        String sql = "UPDATE instructor SET ins_codigo = '" + getIns_codigo() + "'WHERE  ins_codigo = '" + getIns_codemp() + "';";
        return conpg.accion(sql);
    }

    public List<Instructor> listaInstructorTabla() {
        try {
            //Me retorna un "List" de "persona"
            List<Instructor> lista = new ArrayList<>();

            String sql = "select * from instructor";

            ResultSet rs = conpg.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                // crear las instancias

                Instructor instructor = new Instructor();
                instructor.setIns_codigo(rs.getInt("ins_codigo"));
                instructor.setIns_areatrabajo(rs.getString("ins_areatrabajo"));
                instructor.setDescripcion(rs.getString("descripcion"));
                instructor.setIns_codemp(rs.getInt("ins_codemp"));

                lista.add(instructor);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Instructor.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Instructor> BuscarInstructor(String ins_codemp) {
        try {
            List<Instructor> lista = new ArrayList<>();
            String sql = "Select * from instructor where ins_codemp '" + ins_codemp + "%'";
            ResultSet rs = conpg.consulta(sql);
            while (rs.next()) {
                Instructor instructor = new Instructor();

                instructor.setIns_codigo(rs.getInt("ins_codigo"));
                instructor.setIns_areatrabajo(rs.getString("ins_areatrabajo"));
                instructor.setDescripcion(rs.getString("descripcion"));
                instructor.setIns_codemp(rs.getInt("ins_codemp"));

            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Instructor.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int Traer_cod_instructor(int ins_cod) {
        int codigo = 0;
        try {

            String sql = "select ins_cod from  instructor where ins_codemp = '" + getIns_codemp() + "'";

            ResultSet rs = conpg.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                codigo = rs.getInt("ins_cod"); //Trae el codigo de la persona recien creada

            }

            //Cierro la conexion a la BD
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(modelo_cliente.class.getName()).log(Level.SEVERE, null, ex);

        }

        return codigo;
    }

    public int validarRepetidoscl(int ins_codemp) { //Metodo que sirve para validar la cantidad de cedulas existentes en la BD
        int cantidad = 0;
        try {

            String sql = "select COUNT(*) from instructor where ins_codemp='" + ins_codemp + "'";

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

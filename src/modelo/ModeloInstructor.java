package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModeloInstructor extends Instructor {

    ConexionPG conpg = new ConexionPG();

    public ModeloInstructor() {
    }

    public ModeloInstructor(int ins_codigo, int ins_codper, String ins_areatrabajo, String ins_horario, String ins_estado) {
        super(ins_codigo, ins_codper, ins_areatrabajo, ins_horario, ins_estado);
    }

    public ModeloInstructor(int ins_codigo, int ins_codper, String ins_areatrabajo, String ins_horario, String ins_estado, int per_codigo, String per_cedula, String per_nombre, String per_apellido, Date per_fechaNac, String per_telefono, String per_direccion) {
        super(ins_codigo, ins_codper, ins_areatrabajo, ins_horario, ins_estado, per_codigo, per_cedula, per_nombre, per_apellido, per_fechaNac, per_telefono, per_direccion);
    }

    public boolean crearInstructor() {
        String sql = "INSERT INTO instructor(ins_codper, ins_areatrabajo, ins_horario, ins_estado) VALUES (" + getIns_codper() + ",'" + getIns_areatrabajo() + "', '" + getIns_horario() + "', 'A');";

        return conpg.accion(sql);
    }

    public boolean modificarInstructor() {
        String sql = "UPDATE instructor SET ins_areatrabajo = '" + getIns_areatrabajo() + "', ins_horario = '" + getIns_horario() + "' WHERE ins_codigo = " + getIns_codigo() + ";";

        return conpg.accion(sql);
    }

    public boolean eliminarInstructor(int codigoInstructor) {
        String sql = "UPDATE instructor SET ins_estado= 'I' where ins_codigo = " + codigoInstructor + ";";

        return conpg.accion(sql);
    }

    public List<Instructor> listaInstructoresTabla() {
        try {
            //Me retorna un "List" de "instructor"
            List<Instructor> lista = new ArrayList<>();

            String sql = "select * from persona p, instructor i where p.per_codigo = i.ins_codper;";

            ResultSet rs = conpg.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                //Crear la instancia de instructor 
                Instructor instructor = new Instructor();

                //Todo lo que haga en la sentencia define como voy a extraer los datos
                //Informacion de persona
                instructor.setPer_codigo(rs.getInt("per_codigo"));
                instructor.setPer_cedula(rs.getString("per_cedula"));
                instructor.setPer_nombre(rs.getString("per_nombre"));
                instructor.setPer_apellido(rs.getString("per_apellido"));
                instructor.setPer_fechaNac(rs.getDate("per_fechanac"));
                instructor.setPer_telefono(rs.getString("per_telefono"));
                instructor.setPer_direccion(rs.getString("per_direccion"));

                //Informacion de instructor
                instructor.setIns_codigo(rs.getInt("ins_codigo"));
                instructor.setIns_codper(rs.getInt("ins_codper"));
                instructor.setIns_areatrabajo(rs.getString("ins_areatrabajo"));
                instructor.setIns_horario(rs.getString("ins_horario"));
                instructor.setIns_estado(rs.getString("ins_estado"));

                lista.add(instructor); //Agrego los datos a la lista
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
}

package modelo;

import java.util.Date;

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
}

package modelo;

import java.util.Date;

public class Instructor extends Persona {

    private int ins_codigo;
    private int ins_codper;
    private String ins_areatrabajo;
    private String ins_horario;
    private String ins_estado;

    public Instructor() {
    }

    public Instructor(int ins_codigo, int ins_codper, String ins_areatrabajo, String ins_horario, String ins_estado) {
        this.ins_codigo = ins_codigo;
        this.ins_codper = ins_codper;
        this.ins_areatrabajo = ins_areatrabajo;
        this.ins_horario = ins_horario;
        this.ins_estado = ins_estado;
    }

    public Instructor(int ins_codigo, int ins_codper, String ins_areatrabajo, String ins_horario, String ins_estado, int per_codigo, String per_cedula, String per_nombre, String per_apellido, Date per_fechaNac, String per_telefono, String per_direccion) {
        super(per_codigo, per_cedula, per_nombre, per_apellido, per_fechaNac, per_telefono, per_direccion);
        this.ins_codigo = ins_codigo;
        this.ins_codper = ins_codper;
        this.ins_areatrabajo = ins_areatrabajo;
        this.ins_horario = ins_horario;
        this.ins_estado = ins_estado;
    }

    public int getIns_codigo() {
        return ins_codigo;
    }

    public void setIns_codigo(int ins_codigo) {
        this.ins_codigo = ins_codigo;
    }

    public int getIns_codper() {
        return ins_codper;
    }

    public void setIns_codper(int ins_codper) {
        this.ins_codper = ins_codper;
    }

    public String getIns_areatrabajo() {
        return ins_areatrabajo;
    }

    public void setIns_areatrabajo(String ins_areatrabajo) {
        this.ins_areatrabajo = ins_areatrabajo;
    }

    public String getIns_horario() {
        return ins_horario;
    }

    public void setIns_horario(String ins_horario) {
        this.ins_horario = ins_horario;
    }

    public String getIns_estado() {
        return ins_estado;
    }

    public void setIns_estado(String ins_estado) {
        this.ins_estado = ins_estado;
    }
}

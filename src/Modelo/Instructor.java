package Modelo;

import java.sql.Date;

/**
 *
 * @author Michelle Cuzo
 */
public class Instructor extends Empleado {

    private int ins_codigo;
    private String ins_areatrabajo;
    private String descripcion;
    private int ins_codemp;

    public Instructor(int ins_codigo, String ins_areatrabajo, String descripcion, int ins_codemp, int empleado_codigo, double salario_emp, String emp_horario, int emp_codper) {
        super(empleado_codigo, salario_emp, emp_horario, emp_codper);
        this.ins_codigo = ins_codigo;
        this.ins_areatrabajo = ins_areatrabajo;
        this.descripcion = descripcion;
        this.ins_codemp = ins_codemp;
    }

    public Instructor(int ins_codigo, String ins_areatrabajo, String descripcion, int ins_codemp, int empleado_codigo, double salario_emp, String emp_horario, int emp_codper, int cod_persona, String per_cedula, String per_nombre, String per_apellido, Date per_fechaNac, String per_telefono, String per_direccion) {
        super(empleado_codigo, salario_emp, emp_horario, emp_codper, cod_persona, per_cedula, per_nombre, per_apellido, per_fechaNac, per_telefono, per_direccion);
        this.ins_codigo = ins_codigo;
        this.ins_areatrabajo = ins_areatrabajo;
        this.descripcion = descripcion;
        this.ins_codemp = ins_codemp;
    }



    public int getIns_codigo() {
        return ins_codigo;
    }

    public void setIns_codigo(int ins_codigo) {
        this.ins_codigo = ins_codigo;
    }

    public String getIns_areatrabajo() {
        return ins_areatrabajo;
    }

    public void setIns_areatrabajo(String ins_areatrabajo) {
        this.ins_areatrabajo = ins_areatrabajo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIns_codemp() {
        return ins_codemp;
    }

    public void setIns_codemp(int ins_codemp) {
        this.ins_codemp = ins_codemp;
    }

}

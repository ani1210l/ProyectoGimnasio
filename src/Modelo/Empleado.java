
package Modelo;

import java.sql.Date;

/**
 *
 * @author  Santiago Tapia
 */

public class Empleado extends Persona{
    
     private int empleado_codigo;
     private double salario_emp;
     private int horario_codigo;
     private int emp_codper;

    public Empleado() {
    }

    public Empleado(int empleado_codigo, double salario_emp, int horario_codigo, int emp_codper) {
        this.empleado_codigo = empleado_codigo;
        this.salario_emp = salario_emp;
        this.horario_codigo = horario_codigo;
        this.emp_codper = emp_codper;
    }

    public Empleado(int empleado_codigo, double salario_emp, int horario_codigo, int emp_codper, int cod_persona, String per_cedula, String per_nombre, String per_apellido, Date per_fechaNac, String per_telefono, String per_direccion) {
        super(cod_persona, per_cedula, per_nombre, per_apellido, per_fechaNac, per_telefono, per_direccion);
        this.empleado_codigo = empleado_codigo;
        this.salario_emp = salario_emp;
        this.horario_codigo = horario_codigo;
        this.emp_codper = emp_codper;
    }

    public int getEmpleado_codigo() {
        return empleado_codigo;
    }

    public void setEmpleado_codigo(int empleado_codigo) {
        this.empleado_codigo = empleado_codigo;
    }

    public double getSalario_emp() {
        return salario_emp;
    }

    public void setSalario_emp(double salario_emp) {
        this.salario_emp = salario_emp;
    }

    public int getHorario_codigo() {
        return horario_codigo;
    }

    public void setHorario_codigo(int horario_codigo) {
        this.horario_codigo = horario_codigo;
    }

    public int getEmp_codper() {
        return emp_codper;
    }

    public void setEmp_codper(int emp_codper) {
        this.emp_codper = emp_codper;
    }

   
    
    
    
     
     

}
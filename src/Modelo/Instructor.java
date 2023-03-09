package Modelo;

import java.sql.Date;

/**
 *
 * @author Usuario
 */
public class Instructor extends Empleado {

   private int instructor_codigo;
   private String area_trabajo;
   private String descripcion;

    public Instructor(int empleado_codigo, double salario_emp, int horario_codigo, boolean estado) {
        super(empleado_codigo, salario_emp, horario_codigo, estado);
    }

    public Instructor(int empleado_codigo, double salario_emp, int horario_codigo, boolean estado, int cod_persona, String per_cedula, String per_nombre, String per_apellido, Date per_fechaNac, String per_telefono, String per_direccion) {
        super(empleado_codigo, salario_emp, horario_codigo, estado, cod_persona, per_cedula, per_nombre, per_apellido, per_fechaNac, per_telefono, per_direccion);
    }

    public int getInstructor_codigo() {
        return instructor_codigo;
    }

    public void setInstructor_codigo(int instructor_codigo) {
        this.instructor_codigo = instructor_codigo;
    }

    public String getArea_trabajo() {
        return area_trabajo;
    }

    public void setArea_trabajo(String area_trabajo) {
        this.area_trabajo = area_trabajo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    
    
    
    
}

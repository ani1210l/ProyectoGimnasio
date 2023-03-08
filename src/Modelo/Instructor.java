package Modelo;

import java.sql.Date;

/**
 *
 * @author Usuario
 */
public class Instructor extends Empleado {

    int instructor_codigo;
    String area_trabajo;
    String descripcion;

    public Instructor(int instructor_codigo, String area_trabajo, String descripcion, int empleado_codigo, double salario_emp, int horario_codigo, boolean estado, String persona_codigo, String cedula, String nombre, String apellido, Date fechaNacimiento, String telefono, String direccion) {
        super(empleado_codigo, salario_emp, horario_codigo, estado, persona_codigo, cedula, nombre, apellido, fechaNacimiento, telefono, direccion);
        this.instructor_codigo = instructor_codigo;
        this.area_trabajo = area_trabajo;
        this.descripcion = descripcion;
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

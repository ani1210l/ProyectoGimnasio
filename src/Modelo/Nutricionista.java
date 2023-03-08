/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author Usuario
 */
public class Nutricionista extends Empleado{

    int nutricionista_codigo;
    String rutina;

    public Nutricionista(int nutricionista_codigo, String rutina, int empleado_codigo, double salario_emp, int horario_codigo, boolean estado, String persona_codigo, String cedula, String nombre, String apellido, Date fechaNacimiento, String telefono, String direccion) {
        super(empleado_codigo, salario_emp, horario_codigo, estado, persona_codigo, cedula, nombre, apellido, fechaNacimiento, telefono, direccion);
        this.nutricionista_codigo = nutricionista_codigo;
        this.rutina = rutina;
    }

    public int getNutricionista_codigo() {
        return nutricionista_codigo;
    }

    public void setNutricionista_codigo(int nutricionista_codigo) {
        this.nutricionista_codigo = nutricionista_codigo;
    }

    public String getRutina() {
        return rutina;
    }

    public void setRutina(String rutina) {
        this.rutina = rutina;
    }

}

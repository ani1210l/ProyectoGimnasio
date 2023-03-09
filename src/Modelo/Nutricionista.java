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

    private int nutricionista_codigo;
    private String rutina;

    public Nutricionista(int empleado_codigo, double salario_emp, int horario_codigo, boolean estado) {
        super(empleado_codigo, salario_emp, horario_codigo, estado);
    }

    public Nutricionista(int empleado_codigo, double salario_emp, int horario_codigo, boolean estado, int cod_persona, String per_cedula, String per_nombre, String per_apellido, Date per_fechaNac, String per_telefono, String per_direccion) {
        super(empleado_codigo, salario_emp, horario_codigo, estado, cod_persona, per_cedula, per_nombre, per_apellido, per_fechaNac, per_telefono, per_direccion);
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

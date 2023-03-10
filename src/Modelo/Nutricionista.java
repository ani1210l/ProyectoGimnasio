package Modelo;

import java.sql.Date;

/**
 *
 * @author Carla Leon
 */
public class Nutricionista extends Empleado {

    private int nutricionista_codigo;
    private String rutina;

    public Nutricionista() {
    }
    
    

    public Nutricionista(int nutricionista_codigo, String rutina) {
        this.nutricionista_codigo = nutricionista_codigo;
        this.rutina = rutina;
    }

    public Nutricionista(int empleado_codigo, double salario_emp, int horario_codigo, int emp_codper) {
        super(empleado_codigo, salario_emp, horario_codigo, emp_codper);
    }

    public Nutricionista(int empleado_codigo, double salario_emp, int horario_codigo, int emp_codper, int cod_persona, String per_cedula, String per_nombre, String per_apellido, Date per_fechaNac, String per_telefono, String per_direccion) {
        super(empleado_codigo, salario_emp, horario_codigo, emp_codper, cod_persona, per_cedula, per_nombre, per_apellido, per_fechaNac, per_telefono, per_direccion);
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

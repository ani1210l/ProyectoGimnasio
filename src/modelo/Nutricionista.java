package modelo;

import java.util.Date;

public class Nutricionista extends Persona {

    private int nutri_codigo;
    private int nutri_codper;
    private String nutri_rutina;
    private String nutri_horario;
    private String nutri_estado;

    public Nutricionista() {
    }

    public Nutricionista(int nutri_codigo, int nutri_codper, String nutri_rutina, String nutri_horario, String nutri_estado) {
        this.nutri_codigo = nutri_codigo;
        this.nutri_codper = nutri_codper;
        this.nutri_rutina = nutri_rutina;
        this.nutri_horario = nutri_horario;
        this.nutri_estado = nutri_estado;
    }

    public Nutricionista(int nutri_codigo, int nutri_codper, String nutri_rutina, String nutri_horario, String nutri_estado, int per_codigo, String per_cedula, String per_nombre, String per_apellido, Date per_fechaNac, String per_telefono, String per_direccion) {
        super(per_codigo, per_cedula, per_nombre, per_apellido, per_fechaNac, per_telefono, per_direccion);
        this.nutri_codigo = nutri_codigo;
        this.nutri_codper = nutri_codper;
        this.nutri_rutina = nutri_rutina;
        this.nutri_horario = nutri_horario;
        this.nutri_estado = nutri_estado;
    }

    public int getNutri_codigo() {
        return nutri_codigo;
    }

    public void setNutri_codigo(int nutri_codigo) {
        this.nutri_codigo = nutri_codigo;
    }

    public int getNutri_codper() {
        return nutri_codper;
    }

    public void setNutri_codper(int nutri_codper) {
        this.nutri_codper = nutri_codper;
    }

    public String getNutri_rutina() {
        return nutri_rutina;
    }

    public void setNutri_rutina(String nutri_rutina) {
        this.nutri_rutina = nutri_rutina;
    }

    public String getNutri_horario() {
        return nutri_horario;
    }

    public void setNutri_horario(String nutri_horario) {
        this.nutri_horario = nutri_horario;
    }

    public String getNutri_estado() {
        return nutri_estado;
    }

    public void setNutri_estado(String nutri_estado) {
        this.nutri_estado = nutri_estado;
    }

}

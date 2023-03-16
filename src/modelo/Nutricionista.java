package modelo;

import java.util.Date;

public class Nutricionista extends Persona {

    private int nutri_codigo;
    private int nutri_codper;
    private int nutri_aniosExperiencia;
    private String nutri_estado;

    public Nutricionista() {
    }

    public Nutricionista(int nutri_codigo, int nutri_codper, int nutri_aniosExperiencia, String nutri_estado) {
        this.nutri_codigo = nutri_codigo;
        this.nutri_codper = nutri_codper;
        this.nutri_aniosExperiencia = nutri_aniosExperiencia;
        this.nutri_estado = nutri_estado;
    }

    public Nutricionista(int nutri_codigo, int nutri_codper, int nutri_aniosExperiencia, String nutri_estado, int per_codigo, String per_cedula, String per_nombre, String per_apellido, Date per_fechaNac, String per_telefono, String per_direccion) {
        super(per_codigo, per_cedula, per_nombre, per_apellido, per_fechaNac, per_telefono, per_direccion);
        this.nutri_codigo = nutri_codigo;
        this.nutri_codper = nutri_codper;
        this.nutri_aniosExperiencia = nutri_aniosExperiencia;
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

    public int getNutri_aniosExperiencia() {
        return nutri_aniosExperiencia;
    }

    public void setNutri_aniosExperiencia(int nutri_aniosExperiencia) {
        this.nutri_aniosExperiencia = nutri_aniosExperiencia;
    }

    public String getNutri_estado() {
        return nutri_estado;
    }

    public void setNutri_estado(String nutri_estado) {
        this.nutri_estado = nutri_estado;
    }
}

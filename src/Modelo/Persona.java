package Modelo;

import java.sql.Date;

public class Persona {

    private int cod_persona;
    private String per_cedula;
    private String per_nombre;
    private String per_apellido;
    private Date per_fechaNac;
    private String per_telefono;
    private String per_direccion;

    public Persona() {
    }

    public Persona(int cod_persona, String per_cedula, String per_nombre, String per_apellido, Date per_fechaNac, String per_telefono, String per_direccion) {
        this.cod_persona = cod_persona;
        this.per_cedula = per_cedula;
        this.per_nombre = per_nombre;
        this.per_apellido = per_apellido;
        this.per_fechaNac = per_fechaNac;
        this.per_telefono = per_telefono;
        this.per_direccion = per_direccion;
    }

    public int getCod_persona() {
        return cod_persona;
    }

    public void setCod_persona(int cod_persona) {
        this.cod_persona = cod_persona;
    }

    public String getPer_cedula() {
        return per_cedula;
    }

    public void setPer_cedula(String per_cedula) {
        this.per_cedula = per_cedula;
    }

    public String getPer_nombre() {
        return per_nombre;
    }

    public void setPer_nombre(String per_nombre) {
        this.per_nombre = per_nombre;
    }

    public String getPer_apellido() {
        return per_apellido;
    }

    public void setPer_apellido(String per_apellido) {
        this.per_apellido = per_apellido;
    }

    public Date getPer_fechaNac() {
        return per_fechaNac;
    }

    public void setPer_fechaNac(Date per_fechaNac) {
        this.per_fechaNac = per_fechaNac;
    }

    public String getPer_telefono() {
        return per_telefono;
    }

    public void setPer_telefono(String per_telefono) {
        this.per_telefono = per_telefono;
    }

    public String getPer_direccion() {
        return per_direccion;
    }

    public void setPer_direccion(String per_direccion) {
        this.per_direccion = per_direccion;
    }
}

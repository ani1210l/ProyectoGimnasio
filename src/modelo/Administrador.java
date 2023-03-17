/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author holi
 */
public class Administrador extends Persona{
    private int adm_codigo;
    private int adm_codper;
    private String adm_usuario, adm_clave, adm_estado;

    public Administrador() {
    }
    
    public Administrador(int adm_codigo, int adm_codper, String adm_usuario, String adm_clave, String adm_estado) {
        this.adm_codigo = adm_codigo;
        this.adm_codper = adm_codper;
        this.adm_usuario = adm_usuario;
        this.adm_clave = adm_clave;
        this.adm_estado = adm_estado;
    }

    public Administrador(int adm_codigo, int adm_codper, String adm_usuario, String adm_clave, String adm_estado, int per_codigo, String per_cedula, String per_nombre, String per_apellido, Date per_fechaNac, String per_telefono, String per_direccion) {
        super(per_codigo, per_cedula, per_nombre, per_apellido, per_fechaNac, per_telefono, per_direccion);
        this.adm_codigo = adm_codigo;
        this.adm_codper = adm_codper;
        this.adm_usuario = adm_usuario;
        this.adm_clave = adm_clave;
        this.adm_estado = adm_estado;
    }

    public int getAdm_codigo() {
        return adm_codigo;
    }

    public void setAdm_codigo(int adm_codigo) {
        this.adm_codigo = adm_codigo;
    }

    public int getAdm_codper() {
        return adm_codper;
    }

    public void setAdm_codper(int adm_codper) {
        this.adm_codper = adm_codper;
    }

    public String getAdm_usuario() {
        return adm_usuario;
    }

    public void setAdm_usuario(String adm_usuario) {
        this.adm_usuario = adm_usuario;
    }

    public String getAdm_clave() {
        return adm_clave;
    }

    public void setAdm_clave(String adm_clave) {
        this.adm_clave = adm_clave;
    }

    public String getAdm_estado() {
        return adm_estado;
    }

    public void setAdm_estado(String adm_estado) {
        this.adm_estado = adm_estado;
    }

    
}

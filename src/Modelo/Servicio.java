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
public class Servicio {

    int servicio_codigo;
    String hora;
    String detalle;
    boolean estado;
    String nombre;
    Date fechaIngreso;

    public Servicio(int servicio_codigo, String hora, String detalle, boolean estado, String nombre, Date fechaIngreso) {
        this.servicio_codigo = servicio_codigo;
        this.hora = hora;
        this.detalle = detalle;
        this.estado = estado;
        this.nombre = nombre;
        this.fechaIngreso = fechaIngreso;
    }

    public int getServicio_codigo() {
        return servicio_codigo;
    }

    public void setServicio_codigo(int servicio_codigo) {
        this.servicio_codigo = servicio_codigo;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

}

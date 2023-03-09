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

    private int ser_codigo;
    private String ser_hora;
    private String serv_tipo;
    private String serv_detalle;
    private Date serv_fechaIngreso;

    public Servicio() {
    }

    public Servicio(int ser_codigo, String ser_hora, String serv_tipo, String serv_detalle, Date serv_fechaIngreso) {
        this.ser_codigo = ser_codigo;
        this.ser_hora = ser_hora;
        this.serv_tipo = serv_tipo;
        this.serv_detalle = serv_detalle;
        this.serv_fechaIngreso = serv_fechaIngreso;
    }

    public int getSer_codigo() {
        return ser_codigo;
    }

    public void setSer_codigo(int ser_codigo) {
        this.ser_codigo = ser_codigo;
    }

    public String getSer_hora() {
        return ser_hora;
    }

    public void setSer_hora(String ser_hora) {
        this.ser_hora = ser_hora;
    }

    public String getServ_tipo() {
        return serv_tipo;
    }

    public void setServ_tipo(String serv_tipo) {
        this.serv_tipo = serv_tipo;
    }

    public String getServ_detalle() {
        return serv_detalle;
    }

    public void setServ_detalle(String serv_detalle) {
        this.serv_detalle = serv_detalle;
    }

    public Date getServ_fechaIngreso() {
        return serv_fechaIngreso;
    }

    public void setServ_fechaIngreso(Date serv_fechaIngreso) {
        this.serv_fechaIngreso = serv_fechaIngreso;
    }

}

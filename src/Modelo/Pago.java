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
public class Pago {
    
     int pago_codigo;
     String deuda;
     Date fecha;
     int cliente_servicio_codigo;

    public Pago(int pago_codigo, String deuda, Date fecha, int cliente_servicio_codigo) {
        this.pago_codigo = pago_codigo;
        this.deuda = deuda;
        this.fecha = fecha;
        this.cliente_servicio_codigo = cliente_servicio_codigo;
    }

    public int getPago_codigo() {
        return pago_codigo;
    }

    public void setPago_codigo(int pago_codigo) {
        this.pago_codigo = pago_codigo;
    }

    public String getDeuda() {
        return deuda;
    }

    public void setDeuda(String deuda) {
        this.deuda = deuda;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCliente_servicio_codigo() {
        return cliente_servicio_codigo;
    }

    public void setCliente_servicio_codigo(int cliente_servicio_codigo) {
        this.cliente_servicio_codigo = cliente_servicio_codigo;
    }







}


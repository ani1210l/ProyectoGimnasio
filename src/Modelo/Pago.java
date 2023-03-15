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
private int pago_codigo;
    private String deuda,pag_rutina;
    private Date fecha;
   private  int cod_cliente;
    public Pago(int pago_codigo, String deuda, String pag_rutina, Date fecha, int cod_cliente) {
        this.pago_codigo = pago_codigo;
        this.deuda = deuda;
        this.pag_rutina = pag_rutina;
        this.fecha = fecha;
        this.cod_cliente = cod_cliente;
    }
    
     

    public Pago() {
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

    public String getPag_rutina() {
        return pag_rutina;
    }

    public void setPag_rutina(String pag_rutina) {
        this.pag_rutina = pag_rutina;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }


     
}


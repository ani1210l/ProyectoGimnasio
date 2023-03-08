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
public class Levantamiento_Pesas extends Servicio{
    
    private int levantamiento_pesas_codigo;
    private String peso;
    private String tipo_pesas;

    public Levantamiento_Pesas(int levantamiento_pesas_codigo, String peso, String tipo_pesas, int servicio_codigo, String hora, String detalle, boolean estado, String nombre, Date fechaIngreso) {
        super(servicio_codigo, hora, detalle, estado, nombre, fechaIngreso);
        this.levantamiento_pesas_codigo = levantamiento_pesas_codigo;
        this.peso = peso;
        this.tipo_pesas = tipo_pesas;
    }

    public int getLevantamiento_pesas_codigo() {
        return levantamiento_pesas_codigo;
    }

    public void setLevantamiento_pesas_codigo(int levantamiento_pesas_codigo) {
        this.levantamiento_pesas_codigo = levantamiento_pesas_codigo;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getTipo_pesas() {
        return tipo_pesas;
    }

    public void setTipo_pesas(String tipo_pesas) {
        this.tipo_pesas = tipo_pesas;
    }


}

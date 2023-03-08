/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public class Horario {

     int horario_codigo;
     String jornada;
     boolean estado;

    public Horario(int horario_codigo, String jornada, boolean estado) {
        this.horario_codigo = horario_codigo;
        this.jornada = jornada;
        this.estado = estado;
    }

    public int getHorario_codigo() {
        return horario_codigo;
    }

    public void setHorario_codigo(int horario_codigo) {
        this.horario_codigo = horario_codigo;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }


}

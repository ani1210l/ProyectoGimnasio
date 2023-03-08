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
public class Servicio_horario extends Servicio {
     int servicio_horario_codigo;
     boolean estadoS;
     int horario_Codigo;

    public Servicio_horario(int servicio_horario_codigo, boolean estadoS, int horario_Codigo, int servicio_codigo, String hora, String detalle, boolean estado, String nombre, Date fechaIngreso) {
        super(servicio_codigo, hora, detalle, estado, nombre, fechaIngreso);
        this.servicio_horario_codigo = servicio_horario_codigo;
        this.estadoS = estadoS;
        this.horario_Codigo = horario_Codigo;
    }

    public int getServicio_horario_codigo() {
        return servicio_horario_codigo;
    }

    public void setServicio_horario_codigo(int servicio_horario_codigo) {
        this.servicio_horario_codigo = servicio_horario_codigo;
    }

    public boolean isEstadoS() {
        return estadoS;
    }

    public void setEstadoS(boolean estadoS) {
        this.estadoS = estadoS;
    }

    public int getHorario_Codigo() {
        return horario_Codigo;
    }

    public void setHorario_Codigo(int horario_Codigo) {
        this.horario_Codigo = horario_Codigo;
    }

    

}


package Modelo;

import java.sql.Date;


public class Cardio extends Servicio{
     private int cardio_codigo;
      private String tiempo;

    public Cardio(int servicio_codigo, String hora, String detalle, boolean estado, String nombre, Date fechaIngreso) {
        super(servicio_codigo, hora, detalle, estado, nombre, fechaIngreso);
    }
      

    public Cardio(int cardio_codigo, String tiempo, int servicio_codigo, String hora, String detalle, boolean estado, String nombre, Date fechaIngreso) {
        super(servicio_codigo, hora, detalle, estado, nombre, fechaIngreso);
        this.cardio_codigo = cardio_codigo;
        this.tiempo = tiempo;
    }

    public int getCardio_codigo() {
        return cardio_codigo;
    }

    public void setCardio_codigo(int cardio_codigo) {
        this.cardio_codigo = cardio_codigo;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

}

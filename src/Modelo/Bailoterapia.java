package Modelo;

import java.sql.Date;

public class Bailoterapia extends Servicio {

    private int bailoterapia_codigo;
    private String tipo_baile;

    public Bailoterapia(int servicio_codigo, String hora, String detalle, boolean estado, String nombre, Date fechaIngreso) {
        super(servicio_codigo, hora, detalle, estado, nombre, fechaIngreso);
    }

    public Bailoterapia(int bailoterapia_codigo, String tipo_baile, int servicio_codigo, String hora, String detalle, boolean estado, String nombre, Date fechaIngreso) {
        super(servicio_codigo, hora, detalle, estado, nombre, fechaIngreso);
        this.bailoterapia_codigo = bailoterapia_codigo;
        this.tipo_baile = tipo_baile;
    }

    public int getBailoterapia_codigo() {
        return bailoterapia_codigo;
    }

    public void setBailoterapia_codigo(int bailoterapia_codigo) {
        this.bailoterapia_codigo = bailoterapia_codigo;
    }

    public String getTipo_baile() {
        return tipo_baile;
    }

    public void setTipo_baile(String tipo_baile) {
        this.tipo_baile = tipo_baile;
    }

}

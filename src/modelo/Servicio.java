package modelo;

public class Servicio {

    private int ser_codigo;
    private String ser_nombre;
    private double ser_precio;

    public Servicio() {
    }

    public Servicio(int ser_codigo, String ser_nombre, double ser_precio) {
        this.ser_codigo = ser_codigo;
        this.ser_nombre = ser_nombre;
        this.ser_precio = ser_precio;
    }

    public int getSer_codigo() {
        return ser_codigo;
    }

    public void setSer_codigo(int ser_codigo) {
        this.ser_codigo = ser_codigo;
    }

    public String getSer_nombre() {
        return ser_nombre;
    }

    public void setSer_nombre(String ser_nombre) {
        this.ser_nombre = ser_nombre;
    }

    public double getSer_precio() {
        return ser_precio;
    }

    public void setSer_precio(double ser_precio) {
        this.ser_precio = ser_precio;
    }
}

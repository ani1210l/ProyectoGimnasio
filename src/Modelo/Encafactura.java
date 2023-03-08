
package Modelo;


public class Encafactura {
    private int cod_factura;
    private int pago_cod;
    private String fecha;

    public Encafactura() {
    }

    public Encafactura(int cod_factura, int pago_cod, String fecha) {
        this.cod_factura = cod_factura;
        this.pago_cod = pago_cod;
        this.fecha = fecha;
    }

    public int getCod_factura() {
        return cod_factura;
    }

    public void setCod_factura(int cod_factura) {
        this.cod_factura = cod_factura;
    }

    public int getPago_cod() {
        return pago_cod;
    }

    public void setPago_cod(int pago_cod) {
        this.pago_cod = pago_cod;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
}

package Modelo;

public class Detfactura {

    private int cod_det_fac;
    private int cod_factura;
    private int serv_cod;

    public Detfactura() {
    }

    public Detfactura(int cod_det_fac, int cod_factura, int serv_cod) {
        this.cod_det_fac = cod_det_fac;
        this.cod_factura = cod_factura;
        this.serv_cod = serv_cod;
    }

    public int getCod_det_fac() {
        return cod_det_fac;
    }

    public void setCod_det_fac(int cod_det_fac) {
        this.cod_det_fac = cod_det_fac;
    }

    public int getCod_factura() {
        return cod_factura;
    }

    public void setCod_factura(int cod_factura) {
        this.cod_factura = cod_factura;
    }

    public int getServ_cod() {
        return serv_cod;
    }

    public void setServ_cod(int serv_cod) {
        this.serv_cod = serv_cod;
    }

}

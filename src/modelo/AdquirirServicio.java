package modelo;

import java.util.Date;

public class AdquirirServicio {

    private int adq_codigo;
    private int adq_codcli;
    private int adq_codins;
    private int adq_codnut;
    private int adq_codser;
    private Date adq_fechainicio;
    private int adq_mesesins;
    private int adq_mesesnut;
    private int adq_mesesser;
    private double adq_costototal;
    private String adq_estado;

    public AdquirirServicio() {
    }

    public AdquirirServicio(int adq_codigo, int adq_codcli, int adq_codins, int adq_codnut, int adq_codser, Date adq_fechainicio, int adq_mesesins, int adq_mesesnut, int adq_mesesser, double adq_costototal, String adq_estado) {
        this.adq_codigo = adq_codigo;
        this.adq_codcli = adq_codcli;
        this.adq_codins = adq_codins;
        this.adq_codnut = adq_codnut;
        this.adq_codser = adq_codser;
        this.adq_fechainicio = adq_fechainicio;
        this.adq_mesesins = adq_mesesins;
        this.adq_mesesnut = adq_mesesnut;
        this.adq_mesesser = adq_mesesser;
        this.adq_costototal = adq_costototal;
        this.adq_estado = adq_estado;
    }

    public int getAdq_codigo() {
        return adq_codigo;
    }

    public void setAdq_codigo(int adq_codigo) {
        this.adq_codigo = adq_codigo;
    }

    public int getAdq_codcli() {
        return adq_codcli;
    }

    public void setAdq_codcli(int adq_codcli) {
        this.adq_codcli = adq_codcli;
    }

    public int getAdq_codins() {
        return adq_codins;
    }

    public void setAdq_codins(int adq_codins) {
        this.adq_codins = adq_codins;
    }

    public int getAdq_codnut() {
        return adq_codnut;
    }

    public void setAdq_codnut(int adq_codnut) {
        this.adq_codnut = adq_codnut;
    }

    public int getAdq_codser() {
        return adq_codser;
    }

    public void setAdq_codser(int adq_codser) {
        this.adq_codser = adq_codser;
    }

    public Date getAdq_fechainicio() {
        return adq_fechainicio;
    }

    public void setAdq_fechainicio(Date adq_fechainicio) {
        this.adq_fechainicio = adq_fechainicio;
    }

    public int getAdq_mesesins() {
        return adq_mesesins;
    }

    public void setAdq_mesesins(int adq_mesesins) {
        this.adq_mesesins = adq_mesesins;
    }

    public int getAdq_mesesnut() {
        return adq_mesesnut;
    }

    public void setAdq_mesesnut(int adq_mesesnut) {
        this.adq_mesesnut = adq_mesesnut;
    }

    public int getAdq_mesesser() {
        return adq_mesesser;
    }

    public void setAdq_mesesser(int adq_mesesser) {
        this.adq_mesesser = adq_mesesser;
    }

    public double getAdq_costototal() {
        return adq_costototal;
    }

    public void setAdq_costototal(double adq_costototal) {
        this.adq_costototal = adq_costototal;
    }

    public String getAdq_estado() {
        return adq_estado;
    }

    public void setAdq_estado(String adq_estado) {
        this.adq_estado = adq_estado;
    }

}

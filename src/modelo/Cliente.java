package modelo;

import java.sql.Date;

public class Cliente extends Persona {

    private int cliente_codigo;
    private int cliente_codper;
    private String cliente_tipomembresia;
    //private int cliente_cantidadmeses;
    private String cliente_estado;

    public Cliente() {
    }

    public Cliente(int cliente_codigo, int cliente_codper, String cliente_tipomembresia, String cliente_estado, int per_codigo, String per_cedula, String per_nombre, String per_apellido, java.util.Date per_fechaNac, String per_telefono, String per_direccion) {
        super(per_codigo, per_cedula, per_nombre, per_apellido, per_fechaNac, per_telefono, per_direccion);
        this.cliente_codigo = cliente_codigo;
        this.cliente_codper = cliente_codper;
        this.cliente_tipomembresia = cliente_tipomembresia;
        this.cliente_estado = cliente_estado;
    }

    public int getCliente_codigo() {
        return cliente_codigo;
    }

    public void setCliente_codigo(int cliente_codigo) {
        this.cliente_codigo = cliente_codigo;
    }

    public int getCliente_codper() {
        return cliente_codper;
    }

    public void setCliente_codper(int cliente_codper) {
        this.cliente_codper = cliente_codper;
    }

    public String getCliente_tipomembresia() {
        return cliente_tipomembresia;
    }

    public void setCliente_tipomembresia(String cliente_tipomembresia) {
        this.cliente_tipomembresia = cliente_tipomembresia;
    }

    public String getCliente_estado() {
        return cliente_estado;
    }

    public void setCliente_estado(String cliente_estado) {
        this.cliente_estado = cliente_estado;
    }

}
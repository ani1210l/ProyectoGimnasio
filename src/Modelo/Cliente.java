
package Modelo;

import java.sql.Date;

public class Cliente extends Persona {

    private int cliente_codigo;
    private Date fecha_ingreso;
    private boolean estado;

    public Cliente(int cliente_codigo, Date fecha_ingreso, boolean estado) {
        this.cliente_codigo = cliente_codigo;
        this.fecha_ingreso = fecha_ingreso;
        this.estado = estado;
    }

    public Cliente(int cliente_codigo, Date fecha_ingreso, boolean estado, int cod_persona, String per_cedula, String per_nombre, String per_apellido, Date per_fechaNac, String per_telefono, String per_direccion) {
        super(cod_persona, per_cedula, per_nombre, per_apellido, per_fechaNac, per_telefono, per_direccion);
        this.cliente_codigo = cliente_codigo;
        this.fecha_ingreso = fecha_ingreso;
        this.estado = estado;
    }


    

    public int getCliente_codigo() {
        return cliente_codigo;
    }

    public void setCliente_codigo(int cliente_codigo) {
        this.cliente_codigo = cliente_codigo;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}


package Modelo;

import java.sql.Date;

public class Cliente extends Persona {

    private int cliente_codigo;
    private Date fecha_ingreso;
    private boolean estado;

    public Cliente(int cliente_codigo, Date fecha_ingreso, boolean estado, String persona_codigo, String cedula, String nombre, String apellido, Date fechaNacimiento, String telefono, String direccion) {
        super(persona_codigo, cedula, nombre, apellido, fechaNacimiento, telefono, direccion);
        this.cliente_codigo = cliente_codigo;
        this.fecha_ingreso = fecha_ingreso;
        this.estado = estado;
    }

    public Cliente(String persona_codigo, String cedula, String nombre, String apellido, Date fechaNacimiento, String telefono, String direccion) {
        super(persona_codigo, cedula, nombre, apellido, fechaNacimiento, telefono, direccion);
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

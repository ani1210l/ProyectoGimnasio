
package Modelo;

import java.sql.Date;


public class Cliente_servicio extends Cliente {

    private int cliente_servicio_codigo;
    private int servicio_horario_codigo;
    private Date Fecha_ingreso;
    private Date Fecha_fin;
    private boolean Estado;
    private int cliente_Codigo;

    public Cliente_servicio(int cliente_servicio_codigo, int servicio_horario_codigo, Date Fecha_ingreso, Date Fecha_fin, boolean Estado, int cliente_Codigo, int cliente_codigo, Date fecha_ingreso, boolean estado, String persona_codigo, String cedula, String nombre, String apellido, Date fechaNacimiento, String telefono, String direccion) {
        super(cliente_codigo, fecha_ingreso, estado, persona_codigo, cedula, nombre, apellido, fechaNacimiento, telefono, direccion);
        this.cliente_servicio_codigo = cliente_servicio_codigo;
        this.servicio_horario_codigo = servicio_horario_codigo;
        this.Fecha_ingreso = Fecha_ingreso;
        this.Fecha_fin = Fecha_fin;
        this.Estado = Estado;
        this.cliente_Codigo = cliente_Codigo;
    }   
    

    public int getCliente_servicio_codigo() {
        return cliente_servicio_codigo;
    }

    public void setCliente_servicio_codigo(int cliente_servicio_codigo) {
        this.cliente_servicio_codigo = cliente_servicio_codigo;
    }

    public int getServicio_horario_codigo() {
        return servicio_horario_codigo;
    }

    public void setServicio_horario_codigo(int servicio_horario_codigo) {
        this.servicio_horario_codigo = servicio_horario_codigo;
    }

    public Date getFecha_ingreso() {
        return Fecha_ingreso;
    }

    public void setFecha_ingreso(Date Fecha_ingreso) {
        this.Fecha_ingreso = Fecha_ingreso;
    }

    public Date getFecha_fin() {
        return Fecha_fin;
    }

    public void setFecha_fin(Date Fecha_fin) {
        this.Fecha_fin = Fecha_fin;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    public int getCliente_Codigo() {
        return cliente_Codigo;
    }

    public void setCliente_Codigo(int cliente_Codigo) {
        this.cliente_Codigo = cliente_Codigo;
    }

    

   


}

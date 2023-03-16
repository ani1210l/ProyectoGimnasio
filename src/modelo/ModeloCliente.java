package modelo;

import java.sql.Date;

public class ModeloCliente extends Cliente {

    ConexionPG conpg = new ConexionPG();

    public ModeloCliente() {
    }

    public ModeloCliente(int cliente_codigo, int cliente_codper, Date cliente_fechaingreso, Date cliente_fechafin, String cliente_estado) {
        super(cliente_codigo, cliente_codper, cliente_fechaingreso, cliente_fechafin, cliente_estado);
    }

    public ModeloCliente(int cliente_codigo, int cliente_codper, Date cliente_fechaingreso, Date cliente_fechafin, String cliente_estado, int per_codigo, String per_cedula, String per_nombre, String per_apellido, java.util.Date per_fechaNac, String per_telefono, String per_direccion) {
        super(cliente_codigo, cliente_codper, cliente_fechaingreso, cliente_fechafin, cliente_estado, per_codigo, per_cedula, per_nombre, per_apellido, per_fechaNac, per_telefono, per_direccion);
    }

    public boolean crearInstructor() {
        String sql = "INSERT INTO instructor(cliente_codper, cliente_fechaingreso, clientefecha, cliente_estado) VALUES (" + getCliente_codper() + ",'" + getCliente_fechaingreso() + "', '" + getCliente_fechafin() + "', 'A');";

        return conpg.accion(sql);
    }

}

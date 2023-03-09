
package Modelo;

import java.sql.Date;

/**
 *
 * @author Usuario
 */
public class ClienteServicio extends Cliente{

    public ClienteServicio(int cliente_codigo, Date fecha_ingreso, boolean estado) {
        super(cliente_codigo, fecha_ingreso, estado);
    }

    public ClienteServicio(int cliente_codigo, Date fecha_ingreso, boolean estado, int cod_persona, String per_cedula, String per_nombre, String per_apellido, Date per_fechaNac, String per_telefono, String per_direccion) {
        super(cliente_codigo, fecha_ingreso, estado, cod_persona, per_cedula, per_nombre, per_apellido, per_fechaNac, per_telefono, per_direccion);
    }
    
    
}

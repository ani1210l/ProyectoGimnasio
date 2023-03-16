package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class ModeloAdministrador extends Administrador {
    
    ConexionPG conpg = new ConexionPG();

    public ModeloAdministrador() {
    }

    public ModeloAdministrador(int adm_codigo, int adm_codper, String adm_usuario, String adm_clave, String adm_estado) {
        super(adm_codigo, adm_codper, adm_usuario, adm_clave, adm_estado);
    }

    public ModeloAdministrador(int adm_codigo, int adm_codper, String adm_usuario, String adm_clave, String adm_estado, int per_codigo, String per_cedula, String per_nombre, String per_apellido, Date per_fechaNac, String per_telefono, String per_direccion) {
        super(adm_codigo, adm_codper, adm_usuario, adm_clave, adm_estado, per_codigo, per_cedula, per_nombre, per_apellido, per_fechaNac, per_telefono, per_direccion);
    }
    
    public boolean crearAdministrador() {
        String sql = "INSERT INTO administrador(adm_codigo, adm_usuario, adm_clave, adm_estado) VALUES (" + getAdm_codigo() + ",'" + getAdm_usuario() + "', '" + getAdm_clave() + "', 'A');";

        return conpg.accion(sql);
    }

    public boolean modificarAdministrador() {
        String sql = "UPDATE administrador SET adm_clave = '" + getAdm_clave()+ "', adm_usuario = '" + getAdm_usuario() + "' WHERE adm_codigo = " + getAdm_codigo() + ";";

        return conpg.accion(sql);
    }

    public boolean eliminarAdministrador(int codigoAdministrador) {
        String sql = "UPDATE administrador SET adm_estado= 'I' where adm_codigo = " + codigoAdministrador + ";";

        return conpg.accion(sql);
    }

    public List<Administrador> listaAdminTabla() {
        try {
            //Me retorna un "List" de "instructor"
            List<Administrador> lista = new ArrayList<>();

            String sql = "select * from persona p, administrador a where p.per_codigo = a.adm_codper and ins_estado = 'A';";

            ResultSet rs = conpg.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                //Crear la instancia de instructor 
                Administrador administrador = new Administrador();

                //Todo lo que haga en la sentencia define como voy a extraer los datos
                //Informacion de persona
                administrador.setPer_codigo(rs.getInt("per_codigo"));
                administrador.setPer_cedula(rs.getString("per_cedula"));
                administrador.setPer_nombre(rs.getString("per_nombre"));
                administrador.setPer_apellido(rs.getString("per_apellido"));
                administrador.setPer_fechaNac(rs.getDate("per_fechanac"));
                administrador.setPer_telefono(rs.getString("per_telefono"));
                administrador.setPer_direccion(rs.getString("per_direccion"));

                //Informacion de Administrador
                administrador.setAdm_codigo(rs.getInt("adm_codigo"));
                administrador.setAdm_codper(rs.getInt("adm_codper"));
                administrador.setAdm_usuario(rs.getString("adm_usuario"));
                administrador.setAdm_clave(rs.getString("adm_clave"));
                administrador.setAdm_estado(rs.getString("adm_estado"));

                lista.add(administrador); //Agrego los datos a la lista
            }

            //Cierro la conexion a la BD
            rs.close();
            //Retorno la lista
            return lista;

        } catch (SQLException ex) {
            Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}

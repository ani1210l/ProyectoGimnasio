package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModeloServicio extends Servicio {

    ConexionPG conpg = new ConexionPG();

    public ModeloServicio() {
    }

    public ModeloServicio(int ser_codigo, String ser_nombre, double ser_precio) {
        super(ser_codigo, ser_nombre, ser_precio);
    }

    public boolean crearServicio() {
        String sql = "INSERT INTO servicio(ser_nombre, ser_precio, ser_estado) VALUES ('" + getSer_nombre() + "'," + getSer_precio() + ", 'A');";

        return conpg.accion(sql);
    }

    public boolean modificarServicio() {
        String sql = "UPDATE servicio SET ser_nombre = '" + getSer_nombre() + "', ser_precio = '" + getSer_precio() + "' WHERE ser_codigo = " + getSer_codigo() + ";";

        return conpg.accion(sql);
    }

    public boolean eliminarServicio(int codigoServicio) {
        String sql = "UPDATE servicio SET ser_estado= 'I' where ser_codigo = " + codigoServicio + ";";

        return conpg.accion(sql);
    }

    public List<Servicio> listaServiciosTabla() {
        try {
            //Me retorna un "List" de "instructor"
            List<Servicio> lista = new ArrayList<>();

            String sql = "select * from servicio where ser_estado = 'A';";

            ResultSet rs = conpg.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                //Crear la instancia de instructor 
                Servicio servicio = new Servicio();

                //Todo lo que haga en la sentencia define como voy a extraer los datos
                //Informacion de persona
                servicio.setSer_codigo(rs.getInt("ser_codigo"));
                servicio.setSer_nombre(rs.getString("ser_nombre"));
                servicio.setSer_precio(rs.getDouble("ser_precio"));

                lista.add(servicio); //Agrego los datos a la lista
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

package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModeloAdquirirServicio extends AdquirirServicio {

    ConexionPG conpg = new ConexionPG();

    public ModeloAdquirirServicio() {
    }

    public ModeloAdquirirServicio(int adq_codigo, int adq_codcli, int adq_codins, int adq_codnut, int adq_codser, Date adq_fechainicio, int adq_mesesins, int adq_mesesnut, int adq_mesesser, double adq_costototal, String adq_estado) {
        super(adq_codigo, adq_codcli, adq_codins, adq_codnut, adq_codser, adq_fechainicio, adq_mesesins, adq_mesesnut, adq_mesesser, adq_costototal, adq_estado);
    }

    public boolean crearAdquirirServicio() {
        String sql = "INSERT INTO adquirirservicio(adq_codcli, adq_codins, adq_codnut, adq_codser, adq_fechainicio, adq_mesesins, adq_mesesnut, adq_mesesser, adq_costototal, adq_estado) VALUES (" + getAdq_codcli() + "," + getAdq_codins() + ", " + getAdq_codnut() + ", " + getAdq_codser() + ",'" + getAdq_fechainicio() + "'," + getAdq_mesesins() + "," + getAdq_mesesnut() + "," + getAdq_mesesser() + "," + getAdq_costototal() + ",'A');";

        return conpg.accion(sql);
    }

    public boolean modificarAdquirirServicio() {
        String sql = "UPDATE adquirirservicio SET adq_codins = " + getAdq_codins() + ", adq_codnut = " + getAdq_codnut() + ", adq_codser = " + getAdq_codser() + ", adq_fechainicio = '" + getAdq_fechainicio() + "', adq_mesesins =  " + getAdq_mesesins() + ",adq_mesesnut = " + getAdq_mesesnut() + ", adq_mesesser = " + getAdq_mesesser() + ", adq_costototal = " + getAdq_costototal() + " WHERE adq_codigo = " + getAdq_codigo() + ";";

        return conpg.accion(sql);
    }

    public boolean eliminarAdquirirServicio(int codigoAdquirServicio) {
        String sql = "UPDATE adquirirservicio SET adq_estado = 'I' where adq_codigo = " + codigoAdquirServicio + ";";

        return conpg.accion(sql);
    }

    public List<AdquirirServicio> listaAdquirirServicioTabla() {
        try {

            List<AdquirirServicio> lista = new ArrayList<>();

            String sql = "select * from adquirirservicio where adq_estado = 'A';";

            ResultSet rs = conpg.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {

                AdquirirServicio adquirir = new AdquirirServicio();

                adquirir.setAdq_codigo(rs.getInt("adq_codigo"));
                adquirir.setAdq_codcli(rs.getInt("adq_codcli"));
                adquirir.setAdq_codins(rs.getInt("adq_codins"));
                adquirir.setAdq_codnut(rs.getInt("adq_codnut"));
                adquirir.setAdq_codser(rs.getInt("adq_codser"));
                adquirir.setAdq_fechainicio(rs.getDate("adq_fechainicio"));
                adquirir.setAdq_mesesins(rs.getInt("adq_mesesins"));
                adquirir.setAdq_mesesnut(rs.getInt("adq_mesesnut"));
                adquirir.setAdq_mesesser(rs.getInt("adq_mesesser"));
                adquirir.setAdq_costototal(rs.getInt("adq_costototal"));
                adquirir.setAdq_estado(rs.getString("adq_estado"));

                lista.add(adquirir); //Agrego los datos a la lista
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

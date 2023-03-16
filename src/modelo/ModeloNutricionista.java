package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModeloNutricionista extends Nutricionista {

    ConexionPG conpg = new ConexionPG();

    public ModeloNutricionista() {
    }

    public ModeloNutricionista(int nutri_codigo, int nutri_codper, int nutri_aniosExperiencia, String nutri_estado) {
        super(nutri_codigo, nutri_codper, nutri_aniosExperiencia, nutri_estado);
    }

    public ModeloNutricionista(int nutri_codigo, int nutri_codper, int nutri_aniosExperiencia, String nutri_estado, int per_codigo, String per_cedula, String per_nombre, String per_apellido, Date per_fechaNac, String per_telefono, String per_direccion) {
        super(nutri_codigo, nutri_codper, nutri_aniosExperiencia, nutri_estado, per_codigo, per_cedula, per_nombre, per_apellido, per_fechaNac, per_telefono, per_direccion);
    }

    public boolean crearNutricionista() {
        String sql = "INSERT INTO nutricionista(nut_codper, nut_aniosexperiencia, nut_estado)VALUES (" + getNutri_codper() + ", " + getNutri_aniosExperiencia() + ", 'A');";

        return conpg.accion(sql);
    }

    public boolean modificarNutricionista() {
        String sql = "UPDATE nutricionista SET nut_aniosexperiencia = '" + getNutri_aniosExperiencia() + " ' WHERE nut_codigo = " + getNutri_codigo() + ";";
        return conpg.accion(sql);
    }

    public boolean eliminarNutricionista(int codigoNutri) {
        String sql = "UPDATE nutricionista SET nut_estado= 'I' where nut_codigo = " + codigoNutri + ";";

        return conpg.accion(sql);
    }

    public List<Nutricionista> listaNutricionistaTabla() {
        try {
            //Me retorna un "List" de "instructor"
            List<Nutricionista> lista = new ArrayList<>();

            String sql = "select * from persona p, nutricionista n where p.per_codigo = n.nut_codper and nut_estado = 'A';";

            ResultSet rs = conpg.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                //Crear la instancia de instructor 
                Nutricionista nutricionista = new Nutricionista();

                //Todo lo que haga en la sentencia define como voy a extraer los datos
                //Informacion de persona
                nutricionista.setPer_codigo(rs.getInt("per_codigo"));
                nutricionista.setPer_cedula(rs.getString("per_cedula"));
                nutricionista.setPer_nombre(rs.getString("per_nombre"));
                nutricionista.setPer_apellido(rs.getString("per_apellido"));
                nutricionista.setPer_fechaNac(rs.getDate("per_fechanac"));
                nutricionista.setPer_telefono(rs.getString("per_telefono"));
                nutricionista.setPer_direccion(rs.getString("per_direccion"));

                //Informacion de nutricionsita
                nutricionista.setNutri_codigo(rs.getInt("nut_codigo"));
                nutricionista.setNutri_codper(rs.getInt("nut_codper"));
                nutricionista.setNutri_aniosExperiencia(rs.getInt("nut_aniosExperiencia"));
                nutricionista.setNutri_estado(rs.getString("nut_estado"));

                lista.add(nutricionista);
            }
            rs.close();
            return lista;

        } catch (SQLException ex) {
            Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
}

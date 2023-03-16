package modelo;

import java.util.Date;

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
}

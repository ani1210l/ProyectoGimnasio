package modelo;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModeloCliente extends Cliente {

    ConexionPG conpg = new ConexionPG();

    public ModeloCliente() {
    }

    public ModeloCliente(int cliente_codigo, int cliente_codper, String cliente_tipomembresia, String cliente_estado, int per_codigo, String per_cedula, String per_nombre, String per_apellido, java.util.Date per_fechaNac, String per_telefono, String per_direccion) {
        super(cliente_codigo, cliente_codper, cliente_tipomembresia, cliente_estado, per_codigo, per_cedula, per_nombre, per_apellido, per_fechaNac, per_telefono, per_direccion);
    }

  

   


    public boolean crearCliente() {
        String sql = "INSERT INTO cliente(cli_codper, cli_tipodemembresia, cli_estado) VALUES (" + getCliente_codper()+ ",'" + getCliente_tipomembresia()+ "', 'A');";

        return conpg.accion(sql);
    }
     public boolean modificarInstructor() {
        String sql = "UPDATE cliente SET cli_tipodemembresia = '" + getCliente_tipomembresia() + "' WHERE cli_codigo = " + getCliente_codigo() + ";";

        return conpg.accion(sql);
    }

    public boolean eliminarCliente(int cliente_codigo) {
        String sql = "UPDATE cliente SET cli_estado= 'I' where cli_codigo = " + cliente_codigo + ";";

        return conpg.accion(sql);
    }

    public List<Cliente> listaClientesTabla() {
        try {
            //Me retorna un "List" de "instructor"
            List<Cliente> lista = new ArrayList<>();

            String sql = "select * from persona p, cliente c where p.per_codigo = c.cli_codper;";

            ResultSet rs = conpg.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                //Crear la instancia de instructor 
                Cliente cliente = new Cliente();

                //Todo lo que haga en la sentencia define como voy a extraer los datos
                //Informacion de persona
                cliente.setPer_codigo(rs.getInt("per_codigo"));
                cliente.setPer_cedula(rs.getString("per_cedula"));
                cliente.setPer_nombre(rs.getString("per_nombre"));
                cliente.setPer_apellido(rs.getString("per_apellido"));
                cliente.setPer_fechaNac(rs.getDate("per_fechanac"));
                cliente.setPer_telefono(rs.getString("per_telefono"));
                cliente.setPer_direccion(rs.getString("per_direccion"));

                //Informacion de instructor
                cliente.setCliente_codigo(rs.getInt("cli_codigo"));
                cliente.setCliente_codper(rs.getInt("cli_codper"));
                cliente.setCliente_tipomembresia(rs.getString("cli_tipodemembresia"));
                //cliente.setCliente_cantidadmeses(rs.getInt("cli_cantidadmeses"));
                cliente.setCliente_estado(rs.getString("cli_estado"));

                lista.add(cliente); //Agrego los datos a la lista
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
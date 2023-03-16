package controlador;

import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.Instructor;
import modelo.ModeloCliente;
import modelo.ModeloPersona;
import vista.VistaCliente;

public class ControladorCliente {

    ModeloCliente modelo;
    VistaCliente vista;

    public ControladorCliente(ModeloCliente modelo, VistaCliente vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
    }

    public void iniciarControl() {
        vista.getBtnCrear().addActionListener(l -> abrirjDlgCliente());
        vista.getBtnGuardar().addActionListener(l -> crearModificarCliente());
    }

    public void abrirjDlgCliente() {

        vista.getjDlgCliente().setVisible(true);
        vista.getjDlgCliente().setSize(809, 460);
        vista.getjDlgCliente().setLocationRelativeTo(null);
        vista.getjDlgCliente().setName("Crear nuevo Cliente");
        vista.getjDlgCliente().setTitle("Crear nuevo Cliente");

    }
    public void cargarTablaDeCliente() {
        DefaultTableModel tabla = (DefaultTableModel) vista.getTblCliente().getModel();
        tabla.setNumRows(0);

        List<Cliente> instructores = modelo.listaClientesTabla();
        instructores.stream().forEach(i -> {
            String[] datos = {String.valueOf(i.getCliente_codigo()),i.getPer_cedula(),i.getPer_nombre(),i.getPer_apellido(),i.getPer_telefono(),i.getPer_telefono(),(String.valueOf(i.getCliente_tipomembresia()))};
            tabla.addRow(datos);
        });
    }

      public void crearModificarCliente() {

        if ("Crear nuevo Cliente".equals(vista.getjDlgCliente().getName())) {

            //Validar datos
            ModeloPersona persona = new ModeloPersona();
            if (persona.validarRepetidos(vista.getTxtCedula().getText()) == 0) {

                //Setear datos de persona
                persona.setPer_cedula(vista.getTxtCedula().getText());
                persona.setPer_nombre(vista.getTxtNombre().getText());
                persona.setPer_apellido(vista.getTxtApellido().getText());
                persona.setPer_telefono(vista.getTxtTelefono().getText());
                persona.setPer_direccion(vista.getTxtDireccion().getText());

                Date fecha = vista.getFechaDeNacimiento().getDate();
                java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
                persona.setPer_fechaNac(fechaSQL);
                

                //Setear datos de cliente
                modelo.setCliente_tipomembresia(vista.getComboMembresia().getSelectedItem().toString());
                }

                if (persona.crearPersona()) {
                    //Guarda el codigo de la persona
                    System.out.println("Persona");
                    modelo.setCliente_codper(persona.traerCodigoDePersonaCreada());
                    if (modelo.crearCliente()) {
                        JOptionPane.showMessageDialog(null, "Se creo exitosamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo registrar");
                    }
                } else {
                    System.out.println("Error");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El numero de cedula ya se encuentra registrado en la base de datos");
            }
        }
}
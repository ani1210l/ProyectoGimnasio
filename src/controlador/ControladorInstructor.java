package controlador;

import java.util.Date;
import javax.swing.JOptionPane;
import modelo.ModeloInstructor;
import modelo.ModeloPersona;
import vista.VistaInstructor;
import vista.VistaPrincipal;

public class ControladorInstructor {

    ModeloInstructor modelo;
    VistaInstructor vista;

    VistaPrincipal p = new VistaPrincipal();

    public ControladorInstructor(ModeloInstructor modelo, VistaInstructor vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
    }

    public void iniciarControl() {
        vista.getBtnCrear().addActionListener(l -> abrirjDlgInstructor());
        vista.getBtnGuardar().addActionListener(l -> crearModificarInstructor());
    }

    public void abrirjDlgInstructor() {

        vista.getjDlgInstructor().setVisible(true);
        vista.getjDlgInstructor().setSize(809, 460);
        vista.getjDlgInstructor().setLocationRelativeTo(null);
        vista.getjDlgInstructor().setName("Crear nuevo instructor");
        vista.getjDlgInstructor().setTitle("Crear nuevo instructor");

    }

    public void crearModificarInstructor() {

        if ("Crear nuevo instructor".equals(vista.getjDlgInstructor().getName())) {

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

                //Setear datos de instructor
                modelo.setIns_areatrabajo(vista.getTxtAreaTrabajo().getText());

                String horario = "";
                if (vista.getMatutino().isSelected()) {
                    horario = "Matutino";
                } else {
                    if (vista.getVespertino().isSelected()) {
                        horario = "Vespertino";
                    } else {
                        if (vista.getNocturno().isSelected()) {
                            horario = "Nocturno";
                        }
                    }
                }

                modelo.setIns_horario(horario);

                if (persona.crearPersona()) {
                    //Guarda el codigo de la persona
                    System.out.println("Persona");
                    modelo.setIns_codper(persona.traerCodigoDePersonaCreada());
                    if (modelo.crearInstructor()) {
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
}

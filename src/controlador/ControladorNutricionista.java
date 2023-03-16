package controlador;

import java.util.Date;
import javax.swing.JOptionPane;
import modelo.ModeloNutricionista;
import modelo.ModeloPersona;
import vista.VistaNutricionista;
import vista.VistaPrincipal;

public class ControladorNutricionista {

    ModeloNutricionista modelo;
    VistaNutricionista vista;

    VistaPrincipal p = new VistaPrincipal();

    public ControladorNutricionista(ModeloNutricionista modelo, VistaNutricionista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciarControl() {
        vista.getBtnCrearNUTRI().addActionListener(l -> abrirJDlgNutricionista());
        vista.getBtnGuardar().addActionListener(l -> crearModificarNutricionista());

    }

    public void abrirJDlgNutricionista() {
        vista.getjDialogNutricionista().setVisible(true);
        vista.getjDialogNutricionista().setSize(809, 460);
        vista.getjDialogNutricionista().setLocationRelativeTo(null);
        vista.getjDialogNutricionista().setName("Crear nuevo nutricionista");
        vista.getjDialogNutricionista().setTitle("Crear nuevo nutricionista");
    }

    public void crearModificarNutricionista() {

        if ("Crear nuevo instructor".equals(vista.getjDialogNutricionista().getName())) {

            //Validar datos
            ModeloPersona persona = new ModeloPersona();
            if (persona.validarRepetidos(vista.getTxtCedulanutri().getText()) == 0) {

                //Setear datos de persona
                persona.setPer_cedula(vista.getTxtCedulanutri().getText());
                persona.setPer_nombre(vista.getTxtNombrenutri().getText());
                persona.setPer_apellido(vista.getTxtApellidonutri().getText());
                persona.setPer_telefono(vista.getTxtTelefononutri().getText());
                persona.setPer_direccion(vista.getTxtDireccionnutri().getText());

                Date fecha = vista.getFechaDeNacimientonutri().getDate();
                java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
                persona.setPer_fechaNac(fechaSQL);

                //Setear datos de instructor
                modelo.setNutri_rutina(vista.getTxtRutina().getText());

                String horario = "";
                if (vista.getMatutino().isSelected()) {
                    horario = "Matutino";
                } else {
                    if (vista.getVespertino().isSelected()) {
                        horario = "Vespertino";

                    }
                }

                modelo.setNutri_horario(horario);

                if (persona.crearPersona()) {
                    //Guarda el codigo de la persona
                    System.out.println("Persona");
                    modelo.setNutri_codper(persona.traerCodigoDePersonaCreada());
                    if (modelo.crearNutricionista()) {
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

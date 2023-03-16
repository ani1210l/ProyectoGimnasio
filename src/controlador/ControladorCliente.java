package controlador;

import java.util.Date;
import javax.swing.JOptionPane;
import modelo.ModeloCliente;
import modelo.ModeloPersona;
import vista.VistaCliente;

import vista.VistaPrincipal;

public class ControladorCliente {

    ModeloCliente modelo;
    VistaCliente vista;

    VistaPrincipal p = new VistaPrincipal();

    public ControladorCliente(ModeloCliente modelo, VistaCliente vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciarControl() {
        vista.getBtnCrearcliente().addActionListener(l -> abrirjDlgCliente());
       // vista.getBtnGuardarcliente().addActionListener(l -> crearModificarCliente());
    }

    public void abrirjDlgCliente() {

        vista.getjDialogCliente().setVisible(true);
        vista.getjDialogCliente().setSize(809, 460);
        vista.getjDialogCliente().setLocationRelativeTo(null);
        vista.getjDialogCliente().setName("Crear nuevo Cliente");
        vista.getjDialogCliente().setTitle("Crear nuevo Cliente");

    }

  /*  public void crearModificarCliente() {

        if ("Crear nuevo Cliente".equals(vista.getjDialogCliente().getName())) {

            //Validar datos
            ModeloPersona persona = new ModeloPersona();
            if (persona.validarRepetidos(vista.getTblCliente().getText()) == 0) {

                //Setear datos de persona
                persona.setPer_cedula(vista.getTxtCedulacliente().getText());
                persona.setPer_nombre(vista.getTxtNombrecli().getText());
                persona.setPer_apellido(vista.getTxtApellidocli().getText());
                persona.setPer_telefono(vista.getTxtTelefonoclie().getText());
                persona.setPer_direccion(vista.getTxtDireccionclie().getText());

                Date fecha = vista.getFechaDeNacimientoclie().getDate();
                java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
                persona.setPer_fechaNac(fechaSQL);
                

                //Setear datos de instructor
              
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
        }*/
    }



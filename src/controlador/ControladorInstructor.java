package controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.Instructor;
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
        vista.setSize(p.getEscritorioPrincipal().getWidth(), p.getEscritorioPrincipal().getHeight());
        cargarTablaDeInstructores();
    }

    public void iniciarControl() {
        vista.getBtnCrear().addActionListener(l -> abrirjDlgInstructor());
        vista.getBtnGuardar().addActionListener(l -> crearModificarInstructor());
        vista.getBtnActualizar().addActionListener(l -> cargarTablaDeInstructores());
        vista.getBtnModificar().addActionListener(l -> cargarDatosInstructoresEnTXT());
        vista.getBtnEliminar().addActionListener(l -> eliminarInstructor());
        buscarRegistros();
    }

    public void abrirjDlgInstructor() {

        vista.getjDlgInstructor().setVisible(true);
        vista.getjDlgInstructor().setSize(889, 495);
        vista.getjDlgInstructor().setLocationRelativeTo(null);
        vista.getjDlgInstructor().setName("Crear nuevo instructor");
        vista.getjDlgInstructor().setTitle("Crear nuevo instructor");

        //Quitar visibilidad del codigo del instructor
        vista.getTxtCodigoInstructor().setVisible(false);

    }

    public void cargarTablaDeInstructores() {
        DefaultTableModel tabla = (DefaultTableModel) vista.getTblInstructor().getModel();
        tabla.setNumRows(0);

        List<Instructor> instructores = modelo.listaInstructoresTabla();
        instructores.stream().forEach(i -> {
            String[] datos = {String.valueOf(i.getIns_codigo()), i.getPer_cedula(), i.getPer_nombre(), i.getPer_apellido(), i.getIns_areatrabajo(), i.getIns_horario()};
            tabla.addRow(datos);
        });
    }

    public void crearModificarInstructor() {

        if ("Crear nuevo instructor".equals(vista.getjDlgInstructor().getName())) {

            //VALIDAR DATOS
            //Creo un objeto del modelo persona para llamar a sus metodos
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
                    modelo.setIns_codper(persona.traerCodigoDePersonaCreada());
                    if (modelo.crearInstructor()) {
                        JOptionPane.showMessageDialog(null, "Instructor creado satisfactoriamente");
                        vista.getjDlgInstructor().setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo registrar la informacioón");
                        persona.eliminarPersonaNoCreada(vista.getTxtCedula().getText());
                    }
                } else {
                    System.out.println("Error: No se registrar la persona");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El numero de cedula ya se encuentra registrado en la base de datos");
            }
        } else {
            //VALIDAR DATOS
            //Creo un objeto del modelo persona para llamar a sus metodos
            ModeloPersona persona = new ModeloPersona();

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

            if (persona.modificarPersona()) {
                //Seteo el codigo del instructor tomado del txt
                System.out.println("Persona modificada");
                modelo.setIns_codigo(Integer.parseInt(vista.getTxtCodigoInstructor().getText()));

                if (modelo.modificarInstructor()) {
                    JOptionPane.showMessageDialog(null, "La información se modificó satisfactoriamente");
                    vista.getjDlgInstructor().setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo modificar la información");
                }
            } else {
                System.out.println("Error modificando persona");
            }
        }

        cargarTablaDeInstructores();
    }

    public void cargarDatosInstructoresEnTXT() {
        int fila = vista.getTblInstructor().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {

            //Abrir jDialog de campos de Docente
            vista.getjDlgInstructor().setVisible(true);
            vista.getjDlgInstructor().setName("Modificar instructor");
            vista.getjDlgInstructor().setSize(889, 495);
            vista.getjDlgInstructor().setLocationRelativeTo(null);
            vista.getjDlgInstructor().setTitle("Modificar instructor");

            //Quitar visibilidad
            vista.getTxtCodigoInstructor().setVisible(false);

            //ModeloPersona modeloPersona = new ModeloPersona();
            List<Instructor> listai = modelo.listaInstructoresTabla();

            listai.stream().forEach(instructor -> {

                if (instructor.getPer_cedula().equals(vista.getTblInstructor().getValueAt(fila, 1).toString())) {
                    //Cargar datos de persona

                    vista.getTxtCedula().setText(instructor.getPer_cedula());
                    vista.getTxtNombre().setText(instructor.getPer_nombre());
                    vista.getTxtApellido().setText(instructor.getPer_apellido());
                    vista.getFechaDeNacimiento().setDate(instructor.getPer_fechaNac());
                    vista.getTxtTelefono().setText(instructor.getPer_telefono());
                    vista.getTxtDireccion().setText(instructor.getPer_direccion());

                    //Cargar datos de instructor
                    vista.getTxtCodigoInstructor().setText(String.valueOf(instructor.getIns_codigo()));
                    vista.getTxtAreaTrabajo().setText(instructor.getIns_areatrabajo());

                    if (instructor.getIns_horario().equals("Matutino")) {
                        vista.getMatutino().setSelected(true);
                    } else {
                        if (instructor.getIns_horario().equals("Vespertino")) {
                            vista.getVespertino().setSelected(true);

                        } else {
                            if (instructor.getIns_horario().equals("Nocturno")) {
                                vista.getNocturno().setSelected(true);
                            }
                        }
                    }

                }
            });
        }
    }

    public void eliminarInstructor() {

        int fila = vista.getTblInstructor().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {

            int response = JOptionPane.showConfirmDialog(vista, "¿Seguro que desea eliminar esta información?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {

                int codigoInstructor;
                codigoInstructor = Integer.parseInt(vista.getTblInstructor().getValueAt(fila, 0).toString());

                if (modelo.eliminarInstructor(codigoInstructor)) {
                    JOptionPane.showMessageDialog(null, "El registro se elimino satisfactoriamente");
                    cargarTablaDeInstructores();//Actualizo la tabla con los datos
                } else {
                    JOptionPane.showMessageDialog(null, "El registro no se pudo eliminar");
                }
            }
        }
    }

    //El buscar funciona directamente con la tabla no con la BD
    public void buscarRegistros() {

        KeyListener eventoTeclado = new KeyListener() {//Crear un objeto de tipo keyListener(Es una interface) por lo tanto se debe implementar sus metodos abstractos

            @Override
            public void keyTyped(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {

                //CODIGO PARA FILTRAR LOS DATOS DIRECTAMENTE DE LA TABLA. NO ELIMINAR. SI FUNCIONA. ES MUY IMPORTANTE
                TableRowSorter<DefaultTableModel> filtrar;

                DefaultTableModel tabla = (DefaultTableModel) vista.getTblInstructor().getModel();

                //vista.getTablaconduccion().setAutoCreateRowSorter(true);
                filtrar = new TableRowSorter<>(tabla);
                vista.getTblInstructor().setRowSorter(filtrar);

                try {

                    filtrar.setRowFilter(RowFilter.regexFilter(vista.getTxtBuscar().getText())); //Se pasa como parametro el campo de donde se va a obtener la informacion y el (3) es la columna con la cual va a buscar las coincidencias
                } catch (Exception ex) {
                    System.out.println("Error: " + ex);
                }
            }
        };

        vista.getTxtBuscar().addKeyListener(eventoTeclado); //"addKeyListener" es un metodo que se le tiene que pasar como argumento un objeto de tipo keyListener 
    }
}

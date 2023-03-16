package controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.ModeloNutricionista;
import modelo.ModeloPersona;
import modelo.Nutricionista;
import vista.VistaNutricionista;

public class ControladorNutricionista {

    ModeloNutricionista modelo;
    VistaNutricionista vista;

    public ControladorNutricionista(ModeloNutricionista modelo, VistaNutricionista vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
    }

    public void iniciarControl() {
        vista.getBtnCrear().addActionListener(l -> abrirJDlgNutricionista());
        vista.getBtnGuardar().addActionListener(l -> crearModificarNutricionista());
        vista.getBtnActualizar().addActionListener(l -> cargarTablaDeNutricionista());
        vista.getBtnModificar().addActionListener(l -> cargarDatosNutricionistaEnTXT());
        vista.getBtnEliminar().addActionListener(l -> eliminarNutricionista());
        vista.getBtnCancelar().addActionListener(l -> cancelar());

        buscarRegistros();
        cargarTablaDeNutricionista();
    }

    public void abrirJDlgNutricionista() {
        vista.getjDlgNutricionista().setVisible(true);
        vista.getjDlgNutricionista().setSize(819, 470);
        vista.getjDlgNutricionista().setLocationRelativeTo(null);
        vista.getjDlgNutricionista().setName("Crear nuevo nutricionista");
        vista.getjDlgNutricionista().setTitle("Crear nuevo nutricionista");
        cargarTablaDeNutricionista();
        //QUITAR VISIBILIDAD DEL CODIGO DEL INSTRUCTOR
        vista.getTxtCodigoNutricionista().setVisible(false);
    }

    public void cargarTablaNutricionistas() {
        DefaultTableModel tabla = (DefaultTableModel) vista.getTblNutricionista().getModel();
        tabla.setNumRows(0);

        List<Nutricionista> nutricionista = modelo.listaNutricionistaTabla();
        nutricionista.stream().forEach(n -> {
            String[] datos = {String.valueOf(n.getNutri_codigo()), n.getPer_cedula(), n.getPer_nombre(), n.getPer_apellido(), String.valueOf(n.getNutri_aniosExperiencia())};
            tabla.addRow(datos);
        });
    }

    public void crearModificarNutricionista() {

        if ("Crear nuevo nutricionista".equals(vista.getjDlgNutricionista().getName())) {

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

                //Setear datos de nutricionista
                modelo.setNutri_aniosExperiencia(Integer.parseInt(vista.getSpinnerAniosExperiencia().getValue().toString()));

                if (persona.crearPersona()) {
                    //Guarda el codigo de la persona
                    System.out.println("Persona");
                    modelo.setNutri_codper(persona.traerCodigoDePersonaCreada());
                    if (modelo.crearNutricionista()) {
                        JOptionPane.showMessageDialog(null, "Se creo exitosamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo registrar");
                        persona.eliminarPersonaNoCreada(vista.getTxtCedula().getText());
                    }
                } else {
                    System.out.println("Error");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El numero de cedula ya se encuentra registrado en la base de datos");
            }
        } else {
            ///Validar Datos
            // Crear un objeto del nmodelo persona para llamar a sus metods
            ModeloPersona persona = new ModeloPersona();

            persona.setPer_cedula(vista.getTxtCedula().getText());
            persona.setPer_nombre(vista.getTxtNombre().getText());
            persona.setPer_apellido(vista.getTxtApellido().getText());
            persona.setPer_telefono(vista.getTxtTelefono().getText());
            persona.setPer_direccion(vista.getTxtDireccion().getText());

            Date fecha = vista.getFechaDeNacimiento().getDate();
            java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
            persona.setPer_fechaNac(fechaSQL);

            //Setear datos de nutricionista
            modelo.setNutri_aniosExperiencia(Integer.parseInt(vista.getSpinnerAniosExperiencia().getValue().toString()));

            // Setear datos de instructor
            modelo.setNutri_aniosExperiencia(Integer.parseInt(vista.getSpinnerAniosExperiencia().getValue().toString()));

            modelo.setNutri_codper(persona.traerCodigoDePersonaCreada());

            if (persona.modificarPersona()) {
                //Seteo el codigo del instructor tomado del txt
                System.out.println("Persona modificada");
                modelo.setNutri_codigo(Integer.parseInt(vista.getTxtCodigoNutricionista().getText()));

                if (modelo.modificarNutricionista()) {
                    JOptionPane.showMessageDialog(null, "La información se modificó satisfactoriamente");
                    vista.getjDlgNutricionista().setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo modificar la información");
                }
            } else {
                System.out.println("Error modificando persona");
            }
        }
        cargarTablaNutricionistas();
    }

    public void cargarDatosNutricionistaEnTXT() {
        int fila = vista.getTblNutricionista().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {

            //Abrir jDialog de campos de Docente
            vista.getjDlgNutricionista().setVisible(true);
            vista.getjDlgNutricionista().setName("Modificar nutricionista");
            vista.getjDlgNutricionista().setSize(819, 470);
            vista.getjDlgNutricionista().setLocationRelativeTo(null);
            vista.getjDlgNutricionista().setTitle("Modificar nutricionista");

            //Quitar visibilidad
            vista.getTxtCodigoNutricionista().setVisible(false);

///ModeloPersona modelo persona = new ModeloPersona();
            List<Nutricionista> listan = modelo.listaNutricionistaTabla();

            listan.stream().forEach(nutricionista -> {

                if (nutricionista.getPer_cedula().equals(vista.getTblNutricionista().getValueAt(fila, 1).toString())) {
                    //Cargar datos de persona

                    vista.getTxtCedula().setText(nutricionista.getPer_cedula());
                    vista.getTxtNombre().setText(nutricionista.getPer_nombre());
                    vista.getTxtApellido().setText(nutricionista.getPer_apellido());
                    vista.getFechaDeNacimiento().setDate(nutricionista.getPer_fechaNac());
                    vista.getTxtTelefono().setText(nutricionista.getPer_telefono());
                    vista.getTxtDireccion().setText(nutricionista.getPer_direccion());

                    //Cargar datos de instructor
                    vista.getTxtCodigoNutricionista().setText(String.valueOf(nutricionista.getNutri_codigo()));
                    vista.getSpinnerAniosExperiencia().setValue(nutricionista.getNutri_aniosExperiencia());
                    bloquearcampos();
                }
            });
        }
    }

    public void eliminarNutricionista() {
        int fila = vista.getTblNutricionista().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {

            int response = JOptionPane.showConfirmDialog(vista, "¿Seguro que desea eliminar esta información?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {

                int codigoInstructor;
                codigoInstructor = Integer.parseInt(vista.getTblNutricionista().getValueAt(fila, 0).toString());

                if (modelo.eliminarNutricionista(codigoInstructor)) {
                    JOptionPane.showMessageDialog(null, "El registro se elimino satisfactoriamente");
                    cargarTablaDeNutricionista();//Actualizo la tabla con los datos
                } else {
                    JOptionPane.showMessageDialog(null, "El registro no se pudo eliminar");
                }
            }
        }
    }

    public void cargarTablaDeNutricionista() {
        DefaultTableModel tabla = (DefaultTableModel) vista.getTblNutricionista().getModel();
        tabla.setNumRows(0);

        List<Nutricionista> nutricionistas = modelo.listaNutricionistaTabla();
        nutricionistas.stream().forEach(n -> {
            String[] datos = {String.valueOf(n.getNutri_codigo()), n.getPer_cedula(), n.getPer_nombre(), n.getPer_apellido(), String.valueOf(n.getNutri_aniosExperiencia())};
            tabla.addRow(datos);
        });
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

                DefaultTableModel tabla = (DefaultTableModel) vista.getTblNutricionista().getModel();

                //vista.getTablaconduccion().setAutoCreateRowSorter(true);
                filtrar = new TableRowSorter<>(tabla);
                vista.getTblNutricionista().setRowSorter(filtrar);

                try {

                    filtrar.setRowFilter(RowFilter.regexFilter(vista.getTxtBuscar().getText())); //Se pasa como parametro el campo de donde se va a obtener la informacion y el (3) es la columna con la cual va a buscar las coincidencias
                } catch (Exception ex) {
                    System.out.println("Error: " + ex);
                }
            }
        };

        vista.getTxtBuscar().addKeyListener(eventoTeclado); //"addKeyListener" es un metodo que se le tiene que pasar como argumento un objeto de tipo keyListener 
    }

    public void bloquearcampos() {
        vista.getTxtCedula().setEditable(false);
    }

    public void cancelar() {
        vista.getjDlgNutricionista().setVisible(false);
    }
}

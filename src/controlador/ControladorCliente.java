package controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.Cliente;
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
        vista.getBtnActualizar().addActionListener(l -> cargarTablaDeCliente());
        vista.getBtnModificar().addActionListener(l -> cargarDatosClienteEnTXT());
        vista.getBtnEliminar().addActionListener(l -> eliminarCliente());
        vista.getBtnCancelar().addActionListener(l -> Cancelar());
        buscarRegistros();
        cargarTablaDeCliente();
    }

    public void abrirjDlgCliente() {

        vista.getjDlgCliente().setVisible(true);
        vista.getjDlgCliente().setSize(914, 516);
        vista.getjDlgCliente().setLocationRelativeTo(null);
        vista.getjDlgCliente().setName("Crear nuevo Cliente");
        vista.getjDlgCliente().setTitle("Crear nuevo Cliente");
        desbloquearCampos();
        limpiarCampos();
    }

    public void bloquearCampos() {
        vista.getTxtCedula().setEditable(false);
        vista.getTxtCodigoCliente().setVisible(false);
    }

    public void desbloquearCampos() {
        vista.getTxtCedula().setEditable(true);
        vista.getTxtCodigoCliente().setVisible(false);
    }

    public void cargarTablaDeCliente() {
        DefaultTableModel tabla = (DefaultTableModel) vista.getTblCliente().getModel();
        tabla.setNumRows(0);

        List<Cliente> instructores = modelo.listaClientesTabla();
        instructores.stream().forEach(i -> {
            String[] datos = {String.valueOf(i.getCliente_codigo()), i.getPer_cedula(), i.getPer_nombre(), i.getPer_apellido(), i.getPer_telefono(), i.getCliente_tipomembresia(), (String.valueOf(i.getCliente_tipomembresia()))};
            tabla.addRow(datos);
        });
    }

    public void crearModificarCliente() {

        if ("Crear nuevo Cliente".equals(vista.getjDlgCliente().getName())) {

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

                //Setear datos de cliente
                modelo.setCliente_tipomembresia(vista.getComboMembresia().getSelectedItem().toString());

                if (persona.crearPersona()) {
                    //Guarda el codigo de la persona
                    modelo.setCliente_codper(persona.traerCodigoDePersonaCreada());
                    if (modelo.crearCliente()) {
                        JOptionPane.showMessageDialog(null, "Cliente creado satisfactoriamente");
                        vista.getjDlgCliente().setVisible(false);
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
            modelo.setCliente_tipomembresia(vista.getComboMembresia().getSelectedItem().toString());

            if (persona.modificarPersona()) {
                //Seteo el codigo del instructor tomado del txt
                System.out.println("Persona modificada");
                modelo.setCliente_codigo(Integer.parseInt(vista.getTxtCodigoCliente().getText()));

                if (modelo.modificarCliente()) {
                    JOptionPane.showMessageDialog(null, "La información se modificó satisfactoriamente");
                    vista.getjDlgCliente().setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo modificar la información");
                }
            } else {
                System.out.println("Error modificando persona");
            }
        }

        cargarTablaDeCliente();
    }

    public void cargarDatosClienteEnTXT() {
        int fila = vista.getTblCliente().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {

            //Abrir jDialog de campos de Docente
            vista.getjDlgCliente().setVisible(true);
            vista.getjDlgCliente().setName("Modificar Cliente");
            vista.getjDlgCliente().setSize(889, 495);
            vista.getjDlgCliente().setLocationRelativeTo(null);
            vista.getjDlgCliente().setTitle("Modificar cliente");
            bloquearCampos();

            //Quitar visibilidad
            vista.getTxtCodigoCliente().setVisible(false);

            //ModeloPersona modeloPersona = new ModeloPersona();
            List<Cliente> listai = modelo.listaClientesTabla();

            listai.stream().forEach(cliente -> {

                if (cliente.getPer_cedula().equals(vista.getTblCliente().getValueAt(fila, 1).toString())) {
                    //Cargar datos de persona

                    vista.getTxtCedula().setText(cliente.getPer_cedula());
                    vista.getTxtNombre().setText(cliente.getPer_nombre());
                    vista.getTxtApellido().setText(cliente.getPer_apellido());
                    vista.getFechaDeNacimiento().setDate(cliente.getPer_fechaNac());
                    vista.getTxtTelefono().setText(cliente.getPer_telefono());
                    vista.getTxtDireccion().setText(cliente.getPer_direccion());

                    for (int j = 0; j < vista.getComboMembresia().getItemCount(); j++) {
                        if (vista.getComboMembresia().getItemAt(j).equalsIgnoreCase(cliente.getCliente_tipomembresia())) {
                            vista.getComboMembresia().setSelectedIndex(j);
                            j = vista.getComboMembresia().getItemCount();
                        }
                    }
                    //Cargar datos de instructor
                    vista.getTxtCodigoCliente().setText(String.valueOf(cliente.getCliente_codigo()));

                }
            });
        }
    }

    public void eliminarCliente() {

        int fila = vista.getTblCliente().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {

            int response = JOptionPane.showConfirmDialog(vista, "¿Seguro que desea eliminar esta información?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {

                int codigoCliente;
                codigoCliente = Integer.parseInt(vista.getTblCliente().getValueAt(fila, 0).toString());

                if (modelo.eliminarCliente(codigoCliente)) {
                    JOptionPane.showMessageDialog(null, "El registro se elimino satisfactoriamente");
                    cargarTablaDeCliente();//Actualizo la tabla con los datos
                } else {
                    JOptionPane.showMessageDialog(null, "El registro no se pudo eliminar");
                }
            }
        }
    }

    public void limpiarCampos() {
        vista.getTxtCedula().setText("");
        vista.getTxtNombre().setText("");
        vista.getTxtApellido().setText("");
        vista.getFechaDeNacimiento().setDate(null);
        vista.getTxtTelefono().setText("");
        vista.getTxtDireccion().setText("");
        vista.getComboMembresia().setSelectedIndex(0);
    }

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

                DefaultTableModel tabla = (DefaultTableModel) vista.getTblCliente().getModel();

                //vista.getTablaconduccion().setAutoCreateRowSorter(true);
                filtrar = new TableRowSorter<>(tabla);
                vista.getTblCliente().setRowSorter(filtrar);

                try {

                    filtrar.setRowFilter(RowFilter.regexFilter(vista.getTxtBuscar().getText())); //Se pasa como parametro el campo de donde se va a obtener la informacion y el (3) es la columna con la cual va a buscar las coincidencias
                } catch (Exception ex) {
                    System.out.println("Error: " + ex);
                }
            }
        };

        vista.getTxtBuscar().addKeyListener(eventoTeclado); //"addKeyListener" es un metodo que se le tiene que pasar como argumento un objeto de tipo keyListener 
    }

    public void Cancelar() {
        vista.getjDlgCliente().setVisible(false);
    }

}

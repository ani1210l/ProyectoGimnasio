package controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.Administrador;
import modelo.ModeloAdministrador;
import modelo.ModeloPersona;
import vista.VistaAdmin;
import vista.VistaPrincipal;

public class ControladorAdmin {

    ModeloAdministrador modelo;
    VistaAdmin vista;
    VistaPrincipal p = new VistaPrincipal();

    public ControladorAdmin(ModeloAdministrador modelo, VistaAdmin vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
        vista.setSize(p.getEscritorioPrincipal().getWidth(), p.getEscritorioPrincipal().getHeight());

    }

    public void iniciarControl() {
        cargarTablaDeAdministrador();

        vista.getBtnAgregar().addActionListener(l -> abrirjDlgAdmin());
        vista.getBtnGuardar().addActionListener(l -> crearModificarAdmin());
        vista.getBtnActualizar().addActionListener(l -> cargarTablaDeAdministrador());
        vista.getBtnModificar().addActionListener(l -> cargarDatosAdministradorEnTXT());
        vista.getBtnEliminar().addActionListener(l -> eliminarAdmin());
        vista.getBtnCancelar().addActionListener(l -> cancelar());

//        vista.getPassword().setText("");
//        vista.getLbocultar().setVisible(true);
//        vista.getLbmostrar().setVisible(false);
        verContrasenia();
        ocultarContrasenia();

        buscarRegistros();
    }

    public void abrirjDlgAdmin() {

        vista.getDlgAdmin().setVisible(true);
        vista.getDlgAdmin().setSize(615, 699);
        vista.getDlgAdmin().setLocationRelativeTo(null);
        vista.getDlgAdmin().setName("Crear nuevo admin");
        vista.getDlgAdmin().setTitle("Crear nuevo admin");

        //Quitar visibilidad del codigo del instructor
        vista.getTxtcodigoadmin().setVisible(false);
        //desbloquearCampos();
        LimpiarTablas();
    }

    public void cargarTablaDeAdministrador() {
        DefaultTableModel tabla = (DefaultTableModel) vista.getTblAdministrador().getModel();
        tabla.setNumRows(0);

        List<Administrador> admins = modelo.listaAdminTabla();
        admins.stream().forEach(i -> {
            String[] datos = {String.valueOf(i.getAdm_codigo()), i.getPer_cedula(), i.getPer_nombre(), i.getPer_apellido(), i.getAdm_usuario()};
            tabla.addRow(datos);
        });
    }

    public void crearModificarAdmin() {

        if ("Crear nuevo admin".equals(vista.getDlgAdmin().getName())) {

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

                //Setear datos de administrador
                modelo.setAdm_usuario(vista.getTxtusuario().getText());
                modelo.setAdm_clave(vista.getPassword().getText());

                if (persona.crearPersona()) {
                    //Guarda el codigo de la persona
                    modelo.setAdm_codper(persona.traerCodigoDePersonaCreada());
                    if (modelo.crearAdministrador()) {
                        JOptionPane.showMessageDialog(null, "Usuario creado satisfactoriamente");
                        vista.getDlgAdmin().setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo registrar la informacioón");
                        persona.eliminarPersonaNoCreada(vista.getTxtCedula().getText());
                    }
                } else {
                    System.out.println("Error: No se registro la persona");
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

            //Setear datos de administrador
            modelo.setAdm_usuario(vista.getTxtusuario().getText());
            modelo.setAdm_clave(vista.getPassword().getText());

            if (persona.modificarPersona()) {
                //Seteo el codigo del instructor tomado del txt
                System.out.println("Persona modificada");
                modelo.setAdm_codigo(Integer.parseInt(vista.getTxtcodigoadmin().getText()));

                if (modelo.modificarAdministrador()) {
                    JOptionPane.showMessageDialog(null, "La información se modificó satisfactoriamente");
                    vista.getDlgAdmin().setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo modificar la información");
                }
            } else {
                System.out.println("Error modificando persona");
            }
        }

        cargarTablaDeAdministrador();
    }

    public void cargarDatosAdministradorEnTXT() {
        int fila = vista.getTblAdministrador().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {

            //Abrir jDialog de campos de Docente
            vista.getDlgAdmin().setVisible(true);
            vista.getDlgAdmin().setName("Modificar Administrador");
            vista.getDlgAdmin().setSize(615, 699);
            vista.getDlgAdmin().setLocationRelativeTo(null);
            vista.getDlgAdmin().setTitle("Modificar Administrador");
            //bloquearCampos();

            //Quitar visibilidad
            vista.getTxtcodigoadmin().setVisible(false);
            //ModeloPersona modeloPersona = new ModeloPersona();
            List<Administrador> listai = modelo.listaAdminTabla();

            listai.stream().forEach(Administrador -> {

                if (Administrador.getPer_cedula().equals(vista.getTblAdministrador().getValueAt(fila, 1).toString())) {
                    //Cargar datos de persona

                    vista.getTxtCedula().setText(Administrador.getPer_cedula());
                    vista.getTxtNombre().setText(Administrador.getPer_nombre());
                    vista.getTxtApellido().setText(Administrador.getPer_apellido());
                    vista.getFechaDeNacimiento().setDate(Administrador.getPer_fechaNac());
                    vista.getTxtTelefono().setText(Administrador.getPer_telefono());
                    vista.getTxtDireccion().setText(Administrador.getPer_direccion());

                    //Setear datos de administrador
                    vista.getTxtcodigoadmin().setText(String.valueOf(Administrador.getAdm_codigo()));
                    vista.getTxtusuario().setText(Administrador.getAdm_usuario());
                    vista.getPassword().setText(Administrador.getAdm_clave());

                }
            });
        }
    }

    public void eliminarAdmin() {

        int fila = vista.getTblAdministrador().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {

            int response = JOptionPane.showConfirmDialog(vista, "¿Seguro que desea eliminar esta información?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {

                int codigoAdmin;
                codigoAdmin = Integer.parseInt(vista.getTblAdministrador().getValueAt(fila, 0).toString());

                if (modelo.eliminarAdministrador(codigoAdmin)) {
                    JOptionPane.showMessageDialog(null, "El registro se elimino satisfactoriamente");
                    cargarTablaDeAdministrador();//Actualizo la tabla con los datos
                } else {
                    JOptionPane.showMessageDialog(null, "El registro no se pudo eliminar");
                }
            }
        }
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

                DefaultTableModel tabla = (DefaultTableModel) vista.getTblAdministrador().getModel();

                //vista.getTablaconduccion().setAutoCreateRowSorter(true);
                filtrar = new TableRowSorter<>(tabla);
                vista.getTblAdministrador().setRowSorter(filtrar);

                try {

                    filtrar.setRowFilter(RowFilter.regexFilter(vista.getTxtBuscar().getText())); //Se pasa como parametro el campo de donde se va a obtener la informacion y el (3) es la columna con la cual va a buscar las coincidencias
                } catch (Exception ex) {
                    System.out.println("Error: " + ex);
                }
            }
        };

        vista.getTxtBuscar().addKeyListener(eventoTeclado); //"addKeyListener" es un metodo que se le tiene que pasar como argumento un objeto de tipo keyListener 
    }

    public void LimpiarTablas() {
        vista.getTxtCedula().setText("");
        vista.getTxtNombre().setText(" ");
        vista.getTxtApellido().setText(" ");
        vista.getTxtDireccion().setText(" ");
        vista.getTxtTelefono().setText(" ");
        vista.getTxtusuario().setText(" ");
        vista.getPassword().setText(" ");

    }

    public void cancelar() {
        vista.getDlgAdmin().setVisible(false);
    }

    public void verContrasenia() {
        MouseListener evento = new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                vista.getPassword().setEchoChar('●');
                vista.getLbocultar().setVisible(true);
                vista.getLbmostrar().setVisible(false);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };

        vista.getLbmostrar().addMouseListener(evento);
    }

    public void ocultarContrasenia() {
        MouseListener evento = new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent e) {

                vista.getPassword().setEchoChar((char) 0);
                vista.getLbmostrar().setVisible(true);
                vista.getLbocultar().setVisible(false);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };

        vista.getLbocultar().addMouseListener(evento);
    }

}

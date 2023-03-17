package controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.xml.ws.Holder;
import modelo.AdquirirServicio;
import modelo.Cliente;
import modelo.Instructor;
import modelo.ModeloAdquirirServicio;
import modelo.ModeloCliente;
import modelo.ModeloInstructor;
import modelo.ModeloNutricionista;
import modelo.ModeloServicio;
import modelo.Nutricionista;
import modelo.Servicio;
import vista.VistaAdquirirServicio;

public class ControladorAdquirirServicio {

    ModeloAdquirirServicio modelo;
    VistaAdquirirServicio vista;

    static boolean encontrar;

    public ControladorAdquirirServicio(ModeloAdquirirServicio modelo, VistaAdquirirServicio vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
    }

    public void iniciarControl() {

        cargarTablaDeAdquirirServicio();//Se cargan los datos apenas se inicia la ventana

        //AdquirirServicio
        vista.getBtnCrear().addActionListener(l -> abrirjDialogAdquirirServicio());
        vista.getBtnCalcular().addActionListener(l -> calcularTotal());
        vista.getBtnGuardar().addActionListener(l -> crearModificarAdquirirServicio());
        vista.getBtnEliminar().addActionListener(l -> eliminarAdquirirServicio());
        vista.getBtnActualizar().addActionListener(l -> cargarTablaDeAdquirirServicio());
        vista.getBtnModificar().addActionListener(l -> cargarDatosAdquirirServicioEnTXT());
        buscarRegistros();

        //Cliente
        vista.getBtnBuscarCli().addActionListener(l -> abrirjDialogCliente());
        vista.getBtnCargarCli().addActionListener(l -> cargarDatosClienteEnTXT());

        //Instructor
        vista.getBtnBuscarIns().addActionListener(l -> abrirjDialogInstructor());
        vista.getBtnCargarIns().addActionListener(l -> cargarDatosInstructorEnTXT());

        //Nutricionista
        vista.getBtnBuscarNut().addActionListener(l -> abrirjDialogNutricionista());
        vista.getBtnCargarNut().addActionListener(l -> cargarDatosNutricionistaEnTXT());

        //Servicio
        vista.getBtnBuscarSer().addActionListener(l -> abrirjDialogServicio());
        vista.getBtnCargarSer().addActionListener(l -> cargarDatosServicioEnTXT());
    }

    public void abrirjDialogAdquirirServicio() {
        vista.getjDlgAdquirirServicio().setVisible(true);
        vista.getjDlgAdquirirServicio().setSize(885, 638);
        vista.getjDlgAdquirirServicio().setLocationRelativeTo(null);
        vista.getjDlgAdquirirServicio().setName("Adquirir servicio");
        vista.getjDlgAdquirirServicio().setTitle("Adquirir servicio");

        //Quito la visibilidad del txt del codigo del curso
        vista.getTxtCodigoCliente().setVisible(false);
        vista.getTxtCodigoInstructor().setVisible(false);
        vista.getTxtCodigoNutricionista().setVisible(false);
        vista.getTxtCodigoServicio().setVisible(false);

        cargarRegistroDeCliente();
        //buscarCurso();
    }

    public void cargarTablaDeAdquirirServicio() {
        DefaultTableModel tabla = (DefaultTableModel) vista.getTblAdquirirServicio().getModel();
        tabla.setNumRows(0);

        ModeloCliente cliente = new ModeloCliente();
        ModeloInstructor instructor = new ModeloInstructor();
        ModeloNutricionista nutricionista = new ModeloNutricionista();
        ModeloServicio servicio = new ModeloServicio();

        List<AdquirirServicio> adquirir = modelo.listaAdquirirServicioTabla();
        List<Cliente> clientes = cliente.listaClientesTabla();
        List<Instructor> instructores = instructor.listaInstructoresTabla();
        List<Nutricionista> nutricionistas = nutricionista.listaNutricionistaTabla();
        List<Servicio> servicios = servicio.listaServiciosTabla();

        adquirir.stream().forEach(a -> {

            clientes.stream().forEach(c -> {
                if (a.getAdq_codcli() == c.getCliente_codigo()) {

                    instructores.stream().forEach(i -> {

                        if (a.getAdq_codins() == i.getIns_codigo()) {

                            nutricionistas.stream().forEach(n -> {

                                if (a.getAdq_codnut() == n.getNutri_codigo()) {

                                    servicios.stream().forEach(s -> {

                                        if (a.getAdq_codser() == s.getSer_codigo()) {

                                            Object[] datos = {a.getAdq_codigo(), c.getPer_cedula(), c.getPer_nombre() + " " + c.getPer_apellido(), i.getPer_nombre() + " " + i.getPer_apellido(), n.getPer_nombre() + " " + n.getPer_apellido(), s.getSer_nombre(), a.getAdq_costototal()};
                                            tabla.addRow(datos);
                                        }
                                    });
                                }
                            });
                        }
                    });
                }
            });
        });
    }

    public void crearModificarAdquirirServicio() {

        if (vista.getjDlgAdquirirServicio().getName().equals("Adquirir servicio")) {

            encontrar = false;

            List<AdquirirServicio> adquirir = modelo.listaAdquirirServicioTabla();

            adquirir.stream().forEach(a -> {

                if (a.getAdq_codcli() == Integer.parseInt(vista.getTxtCodigoCliente().getText())) {
                    encontrar = true;
                }
            });

            if (encontrar) {
                JOptionPane.showMessageDialog(null, "Solo puede adquirir un servicio");
            } else {
                //Validar
                modelo.setAdq_codcli(Integer.parseInt(vista.getTxtCodigoCliente().getText()));
                modelo.setAdq_codins(Integer.parseInt(vista.getTxtCodigoInstructor().getText()));
                modelo.setAdq_codnut(Integer.parseInt(vista.getTxtCodigoNutricionista().getText()));
                modelo.setAdq_codser(Integer.parseInt(vista.getTxtCodigoServicio().getText()));

                modelo.setAdq_mesesins(Integer.parseInt(vista.getSpinnerMesesIns().getValue().toString()));
                modelo.setAdq_mesesnut(Integer.parseInt(vista.getSpinnerMesesNut().getValue().toString()));
                modelo.setAdq_mesesser(Integer.parseInt(vista.getSpinnerMesesSer().getValue().toString()));

                Date fecha = vista.getFechaInicio().getDate();
                java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
                modelo.setAdq_fechainicio(fechaSQL);

                modelo.setAdq_costototal(Double.parseDouble(vista.getTxtTotal().getText()));

                if (modelo.crearAdquirirServicio()) {
                    JOptionPane.showMessageDialog(null, "Adquirio el servicio satisfactoriamente");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo adquirir el servicio");
                }
            }
        } else {
            //Validar
            modelo.setAdq_codigo(Integer.parseInt(vista.getTxtCodigoAdquirirServicio().getText()));
            modelo.setAdq_codcli(Integer.parseInt(vista.getTxtCodigoCliente().getText()));
            modelo.setAdq_codins(Integer.parseInt(vista.getTxtCodigoInstructor().getText()));
            modelo.setAdq_codnut(Integer.parseInt(vista.getTxtCodigoNutricionista().getText()));
            modelo.setAdq_codser(Integer.parseInt(vista.getTxtCodigoServicio().getText()));

            modelo.setAdq_mesesins(Integer.parseInt(vista.getSpinnerMesesIns().getValue().toString()));
            modelo.setAdq_mesesnut(Integer.parseInt(vista.getSpinnerMesesNut().getValue().toString()));
            modelo.setAdq_mesesser(Integer.parseInt(vista.getSpinnerMesesSer().getValue().toString()));

            Date fecha = vista.getFechaInicio().getDate();
            java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
            modelo.setAdq_fechainicio(fechaSQL);

            modelo.setAdq_costototal(Double.parseDouble(vista.getTxtTotal().getText()));

            if (modelo.modificarAdquirirServicio()) {
                JOptionPane.showMessageDialog(null, "El servicio se modifico satisfactoriamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo modificar el servicio");
            }
        }

        cargarTablaDeAdquirirServicio();
    }

    public void cargarDatosAdquirirServicioEnTXT() {
        int fila = vista.getTblAdquirirServicio().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {

            vista.getjDlgAdquirirServicio().setVisible(true);
            vista.getjDlgAdquirirServicio().setName("Modificar instructor");
            vista.getjDlgAdquirirServicio().setSize(883, 546);
            vista.getjDlgAdquirirServicio().setLocationRelativeTo(null);
            vista.getjDlgAdquirirServicio().setTitle("Modificar instructor");
            //bloquearCampos();

            //Quitar visibilidad
            //vista.getTxtCodigoAdquirirServicio().setVisible(false);
            ModeloCliente cliente = new ModeloCliente();
            ModeloInstructor instructor = new ModeloInstructor();
            ModeloNutricionista nutricionista = new ModeloNutricionista();
            ModeloServicio servicio = new ModeloServicio();

            List<AdquirirServicio> adquirir = modelo.listaAdquirirServicioTabla();
            List<Cliente> clientes = cliente.listaClientesTabla();
            List<Instructor> instructores = instructor.listaInstructoresTabla();
            List<Nutricionista> nutricionistas = nutricionista.listaNutricionistaTabla();
            List<Servicio> servicios = servicio.listaServiciosTabla();

            adquirir.stream().forEach(a -> {

                clientes.stream().forEach(c -> {
                    if (a.getAdq_codcli() == c.getCliente_codigo()) {

                        instructores.stream().forEach(i -> {

                            if (a.getAdq_codins() == i.getIns_codigo()) {

                                nutricionistas.stream().forEach(n -> {

                                    if (a.getAdq_codnut() == n.getNutri_codigo()) {

                                        servicios.stream().forEach(s -> {

                                            if (a.getAdq_codser() == s.getSer_codigo()) {

                                                //Adquirir servicio
                                                vista.getTxtCodigoAdquirirServicio().setText(String.valueOf(a.getAdq_codigo()));
                                                vista.getFechaInicio().setDate(a.getAdq_fechainicio());
                                                vista.getTxtTotal().setText(String.valueOf(a.getAdq_costototal()));

                                                //Cliente
                                                vista.getTxtCodigoCliente().setText(String.valueOf(c.getCliente_codigo()));
                                                vista.getTxtCedulaCli().setText(c.getPer_cedula());
                                                vista.getTxtNombreCli().setText(c.getPer_nombre() + " " + c.getPer_apellido());

                                                //Instructor
                                                vista.getTxtCodigoInstructor().setText(String.valueOf(i.getIns_codigo()));
                                                vista.getTxtCedulaIns().setText(i.getPer_cedula());
                                                vista.getTxtNombreIns().setText(i.getPer_nombre() + " " + i.getPer_apellido());
                                                vista.getSpinnerSueldoIns().setValue(i.getIns_suedo());
                                                vista.getSpinnerMesesIns().setValue(a.getAdq_mesesins());

                                                //Nutricionista
                                                vista.getTxtCodigoNutricionista().setText(String.valueOf(n.getNutri_codigo()));
                                                vista.getTxtCedulaNut().setText(n.getPer_cedula());
                                                vista.getTxtNombreNut().setText(n.getPer_nombre() + " " + n.getPer_apellido());
                                                vista.getSpinnerSueldoNut().setValue(n.getNutri_salario());
                                                vista.getSpinnerMesesNut().setValue(a.getAdq_mesesnut());

                                                //Servicio
                                                vista.getTxtCodigoServicio().setText(String.valueOf(s.getSer_codigo()));
                                                vista.getTxtNombreSer().setText(s.getSer_nombre());
                                                vista.getSpinnerCostoSer().setValue(s.getSer_precio());
                                                vista.getSpinnerMesesSer().setValue(a.getAdq_mesesser());
                                            }
                                        });
                                    }
                                });
                            }
                        });
                    }
                });
            });
        }
    }

    public void eliminarAdquirirServicio() {

        int fila = vista.getTblAdquirirServicio().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {

            int response = JOptionPane.showConfirmDialog(vista, "¿Seguro que desea eliminar esta información?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {

                int codigoAdquirirServicio;
                codigoAdquirirServicio = Integer.parseInt(vista.getTblAdquirirServicio().getValueAt(fila, 0).toString());

                if (modelo.eliminarAdquirirServicio(codigoAdquirirServicio)) {
                    JOptionPane.showMessageDialog(null, "El registro se elimino satisfactoriamente");
                    cargarTablaDeAdquirirServicio();//Actualizo la tabla con los datos
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

                DefaultTableModel tabla = (DefaultTableModel) vista.getTblAdquirirServicio().getModel();

                //vista.getTablaconduccion().setAutoCreateRowSorter(true);
                filtrar = new TableRowSorter<>(tabla);
                vista.getTblAdquirirServicio().setRowSorter(filtrar);

                try {

                    filtrar.setRowFilter(RowFilter.regexFilter(vista.getTxtBuscar().getText())); //Se pasa como parametro el campo de donde se va a obtener la informacion y el (3) es la columna con la cual va a buscar las coincidencias
                } catch (Exception ex) {
                    System.out.println("Error: " + ex);
                }
            }
        };

        vista.getTxtBuscar().addKeyListener(eventoTeclado); //"addKeyListener" es un metodo que se le tiene que pasar como argumento un objeto de tipo keyListener 
    }

    //Todo sobre el registro de clientes en el jDialog
    public void abrirjDialogCliente() {
        vista.getjDlgBuscarCliente().setVisible(true);
        vista.getjDlgBuscarCliente().setSize(630, 300);
        vista.getjDlgBuscarCliente().setLocationRelativeTo(null);
        vista.getjDlgBuscarCliente().setTitle("Seleccionar cliente");

        cargarRegistroDeCliente();
        buscarCliente();
    }

    public void cargarRegistroDeCliente() {

        ModeloCliente modeloCliente = new ModeloCliente();

        vista.getTblCli().setRowHeight(25);
        DefaultTableModel estructuraTabla = (DefaultTableModel) vista.getTblCli().getModel();
        estructuraTabla.setRowCount(0);

        List<Cliente> cliente = modeloCliente.listaClientesTabla();

        Holder<Integer> i = new Holder<>(0);

        cliente.stream().forEach(c -> {

            estructuraTabla.addRow(new Object[8]);

            vista.getTblCli().setValueAt(c.getCliente_codigo(), i.value, 0);
            vista.getTblCli().setValueAt(c.getPer_cedula(), i.value, 1);
            vista.getTblCli().setValueAt(c.getPer_nombre(), i.value, 2);
            vista.getTblCli().setValueAt(c.getPer_apellido(), i.value, 3);
            vista.getTblCli().setValueAt(c.getCliente_tipomembresia(), i.value, 4);

            i.value++;
        });
    }

    public void cargarDatosClienteEnTXT() {
        int fila = vista.getTblCli().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {

            ModeloCliente modeloCliente = new ModeloCliente();
            List<Cliente> listap = modeloCliente.listaClientesTabla();

            listap.stream().forEach(c -> {

                if (c.getCliente_codigo() == Integer.parseInt(vista.getTblCli().getValueAt(fila, 0).toString())) {

                    vista.getTxtCodigoCliente().setText(String.valueOf(c.getCliente_codigo()));
                    vista.getTxtCedulaCli().setText(c.getPer_cedula());
                    vista.getTxtNombreCli().setText(c.getPer_nombre() + " " + c.getPer_apellido());
                }
            });

            vista.getjDlgBuscarCliente().dispose();
        }
    }

    public void buscarCliente() {

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

                DefaultTableModel tabla = (DefaultTableModel) vista.getTblCli().getModel();

                //vista.getTablaconduccion().setAutoCreateRowSorter(true);
                filtrar = new TableRowSorter<>(tabla);
                vista.getTblCli().setRowSorter(filtrar);

                try {

                    filtrar.setRowFilter(RowFilter.regexFilter(vista.getTxtBuscarCli().getText())); //Se pasa como parametro el campo de donde se va a obtener la informacion y el (3) es la columna con la cual va a buscar las coincidencias
                } catch (Exception ex) {
                    System.out.println("Error: " + ex);
                }
            }
        };

        vista.getTxtBuscarCli().addKeyListener(eventoTeclado); //"addKeyListener" es un metodo que se le tiene que pasar como argumento un objeto de tipo keyListener 
    }

    //Todo sobre el registro de instructores en el jDialog
    public void abrirjDialogInstructor() {
        vista.getjDlgBuscarInstructor().setVisible(true);
        vista.getjDlgBuscarInstructor().setSize(620, 314);
        vista.getjDlgBuscarInstructor().setLocationRelativeTo(null);
        vista.getjDlgBuscarInstructor().setTitle("Seleccionar instructor");

        cargarRegistroDeInstructor();
        buscarInstructor();
    }

    public void cargarRegistroDeInstructor() {

        ModeloInstructor modeloInstructor = new ModeloInstructor();

        vista.getTblIns().setRowHeight(25);
        DefaultTableModel estructuraTabla = (DefaultTableModel) vista.getTblIns().getModel();
        estructuraTabla.setRowCount(0);

        List<Instructor> cliente = modeloInstructor.listaInstructoresTabla();

        Holder<Integer> i = new Holder<>(0);

        cliente.stream().forEach(c -> {

            estructuraTabla.addRow(new Object[8]);

            vista.getTblIns().setValueAt(c.getIns_codigo(), i.value, 0);
            vista.getTblIns().setValueAt(c.getPer_cedula(), i.value, 1);
            vista.getTblIns().setValueAt(c.getPer_nombre(), i.value, 2);
            vista.getTblIns().setValueAt(c.getPer_apellido(), i.value, 3);
            vista.getTblIns().setValueAt(c.getIns_areatrabajo(), i.value, 4);
            vista.getTblIns().setValueAt(c.getIns_suedo(), i.value, 5);

            i.value++;
        });
    }

    public void cargarDatosInstructorEnTXT() {
        int fila = vista.getTblIns().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {

            ModeloInstructor modeloInstructor = new ModeloInstructor();
            List<Instructor> listap = modeloInstructor.listaInstructoresTabla();

            listap.stream().forEach(c -> {

                if (c.getIns_codigo() == Integer.parseInt(vista.getTblIns().getValueAt(fila, 0).toString())) {

                    vista.getTxtCodigoInstructor().setText(String.valueOf(c.getIns_codigo()));
                    vista.getTxtCedulaIns().setText(c.getPer_cedula());
                    vista.getTxtNombreIns().setText(c.getPer_nombre() + " " + c.getPer_apellido());
                    vista.getSpinnerSueldoIns().setValue(c.getIns_suedo());
                }
            });

            vista.getjDlgBuscarInstructor().dispose();
        }
    }

    public void buscarInstructor() {

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

                DefaultTableModel tabla = (DefaultTableModel) vista.getTblIns().getModel();

                //vista.getTablaconduccion().setAutoCreateRowSorter(true);
                filtrar = new TableRowSorter<>(tabla);
                vista.getTblIns().setRowSorter(filtrar);

                try {

                    filtrar.setRowFilter(RowFilter.regexFilter(vista.getTxtBuscarIns().getText())); //Se pasa como parametro el campo de donde se va a obtener la informacion y el (3) es la columna con la cual va a buscar las coincidencias
                } catch (Exception ex) {
                    System.out.println("Error: " + ex);
                }
            }
        };

        vista.getTxtBuscarIns().addKeyListener(eventoTeclado); //"addKeyListener" es un metodo que se le tiene que pasar como argumento un objeto de tipo keyListener 
    }

    //Todo sobre el registro de nutricionista en el jDialog
    public void abrirjDialogNutricionista() {
        vista.getjDlgBuscarNutricionista().setVisible(true);
        vista.getjDlgBuscarNutricionista().setSize(711, 350);
        vista.getjDlgBuscarNutricionista().setLocationRelativeTo(null);
        vista.getjDlgBuscarNutricionista().setTitle("Seleccionar nutricionista");

        cargarRegistroDeNutricionista();
        buscarNutricionista();
    }

    public void cargarRegistroDeNutricionista() {

        ModeloNutricionista modeloNutricionista = new ModeloNutricionista();

        vista.getTblIns().setRowHeight(25);
        DefaultTableModel estructuraTabla = (DefaultTableModel) vista.getTblNut().getModel();
        estructuraTabla.setRowCount(0);

        List<Nutricionista> nutricionista = modeloNutricionista.listaNutricionistaTabla();

        Holder<Integer> i = new Holder<>(0);

        nutricionista.stream().forEach(c -> {

            estructuraTabla.addRow(new Object[8]);

            vista.getTblNut().setValueAt(c.getNutri_codigo(), i.value, 0);
            vista.getTblNut().setValueAt(c.getPer_cedula(), i.value, 1);
            vista.getTblNut().setValueAt(c.getPer_nombre(), i.value, 2);
            vista.getTblNut().setValueAt(c.getPer_apellido(), i.value, 3);
            vista.getTblNut().setValueAt(c.getNutri_aniosExperiencia(), i.value, 4);
            vista.getTblNut().setValueAt(c.getNutri_salario(), i.value, 5);

            i.value++;
        });
    }

    public void cargarDatosNutricionistaEnTXT() {
        int fila = vista.getTblNut().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {

            ModeloNutricionista modeloNutricionista = new ModeloNutricionista();

            List<Nutricionista> listap = modeloNutricionista.listaNutricionistaTabla();

            listap.stream().forEach(c -> {

                if (c.getNutri_codigo() == Integer.parseInt(vista.getTblNut().getValueAt(fila, 0).toString())) {

                    vista.getTxtCodigoNutricionista().setText(String.valueOf(c.getNutri_codigo()));
                    vista.getTxtCedulaNut().setText(c.getPer_cedula());
                    vista.getTxtNombreNut().setText(c.getPer_nombre() + " " + c.getPer_apellido());
                    vista.getSpinnerSueldoNut().setValue(c.getNutri_salario());
                }
            });

            vista.getjDlgBuscarNutricionista().dispose();
        }
    }

    public void buscarNutricionista() {

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

                DefaultTableModel tabla = (DefaultTableModel) vista.getTblNut().getModel();

                //vista.getTablaconduccion().setAutoCreateRowSorter(true);
                filtrar = new TableRowSorter<>(tabla);
                vista.getTblNut().setRowSorter(filtrar);

                try {

                    filtrar.setRowFilter(RowFilter.regexFilter(vista.getTxtBuscarNut().getText())); //Se pasa como parametro el campo de donde se va a obtener la informacion y el (3) es la columna con la cual va a buscar las coincidencias
                } catch (Exception ex) {
                    System.out.println("Error: " + ex);
                }
            }
        };

        vista.getTxtBuscarNut().addKeyListener(eventoTeclado); //"addKeyListener" es un metodo que se le tiene que pasar como argumento un objeto de tipo keyListener 
    }

    //Todo sobre el registro de servicio en el jDialog
    public void abrirjDialogServicio() {
        vista.getjDlgBuscarServicio().setVisible(true);
        vista.getjDlgBuscarServicio().setSize(664, 330);
        vista.getjDlgBuscarServicio().setLocationRelativeTo(null);
        vista.getjDlgBuscarServicio().setTitle("Seleccionar servicio");

        cargarRegistroDeServicio();
        buscarServicio();
    }

    public void cargarRegistroDeServicio() {

        ModeloServicio modeloServicio = new ModeloServicio();

        vista.getTblIns().setRowHeight(25);
        DefaultTableModel estructuraTabla = (DefaultTableModel) vista.getTblSer().getModel();
        estructuraTabla.setRowCount(0);

        List<Servicio> servicio = modeloServicio.listaServiciosTabla();

        Holder<Integer> i = new Holder<>(0);

        servicio.stream().forEach(c -> {

            estructuraTabla.addRow(new Object[8]);

            vista.getTblSer().setValueAt(c.getSer_codigo(), i.value, 0);
            vista.getTblSer().setValueAt(c.getSer_nombre(), i.value, 1);
            vista.getTblSer().setValueAt(c.getSer_precio(), i.value, 2);

            i.value++;
        });
    }

    public void cargarDatosServicioEnTXT() {
        int fila = vista.getTblSer().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {

            ModeloServicio modeloServicio = new ModeloServicio();
            List<Servicio> listap = modeloServicio.listaServiciosTabla();

            listap.stream().forEach(c -> {

                if (c.getSer_codigo() == Integer.parseInt(vista.getTblSer().getValueAt(fila, 0).toString())) {

                    vista.getTxtCodigoServicio().setText(String.valueOf(c.getSer_codigo()));
                    vista.getTxtNombreSer().setText(c.getSer_nombre());
                    vista.getSpinnerCostoSer().setValue(c.getSer_precio());
                }
            });

            vista.getjDlgBuscarServicio().dispose();
        }
    }

    public void buscarServicio() {

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

                DefaultTableModel tabla = (DefaultTableModel) vista.getTblSer().getModel();

                //vista.getTablaconduccion().setAutoCreateRowSorter(true);
                filtrar = new TableRowSorter<>(tabla);
                vista.getTblSer().setRowSorter(filtrar);

                try {

                    filtrar.setRowFilter(RowFilter.regexFilter(vista.getTxtBuscarSer().getText())); //Se pasa como parametro el campo de donde se va a obtener la informacion y el (3) es la columna con la cual va a buscar las coincidencias
                } catch (Exception ex) {
                    System.out.println("Error: " + ex);
                }
            }
        };

        vista.getTxtBuscarSer().addKeyListener(eventoTeclado); //"addKeyListener" es un metodo que se le tiene que pasar como argumento un objeto de tipo keyListener 
    }

    public void calcularTotal() {
        double costoIns = Double.parseDouble(vista.getSpinnerMesesIns().getValue().toString()) * Double.parseDouble(vista.getSpinnerSueldoIns().getValue().toString());
        double costoNut = Double.parseDouble(vista.getSpinnerMesesNut().getValue().toString()) * Double.parseDouble(vista.getSpinnerSueldoNut().getValue().toString());
        double costoSer = Double.parseDouble(vista.getSpinnerMesesSer().getValue().toString()) * Double.parseDouble(vista.getSpinnerCostoSer().getValue().toString());

        double total = costoIns + costoNut + costoSer;

        try {
            vista.getTxtTotal().setText(String.valueOf(total));
        } catch (NumberFormatException e) {
            System.out.println("Error");
        }
    }
}

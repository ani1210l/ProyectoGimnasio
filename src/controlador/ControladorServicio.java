package controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.Instructor;
import modelo.ModeloServicio;
import modelo.Servicio;
import vista.VistaPrincipal;
import vista.VistaServicio;

public class ControladorServicio {

    ModeloServicio modelo;
    VistaServicio vista;
     VistaPrincipal p = new VistaPrincipal();

    static boolean nombreRepetido;

    public ControladorServicio(ModeloServicio modelo, VistaServicio vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
        vista.setSize(p.getEscritorioPrincipal().getWidth(), p.getEscritorioPrincipal().getHeight());
        cargarTablaDeServicios();
    }

    public void iniciarControl() {
        vista.getBtnCrear().addActionListener(l -> abrirjDlgServicio());
        vista.getBtnGuardar().addActionListener(l -> crearModificarServicio());
        vista.getBtnActualizar().addActionListener(l -> cargarTablaDeServicios());
        vista.getBtnModificar().addActionListener(l -> cargarDatosServiciosEnTXT());
        vista.getBtnEliminar().addActionListener(l -> eliminarServicio());
        buscarRegistros();
    }

    public void abrirjDlgServicio() {

        vista.getjDlgServicio().setVisible(true);
        vista.getjDlgServicio().setSize(476, 363);
        vista.getjDlgServicio().setLocationRelativeTo(null);
        vista.getjDlgServicio().setName("Crear nuevo servicio");
        vista.getjDlgServicio().setTitle("Crear nuevo servicio");

        //Quitar visibilidad del codigo del instructor
        vista.getTxtCodigoServicio().setVisible(false);

    }

    public void cargarTablaDeServicios() {
        DefaultTableModel tabla = (DefaultTableModel) vista.getTblServicio().getModel();
        tabla.setNumRows(0);

        List<Servicio> servicios = modelo.listaServiciosTabla();
        servicios.stream().forEach(i -> {
            String[] datos = {String.valueOf(i.getSer_codigo()), i.getSer_nombre(), String.valueOf(i.getSer_precio())};
            tabla.addRow(datos);
        });
    }

    public void crearModificarServicio() {

        nombreRepetido = false;

        if ("Crear nuevo servicio".equals(vista.getjDlgServicio().getName())) {

            //VALIDAR DATOS
            //Creo un objeto del modelo persona para llamar a sus metodos
            List<Servicio> servicios = modelo.listaServiciosTabla();
            servicios.stream().forEach(s -> {

                if (s.getSer_nombre().equalsIgnoreCase(vista.getTxtNombre().getText())) {
                    nombreRepetido = true;
                }
            });

            if (nombreRepetido) {
                JOptionPane.showMessageDialog(null, "El servicio ya se encuentra registrado");
            } else {
                modelo.setSer_nombre(vista.getTxtNombre().getText());
                modelo.setSer_precio(Double.parseDouble(vista.getSpinnerCosto().getValue().toString()));

                if (modelo.crearServicio()) {
                    JOptionPane.showMessageDialog(null, "Servicio registrado satisfactoriamente");
                    vista.getjDlgServicio().setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "El servicio no se pudo registrar");
                }
            }
        } else {

            //VALIDAR DATOS
            //Creo un objeto del modelo persona para llamar a sus metodos
            List<Servicio> servicios = modelo.listaServiciosTabla();
            servicios.stream().forEach(s -> {

                if (s.getSer_nombre().equalsIgnoreCase(vista.getTxtNombre().getText())) {
                    nombreRepetido = true;
                }
            });

            if (nombreRepetido) {
                JOptionPane.showMessageDialog(null, "El servicio ya se encuentra registrado");
            } else {
                modelo.setSer_codigo(Integer.parseInt(vista.getTxtCodigoServicio().getText()));
                modelo.setSer_nombre(vista.getTxtNombre().getText());
                modelo.setSer_precio(Double.parseDouble(vista.getSpinnerCosto().getValue().toString()));

                if (modelo.modificarServicio()) {
                    JOptionPane.showMessageDialog(null, "Servicio modificado satisfactoriamente");
                    vista.getjDlgServicio().setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "El servicio no se pudo modificar");
                }
            }
        }

        cargarTablaDeServicios();
    }

    public void cargarDatosServiciosEnTXT() {
        int fila = vista.getTblServicio().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {

            vista.getjDlgServicio().setVisible(true);
            vista.getjDlgServicio().setName("Modificar servicio");
            vista.getjDlgServicio().setSize(476, 363);
            vista.getjDlgServicio().setLocationRelativeTo(null);
            vista.getjDlgServicio().setTitle("Modificar servicio");

            //Quitar visibilidad
            vista.getTxtCodigoServicio().setVisible(false);

            List<Servicio> listaS = modelo.listaServiciosTabla();

            listaS.stream().forEach(s -> {

                if (s.getSer_codigo() == Integer.parseInt(vista.getTblServicio().getValueAt(fila, 0).toString())) {

                    vista.getTxtCodigoServicio().setText(String.valueOf(s.getSer_codigo()));
                    vista.getTxtNombre().setText(s.getSer_nombre());
                    vista.getSpinnerCosto().setValue(s.getSer_precio());

                }
            });
        }
    }

    public void eliminarServicio() {

        int fila = vista.getTblServicio().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {

            int response = JOptionPane.showConfirmDialog(vista, "¿Seguro que desea eliminar esta información?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {

                int codigoServicio;
                codigoServicio = Integer.parseInt(vista.getTblServicio().getValueAt(fila, 0).toString());

                if (modelo.eliminarServicio(codigoServicio)) {
                    JOptionPane.showMessageDialog(null, "El registro se elimino satisfactoriamente");
                    cargarTablaDeServicios();//Actualizo la tabla con los datos
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

                DefaultTableModel tabla = (DefaultTableModel) vista.getTblServicio().getModel();

                //vista.getTablaconduccion().setAutoCreateRowSorter(true);
                filtrar = new TableRowSorter<>(tabla);
                vista.getTblServicio().setRowSorter(filtrar);

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

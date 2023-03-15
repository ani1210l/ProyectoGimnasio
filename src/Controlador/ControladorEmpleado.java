/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Empleado;
import Modelo.ModeloEmpleado;
import Modelo.ModeloPersona;
import Modelo.Persona;
import Vista.VistaEmpleado;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.xml.ws.Holder;

/**
 *
 * @author Asus
 */
public class ControladorEmpleado {

    private ModeloEmpleado modelo;
    private VistaEmpleado vista;
    private JFileChooser jfc; //Objeto de tipo JFileChooser

//    public ControladorEmpleado(ModeloEmpleado modelo, VistaEmpleado vista, JFileChooser jfc) {
//        this.modelo = modelo;
//        this.vista = vista;
//        this.jfc = jfc;}
//    }
    public ControladorEmpleado(ModeloEmpleado modelo, VistaEmpleado vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
        cargarEmpleadoTabla();//carga dtos
    }

    private void cargarEmpleadoTabla() {
        DefaultTableModel tabla = (DefaultTableModel) vista.getTblEmpleado().getModel();
        tabla.setNumRows(0);

        List<Empleado> horarios = modelo.listaEmpleadosTabla();
        horarios.stream().forEach(p -> {
            String[] datos = {String.valueOf(p.getEmpleado_codigo()), String.valueOf(p.getEmp_codper()), String.valueOf(p.getSalario_emp()), p.getEmp_horario()};
            tabla.addRow(datos);
        });

    }

    public void iniciarControl() {

        vista.getBtnCrear().addActionListener(l -> abrirDlgEmpleado());
        vista.getBtnActualizar().addActionListener(l -> cargarEmpleadoTabla());
        vista.getBtnModificar().addActionListener(l -> abrirYCargarDatosEnElDialog());
//        vista.getBtnEliminar().addActionListener(l -> eliminarEmpleado());
        vista.getBtnAceptar().addActionListener(l -> crearEmpleado());
        vista.getBtnCancelar().addActionListener(l -> botonCancelar());
        //vista.getBtngeneraReporte().addActionListener(l -> imprimirPersona());
        //vista.getBtnImprimir().addActionListener(l -> abrirJDlgImprimir());
        buscarEmpleado();
    }

    public void abrirDlgEmpleado() {

        vista.getjDialEmpleado().setName("Crear nuevo empleado");
        vista.getjDialEmpleado().setLocationRelativeTo(vista);
        vista.getjDialEmpleado().setSize(891, 565);
        vista.getjDialEmpleado().setTitle("Crear nuevo empleado");
        vista.getjDialEmpleado().setVisible(true);

    }

    private void abrirYCargarDatosEnElDialog() {

        int fila = vista.getTblEmpleado().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {

            //Abrir jDialog de campos de Docente
            vista.getjDialEmpleado().setName("Modificar empleado");
            vista.getjDialEmpleado().setLocationRelativeTo(null);
            vista.getjDialEmpleado().setSize(879, 565);
            vista.getjDialEmpleado().setTitle("Modificar  empleado");
            vista.getjDialEmpleado().setVisible(true);

            //ModeloPersona modeloPersona = new ModeloPersona();
            List<Empleado> listae = modelo.listaEmpleadosTabla();

            listae.stream().forEach(empleado -> {

                if (empleado.getPer_cedula().equals(vista.getTblEmpleado().getValueAt(fila, 0).toString())) {
                    vista.getTxtcedula().setText(empleado.getPer_cedula());
                    vista.getTxtnombre().setText(empleado.getPer_nombre());
                    vista.getTxtapellido().setText(empleado.getPer_apellido());
                    vista.getjFecha().setDate(empleado.getPer_fechaNac());
                    vista.getTxttelefono().setText(empleado.getPer_telefono());
                    vista.getTxtdireccion().setText(empleado.getPer_direccion());

                    vista.getTxtcodempleado().setText(String.valueOf(empleado.getEmpleado_codigo()));
                    vista.getTxtsalario().setText(String.valueOf(empleado.getSalario_emp()));
                    vista.getTxtcodempleadopers().setText(String.valueOf(empleado.getEmp_codper()));

                    vista.getCmdHorario().setSelectedItem(empleado.getEmp_horario());

                }
            });
        }
    }

    private boolean crearEmpleado() {

        boolean crearEmpleados = false;

        if ("Crear nuevo empleado".equals(vista.getjDialEmpleado().getName())) {

            if (validarDatosEmpleado()) {

                ModeloEmpleado empleado = new ModeloEmpleado();

                empleado.setPer_cedula(vista.getTxtcedula().getText());
                empleado.setPer_nombre(vista.getTxtnombre().getText());
                empleado.setPer_apellido(vista.getTxtapellido().getText());
                Date fecha = vista.getjFecha().getDate();
                java.sql.Date fechaSQL = new java.sql.Date(fecha.getDate());
                empleado.setPer_fechaNac(fechaSQL);
                empleado.setPer_telefono(vista.getTxttelefono().getText());
                empleado.setPer_direccion(vista.getTxtdireccion().getText());
                int codigoEmpleado = Integer.parseInt(vista.getTxtcodempleado().getText());
                int codigoEmpleadoPersona = Integer.parseInt(vista.getTxtcodempleadopers().getText());
                double salario = Double.parseDouble(vista.getTxtsalario().getText());
                String sacarhorario = vista.getCmdHorario().getSelectedItem().toString();

                empleado.setEmpleado_codigo(codigoEmpleado);
                empleado.setEmp_codper(codigoEmpleadoPersona);
                empleado.setSalario_emp(salario);
                empleado.setEmp_horario(sacarhorario);

                if (empleado.crearEmpleado() == null) {
                    JOptionPane.showMessageDialog(null, "Empleado creado");
                    crearEmpleados = true;
                } else {
                    System.out.println("El empleado NO se pudo crear");
                }
            }
        } else {

            JOptionPane.showMessageDialog(null, "El numero de empleado ya se encuentra registrado");
        }
        return crearEmpleados;
    }

    public boolean validarDatosEmpleado() {
        Validaciones mivalidacion = new Validaciones();

        boolean validar = true;

        /*if (vista.getTxtCedula().getText().isEmpty() || !mivalidacion.validarCedula(vista.getTxtCedula().getText())) {

            validar = false;
        }*/
        if (vista.getTxtnombre().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el primer nombre");
            validar = false;
        } else {
            if (!mivalidacion.validarTextoSinEspacio(vista.getTxtnombre().getText())) {
                JOptionPane.showMessageDialog(null, "Primer nombre incorrecto");
                validar = false;
            }
        }

        if (vista.getTxtapellido().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el apellido");
            validar = false;
        } else {
            if (!mivalidacion.validarTextoSinEspacio(vista.getTxtapellido().getText())) {
                JOptionPane.showMessageDialog(null, "Primer apellido incorrecto");
                validar = false;
            }
        }

        if (vista.getTxttelefono().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el numero de telefono");
            validar = false;
        } else {
            if (!mivalidacion.validarTelefono(vista.getTxttelefono().getText())) {
                JOptionPane.showMessageDialog(null, "Telefono incorrecto");
                validar = false;
            }
        }

        if (vista.getTxtdireccion().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese la direccion");
            validar = false;
        } else {
            if (!mivalidacion.validarDireccion(vista.getTxtdireccion().getText())) {
                JOptionPane.showMessageDialog(null, "Direccion incorrecta");
                validar = false;
            }
        }

        return validar;
    }

////    private void eliminarEmpleado() {
////
////        int fila = vista.getTblEmpleado().getSelectedRow();
////
////        if (fila == -1) {
////            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
////        } else {
////
////            int response = JOptionPane.showConfirmDialog(vista, "¿Seguro que desea eliminar la información?", "Confirme", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
////            if (response == JOptionPane.YES_OPTION) {
////
////                int Empleado_codigo;
////                Empleado_codigo = vista.getTblEmpleado().getValueAt(fila, 0).toString();
////
////                if (modelo.eliminarEmpleado(Empleado_codigo)) {
////                    JOptionPane.showMessageDialog(null, "La persona fue eliminada exitosamente");
////                    cargarEmpleadoTabla();
////                } else {
////                    JOptionPane.showMessageDialog(null, "La persona no se pudo eliminar");
////                }
////            }
////        }
////
////    }
    public void modificarEmpleado() {
//
//        int seleccion = vista.getTblEmpleado().getSelectedRow();
        if ("Editar empleado".equals(vista.getjDialEmpleado().getName())) {

            if (validarDatosEmpleado()) {
                ModeloEmpleado empleado = new ModeloEmpleado();

                //Setear los datos de persona
                empleado.setPer_cedula(vista.getTxtcedula().getText());
                empleado.setPer_nombre(vista.getTxtnombre().getText());
                empleado.setPer_apellido(vista.getTxtapellido().getText());

                Date fecha = vista.getjFecha().getDate();
                java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
                empleado.setPer_fechaNac(fechaSQL);
                empleado.setPer_telefono(vista.getTxttelefono().getText());
                empleado.setPer_direccion(vista.getTxtdireccion().getText());
                vista.getTxtcodempleado().setText(String.valueOf(empleado.getEmpleado_codigo()));
                vista.getTxtcodempleadopers().setText(String.valueOf(empleado.getEmp_codper()));
                vista.getCmdHorario().setSelectedItem(String.valueOf(empleado.getEmp_horario()));
                vista.getTxtsalario().setText(String.valueOf(empleado.getSalario_emp()));

                if (empleado.modificarEmpleado() == null) {
                    JOptionPane.showMessageDialog(null, "Datos modificados exitosamente");
                    vista.getjDialEmpleado().setVisible(false);
                    cargarEmpleadoTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "No fue posible modificar los datos");
                }

            }
        }

    }

    private void botonCancelar() {
        vista.getjDialEmpleado().setVisible(false);

    }

    public void buscarEmpleado() {
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

                DefaultTableModel tabla = (DefaultTableModel) vista.getTblEmpleado().getModel();

                //vista.getTablaconduccion().setAutoCreateRowSorter(true);
                filtrar = new TableRowSorter<>(tabla);
                vista.getTblEmpleado().setRowSorter(filtrar);

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

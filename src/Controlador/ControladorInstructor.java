/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Empleado;
import Modelo.Instructor;
import Modelo.ModeloEmpleado;
import Modelo.Modelo_Instructor;
import Vista.VistaEmpleado;
import Vista.VistaInstructor;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;

/**
 *
 * @author Asus
 */
public class ControladorInstructor {

    private Modelo_Instructor modelo;
    private VistaInstructor vista;
    private JFileChooser jfc;

    public ControladorInstructor(Modelo_Instructor modelo, VistaInstructor vista, JFileChooser jfc) {
        this.modelo = modelo;
        this.vista = vista;
        this.jfc = jfc;
        vista.setVisible(true);
        cargarInstructorTabla();
    }

    private void cargarInstructorTabla() {
        vista.getTblaInstructor().setRowHeight(100);
        DefaultTableModel tblModel;
        tblModel = (DefaultTableModel) vista.getTblaInstructor().getModel();
        tblModel.setNumRows(0);//limpio filas de la tabla.

        List<Instructor> listap = modelo.listaInstructorTabla();//Enlazo al Modelo y obtengo los datos
        Holder<Integer> i = new Holder<>(0);//Contador para las filas. 'i' funciona dentro de una expresion lambda

        listap.stream().forEach(pe -> {

            tblModel.addRow(new Object[9]);//Creo una fila vacia

            vista.getTblaInstructor().setValueAt(pe.getCod_persona(), i.value, 0);
            vista.getTblaInstructor().setValueAt(pe.getEmpleado_codigo(), i.value, 1);
            vista.getTblaInstructor().setValueAt(pe.getHorario_codigo(), i.value, 2);
            vista.getTblaInstructor().setValueAt(pe.getSalario_emp(), i.value, 3);
            vista.getTblaInstructor().setValueAt(pe.getIns_codigo(), i.value, 4);
            vista.getTblaInstructor().setValueAt(pe.getIns_areatrabajo(), i.value, 5);
            vista.getTblaInstructor().setValueAt(pe.getDescripcion(), i.value, 6);
            i.value++;
        });

    }

    public void iniciarControl() {

        vista.getBtnCrear().addActionListener(l -> abrirDlgEmpleado());
        vista.getBtnActualizar().addActionListener(l -> cargarInstructorTabla());
        vista.getBtnModificar().addActionListener(l -> abrirDlgEmpleado());
//        vista.getBtnEliminar().addActionListener(l -> eliminarEmpleado());
        vista.getBtnAceptar().addActionListener(l -> crearInstructor());
        vista.getBtnCancelar().addActionListener(l -> botonCancelar());
        //vista.getBtngeneraReporte().addActionListener(l -> imprimirPersona());
        //vista.getBtnImprimir().addActionListener(l -> abrirJDlgImprimir());
        buscarEmpleado();

    }

    public void abrirDlgEmpleado() {

        vista.getjDialoInstructor().setName("Crear nuevo instructor");
        vista.getjDialoInstructor().setLocationRelativeTo(vista);
        vista.getjDialoInstructor().setSize(891, 565);
        vista.getjDialoInstructor().setTitle("Crear nuevo instructor");
        vista.getjDialoInstructor().setVisible(true);

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
    private void botonCancelar() {
        vista.getjDialoInstructor().setVisible(false);

    }

    private void buscarEmpleado() {

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

                DefaultTableModel tblModel;
                tblModel = (DefaultTableModel) vista.getTblaInstructor().getModel();
                tblModel.setNumRows(0);//limpio filas de la tabla.

                List<Instructor> listaEm = modelo.BuscarInstructor(vista.getBuscar().getText());//Enlazo al Modelo y obtengo los datos
                Holder<Integer> i = new Holder<>(0);//contador para el no. fila

                listaEm.stream().forEach(pe -> {

                    tblModel.addRow(new Object[9]);
                    vista.getTblaInstructor().setValueAt(pe.getCod_persona(), i.value, 0);
                    vista.getTblaInstructor().setValueAt(pe.getEmpleado_codigo(), i.value, 1);
                    vista.getTblaInstructor().setValueAt(pe.getHorario_codigo(), i.value, 2);
                    vista.getTblaInstructor().setValueAt(pe.getSalario_emp(), i.value, 3);
                    vista.getTblaInstructor().setValueAt(pe.getIns_codigo(), i.value, 4);
                    vista.getTblaInstructor().setValueAt(pe.getIns_areatrabajo(), i.value, 5);
                    vista.getTblaInstructor().setValueAt(pe.getDescripcion(), i.value, 6);

                    i.value++;
                });
            }
        };

        vista.getBuscar().addKeyListener(eventoTeclado);
    }

    private boolean crearInstructor() {
        boolean crearInstructor = false;

        if ("Crear nuevo instructor".equals(vista.getjDialoInstructor().getName())) {

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
            int codigoHorario = Integer.parseInt(vista.getTxtHorario().getText());

            empleado.setEmpleado_codigo(codigoEmpleado);
            empleado.setEmp_codper(codigoEmpleadoPersona);
            empleado.setSalario_emp(salario);
            empleado.setHorario_codigo(codigoHorario);

            if (empleado.crearEmpleado() == null) {
                JOptionPane.showMessageDialog(null, "Empleado creado");
                crearInstructor = true;
            } else {
                System.out.println("El empleado NO se pudo crear");
            }

        } else {

            JOptionPane.showMessageDialog(null, "El numero de empleado ya se encuentra registrado");
        }
        return crearInstructor;
    }
}

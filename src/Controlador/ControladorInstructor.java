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
            vista.().setValueAt(pe.getIns_codigo(), i.value, 0);
            vista.getTblaInstructor().setValueAt(pe.getSalario_emp(), i.value, 1);
            vista.getTblaInstructor().setValueAt(pe.getHorario_codigo(), i.value, 2);
            vista.getTblaInstructor().setValueAt(pe.getEmp_codper(), i.value, 3);

            i.value++;
        });

    }
     
     public void iniciarControl() {

        vista.getBtnCrear().addActionListener(l -> abrirDlgEmpleado());
        vista.getBtnActualizar().addActionListener(l -> cargarInstructorTabla());
        vista.getBtnModificar().addActionListener(l -> abrirDlgEmpleado());
//        vista.getBtnEliminar().addActionListener(l -> eliminarEmpleado());
        vista.getBtnAceptar().addActionListener(l -> crearEmpleado());
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
    
    public boolean validarDatoInstructor() {
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
     private void botonCancelar() {
        vista.getjDialoInstructor().setVisible(false);

    }
}

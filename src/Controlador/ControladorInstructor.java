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

        vista.getBtnCrear().addActionListener(l -> abrirDlgoInstructor());
        vista.getBtnActualizar().addActionListener(l -> cargarInstructorTabla());
        vista.getBtnModificar().addActionListener(l -> abrirYCargarDatosEnElDialog());
//        vista.getBtnEliminar().addActionListener(l -> eliminarInstructor());
        vista.getBtnAceptar().addActionListener(l -> crearInstructor());
        vista.getBtnCancelar().addActionListener(l -> botonCancelar());
        //vista.getBtngeneraReporte().addActionListener(l -> imprimir());
        //vista.getBtnImprimir().addActionListener(l -> abrirJDlgImprimir());
        buscarInstructor();

    }

    public void abrirDlgoInstructor() {

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

    private void buscarInstructor() {

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

            Modelo_Instructor instructor = new Modelo_Instructor();

            int codigoEmpleado = Integer.parseInt(vista.getTxtcodempleado().getText());
            int codigoPersona = Integer.parseInt(vista.getTxtinstruccodPersona().getText());
            double salario = Double.parseDouble(vista.getTxtsalario().getText());
            int codigoHorario = Integer.parseInt(vista.getTxtcodigoHorario().getText());
            int codigoInstructor = Integer.parseInt(vista.getTxtcodinstructor().getText());

            String areaTrabajo = vista.getTxtareatrabajo().getText();
            String descripcion = vista.getTxtdescripcion().getText();

            instructor.setEmpleado_codigo(codigoEmpleado);
            instructor.setCod_persona(codigoPersona);
            instructor.setSalario_emp(salario);
            instructor.setHorario_codigo(codigoHorario);
            instructor.setIns_areatrabajo(areaTrabajo);
            instructor.setIns_codigo(codigoInstructor);
            instructor.setDescripcion(descripcion);

            if (instructor.CrearInstructor() == null) {
                JOptionPane.showMessageDialog(null, "Instructor creado");
                crearInstructor = true;
            } else {
                System.out.println("El instructor NO se pudo crear");
            }

        } else {

            JOptionPane.showMessageDialog(null, "El numero de instructor ya se encuentra registrado");
        }
        return crearInstructor;
    }

    private void abrirYCargarDatosEnElDialog() {

        int fila = vista.getTblaInstructor().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {

            //Abrir jDialog de campos de Docente
            vista.getjDialoInstructor().setName("Modificar instructor");
            vista.getjDialoInstructor().setLocationRelativeTo(null);
            vista.getjDialoInstructor().setSize(879, 565);
            vista.getjDialoInstructor().setTitle("Modificar  instructor");
            vista.getjDialoInstructor().setVisible(true);

            //ModeloPersona modeloPersona = new ModeloPersona();
            List<Instructor> listae = modelo.listaInstructorTabla();

            listae.stream().forEach(instructor -> {

                if (instructor.getPer_cedula().equals(vista.getTblaInstructor().getValueAt(fila, 0).toString())) {

                    vista.getTxtcodempleado().setText(String.valueOf(instructor.getEmpleado_codigo()));
                    vista.getTxtsalario().setText(String.valueOf(instructor.getSalario_emp()));
                    vista.getTxtinstruccodPersona().setText(String.valueOf(instructor.getCod_persona()));
                    vista.getTxtcodigoHorario().setText(String.valueOf(instructor.getHorario_codigo()));

                    vista.getTxtcodinstructor().setText(String.valueOf(instructor.getIns_codigo()));
                    vista.getTxtareatrabajo().setText(instructor.getIns_areatrabajo());
                    vista.getTxtdescripcion().setText(instructor.getDescripcion());

                }
            });
        }
    }
}

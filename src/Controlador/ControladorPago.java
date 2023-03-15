/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.modelopago;
import Modelo.Pago;
import Vista.VistaPago;
import Vista.VistaPrincipal;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;

/**
 *
<<<<<<< HEAD
 * @author damian
 */
public class ControladorPago {

    private modelopago modelo;
    private VistaPago vista;
    VistaPrincipal p = new VistaPrincipal();

    public ControladorPago(modelopago modelo, VistaPago vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);

        vista.setSize(p.getjDesktopPane().getWidth(), p.getjDesktopPane().getHeight());
        vista.getjDcrearpago().setResizable(true);
        cargarpagoTabla();
    }

    public void cargarpagoTabla() {
        DefaultTableModel tblModel;
        tblModel = (DefaultTableModel) vista.getTblPago().getModel();
        tblModel.setNumRows(0);//limpio filas de la tablaSSSSS.

        List<Pago> listapa = modelo.listapagosTabla();//Enlazo al Modelo y obtengo los datos
        Holder<Integer> i = new Holder<>(0);//Contador para las filas. 'i' funciona dentro de una expresion lambda

        listapa.stream().forEach(pe -> {

            tblModel.addRow(new Object[9]);//Creo una fila vacia
            vista.getTblPago().setValueAt(pe.getPago_codigo(), i.value, 0);
            vista.getTblPago().setValueAt(pe.getPag_rutina(), i.value, 1);
            vista.getTblPago().setValueAt(pe.getDeuda(), i.value, 2);
            vista.getTblPago().setValueAt(pe.getFecha(), i.value, 3);
                        vista.getTblPago().setValueAt(pe.getCod_cliente(), i.value, 4);


            i.value++;
        });
    }

    public void iniciarControl() {
        vista.getjDcrearpago().setSize(875, 623);

        vista.getBtnCrearpago().addActionListener(l -> abrirDlgPago());
        vista.getBtnActualizarpago().addActionListener(l -> cargarpagoTabla());
        vista.getBtnModificarpago().addActionListener(l -> cargarDatospagoTXT());
        vista.getBtnCancelar().addActionListener(l -> botonCancelar());
        vista.getBtnGuardar().addActionListener(l -> crearPAGO());
        buscarPago();
    }

    public void abrirDlgPago() {

        vista.getjDcrearpago().setName("Crear nuevo pago");
        vista.getjDcrearpago().setSize(875, 623);
        vista.getjDcrearpago().setTitle("Crear nuevo pago");
        vista.getjDcrearpago().setVisible(true);

    }

    public void cargarDatospagoTXT() {
        int fila = vista.getTblPago().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {

            //Abrir jDialog de campos de Docente
            vista.getjDcrearpago().setName("Modificar pago");
            vista.getjDcrearpago().setLocationRelativeTo(null);
            vista.getjDcrearpago().setSize(802, 622);
            vista.getjDcrearpago().setTitle("Modificar  pago");
            vista.getjDcrearpago().setVisible(true);

            //ModeloPersona modeloPersona = new ModeloPersona();
            List<Pago> listac = modelo.listapagosTabla();

            listac.stream().forEach(persona -> {

                if (String.valueOf(persona.getPago_codigo()).equals(vista.getTblPago().getValueAt(fila, 0).toString())) {
                    vista.getTxtcdpago().setText(String.valueOf(persona.getPago_codigo()));
                    vista.getTxtpagorut().setText(persona.getPag_rutina());
                    vista.getTxtdeuda().setText(persona.getDeuda());
                    vista.getjDateChooser1().setDate(persona.getFecha());
                    vista.getTxtcodcli().setText(String.valueOf(persona.getCod_cliente()));

                }
            });
        }
    }

    public void botonCancelar() {
        vista.getjDcrearpago().setVisible(false);
    }

    public boolean crearPAGO() {

        boolean crearPAGO = false;
        //Insertar persona

        if (modelo.validarRepetidospago(Integer.parseInt(vista.getTxtcodcli().getText())) == 0) {

            if (validarDatospago()) {

                modelopago personac = new modelopago();

                //vista.getTxtcedula().setText(persona.getPer_cedula());
                
                personac.setPag_rutina(vista.getTxtpagorut().getText());
                personac.setDeuda(vista.getTxtdeuda().getText());
                Date fecha = vista.getjDateChooser1().getDate();
                java.sql.Date fechaSQL = new java.sql.Date(fecha.getDate());
                 personac.setFecha(fechaSQL);
                personac.setCod_cliente(Integer.parseInt(vista.getTxtcodcli().getText()));
               
                if (personac.crearPago()== null) {
                    JOptionPane.showMessageDialog(null, "pago creada");
                    // System.out.println("Persona creada satisfactoriamente");
                    crearPAGO = true;
                } else {
                    System.out.println("no pago NO se pudo crear");
                }
            }
        } else {

            JOptionPane.showMessageDialog(null, "El numero de cedula ya se encuentra registrado");
        }

        return crearPAGO;

    }

    public boolean validarDatospago() {
        Validaciones mivalidacion = new Validaciones();

        boolean validar = true;

        /*if (vista.getTxtCedula().getText().isEmpty() || !mivalidacion.validarCedula(vista.getTxtCedula().getText())) {

            validar = false;
        }*/
       
            
        

        if (vista.getTxtpagorut().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el pago de rutina");
            validar = false;
        } else {
            validar = true;
        }

        if (vista.getTxtdeuda().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese la deuda");
            validar = false;
        } else {
           validar = true;
        }

        if (vista.getTxtcodcli().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese codigo de clienten");
            validar = false;
        } else {
            validar = true;
        }
        if (vista.getjDateChooser1().getDate() == null) {
            JOptionPane.showMessageDialog(null, "Ingrese fecha de pago");
            validar = false;
        } else {

            LocalDate fechaNueva = vista.getjDateChooser1().getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); //Paso la fecha de nacimiento de tipo Date a tipo LocalDate

           
        }

        return validar;
    }

    public void buscarPago() {

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
                tblModel = (DefaultTableModel) vista.getTblPago().getModel();
                tblModel.setNumRows(0);//limpio filas de la tabla.

                List<Pago> listac = modelo.buscarPagos(Integer.parseInt(vista.getjButton1().getText()));//Enlazo al Modelo y obtengo los datos
                Holder<Integer> i = new Holder<>(0);//Contador para las filas. 'i' funciona dentro de una expresion lambda

                listac.stream().forEach(pe -> {

                      tblModel.addRow(new Object[9]);//Creo una fila vacia
            vista.getTblPago().setValueAt(pe.getPago_codigo(), i.value, 0);
            vista.getTblPago().setValueAt(pe.getPag_rutina(), i.value, 1);
            vista.getTblPago().setValueAt(pe.getDeuda(), i.value, 2);
            vista.getTblPago().setValueAt(pe.getFecha(), i.value, 3);
                        vista.getTblPago().setValueAt(pe.getCod_cliente(), i.value, 4);


            i.value++;
                });
            }
        };

        vista.getjButton1().addKeyListener(eventoTeclado); //"addKeyListener" es un metodo que se le tiene que pasar como argumento un objeto de tipo keyListener 
    }

    public boolean validarDatosPersona() {
        Validaciones mivalidacion = new Validaciones();

        boolean validar = true;

        /*if (vista.getTxtCedula().getText().isEmpty() || !mivalidacion.validarCedula(vista.getTxtCedula().getText())) {

            validar = false;
        }*/
       if (vista.getTxtcdpago().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el codigo pago");
            validar = false;
        } else {
            if (!mivalidacion.validarTextoSinEspacio(vista.getTxtcdpago().getText())) {
                JOptionPane.showMessageDialog(null, "codigo pagoincorrecto");
                validar = false;
            }
        }

        if (vista.getTxtpagorut().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el pago de rutina");
            validar = false;
        } else {
            if (!mivalidacion.validarTextoSinEspacio(vista.getTxtpagorut().getText())) {
                JOptionPane.showMessageDialog(null, "pago de rutina incorrecto");
                validar = false;
            }
        }

        if (vista.getTxtdeuda().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese la deuda");
            validar = false;
        } else {
            if (!mivalidacion.validarTelefono(vista.getTxtdeuda().getText())) {
                JOptionPane.showMessageDialog(null, "deuda incorrecto");
                validar = false;
            }
        }

        if (vista.getTxtcodcli().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese codigo de clienten");
            validar = false;
        } else {
            if (!mivalidacion.validarDireccion(vista.getTxtcodcli().getText())) {
                JOptionPane.showMessageDialog(null, " codigo de clienten incorrecta");
                validar = false;
            }
        }
        if (vista.getjDateChooser1().getDate() == null) {
            JOptionPane.showMessageDialog(null, "Ingrese fecha de pago");
            validar = false;
        } else {

            LocalDate fechaNueva = vista.getjDateChooser1().getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); //Paso la fecha de nacimiento de tipo Date a tipo LocalDate

           
        }

        return validar;
        
    }

    



 
     
    
}



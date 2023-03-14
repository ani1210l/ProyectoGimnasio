/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.modelo_cliente;
import Modelo.Cliente;
import Vista.VistaCliente;
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
 * @author damian
 */
public class ControladorCliente {

    private modelo_cliente modelo;
    private VistaCliente vista;
    VistaPrincipal p = new VistaPrincipal();

    public ControladorCliente(modelo_cliente modelo, VistaCliente vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);

        vista.setSize(p.getjDesktopPane().getWidth(), p.getjDesktopPane().getHeight());
        vista.getjDcliente().setResizable(true);
        cargarClienteTabla();
    }

    public void cargarClienteTabla() {
        DefaultTableModel tblModel;
        tblModel = (DefaultTableModel) vista.getTblClientes().getModel();
        tblModel.setNumRows(0);//limpio filas de la tabla.

        List<Cliente> listac = modelo.listaclientesTabla();//Enlazo al Modelo y obtengo los datos
        Holder<Integer> i = new Holder<>(0);//Contador para las filas. 'i' funciona dentro de una expresion lambda

        listac.stream().forEach(pe -> {

            tblModel.addRow(new Object[9]);//Creo una fila vacia
            vista.getTblClientes().setValueAt(pe.getCliente_codigo(), i.value, 0);
            vista.getTblClientes().setValueAt(pe.getFecha_ingreso(), i.value, 1);
            vista.getTblClientes().setValueAt(pe.getCli_codper(), i.value, 2);

            i.value++;
        });
    }

    public void iniciarControl() {
        vista.getjDcliente().setSize(875, 623);

        vista.getBtnCrearcliente().addActionListener(l -> abrirDlgPersonas());
        vista.getBtnActualizarcli().addActionListener(l -> cargarClienteTabla());
        vista.getBtnModificarcli().addActionListener(l -> cargarDatosClienteEnTXT());
        vista.getBtnCancelar().addActionListener(l -> botonCancelar());
        vista.getBtnGuardar().addActionListener(l -> crearCliente());
        buscarCliente();
    }

    public void abrirDlgPersonas() {

        vista.getjDcliente().setName("Crear nueva cliente");
        vista.getjDcliente().setSize(875, 623);
        vista.getjDcliente().setTitle("Crear nueva cliente");
        vista.getjDcliente().setVisible(true);

    }

    public void cargarDatosClienteEnTXT() {
        int fila = vista.getTblClientes().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {

            //Abrir jDialog de campos de Docente
            vista.getjDcliente().setName("Modificar persona");
            vista.getjDcliente().setLocationRelativeTo(null);
            vista.getjDcliente().setSize(802, 622);
            vista.getjDcliente().setTitle("Modificar  persona");
            vista.getjDcliente().setVisible(true);

            //ModeloPersona modeloPersona = new ModeloPersona();
            List<Cliente> listac = modelo.listaclientesTabla();

            listac.stream().forEach(persona -> {

                if (persona.getPer_cedula().equals(vista.getTblClientes().getValueAt(fila, 0).toString())) {
                    vista.getTxtcedula().setText(persona.getPer_cedula());
                    vista.getTxtnombre().setText(persona.getPer_nombre());
                    vista.getTxtapellido().setText(persona.getPer_apellido());
                    vista.getFechanacimiento().setDate(persona.getPer_fechaNac());
                    vista.getTxttelefono().setText(persona.getPer_telefono());
                    vista.getTxtdireccion().setText(persona.getPer_direccion());

                }
            });
        }
    }

    public void botonCancelar() {
        vista.getjDcliente().setVisible(false);
    }

    public boolean crearCliente() {

        boolean crearCliente = false;
        //Insertar persona

        if (modelo.validarRepetidoscl(Integer.parseInt(vista.getTxtcedula().getText())) == 0) {

            if (validarDatosCLIENTE()) {

                modelo_cliente personac = new modelo_cliente();

                //vista.getTxtcedula().setText(persona.getPer_cedula());
                personac.setPer_cedula(vista.getTxtcedula().getText());
                personac.setPer_nombre(vista.getTxtnombre().getText());
                personac.setPer_apellido(vista.getTxtapellido().getText());
                Date fecha = vista.getFechanacimiento().getDate();
                java.sql.Date fechaSQL = new java.sql.Date(fecha.getDate());
                personac.setPer_nombre(vista.getTxtnombre().getText());
                personac.setPer_fechaNac(fechaSQL);
                personac.setPer_telefono(vista.getTxttelefono().getText());
                personac.setPer_direccion(vista.getTxtdireccion().getText());
                personac.setCli_codper(Integer.parseInt(vista.getTxtcodper().getText()));
               Date fechai = vista.getFechaing().getDate();
                java.sql.Date fechaSQL1 = new java.sql.Date(fechai.getDate());
                              personac.setFecha_ingreso(fechaSQL1);

                if (personac.crearCliente() == null) {
                    JOptionPane.showMessageDialog(null, "Persona creada");
                    // System.out.println("Persona creada satisfactoriamente");
                    crearCliente = true;
                } else {
                    System.out.println("La persona NO se pudo crear");
                }
            }
        } else {

            JOptionPane.showMessageDialog(null, "El numero de cedula ya se encuentra registrado");
        }

        return crearCliente;

    }

    public boolean validarDatosCLIENTE() {
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
        if (vista.getFechanacimiento().getDate() == null) {
            JOptionPane.showMessageDialog(null, "Ingrese la fecha fecha de nacimiento");
            validar = false;
        } else {

            LocalDate fechaNueva = vista.getFechanacimiento().getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); //Paso la fecha de nacimiento de tipo Date a tipo LocalDate

            if (Period.between(fechaNueva, LocalDate.now()).getYears() < 5) { //Comparo si la persona es mayor a 5 años
                JOptionPane.showMessageDialog(null, "Debe tener mas de 5 años");
                validar = false;
            } else {
                if (Period.between(fechaNueva, LocalDate.now()).getYears() > 70) { //Comparo si la persona tiene menos de 70 años
                    JOptionPane.showMessageDialog(null, "Fecha incorrecta. Usted sobrepasa los 70 años");
                    validar = false;
                }
            }
        }

        return validar;
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

                DefaultTableModel tblModel;
                tblModel = (DefaultTableModel) vista.getTblClientes().getModel();
                tblModel.setNumRows(0);//limpio filas de la tabla.

                List<Cliente> listac = modelo.buscarcliente(Integer.parseInt(vista.getBtnBuscarPersona().getText()));//Enlazo al Modelo y obtengo los datos
                Holder<Integer> i = new Holder<>(0);//Contador para las filas. 'i' funciona dentro de una expresion lambda

                listac.stream().forEach(pe -> {

                    tblModel.addRow(new Object[9]);
                    vista.getTblClientes().setValueAt(pe.getCliente_codigo(), i.value, 0);
            vista.getTblClientes().setValueAt(pe.getFecha_ingreso(), i.value, 1);
            vista.getTblClientes().setValueAt(pe.getCli_codper(), i.value, 2);
                    i.value++;
                });
            }
        };

        vista.getBtnBuscarPersona().addKeyListener(eventoTeclado); //"addKeyListener" es un metodo que se le tiene que pasar como argumento un objeto de tipo keyListener 
    }

    public boolean validarDatosPersona() {
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
        if (vista.getFechanacimiento().getDate() == null) {
            JOptionPane.showMessageDialog(null, "Ingrese la fecha fecha de nacimiento");
            validar = false;
        } else {

            LocalDate fechaNueva = vista.getFechanacimiento().getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); //Paso la fecha de nacimiento de tipo Date a tipo LocalDate

            if (Period.between(fechaNueva, LocalDate.now()).getYears() < 5) { //Comparo si la persona es mayor a 5 años
                JOptionPane.showMessageDialog(null, "Debe tener mas de 5 años");
                validar = false;
            } else {
                if (Period.between(fechaNueva, LocalDate.now()).getYears() > 70) { //Comparo si la persona tiene menos de 70 años
                    JOptionPane.showMessageDialog(null, "Fecha incorrecta. Usted sobrepasa los 70 años");
                    validar = false;
                }
            }
        }

        return validar;
    }

    

}

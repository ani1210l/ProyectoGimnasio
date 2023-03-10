package Controlador;

import Modelo.ModeloPersona;
import Modelo.Persona;
import Vista.VistaPersona;
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
 * @author Usuario
 */
public class ControladorPersona {

    private ModeloPersona modelo;
    private VistaPersona vista;

    //static boolean asignar; //Esta variable es de tipo static para que funcione dentro de la expresion lambda. Esta variable sera true o false dependiendo si la persona es o no docente
    VistaPrincipal p = new VistaPrincipal();

    public ControladorPersona(ModeloPersona modelo, VistaPersona vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);

        vista.setSize(p.getjDesktopPane().getWidth(), p.getjDesktopPane().getHeight());
        vista.getjDlogRegistroPersona().setResizable(true);
        cargarPersonasTabla();

    }

    public void iniciarControl() {
        vista.getjDlogRegistroPersona().setSize(875, 623);

        vista.getJButtonCrearPersona().addActionListener(l -> abrirDlgPersonas());
        vista.getJButtonAcuatlizarPersona().addActionListener(l -> cargarPersonasTabla());
        vista.getJButtonModificarPersona().addActionListener(l -> cargarDatosPersonaEnTXT());
        vista.getjButtonCancelar().addActionListener(l -> botonCancelar());
        vista.getjButtonGuardar().addActionListener(l -> crearPersona());
        buscarPersona();
    }

    public void abrirDlgPersonas() {

        vista.getjDlogRegistroPersona().setName("Crear nueva persona");
        vista.getjDlogRegistroPersona().setSize(875, 623);
        vista.getjDlogRegistroPersona().setTitle("Crear nueva persona");
        vista.getjDlogRegistroPersona().setVisible(true);

    }

    private void crearEditarCurso() {
        if ("Crear nueva persona".equals(vista.getjDlogRegistroPersona().getName())) {

            //INSERTAR
            if (validarDatosPersona()) {
                ModeloPersona per = new ModeloPersona();
                per.setPer_nombre(vista.getTxtnombre().getText());
                per.setPer_apellido(vista.getTxtapellido().getText());
                per.setPer_telefono(vista.getTxttelefono().getText());
                per.setPer_direccion(vista.getTxtdireccion().getText());

                java.sql.Date fechanac = new java.sql.Date(vista.getFechanacimiento().getDate().getTime());//Paso de util.Date a sql.Date

                per.setPer_fechaNac(fechanac);

                if (per.crearPersona() == null) {
                    vista.getjDlogRegistroPersona().setVisible(false);
                    JOptionPane.showMessageDialog(vista, "Persona creada satisfactoriamente");
                    cargarPersonasTabla();
                } else {
                    JOptionPane.showMessageDialog(vista, "No se pudo crear el curso");
                }
            }

        }
    }

    public void cargarPersonasTabla() {
        DefaultTableModel tblModel;
        tblModel = (DefaultTableModel) vista.getJTablePersonas().getModel();
        tblModel.setNumRows(0);//limpio filas de la tabla.

        List<Persona> listap = modelo.listaPersonasTabla();//Enlazo al Modelo y obtengo los datos
        Holder<Integer> i = new Holder<>(0);//Contador para las filas. 'i' funciona dentro de una expresion lambda

        listap.stream().forEach(pe -> {

            tblModel.addRow(new Object[9]);//Creo una fila vacia
            vista.getJTablePersonas().setValueAt(pe.getPer_cedula(), i.value, 0);
            vista.getJTablePersonas().setValueAt(pe.getPer_nombre(), i.value, 1);
            vista.getJTablePersonas().setValueAt(pe.getPer_apellido(), i.value, 2);
            vista.getJTablePersonas().setValueAt(pe.getPer_fechaNac(), i.value, 3);
            vista.getJTablePersonas().setValueAt(pe.getPer_telefono(), i.value, 4);
            vista.getJTablePersonas().setValueAt(pe.getPer_direccion(), i.value, 5);

            i.value++;
        });
    }

    public void cargarDatosPersonaEnTXT() {
        int fila = vista.getJTablePersonas().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {

            //Abrir jDialog de campos de Docente
            vista.getjDlogRegistroPersona().setName("Modificar persona");
            vista.getjDlogRegistroPersona().setLocationRelativeTo(null);
            vista.getjDlogRegistroPersona().setSize(802, 622);
            vista.getjDlogRegistroPersona().setTitle("Modificar  persona");
            vista.getjDlogRegistroPersona().setVisible(true);

            //ModeloPersona modeloPersona = new ModeloPersona();
            List<Persona> listap = modelo.listaPersonasTabla();

            listap.stream().forEach(persona -> {

                if (persona.getPer_cedula().equals(vista.getJTablePersonas().getValueAt(fila, 0).toString())) {
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
        public boolean crearPersona() {

        boolean crearPersona = false;
        //Insertar persona
        if (modelo.validarRepetidos(vista.getTxtcedula().getText()) == 0) {

            if (validarDatosPersona()) {

                ModeloPersona persona = new ModeloPersona();

                //vista.getTxtcedula().setText(persona.getPer_cedula());
                persona.setPer_cedula(vista.getTxtcedula().getText());
                persona.setPer_nombre(vista.getTxtnombre().getText());
                persona.setPer_apellido(vista.getTxtapellido().getText());
                Date fecha = vista.getFechanacimiento().getDate();
                java.sql.Date fechaSQL = new java.sql.Date(fecha.getDate());
                persona.setPer_fechaNac(fechaSQL);
                persona.setPer_telefono(vista.getTxttelefono().getText());
                persona.setPer_direccion(vista.getTxtdireccion().getText());

                if (persona.crearPersona() == null) {
                    JOptionPane.showMessageDialog(null, "Persona creada");
                    // System.out.println("Persona creada satisfactoriamente");
                    crearPersona = true;
                } else {
                    System.out.println("La persona NO se pudo crear");
                }
            }
        } else {

            JOptionPane.showMessageDialog(null, "El numero de cedula ya se encuentra registrado");
        }

        return crearPersona;
    }
    public void modificarPersona() {
        if (validarDatosPersona()) {
            ModeloPersona persona = new ModeloPersona();

            //Setear los datos de persona
            persona.setPer_cedula(vista.getTxtcedula().getText());
            persona.setPer_nombre(vista.getTxtnombre().getText());
            persona.setPer_apellido(vista.getTxtapellido().getText());

            Date fecha = vista.getFechanacimiento().getDate();
            java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
            persona.setPer_fechaNac(fechaSQL);

            persona.setPer_telefono(vista.getTxttelefono().getText());
            persona.setPer_direccion(vista.getTxtdireccion().getText());

            if (persona.modificarPersona() == null) {
                JOptionPane.showMessageDialog(null, "Datos modificados exitosamente");
                vista.getjDlogRegistroPersona().setVisible(false);
                cargarPersonasTabla();
            } else {
                JOptionPane.showMessageDialog(null, "No fue posible modificar los datos");
            }
        }
    }

//else hacemos el editar
    //EDITAR
    public void buscarPersona() {

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
                tblModel = (DefaultTableModel) vista.getJTablePersonas().getModel();
                tblModel.setNumRows(0);//limpio filas de la tabla.

                List<Persona> listap = modelo.buscarPersona(vista.getJTextFieldBuscarPersona().getText());//Enlazo al Modelo y obtengo los datos
                Holder<Integer> i = new Holder<>(0);//Contador para las filas. 'i' funciona dentro de una expresion lambda

                listap.stream().forEach(pe -> {

                    tblModel.addRow(new Object[9]);
                    vista.getJTablePersonas().setValueAt(pe.getPer_cedula(), i.value, 0);
                    vista.getJTablePersonas().setValueAt(pe.getPer_nombre(), i.value, 1);
                    vista.getJTablePersonas().setValueAt(pe.getPer_apellido(), i.value, 2);
                    vista.getJTablePersonas().setValueAt(pe.getPer_telefono(), i.value, 3);
                    vista.getJTablePersonas().setValueAt(pe.getPer_direccion(), i.value, 4);

                    i.value++;
                });
            }
        };

        vista.getJTextFieldBuscarPersona().addKeyListener(eventoTeclado); //"addKeyListener" es un metodo que se le tiene que pasar como argumento un objeto de tipo keyListener 
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

            if (Period.between(fechaNueva, LocalDate.now()).getYears() < 5) { //Comparo si la persona es mayor a 5 a??os
                JOptionPane.showMessageDialog(null, "Debe tener mas de 5 a??os");
                validar = false;
            } else {
                if (Period.between(fechaNueva, LocalDate.now()).getYears() > 70) { //Comparo si la persona tiene menos de 70 a??os
                    JOptionPane.showMessageDialog(null, "Fecha incorrecta. Usted sobrepasa los 70 a??os");                    validar = false;
                }
            }
        }

        return validar;
    }

    public void botonCancelar() {
        vista.getjDlogRegistroPersona().setVisible(false);
    }

}

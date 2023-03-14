package Controlador;

import Controlador.Validaciones;
import Modelo.ModeloEmpleado;
import Modelo.ModeloPersona;
import Modelo.Modelo_nutri;
import Modelo.Nutricionista;
import Vista.VistaNutricionista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
 * @author miche
 */
public class ControlNutricionista implements ActionListener{
    
    private VistaNutricionista vista;
    private Modelo_nutri modelo;
    
       
    
     VistaNutricionista viewnutri = new VistaNutricionista();

    public ControlNutricionista(VistaNutricionista vista, Modelo_nutri modelo) {
        this.vista = vista;
        this.modelo = modelo;
        
        vista.setVisible(true);
        
        vista.getDlgcreanutricionista().setResizable(true);
        cargarNutricionistaTabla();
        
    }

    public void iniciarControl() {

        vista.getDlgcreanutricionista().setSize(875, 623);

        vista.getBtnCrearnutri().addActionListener(l -> abrirDlgPersonas());
        vista.getBtnActualizarnutri().addActionListener(l -> cargarNutricionistaTabla());
        vista.getBtnModificarnutri().addActionListener(l -> cargarDatosNutriEnTXT());
        vista.getBtncancelar().addActionListener(l -> botonCancelar());
        vista.getBtnguardar().addActionListener(l -> crearNutricionista());
        buscarNutricionista();
    }

    public void abrirDlgPersonas() {

        vista.getDlgcreanutricionista().setName("Crear nuevo Nutricionista");
        vista.getDlgcreanutricionista().setSize(875, 623);
        vista.getDlgcreanutricionista().setTitle("Crear nuevo Nutricionista");
        vista.getDlgcreanutricionista().setVisible(true);

    }

 ////////////////////////////////////////////////////////////////////////////////////////////////
    
    private void crearEditarNutricionista() {
        
        if ("Crear nuevo Nutricionista".equals(vista.getDlgcreanutricionista().getName())) {

            //INSERTAR
            if (validarDatosNutricionista()) {
                
                Modelo_nutri nutricionista = new Modelo_nutri();
                
                nutricionista.setPer_cedula(vista.getTxtcedulanutri().getText());
                nutricionista.setPer_nombre(vista.getTxtNombreNutri().getText());
                nutricionista.setPer_apellido(vista.getTxtapellidonutri().getText());
                nutricionista.setPer_telefono(vista.getTxttelefononutri().getText());
                nutricionista.setPer_direccion(vista.getTxtdirecnutri().getText());

                java.sql.Date fechanacnutri = new java.sql.Date(vista.getJfechanacimnutri().getDate().getTime());

                nutricionista.setPer_fechaNac(fechanacnutri);

                if (nutricionista.crearNutricionista() == null) {
                    vista.getDlgcreanutricionista().setVisible(false);
                    JOptionPane.showMessageDialog(vista, "Nutricionista creado exitosamente");
                    cargarNutricionistaTabla();
                } else {
                    JOptionPane.showMessageDialog(vista, "No se pudo crear el nutricionista");
                }
            }

        }
    }

    public void cargarNutricionistaTabla() {
        DefaultTableModel tblModel;
        tblModel = (DefaultTableModel) vista.getTblNutricionista().getModel();
        tblModel.setNumRows(0);

        List<Nutricionista> listanutri = modelo.listaNutricionistaTabla();
        Holder<Integer> i = new Holder<>(0);

        listanutri.stream().forEach(nutri -> {

            tblModel.addRow(new Object[3]);//Creo una fila vacia
            vista.getTblNutricionista().setValueAt(nutri.getNutricionista_codigo(), i.value, 0);
            vista.getTblNutricionista().setValueAt(nutri.getRutina(), i.value, 1);
            vista.getTblNutricionista().setValueAt(nutri.getEmpleado_codigo(), i.value, 2);

            i.value++;
        });
    }

    public void cargarDatosNutriEnTXT() {
        
        int fila = vista.getTblNutricionista().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {

            vista.getDlgcreanutricionista().setName("Modificar Nutricionista");
            vista.getDlgcreanutricionista().setLocationRelativeTo(null);
            vista.getDlgcreanutricionista().setSize(802, 622);
            vista.getDlgcreanutricionista().setTitle("Modificar  Nutricionista");
            vista.getDlgcreanutricionista().setVisible(true);

            
            List<Nutricionista> listanutri = modelo.listaNutricionistaTabla();

            listanutri.stream().forEach(nutricionista -> {

                String codigo = Integer.toString((int) vista.getTblNutricionista().getValueAt(fila, 0));

                                
                if (codigo.equals(vista.getTblNutricionista().getValueAt(fila, 0).toString())) {
                    
       ////////////////////CODIGO PERSONA
                    vista.getTxtcedulanutri().setText(nutricionista.getPer_cedula());
                    vista.getTxtNombreNutri().setText(nutricionista.getPer_nombre());
                    vista.getTxtapellidonutri().setText(nutricionista.getPer_apellido());
                    vista.getJfechanacimnutri().setDate(nutricionista.getPer_fechaNac());
                    vista.getTxttelefononutri().setText(nutricionista.getPer_telefono());
                    vista.getTxtdirecnutri().setText(nutricionista.getPer_direccion());
       /////////////////CODIGO EMPLEADO             
       /////////////////SALARIO EMPLEADO
       /////////////////HORARIO EMPLEADO
       ////////////////CODIGO NUTRICIONISTA
                    vista.getTxtrutina().setText(nutricionista.getRutina());            

                }
            });
        }
    }

    public boolean crearNutricionista() {

        boolean crearNutrici = false;
        //Insertar persona
        
        if (modelo.validarRepetidos(Integer.parseInt(vista.getTxtcedulanutri().getText())) == 0) {

            if (validarDatosNutricionista()) {
                
                ModeloPersona persona = new ModeloPersona();
                ModeloEmpleado empleado = new ModeloEmpleado();
                Modelo_nutri nutri = new Modelo_nutri();
                  
                
                persona.setPer_cedula(vista.getTxtcedulanutri().getText());
                persona.setPer_nombre(vista.getTxtNombreNutri().getText());
                persona.setPer_apellido(vista.getTxtapellidonutri().getText());
                Date fecha = vista.getJfechanacimnutri().getDate();
                java.sql.Date fechaSQL = new java.sql.Date(fecha.getDate());
                persona.setPer_fechaNac(fechaSQL);
                persona.setPer_telefono(vista.getTxttelefononutri().getText());
                persona.setPer_direccion(vista.getTxtdirecnutri().getText());
                int codempleado = Integer.valueOf(vista.getTxtcodempleado().getText());
                empleado.setEmpleado_codigo(codempleado);
                double salarioempleado = Double.valueOf(vista.getTxtsalarionutri().getText());
                empleado.setSalario_emp(salarioempleado);
                
               ////////////////////HORARIO///////////////////////
                
                int codnutr = Integer.valueOf(vista.getTxtcodnutri().getText());
                nutri.setNutricionista_codigo(codnutr);
                nutri.setRutina(vista.getTxtrutina().getText());                
                
///////////////////////////////////////////////////////////
                
                if (persona.crearPersona() == null) {
                    JOptionPane.showMessageDialog(null, "Persona creada");
                    // System.out.println("Persona creada satisfactoriamente");
                    crearNutrici = true;
                } else {
                    System.out.println("La persona NO se pudo crear");
                }
            }
        } else {

            JOptionPane.showMessageDialog(null, "El numero de cedula ya se encuentra registrado");
        }

        return crearNutrici;
    }

    public void modificarPersona() {
        if (validarDatosNutricionista()) {
                ModeloPersona persona = new ModeloPersona();
                ModeloEmpleado empleado = new ModeloEmpleado();
                Modelo_nutri nutri = new Modelo_nutri();
            

/////////////////////////CODIGOPERSONA  ???????

                persona.setPer_cedula(vista.getTxtcedulanutri().getText());
                persona.setPer_nombre(vista.getTxtNombreNutri().getText());
                persona.setPer_apellido(vista.getTxtapellidonutri().getText());
                Date fecha = vista.getJfechanacimnutri().getDate();
                java.sql.Date fechaSQL = new java.sql.Date(fecha.getDate());
                persona.setPer_fechaNac(fechaSQL);
                persona.setPer_telefono(vista.getTxttelefononutri().getText());
                persona.setPer_direccion(vista.getTxtdirecnutri().getText());
                int codempleado = Integer.valueOf(vista.getTxtcodempleado().getText());
                empleado.setEmpleado_codigo(codempleado);
                double salarioempleado = Double.valueOf(vista.getTxtsalarionutri().getText());
                empleado.setSalario_emp(salarioempleado);
                
               ////////////////////HORARIO///////////////////////
                
                int codnutr = Integer.valueOf(vista.getTxtcodnutri().getText());
                nutri.setNutricionista_codigo(codnutr);
                nutri.setRutina(vista.getTxtrutina().getText()); 

            if (persona.modificarPersona() == null) {
                JOptionPane.showMessageDialog(null, "Datos modificados exitosamente");
                vista.getDlgcreanutricionista().setVisible(false);
                cargarNutricionistaTabla();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo modificar los datos");
            }
        }
    }

    //EDITAR
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

                DefaultTableModel tblModel;
                tblModel = (DefaultTableModel) vista.getTblNutricionista().getModel();
                tblModel.setNumRows(0);//limpio filas de la tabla.

                int codnutricionista = Integer.valueOf(vista.getTxtBuscar().getText());
                List<Nutricionista> listap = modelo.buscarNutri(codnutricionista);
                Holder<Integer> i = new Holder<>(0);

                listap.stream().forEach(nutri -> {

                    tblModel.addRow(new Object[9]);
                    vista.getTblNutricionista().setValueAt(nutri.getNutricionista_codigo(), i.value, 0);
                    vista.getTblNutricionista().setValueAt(nutri.getRutina(), i.value, 1);
                    vista.getTblNutricionista().setValueAt(nutri.getEmpleado_codigo(), i.value, 2);

                    i.value++;
                });
            }
        };

        vista.getTxtBuscar().addKeyListener(eventoTeclado); 
    }

    public boolean validarDatosNutricionista() {
        Validaciones mivalidacion = new Validaciones();

        boolean validar = true;

        if (vista.getTxtNombreNutri().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese su nombre");
            validar = false;
        } else {
            if (!mivalidacion.validarTextoSinEspacio(vista.getTxtNombreNutri().getText())) {
                JOptionPane.showMessageDialog(null, "Nombre incorrecto");
                validar = false;
            }
        }

        if (vista.getTxtapellidonutri().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese su apellido");
            validar = false;
        } else {
            if (!mivalidacion.validarTextoSinEspacio(vista.getTxtapellidonutri().getText())) {
                JOptionPane.showMessageDialog(null, "Apellido incorrecto");
                validar = false;
            }
        }

        if (vista.getTxttelefononutri().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese su numero de telefono");
            validar = false;
        } else {
            if (!mivalidacion.validarTelefono(vista.getTxttelefononutri().getText())) {
                JOptionPane.showMessageDialog(null, "Telefono incorrecto");
                validar = false;
            }
        }

        if (vista.getTxtdirecnutri().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese su direccion");
            validar = false;
        } else {
            if (!mivalidacion.validarDireccion(vista.getTxtdirecnutri().getText())) {
                JOptionPane.showMessageDialog(null, "Direccion incorrecta");
                validar = false;
            }
        }
        if (vista.getJfechanacimnutri().getDate() == null) {
            JOptionPane.showMessageDialog(null, "Ingrese su fecha fecha de nacimiento");
            validar = false;
        } else {

            LocalDate fechaNueva = vista.getJfechanacimnutri().getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); //Paso la fecha de nacimiento de tipo Date a tipo LocalDate

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

    public void botonCancelar() {
        vista.getDlgcreanutricionista().setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
////michelle
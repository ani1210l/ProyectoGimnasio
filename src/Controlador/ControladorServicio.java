
package Controlador;

import Controlador.Validaciones;
import Modelo.Modelo_Servicio;
import Modelo.Nutricionista;
import Modelo.Servicio;
import Vista.VistaServicios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;

/**xvbn
 *
 * @author Michelle
 */
public class ControladorServicio implements ActionListener {

    private VistaServicios vista;
    private Modelo_Servicio modelo;

//    VistaServicios viewservicio = new VistaServicios();

    public ControladorServicio(VistaServicios vista, Modelo_Servicio modelo) {
        this.vista = vista;
        this.modelo = modelo;
        vista.setVisible(true);
        
        this.vista.getGroupServicio().add(vista.getCardio());
        this.vista.getGroupServicio().add(vista.getBaiolo());
        this.vista.getGroupServicio().add(vista.getPesas());

    }

    public void iniciarControl() {

        vista.getDlgServicio().setSize(875, 623);

        vista.getBtnCrearservicios().addActionListener(l -> abrirDlgPersonas());
        vista.getBtnActualizarservicios().addActionListener(l -> cargarServicioTabla());
        vista.getBtnModificarservicios().addActionListener(l -> cargarServicioEnTXT());
        vista.getBtncancelarser().addActionListener(l -> botonCancelarServ());
        vista.getBtnguardarser().addActionListener(l -> crearServicio());
        buscarServicio();
    }

    public void abrirDlgPersonas() {

        vista.getDlgServicio().setName("Crear Servicio");
        vista.getDlgServicio().setSize(875, 623);
        vista.getDlgServicio().setTitle("Crear Servicio");
        vista.getDlgServicio().setVisible(true);

    }

 /////////////////////////////////////////////////////////////////////////////////////777
    public String eleccionServicio() {

        String servicio = null;
        if (vista.getCardio().isSelected()) {
            servicio = "Cardio";
        }
        if (vista.getBaiolo().isSelected()) {
            servicio = "Bailoterapia";
        }
        if (vista.getPesas().isSelected()) {
            servicio = "Levantamiento Pesas";
        }
        return servicio;
    }

    private void crearEditarServicio() {

        if ("Crear nuevo Servicio".equals(vista.getDlgServicio().getName())) {

            //INSERTAR
            if (validarDatosServicio()) {

                Modelo_Servicio servicio = new Modelo_Servicio();
                int codservicio = Integer.valueOf(vista.getTxtcodservicio().getText());
                servicio.setSer_codigo(codservicio);
                servicio.setServ_tipo(eleccionServicio());
                String horario = vista.getCmbhorario().getSelectedItem().toString();
                servicio.setSer_hora(horario);
                servicio.setServ_detalle(vista.getTxtdetalle().getText());
                java.sql.Date fechaingreso = new java.sql.Date(vista.getFechaservicio().getDate().getTime());
                servicio.setServ_fechaIngreso(fechaingreso);

                if (servicio.crearServicio() == null) {
                    vista.getDlgServicio().setVisible(false);
                    JOptionPane.showMessageDialog(vista, "Servicio creado exitosamente");
                    cargarServicioTabla();
                } else {
                    JOptionPane.showMessageDialog(vista, "No se pudo crear el servicio");
                }
            }

        }
    }

    public void cargarServicioTabla() {
        DefaultTableModel tblModel;
        tblModel = (DefaultTableModel) vista.getTblservicios().getModel();
        tblModel.setNumRows(0);

        List<Servicio> listaservicio = modelo.listaserviciosTabla();
        Holder<Integer> i = new Holder<>(0);

        listaservicio.stream().forEach(serv -> {

            tblModel.addRow(new Object[3]);
            vista.getTblservicios().setValueAt(serv.getSer_codigo(), i.value, 0);
            vista.getTblservicios().setValueAt(serv.getServ_tipo(), i.value, 1);
            vista.getTblservicios().setValueAt(serv.getSer_hora(), i.value, 2);
            vista.getTblservicios().setValueAt(serv.getServ_detalle(), i.value, 2);
            vista.getTblservicios().setValueAt(serv.getServ_fechaIngreso(), i.value, 2);
            i.value++;
        });
    }

    //////////////////////////////// NO ESTA HECHO
    public void cargarServicioEnTXT() {

        int fila = vista.getTblservicios().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {

            vista.getDlgServicio().setName("Modificar Servicio");
            vista.getDlgServicio().setLocationRelativeTo(null);
            vista.getDlgServicio().setSize(802, 622);
            vista.getDlgServicio().setTitle("Modificar Servicio");
            vista.getDlgServicio().setVisible(true);

            List<Servicio> listanutri = modelo.listaserviciosTabla();

            listanutri.stream().forEach(servicio -> {

                String codigo = Integer.toString((int) vista.getTblservicios().getValueAt(fila, 0));

                if (codigo.equals(vista.getTblservicios().getValueAt(fila, 0).toString())) {

 ////////////////// vista.getTxtcodservicio().setText(nutricionista.getSer_codigo());
                }
            });
        }
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////

    public boolean crearServicio() {

        boolean crearServicio = false;
        //Insertar persona

      

        if (modelo.validarRepetidoscl(Integer.parseInt(vista.getTxtcodservicio().getText())) == 0) {

            if (validarDatosServicio()) {

                Modelo_Servicio servicio = new Modelo_Servicio();

                int codservicio = Integer.valueOf(vista.getTxtcodservicio().getText());
                servicio.setSer_codigo(codservicio);
                servicio.setServ_tipo(eleccionServicio());
                String horario = vista.getCmbhorario().getSelectedItem().toString();
                servicio.setSer_hora(horario);
                servicio.setServ_detalle(vista.getTxtdetalle().getText());
                Date fecha = vista.getFechaservicio().getDate();
                java.sql.Date fechaSQL = new java.sql.Date(fecha.getDate());
                servicio.setServ_fechaIngreso(fechaSQL);

                if (servicio.crearServicio() == null) {
                    JOptionPane.showMessageDialog(null, "Servicio creado");
                    crearServicio = true;
                } else {
                    System.out.println("El servicio no se pudo crear");
                }
            }
        } else {

            JOptionPane.showMessageDialog(null, "El codigo del servicio ya se encuentra registrado");
        }

        return crearServicio;
    }

    public void modificarServicio() {
        if (validarDatosServicio()) {

            Modelo_Servicio servicio = new Modelo_Servicio();

            int codservicio = Integer.valueOf(vista.getTxtcodservicio().getText());
            servicio.setSer_codigo(codservicio);
            servicio.setServ_tipo(eleccionServicio());
            String horario = vista.getCmbhorario().getSelectedItem().toString();
            servicio.setSer_hora(horario);
            servicio.setServ_detalle(vista.getTxtdetalle().getText());
            Date fecha = vista.getFechaservicio().getDate();
            java.sql.Date fechaSQL = new java.sql.Date(fecha.getDate());
            servicio.setServ_fechaIngreso(fechaSQL);

            if (servicio.modificarServicio() == null) {
                JOptionPane.showMessageDialog(null, "Datos modificados exitosamente");
                vista.getDlgServicio().setVisible(false);
                cargarServicioTabla();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo modificar los datos");
            }
        }
    }

    //EDITAR
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

                DefaultTableModel tblModel;
                tblModel = (DefaultTableModel) vista.getTblservicios().getModel();
                tblModel.setNumRows(0);

                int codservicio = Integer.valueOf(vista.getTxtBuscar().getText());
                List<Servicio> listap = modelo.buscarServicio(codservicio);
                Holder<Integer> i = new Holder<>(0);

                listap.stream().forEach(servicio -> {

                    tblModel.addRow(new Object[9]);
                    vista.getTblservicios().setValueAt(servicio.getSer_codigo(), i.value, 0);
                    vista.getTblservicios().setValueAt(servicio.getServ_tipo(), i.value, 1);
                    vista.getTblservicios().setValueAt(servicio.getSer_hora(), i.value, 2);
                    vista.getTblservicios().setValueAt(servicio.getServ_detalle(), i.value, 2);
                    vista.getTblservicios().setValueAt(servicio.getServ_fechaIngreso(), i.value, 2);

                    i.value++;
                });
            }
        };

        vista.getTxtBuscar().addKeyListener(eventoTeclado);
    }

    public boolean validarDatosServicio() {
        Validaciones valid = new Validaciones();

        boolean validar = true;

        if (vista.getGroupServicio().isSelected(null)) {
            JOptionPane.showMessageDialog(null, "Seleccione un servicio");
            validar = false;
        }
        if (vista.getTxtdetalle().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Agregue un detalle");
            validar = false;
        } else {
            if (!valid.validarTelefono(vista.getTxtdetalle().getText())) {
                JOptionPane.showMessageDialog(null, "Detalle incorrecto");
                validar = false;
            }
        }
        if (vista.getFechaservicio().getDate() == null) {
            JOptionPane.showMessageDialog(null, "Ingrese la fecha de ingreso");
            validar = false;
        } else {

            LocalDate fechaNueva = vista.getFechaservicio().getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); 
            
        }

        return validar;
    }

    public void botonCancelarServ() {
        vista.getDlgServicio().setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//luish
}

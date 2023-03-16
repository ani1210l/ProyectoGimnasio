package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Administrador;
import modelo.ModeloAdministrador;
import vista.Login;
import vista.VistaPrincipal;

/**
 *
 * @author miche
 */
public class ControladorLogin {
    Login vista;
    
    static boolean encontrar;
    static String usuario;

    public ControladorLogin(Login vista) {
        this.vista = vista;
        vista.setVisible(true);
    }
    
    public void iniciarControl() {
        vista.getBtniniciar().addActionListener(l -> login());
        vista.getTxtcontra().setText("");
        vista.getLbocultar().setVisible(true);
        vista.getLbmostrar().setVisible(false);
        verContrasenia();
        ocultarContrasenia();
    }

    public void login() {
        encontrar = false;

        ModeloAdministrador admin = new ModeloAdministrador();
        List<Administrador> listAdmin = admin.listaAdminTabla();
  

        listAdmin.stream().forEach(a -> {

            if (a.getAdm_usuario().equals(vista.getTxtusuario().getText()) && a.getAdm_clave().equals(vista.getTxtcontra().getText())) {
                vista.setVisible(false);//Cierro la ventana del login y abro la ventana principal 
                encontrar = true;//El usuario y la contraseña ingresados por el usuario son iguales a los que estan en la BD

                VistaPrincipal vistaPrincipal = new VistaPrincipal();
                ControladorPrincipal control = new ControladorPrincipal(vistaPrincipal);
                control.iniciarControl();

                usuario = vista.getTxtusuario().getText();//Guardo el usuario para luego usarlo en la matricula
                System.out.println("Usuario login: " + usuario);
            }
        });

        if (!encontrar) {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecto");
        }
    }

    public void verContrasenia() {
        MouseListener evento = new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                vista.getTxtcontra().setEchoChar('●');
                vista.getLbocultar().setVisible(true);
                vista.getLbmostrar().setVisible(false);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };

        vista.getLbmostrar().addMouseListener(evento);
    }

    public void ocultarContrasenia() {
        MouseListener evento = new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent e) {

                vista.getTxtcontra().setEchoChar((char) 0);
                vista.getLbmostrar().setVisible(true);
                vista.getLbocultar().setVisible(false);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };

        vista.getLbocultar().addMouseListener(evento);
    }
    

    
}

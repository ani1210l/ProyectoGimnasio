package main;

import controlador.ControladorLogin;
import vista.VistaLogin;

public class inicio {

    public static void main(String[] args) {
//        VistaPrincipal vistaPrincipal = new VistaPrincipal();
//
//        ControladorPrincipal control = new ControladorPrincipal(vistaPrincipal);
//        control.iniciarControl();

        VistaLogin vistaLogin = new VistaLogin();
        ControladorLogin control = new ControladorLogin(vistaLogin);
        control.iniciarControl();
    }
}

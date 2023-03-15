package main;

import controlador.ControladorPrincipal;
import vista.VistaPrincipal;

public class inicio {

    public static void main(String[] args) {
        VistaPrincipal vistaPrincipal = new VistaPrincipal();

        ControladorPrincipal control = new ControladorPrincipal(vistaPrincipal);
        control.iniciarControl();
    }
}

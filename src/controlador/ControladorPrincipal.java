package controlador;

import modelo.ModeloInstructor;
import vista.VistaInstructor;
import vista.VistaPrincipal;

public class ControladorPrincipal {

    VistaPrincipal vistaPrincipal;

    public ControladorPrincipal(VistaPrincipal vistaPrincipal) {
        this.vistaPrincipal = vistaPrincipal;
        vistaPrincipal.setVisible(true);
    }

    public void iniciarControl() {
        vistaPrincipal.getBtnInstructor().addActionListener(l -> crudInstructor());
    }

    public void crudInstructor() {
        //Instancio las clases del Modelo y la Vista.
        VistaInstructor vista = new VistaInstructor();
        ModeloInstructor modelo = new ModeloInstructor();

        //Agregar Vista Personas al Desktop Pane.
        vistaPrincipal.getEscritorioPrincipal().add(vista);

        ControladorInstructor control = new ControladorInstructor(modelo, vista);
        control.iniciarControl();//Empezamos las escuchas a los eventos de la vista, Listeners.
    }
}

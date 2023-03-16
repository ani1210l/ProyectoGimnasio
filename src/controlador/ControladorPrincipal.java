package controlador;

import modelo.ModeloCliente;
import modelo.ModeloInstructor;
import modelo.ModeloNutricionista;
import modelo.ModeloServicio;
import vista.VistaCliente;
import vista.VistaInstructor;
import vista.VistaNutricionista;
import vista.VistaPrincipal;
import vista.VistaServicio;

public class ControladorPrincipal {

    VistaPrincipal vistaPrincipal;

    public ControladorPrincipal(VistaPrincipal vistaPrincipal) {
        this.vistaPrincipal = vistaPrincipal;
        vistaPrincipal.setVisible(true);
    }

    public void iniciarControl() {
        vistaPrincipal.getBtnInstructor().addActionListener(l -> crudInstructor());
        vistaPrincipal.getBtnNutricionista().addActionListener(l -> crudNutricionista());
        vistaPrincipal.getBtnCliente().addActionListener(l -> crudCliente());
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

    public void crudNutricionista() {
        //Instancio las clases del Modelo y la Vista.
        VistaNutricionista vista = new VistaNutricionista();
        ModeloNutricionista modelo = new ModeloNutricionista();

        //Agregar Vista Personas al Desktop Pane.
        vistaPrincipal.getEscritorioPrincipal().add(vista);

        ControladorNutricionista control = new ControladorNutricionista(modelo, vista);
        control.iniciarControl();//Empezamos las escuchas a los eventos de la vista, Listeners.
    }

    public void crudCliente() {
        //Instancio las clases del Modelo y la Vista.
        VistaCliente vista = new VistaCliente();
        ModeloCliente modelo = new ModeloCliente();

        //Agregar Vista Personas al Desktop Pane.
        vistaPrincipal.getEscritorioPrincipal().add(vista);

        ControladorCliente control = new ControladorCliente(modelo, vista);
        control.iniciarControl();//Empezamos las escuchas a los eventos de la vista, Listeners.
    }

    public void crudServicio() {
        //Instancio las clases del Modelo y la Vista.
        VistaServicio vista = new VistaServicio();
        ModeloServicio modelo = new ModeloServicio();

        //Agregar Vista Personas al Desktop Pane.
        vistaPrincipal.getEscritorioPrincipal().add(vista);

        ControladorServicio control = new ControladorServicio(modelo, vista);
        control.iniciarControl();//Empezamos las escuchas a los eventos de la vista, Listeners.
    }
}

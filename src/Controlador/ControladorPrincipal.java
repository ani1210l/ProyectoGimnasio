/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import Vista.VistaPrincipal;
import Vista.VistaPersona;
import Vista.*;
import Vista.VistaCliente;
/**
 *
 * @author Usuario
 */
public class ControladorPrincipal {

    VistaPrincipal vistaPrincipal;

    public ControladorPrincipal(VistaPrincipal vistaPrincipal) {
        this.vistaPrincipal = vistaPrincipal;
        vistaPrincipal.setVisible(true);
        vistaPrincipal.setLocationRelativeTo(null);
    }

    public void iniciaControl() {
        vistaPrincipal.getBtnpersonas().addActionListener(l -> registroPersona());

        vistaPrincipal.getBtnregistrocli().addActionListener(l -> registrocliente());
    }

    private void registroPersona() {

        //vistaPrincipal.getjDesktopPane().removeAll(); //Remuevo todos los elementos que esten en sobre el desktopPane antes de abrir las ventanas
        //Instancio las clases del Modelo y la Vista.
        VistaPersona vistaper = new VistaPersona();
        ModeloPersona modeloper = new ModeloPersona();

        //Agregar Vista Personas al Desktop Pane.
        vistaPrincipal.getjDesktopPane().add(vistaper);

        ControladorPersona controlpers = new ControladorPersona(modeloper, vistaper);
        controlpers.iniciarControl();//Empezamos las escuchas a los eventos de la vista, Listeners.

    }

     private void registrocliente() {

        //vistaPrincipal.getjDesktopPane().removeAll(); //Remuevo todos los elementos que esten en sobre el desktopPane antes de abrir las ventanas
        //Instancio las clases del Modelo y la Vista.
         VistaCliente VISTAC = new VistaCliente();
        modelo_cliente modeloC = new modelo_cliente();

        //Agregar Vista Personas al Desktop Pane.
        vistaPrincipal.getjDesktopPane().add(VISTAC);

        ControladorCliente controlc = new ControladorCliente(modeloC, VISTAC);
        controlc.iniciarControl();//EmpMMMASASMMMMMezamos las escuchas a los eventos de la vista, Listeners.

    }
     
     private void registroEmpleado() {

        //vistaPrincipal.getjDesktopPane().removeAll(); //Remuevo todos los elementos que esten en sobre el desktopPane antes de abrir las ventanas
        //Instancio las clases del Modelo y la Vista.
         VistaEmpleado VISTAC = new VistaEmpleado();
        ModeloEmpleado modeloC = new ModeloEmpleado();

        //Agregar Vista Personas al Desktop Pane.
        vistaPrincipal.getjDesktopPane().add(VISTAC);

        ControladorEmpleado controlc = new ControladorEmpleado(modeloC, VISTAC);
        controlc.iniciarControl();//Empezamos las escuchas a los eventos de la vista, Listeners.

    }

}

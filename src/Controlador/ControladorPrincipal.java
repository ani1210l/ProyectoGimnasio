/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import Vista.VistaPrincipal;
import Vista.VistaPersona;

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
        
       
       
        public void iniciaControl(){
        vistaPrincipal.getBtnpersonas().addActionListener(l->registroPersona());
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
            System.out.println("aaaaaaaaaaa");
        }
        
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloPersona;
import Vista.Menu;
import Vista.VistaPersona;

/**
 *
 * @author Usuario
 */
public class ControladorMenu {
        Menu vistaPrincipal;

    public ControladorMenu(Menu vistaPrincipal) {
        this.vistaPrincipal = vistaPrincipal;
        vistaPrincipal.setVisible(true);
        vistaPrincipal.setLocationRelativeTo(null);
    }
        
       private void registroPersona() {
        vistaPrincipal.getBtnEmpleado().addActionListener(l -> registroPersona());
        VistaPersona vista = new VistaPersona();
        ModeloPersona modelo = new ModeloPersona();

        ControladorPersona control = new ControladorPersona(modelo, vista);
        control.iniciarControl();//Empezamos las escuchas a los eventos de la vista, Listeners.
    }
       
        public void iniciaControl(){
        vistaPrincipal.getBtnEmpleado().addActionListener(l->registroPersona());
    }
}

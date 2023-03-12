/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.proyecto_gimnasio;

import Controlador.ControladorPrincipal;
import Vista.VistaPrincipal;

/**
 *
 * @author frank
 */
public class Proyecto_Gimnasio {

    public static void main(String[] args) {
        VistaPrincipal vistaMenu = new VistaPrincipal();
        ControladorPrincipal control = new ControladorPrincipal(vistaMenu);
        control.iniciaControl();
    }
}

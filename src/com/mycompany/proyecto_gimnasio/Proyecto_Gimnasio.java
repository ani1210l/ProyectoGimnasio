/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto_gimnasio;

import Controlador.ControladorMenu;
import Vista.Menu;

/**
 *
 * @author frank
 */
public class Proyecto_Gimnasio {

    public static void main(String[] args) {
        Menu vistaLogin = new Menu();
        ControladorMenu control = new ControladorMenu(vistaLogin);
        control.iniciaControl();
    }
}

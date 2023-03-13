/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.modelo_cliente;
import Modelo.Cliente;
import Vista.VistaCliente;
import Vista.VistaPrincipal;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;

/**
 *
 * @author User
 */
public class ControladorCliente {

    private modelo_cliente modelo;
    private VistaCliente vista;
    VistaPrincipal p = new VistaPrincipal();

    public ControladorCliente(modelo_cliente modelo, VistaCliente vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);

        vista.setSize(p.getjDesktopPane().getWidth(), p.getjDesktopPane().getHeight());
        vista.getjDialog1().setResizable(true);
        cargarClienteTabla();
    }

    public void cargarClienteTabla() {
        DefaultTableModel tblModel;
        tblModel = (DefaultTableModel) vista.getTblClientes().getModel();
        tblModel.setNumRows(0);//limpio filas de la tabla.

        List<Cliente> listac = modelo.listaclientesTabla();//Enlazo al Modelo y obtengo los datos
        Holder<Integer> i = new Holder<>(0);//Contador para las filas. 'i' funciona dentro de una expresion lambda

        listac.stream().forEach(pe -> {

            tblModel.addRow(new Object[9]);//Creo una fila vacia
            vista.getTblClientes().setValueAt(pe.getCliente_codigo(), i.value, 0);
            vista.getTblClientes().setValueAt(pe.getFecha_ingreso(), i.value, 1);
            vista.getTblClientes().setValueAt(pe.getCli_codper(), i.value, 2);

            i.value++;
        });
    }
}

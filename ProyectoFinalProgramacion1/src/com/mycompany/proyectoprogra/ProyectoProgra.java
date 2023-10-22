/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectoprogra;


import Interfaces.Login;
import Interfaces.VentanaUsuarios;

/**
 *
 * @author PC
 */
public class ProyectoProgra {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login().setVisible(true);
            }
        });
    
}
}

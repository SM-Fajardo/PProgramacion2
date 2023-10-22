/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoprogra;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conexion {
    private Connection conectar = null;
    private String usuario = "root";
    private String password = "AlfredoF4arD0#123%$";
    private String bd = "trasnporteveloce";
    private String ip = "localhost";
    private String puerto = "3306";
    
    public Connection establecerConexion() {
        try {
            String cadena = "jdbc:mysql://" + ip + ":" + puerto + "/" + bd;
            conectar = DriverManager.getConnection(cadena, usuario, password);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos: " + e.toString());
        }
        return conectar;
    }
}


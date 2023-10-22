/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metodos;

import com.mycompany.proyectoprogra.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class metodoBoleto {
    conexion conectar = new conexion();
  
    
    
public void insertarBoleto(String Nombre, String Apellido, String DPI, String NoBoleto, String Precio, String Fecha, String Bus, String Ruta) throws SQLException {
    try {
        Connection conn = conectar.establecerConexion();
        String query = "INSERT INTO boletos (Nombre, Apellido, DPI, Boleto, Precio, Fecha, Bus, Ruta) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, Nombre);
        stmt.setString(2, Apellido);
        stmt.setString(3, DPI);
        stmt.setString(4, NoBoleto);
        stmt.setString(5, Precio);
        stmt.setString(6, Fecha);
        stmt.setString(7, Bus);
        stmt.setString(8, Ruta);
        stmt.executeUpdate();

        conn.close();
        
                JOptionPane.showMessageDialog(null, "Boleto registrado exitosamente.", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);

    } catch (SQLException e) {
        if (e.getErrorCode() == 1452) {
            if (e.getMessage().contains("Bus")) {
                JOptionPane.showMessageDialog(null, "Error al insertar el boleto: Bus no existe.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (e.getMessage().contains("Ruta")) {
                JOptionPane.showMessageDialog(null, "Error al insertar el boleto: Ruta no existe.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al insertar el boleto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error al insertar el boleto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}




public void eliminarBoleto(String NoBoleto) throws SQLException {
    try {
        Connection conn = conectar.establecerConexion();

        String query = "DELETE FROM boletos WHERE Boleto = ?";
PreparedStatement stmt = conn.prepareStatement(query);
stmt.setString(1, NoBoleto);

stmt.executeUpdate();

    
        

        conn.close();
    } catch (Exception e) {
        System.out.println("");
    }
}

    public void modificarBoleto(String Nombre, String Apellido, String DPI, String NoBoleto, String Precio, String Fecha, String Bus, String Ruta
    ) throws SQLException {
        try {
            Connection conn = conectar.establecerConexion();
            String query;
            PreparedStatement stmt;
            query = "UPDATE boletos "
                    + "SET Nombre = ?, Apellido = ?, DPI = ?, Precio = ?,Fecha = ?,Bus = ? ,Ruta = ?"
                    + "WHERE Boleto = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, Nombre);
            stmt.setString(2, Apellido);
            stmt.setString(3, DPI);
            stmt.setString(4, Precio);
            stmt.setString(5, Fecha);
            stmt.setString(6, Bus);
            stmt.setString(7, Ruta);
            stmt.setString(8, NoBoleto);

            stmt.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            System.out.println("Error al modificar el Boleto: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

    



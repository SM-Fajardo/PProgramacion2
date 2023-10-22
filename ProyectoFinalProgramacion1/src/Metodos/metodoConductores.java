/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metodos;

import com.mycompany.proyectoprogra.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class metodoConductores {
    conexion conectar = new conexion();
  

public void insertarConductor(String Nombre, String Apellido, int DPI, String Licencia, String TipoLicencia) throws SQLException {
    try {
        Connection conn = conectar.establecerConexion();
        String query = "INSERT INTO conductores (Nombre, Apellido, DPI, Licencia, TipoLicencia) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, Nombre);
        stmt.setString(2, Apellido);
        stmt.setInt(3, DPI);
        stmt.setString(4, Licencia);
        stmt.setString(5, TipoLicencia);
        stmt.executeUpdate();

       conn.close();
                    JOptionPane.showMessageDialog(null, "Conductor registrado  con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);

    } catch (SQLException e) {
        if (e.getErrorCode() == 1062) {
            JOptionPane.showMessageDialog(null, "Error al insertar el conductor: El conductor ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Error al insertar el conductor: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}




public void eliminarConductor(String Licencia) throws SQLException {
    try {
        Connection conn = conectar.establecerConexion();

        String query = "DELETE FROM conductores WHERE Licencia = ?";
PreparedStatement stmt = conn.prepareStatement(query);
stmt.setString(1, Licencia);

stmt.executeUpdate();

    
        

        conn.close();
    } catch (SQLException ex) {
        System.out.println("");
    }
}



public void modificarConductor(String Nombre, String Apellido, Integer DPI, String Licencia, String TipoLicencia) {
    try {
        Connection conn = conectar.establecerConexion();

        String query;
        PreparedStatement stmt;

        if (DPI != null) {
            query = "UPDATE conductores " +
                    "SET Nombre = ?, Apellido = ?, DPI = ?, TipoLicencia = ? " +
                    "WHERE Licencia = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, Nombre);
            stmt.setString(2, Apellido);
            stmt.setInt(3, DPI);
            stmt.setString(4, TipoLicencia);
            stmt.setString(5, Licencia);
        } else {
            query = "UPDATE conductores " +
                    "SET Nombre = ?, Apellido = ?, TipoLicencia = ? " +
                    "WHERE Licencia = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, Nombre);
            stmt.setString(2, Apellido);
            stmt.setString(3, TipoLicencia);
            stmt.setString(4, Licencia);
        }

        stmt.executeUpdate();

        conn.close();
    } catch (SQLException e) {
        System.out.println("Error al modificar el conductor: " + e.getMessage());
        e.printStackTrace();
    }
}



}














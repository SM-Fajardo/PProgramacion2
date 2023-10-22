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
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class metodoUsuario {
    conexion conectar = new conexion();
    public void insertarUsuario(String Nombre, String Apellido, String Usuario, String Contraseña) throws SQLException {
    try {
        Connection connection = conectar.establecerConexion();
        Statement statement = connection.createStatement();

        String query = "INSERT INTO usuarios (Nombre, Apellido, Usuario, Contraseña) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, Nombre);
        preparedStatement.setString(2, Apellido);
        preparedStatement.setString(3, Usuario);
        preparedStatement.setString(4, Contraseña);
        
        preparedStatement.executeUpdate();
        connection.close();
        
        JOptionPane.showMessageDialog(null, "Usuario registrado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        
    } catch (SQLException e) {
        if (e.getErrorCode() == 1062) {
            JOptionPane.showMessageDialog(null, "El Usuario ya está registrado", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Error al registrar el Usuario: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

public void eliminarUsuario(String Usuario)   throws SQLException {
    try {
        Connection conn = conectar.establecerConexion();

        if (conn != null) {
            String query = "DELETE FROM usuarios WHERE Usuario = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, Usuario);
    
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("El usuario ha sido eliminado correctamente.");
            } else {
                System.out.println("No se encontró el usuario a eliminar.");
            }

            conn.close();
        } else {
            System.out.println("Error al establecer la conexión a la base de datos.");
        }
    } catch (SQLException e) {
        System.out.println("Error al eliminar el usuario: " + e.getMessage());
    }
}









}


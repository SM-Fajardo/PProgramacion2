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
public class metodoBus {
    conexion conectar = new conexion();
    public void insertarBus(String marca, String modelo, String placa, String motor) throws SQLException {
    try {
        Connection connection = conectar.establecerConexion();
        Statement statement = connection.createStatement();

        String query = "INSERT INTO buses (Marca, Modelo, Placa, Motor, Estado) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, marca);
        preparedStatement.setString(2, modelo);
        preparedStatement.setString(3, placa);
        preparedStatement.setString(4, motor);
        preparedStatement.setString(5, "Disponible"); // Establecer el estado como "Disponible"

        preparedStatement.executeUpdate();
        connection.close();
        
        JOptionPane.showMessageDialog(null, "Bus registrado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        
    } catch (SQLException e) {
        if (e.getErrorCode() == 1062) {
            JOptionPane.showMessageDialog(null, "El bus ya está registrado", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Error al registrar el bus: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

    
    
    
public void eliminarBus(String Placa) throws SQLException {
    try {
        Connection conn = conectar.establecerConexion();

        String query = "DELETE FROM buses WHERE Placa = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, Placa);
    
        stmt.executeUpdate();

        conn.close();
    } catch (Exception e) {
        System.out.println("");
    }
}





   public void modificarBus(String Marca, String Modelo, String Placa, String Motor) throws SQLException {
    try {
        Connection conn = conectar.establecerConexion();

        String query = "UPDATE buses " +
                "SET Marca = ?, Modelo = ?, Motor = ? " +
                "WHERE Placa = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, Marca);
        stmt.setString(2, Modelo);
        stmt.setString(3, Motor);
        stmt.setString(4, Placa);

        stmt.executeUpdate();

        conn.close();
    } catch (SQLException e) {
        System.out.println("");
    }
}
   
  public void mostrarBusesEnJList(Connection connection, DefaultListModel<String> l1, DefaultListModel<String> l2, DefaultListModel<String> l3, DefaultListModel<String> l4) throws SQLException {
    try {
        Statement statement = connection.createStatement();

        String query = "SELECT Marca, Modelo, Placa, Motor FROM buses";
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            String marca = resultSet.getString("Marca");
            String modelo = resultSet.getString("Modelo");
            String placa = resultSet.getString("Placa");
            String motor = resultSet.getString("Motor");

            l1.addElement(marca);
            l2.addElement(modelo);
            l3.addElement(placa);
            l4.addElement(motor);
        }

        resultSet.close();
    } catch (SQLException e) {
        throw new SQLException("Error al obtener los datos de los buses: " + e.getMessage());
    }
}

}
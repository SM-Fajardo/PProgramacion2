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
import java.sql.ResultSet;

/**
 *
 * @author PC
 */
public class metodoViajes {

    conexion conectar = new conexion();
public void insertarViaje(String Estacion1, String Estacion2, String Ruta, String Placa, String Conductor, String Fecha, String Horario) throws SQLException {
    try {
        Connection conn = conectar.establecerConexion();
        
        // Verificar si la placa del bus está en uso
        if (verificarPlacaEnUso(Placa)) {
            JOptionPane.showMessageDialog(null, "No se puede crear otro viaje con la misma placa hasta que esté disponible de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            conn.close();
            return;
        }

        String query = "INSERT INTO viajes (Estacion1, Estacion2, Ruta, Buses, Conductor, Fecha, Horario) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, Estacion1);
        stmt.setString(2, Estacion2);
        stmt.setString(3, Ruta);
        stmt.setString(4, Placa);
        stmt.setString(5, Conductor);
        stmt.setString(6, Fecha);
        stmt.setString(7, Horario);
        stmt.executeUpdate();

        // Actualizar el estado del bus a "En Uso"
        actualizarEstadoBus(Placa, "En Uso");

        conn.close();

        JOptionPane.showMessageDialog(null, "Viaje registrado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    } catch (SQLException e) {
        if (e.getErrorCode() == 1452) {
            if (e.getMessage().contains("Estación")) {
                JOptionPane.showMessageDialog(null, "Error al insertar el viaje: Estación inexistente.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (e.getMessage().contains("Bus")) {
                JOptionPane.showMessageDialog(null, "Error al insertar el viaje: Bus inexistente.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (e.getMessage().contains("Conductor")) {
                JOptionPane.showMessageDialog(null, "Error al insertar el viaje: Conductor inexistente.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al insertar el viaje: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error al insertar el viaje: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

private void actualizarEstadoBus(String placa, String estado) throws SQLException {
    Connection conn = conectar.establecerConexion();
    String query = "UPDATE buses SET Estado = ? WHERE Placa = ?";
    PreparedStatement stmt = conn.prepareStatement(query);
    stmt.setString(1, estado);
    stmt.setString(2, placa);
    stmt.executeUpdate();
    conn.close();
}

public boolean verificarPlacaEnUso(String placa) throws SQLException {
    Connection conn = conectar.establecerConexion();
    String query = "SELECT Estado FROM buses WHERE Placa = ?";
    PreparedStatement stmt = conn.prepareStatement(query);
    stmt.setString(1, placa);
    ResultSet resultSet = stmt.executeQuery();
    if (resultSet.next()) {
        String estado = resultSet.getString("Estado");
        if (estado.equalsIgnoreCase("En Uso")) {
            resultSet.close();
            conn.close();
            return true;
        }
    }
    resultSet.close();
    conn.close();
    return false;
}



public void eliminarViajeYMarcarBusDisponible(String Ruta) throws SQLException {
    try {
        Connection conn = conectar.establecerConexion();

        // Obtener la placa del bus asignado al viaje que se va a eliminar
        String getPlacaQuery = "SELECT buses FROM viajes WHERE Ruta = ?";
        PreparedStatement getPlacaStmt = conn.prepareStatement(getPlacaQuery);
        getPlacaStmt.setString(1, Ruta);  // Establecer el valor del parámetro
        ResultSet resultSet = getPlacaStmt.executeQuery();
        String placa = null;
        if (resultSet.next()) {
            placa = resultSet.getString("buses");
        }
        resultSet.close();

        String deleteQuery = "DELETE FROM viajes WHERE Ruta = ?";
        PreparedStatement deleteStmt = conn.prepareStatement(deleteQuery);
        deleteStmt.setString(1, Ruta);
        deleteStmt.executeUpdate();

        // Marcar el bus como "Disponible"
        if (placa != null) {
            String updateQuery = "UPDATE buses SET Estado = 'Disponible' WHERE Placa = ?";
            PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
            updateStmt.setString(1, placa);
            updateStmt.executeUpdate();
        }

        conn.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al eliminar por ruta: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}




    public void modificarViaje(String Estacion1, String Estacion2, String Ruta, String Buses, String Conductor, String Fecha, String Horario) throws SQLException {
        try {
            Connection conn = conectar.establecerConexion();

            String query = "UPDATE viajes "
                    + "SET Estacion1 = ?, Estacion2 = ?, Buses = ?, Conductor = ?, Fecha = ?, Horario = ? "
                    + "WHERE Ruta = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, Estacion1);
            stmt.setString(2, Estacion2);
            stmt.setString(3, Buses);
            stmt.setString(4, Conductor);
            stmt.setString(5, Fecha);
            stmt.setString(6, Horario);
            stmt.setString(7, Ruta);

            stmt.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            System.out.println("Error al modificar el viaje: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

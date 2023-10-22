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
public class metodoEstacion {

    conexion conectar = new conexion();
public void insertarEstaciones(String estacion) throws SQLException {
    try (Connection connection = conectar.establecerConexion();
         Statement statement = connection.createStatement()) {

        // Verificar si la estación ya está registrada
        String verificarEstacionQuery = "SELECT COUNT(*) FROM estaciones WHERE Estacion = '" + estacion + "'";
        try (ResultSet resultSet = statement.executeQuery(verificarEstacionQuery)) {
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                if (count > 0) {
                    JOptionPane.showMessageDialog(null, "La estación ya está registrada", "Error", JOptionPane.ERROR_MESSAGE);
                    return; // Salir del método si la estación ya está registrada
                }
            }
        }

        // Obtener el último valor de orden insertado en la tabla
        String getMaxOrdenQuery = "SELECT MAX(Orden) FROM estaciones";
        try (ResultSet resultSet = statement.executeQuery(getMaxOrdenQuery)) {
            int ultimoOrden = 0;
            if (resultSet.next()) {
                ultimoOrden = resultSet.getInt(1);
            }

            // Incrementar el orden para las nuevas estaciones
            int nuevoOrden = ultimoOrden + 1;

            String query = "INSERT INTO estaciones (Estacion, Orden) VALUES ('" + estacion + "', " + nuevoOrden + ")";
            statement.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Estaciones registradas con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al registrar las estaciones: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}



    public void eliminarEstacion(String Orden) {
        try {
            Connection conn = conectar.establecerConexion();

            String query = "DELETE FROM estaciones WHERE Orden = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, Orden);

            stmt.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            if (e.getErrorCode() == 1451) {
                System.out.println("La estación está en uso. No se puede eliminar.");
                JOptionPane.showMessageDialog(null, "La estación está en uso. No se puede eliminar.", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                System.out.println("Ocurrió un error al eliminar la estación.");
                JOptionPane.showMessageDialog(null, "Ocurrió un error al eliminar la estación.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error desconocido.");
            JOptionPane.showMessageDialog(null, "Ocurrió un error desconocido.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void modificarEstacion(String Orden, String Estacion) throws SQLException {
        try {
            Connection conn = conectar.establecerConexion();

            String query = "UPDATE estaciones "
                    + "SET Estacion = ? "
                    + "WHERE Orden = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, Estacion);

            stmt.setString(3, Orden);

            stmt.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            System.out.println("");
        }
    }

    public void actualizarNumerosFila(String orden) throws SQLException {
        try {
            Connection conn = conectar.establecerConexion();

            String sqlUpdate = "UPDATE estaciones SET Orden = Orden - 1 WHERE Orden > ?";
            PreparedStatement statement = conn.prepareStatement(sqlUpdate);
            statement.setString(1, orden);
            statement.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            System.out.println("");
        }
    }
}

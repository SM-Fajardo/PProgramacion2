/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Clases.ArchivoBoleto;
import Clases.ArchivoBus;
import Clases.Asignar;
import Clases.controlyGestionBus;
import Clases.estaciones;
import Clases.reservacion;
import Metodos.metodoBus;

import VentanasReportes.ReporteBus;
import VentanasReportes.ReporteEstaciones;
import VentanasReportes.ReportesSQL;
import com.mycompany.proyectoprogra.conexion;
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author PC
 */
public class ControlyGestionBus extends javax.swing.JFrame {

        
  

    conexion conectar = new conexion();
    
    
    
   
    public ControlyGestionBus() {
        
        
        initComponents();
       // Carga la imagen desde el archivo
        String rutaImagen = "C:\\Users\\PC\\Documents\\NetBeansProjects\\ProyectoFinalProgramacion1\\src\\imagenes\\trasnportes veloce.png";
        ImageIcon imagenIcono = new ImageIcon(rutaImagen);

        // Establece la imagen como icono de la ventana
        setIconImage(imagenIcono.getImage());
        setVisible(true);
        
        setLocationRelativeTo(null);//Null es para colocar centrado el JFrame
       
    
        
        
    }
    
       
  private void reporteBusPorOrden(String Placa) throws SQLException {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet resultSet = null;

    try {
        // Establecer la conexión con la base de datos
        conn = conectar.establecerConexion();

        // Consultar los buses en la base de datos filtrando por placa
        String query = "SELECT Marca, Modelo, Placa, Motor FROM buses WHERE Placa = ?";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, Placa);
        resultSet = stmt.executeQuery();

        // Verificar si se encontraron registros
        if (resultSet.next()) {
            // Limpiar los campos de texto antes de mostrar los resultados
            tfMarca.setText("");
            tfModelo.setText("");
            tfPlaca.setText("");
            tfMotor.setText("");
            
            // Mostrar los valores del primer registro en los campos de texto
            tfMarca.setText(resultSet.getString("Marca"));
            tfModelo.setText(resultSet.getString("Modelo"));
            tfPlaca.setText(resultSet.getString("Placa"));
            tfMotor.setText(resultSet.getString("Motor"));
        } else {
            // Si no se encontraron registros, se pueden limpiar los campos de texto
            tfMarca.setText("");
            tfModelo.setText("");
            tfPlaca.setText("");
            tfMotor.setText("");
            
            
            
                // Configurar el fondo de la ventana de diálogo en blanco
                UIManager.put("OptionPane.background", Color.WHITE);
                UIManager.put("Panel.background", Color.WHITE);

                JOptionPane.showMessageDialog(null, "No se encontró el bus  en la base de datos", "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
        }
    } finally {
        // Cerrar los recursos (resultset, statement y conexión) en un bloque finally para asegurar su liberación
        if (resultSet != null) {
            resultSet.close();
        }
        if (stmt != null) {
            stmt.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
}


    
      
      public Asignar Limpiar(){
        tfMarca.setText("");
        tfModelo.setText("");
        tfMotor.setText("");
        tfPlaca.setText("");
        
        
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lbMarca = new javax.swing.JLabel();
        lbModelo = new javax.swing.JLabel();
        lbPlaca = new javax.swing.JLabel();
        lbMotor = new javax.swing.JLabel();
        tfMarca = new javax.swing.JTextField();
        tfModelo = new javax.swing.JTextField();
        tfPlaca = new javax.swing.JTextField();
        tfMotor = new javax.swing.JTextField();
        btRegresar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        btReporte = new javax.swing.JButton();
        btHTML = new javax.swing.JButton();
        btBuscar = new javax.swing.JButton();
        btModificar = new javax.swing.JButton();
        btEliminar = new javax.swing.JButton();
        btRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/autobus-escolar (1).png"))); // NOI18N
        jLabel1.setText("Control y Gestion de Bus");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 13, -1, -1));

        lbMarca.setText("Marca");
        getContentPane().add(lbMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 77, -1, -1));

        lbModelo.setText("Modelo");
        getContentPane().add(lbModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 117, -1, -1));

        lbPlaca.setText("Placa");
        getContentPane().add(lbPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 154, -1, -1));

        lbMotor.setText("Motor");
        getContentPane().add(lbMotor, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 191, -1, -1));

        tfMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfMarcaActionPerformed(evt);
            }
        });
        getContentPane().add(tfMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 74, 191, -1));
        getContentPane().add(tfModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 114, 191, -1));
        getContentPane().add(tfPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 148, 191, -1));
        getContentPane().add(tfMotor, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 188, 191, -1));

        btRegresar.setBackground(new java.awt.Color(0, 153, 153));
        btRegresar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/regresar.png"))); // NOI18N
        btRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(btRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 398, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 347, 485, 10));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo9.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 150, 450));

        btReporte.setBackground(new java.awt.Color(0, 153, 153));
        btReporte.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btReporte.setForeground(new java.awt.Color(255, 255, 255));
        btReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reporteSQL.png"))); // NOI18N
        btReporte.setText("REPORTE");
        btReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btReporteActionPerformed(evt);
            }
        });
        jPanel1.add(btReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 120, -1));

        btHTML.setBackground(new java.awt.Color(0, 153, 153));
        btHTML.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btHTML.setForeground(new java.awt.Color(255, 255, 255));
        btHTML.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/html.png"))); // NOI18N
        btHTML.setText("HTML");
        btHTML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHTMLActionPerformed(evt);
            }
        });
        jPanel1.add(btHTML, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 110, -1));

        btBuscar.setBackground(new java.awt.Color(0, 153, 153));
        btBuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscarSQL.png"))); // NOI18N
        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, -1, -1));

        btModificar.setBackground(new java.awt.Color(0, 153, 153));
        btModificar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btModificar.setForeground(new java.awt.Color(255, 255, 255));
        btModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/modificarSQL.png"))); // NOI18N
        btModificar.setText("Modificar");
        btModificar.setMaximumSize(new java.awt.Dimension(103, 29));
        btModificar.setMinimumSize(new java.awt.Dimension(103, 29));
        btModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, -1, 30));

        btEliminar.setBackground(new java.awt.Color(0, 153, 153));
        btEliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminarSQL.png"))); // NOI18N
        btEliminar.setText("Eliminar");
        btEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 120, 30));

        btRegistrar.setBackground(new java.awt.Color(0, 153, 153));
        btRegistrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardarSQL.png"))); // NOI18N
        btRegistrar.setText("Registrar");
        btRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, -1, 660, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfMarcaActionPerformed

    private void btRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegistrarActionPerformed
        // TODO add your handling code here:
         metodoBus objetoC = new metodoBus();
        try {
            String Marca =tfMarca.getText();
            String Modelo =tfModelo.getText();
            String  Placa=tfPlaca.getText();
            String  Motor =tfMotor.getText();
            
         if (Marca.isEmpty()|| Modelo.isEmpty()||Placa.isEmpty()||Motor.isEmpty()) {
        JOptionPane.showMessageDialog(null, "El campo de estación está vacío", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Salir del método si el campo de estación está vacío
    }
            
            objetoC.insertarBus(tfMarca.getText(), tfModelo.getText(), tfPlaca.getText(), tfMotor.getText());
            
            Limpiar();
        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) {
                JOptionPane.showMessageDialog(null, "El bus ya está registrado", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar el bus: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

           
    }//GEN-LAST:event_btRegistrarActionPerformed

    private void btEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarActionPerformed
        // TODO add your handling code here:
      metodoBus objetoC = new metodoBus();
try {
    String Placa = tfPlaca.getText(); // Obtener el número de orden del campo de texto
    String Marca = tfMarca.getText();
    String Modelo = tfModelo.getText();
    String Motor = tfMotor.getText();

         if (Marca.isEmpty()|| Modelo.isEmpty()||Placa.isEmpty()||Motor.isEmpty()) {
        JOptionPane.showMessageDialog(null, "El campo de estación está vacío", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Salir del método si el campo de estación está vacío
    }
    objetoC.eliminarBus(Placa); // Llamar al método eliminarEstacion con el parámetro de Orden
    Limpiar();
    JOptionPane.showMessageDialog(null, "Bus eliminado", "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
   
} catch (SQLException ex) {
    Logger.getLogger(controlyGestionBus.class.getName()).log(Level.SEVERE, null, ex);
}

        
    }//GEN-LAST:event_btEliminarActionPerformed

    private void btModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarActionPerformed
        // TODO add your handling code here:
          metodoBus objetoC = new metodoBus();
try {
    String marca = tfMarca.getText(); // Obtener el número de orden del campo de texto
    String modelo = tfModelo.getText(); // Obtener el valor de EstacionA del campo de texto
    String placa = tfPlaca.getText(); // Obtener el valor de EstacionB del campo de texto
    String motor = tfMotor.getText(); // Obtener el valor de EstacionC del campo de texto

    
            
         if (marca.isEmpty()|| modelo.isEmpty()||placa.isEmpty()||motor.isEmpty()) {
        JOptionPane.showMessageDialog(null, "El campo de estación está vacío", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Salir del método si el campo de estación está vacío
    }
    objetoC.modificarBus(marca, modelo, placa, motor); // Llamar al método modificarEstacion con los parámetros correspondientes

    JOptionPane.showMessageDialog(null, "bus modificado", "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
    Limpiar();
} catch (SQLException ex) {
    Logger.getLogger(controlyGestionBus.class.getName()).log(Level.SEVERE, null, ex);
}
     

    }//GEN-LAST:event_btModificarActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
   try {
    String Placa = tfPlaca.getText();
     if (Placa.isEmpty()) {
                         UIManager.put("OptionPane.background", Color.WHITE);
                UIManager.put("Panel.background", Color.WHITE);
        JOptionPane.showMessageDialog(null, "El campo de texto está vacío", "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
     }else{
        reporteBusPorOrden(Placa);
     }
} catch (SQLException ex) {
    Logger.getLogger(estaciones.class.getName()).log(Level.SEVERE, null, ex);
    JOptionPane.showMessageDialog(null, "Bus no encontrado", "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
}
    }//GEN-LAST:event_btBuscarActionPerformed

    private void btRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegresarActionPerformed
        // TODO add your handling code here:
         MenuP vmenu = new MenuP();
        vmenu.setVisible(true);
        dispose();
       
    }//GEN-LAST:event_btRegresarActionPerformed

    private void btHTMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHTMLActionPerformed
        // TODO add your handling code here:
    BufferedWriter ficheroSalida;

try {
    ficheroSalida = new BufferedWriter(new FileWriter(new File("reporteBus.html")));

    ficheroSalida.write("<HTML><HEAD><TITLE>REPORTE</TITLE>");
    ficheroSalida.write("<style>");
    ficheroSalida.write("body { font-family: Arial, sans-serif; margin: 20px; background-color: #f1f1f1; }");
    ficheroSalida.write("h1 { text-align: center; color: #333; }");
    ficheroSalida.write("table { border-collapse: collapse; width: 100%; background-color: #fff; border: 1px solid #ddd; }");
    ficheroSalida.write("th, td { padding: 8px; text-align: left; border-bottom: 1px solid #ddd; }");
    ficheroSalida.write("tr:hover { background-color: #f5f5f5; }");
    ficheroSalida.write(".fade-in { animation: fadeIn 1s; }");
    ficheroSalida.write("@keyframes fadeIn { from { opacity: 0; } to { opacity: 1; } }");
    ficheroSalida.write(".bus-icon { width: 50px; height: auto; float: left; margin-right: 10px; }");
    ficheroSalida.write("</style>");
    ficheroSalida.write("</HEAD><BODY>");
    ficheroSalida.write("<h1 class='fade-in'>Reporte de BUS </h1>");
    ficheroSalida.write("<table>");
    ficheroSalida.write("<tr><th> </th><th>MARCA </th><th>MODELO</th><th>PLACA</th><th>MOTOR</th><th>ESTADO</th></tr>");

    Connection connection = conectar.establecerConexion();
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery("SELECT Marca, Modelo, Placa, Motor, Estado FROM buses");

    while (resultSet.next()) {
        String marca = resultSet.getString("Marca");
        String modelo = resultSet.getString("Modelo");
        String placa = resultSet.getString("Placa");
        String motor = resultSet.getString("Motor");
        String estado = resultSet.getString("Estado");

        ficheroSalida.write("<tr class='fade-in'><td><img class='bus-icon' src='C:\\Users\\PC\\Documents\\NetBeansProjects\\ProyectoFinalProgramacion1\\src\\imagenes\\autobus-escolar (1).png'></td><td>" + marca + "</td><td>" + modelo + "</td><td>" + placa + "</td><td>" + motor + "</td><td>" + estado + "</td></tr>");

    }

    ficheroSalida.write("</table>");
    ficheroSalida.write("<script>");
    ficheroSalida.write("window.onload = function() { var rows = document.getElementsByTagName('tr'); for (var i = 0; i < rows.length; i++) { rows[i].style.animationDelay = (i * 0.2) + 's'; } }");
    ficheroSalida.write("</script>");
    ficheroSalida.write("</BODY></HTML>");
    ficheroSalida.close();
    connection.close();

    JOptionPane.showMessageDialog(null, "Reporte de buses generado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);

} catch (IOException | SQLException ex) {
    JOptionPane.showMessageDialog(null, "Error al generar el reporte de buses: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}



    }//GEN-LAST:event_btHTMLActionPerformed

    private void btReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btReporteActionPerformed
       
            // TODO add your handling code here:

           
         try {
            ReporteBus.getInstance();
        } catch (SQLException ex) {
            System.out.println("");
        }
         
       
    }//GEN-LAST:event_btReporteActionPerformed

    /**
     * @param args the command line arguments
     */
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btEliminar;
    private javax.swing.JButton btHTML;
    private javax.swing.JButton btModificar;
    private javax.swing.JButton btRegistrar;
    private javax.swing.JButton btRegresar;
    private javax.swing.JButton btReporte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbMarca;
    private javax.swing.JLabel lbModelo;
    private javax.swing.JLabel lbMotor;
    private javax.swing.JLabel lbPlaca;
    private javax.swing.JTextField tfMarca;
    private javax.swing.JTextField tfModelo;
    private javax.swing.JTextField tfMotor;
    private javax.swing.JTextField tfPlaca;
    // End of variables declaration//GEN-END:variables
}

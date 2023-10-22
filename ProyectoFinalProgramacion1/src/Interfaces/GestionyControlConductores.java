/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;


import Clases.ArchivoConductores;
import Clases.Asignar;
import Clases.controlyGestionBus;
import Clases.gestionyControlConductores;
import Clases.reservacion;
import Metodos.metodoConductores;
import java.util.logging.Logger;

import VentanasReportes.ReporteConductores;
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
public class GestionyControlConductores extends javax.swing.JFrame {
    
     conexion conectar = new conexion();
    

    public GestionyControlConductores() {
        initComponents();
        // Carga la imagen desde el archivo
        String rutaImagen = "C:\\Users\\PC\\Documents\\NetBeansProjects\\ProyectoFinalProgramacion1\\src\\imagenes\\trasnportes veloce.png";
        ImageIcon imagenIcono = new ImageIcon(rutaImagen);

        // Establece la imagen como icono de la ventana
        setIconImage(imagenIcono.getImage());
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    
    
    
    private void reporteconductoresPorOrden(String Licencia) throws SQLException {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet resultSet = null;

    try {
        // Establecer la conexión con la base de datos
        conn = conectar.establecerConexion();

        // Consultar las estaciones en la base de datos filtrando por número de licencia
        String query = "SELECT Nombre, Apellido, DPI, Licencia, TipoLicencia FROM conductores WHERE Licencia = ?";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, Licencia);
        resultSet = stmt.executeQuery();

        // Verificar si se encontraron registros
        if (resultSet.next()) {
            // Obtener los valores de los conductores encontrados
            String nombre = resultSet.getString("Nombre");
            String apellido = resultSet.getString("Apellido");
            String dpi = resultSet.getString("DPI");
            String licencia = resultSet.getString("Licencia");
            String tipoLicencia = resultSet.getString("TipoLicencia");

            // Modificar los datos si es necesario
            // Aquí puedes realizar las modificaciones necesarias en las variables nombre, apellido, dpi, licencia, tipoLicencia

            // Actualizar los campos de texto con los nuevos valores modificados
            tfNombre.setText(nombre);
            tfApellido.setText(apellido);
            tfDPI.setText(dpi);
            tfNoLicencia.setText(licencia);
            tfTLicencia.setText(tipoLicencia);
        } else {
            // Si no se encontraron registros, se pueden limpiar los campos de texto
            tfNombre.setText("");
            tfApellido.setText("");
            tfDPI.setText("");
            tfNoLicencia.setText("");
            tfTLicencia.setText("");
            
            
            
                // Configurar el fondo de la ventana de diálogo en blanco
                UIManager.put("OptionPane.background", Color.WHITE);
                UIManager.put("Panel.background", Color.WHITE);

                JOptionPane.showMessageDialog(null, "No se encontró conductor en la base de datos", "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
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
        tfNombre.setText("");
        tfApellido.setText("");
        tfDPI.setText("");
        tfNoLicencia.setText("");
        tfTLicencia.setText("");
        
        
        return null;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lbNombre = new javax.swing.JLabel();
        lbApellido = new javax.swing.JLabel();
        lbDPI = new javax.swing.JLabel();
        tfApellido = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btRegresar = new javax.swing.JButton();
        lbNLicencia = new javax.swing.JLabel();
        lbTLicencia = new javax.swing.JLabel();
        tfNoLicencia = new javax.swing.JTextField();
        tfTLicencia = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        tfDPI = new javax.swing.JTextField();
        tfNombre = new javax.swing.JTextField();
        btEliminar = new javax.swing.JButton();
        btAgregar = new javax.swing.JButton();
        btHTML = new javax.swing.JButton();
        btBuscar = new javax.swing.JButton();
        btReporte = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btModificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/conductor-de-autobus.png"))); // NOI18N
        jLabel1.setText("CONDUCTORES");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 13, -1, -1));

        lbNombre.setText("Nombre");
        getContentPane().add(lbNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 107, -1, -1));

        lbApellido.setText("Apellido");
        getContentPane().add(lbApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 148, -1, -1));

        lbDPI.setText("DPI");
        getContentPane().add(lbDPI, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 190, -1, -1));
        getContentPane().add(tfApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 145, 178, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 341, 520, 10));

        btRegresar.setBackground(new java.awt.Color(0, 153, 153));
        btRegresar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/regresar.png"))); // NOI18N
        btRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(btRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 475, -1, -1));

        lbNLicencia.setText("No. Licencia");
        getContentPane().add(lbNLicencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 230, -1, -1));

        lbTLicencia.setText("Tipo  de Licencia ");
        getContentPane().add(lbTLicencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 270, -1, -1));
        getContentPane().add(tfNoLicencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 227, 178, -1));
        getContentPane().add(tfTLicencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 267, 178, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(tfDPI, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 180, -1));

        tfNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNombreActionPerformed(evt);
            }
        });
        jPanel1.add(tfNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 108, 178, -1));

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
        jPanel1.add(btEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 120, -1));

        btAgregar.setBackground(new java.awt.Color(0, 153, 153));
        btAgregar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardarSQL.png"))); // NOI18N
        btAgregar.setText("Agregar ");
        btAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

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
        jPanel1.add(btHTML, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 110, -1));

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
        jPanel1.add(btBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 410, 120, -1));

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
        jPanel1.add(btReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 410, 120, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo9.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(547, 0, 140, 510));

        btModificar.setBackground(new java.awt.Color(0, 153, 153));
        btModificar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btModificar.setForeground(new java.awt.Color(255, 255, 255));
        btModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/modificarSQL.png"))); // NOI18N
        btModificar.setText("Modificar");
        btModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 360, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarActionPerformed
// TODO add your handling code here:
metodoConductores objetoC = new metodoConductores();
try {
    String DPIString = tfDPI.getText();
    if (DPIString.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Uno o más campos están vacíos", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Salir del método si el campo de DPI está vacío
    }
    
    int DPI = Integer.parseInt(DPIString);
    String Nombre = tfNombre.getText();
    String Apellido = tfApellido.getText();
    String Nolicencia = tfNoLicencia.getText();
    String TipoLicencia = tfTLicencia.getText();
    
    if (Nombre.isEmpty() || Apellido.isEmpty() || Nolicencia.isEmpty() || TipoLicencia.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Uno o más campos están vacíos", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Salir del método si algún campo está vacío
    }
    
    objetoC.insertarConductor(Nombre, Apellido, DPI, Nolicencia, TipoLicencia);
    Limpiar();
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(null, "El DPI debe ser un número entero válido", "Error", JOptionPane.ERROR_MESSAGE);
} catch (SQLException e) {
    JOptionPane.showMessageDialog(null, "Error al registrar el conductor: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    System.out.println("Código de error: " + e.getErrorCode()); // Agrega esta línea para imprimir el código de error
    e.printStackTrace();
}


        
        
        
        
        
        
        
    }//GEN-LAST:event_btAgregarActionPerformed

    private void btEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarActionPerformed
 metodoConductores objetoC = new metodoConductores();
try {
    String DPIString = tfDPI.getText();
    if (DPIString.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Uno o más campos están vacíos", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Salir del método si el campo de DPI está vacío
    }

    int DPI = Integer.parseInt(DPIString);
    String Nombre = tfNombre.getText();
    String Apellido = tfApellido.getText();
    String Nolicencia = tfNoLicencia.getText();
    String TipoLicencia = tfTLicencia.getText();

    if (Nombre.isEmpty() || Apellido.isEmpty() || Nolicencia.isEmpty() || TipoLicencia.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Uno o más campos están vacíos", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Salir del método si uno o más campos están vacíos
    }

    // Aquí puedes utilizar el objetoC para llamar a los métodos correspondientes de la clase `metodoConductores`

    JOptionPane.showMessageDialog(null, "Conductor eliminado", "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
    Limpiar();
} catch (NumberFormatException ex) {
    JOptionPane.showMessageDialog(null, "Error al convertir DPI a número", "Error", JOptionPane.ERROR_MESSAGE);
} catch (Exception ex) {
    JOptionPane.showMessageDialog(null, "Error en la base de datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    Logger.getLogger(gestionyControlConductores.class.getName()).log(Level.SEVERE, null, ex);
} 


    }//GEN-LAST:event_btEliminarActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
       
  try {
    String licencia = tfNoLicencia.getText();
    if(licencia.isEmpty()){
         // Configurar el fondo de la ventana de diálogo en blanco
                UIManager.put("OptionPane.background", Color.WHITE);
                UIManager.put("Panel.background", Color.WHITE);
         JOptionPane.showMessageDialog(null, "El campo de texto está vacío", "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
    }
    else {
    reporteconductoresPorOrden(licencia);
    }
} catch (SQLException ex) {
    Logger.getLogger(gestionyControlConductores.class.getName()).log(Level.SEVERE, null, ex);
    JOptionPane.showMessageDialog(null, "Conductor no encontrado", "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
}

    }//GEN-LAST:event_btBuscarActionPerformed

    private void btModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarActionPerformed
     metodoConductores objetoC = new metodoConductores();
try {
    String nombre = tfNombre.getText();
    String apellido = tfApellido.getText();
    String dpiText = tfDPI.getText();
    String licencia = tfNoLicencia.getText();
    String tipolicencia = tfTLicencia.getText();
    
    // Verificar si uno o más campos están vacíos
    if (nombre.isEmpty() || apellido.isEmpty() || dpiText.isEmpty() || licencia.isEmpty() || tipolicencia.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Uno o más campos están vacíos", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Salir del método si uno o más campos están vacíos
    }
    
    int dpi;
    
    // Verificar si el campo DPI contiene un valor numérico válido
    if (dpiText.matches("\\d+")) {
        dpi = Integer.parseInt(dpiText);
        
        objetoC.modificarConductor(nombre, apellido, dpi, licencia, tipolicencia);
        
        JOptionPane.showMessageDialog(null, "Conductor modificado", "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
        Limpiar();
    } else {
        throw new NumberFormatException();
    }
} catch (NumberFormatException ex) {
    JOptionPane.showMessageDialog(null, "Error: Ingresa un valor numérico válido para DPI", "Error de formato", JOptionPane.ERROR_MESSAGE);
}


    }//GEN-LAST:event_btModificarActionPerformed

    private void btRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegresarActionPerformed
        // TODO add your handling code here:
         MenuP vmenu = new MenuP();
        vmenu.setVisible(true);
        dispose();
           
    }//GEN-LAST:event_btRegresarActionPerformed

    private void btHTMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHTMLActionPerformed
     
          BufferedWriter ficheroSalida;

try {
    ficheroSalida = new BufferedWriter(new FileWriter(new File("reporteConductores.html")));

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
    ficheroSalida.write("<h1 class='fade-in'>Reporte de CoNDUCTORES </h1>");
    ficheroSalida.write("<table>");
    ficheroSalida.write("<tr><th> </th><th> NOMBRE </th><th>APELLIDO</th><th>DPI </th><th>NO.LICENCIA  </th><th>TIPO DE LICENCIA  </th></tr>");

    Connection connection = conectar.establecerConexion();
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery("SELECT Nombre, Apellido, DPI, Licencia, TipoLicencia FROM conductores");

    while (resultSet.next()) {
        String nombre = resultSet.getString("Nombre");
        String apellido = resultSet.getString("Apellido");
        String dpi = resultSet.getString("DPI");
        String licencia = resultSet.getString("Licencia");
        String Tlicencia = resultSet.getString("TipoLicencia");

       ficheroSalida.write("<tr class='fade-in'><td><img class='bus-icon' src='C:\\Users\\PC\\Documents\\NetBeansProjects\\ProyectoFinalProgramacion1\\src\\imagenes\\conductor-de-autobus.png'></td><td>" + nombre + "</td><td>" + apellido + "</td><td>" + dpi + "</td><td>" + licencia + "</td><td>" + Tlicencia + "</td></tr>");

    }

    ficheroSalida.write("</table>");
    ficheroSalida.write("<script>");
    ficheroSalida.write("window.onload = function() { var rows = document.getElementsByTagName('tr'); for (var i = 0; i < rows.length; i++) { rows[i].style.animationDelay = (i * 0.2) + 's'; } }");
    ficheroSalida.write("</script>");
    ficheroSalida.write("</BODY></HTML>");
    ficheroSalida.close();
    connection.close();

    JOptionPane.showMessageDialog(null, "Reporte generado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);

} catch (IOException | SQLException ex) {
    JOptionPane.showMessageDialog(null, "Error al generar el reporte: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_btHTMLActionPerformed

    private void btReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btReporteActionPerformed
        // TODO add your handling code here:
       
        
        
           
         try {
            ReporteConductores.getInstance();
        } catch (SQLException ex) {
            System.out.println("");
        }
         
    
    }//GEN-LAST:event_btReporteActionPerformed

    private void tfNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNombreActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAgregar;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btEliminar;
    private javax.swing.JButton btHTML;
    private javax.swing.JButton btModificar;
    private javax.swing.JButton btRegresar;
    private javax.swing.JButton btReporte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbApellido;
    private javax.swing.JLabel lbDPI;
    private javax.swing.JLabel lbNLicencia;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbTLicencia;
    private javax.swing.JTextField tfApellido;
    private javax.swing.JTextField tfDPI;
    private javax.swing.JTextField tfNoLicencia;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfTLicencia;
    // End of variables declaration//GEN-END:variables
}

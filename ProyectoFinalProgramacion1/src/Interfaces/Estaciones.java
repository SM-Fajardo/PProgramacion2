/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package Interfaces;

import Clases.ArchivoBoleto;
import Clases.ArchivoEstacion;
import Clases.Asignar;
import Clases.estaciones;
import Clases.gestionyControlConductores;
import Clases.reservacion;
import Metodos.metodoEstacion;
import VentanasReportes.ReporteEstaciones;
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
public class Estaciones extends javax.swing.JFrame {
 conexion conectar = new conexion();
    
    public Estaciones( ) {
        
       
        initComponents();
        // Carga la imagen desde el archivo
        String rutaImagen = "C:\\Users\\PC\\Documents\\NetBeansProjects\\ProyectoFinalProgramacion1\\src\\imagenes\\trasnportes veloce.png";
        ImageIcon imagenIcono = new ImageIcon(rutaImagen);

        // Establece la imagen como icono de la ventana
        setIconImage(imagenIcono.getImage());
        setVisible(true);
        
        setLocationRelativeTo(null);//Null es para colocar centrado el JFrame
       
    }
public Asignar Limpiar(){
        tfEstacion.setText("");
        
       
        
        
        return null;
    }
    

 private void reporteEstacionesPorOrden(String Orden) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet resultSet = null;

        try {
            // Establecer la conexión con la base de datos
            conn = conectar.establecerConexion();

            // Consultar las estaciones en la base de datos filtrando por número de orden
            String query = "SELECT Estacion FROM estaciones WHERE Orden = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, Orden);
            resultSet = stmt.executeQuery();

            // Verificar si se encontraron registros
            if (resultSet.next()) {
                // Limpiar los campos de texto antes de mostrar los resultados
                tfEstacion.setText("");

                // Iterar a través del ResultSet y mostrar los resultados
                do {
                    String estacionA = resultSet.getString("Estacion");

                    // Mostrar los valores de las estaciones encontradas en los campos de texto
                    tfEstacion.setText(tfEstacion.getText() + estacionA + "\n");
                } while (resultSet.next());
            } else {
                // Si no se encontraron registros, se pueden limpiar los campos de texto
                tfEstacion.setText("");

                // Configurar el fondo de la ventana de diálogo en blanco
                UIManager.put("OptionPane.background", Color.WHITE);
                UIManager.put("Panel.background", Color.WHITE);

                JOptionPane.showMessageDialog(null, "No se encontró la estación en la base de datos", "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
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
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lbEstacionA = new javax.swing.JLabel();
        tfEstacion = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        btReporte = new javax.swing.JButton();
        btHTML = new javax.swing.JButton();
        btModificar = new javax.swing.JButton();
        btEliminar = new javax.swing.JButton();
        btBuscar = new javax.swing.JButton();
        tfBuscar = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 153, 153));
        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/estacion-de-autobuses.png"))); // NOI18N
        jLabel1.setText("Estaciones");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, -1));

        lbEstacionA.setText("Ingrese Estacion:");
        getContentPane().add(lbEstacionA, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 76, -1, -1));
        getContentPane().add(tfEstacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 73, 201, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 187, 650, 10));

        jButton1.setBackground(new java.awt.Color(0, 153, 153));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardarSQL.png"))); // NOI18N
        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 204, 127, -1));

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
        getContentPane().add(btReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 204, 121, -1));

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
        getContentPane().add(btHTML, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 204, 120, -1));

        btModificar.setBackground(new java.awt.Color(0, 153, 153));
        btModificar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btModificar.setForeground(new java.awt.Color(255, 255, 255));
        btModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/modificarSQL.png"))); // NOI18N
        btModificar.setText("MODIFICAR");
        btModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 246, -1, -1));

        btEliminar.setBackground(new java.awt.Color(0, 153, 153));
        btEliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminarSQL.png"))); // NOI18N
        btEliminar.setText("ELIMINAR");
        btEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 247, -1, 29));

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
        getContentPane().add(btBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(328, 70, -1, -1));
        getContentPane().add(tfBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 73, 204, -1));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 294, 650, 10));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo9.jpg"))); // NOI18N

        btRegresar.setBackground(new java.awt.Color(0, 153, 153));
        btRegresar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/regresar.png"))); // NOI18N
        btRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btRegresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 606, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btRegresar)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-9, 0, 800, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 // TODO add your handling code here:
metodoEstacion objetoC = new metodoEstacion();
try {
    String estacion = tfEstacion.getText();

    if (estacion.isEmpty()) {
        JOptionPane.showMessageDialog(null, "El campo de estación está vacío", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Salir del método si el campo de estación está vacío
    }

    objetoC.insertarEstaciones(estacion);
    Limpiar();
} catch (SQLException e) {
    if (e.getErrorCode() == 1062) {
        JOptionPane.showMessageDialog(null, "Las estaciones ya están registradas", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(null, "Error al registrar la estación: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}










        
    }//GEN-LAST:event_jButton1ActionPerformed

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
    ficheroSalida = new BufferedWriter(new FileWriter(new File("reporteEstaciones.html")));

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
    ficheroSalida.write("<h1 class='fade-in'>Reporte de ESTACIONES </h1>");
    ficheroSalida.write("<table>");
    ficheroSalida.write("<tr><th> </th><th>ESTACION  </th><th>ORDEN </th></tr>");

    Connection connection = conectar.establecerConexion();
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery("SELECT Estacion, Orden FROM estaciones");

    while (resultSet.next()) {
        String estacion = resultSet.getString("Estacion");
        String orden = resultSet.getString("Orden");

       ficheroSalida.write("<tr class='fade-in'><td><img class='bus-icon' src='C:\\Users\\PC\\Documents\\NetBeansProjects\\ProyectoFinalProgramacion1\\src\\imagenes\\estacion-de-autobuses.png'></td><td>" + estacion + "</td><td>" + orden  + "</td></tr>");

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
            ReporteEstaciones.getInstance();
        } catch (SQLException ex) {
            System.out.println("");
        }
        
         
        
    }//GEN-LAST:event_btReporteActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
    try {
    String Orden = tfBuscar.getText();
    if (Orden.isEmpty()) {
         // Configurar el fondo de la ventana de diálogo en blanco
                UIManager.put("OptionPane.background", Color.WHITE);
                UIManager.put("Panel.background", Color.WHITE);
        JOptionPane.showMessageDialog(null, "El campo de texto está vacío", "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
    } else {
        reporteEstacionesPorOrden(Orden);
    }
} catch (SQLException ex) {
    Logger.getLogger(estaciones.class.getName()).log(Level.SEVERE, null, ex);
    JOptionPane.showMessageDialog(null, "Estaciones no encontradas en la base de datos", "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
}
    }//GEN-LAST:event_btBuscarActionPerformed

    private void btModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarActionPerformed
  // TODO add your handling code here:
metodoEstacion objetoC = new metodoEstacion();
try {
    String Orden = tfBuscar.getText(); // Obtener el número de orden del campo de texto
    String EstacionA = tfEstacion.getText(); // Obtener el valor de EstacionA del campo de texto

    if (Orden.isEmpty()) {
        // Configurar el fondo de la ventana de diálogo en blanco
        UIManager.put("OptionPane.background", Color.WHITE);
        UIManager.put("Panel.background", Color.WHITE);
        JOptionPane.showMessageDialog(null, "El campo de texto está vacío", "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
    } else {
        objetoC.modificarEstacion(Orden, EstacionA); // Llamar al método modificarEstacion con los parámetros correspondientes
        JOptionPane.showMessageDialog(null, "Estación modificada", "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
        Limpiar();
    }
} catch (SQLException ex) {
    Logger.getLogger(estaciones.class.getName()).log(Level.SEVERE, null, ex);
}

       

    }//GEN-LAST:event_btModificarActionPerformed

    private void btEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarActionPerformed
 // TODO agrega tu codigo de manejo aqui:
metodoEstacion objetoC = new metodoEstacion();
try {
    String Orden = tfBuscar.getText(); // Obtener el número de orden del campo de texto

    if (Orden.isEmpty()) {
        JOptionPane.showMessageDialog(null, "El campo de texto está vacío", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        return; // Salir del método si el campo de texto está vacío
    }

    objetoC.eliminarEstacion(Orden); // Llamar al método eliminarEstación con el parámetro de Orden
    objetoC.actualizarNumerosFila(Orden); // Actualizar los números de fila restantes
    JOptionPane.showMessageDialog(null, "Estación eliminada", "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
    Limpiar();
} catch (SQLException ex) {
    Logger.getLogger(estaciones.class.getName()).log(Level.SEVERE, null, ex);
}


    }//GEN-LAST:event_btEliminarActionPerformed

    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btEliminar;
    private javax.swing.JButton btHTML;
    private javax.swing.JButton btModificar;
    private javax.swing.JButton btRegresar;
    private javax.swing.JButton btReporte;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbEstacionA;
    private javax.swing.JTextField tfBuscar;
    private javax.swing.JTextField tfEstacion;
    // End of variables declaration//GEN-END:variables

}

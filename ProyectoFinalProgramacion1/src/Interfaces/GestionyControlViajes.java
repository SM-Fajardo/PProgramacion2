/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Clases.ArchivoBus;
import Clases.ArchivoConductores;
import Clases.ArchivoEstacion;
import Clases.ArchivoViajes;
import Clases.Asignar;
import Clases.controlyGestionBus;
import Clases.estaciones;
import Clases.gestionyControlConductores;
import Clases.gestionyControlViajes;
import Metodos.metodoConductores;
import Metodos.metodoViajes;
import VentanasReportes.ReporteConductores;
import VentanasReportes.ReporteViajes;
import com.mycompany.proyectoprogra.conexion;
import java.awt.Color;
import java.awt.KeyboardFocusManager;
import java.awt.Window;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
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
public class GestionyControlViajes extends javax.swing.JFrame {
conexion conectar = new conexion();
    
    
    
    
    
    public GestionyControlViajes( ) {
       
        initComponents();
        
        // Carga la imagen desde el archivo
        String rutaImagen = "C:\\Users\\PC\\Documents\\NetBeansProjects\\ProyectoFinalProgramacion1\\src\\imagenes\\trasnportes veloce.png";
        ImageIcon imagenIcono = new ImageIcon(rutaImagen);

        // Establece la imagen como icono de la ventana
        setIconImage(imagenIcono.getImage());
        this.setLocationRelativeTo(null);//Null es para colocar centrado el JFrame
        setVisible(true);
    }

    
    
    
    
    
     
  private void reporteRutaPorOrden(String Ruta) throws SQLException {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet resultSet = null;

    try {
        // Establecer la conexión con la base de datos
        conn = conectar.establecerConexion();

        // Consultar los viajes en la base de datos filtrando por ruta
        String query = "SELECT Estacion1, Estacion2, Ruta, Buses, Conductor, Fecha, Horario FROM viajes WHERE Ruta = ?";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, Ruta);
        resultSet = stmt.executeQuery();

        // Verificar si se encontraron registros
        if (resultSet.next()) {
            // Obtener los valores de los viajes encontrados
            String estacion1 = resultSet.getString("Estacion1");
    String estacion2 = resultSet.getString("Estacion2");
    String ruta = resultSet.getString("Ruta");
    String buses = resultSet.getString("Buses");
    String conductor = resultSet.getString("Conductor");
    String fecha = resultSet.getString("Fecha");
    String horario = resultSet.getString("Horario");
            // Modificar los datos si es necesario
            // Aquí puedes realizar las modificaciones necesarias en las variables estacionA, estacionB, ruta, buses, conductor, fecha, horario

            // Actualizar los campos de texto con los nuevos valores modificados
            tfEstacionA.setText(estacion1);
            tfEstacionB.setText(estacion2);
            tfRuta.setText(ruta);
            tfBus.setText(buses);
            tfConductor.setText(conductor);
            tfFecha.setText(fecha);
            tfHorario.setText(horario);
        } else {
            // Si no se encontraron registros, se pueden limpiar los campos de texto
            tfEstacionA.setText("");
            tfEstacionB.setText("");
            tfRuta.setText("");
            tfBus.setText("");
            tfConductor.setText("");
            tfFecha.setText("");
            tfHorario.setText("");
            
            
            // Configurar el fondo de la ventana de diálogo en blanco
                UIManager.put("OptionPane.background", Color.WHITE);
                UIManager.put("Panel.background", Color.WHITE);
            JOptionPane.showMessageDialog(null, "Ruta no encontrada", "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
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
        tfEstacionA.setText("");
        tfEstacionB.setText("");
        tfRuta.setText("");
        tfBus.setText("");
        tfConductor.setText("");
         tfFecha.setText("");
        tfHorario.setText("");
        
        
        
        return null;
    }
    
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lbEstacionI = new javax.swing.JLabel();
        lbEstacionF = new javax.swing.JLabel();
        lbBus = new javax.swing.JLabel();
        lbFecha = new javax.swing.JLabel();
        lbHorario = new javax.swing.JLabel();
        tfEstacionA = new javax.swing.JTextField();
        tfEstacionB = new javax.swing.JTextField();
        tfBus = new javax.swing.JTextField();
        tfFecha = new javax.swing.JTextField();
        tfHorario = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btRegistrar = new javax.swing.JButton();
        btEliminar = new javax.swing.JButton();
        btModificar = new javax.swing.JButton();
        btBuscar = new javax.swing.JButton();
        btRegresar = new javax.swing.JButton();
        lbRuta = new javax.swing.JLabel();
        tfRuta = new javax.swing.JTextField();
        lbCondutor = new javax.swing.JLabel();
        tfConductor = new javax.swing.JTextField();
        btHTML = new javax.swing.JButton();
        btReporte = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/control de viajes.png"))); // NOI18N
        jLabel1.setText("GESTION DE VIAJES");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 13, -1, -1));

        lbEstacionI.setText("Estacion Inicial");
        getContentPane().add(lbEstacionI, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 66, -1, -1));

        lbEstacionF.setText("Estacion Final");
        getContentPane().add(lbEstacionF, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 110, -1, -1));

        lbBus.setText("Buses");
        getContentPane().add(lbBus, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 180, -1, -1));

        lbFecha.setText("Fecha");
        getContentPane().add(lbFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 260, -1, -1));

        lbHorario.setText("Horario");
        getContentPane().add(lbHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 303, -1, -1));
        getContentPane().add(tfEstacionA, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 63, 273, -1));

        tfEstacionB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEstacionBActionPerformed(evt);
            }
        });
        getContentPane().add(tfEstacionB, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 107, 273, -1));
        getContentPane().add(tfBus, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 177, 273, -1));
        getContentPane().add(tfFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 257, 273, -1));
        getContentPane().add(tfHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 300, 273, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 340, 479, 10));

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
        getContentPane().add(btRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 364, -1, -1));

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
        getContentPane().add(btEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 363, 110, 30));

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
        getContentPane().add(btModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 364, -1, -1));

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
        getContentPane().add(btBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 364, -1, -1));

        btRegresar.setBackground(new java.awt.Color(0, 153, 153));
        btRegresar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/regresar.png"))); // NOI18N
        btRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(btRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 455, -1, -1));

        lbRuta.setText("Ruta");
        getContentPane().add(lbRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 145, -1, -1));
        getContentPane().add(tfRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 142, 273, -1));

        lbCondutor.setText("Conductor");
        getContentPane().add(lbCondutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 220, -1, -1));
        getContentPane().add(tfConductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 217, 273, -1));

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
        getContentPane().add(btHTML, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 407, 110, -1));

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
        getContentPane().add(btReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 407, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo9.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 496, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 0, 620, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegistrarActionPerformed
metodoViajes objetoV = new metodoViajes();
boolean error = false; // Bandera para controlar si se ha producido un error
try {
    String Estacion1 = tfEstacionA.getText();
    String Estacion2 = tfEstacionB.getText();
    String Ruta = tfRuta.getText();
    String Bus = tfBus.getText();
    String Conductor = tfConductor.getText();
    String Fecha = tfFecha.getText();
    String Horario = tfHorario.getText();

    if (Estacion1.isEmpty() || Estacion2.isEmpty() || Ruta.isEmpty() || Bus.isEmpty() || Conductor.isEmpty() || Fecha.isEmpty() || Horario.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Uno o más campos están vacíos", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Salir del método si algún campo está vacío
    }
    
    // Verificar si la placa del bus está en uso
    if (objetoV.verificarPlacaEnUso(Bus)) {
        JOptionPane.showMessageDialog(null, "No se puede crear otro viaje con la misma placa hasta que esté disponible de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Salir del método si la placa está en uso
    }

    objetoV.insertarViaje(Estacion1, Estacion2, Ruta, Bus, Conductor, Fecha, Horario);
    Limpiar();
} catch (SQLException e) {
    error = true; // Se ha producido un error
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





    }//GEN-LAST:event_btRegistrarActionPerformed

    private void btEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarActionPerformed
        // TODO add your handling code here:
   metodoViajes objetoV = new metodoViajes();
try {
    String Estacion1 = tfEstacionA.getText();
    String Estacion2 = tfEstacionB.getText();
    String Ruta = tfRuta.getText();
    String Bus = tfBus.getText();
    String Conductor = tfConductor.getText();
    String Fecha = tfFecha.getText();
    String Horario = tfHorario.getText();

    if (Estacion1.isEmpty() || Estacion2.isEmpty() || Ruta.isEmpty() || Bus.isEmpty() || Conductor.isEmpty() || Fecha.isEmpty() || Horario.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Uno o más campos están vacíos", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Salir del método si algún campo está vacío
    }

    objetoV.eliminarViajeYMarcarBusDisponible(Ruta); // Llamar al método eliminarViajeYMarcarBusDisponible con el parámetro de Ruta

    JOptionPane.showMessageDialog(null, "Ruta eliminada con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    Limpiar();

} catch (SQLException ex) {
    Logger.getLogger(gestionyControlConductores.class.getName()).log(Level.SEVERE, null, ex);
}


    }//GEN-LAST:event_btEliminarActionPerformed

    private void btModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarActionPerformed
       
       metodoViajes objetoV = new metodoViajes();
try {
    String Estacion1 = tfEstacionA.getText();
    String Estacion2 = tfEstacionB.getText();
    String Ruta = tfRuta.getText();
    String Bus = tfBus.getText();
    String Conductor = tfConductor.getText();
    String Fecha = tfFecha.getText();
    String Horario = tfHorario.getText();

    
    if (Estacion1.isEmpty() || Estacion2.isEmpty() || Ruta.isEmpty() || Bus.isEmpty() || Conductor.isEmpty() || Fecha.isEmpty() || Horario.isEmpty()) {
        JOptionPane.showMessageDialog(null, "El campo de estación está vacío", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Salir del método si el campo de estación está vacío
    }
    
    objetoV.modificarViaje(Estacion1, Estacion2, Ruta, Bus, Conductor, Fecha, Horario);

    JOptionPane.showMessageDialog(null, "Ruta modificada", "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
    Limpiar();
} catch (SQLException ex) {
    JOptionPane.showMessageDialog(null, "Error al modificar la ruta: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    System.out.println("Código de error: " + ex.getErrorCode());
    ex.printStackTrace();
}

        
    }//GEN-LAST:event_btModificarActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
       
   try {
    String Ruta = tfRuta.getText();
    if (Ruta.isEmpty()) {
        // Configurar el fondo de la ventana de diálogo en blanco
                UIManager.put("OptionPane.background", Color.WHITE);
                UIManager.put("Panel.background", Color.WHITE);
        JOptionPane.showMessageDialog(null, "El campo de texto está vacío", "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
    } else {
    reporteRutaPorOrden(Ruta);
    }
} catch (SQLException ex) {
    Logger.getLogger(estaciones.class.getName()).log(Level.SEVERE, null, ex);
    JOptionPane.showMessageDialog(null, "Ruta no encontrada", "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
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
    ficheroSalida = new BufferedWriter(new FileWriter(new File("reporteviajes.html")));

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
    ficheroSalida.write("<h1 class='fade-in'>Reporte de Viajes </h1>");
    ficheroSalida.write("<table>");
    ficheroSalida.write("<tr><th> </th><th>ESTACION 'A' </th><th>ESTACION 'B' </th><th>RUTA</th><th>BUS </th><th>CONDUCTOR </th><th>FECHA </th><th>HORARIO </th></tr>");

    Connection connection = conectar.establecerConexion();
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery("SELECT Estacion1, Estacion2, Ruta, Buses,Conductor,Fecha,Horario FROM viajes");

    while (resultSet.next()) {
        String Estacion1 = resultSet.getString("Estacion1");
        String Estacion2 = resultSet.getString("Estacion2");
        String Ruta = resultSet.getString("Ruta");
        String Bus = resultSet.getString("Buses");
         String Conductor = resultSet.getString("Conductor");
        String Fecha = resultSet.getString("Fecha");
        String Horario = resultSet.getString("Horario");

       ficheroSalida.write("<tr class='fade-in'><td><img class='bus-icon' src='C:\\Users\\PC\\Documents\\NetBeansProjects\\ProyectoFinalProgramacion1\\src\\imagenes\\control de viajes.png'></td><td>" + Estacion1 + "</td><td>" + Estacion2 + "</td><td>" + Ruta + "</td><td>" + Bus + "</td><td>" + Conductor + "</td><td>" + Fecha + "</td><td>" + Horario + "</td></tr>");

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
            ReporteViajes.getInstance();
        } catch (SQLException ex) {
            System.out.println("");
        }
      
    }//GEN-LAST:event_btReporteActionPerformed

    private void tfEstacionBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEstacionBActionPerformed

    
        
       
    }//GEN-LAST:event_tfEstacionBActionPerformed

  

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
    private javax.swing.JLabel lbBus;
    private javax.swing.JLabel lbCondutor;
    private javax.swing.JLabel lbEstacionF;
    private javax.swing.JLabel lbEstacionI;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JLabel lbHorario;
    private javax.swing.JLabel lbRuta;
    private javax.swing.JTextField tfBus;
    private javax.swing.JTextField tfConductor;
    private javax.swing.JTextField tfEstacionA;
    private javax.swing.JTextField tfEstacionB;
    private javax.swing.JTextField tfFecha;
    private javax.swing.JTextField tfHorario;
    private javax.swing.JTextField tfRuta;
    // End of variables declaration//GEN-END:variables
}

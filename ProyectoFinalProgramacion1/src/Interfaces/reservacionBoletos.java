/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Clases.ArchivoBoleto;
import Clases.ArchivoBus;
import Clases.ArchivoConductores;
import Clases.ArchivoLogin;
import Clases.ArchivoViajes;
import Clases.Asignar;
import Clases.DatosLogin;
import Clases.controlyGestionBus;
import Clases.estaciones;
import Clases.gestionyControlConductores;
import Clases.gestionyControlViajes;
import Clases.reservacion;
import Impresion.Imprimir;
import Metodos.metodoBoleto;
import VentanasReportes.ReporteBoleto;
import VentanasReportes.ReporteViajes;
import com.mycompany.proyectoprogra.conexion;
import java.awt.Color;
import java.awt.KeyboardFocusManager;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.print.attribute.ResolutionSyntax.DPI;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author PC
 */
public class reservacionBoletos extends javax.swing.JFrame {

    conexion conectar = new conexion();

    public reservacionBoletos() {

        initComponents();
        setVisible(true);
// Carga la imagen desde el archivo
        String rutaImagen = "C:\\Users\\PC\\Documents\\NetBeansProjects\\ProyectoFinalProgramacion1\\src\\imagenes\\trasnportes veloce.png";
        ImageIcon imagenIcono = new ImageIcon(rutaImagen);

        // Establece la imagen como icono de la ventana
        setIconImage(imagenIcono.getImage());
        setLocationRelativeTo(null);//Null es para colocar centrado el JFrame

    }

private void reporteBoletoPorOrden(String NoBoleto) throws SQLException {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet resultSet = null;

    try {
        // Establecer la conexión con la base de datos
        conn = conectar.establecerConexion();

        // Consultar los viajes en la base de datos filtrando por ruta
        String query = "SELECT Nombre, Apellido, DPI, Boleto, Precio, Fecha, Bus, Ruta FROM boletos WHERE Boleto = ?";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, NoBoleto);
        resultSet = stmt.executeQuery();

        // Verificar si se encontraron registros
        if (resultSet.next()) {
            // Obtener los valores de los viajes encontrados
            String nombre = resultSet.getString("Nombre");
            String apellido = resultSet.getString("Apellido");
            String dpi = resultSet.getString("DPI");
            String Noboleto = resultSet.getString("Boleto");
            String precio = resultSet.getString("Precio");
            String fechaStr = resultSet.getString("Fecha");
            String bus = resultSet.getString("Bus");
            String ruta = resultSet.getString("Ruta");

            // Modificar los datos si es necesario
            // Actualizar los campos de texto con los nuevos valores modificados
            tfNombre.setText(nombre);
            tfApellido.setText(apellido);
            tfDPI.setText(dpi);
            tfnBoletos.setText(Noboleto);
            tfPrecio.setText(precio);

            // Formatear la fecha al formato "dd/MM/yyyy"
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha = sdf.parse(fechaStr);

            JCalendario.setDate(fecha); // Establecer la fecha en el JDateChooser
            JCalendario.setDateFormatString("dd/MM/yyyy"); // Establecer el formato de fecha

            tfBus.setText(bus);
            tfRuta.setText(ruta);
        } else {
            // Si no se encontraron registros, se pueden limpiar los campos de texto
            tfNombre.setText("");
            tfApellido.setText("");
            tfDPI.setText("");
            tfnBoletos.setText("");
            tfPrecio.setText("");
            JCalendario.setDate(null); // Limpiar la fecha en el JDateChooser
            tfBus.setText("");
            tfRuta.setText("");
            UIManager.put("OptionPane.background", Color.WHITE);
            UIManager.put("Panel.background", Color.WHITE);
            JOptionPane.showMessageDialog(null, "Boleto no encontrado", "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (ParseException ex) {
        JOptionPane.showMessageDialog(null, "Error al convertir la fecha: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
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


    public Asignar Limpiar() {
        tfNombre.setText("");
        tfApellido.setText("");
        tfDPI.setText("");
        tfnBoletos.setText("");
      JCalendario.setDateFormatString("");
      
        tfPrecio.setText("");
        tfBus.setText("");
        tfRuta.setText("");

        return null;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        tfnBoletos = new javax.swing.JTextField();
        tfApellido = new javax.swing.JTextField();
        tfDPI = new javax.swing.JTextField();
        tfPrecio = new javax.swing.JTextField();
        btRegistrar = new javax.swing.JButton();
        btEliminar = new javax.swing.JButton();
        btModificar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btBuscar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tfRuta = new javax.swing.JTextField();
        tfBus = new javax.swing.JTextField();
        btHTML = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        btReporte = new javax.swing.JButton();
        btImprimir = new javax.swing.JButton();
        JCalendario = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boletos.png"))); // NOI18N
        jLabel1.setText("Reservaciones");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 13, -1, -1));

        jLabel2.setText("Nombre");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 107, -1, -1));

        jLabel3.setText("Apellido");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 110, -1, -1));

        jLabel4.setText("DPI");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 150, -1, -1));

        jLabel7.setText("No. Boleto");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 150, -1, -1));

        jLabel8.setText("Fecha");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 190, -1, -1));

        jLabel9.setText("Precio");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 190, -1, -1));
        getContentPane().add(tfNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 107, 150, -1));
        getContentPane().add(tfnBoletos, new org.netbeans.lib.awtextra.AbsoluteConstraints(372, 147, 150, -1));
        getContentPane().add(tfApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(372, 107, 150, -1));
        getContentPane().add(tfDPI, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 147, 150, -1));

        tfPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPrecioActionPerformed(evt);
            }
        });
        getContentPane().add(tfPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 187, 150, -1));

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
        getContentPane().add(btRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 308, -1, -1));

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
        getContentPane().add(btEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 308, -1, 29));

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
        getContentPane().add(btModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(256, 308, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 285, 638, 10));

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
        getContentPane().add(btBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 308, 98, -1));

        jLabel10.setText("Bus");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 230, -1, -1));

        jLabel11.setText("Ruta");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 230, -1, -1));
        getContentPane().add(tfRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(372, 227, 150, -1));
        getContentPane().add(tfBus, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 227, 150, -1));

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
        getContentPane().add(btHTML, new org.netbeans.lib.awtextra.AbsoluteConstraints(486, 308, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo9.jpg"))); // NOI18N

        jButton4.setBackground(new java.awt.Color(0, 153, 153));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/regresar.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

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

        btImprimir.setBackground(new java.awt.Color(0, 153, 153));
        btImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/print_102332.png"))); // NOI18N
        btImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 567, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btReporte)))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(193, 193, 193)))
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(btReporte)
                .addGap(3, 3, 3)
                .addComponent(btImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 0, 810, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPrecioActionPerformed

    private void btRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegistrarActionPerformed
        // TODO add your handling code here:

metodoBoleto objetoV = new metodoBoleto();
boolean error = false; // Bandera para controlar si se ha producido un error
try {
    String Nombre = tfNombre.getText();
    String Apellido = tfApellido.getText();
    String DPI = tfDPI.getText();
    String NoBoleto = tfnBoletos.getText();
    String Precio = tfPrecio.getText();
    String Bus = tfBus.getText();
    String Ruta = tfRuta.getText();
    Date Fecha = JCalendario.getDate(); // Obtener la fecha seleccionada del JDateChooser

    if (Nombre.isEmpty() || Apellido.isEmpty() || DPI.isEmpty() || NoBoleto.isEmpty() || Precio.isEmpty() || Fecha == null || Bus.isEmpty() || Ruta.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Uno o más campos están vacíos", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Salir del método si algún campo está vacío
    }

    // Formatear la fecha en el formato deseado
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String fechaFormateada = sdf.format(Fecha);

    objetoV.insertarBoleto(Nombre, Apellido, DPI, NoBoleto, Precio, fechaFormateada, Bus, Ruta);
    Limpiar();
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

    }//GEN-LAST:event_btRegistrarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         MenuP vmenu = new MenuP();
        vmenu.setVisible(true);
         dispose();
           
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        // TODO add your handling code here:
      try {
    String Boleto = tfnBoletos.getText();
    if (Boleto.isEmpty()) {
        // Configurar el fondo de la ventana de diálogo en blanco
        UIManager.put("OptionPane.background", Color.WHITE);
        UIManager.put("Panel.background", Color.WHITE);
        JOptionPane.showMessageDialog(null, "El campo de texto está vacío", "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
    } else {
        reporteBoletoPorOrden(Boleto);
    }
} catch (SQLException ex) {
    Logger.getLogger(estaciones.class.getName()).log(Level.SEVERE, null, ex);
    JOptionPane.showMessageDialog(null, "Boleto no encontrado", "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
}


    }//GEN-LAST:event_btBuscarActionPerformed

    private void btEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarActionPerformed

        metodoBoleto objetoV = new metodoBoleto();
        try {
            String Nombre = tfNombre.getText();
    String Apellido = tfApellido.getText();
    String DPI = tfDPI.getText();
    String Boleto = tfnBoletos.getText();
    String Precio = tfPrecio.getText();
    Date Fecha = JCalendario.getDate(); // Obtener la fecha seleccionada del JDateChooser
    String Bus = tfBus.getText();
    String Ruta = tfRuta.getText();


    
    if (Nombre.isEmpty() || Apellido.isEmpty() || DPI.isEmpty() || Boleto.isEmpty() || Precio.isEmpty() || Fecha==null || Bus.isEmpty()|| Ruta.isEmpty()) {
        JOptionPane.showMessageDialog(null, "El campo de estación está vacío", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Salir del método si el campo de estación está vacío
    }
    
            objetoV.eliminarBoleto(Boleto); // Llamar al método eliminarEstacion con el parámetro de Orden

            JOptionPane.showMessageDialog(null, "Boleto eliminado", "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
            Limpiar();
        } catch (SQLException ex) {
            Logger.getLogger(gestionyControlConductores.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btEliminarActionPerformed

    private void btModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarActionPerformed
        // TODO add your handling code here:
    metodoBoleto objetoV = new metodoBoleto();
try {
    String Nombre = tfNombre.getText();
    String Apellido = tfApellido.getText();
    String DPI = tfDPI.getText();
    String Boleto = tfnBoletos.getText();
    String Precio = tfPrecio.getText();
    Date Fecha = JCalendario.getDate(); // Obtener la fecha seleccionada del JDateChooser
    String Bus = tfBus.getText();
    String Ruta = tfRuta.getText();

    if (Nombre.isEmpty() || Apellido.isEmpty() || DPI.isEmpty() || Boleto.isEmpty() || Precio.isEmpty() || Fecha == null || Bus.isEmpty() || Ruta.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Uno o más campos están vacíos", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Salir del método si algún campo está vacío
    }

    // Formatear la fecha en el formato deseado
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String fechaFormateada = sdf.format(Fecha);

    objetoV.modificarBoleto(Nombre, Apellido, DPI, Boleto, Precio, fechaFormateada, Bus, Ruta);

    JOptionPane.showMessageDialog(null, "Boleto modificado", "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
    Limpiar();
} catch (SQLException ex) {
    JOptionPane.showMessageDialog(null, "Error al modificar el boleto: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    System.out.println("Código de error: " + ex.getErrorCode());
    ex.printStackTrace();
} catch (Exception ex) {
    JOptionPane.showMessageDialog(null, "Error al convertir la fecha: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    ex.printStackTrace();
}



       
    }//GEN-LAST:event_btModificarActionPerformed

    private void btHTMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHTMLActionPerformed
BufferedWriter ficheroSalida;

try {
    ficheroSalida = new BufferedWriter(new FileWriter(new File("reporteBoleto.html")));

    // Escribir encabezado y estilos
    ficheroSalida.write("<HTML><HEAD><TITLE>REPORTE BOLETOS</TITLE>");
    ficheroSalida.write("<style>");
    ficheroSalida.write("body { font-family: Arial, sans-serif; margin: 20px; background-color: #f1f1f1; }");
    ficheroSalida.write("h1 { text-align: center; color: #333; }");
    ficheroSalida.write(".fade-in { animation: fadeIn 1s; }");
    ficheroSalida.write(".grid-container { display: grid; grid-template-columns: repeat(auto-fill, minmax(300px, 1fr)); grid-gap: 20px; }");
    ficheroSalida.write(".block { padding: 10px; background-color: #fff; border: 1px solid #ddd; }");
    ficheroSalida.write(".block:hover { animation: shake 0.5s; }");
    ficheroSalida.write("@keyframes shake { 0% { transform: translateX(0); } 10% { transform: translateX(-5px); } 20% { transform: translateX(5px); } 30% { transform: translateX(-5px); } 40% { transform: translateX(5px); } 50% { transform: translateX(-5px); } 60% { transform: translateX(5px); } 70% { transform: translateX(-5px); } 80% { transform: translateX(5px); } 90% { transform: translateX(-5px); } 100% { transform: translateX(0); } }");
    ficheroSalida.write("</style>");
    ficheroSalida.write("</HEAD><BODY>");

    // Escribir título
    ficheroSalida.write("<h1 class='fade-in'>Reporte de Boletos</h1>");

    // Obtener datos de la base de datos
    Connection connection = conectar.establecerConexion();
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery("SELECT Nombre, Apellido, DPI, Boleto, Precio, Fecha, Bus, Ruta FROM boletos");

    // Iniciar la cuadrícula
    ficheroSalida.write("<div class='fade-in grid-container'>");

    // Escribir datos en bloques separados
    int contador = 1;
    while (resultSet.next()) {
        String Nombre = resultSet.getString("Nombre");
        String Apellido = resultSet.getString("Apellido");
        String DPI = resultSet.getString("DPI");
        String Boleto = resultSet.getString("Boleto");
        String Precio = resultSet.getString("Precio");
        String Fecha = resultSet.getString("Fecha");
        String Bus = resultSet.getString("Bus");
        String Ruta = resultSet.getString("Ruta");
 // Ajustar la posición del siguiente bloque en forma de tabla
int anchoBloque = 530; // Ancho del bloque (imagen del boleto)
int altoBloque = 246; // Alto del bloque (imagen del boleto)
int espacioHorizontal = 20; // Espacio horizontal entre bloques
int espacioVertical = 20; // Espacio vertical entre bloques
int columnas = 3; // Número de columnas

int fila = (contador - 1) % columnas; // Calcular la fila actual
int columna = (contador - 1) / columnas; // Calcular la columna actual

int margenSuperior = 80; // Margen superior para evitar choques con el título
int leftSiguienteBloque = columna * (anchoBloque + espacioHorizontal);
int topSiguienteBloque = fila * (altoBloque + espacioVertical) + margenSuperior;

ficheroSalida.write("<div class='fade-in block' style='position: absolute; top: " + topSiguienteBloque + "px; left: " + leftSiguienteBloque + "px; background-color: transparent; margin: 0; border: none;'>");
ficheroSalida.write("<img src='C:\\Users\\PC\\Documents\\NetBeansProjects\\ProyectoFinalProgramacion1\\src\\imagenes\\boletohtml.png' width='" + anchoBloque + "' height='" + altoBloque + "' style='position: absolute; top: 0; left: 0;'>");
ficheroSalida.write("<h2 style='position: absolute; top: 10px; left: 40px;'>Boleto " + contador + "</h2>");
ficheroSalida.write("<p style='position: absolute; top: 70px; left: 80px; font-size: 14px;'><strong>NOMBRE:</strong> " + Nombre + "</p>");
ficheroSalida.write("<p style='position: absolute; top: 70px; left: 340px; font-size: 14px;'><strong>APELLIDO:</strong> " + Apellido + "</p>");
ficheroSalida.write("<p style='position: absolute; top: 100px; left: 80px; font-size: 14px;'><strong>DPI:</strong> " + DPI + "</p>");
ficheroSalida.write("<p style='position: absolute; top: 100px; left: 340px; font-size: 14px;'><strong>BOLETO:</strong> " + Boleto + "</p>");
ficheroSalida.write("<p style='position: absolute; top: 130px; left: 80px; font-size: 14px;'><strong>PRECIO:</strong> " + Precio + "</p>");
ficheroSalida.write("<p style='position: absolute; top: 130px; left: 340px; font-size: 14px;'><strong>FECHA:</strong> " + Fecha + "</p>");
ficheroSalida.write("<p style='position: absolute; top: 160px; left: 80px; font-size: 14px; white-space: nowrap;'><strong>BUS:</strong> " + Bus + "</p>");
ficheroSalida.write("<p style='position: absolute; top: 160px; left: 340px; font-size: 14px;'><strong>RUTA:</strong> " + Ruta + "</p>");
ficheroSalida.write("</div>");

contador++;


    }

    // Cerrar etiquetas HTML
    ficheroSalida.write("</div></BODY></HTML>");

    // Cerrar archivo y conexión a la base de datos
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
            ReporteBoleto.getInstance();
        } catch (SQLException ex) {
            System.out.println("");
        }
      
    }//GEN-LAST:event_btReporteActionPerformed

    private void btImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImprimirActionPerformed
        String Nombre = tfNombre.getText();
    String Apellido = tfApellido.getText();
    String DPI = tfDPI.getText();
    String NoBoleto = tfnBoletos.getText();
    String Precio = tfPrecio.getText();
   String Fecha = JCalendario.getDateFormatString();
    String Bus = tfBus.getText();
    String Ruta = tfRuta.getText();
        
        
        
        Imprimir imprimirFrame = new Imprimir();
        imprimirFrame.bill_print(Nombre, Apellido, DPI, NoBoleto, Precio, Fecha, Bus, Ruta);
     
        
        
    }//GEN-LAST:event_btImprimirActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser JCalendario;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btEliminar;
    private javax.swing.JButton btHTML;
    private javax.swing.JButton btImprimir;
    private javax.swing.JButton btModificar;
    private javax.swing.JButton btRegistrar;
    private javax.swing.JButton btReporte;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField tfApellido;
    private javax.swing.JTextField tfBus;
    private javax.swing.JTextField tfDPI;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfPrecio;
    private javax.swing.JTextField tfRuta;
    private javax.swing.JTextField tfnBoletos;
    // End of variables declaration//GEN-END:variables
}

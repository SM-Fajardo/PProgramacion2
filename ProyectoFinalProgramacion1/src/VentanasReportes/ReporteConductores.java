/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VentanasReportes;

import Clases.controlyGestionBus;
import Clases.gestionyControlConductores;
import Interfaces.GestionyControlConductores;
import com.mycompany.proyectoprogra.conexion;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

/**
 *
 * @author PC
 */
public class ReporteConductores extends javax.swing.JFrame {

     conexion conectar = new conexion();
private DefaultListModel <String> l1;
private DefaultListModel <String> l2;
private DefaultListModel <String> l3;
private DefaultListModel <String> l4;
private DefaultListModel <String> l5;
    

private static ReporteConductores instance = null;
    
    public ReporteConductores() throws SQLException   {
       
         initComponents(); //Inicializando los componentes.
         // Carga la imagen desde el archivo
        String rutaImagen = "C:\\Users\\PC\\Documents\\NetBeansProjects\\ProyectoFinalProgramacion1\\src\\imagenes\\trasnportes veloce.png";
        ImageIcon imagenIcono = new ImageIcon(rutaImagen);

        // Establece la imagen como icono de la ventana
        setIconImage(imagenIcono.getImage());
         reporteConductores();
        setLocationRelativeTo(null);//Null es para colocar centrado el JFrame
        setVisible(true);
        
    }

    
    
    
     public static ReporteConductores getInstance() throws SQLException{
        if (instance == null){
            instance= new ReporteConductores();
        }
        return instance;
    }
    
    
    
     
        
         
public void reporteConductores() throws SQLException            
    {
        l1 = new DefaultListModel<>();
        l2 = new DefaultListModel<>();
        l3 = new DefaultListModel<>();
        l4 = new DefaultListModel<>();
        l5 = new DefaultListModel<>();
  
        ResultSet resultSet = null;

        try {
            Statement statement = conectar.establecerConexion().createStatement();

            // Create and execute a SELECT SQL statement.
            String selectSql = "Select * from conductores ";
            resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) {
                l1.addElement(resultSet.getString(1));
                l2.addElement(resultSet.getString(2));
                l3.addElement(resultSet.getString(3));
                l4.addElement(resultSet.getString(4));
                l5.addElement(resultSet.getString(5));
                
            }
            lista1.setModel(l1);
            lista2.setModel(l2);
            lista3.setModel(l3);
            lista4.setModel(l4);
            lista5.setModel(l5);
           
        }
        catch (SQLException e) {
            System.out.println("");
        }
    }
    
    
    
    
    
    
    
    
    
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista1 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        lista2 = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        lista3 = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        lista4 = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        lista5 = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btRegresar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 153));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/conductor-de-autobus.png"))); // NOI18N
        jLabel1.setText("REPORTE CONDUCTORES");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 13, -1, -1));

        jScrollPane1.setViewportView(lista1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 136, 131, 266));

        jScrollPane2.setViewportView(lista2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(317, 136, 89, 266));

        jScrollPane3.setViewportView(lista3);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 136, 102, 266));

        jScrollPane4.setViewportView(lista4);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(629, 136, 89, 266));

        jScrollPane5.setViewportView(lista5);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(783, 136, 76, 266));

        jLabel4.setText("DPI");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(501, 92, -1, -1));

        jLabel5.setText("LICENCIA");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(643, 92, -1, -1));

        jLabel6.setText("T.LICENCIA");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(783, 92, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo2.jpeg"))); // NOI18N

        btRegresar.setBackground(new java.awt.Color(153, 0, 153));
        btRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/regresar.png"))); // NOI18N
        btRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegresarActionPerformed(evt);
            }
        });

        jLabel2.setText("NOMBRE");

        jLabel3.setText("APELLIDO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btRegresar)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel2)
                        .addGap(93, 93, 93)
                        .addComponent(jLabel3)
                        .addContainerGap(565, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btRegresar)
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addContainerGap(323, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegresarActionPerformed
        // TODO add your handling code here:
     
        dispose();

    }//GEN-LAST:event_btRegresarActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JList<String> lista1;
    private javax.swing.JList<String> lista2;
    private javax.swing.JList<String> lista3;
    private javax.swing.JList<String> lista4;
    private javax.swing.JList<String> lista5;
    // End of variables declaration//GEN-END:variables
}

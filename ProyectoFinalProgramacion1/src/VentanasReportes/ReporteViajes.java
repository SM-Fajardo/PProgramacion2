/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VentanasReportes;

import Clases.gestionyControlConductores;
import Clases.gestionyControlViajes;
import Interfaces.GestionyControlViajes;
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
public class ReporteViajes extends javax.swing.JFrame {

    
    
     conexion conectar = new conexion();
private DefaultListModel <String> l1;
private DefaultListModel <String> l2;
private DefaultListModel <String> l3;
private DefaultListModel <String> l4;
private DefaultListModel <String> l5;
private DefaultListModel <String> l6;
private DefaultListModel <String> l7;
    
    private static ReporteViajes instance = null;
    
    public ReporteViajes() throws SQLException    {
        
         initComponents(); //Inicializando los componentes.
         // Carga la imagen desde el archivo
        String rutaImagen = "C:\\Users\\PC\\Documents\\NetBeansProjects\\ProyectoFinalProgramacion1\\src\\imagenes\\trasnportes veloce.png";
        ImageIcon imagenIcono = new ImageIcon(rutaImagen);

        // Establece la imagen como icono de la ventana
        setIconImage(imagenIcono.getImage());
         ReporteViajes();
        setLocationRelativeTo(null);//Null es para colocar centrado el JFrame
        setVisible(true);
        
        
        
    }

    
    
     public static ReporteViajes getInstance() throws SQLException{
        if (instance == null){
            instance= new ReporteViajes();
        }
        return instance;
    }
    
    
    
            
public void ReporteViajes() throws SQLException            
    {
        l1 = new DefaultListModel<>();
        l2 = new DefaultListModel<>();
        l3 = new DefaultListModel<>();
        l4 = new DefaultListModel<>();
        l5 = new DefaultListModel<>();
        l6 = new DefaultListModel<>();
        l7 = new DefaultListModel<>();
  
        ResultSet resultSet = null;

        try {
            Statement statement = conectar.establecerConexion().createStatement();

            // Create and execute a SELECT SQL statement.
            String selectSql = "Select * from viajes ";
            resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) {
                l1.addElement(resultSet.getString(1));
                l2.addElement(resultSet.getString(2));
                l3.addElement(resultSet.getString(3));
                l4.addElement(resultSet.getString(4));
                l5.addElement(resultSet.getString(5));
                l6.addElement(resultSet.getString(6));
                l7.addElement(resultSet.getString(7));
                
            }
            lista1.setModel(l1);
            lista2.setModel(l2);
            lista3.setModel(l3);
            lista4.setModel(l4);
            lista5.setModel(l5);
            lista6.setModel(l6);
            lista7.setModel(l7);
           
        }
        catch (SQLException e) {
            System.out.println("");
        }
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btRegresar = new javax.swing.JButton();
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
        jScrollPane6 = new javax.swing.JScrollPane();
        lista6 = new javax.swing.JList<>();
        jScrollPane7 = new javax.swing.JScrollPane();
        lista7 = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(153, 0, 153));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 153));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/control de viajes.png"))); // NOI18N
        jLabel1.setText("REPORTE VIAJES");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 13, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo2.jpeg"))); // NOI18N

        btRegresar.setBackground(new java.awt.Color(153, 0, 153));
        btRegresar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/regresar.png"))); // NOI18N
        btRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegresarActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(lista1);

        jScrollPane2.setViewportView(lista2);

        jScrollPane3.setViewportView(lista3);

        jScrollPane4.setViewportView(lista4);

        jScrollPane5.setViewportView(lista5);

        jScrollPane6.setViewportView(lista6);

        jScrollPane7.setViewportView(lista7);

        jLabel2.setText("ESTACION \"A\"");

        jLabel3.setText("ESTACION\"B\"");

        jLabel4.setText("RUTA");

        jLabel5.setText("BUS");

        jLabel6.setText("CONDUCTOR");

        jLabel7.setText("FECHA");

        jLabel8.setText("HORARIO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btRegresar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel2)
                                .addGap(37, 37, 37)
                                .addComponent(jLabel3)
                                .addGap(47, 47, 47)
                                .addComponent(jLabel4)
                                .addGap(85, 85, 85)
                                .addComponent(jLabel5)
                                .addGap(66, 66, 66)
                                .addComponent(jLabel6)
                                .addGap(56, 56, 56)
                                .addComponent(jLabel7)
                                .addGap(72, 72, 72)
                                .addComponent(jLabel8)))
                        .addGap(0, 40, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btRegresar)
                .addGap(71, 71, 71)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 450));

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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JList<String> lista1;
    private javax.swing.JList<String> lista2;
    private javax.swing.JList<String> lista3;
    private javax.swing.JList<String> lista4;
    private javax.swing.JList<String> lista5;
    private javax.swing.JList<String> lista6;
    private javax.swing.JList<String> lista7;
    // End of variables declaration//GEN-END:variables
}

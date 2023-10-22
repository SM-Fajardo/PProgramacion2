/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VentanasReportes;

import Clases.gestionyControlViajes;
import Clases.reservacion;
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
public class ReporteBoleto extends javax.swing.JFrame {
    
    
     conexion conectar = new conexion();
    private DefaultListModel<String> l1;
    private DefaultListModel<String> l2;
    private DefaultListModel<String> l3;
    private DefaultListModel<String> l4;
    private DefaultListModel<String> l5;
    private DefaultListModel<String> l6;
    private DefaultListModel<String> l7;
    private DefaultListModel<String> l8;
   

private static ReporteBoleto instance = null;
    
    
    public ReporteBoleto() throws SQLException { 
        initComponents(); //Inicializando los componentes.
        
        // Carga la imagen desde el archivo
        String rutaImagen = "C:\\Users\\PC\\Documents\\NetBeansProjects\\ProyectoFinalProgramacion1\\src\\imagenes\\trasnportes veloce.png";
        ImageIcon imagenIcono = new ImageIcon(rutaImagen);

        // Establece la imagen como icono de la ventana
        setIconImage(imagenIcono.getImage());
        
       ReporteBoleto();
        setLocationRelativeTo(null);//Null es para colocar centrado el JFrame
        setVisible(true);
        
        
        
    }

     
     public static ReporteBoleto getInstance() throws SQLException{
        if (instance == null){
            instance= new ReporteBoleto();
        }
        return instance;
    }
    
    
    
    
    
      
            
public void ReporteBoleto() throws SQLException            
    {
        l1 = new DefaultListModel<>();
        l2 = new DefaultListModel<>();
        l3 = new DefaultListModel<>();
        l4 = new DefaultListModel<>();
        l5 = new DefaultListModel<>();
        l6 = new DefaultListModel<>();
        l7 = new DefaultListModel<>();
        l8 = new DefaultListModel<>();
  
        ResultSet resultSet = null;

        try {
            Statement statement = conectar.establecerConexion().createStatement();

            // Create and execute a SELECT SQL statement.
            String selectSql = "Select * from boletos ";
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
                l8.addElement(resultSet.getString(8));
                
            }
            lista1.setModel(l1);
            lista2.setModel(l2);
            lista3.setModel(l3);
            lista4.setModel(l4);
            lista5.setModel(l5);
            lista6.setModel(l6);
            lista7.setModel(l7);
            lista8.setModel(l8);
           
        }
        catch (SQLException e) {
            System.out.println("");
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btRegresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista2 = new javax.swing.JList<>();
        jScrollPane9 = new javax.swing.JScrollPane();
        lista1 = new javax.swing.JList<>();
        jScrollPane10 = new javax.swing.JScrollPane();
        lista4 = new javax.swing.JList<>();
        jScrollPane11 = new javax.swing.JScrollPane();
        lista5 = new javax.swing.JList<>();
        jScrollPane12 = new javax.swing.JScrollPane();
        lista6 = new javax.swing.JList<>();
        jScrollPane13 = new javax.swing.JScrollPane();
        lista7 = new javax.swing.JList<>();
        jScrollPane14 = new javax.swing.JScrollPane();
        lista8 = new javax.swing.JList<>();
        jScrollPane15 = new javax.swing.JScrollPane();
        lista3 = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 153));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boletos.png"))); // NOI18N
        jLabel1.setText("REPORTE BOLETOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 13, 222, -1));

        btRegresar.setBackground(new java.awt.Color(153, 0, 153));
        btRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/regresar.png"))); // NOI18N
        btRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(btRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 13, -1, -1));

        jScrollPane1.setViewportView(lista2);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 119, 100, 334));

        jScrollPane9.setViewportView(lista1);

        getContentPane().add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 118, 100, 334));

        jScrollPane10.setViewportView(lista4);

        getContentPane().add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(472, 119, 100, 334));

        jScrollPane11.setViewportView(lista5);

        getContentPane().add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(584, 119, 100, 334));

        jScrollPane12.setViewportView(lista6);

        getContentPane().add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(696, 119, 100, 334));

        jScrollPane13.setViewportView(lista7);

        getContentPane().add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(808, 119, 100, 334));

        jScrollPane14.setViewportView(lista8);

        getContentPane().add(jScrollPane14, new org.netbeans.lib.awtextra.AbsoluteConstraints(926, 119, 100, 334));

        jScrollPane15.setViewportView(lista3);

        getContentPane().add(jScrollPane15, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 119, 100, 334));

        jLabel2.setText("NOMBRE");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 83, -1, -1));

        jLabel3.setText("APELLIDO");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(274, 85, -1, -1));

        jLabel4.setText("DPI");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 85, -1, -1));

        jLabel5.setText("BOLETO");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(499, 85, -1, -1));

        jLabel6.setText("PRECIO");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(608, 85, -1, -1));

        jLabel7.setText("FECHA");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(731, 85, -1, -1));

        jLabel8.setText("BUS");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(845, 85, -1, -1));

        jLabel9.setText("RUTA");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(963, 85, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo2.jpeg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 954, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegresarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btRegresarActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JList<String> lista1;
    private javax.swing.JList<String> lista2;
    private javax.swing.JList<String> lista3;
    private javax.swing.JList<String> lista4;
    private javax.swing.JList<String> lista5;
    private javax.swing.JList<String> lista6;
    private javax.swing.JList<String> lista7;
    private javax.swing.JList<String> lista8;
    // End of variables declaration//GEN-END:variables
}

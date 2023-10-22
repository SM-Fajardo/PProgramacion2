/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VentanasReportes;


import Interfaces.ControlyGestionBus;
import com.mycompany.proyectoprogra.conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListModel;
import Metodos.metodoBus;
import javax.swing.ImageIcon;


/**
 *
 * @author PC
 */
public class ReporteBus extends javax.swing.JFrame {
    conexion conectar = new conexion();
private DefaultListModel <String> l1;
private DefaultListModel <String> l2;
private DefaultListModel <String> l3;
private DefaultListModel <String> l4;
private DefaultListModel <String> l5;

    private static ReporteBus instance = null;
    
    private ReporteBus() throws SQLException {
        initComponents();
        // Carga la imagen desde el archivo
        String rutaImagen = "C:\\Users\\PC\\Documents\\NetBeansProjects\\ProyectoFinalProgramacion1\\src\\imagenes\\trasnportes veloce.png";
        ImageIcon imagenIcono = new ImageIcon(rutaImagen);

        // Establece la imagen como icono de la ventana
        setIconImage(imagenIcono.getImage());
        
        reportebus();
        setVisible(true);
        setLocationRelativeTo(null);//Null es para colocar centrado el JFrame
    }
    public static ReporteBus getInstance() throws SQLException{
        if (instance == null){
            instance= new ReporteBus();
        }
        return instance;
    }
    
public void reportebus() throws SQLException            
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
            String selectSql = "Select * from buses ";
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
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        lista4 = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        lista3 = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        lista2 = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        lista1 = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        btRegresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista5 = new javax.swing.JList<>();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 153));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/autobus-escolar (1).png"))); // NOI18N
        jLabel1.setText("REPORTE BUS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 13, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo2.jpeg"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 390));

        jScrollPane8.setViewportView(lista4);

        jPanel1.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 110, 110, 200));

        jLabel5.setText("MOTOR");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 80, -1, -1));

        jScrollPane7.setViewportView(lista3);

        jPanel1.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, 90, 200));

        jLabel4.setText("PLACA");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, -1, -1));

        jScrollPane6.setViewportView(lista2);

        jPanel1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 90, 200));

        jLabel3.setText("MODELO");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, -1, -1));

        jScrollPane5.setViewportView(lista1);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 100, 200));

        jLabel2.setText("MARCA");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, -1, -1));

        btRegresar.setBackground(new java.awt.Color(153, 0, 153));
        btRegresar.setForeground(new java.awt.Color(153, 0, 153));
        btRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/regresar.png"))); // NOI18N
        btRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 10, -1, -1));

        jScrollPane1.setViewportView(lista5);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 110, 100, 200));

        jLabel7.setText("ESTADO");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 80, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegresarActionPerformed
        
       

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
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JList<String> lista1;
    private javax.swing.JList<String> lista2;
    private javax.swing.JList<String> lista3;
    private javax.swing.JList<String> lista4;
    private javax.swing.JList<String> lista5;
    // End of variables declaration//GEN-END:variables

   
}

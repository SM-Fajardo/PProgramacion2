/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VentanasReportes;

import Interfaces.MenuP;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class ReportesSQL extends javax.swing.JFrame {

    
    
    
    
    public ReportesSQL() {
        initComponents();
        // Carga la imagen desde el archivo
        String rutaImagen = "C:\\Users\\PC\\Documents\\NetBeansProjects\\ProyectoFinalProgramacion1\\src\\imagenes\\trasnportes veloce.png";
        ImageIcon imagenIcono = new ImageIcon(rutaImagen);

        // Establece la imagen como icono de la ventana
        setIconImage(imagenIcono.getImage());
        setVisible(true);
        setLocationRelativeTo(null);//Null es para colocar centrado el JFrame
    }

  
    public void abrirArchivo(String archivo){ //Método para abrir un archivo en la carpeta del proyecto.
        try{
            File objetofile=new File(archivo);
            Desktop.getDesktop().open(objetofile); //Abriendo el archivo.
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, "No se encuentra el archivo de reporte html, crealo de nuevo.");
        }
    }
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btEstaciones = new javax.swing.JButton();
        btControlBuses = new javax.swing.JButton();
        btControlConductores = new javax.swing.JButton();
        btControlViajes = new javax.swing.JButton();
        btBoletos = new javax.swing.JButton();
        btUsuarios = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Regresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btEstaciones.setBackground(new java.awt.Color(96, 22, 14));
        btEstaciones.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btEstaciones.setForeground(new java.awt.Color(255, 255, 255));
        btEstaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/estacion-de-autobuses.png"))); // NOI18N
        btEstaciones.setText("Estaciones");
        btEstaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEstacionesActionPerformed(evt);
            }
        });
        getContentPane().add(btEstaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 44, -1, -1));

        btControlBuses.setBackground(new java.awt.Color(96, 22, 14));
        btControlBuses.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btControlBuses.setForeground(new java.awt.Color(255, 255, 255));
        btControlBuses.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/autobus-escolar (1).png"))); // NOI18N
        btControlBuses.setText("Control de Buses");
        btControlBuses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btControlBusesActionPerformed(evt);
            }
        });
        getContentPane().add(btControlBuses, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 45, -1, -1));

        btControlConductores.setBackground(new java.awt.Color(96, 22, 14));
        btControlConductores.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btControlConductores.setForeground(new java.awt.Color(255, 255, 255));
        btControlConductores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/conductor-de-autobus.png"))); // NOI18N
        btControlConductores.setText("Control de Conductores");
        btControlConductores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btControlConductoresActionPerformed(evt);
            }
        });
        getContentPane().add(btControlConductores, new org.netbeans.lib.awtextra.AbsoluteConstraints(391, 44, -1, 41));

        btControlViajes.setBackground(new java.awt.Color(96, 22, 14));
        btControlViajes.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btControlViajes.setForeground(new java.awt.Color(255, 255, 255));
        btControlViajes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/control de viajes.png"))); // NOI18N
        btControlViajes.setText("Control deViajes");
        btControlViajes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btControlViajesActionPerformed(evt);
            }
        });
        getContentPane().add(btControlViajes, new org.netbeans.lib.awtextra.AbsoluteConstraints(391, 98, 220, -1));

        btBoletos.setBackground(new java.awt.Color(96, 22, 14));
        btBoletos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btBoletos.setForeground(new java.awt.Color(255, 255, 255));
        btBoletos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boletos.png"))); // NOI18N
        btBoletos.setText("Boletos");
        btBoletos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBoletosActionPerformed(evt);
            }
        });
        getContentPane().add(btBoletos, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 98, 133, -1));

        btUsuarios.setBackground(new java.awt.Color(96, 22, 14));
        btUsuarios.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        btUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuario.png"))); // NOI18N
        btUsuarios.setText("Usuarios");
        btUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUsuariosActionPerformed(evt);
            }
        });
        getContentPane().add(btUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 98, 173, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo12.jpg"))); // NOI18N

        Regresar.setBackground(new java.awt.Color(96, 22, 14));
        Regresar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Regresar.setForeground(new java.awt.Color(255, 255, 255));
        Regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/regresar.png"))); // NOI18N
        Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(Regresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 526, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Regresar)
                .addGap(223, 223, 223))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, -5, 740, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUsuariosActionPerformed
        // TODO add your handling code here:
        try {
            ReporteUsuarios.getInstance();
        } catch (SQLException ex) {
            System.out.println("");
        }
        
    }//GEN-LAST:event_btUsuariosActionPerformed

    private void btEstacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEstacionesActionPerformed
        // TODO add your handling code here:
          
         try {
            ReporteEstaciones.getInstance();
        } catch (SQLException ex) {
            System.out.println("");
        }
         
    }//GEN-LAST:event_btEstacionesActionPerformed

    private void RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarActionPerformed
        // TODO add your handling code here:
         MenuP vmenu = new MenuP();
        vmenu.setVisible(true);
        dispose();
    }//GEN-LAST:event_RegresarActionPerformed

    private void btControlBusesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btControlBusesActionPerformed
        // TODO add your handling code here:
      
           
         try {
            ReporteBus.getInstance();
        } catch (SQLException ex) {
            System.out.println("");
        }
    }//GEN-LAST:event_btControlBusesActionPerformed

    private void btControlConductoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btControlConductoresActionPerformed
        // TODO add your handling code here:
       
           
         try {
            ReporteConductores.getInstance();
        } catch (SQLException ex) {
            System.out.println("");
        }
    }//GEN-LAST:event_btControlConductoresActionPerformed

    private void btBoletosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBoletosActionPerformed
        // TODO add your handling code here:
        try {
            ReporteBoleto.getInstance();
        } catch (SQLException ex) {
            System.out.println("");
        }
        
    }//GEN-LAST:event_btBoletosActionPerformed

    private void btControlViajesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btControlViajesActionPerformed
        // TODO add your handling code here:
       try {
            ReporteViajes.getInstance();
        } catch (SQLException ex) {
            System.out.println("");
        }
    }//GEN-LAST:event_btControlViajesActionPerformed

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Regresar;
    private javax.swing.JButton btBoletos;
    private javax.swing.JButton btControlBuses;
    private javax.swing.JButton btControlConductores;
    private javax.swing.JButton btControlViajes;
    private javax.swing.JButton btEstaciones;
    private javax.swing.JButton btUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

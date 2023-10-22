/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Impresion;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class Imprimir extends javax.swing.JFrame {

    
    public Imprimir() {
        initComponents();
        // Carga la imagen desde el archivo
        String rutaImagen = "C:\\Users\\PC\\Documents\\NetBeansProjects\\ProyectoFinalProgramacion1\\src\\imagenes\\trasnportes veloce.png";
        ImageIcon imagenIcono = new ImageIcon(rutaImagen);

        // Establece la imagen como icono de la ventana
        setIconImage(imagenIcono.getImage());
        setVisible(true);
         setLocationRelativeTo(null);//Null es para colocar centrado el JFrame
    }
 public void bill_print(String nombre, String apellido, String dpi, String noBoleto, String precio, String fecha, String bus, String ruta) {
    try {
        // Diseño de la factura
        bill.append("===============================================\n");
        bill.append("                          \n");
        bill.append("              Amatitlan, Guatemala            \n");
        bill.append("              +502-41224120                   \n");
        bill.append("===============================================\n");
        bill.append("           BOLETO DE TRANSPORTEVELOCE          \n");
        bill.append("===============================================\n");
        bill.append("\n");

        // Datos del cliente
        bill.append("DATOS DEL CLIENTE:\n");
        bill.append(String.format("Nombre:   %s\n", nombre));
        bill.append(String.format("Apellido: %s\n", apellido));
        bill.append(String.format("DPI:      %s\n", dpi));
        bill.append("\n");

        // Detalles de la compra
        bill.append("DETALLES DE LA COMPRA:\n");
        bill.append(String.format("%-4s %-12s %-10s %-10s\n", "No.", "Artículo", "Precio", "Total"));
        bill.append("-----------------------------------------------\n");
        bill.append(String.format("%-4s %-12s %-10s %-10s\n", noBoleto, "Boleto", precio, precio));
        // Aquí puedes agregar los detalles adicionales de la compra si corresponde
        bill.append("\n");

        // Total
        bill.append(String.format("%-36s %-10s\n", "Total:", precio));
        bill.append("===============================================\n");
        bill.append("        ¡Gracias por viajar con nosotros!       \n");
        bill.append("===============================================\n");

        // Imprimir la factura
        bill.print();
    } catch (PrinterException ex) {
        Logger.getLogger(Imprimir.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    
    
    
    
    
    
    
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        bill = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/marca de agua-PhotoRoom.png-PhotoRoom.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, 160, 70));

        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 2, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/trasnportes veloce.png"))); // NOI18N
        jLabel1.setText("          TRASPORTES VELOCE S.A.");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 270, -1));

        bill.setColumns(20);
        bill.setFont(new java.awt.Font("Segoe UI Historic", 3, 12)); // NOI18N
        bill.setRows(5);
        jScrollPane2.setViewportView(bill);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea bill;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}

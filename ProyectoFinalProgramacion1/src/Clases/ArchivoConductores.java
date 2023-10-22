/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class ArchivoConductores {
    
     public void escribirC(ArrayList<gestionyControlConductores> arrayConductor) {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("bConductores.dat"))) {
            salida.writeObject(arrayConductor);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al escribir en archivo binario.");
        }
    }

    public ArrayList<gestionyControlConductores> leerC() {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("bConductores.dat"))) {
            return (ArrayList<gestionyControlConductores>) entrada.readObject();
        } catch (IOException | ClassNotFoundException e) {
          System.err.println("Error al leer objeto desde archivo binario: " + e.getMessage());
          
            return new ArrayList<>();
        }
    }

}

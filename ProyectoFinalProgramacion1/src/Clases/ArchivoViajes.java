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
public class ArchivoViajes {
     public void escribirV(ArrayList<gestionyControlViajes> arrayViaje) {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("bViaje.dat"))) {
            salida.writeObject(arrayViaje);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al escribir en archivo binario.");
        }
    }

    public ArrayList<gestionyControlViajes> leerV() {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("bViaje.dat"))) {
            return (ArrayList<gestionyControlViajes>) entrada.readObject();
        } catch (IOException | ClassNotFoundException e) {
          System.err.println("Error al leer objeto desde archivo binario: " + e.getMessage());
          
            return new ArrayList<>();
        }
    }
}

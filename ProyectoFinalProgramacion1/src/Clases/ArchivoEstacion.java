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
public class ArchivoEstacion {
    public void escribir(ArrayList<estaciones> arrayBoleto) {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("bEstacion.dat"))) {
            salida.writeObject(arrayBoleto);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al escribir en archivo binario.");
        }
    }

    public ArrayList<estaciones> leer() {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("bEstacion.dat"))) {
            return (ArrayList<estaciones>) entrada.readObject();
        } catch (IOException | ClassNotFoundException e) {
          System.err.println("Error al leer objeto desde archivo binario: " + e.getMessage());
          
            return new ArrayList<>();
        }
    }
    
    
}

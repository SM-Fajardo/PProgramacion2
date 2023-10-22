/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;





public class ArchivoLogin {
// Método para escribir el ArrayList de DatosLogin en un archivo binario
    public void escribir(ArrayList<DatosLogin> arrayUsuarios) {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("bUsuarios.dat"))) {
            salida.writeObject(arrayUsuarios);// Se escribe el ArrayList en el archivo
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al escribir en archivo binario.");
        }
    }
// Método para leer el contenido de un archivo binario y devolverlo como ArrayList de DatosLogin
    public ArrayList<DatosLogin> leer() {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("bUsuarios.dat"))) {
            return (ArrayList<DatosLogin>) entrada.readObject();// Se lee el objeto del archivo y se realiza un casting a ArrayList de DatosLogin
        } catch (IOException | ClassNotFoundException e) {
          System.err.println("Error al leer objeto desde archivo binario: " + e.getMessage());
          
            return new ArrayList<>();
        }
    }

}




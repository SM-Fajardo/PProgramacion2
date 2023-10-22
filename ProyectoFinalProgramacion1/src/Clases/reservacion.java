/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.*;
import java.io.Serializable;

/**
 *
 * @author PC
 */
public class reservacion implements Serializable {
    
    public String Nombre;
    public String Apellido;
    public String DPI;
    public String nBoletos;
    public String Fecha;
    public String Precio;
    public String Bus;
    public String Ruta;

    
    public reservacion(String Nombre, String Apellido, String DPI, String nBoletos, String Fecha, String Precio,String Bus,String Ruta) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.DPI = DPI;
        this.nBoletos = nBoletos;
        this.Fecha = Fecha;
        this.Precio = Precio;
        this.Bus = Bus;
        this.Ruta = Ruta;
        

    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getDPI() {
        return DPI;
    }

    public void setDPI(String DPI) {
        this.DPI = DPI;
    }



    public String getnBoletos() {
        return nBoletos;
    }

    public void setnBoletos(String nBoletos) {
        this.nBoletos = nBoletos;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String Precio) {
        this.Precio = Precio;
    }

    public String getBus() {
        return Bus;
    }

    public void setBus(String Bus) {
        this.Bus = Bus;
    }

    public String getRuta() {
        return Ruta;
    }

    public void setRuta(String Ruta) {
        this.Ruta = Ruta;
    }

    
    
    
     
    
    
}

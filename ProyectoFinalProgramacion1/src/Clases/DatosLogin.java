/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;


import java.io.*;
import java.io.Serializable;

public class DatosLogin implements Serializable {
    private String nombre;
    private String apellido;
    private String usuario;
    private String contraseña;

    
    
    //es el construcotor de las clases 
    public DatosLogin(String nombre, String apellido, String usuario, String contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public static void main(String[] args) throws IOException {
        DatosLogin usuario = new DatosLogin("Juan", "Pérez", "jperez", "contraseña123");

        FileOutputStream fos = new FileOutputStream("usuario.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(usuario);

        oos.close();
        fos.close();
    }
}

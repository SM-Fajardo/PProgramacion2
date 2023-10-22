/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class gestionyControlConductores implements Serializable {
    public String Nombre;
    public String Apellido;
    public String DPI;
    public String NoLicencia;
    public String TLicencia;
    
    public gestionyControlConductores(String Nombre, String Apellido, String DPI, String NoLicencia, String TLicencia) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.DPI = DPI;
        this.NoLicencia = NoLicencia;
        this.TLicencia = TLicencia;
        
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

    public String getNoLicencia() {
        return NoLicencia;
    }

    public void setNoLicencia(String NoLicencia) {
        this.NoLicencia = NoLicencia;
    }

    public String getTLicencia() {
        return TLicencia;
    }

    public void setTLicencia(String TLicencia) {
        this.TLicencia = TLicencia;
    }
    
    
    
}

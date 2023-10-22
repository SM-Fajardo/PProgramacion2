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
public class gestionyControlViajes implements Serializable  {
    public String EstacionI;
    public String EstacionF;
    public String Ruta;
    public String Bus;
    public String Conductor;
    public String Fecha;
    public String Horario;

     
     public gestionyControlViajes(String EstcionI, String EstacionF, String Ruta, String Bus, String Conductor, String Fecha, String Horario) {
        this.EstacionI = EstcionI;
        this.EstacionF = EstacionF;
        this.Ruta = Ruta;
        this.Bus = Bus;
        this.Conductor= Conductor;
        this.Fecha = Fecha;
        this.Horario = Horario;
        
    }

    public String getEstacionI() {
        return EstacionI;
    }

    public void setEstacionI(String EstacionI) {
        this.EstacionI = EstacionI;
    }

    public String getEstacionF() {
        return EstacionF;
    }

    public void setEstacionF(String EstacionF) {
        this.EstacionF = EstacionF;
    }

    public String getRuta() {
        return Ruta;
    }

    public void setRuta(String Ruta) {
        this.Ruta = Ruta;
    }

    public String getBus() {
        return Bus;
    }

    public void setBus(String Bus) {
        this.Bus = Bus;
    }

    public String getConductor() {
        return Conductor;
    }

    public void setConductor(String Conductor) {
        this.Conductor = Conductor;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getHorario() {
        return Horario;
    }

    public void setHorario(String Horario) {
        this.Horario = Horario;
    }

  
    
    
}

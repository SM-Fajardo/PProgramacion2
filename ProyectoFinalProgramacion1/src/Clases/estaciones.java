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
public class estaciones implements Serializable{
    public String EstacionA;
    public String EstacionB;
    public String EstacionC;
  

    public estaciones(String EstacionA, String EstacionB, String EstacionC) {
        this.EstacionA = EstacionA;
        this.EstacionB = EstacionB;
        this.EstacionC = EstacionC;
        
    }
    
    
    
    public String getEstacionA() {
        return EstacionA;
    }

    public void setEstacionA(String EstacionA) {
        this.EstacionA = EstacionA;
    }

    public String getEstacionB() {
        return EstacionB;
    }

    public void setEstacionB(String EstacionB) {
        this.EstacionB = EstacionB;
    }

    public String getEstacionC() {
        return EstacionC;
    }

    public void setEstacionC(String EstacionC) {
        this.EstacionC = EstacionC;
    }

   

    
    
}

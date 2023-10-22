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
public class controlyGestionBus  implements Serializable {
    public String Marca;
    public String Modelo;
    public String Placa;
    public String Motor;
    
    
    public controlyGestionBus(String Marca ,String Modelo , String Placa, String Motor) {
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.Placa = Placa;
        this.Motor= Motor;
        
            
    }
    
    
    

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String Placa) {
        this.Placa = Placa;
    }

    public String getMotor() {
        return Motor;
    }

    public void setMotor(String Motor) {
        this.Motor = Motor;
    }
    
    
    
    
}

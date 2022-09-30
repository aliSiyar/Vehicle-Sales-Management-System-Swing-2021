/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author siyar
 */
public class MotorBike extends Vehicle {
    
    private boolean hasGrenaj;

    public MotorBike(int id,String brand,boolean hasGrenaj, int tireNumber, double engineVolume,int price) {
        super(id,brand,tireNumber, engineVolume,price);
        this.hasGrenaj = hasGrenaj;
    }

    public boolean getHasGrenaj() {
        return hasGrenaj;
    }

    public void setHasGrenaj(boolean hasGrenaj) {
        this.hasGrenaj = hasGrenaj;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author siyar
 */
public class Car extends Vehicle{
    
    private int airbagNum;

    public Car(int id,String brand,int airbagNum, int tireNumber, double engineVolume,int price) {
        super(id,brand,tireNumber, engineVolume,price);
        this.airbagNum = airbagNum;
    }

    public int getAirbagNum() {
        return airbagNum;
    }

    public void setAirbagNum(int airbagNum) {
        this.airbagNum = airbagNum;
    }
    
    
}

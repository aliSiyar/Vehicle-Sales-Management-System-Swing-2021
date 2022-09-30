/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author siyar
 */
public class Vehicle {
    private int id;
    private String brand;
    private int tireNumber;
    private double engineVolume;
    private int price;

    public Vehicle(int id,String brand,int tireNumber, double engineVolume,int price) {
        this.id=id;
        this.brand=brand;
        this.tireNumber = tireNumber;
        this.engineVolume = engineVolume;
        this.price=price;
                
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTireNumber() {
        return tireNumber;
    }

    public void setTireNumber(int tireNumber) {
        this.tireNumber = tireNumber;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }
    
}

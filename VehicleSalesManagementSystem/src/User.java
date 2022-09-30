/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author siyar
 */
public class User extends Person{
    
    private int remainder;

    public User(int id, int remainder, String name, String password) {
        super(id, name, password);
        this.remainder = remainder;
    }
    
    

    

    public int getRemainder() {
        return remainder;
    }

    public void setRemainder(int remainder) {
        this.remainder = remainder;
    }
    
    
    
}

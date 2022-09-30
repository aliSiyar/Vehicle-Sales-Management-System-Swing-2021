/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author siyar
 */
public class Admin extends Person{
    
    private int salary;

    public Admin(int salary, int id, String name, String password) {
        super(id, name, password);
        this.salary = salary;
    }

    

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    
    
    
}

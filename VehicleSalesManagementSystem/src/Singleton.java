/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author siyar
 */
public class Singleton {
    
    private static Singleton instance=null;
    private User user;
    
    private Singleton(){}
    
    public static Singleton getInstance(){
        if(instance==null)
            instance= new Singleton();
        return instance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
            this.user = user;
    }
    
    public void signout(){
        instance=null;
    }
        
    
    
}

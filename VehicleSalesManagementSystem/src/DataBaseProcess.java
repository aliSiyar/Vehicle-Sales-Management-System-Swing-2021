/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author siyar
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DataBaseProcess {
        private  Connection con=null;
    private Statement statement=null;
    private PreparedStatement preparedStatement=null;

    public DataBaseProcess() {
        
        // "jbdc:mysql://localhost:3306/demo" 
        String url="jdbc:mysql://"+Database.host+":"+Database.port+"/"+Database.dbIsmi+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        
            
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//jdbc driverını ekstradan cağırıyoruz com.mysql.jdbc.Driver
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Driver Bulunamadı....");
        }
        
        
        
        
        try {

            
            con = DriverManager.getConnection(url,Database.kullaniciAdi,Database.parola);
            
            System.out.println("baglanti bassarilli");
            
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseProcess.class.getName()).log(Level.SEVERE, null, ex);
            //System.out.println("Bağlantı Başarısız...");
        }
    }
    
    
    public void addUser(String username,String password,String remainder){
        
        
        String query="Insert Into users (username,password,remainder) VALUES(?,?,?)";
            try {
                preparedStatement=con.prepareStatement(query);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2,password);
                preparedStatement.setInt(3,Integer.parseInt(remainder));
                preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(DataBaseProcess.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public boolean login(String username, String password) {
        
        String query="Select * from users";
        
            try {
                preparedStatement=con.prepareStatement(query);

                ResultSet rs=preparedStatement.executeQuery();
                
                while(rs.next()){
                    if (rs.getString("username").equals(username)&&rs.getString("password").equals(password)) {
                        return true;
                    }
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(DataBaseProcess.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        return false;
    }
    
    public ArrayList<Car> getAllCars(){
        String query="Select * from cars";
        ArrayList<Car> output=new ArrayList<>();
        
        try {
            preparedStatement=con.prepareStatement(query);
            ResultSet rs =preparedStatement.executeQuery();
            
            while(rs.next()){
                int id=rs.getInt("id");
                String brand=rs.getString("brand");
                int airbagNum=rs.getInt("airbagNumber");
                int tireNumber=rs.getInt("tireNumber");
                double engineVolume=rs.getDouble("engineVolume");
                int price=rs.getInt("price");
                
                output.add(new Car(id,brand,airbagNum,tireNumber,engineVolume,price));
            }
            
            return output;
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return null;
    }

    public void addCar(String brand, int tireNum, double engineVolume, int airbagNum, int price) {
        
        String query="Insert into cars (brand,airbagNumber,tireNumber,engineVolume,price) VALUES(?,?,?,?,?)";
        
            try {
                preparedStatement=con.prepareStatement(query);
                preparedStatement.setString(1, brand);
                preparedStatement.setInt(2,airbagNum);
                preparedStatement.setInt(3, tireNum);
                preparedStatement.setDouble(4,engineVolume);
                preparedStatement.setInt(5, price);
                
                preparedStatement.executeUpdate();
                
            } catch (SQLException ex) {
                Logger.getLogger(DataBaseProcess.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    void deleteCar(int id) {
        String query="Delete from cars where id = ?";
            try {
                preparedStatement=con.prepareStatement(query);
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(DataBaseProcess.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    
    public ArrayList<MotorBike> getAllMotorBikes(){
        String query="Select * from motorbikes";
        ArrayList<MotorBike> output=new ArrayList<>();
        
        try {
            preparedStatement=con.prepareStatement(query);
            ResultSet rs =preparedStatement.executeQuery();
            
            while(rs.next()){
                int id=rs.getInt("id");
                String brand=rs.getString("brand");
                boolean hasGrenaj=rs.getBoolean("hasGrenaj");
                int tireNumber=rs.getInt("tirenumber");
                double engineVolume=rs.getDouble("engineVolume");
                int price=rs.getInt("price");
                
                output.add(new MotorBike(id, brand, hasGrenaj,  tireNumber,  engineVolume, price));
            }
            
            return output;
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return null;
    }
    
    
    void addMotorbike(String brand,int price,int tireNumber,double engineVolume,boolean hasGrenaj){
        
        String query="INSERT INTO motorbikes (brand,hasGrenaj,engineVolume,price,tirenumber) VALUES (?,?,?,?,?)";
        
        
        try{
            preparedStatement=con.prepareStatement(query);
            preparedStatement.setString(1, brand);
            preparedStatement.setInt(4, price);
            preparedStatement.setInt(5, tireNumber);
            preparedStatement.setDouble(3, engineVolume);
            preparedStatement.setBoolean(2, hasGrenaj);
            preparedStatement.executeUpdate();
            
        }catch (SQLException ex) {
                Logger.getLogger(DataBaseProcess.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
    void deleteMotoBike(int id) {
        String query="Delete from motorbikes where id = ?";
            try {
                preparedStatement=con.prepareStatement(query);
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(DataBaseProcess.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    int getUserColumn(String username,String password,String columnName){
        int column=0;
        String query="SELECT * FROM users where username = ? AND password = ?";
        try {
                preparedStatement=con.prepareStatement(query);
                
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                
                
                ResultSet rs =preparedStatement.executeQuery();
            
                while(rs.next()){
                    column=rs.getInt(columnName);
                    

                }
                
                
            } catch (SQLException ex) {
                Logger.getLogger(DataBaseProcess.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return column;
    }
    
    void updateRemainder(int id,int remainder){
        String query="UPDATE users SET remainder = ? where id = ?";
            try {
                preparedStatement=con.prepareStatement(query);
                preparedStatement.setInt(1, remainder);
                preparedStatement.setInt(2, id);
                preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(DataBaseProcess.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    
    
    
    
    
    
}

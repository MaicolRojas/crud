/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Maicol
 */
public class Conexion {
    Connection con;
    
    public Connection getConnection(){
        String url = "jdbc:mysql://localhost:3306/reto5";
        String user = "root";
        String pass = "";
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con =(Connection) DriverManager.getConnection(url, user, pass);
         
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error Conexion");
        }
       
        return con;
        
    }
    
}
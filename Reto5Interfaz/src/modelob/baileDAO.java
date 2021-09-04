/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelob;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Conexion;

/**
 *
 * @author Maicol
 */
public class baileDAO {
    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    
    public List listar(){
        List <baile> datos = new ArrayList<>();
        String sql = "SELECT * FROM baile ";
        try{
            
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                
               baile b = new baile();
               b.setId(rs.getInt("bai_id"));
               b.setNombre(rs.getString("bai_nombre"));
               b.setAntiguedad(rs.getInt("bai_antiguedad"));
               b.setDuracion(rs.getInt("bai_duracion"));
               
               datos.add(b);
                
            }
            
        }catch(Exception e){
            System.out.println("Something went wrong."+ e);
        }
        
        return datos;
    }
}

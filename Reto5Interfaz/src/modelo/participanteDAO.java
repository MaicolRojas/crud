/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maicol
 */
public class participanteDAO {
    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List listar(){
        List <participante> datos = new ArrayList<>();
        String sql = "SELECT * FROM participantes ";
        try{
            
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                
                participante p = new participante();
                p.setApodo(rs.getString("par_login"));
                p.setNombre(rs.getString("par_nombre"));
                p.setApellido(rs.getString("par_apellido"));
                p.setEmail(rs.getString("par_email"));
                p.setCelular(rs.getString("par_celular"));
                p.setClave(rs.getString("par_clave"));
                p.setFecha(rs.getString("par_fecha_nto"));
                datos.add(p);
                
            }
            
        }catch(Exception e){
            System.out.println("Something went wrong."+ e);
        }
        
        return datos;
    }
    
    public int agregar(participante p){
        int r = 0;
        String sql = "INSERT INTO participantes(par_login, par_nombre, par_apellido, par_email, par_celular, par_clave, par_fecha_nto) VALUES(?,?,?,?,?,?,?)";
        try{
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            
            
            ps.setString(1,p.getApodo());
            ps.setString(2,p.getNombre());
            ps.setString(3,p.getApellido());
            ps.setString(4,p.getEmail());
            ps.setString(5,p.getCelular());
            ps.setString(6,p.getClave() );
            ps.setString(7,p.getFecha());
            r = ps.executeUpdate();
            if(r == 1){
                return 1;
            }else{
                return 0;
            }
        }catch(Exception e){
            System.out.println("ERROR!!!"+ e);
        }
        return r;
    }
    
    public int Actualizar(participante p){
        
        
        String sql = "UPDATE participantes SET par_nombre=?,par_apellido=?,par_email=?,par_celular=?,par_clave=?,par_fecha_nto=? WHERE par_login=?";
        try{
            
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            
            ps.setString(1,p.getNombre());
            ps.setString(2,p.getApellido());
            ps.setString(3,p.getEmail());
            ps.setString(4,p.getCelular());
            ps.setString(5,p.getClave());
            ps.setString(6,p.getFecha());
            ps.setString(7,p.getApodo());

            
            ps.executeUpdate();
            
        }catch(Exception e){
            System.out.println("ERROR!!!"+ e);
        }
        return 1;
    }
    public void delete(String apodo){
        String sql  = "DELETE FROM participantes WHERE par_login='"+apodo+"'";
 
        try{
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println("ccccc"+ e);
        }
        
    }
    
    
}

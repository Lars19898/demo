/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.db;

/**
 *
 * @author larsf
 */
public class JDBCConnection {
    
    
    private static JDBCConnection conn=null;
    
    private  JDBCConnection(){
        
        
    }
    
    public static JDBCConnection getInstance(){
        if(conn==null){
            
            conn=new JDBCConnection();
        }
        
        return conn;
    }
    
    
    
    
    
    
    
}

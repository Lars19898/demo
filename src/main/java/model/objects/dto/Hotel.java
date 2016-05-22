/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.objects.dto;

/**
 *
 * @author larsf
 */
public class Hotel implements java.io.Serializable {
    
    private String name;
    private String ort;
    private Integer id;
    private String description;
    
    
    public Hotel(String name, String ort, int id, String description){
        this.name=name;
        this.ort=ort;
        this.id=id;
        this.description=description;
    }
    
    
    public String getname(){
        return this.name;
    }
    
    public void setname(String name){
        
        this.name=name;
    }
    
    public String getort(){
        return this.ort;
    }
    
    public void setort(String ort){
        this.ort=ort;
    }
    
    
    public void setdescription(String description){
        this.description=description;
    }
    public String getdescription(){
        return this.description;
    }
    
    
    public int getid(){
        return this.id;
    }
    
    public void setid(int id){
        this.id=id;
    }
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package process.control;

import java.util.LinkedList;
import java.util.List;
import model.objects.dto.Hotel;

/**
 *
 * @author larsf
 */
public class HotelSearch {
    
    
    
    Hotel hotel1=new Hotel("Kameha","Bonn", 1, "Hotel am Rhein");
    Hotel hotel2=new Hotel("Maritim","Bonn", 2, "Hotel an der B9");
    Hotel hotel3=new Hotel("Hilton","Köln", 3, "Hotel am Rhein");
    Hotel hotel4=new Hotel("Vier Jahrezeiten","Hamburg", 4, "An der Binnenalster");
    Hotel hotel5=new Hotel("Bayerischer Hof","München", 5, "Exklusives Hotel in München");
    
    
    
    private HotelSearch(){
        
    }
    
    public static HotelSearch search=null;
    
    public static HotelSearch getinstance(){
        if(search==null){
            search=new HotelSearch();
           
        }
        return search;
    } 
    
    public List<Hotel> getHotelsbyort(String ort){
        LinkedList<Hotel> hotels=new LinkedList<Hotel>();
        
        
        if(ort.equals("Bonn")){
            hotels.add(hotel1);
            hotels.add(hotel2);
            
        }
        
        if(ort.equals("Köln")){
            hotels.add(hotel3);
            
            
        }
        
        if(ort.equals("München")){
            hotels.add(hotel5);
            
            
        }
        if(ort.equals("Hamburg")){
            hotels.add(hotel4);
            
            
        }
        
        return hotels;
        
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author larsf
 */
public class nosuchuserLogin extends Exception {
    
    
    public nosuchuserLogin(){
        super("Nutzer nicht vorhanden oder Passwort/Nutzername nicht korrekt");
    }
    
    
    
    
}

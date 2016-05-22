/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import process.control.LoginControl;


/**
 *
 * @author larsf
 */
public class LoginView extends VerticalLayout implements View {

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        this.setUp();
    }
    
    public void setUp(){
        
        // Ein Neuer Kommentar für Git.
        this.setSizeFull();
        final TextField userlogin=new TextField();
        userlogin.setCaption("Username");
        
        final PasswordField password=new PasswordField();
        password.setCaption("Passwort");
        
        VerticalLayout layout=new VerticalLayout();
        layout.addComponent(userlogin);
        layout.addComponent(password);
        
        Panel panel=new Panel("BitteLogin-Daten eingeben");
        
        
        this.addComponent(panel);
                           
        this.setComponentAlignment(panel, Alignment.MIDDLE_CENTER);
        
        panel.setContent(layout);
        
        
        Button buttonLogin=new Button("Login",FontAwesome.SEARCH);
        layout.addComponent(buttonLogin);
        layout.setComponentAlignment(buttonLogin,Alignment.MIDDLE_CENTER);
        
        panel.setSizeUndefined();
        
        
        
    
        buttonLogin.addClickListener(new ClickListener(){
            @Override
            public void buttonClick(Button.ClickEvent event) {
                String user=userlogin.getValue();
                String pw=password.getValue();
                
                LoginControl.controllogin(user, pw);
                
            }
            
        });
        
        
        
        
        
    }
    
}

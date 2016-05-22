/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package process.control;

import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import gui.views.MainView;
import model.objects.dto.User;
import model.services.util.Roles;

/**
 *
 * @author larsf
 */
public class LoginControl {
    
    
    public static void controllogin(String userlogin, String password) {
        User user=null;
        if(userlogin.equals("lars")&password.equals("lars")){
         
            user = new User();
            user.setname(userlogin);
           
        VaadinSession session=UI.getCurrent().getSession();
        session.setAttribute("Lars", user);
        
        UI.getCurrent().getNavigator().navigateTo("MainView"); 
        
        }
        
        else{
            Notification.show("Nutzer nicht gefunden oder Eingaben falsch!", Notification.Type.ERROR_MESSAGE);
        }
        
        
        
        
        
    }

    public static void logoutuser() {
        UI.getCurrent().getPage().setLocation("/SE2Projekt");
        VaadinSession.getCurrent().close();
        
    }
    
}

package com.mycompany.se2projekt;
import javax.servlet.annotation.WebServlet;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.data.util.BeanItem;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.AbstractErrorMessage;
import com.vaadin.server.AbstractErrorMessage.ContentMode;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import gui.views.LoginView;
import gui.views.MainView;
import java.util.List;
import model.objects.dto.Hotel;
import process.control.HotelSearch;

/**
 *
 */
@Theme("mytheme")
@Widgetset("com.mycompany.se2projekt.MyAppWidgetset")
public class MyUI extends UI {
    
     
     
    
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        
        System.out.println("LOG "+UI.getCurrent().getSession().toString());
      
        Navigator navi=new Navigator(this,this);
        navi.addView("LoginView",  LoginView.class);
        navi.addView("MainView", MainView.class);
        UI.getCurrent().getNavigator().navigateTo("LoginView");
        
       
        
        
        

    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}

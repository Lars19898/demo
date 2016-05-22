/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.views;

import com.mycompany.se2projekt.MyUI;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.data.util.BeanItem;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import java.util.List;
import model.objects.dto.Hotel;
import model.objects.dto.User;
import model.services.util.Roles;
import process.control.HotelSearch;
import process.control.LoginControl;

/**
 *
 * @author larsf
 */
public class MainView extends VerticalLayout implements View {

    private int anzahlsuche = 0;
    private Hotel hotelselektiert;

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        this.setup();
    }

    public void setup( ) {
        
        final HorizontalLayout hlayout = new HorizontalLayout();
       
       
        Button button = new Button("Suche");
        Button bookingbutton = new Button("Buchen");
        final TextField textfield = new TextField();   
        User user=(User)UI.getCurrent().getSession().getAttribute("Lars");
        Button logout =new Button("Logout: "+ user.getname());
                              
        
        Label label = new Label(user.getname()+"Bitte Ort eingeben");
        hlayout.addComponent(label);
        hlayout.addComponent(textfield);
        hlayout.addComponent(button);
        hlayout.addComponent(bookingbutton);
        hlayout.addComponent(logout);
        this.addComponent(hlayout);
        this.setComponentAlignment(hlayout, Alignment.MIDDLE_CENTER);
        final BeanContainer<Integer, Hotel> data = new BeanContainer<Integer, Hotel>(Hotel.class);
        data.setBeanIdProperty("id");
        final Table table = new Table("Treffer", data);
        table.setSizeFull();
        table.setSelectable(true);
        bookingbutton.addClickListener(new ClickListener() { // Interface wird instanziiert durch AnonymeKlasse
            @Override
            public void buttonClick(ClickEvent event) {
                if (hotelselektiert == null) {
                    Notification.show("Kein Hotel ausgew\u00e4hlt ", Notification.Type.WARNING_MESSAGE);
                } else {
                    Notification.show("Hotel " + hotelselektiert.getname() + " wurde zur Buchung ausgew\u00e4hlt");
                }
            }
        });
        table.addItemClickListener(new ItemClickListener() {
            @Override
            public void itemClick(ItemClickEvent event) {
                BeanItem<Hotel> result = data.getItem(event.getItemId());
                hotelselektiert = result.getBean();
            }
        });
        button.addClickListener(new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                String ort = textfield.getValue();
                table.removeAllItems();
                anzahlsuche++;
                table.setCaption("Treffer f\u00fcr " + ort + " (Anzahl der Suche " + anzahlsuche + ")");
                if (ort.equals("")) {
                    Notification.show("Sie haben keinen Ort angegeben", Notification.Type.WARNING_MESSAGE);
                } else {
                    addComponent(table);
                    List<Hotel> liste = HotelSearch.getinstance().getHotelsbyort(ort);
                    data.addAll(liste);
                }
            }
        });
        
        
        logout.addClickListener(new ClickListener(){
            @Override
            public void buttonClick(ClickEvent event) {
                LoginControl.logoutuser();
            }
            
        });
                
    }
    
}

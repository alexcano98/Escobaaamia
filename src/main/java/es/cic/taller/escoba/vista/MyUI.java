package es.cic.taller.escoba.vista;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {
	private PantallaLayout pantalla = new PantallaLayout(this);
    @Override
    protected void init(VaadinRequest vaadinRequest) {
       
    	TabSheet pestaña = new TabSheet();
    	 pestaña.setHeight(100.0f, Unit.PERCENTAGE);
         pestaña.addStyleName(ValoTheme.TABSHEET_FRAMED);
         pestaña.addStyleName(ValoTheme.TABSHEET_PADDED_TABBAR);
         
         pestaña.addTab(pantalla);
         setContent(pestaña);
         
        
    	
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}

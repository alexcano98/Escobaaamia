package es.cic.taller.escoba.vista;

import java.io.File;

import com.vaadin.server.FileResource;
import com.vaadin.server.Resource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.VerticalLayout;

public class EscobasForm extends GridLayout {
	
	
	
	
	public EscobasForm() {
		setRows(4);
		setColumns(4);
		
		
	}
	
	public void añadeEscoba() {
		Image imagen = new Image();
		imagen.setSource(getImageResource("circle.png"));
		imagen.setWidth("50px");
		imagen.setHeight("50px");
		imagen.setVisible(true);
		
		this.addComponent(imagen);
	}
	
	private Resource getImageResource(String recurso) {
		String basepath = VaadinService.getCurrent()
                .getBaseDirectory().getAbsolutePath();
		FileResource resource = new FileResource(new File(basepath +
                "/images/" + recurso));
        return resource;
}
	
}

package es.cic.tallet.escoba.juego;

import java.io.File;

import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Image;

public class Carta {
	private String palo;
	private int numero;
	Image imagen= new Image();

	public Carta(int numero,String palo) {
		this.numero= numero;
		this.palo= palo;
		setImagen();

	}

	public int getNumero() {
		return numero;
	}

	public String getPalo() {
		return palo;
	}
	private void setImagen() {
		String nomImagen= numero+palo;
		String basepath = VaadinService.getCurrent()
				.getBaseDirectory().getAbsolutePath();

		FileResource resource = new FileResource(new File(basepath +
				"/images/"+nomImagen));

		imagen.setSource(resource);
		imagen.setWidth("100px");
		imagen.setHeight("200px");
	}
	
	public Image getImagen() {
		return imagen;
	}


}


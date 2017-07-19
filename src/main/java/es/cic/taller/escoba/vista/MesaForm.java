package es.cic.taller.escoba.vista;

import java.io.File;

import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.event.MouseEvents.ClickListener;
import com.vaadin.server.FileResource;
import com.vaadin.server.Resource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;

import es.cic.tallet.escoba.juego.Carta;

public class MesaForm extends FormLayout {

	
	private Image imagen1;
	private Image imagen2;
	private Image imagen3;
	private Image imagen4;
	
	private Mesa mesa;
	
	private HorizontalLayout cartas = new HorizontalLayout();
	
	public MesaForm() {
		
		cartas.addComponents(imagen1,imagen2,imagen3,imagen4);
		imagen1.addClickListener(new Seleccion());
		imagen2.addClickListener(new Seleccion());
		imagen3.addClickListener(new Seleccion());
		imagen4.addClickListener(new Seleccion());
		
		addComponents(cartas);
		this.setSizeFull();
	}
	private Resource getImageResource(String recurso) {
		String basepath = VaadinService.getCurrent()
                .getBaseDirectory().getAbsolutePath();
		FileResource resource = new FileResource(new File(basepath +
                "/images/" + recurso));
        return resource;
	}	
	private void cargaCarta(Carta carta, Image imagen) {
		imagen.setSource(getImageResource(carta.getNombreFichero()));
		imagen.setWidth("100px");
		imagen.setHeight("200px");
	}
	
	private Carta getCartaImagen(Component componente) {
		Carta carta = null;
		
		if (componente.equals(imagen1)) {
			carta = mesa.getCarta1();
		} else if (componente.equals(imagen2)) {
			carta = mesa.getCarta2();
		} else if (componente.equals(imagen3)) {
			carta = mesa.getCarta3();
		} else if (componente.equals(imagen4)) {
			carta = mesa.getCarta4();
		}
		return carta;
	}
	
	
	private void estableceSeleccionado(Component componente, boolean seleccionado) {
		if (!seleccionado) {
			componente.setWidth("100px");
			componente.setHeight("200px");
		} else {
			componente.setWidth("200px");
			componente.setHeight("400px");
		}
	}
	
	class Seleccion implements ClickListener {

		private static final long serialVersionUID = 1097359184957535482L;

		@Override
		public void click(ClickEvent event) {
			
		}

		
	}
	
	
	
	
	
}



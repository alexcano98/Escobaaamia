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

public class ManoForm extends FormLayout {
	private HorizontalLayout cartas = new HorizontalLayout();
	
	private Image imagen1 = new Image();
	private Image imagen2 = new Image();
	private Image imagen3 = new Image();
	
	private Mano mano;
	
	public ManoForm() {
		
			cartas.addComponents(imagen1,imagen2,imagen3);
			imagen1.addClickListener(new Seleccion());
			imagen2.addClickListener(new Seleccion());
			imagen3.addClickListener(new Seleccion());
			
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
			carta = mano.getCarta1();
		} else if (componente.equals(imagen2)) {
			carta = mano.getCarta2();
		} else if (componente.equals(imagen3)) {
			carta = mano.getCarta3();
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

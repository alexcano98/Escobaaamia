package es.cic.taller.escoba.vista;

import java.io.File;
import java.util.List;

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
import es.cic.tallet.escoba.juego.Mesa;

public class MesaForm extends FormLayout {

	
	private List<Image> imagenes;	
	private Mesa mesa;
	
	private HorizontalLayout cartas = new HorizontalLayout();
	
	public MesaForm() {
		
		for( Image imagen: imagenes) {
			imagen.addClickListener(new Seleccion());
			cartas.addComponent(imagen);
		}
		addComponents(cartas);
		this.setSizeFull();
	
	}	
	private void añadeImagen() {
		
	}
	
	private void eliminaImagen() {
		
	}
	
	public void setMano(List<Carta> cartas) {
		for( Carta carta : cartas) {
			Image imagen = carta.getImagen();
			imagen.setWidth("100px");
			imagen.setHeight("200px");
			imagenes.add(imagen);
		}
	}
	
	private Carta getCartaImagen(Component componente) {
		Carta carta = null;
		for( Image imagen: imagenes) {
			if(componente == imagen) {
				// aqui se debe llamar a la clase Mesa que va a retornar con un metodo el objeto carta que coincida en 
				// el array de cartas de la clase Mesa con el indice de la imagen
			}
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
	
	private void estableceDescartadaImagen(Component componente) {
		Carta carta = getCartaImagen(componente);
		
		boolean descartada = isCartaDescartada(carta);
		
		estableceSeleccionado(componente, descartada);
	}

	private boolean isCartaDescartada(Carta carta) {
		//return mano.getListaDescartadas().contains(carta);
		return false;
}
	
	
	
}



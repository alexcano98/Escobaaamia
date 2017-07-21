package es.cic.taller.escoba.vista;


import java.util.ArrayList;
import java.util.List;

import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.event.MouseEvents.ClickListener;

import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;

import es.cic.tallet.escoba.juego.Carta;

import es.cic.tallet.escoba.juego.Ronda;

public class MesaForm extends FormLayout {

	
	private List<Image> imagenes;
	
	private HorizontalLayout cartas = new HorizontalLayout();
	private Ronda ronda;
	
	
	public MesaForm(Ronda ronda) {
		this.ronda = ronda;
		imagenes = new ArrayList<Image>();
		List<Carta> cartas = ronda.getCartasMedio();
		for( Carta carta : cartas) {
			Image imagen = carta.getImagen();
			imagenes.add(imagen);
		}
		
		for( Image imagen: imagenes) {
			imagen.addClickListener(new Seleccion());
			this.cartas.addComponent(imagen);
		}
		addComponents(this.cartas);
		this.setSizeFull();
	
	}	
	public void añadeImagen(Carta carta) {
		imagenes.add(carta.getImagen());
		imagenes.get(imagenes.size()-1).addClickListener(new Seleccion());
		this.cartas.addComponent(carta.getImagen());
	}
	
	private void eliminaImagen() {
		
	}
	
	
	
	private Carta getCartaImagen(Component componente) {
		Carta carta = null;
		for( Image imagen: imagenes) {
			if(componente == imagen) {
				// Aqui se debe conseguir el objeto carta que corresponde con el componente
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
			
			Component componente = event.getComponent();
			Carta carta = getCartaImagen(componente);
			
			boolean seleccionada = isCartaSeleccionada(carta);
			boolean seleccionar = !seleccionada;
			
			if (seleccionar) {
				ronda.getListaSeleccionadas().add(carta);
			} else {
				ronda.getListaSeleccionadas().remove(carta);
			}
			
			estableceSeleccionado(componente, seleccionar);
		}
		}


	private boolean isCartaSeleccionada(Carta carta) {

		return ronda.getListaSeleccionadas().contains(carta);
	}
	
	
	
}



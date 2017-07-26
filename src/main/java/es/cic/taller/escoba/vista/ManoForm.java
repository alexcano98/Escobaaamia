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
import es.cic.tallet.escoba.juego.Mano;

public class ManoForm extends FormLayout {
	private HorizontalLayout cartas = new HorizontalLayout();
	
	private Image imagen1; 
	private Image imagen2;
	private Image imagen3; 
	
	private Mano mano;
	
	public ManoForm(Mano mano) {
			
			this.mano = mano;
	
			setMano();
			addComponents(cartas);
			this.setSizeFull();
		
	}

	private void generaImagenes() {
		imagen1 = new Image();
		imagen2 = new Image();
		imagen3 = new Image();
		imagen1.addClickListener(new Seleccion());
		imagen2.addClickListener(new Seleccion());
		imagen3.addClickListener(new Seleccion());
		cartas.addComponents(imagen1,imagen2,imagen3);
	}
	
	public void eliminaCarta(Carta carta) {
		estableceDeseleccionado(carta);
		this.cartas.getComponent(getIndexImagen(carta)).setVisible(false);
		this.cartas.removeComponent(carta.getImagen());
		PantallaLayout.getSoltar().setEnabled(false);
		mano.eliminar(carta);
	    
	}
	private int getIndexImagen(Carta carta) {
		int index=-1;
		
		if (carta == mano.getCarta1()) {	
			index = 0;
		} else if (carta == mano.getCarta2()) {
			index = 1;
		} else if (carta == mano.getCarta3()) {
			index = 2;
		}
		return index;
	}
	
	public void setMano() {
		generaImagenes();
		cartas.addComponents(imagen1,imagen2,imagen3);
		cargaCarta(mano.getCarta1(), imagen1);
		cargaCarta(mano.getCarta2(), imagen2);
		cargaCarta(mano.getCarta3(), imagen3);
		
	}	
	private void cargaCarta(Carta carta, Image imagen) {
		imagen.setSource(carta.getImagen().getSource());
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
	
	public void resetea() {
		cartas.removeAllComponents();
		setMano();
		cartas.addComponents(imagen1,imagen2,imagen3);
	}
	
	
	
	class Seleccion implements ClickListener {

		private static final long serialVersionUID = 1097359184957535482L;

		@Override
		public void click(ClickEvent event) {
			Component componente = event.getComponent();
			estableceCartaSeleccionada(componente);
			
		}
	}
		
		
		private void estableceCartaSeleccionada(Component componente) {
			Carta carta = getCartaImagen(componente);
			
			boolean seleccionada = isCartaSeleccionada(carta);
			boolean seleccionar = !seleccionada;
			if (seleccionar && mano.sePuedeSeleccionarCarta()) {
								carta.setSeleccionada(seleccionar);
								PantallaLayout.getSoltar().setEnabled(true);
								
							} else {
								carta.setSeleccionada(false);
								PantallaLayout.getSoltar().setEnabled(false);
							}
							
							estableceSeleccionado(componente, carta.isSeleccionada());
				}
		

		private boolean isCartaSeleccionada(Carta carta) {
			return   carta == mano.getSeleccionada();
			
	}
		public Mano getMano() {
			return mano;
		}
		
		private void estableceDeseleccionado(Carta carta) {
			carta.getImagen().setWidth("100px");
			carta.getImagen().setHeight("200px");
			mano.getSeleccionada().setSeleccionada(false);
			
		}
		

}


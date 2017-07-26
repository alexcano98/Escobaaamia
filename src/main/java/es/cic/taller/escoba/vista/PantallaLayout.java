package es.cic.taller.escoba.vista;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.VerticalLayout;

import es.cic.tallet.escoba.juego.Carta;
import es.cic.tallet.escoba.juego.Mano;
import es.cic.tallet.escoba.juego.Ronda;

public class PantallaLayout extends GridLayout {
	
	

	private ManoForm manoFormJ1;
	private ManoForm manoFormJ2;
	private EscobasForm escobasFormJugador1;
	private EscobasForm escobasFormJugador2;
	private Ronda ronda = new Ronda();
	private Mano mano1 = ronda.getMano1();
	private Mano mano2 = ronda.getMano2();
	
	private MyUI myUI;
	
	private MesaForm mesa;
	private static Button recoger = new Button("Recoger");
	private static Button soltar = new Button("Soltar");
	
	public PantallaLayout(MyUI myUI) {
		this.myUI = myUI;
	
		
		
		manoFormJ1 = new ManoForm(mano1);
		manoFormJ2 = new ManoForm(mano2);
		
		mesa = new MesaForm(ronda);
		
		setRows(3);
		setColumns(2);
		
		addComponent(manoFormJ1,0,0);
		addComponent(manoFormJ2,0,2);
		/*addComponent(escobasFormJugador1,1,0);  // Error: establece valores nulos que no se pueden colocar (Solucionar)
		addComponent(escobasFormJugador2,1,2);*/
		addComponent(mesa,0,1);
		VerticalLayout acciones = new VerticalLayout();
		acciones.addComponents(recoger,soltar);
		addComponent(acciones,1,1);
		this.setComponentAlignment(acciones, Alignment.MIDDLE_RIGHT);
		this.setSizeFull();
		
		ronda.getJugador1().setManoActual(manoFormJ1);
		ronda.getJugador2().setManoActual(manoFormJ2);
		recoger.setEnabled(false);
		soltar.setEnabled(false);
		
		soltar.addClickListener(e ->{
				Carta carta = ronda.getJugadorActual().getMano().getMano().getSeleccionada();
				ronda.getJugadorActual().getMano().eliminaCarta(carta);
				mesa.añadeImagen(carta);
				
				if(manoFormJ1.getMano().isVacia() && manoFormJ2.getMano().isVacia()) {
					
					if(!ronda.getBaraja().quedanCartas()) {
						
						ronda.getBaraja().generaBaraja();
					 }
					
					ronda.reparteMano();
					
					ronda.getJugador1().setManoActual(manoFormJ1);
					ronda.getJugador2().setManoActual(manoFormJ2);
					
					manoFormJ1.resetea();
					manoFormJ2.resetea();
					
					
				}
					
				ronda.cambiaTurno();

		});
		
		recoger.addClickListener(e->{
				Carta carta = ronda.getJugadorActual().getMano().getMano().getSeleccionada();
				ronda.getJugadorActual().getMano().eliminaCarta(carta);
				mesa.eliminaImagen(ronda.getListaSeleccionadas());
				ronda.getListaSeleccionadas().clear();
				
				if(manoFormJ1.getMano().isVacia() && manoFormJ2.getMano().isVacia()) {
					if(!ronda.getBaraja().quedanCartas()) {
						ronda.getBaraja().generaBaraja();
					}
					ronda.reparteMano();

		
					ronda.getJugador1().setManoActual(manoFormJ1);
					ronda.getJugador2().setManoActual(manoFormJ2);
					
					manoFormJ1.resetea();
					manoFormJ2.resetea();
					
					
				}
				
				ronda.cambiaTurno();
			
		});
		
		
		
	}
	
	
	public ManoForm getManoFormJ1() {
		return manoFormJ1;
	}

	public void setManoFormJ1(ManoForm manoFormJ1) {
		this.manoFormJ1 = manoFormJ1;
	}

	public ManoForm getManoFormJ2() {
		return manoFormJ2;
	}

	public void setManoFormJ2(ManoForm manoFormJ2) {
		this.manoFormJ2 = manoFormJ2;
	}

	public MesaForm getMesa() {
		return mesa;
	}

	public void setMesa(MesaForm mesa) {
		this.mesa = mesa;
	}
	public static Button getSoltar() {
		return soltar;
	}
	public static Button getRecojer() {
		return recoger;
	}
}
	
	


package es.cic.taller.escoba.vista;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import es.cic.tallet.escoba.juego.Carta;
import es.cic.tallet.escoba.juego.Juego;
import es.cic.tallet.escoba.juego.Jugador;
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
	private Juego juego=new Juego();
	private MyUI myUI;
	private Label etiqueta =new Label();
	private Jugador ultimoJugador;
	private MesaForm mesa;
	private static Button recoger = new Button("Recoger");
	private static Button soltar = new Button("Soltar");
	private static Button nuevaRonda = new Button("NuevaRonda");
	private Label jugador = new Label();
	
	public PantallaLayout(MyUI myUI) {
		this.myUI = myUI;
		
		jugador.setCaption(ronda.getJugadorActual().getNombre());

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
		acciones.addComponents(jugador,recoger,soltar,etiqueta, nuevaRonda);
		nuevaRonda.setVisible(false);
		addComponent(acciones,1,1);
		this.setComponentAlignment(acciones, Alignment.MIDDLE_RIGHT);
		this.setSizeFull();

		ronda.getJugador1().setManoActual(manoFormJ1);
		ronda.getJugador2().setManoActual(manoFormJ2);
		recoger.setEnabled(false);
		soltar.setEnabled(false);
		nuevaRonda.setCaption("nueva ronda");
		soltar.addClickListener(e ->{
			
			Carta carta = ronda.getJugadorActual().getMano().getMano().getSeleccionada();
			ronda.getJugadorActual().getMano().eliminaCarta(carta);
			mesa.añadeImagen(carta);
			

			if(manoFormJ1.getMano().isVacia() && manoFormJ2.getMano().isVacia()) {

				if(isRondaAcabada()) {
					rondaAcabada();
				}else {

				ronda.reparteMano();

				manoFormJ1.resetea();
				manoFormJ2.resetea();
				
			}
		}

			ronda.cambiaTurno();
			jugador.setCaption(ronda.getJugadorActual().getNombre());

		});

		recoger.addClickListener(e->{
			
			ultimoJugador=ronda.getJugadorActual();
			ronda.anhadeCArtasJugador(ultimoJugador);
			Carta carta = ultimoJugador.getMano().getMano().getSeleccionada();
			ultimoJugador.getMano().eliminaCarta(carta);
			mesa.eliminaImagen(ronda.getListaSeleccionadas());
			ronda.getListaSeleccionadas().clear();
			
			
			if(mesa.hayEscoba()) {
				
				ultimoJugador.sumaPuntos(1);
			}
			if(manoFormJ1.getMano().isVacia() && manoFormJ2.getMano().isVacia()) {
				if(isRondaAcabada()) {
					rondaAcabada();
				}else {
				ronda.reparteMano();
	
				manoFormJ1.resetea();
				manoFormJ2.resetea();


				}
			}

			ronda.cambiaTurno();
			jugador.setCaption(ronda.getJugadorActual().getNombre());

		});

		nuevaRonda.addClickListener(e->{
				ronda.reiniciaRonda(); 
				ronda.daCartasAlMedio();
				mesa.resetea();
				ronda.reparteMano();

				manoFormJ1.resetea();
				manoFormJ2.resetea();
				nuevaRonda.setVisible(false);
				  
				ronda.cambiaTurno();
				jugador.setCaption(ronda.getJugadorActual().getNombre());
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
	public boolean isRondaAcabada() {
		return !ronda.getBaraja().quedanCartas();
	}
	private void rondaAcabada() {
		ultimoJugador.anhadeCartas(ronda.getCartasMedio());
		
		ronda.sumaPuntos();
		mesa.borrarCartasMedio(ronda.getCartasMedio());
		ronda.getCartasMedio().clear();
		
		
		juego.setPuntuacionJugador1(ronda.getJugador1().getPuntos());
		juego.setPuntuacionJugador2(ronda.getJugador2().getPuntos());
		
		
		etiqueta.setCaption("Jugador 1:" + ronda.getJugador1().getPuntos()
					+" Jugador 2:" + ronda.getJugador2().getPuntos());
		
		if(juego.isTerminado()) {
			nuevaRonda.setCaption("Nuevo Juego");
			juego.nuevoJuego();
			ronda.getJugador1().finJuego();
			ronda.getJugador2().finJuego();
		}
		nuevaRonda.setVisible(true);
		
	
	}
}




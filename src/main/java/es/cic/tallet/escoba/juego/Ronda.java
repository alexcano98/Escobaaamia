package es.cic.tallet.escoba.juego;

import java.util.ArrayList;
import java.util.List;

public class Ronda {
	private Mano mano1;
	private Mano mano2;
	
	
	private ArrayList<Carta> medio = new ArrayList<Carta>();
	
	private ArrayList<Carta> jug1= new ArrayList<Carta>();
	private ArrayList<Carta> jug2= new ArrayList<Carta>();
	
	private Baraja baraja= new Baraja();
	
	public Ronda() {
		
		reparteMano();	
		daCartasAlMedio();
	}

	private void daCartasAlMedio() {
		medio.add(baraja.getCarta());
		medio.add(baraja.getCarta());
		medio.add(baraja.getCarta());
		medio.add(baraja.getCarta());
	}

	public void reparteMano() {
		mano1= baraja.getMano();
		mano2= baraja.getMano();
	}
	
	
	
	public boolean anhadeCartajug1(ArrayList<Carta> seleccionadas) {
		
		if(Mano.puedeSumarCarta(seleccionadas)){
			mano1.eliminar(mano1.estaEnLaMano(seleccionadas));
			medio.removeAll(seleccionadas);
			return jug1.addAll(seleccionadas);
		}
		return false;
		
	}
	
	public boolean anhadeCartajug2(ArrayList<Carta> seleccionadas) {
		if(Mano.puedeSumarCarta(seleccionadas)) {
			mano2.eliminar(mano2.estaEnLaMano(seleccionadas));
			medio.removeAll(seleccionadas);
			return jug2.addAll(seleccionadas);
		}
		return false;
		
	}
	
	public void tiraCarta(Carta carta) {
		medio.add(carta);
		mano1.eliminar(carta);
		mano2.eliminar(carta);
	}
	
	public List<Carta> getCartasMedio() {
		return medio;
	}
	
}

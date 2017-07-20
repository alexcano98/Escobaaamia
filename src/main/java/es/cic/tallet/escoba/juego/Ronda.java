package es.cic.tallet.escoba.juego;

import java.util.ArrayList;

public class Ronda {
	Mano mano1;
	Mano mano2;
	

	
	ArrayList<Carta> medio = new ArrayList<Carta>();
	
	ArrayList<Carta> jug1= new ArrayList<Carta>();
	ArrayList<Carta> jug2= new ArrayList<Carta>();
	
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
		if(Mano.puedeSumarCarta(seleccionadas)) {
			
			
			medio.removeAll(seleccionadas);
			
			return jug1.addAll(seleccionadas);
		}
		return false;
		
	}
	
	public boolean anhadeCartajug2(ArrayList<Carta> seleccionadas) {
		if(Mano.puedeSumarCarta(seleccionadas)) {
			return jug2.addAll(seleccionadas);
		}
		return false;
		
	}
	
}

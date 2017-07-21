
package es.cic.tallet.escoba.juego;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baraja {
	
	private List<Carta> listaCartas = new ArrayList<>();
	
	public Baraja() {
		generaBaraja();
		
	}
	
	public void generaBaraja() {
		for(int i=1; i<=10;i++) {
			listaCartas.add(new Carta(i,"ORO.png"));
			listaCartas.add(new Carta(i,"COPA.png"));
			listaCartas.add(new Carta(i,"ESPADAS.png"));
			listaCartas.add(new Carta(i,"BASTOS.png"));
		}
	
		Collections.shuffle(listaCartas);
	}
	
	public void resetear() {
		listaCartas.clear();
		
		generaBaraja();
	}
	
	public Mano getMano() {
		Mano mano = new Mano();
		mano.setCarta1(getCarta());
		mano.setCarta2(getCarta());
		mano.setCarta3(getCarta());
		return mano;
	}
	
	public Carta getCarta() {
		Carta carta = listaCartas.remove(0);
		return carta;		
	}
	
	
}

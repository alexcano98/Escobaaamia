
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
			listaCartas.add(new Carta(i,"ORO"));
			listaCartas.add(new Carta(i,"COPA"));
			listaCartas.add(new Carta(i,"ESPADAS"));
			listaCartas.add(new Carta(i,"BASTOS"));
		}
	
		Collections.shuffle(listaCartas);
	}
	
	public void resetear() {
		listaCartas.clear();
		generaBaraja();
	}
	
	public void reparteMano(Mano mano) {
		
		mano.setCarta1(getCarta());
		mano.setCarta2(getCarta());
		mano.setCarta3(getCarta());
	}
	
	public Carta getCarta() {
		Carta carta = listaCartas.get(0);
		listaCartas.remove(0);
		return carta;		
	}
	
	public boolean quedanCartas() {
		return listaCartas.size()>0;
	}
	
	
}

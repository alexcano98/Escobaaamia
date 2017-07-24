package es.cic.tallet.escoba.juego;

import java.util.ArrayList;
import java.util.List;

public class Ronda {
	private Mano mano1;
	private Mano mano2;

	private ArrayList<Carta> seleccionadas = new ArrayList<Carta>();
	private ArrayList<Carta> medio = new ArrayList<Carta>();

	private ArrayList<Carta> jug1= new ArrayList<Carta>();
	private ArrayList<Carta> jug2= new ArrayList<Carta>();

	private Baraja baraja= new Baraja();
	private Juego juego=new Juego();
	
	
	private Jugador jugador1 = new Jugador("Jugador1");
	private Jugador jugador2 = new Jugador("Jugador2");
	
	public Ronda() {

		reparteMano();	
		daCartasAlMedio();
		jugador1.setTurno(true);
		jugador1.setManoActual(mano1);
		jugador2.setManoActual(mano2);
	}
	public void cambiaTurno() {
		boolean turno=jugador1.getTurno();
		jugador1.setTurno(!turno);
		jugador2.setTurno(turno);
	}
	public Jugador getJugadorActual() {
		boolean turno=jugador1.getTurno();
		if(turno) {
			return jugador1;
		}
		return jugador2;
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

	public List<Carta> getCartasMedio() {
		return medio;
	}
	public List<Carta> getListaSeleccionadas(){
		return seleccionadas;
	}

	public Mano getMano1() {
		return mano1;
	}
	public Mano getMano2() {
		return mano2;

	}
	public boolean puedeSumarCarta(Mano mano) {
		int num = mano.getSeleccionada().getNumero();
		for(Carta c: seleccionadas) {
			num=num+c.getNumero();
		}
		return num==15;

	}
	private int orosJ1() {
		int oros=0;
		for(int i=0; i<jug1.size();i++) {
			if(jug1.get(i).getPalo().equals("ORO")) {
				oros++;
			}
		}
		return oros;
	}
	private int orosJ2() {
		int oros=0;
		for(int i=0; i<jug2.size();i++) {
			if(jug2.get(i).getPalo().equals("ORO")) {
				oros++;
			}
		}
		return oros;
	}
	
	private int sietesJ1() {
		int sietes=0;
		for(int i=0; i<jug1.size();i++) {
			if(jug1.get(i).getNumero()==7) {
				sietes++;
			}
		}
		return sietes;
	}
	private int sietesJ2() {
		int sietes=0;
		for(int i=0; i<jug2.size();i++) {
			if(jug2.get(i).getNumero()==7) {
				sietes++;
			}
		}
		return sietes;
	}
	private boolean sieteOroJ1() {
		for(int i=0; i<jug1.size();i++) {
			if(jug1.get(i).getNumero()==7&&jug1.get(i).getPalo().equals("ORO")) {
				return true;
			}
		}
		return false;
	}
	
	public void sumaPuntos() {
		int puntJ1=0;
		int puntJ2=0;
		if(jug1.size()>jug2.size()) {
			puntJ1++;
		}else {
			if(jug1.size()<jug2.size()) {
				puntJ2++;
			}
		}
		if(orosJ1()>orosJ2()) {
			puntJ1++;
		}else {
			if(orosJ1()<orosJ2()) {
				puntJ2++;
			}
		}
		if(sietesJ1()>sietesJ2()) {
			puntJ1++;
		}else {
			if(sietesJ1()<sietesJ2()) {
				puntJ2++;
			}
		}
		if(sieteOroJ1()) {
			puntJ1++;
		}else {
			puntJ2++;
		}
		juego.sumaPuntuacionJugador1(puntJ1);
		juego.sumaPuntuacionJugador2(puntJ2);
		
	}
}

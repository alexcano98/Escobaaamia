package es.cic.tallet.escoba.juego;

import java.util.ArrayList;

public class Mano {

	private Carta carta1;
	private Carta carta2;
	private Carta carta3;
	Jugador jugador;

	public Carta getCarta1() {
		return carta1;
	}
	public void setCarta1(Carta carta1) {
		this.carta1 = carta1;
	}

	public Carta getCarta2() {
		return carta2;
	}
	public void setCarta2(Carta carta2) {
		this.carta2 = carta2;
	}

	public Carta getCarta3() {
		return carta3;
	}
	public void setCarta3(Carta carta3) {
		this.carta3 = carta3;
	}
	public Jugador getJugador() {
		return jugador;
	}
	
	public void setJugador(Jugador jugador) {
		this.jugador=jugador;
	}


	public static boolean sumaCarta(ArrayList <Carta> seleccionadas) {
		int num = 0;
		for(Carta c: seleccionadas) {
			num=num+c.getNumero();
			
		}
		return num==15;

	}
	


}

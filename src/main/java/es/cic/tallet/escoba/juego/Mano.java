package es.cic.tallet.escoba.juego;

import java.util.ArrayList;

public class Mano {

	private Carta carta1;
	private Carta carta2;
	private Carta carta3;
	private Jugador jugador;
	
	

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
	
	public boolean estaEnLaMano(Carta carta) {
		return carta1==carta || carta2==carta || carta3== carta;
	}
	
	
	public Carta estaEnLaMano(ArrayList <Carta> cartas) {
		for(Carta c: cartas) {
			if(estaEnLaMano(c)) {
				return c;
			}
		}
		return null;
	}


	public static boolean puedeSumarCarta(ArrayList <Carta> seleccionadas) {
		int num = 0;
		for(Carta c: seleccionadas) {
			num=num+c.getNumero();
		}
		return num==15;

	}
	public void eliminar(Carta carta) {
		if(carta== carta1)setCarta1(null);
		if(carta== carta2)setCarta2(null);
		if(carta== carta3)setCarta3(null);
	}
	
	
	public boolean puedeRepartir() {
		if(carta1==null && carta2 ==null && carta3== null) {
			return true;
		}
		return false;
		
	}
	public boolean sePuedeSeleccionarCarta() {
		boolean seleccionada= true;
		if(carta1.isSeleccionada()==true)seleccionada=false;
		if(carta2.isSeleccionada()==true)seleccionada=false;
		if(carta3.isSeleccionada()==true)seleccionada=false;
		return seleccionada;
	}
	
	public Carta getSeleccionada() {
		if(carta1.isSeleccionada()==true)return carta1;
		if(carta2.isSeleccionada()==true)return carta2;
		if(carta3.isSeleccionada()==true)return carta3;
		return null;
	}
	
	


}

package es.cic.tallet.escoba.juego;

import es.cic.taller.escoba.vista.ManoForm;

public class Jugador {
	private String nombre;
	private ManoForm mano;
	private boolean turno;
	
	
	public Jugador(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public ManoForm getMano() {
		return mano;
	}
	public void setManoActual(ManoForm mano) {
		this.mano = mano;
	}
	public boolean getTurno() {
		return turno;
	}
	public void setTurno(boolean juega) {
		turno=juega;
	}
	
}

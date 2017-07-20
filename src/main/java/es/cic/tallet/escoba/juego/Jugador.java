package es.cic.tallet.escoba.juego;

public class Jugador {
	private String nombre;
	private Mano manoActual;
	
	
	public Jugador(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public Mano getManoActual() {
		return manoActual;
	}
	public void setManoActual(Mano manoActual) {
		this.manoActual = manoActual;
	}
	
	
	
	
}

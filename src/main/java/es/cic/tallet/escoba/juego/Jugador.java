package es.cic.tallet.escoba.juego;

public class Jugador {
	private String nombre;
	private Mano manoActual;
	private boolean turno;
	
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
	public boolean getTurno() {
		return turno;
	}
	public void setTurno(boolean juega) {
		turno=juega;
	}
	
}

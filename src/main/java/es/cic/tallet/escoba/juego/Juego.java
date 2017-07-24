
package es.cic.tallet.escoba.juego;

public class Juego {

	private int puntuacionJugador1=0;
	private int puntuacionJugador2=0;

	public static int PUNTUACION_MAXIMA = 15;

	public boolean isTerminado() {
		return puntuacionJugador1 == PUNTUACION_MAXIMA || puntuacionJugador2== PUNTUACION_MAXIMA;
	}

	public int getPuntuacionJugador1() {
		return puntuacionJugador1;
	}
	public void sumaPuntuacionJugador1(int puntuacionEquipo1) {
		this.puntuacionJugador1 = this.puntuacionJugador1+ puntuacionEquipo1;
	}
	public int getPuntuacionJugador2() {
		return puntuacionJugador2;
	}
	public void sumaPuntuacionJugador2(int puntuacionEquipo2) {
		this.puntuacionJugador2 = this.puntuacionJugador2+ puntuacionEquipo2;
	}

	
	








}





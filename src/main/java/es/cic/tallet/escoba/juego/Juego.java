package es.cic.tallet.escoba.juego;

public class Juego {

	private int puntuacionJugador1;
	private int puntuacionJugador2;

	public static int PUNTUACION_MAXIMA = 15;

	public boolean isTerminado() {
		return puntuacionJugador1 == PUNTUACION_MAXIMA || puntuacionJugador2== PUNTUACION_MAXIMA;
	}

	public int getpuntuacionJugador1() {
		return puntuacionJugador1;
	}
	public void setPuntuacionEquipo1(int puntuacionEquipo1) {
		this.puntuacionJugador1 = puntuacionJugador1;
	}
	public int getPuntuacionJugador2() {
		return puntuacionJugador2;
	}
	public void setPuntuacionJugador2(int puntuacionEquipo2) {
		this.puntuacionJugador2 = puntuacionJugador2;
	}

	
	








}



}

package es.cic.tallet.escoba.juego;

import java.util.ArrayList;
import java.util.List;

public class Ronda {
	private Mano mano1 = new Mano();
	private Mano mano2 = new Mano();

	private ArrayList<Carta> seleccionadas = new ArrayList<Carta>();
	private ArrayList<Carta> medio = new ArrayList<Carta>();

	private Baraja baraja = new Baraja();

	private Juego juego = new Juego();

	private Jugador jugador1 = new Jugador("Jugador1");
	private Jugador jugador2 = new Jugador("Jugador2");

	public Ronda() {

		reparteMano();
		daCartasAlMedio();
		jugador1.setTurno(true);
	}

	public void cambiaTurno() {
		boolean turno = jugador1.getTurno();
		jugador1.setTurno(!turno);
		jugador2.setTurno(turno);
	}

	public Jugador getJugadorActual() {
		
		boolean turno = jugador1.getTurno();
		if (turno) {
			return jugador1;
		}
		return jugador2;
	}
	

	public void daCartasAlMedio() {
		medio.add(baraja.getCarta());
		medio.add(baraja.getCarta());
		medio.add(baraja.getCarta());
		medio.add(baraja.getCarta());
	}

	public void reparteMano() {
		baraja.reparteMano(mano1);
		baraja.reparteMano(mano2);
	}

	public List<Carta> getCartasMedio() {
		return medio;
	}

	public List<Carta> getListaSeleccionadas() {
		return seleccionadas;
	}

	public Mano getMano1() {
		return mano1;
	}

	public Mano getMano2() {
		return mano2;

	}

	public boolean puedeSumarCarta(Mano mano) {
		if (!mano.sePuedeSeleccionarCarta()) {
			int num = mano.getSeleccionada().getNumero();
			for (Carta c : seleccionadas) {
				num = num + c.getNumero();
			}
			return num == 15;
		}
		return false;
	}

	private int orosJ1() {
		int oros = 0;
		for (int i = 0; i < jugador1.getCartas().size(); i++) {
			if (jugador1.getCartas().get(i).getPalo().equals("ORO")) {
				oros++;
			}
		}
		return oros;
	}

	private int orosJ2() {
		int oros = 0;
		for (int i = 0; i < jugador2.getCartas().size(); i++) {
			if (jugador2.getCartas().get(i).getPalo().equals("ORO")) {
				oros++;
			}
		}
		return oros;
	}

	private int sietesJ1() {
		int sietes = 0;
		for (int i = 0; i < jugador1.getCartas().size(); i++) {
			if (jugador1.getCartas().get(i).getNumero() == 7) {
				sietes++;
			}
		}
		return sietes;
	}

	private int sietesJ2() {
		int sietes = 0;
		for (int i = 0; i < jugador2.getCartas().size(); i++) {
			if (jugador2.getCartas().get(i).getNumero() == 7) {
				sietes++;
			}
		}
		return sietes;
	}

	private boolean sieteOroJ1() {
		for (int i = 0; i < jugador1.getCartas().size(); i++) {
			if (jugador1.getCartas().get(i).getNumero() == 7 && jugador1.getCartas().get(i).getPalo().equals("ORO")) {
				return true;
			}
		}
		return false;
	}

	public void sumaPuntos() {
		int puntJ1 = 0;
		int puntJ2 = 0;
		if (jugador1.getCartas().size() > jugador2.getCartas().size()) {
			puntJ1++;

		} else if (jugador1.getCartas().size() < jugador2.getCartas().size()) {
			puntJ2++;
		}

		if (orosJ1() > orosJ2()) {
			puntJ1++;
		} else if (orosJ1() < orosJ2()) {
			puntJ2++;
		}

		if (sietesJ1() > sietesJ2()) {
			puntJ1++;

		} else if (sietesJ1() < sietesJ2()) {
			puntJ2++;
		}

		if (sieteOroJ1()) {
			puntJ1++;
		} else {
			puntJ2++;
		}
		
		jugador1.sumaPuntos(puntJ1);
		jugador2.sumaPuntos(puntJ2);

	}

	public boolean hayEscoba() {
	
		return medio.size() == 0;
		
	}

	public void sumaEscoba(Jugador jugador) {
		jugador.sumaPuntos(1);
	}

	public Jugador getJugador1() {
		return jugador1;
	}

	public void setJugador1(Jugador jugador1) {
		this.jugador1 = jugador1;
	}

	public Jugador getJugador2() {
		return jugador2;
	}

	public void setJugador2(Jugador jugador2) {
		this.jugador2 = jugador2;
	}

	public void reiniciaRonda() {
		jugador1.getCartas().clear();
		jugador2.getCartas().clear();
		baraja = new Baraja();
	}

	public void anhadeCArtasJugador(Jugador jugador) {
		List<Carta> robadas = seleccionadas;
		robadas.add(jugador.getMano().getMano().getSeleccionada());
		jugador.anhadeCartas(robadas);
	}

	public Baraja getBaraja() {
		return baraja;
	}

	public void setBaraja(Baraja baraja) {
		this.baraja = baraja;
	}
}

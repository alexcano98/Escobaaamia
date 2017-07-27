package es.cic.tallet.escoba.juego;

import java.util.ArrayList;
import java.util.List;

import es.cic.taller.escoba.vista.ManoForm;

public class Jugador {
	private String nombre;
	private ManoForm mano;
	private boolean turno;
	private int puntos=0;
	private List<Carta> cartas = new ArrayList<Carta>();
	
	public int getPuntos() {
		return puntos;
	}
	public void sumaPuntos(int p) {
		puntos=puntos+p;
	}
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
	public void anhadeCartas(List<Carta> robadas) {
		cartas.addAll(robadas);
	}
	public List<Carta> getCartas(){
		return cartas;
	}
	
}

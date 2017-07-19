package es.cic.taller.escoba.vista;

import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.VerticalLayout;

public class PantallaLayout extends GridLayout {
	
	private ManoForm manoFormJugador1;
	private ManoForm manoFormJugador2;
	private EscobasForm escobasFormJugador1;
	private EscobasForm escobasFormJugador2;
	
	private MyUI myUI;
	
	private MesaForm mesa;
	private Button recojer = new Button("Recojer");
	private Button soltar = new Button("Soltar");
	
	public PantallaLayout(MyUI myUI) {
		this.myUI = myUI;
		
		manoFormJugador1 = new ManoForm();
		manoFormJugador2 = new ManoForm();
		mesa = new MesaForm();
		
		setRows(3);
		setColumns(2);
		
		addComponent(manoFormJugador1,0,0);
		addComponent(manoFormJugador2,0,2);
		addComponent(escobasFormJugador1,1,0);
		addComponent(escobasFormJugador2,1,2);
		addComponent(mesa,0,1);
		
		VerticalLayout acciones = new VerticalLayout();
		acciones.addComponents(recojer,soltar);
		acciones.setSizeFull();
		this.setSizeFull();
		
		recojer.setEnabled(false);
		soltar.setEnabled(false);
		
		addComponent(acciones,1,1);
		
		
	}
	
	
	
	
	
	
	
	
	
}

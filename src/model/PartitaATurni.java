package model;

import java.io.Serializable;
import java.util.ArrayList;

public class PartitaATurni extends Partita implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int turni;

	public PartitaATurni(Mazzo mazzo, ArrayList<Giocatore> giocatori, String codice, int turni) {
		super(mazzo, giocatori, codice);
		this.setTurni(turni);
	}

	public int getTurni() {
		return turni;
	}

	public void setTurni(int turni) {
		this.turni = turni;
	}

}

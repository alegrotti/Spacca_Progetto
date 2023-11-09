package model;

import java.io.Serializable;
import java.util.HashSet;

public class PartitaATurni extends Partita implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int turni;

	public PartitaATurni(Mazzo mazzo, HashSet<String> giocatori, String codice, int turni, int creditiIniziali) {
		super(mazzo, giocatori, codice, creditiIniziali);
		this.setTurni(turni);
	}

	public int getTurni() {
		return turni;
	}

	public void setTurni(int turni) {
		this.turni = turni;
	}

}

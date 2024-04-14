package model;

import java.io.Serializable;
import java.util.ArrayList;

public class PartitaATurni extends Partita implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int turni;

	public PartitaATurni(ArrayList<String> giocatori, String codice, int turni, int creditiIniziali, String codiceTorneo) {
		super(giocatori, codice, creditiIniziali, codiceTorneo);
		this.setTurni(turni);
	}

	public int getTurni() {
		return turni;
	}

	public void setTurni(int turni) {
		this.turni = turni;
	}

}

package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Partita implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Mazzo mazzo;
	private int turno;
	private int nTurni;
	private ArrayList<String> giocatori;
	private String codice;
	
	
	public Partita(Mazzo mazzo, ArrayList<String> giocatori, String codice, int nTurni, int creditiIniziali) {
		this.mazzo = mazzo;
		this.giocatori = giocatori;
		this.codice = codice;
		this.setTurno(0);
		this.nTurni = nTurni;
		
	}

	public Mazzo getMazzo() {
		return mazzo;
	}

	public void setMazzo(Mazzo mazzo) {
		this.mazzo = mazzo;
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}
	
}

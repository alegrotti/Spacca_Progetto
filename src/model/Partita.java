package model;

import java.io.Serializable;
import java.util.HashSet;

public class Partita implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Mazzo mazzo;
	private int turno;
	private HashSet<String> giocatori;
	private String codice;
	
	
	public Partita(Mazzo mazzo, HashSet<String> giocatori, String codice, int creditiIniziali) {
		this.mazzo = mazzo;
		this.giocatori = giocatori;
		this.codice = codice;
		this.setTurno(0);
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

	public HashSet<String> getGiocatori() {
		return giocatori;
	}
	
}

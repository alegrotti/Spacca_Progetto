package model;

import java.io.Serializable;
import java.util.HashSet;

public class Partita implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Mazzo mazzo;
	private int turno;
	private HashSet<String> giocatori;
	private String codice;
	private int crediti;
	
	public Partita(Mazzo mazzo, HashSet<String> giocatori, String codice, int creditiIniziali) {
		this.mazzo = mazzo;
		this.giocatori = giocatori;
		this.codice = codice;
		this.turno = 0;
		this.crediti = creditiIniziali;
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
	
	public int getCrediti() {
		return crediti;
	}
}

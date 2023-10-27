package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Partita implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Mazzo mazzo;
	private int turno;
	private HashMap<Integer,Giocatore> postazioni;
	private String codice;
	
	
	public Partita(Mazzo mazzo, ArrayList<Giocatore> giocatori, String codice) {
		this.setMazzo(mazzo);
		for(int i = 0 ; i < giocatori.size() ; i++)
			postazioni.put(i, giocatori.get(i));
		this.setCodice(codice);
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
	
}

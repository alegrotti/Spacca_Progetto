package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Partita implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Mazzo mazzo;
	private int turno;
	private HashSet<String> giocatori;
	private String codice;
	private int creditiIniziali;
	private HashMap<String, City> cittadine;
	private HashMap<String, Integer> crediti;
	private ArrayList<String> carteTavolo;
	
	public Partita(Mazzo mazzo, HashSet<String> giocatori, String codice, int creditiIniziali) {
		this.mazzo = mazzo;
		this.giocatori = giocatori;
		this.codice = codice;
		this.turno = 0;
		this.creditiIniziali = creditiIniziali;
		this.crediti = creaCreditiIniziali(giocatori,creditiIniziali);
		carteTavolo = new ArrayList<String>();
		System.out.println("y");
	}

	private HashMap<String,Integer> creaCreditiIniziali(HashSet<String> g, int c){
		HashMap<String,Integer> cre = new HashMap<String,Integer>();
		for(String s : giocatori) {
			cre.put(s, creditiIniziali);
		}
		return cre;
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
	
	public int getCrediti(String s) {
		return crediti.get(s);
	}

	public ArrayList<String> getCarteTavolo() {
		return carteTavolo;
	}

	public City getCittadina(String c) {
		return cittadine.get(c);
	}

	public int getCreditiIniziali() {
		return creditiIniziali;
	}
}

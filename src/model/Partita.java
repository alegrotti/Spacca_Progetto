package model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;

public class Partita implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Mazzo mazzo;
	private int turno;
	private HashSet<String> giocatori;
	private HashSet<String> giocatoriTurno;
	private String codice;
	private int creditiIniziali;
	private int puntata;
	private HashMap<String, City> cittadine;
	private HashMap<String, Integer> crediti;
	
	public Partita(Mazzo mazzo, HashSet<String> giocatori, String codice, int creditiIniziali) {
		this.mazzo = mazzo;
		this.giocatori = giocatori;
		giocatoriTurno = giocatori;
		this.codice = codice;
		this.turno = 0;
		this.creditiIniziali = creditiIniziali;
		this.crediti = creaCreditiIniziali(giocatori,creditiIniziali);
		this.cittadine = creaCittadineIniziali(giocatori);
		this.puntata = 0;
	}

	private HashMap<String,Integer> creaCreditiIniziali(HashSet<String> g, int c){
		HashMap<String,Integer> cre = new HashMap<String,Integer>();
		for(String s : giocatori) {
			cre.put(s, creditiIniziali);
		}
		return cre;
	}
	
	private HashMap<String,City> creaCittadineIniziali(HashSet<String> g){
		HashMap<String,City> cit = new HashMap<String,City>();
		for(String s : giocatori) {
			cit.put(s, new City(s));
		}
		return cit;
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

	public City getCittadina(String c) {
		return cittadine.get(c);
	}

	public int getCreditiIniziali() {
		return creditiIniziali;
	}

	public HashSet<String> getGiocatoriTurno() {
		return giocatoriTurno;
	}

	public void aggiornaCrediti(HashSet<String> g, int puntata) {
		
	}

	public int getPuntata() {
		return puntata;
	}
}

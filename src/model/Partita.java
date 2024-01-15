package model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;

public class Partita implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Mazzo mazzoTurno;
	private Mazzo mazzo;
	private int turno;
	private HashSet<String> giocatori;
	private HashSet<String> giocatoriTurno;
	private String codice;
	private int creditiIniziali;
	private int tavolo;
	private Carta[] carteTavolo;
	private HashMap<String, Carta[]> mani;
	private HashMap<String, City> cittadine;
	private HashMap<String, Integer> crediti;
	
	public Partita(Mazzo mazzo, HashSet<String> giocatori, String codice, int creditiIniziali) {
		this.mazzo = mazzo;
		this.giocatori = giocatori;
		this.codice = codice;
		this.turno = 0;
		this.tavolo = 0;
		this.creditiIniziali = creditiIniziali;
		this.mani = null;
		this.mazzoTurno = null;
		this.carteTavolo = null;
		this.crediti = creaCreditiIniziali(giocatori,creditiIniziali);
		this.cittadine = creaCittadineIniziali(giocatori);
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
	
	public void aggiornaCrediti(HashSet<String> players, int puntata) {
		for(String p : players) {
			int x = crediti.get(p);
			if(x<puntata) {
				tavolo+=x;
				crediti.put(p, 0);
			}else {
				tavolo+=x;
				crediti.put(p, x-puntata);
			}
		}
	}
	
	public int getTavolo() {
		return tavolo;
	}
	/*
	public void inizializzaTurno() {
		tavolo = 0;
		giocatoriTurno = giocatori;
		mazzoTurno = mazzo;
		creaTavolo();
		mani = empty();
		for(Giocatore)
		creaMano();
	}
	*/
	public HashSet<String> getGiocatoriTurno() {
		return giocatoriTurno;
	}
	
	public Carta[] getMano(String n) {
		return mani.get(n);
	}
	
	public void creaTavolo() {
		Carta[] carte = new Carta[3];
		mazzoTurno.mix();
		for (int i = 0 ; i < carte.length ; i++) {
			
		}
		
	}
	
	public void creaMano() {
		Carta[] carte = new Carta[3];
		mazzoTurno.mix();
		for (int i = 0 ; i < carte.length ; i++) {
			
		}
	}
	
}

package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import controller.CampoGiocoController;

public class Partita implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Mazzo mazzoTurno;
	private Mazzo mazzo;
	private int turno;
	private ArrayList<String> giocatori;
	private ArrayList<String> giocatoriTurno;
	private String codice;
	private int creditiIniziali;
	private int tavolo;
	private Carta[] carteTavolo;
	private HashMap<String, Carta[]> mani;
	private HashMap<String, City> cittadine;
	private HashMap<String, Integer> crediti;
	
	public Partita(Mazzo mazzo, ArrayList<String> giocatori, String codice, int creditiIniziali) {
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

	private HashMap<String,Integer> creaCreditiIniziali(ArrayList<String> g, int c){
		HashMap<String,Integer> cre = new HashMap<String,Integer>();
		for(String s : giocatori) {
			cre.put(s, creditiIniziali);
		}
		return cre;
	}
	
	private HashMap<String,City> creaCittadineIniziali(ArrayList<String> g){
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

	public ArrayList<String> getGiocatori() {
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
	
	public void aggiornaCrediti(ArrayList<String> players, int puntata) {
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
	
	public void inizializzaTurno() {
		tavolo = 0;
		giocatoriTurno = giocatori;
		mazzoTurno = mazzo;
		carteTavolo = creaTavolo();
		CampoGiocoController.giocatore = giocatoriTurno.get(0);
		for(String g : giocatori)
			mani.put(g,creaMano());
	}
	
	public ArrayList<String> getGiocatoriTurno() {
		return giocatoriTurno;
	}
	
	public Carta[] getMano(String n) {
		return mani.get(n);
	}
	
	public Carta[] creaTavolo() {
		Carta[] carte = new Carta[3];
		mazzoTurno.mix();
		for (int i = 0 ; i < carte.length ; i++) {
			carte[i] = mazzoTurno.getCarte().getFirst();
			mazzoTurno.getCarte().remove(0);
		}
		return carte;
	}
	
	public Carta[] creaMano() {
		Carta[] carte = new Carta[3];
		mazzoTurno.mix();
		for (int i = 0 ; i < carte.length ; i++) {
			carte[i] = mazzoTurno.getCarte().getFirst();
			mazzoTurno.getCarte().remove(0);
		}
		return carte;
	}

	public Carta[] getCarteTavolo() {
		return carteTavolo;
	}
	
}

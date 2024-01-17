package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Partita implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Mazzo mazzoTurno;
	private Mazzo mazzo;
	private int turno;
	private int puntata;
	private ArrayList<String> giocatori;
	private ArrayList<String> giocatoriTurno;
	private String codice;
	private int creditiIniziali;
	private int tavolo;
	private Carta[] carteTavolo;
	private HashMap<String, Carta[]> mani;
	private HashMap<String, City> cittadine;
	private HashMap<String, Integer> crediti;
	private HashMap<String, Integer> creditiTurno;
	
	public Partita() {
		this.mazzo = null;
		this.turno = 0;
		this.giocatori = null;
		this.giocatoriTurno = null;
		this.codice = null;
		this.creditiIniziali = 0;
		this.tavolo = 0;
		this.mazzoTurno = null;
		this.carteTavolo = null;
		this.mani = null;
		this.cittadine = null;
		this.crediti = null;
		this.setPuntata(0);
	}

	public Partita(Mazzo mazzo, ArrayList<String> giocatori, String codice, int creditiIniziali) {
		this.mazzo = mazzo;
		this.giocatori = giocatori;
		this.codice = codice;
		this.turno = 0;
		this.tavolo = 0;
		this.setPuntata(0);
		this.creditiIniziali = creditiIniziali;
		this.mani = creaManiIniziali(giocatori);
		this.mazzoTurno = null;
		this.carteTavolo = null;
		this.crediti = creaCreditiIniziali(giocatori,creditiIniziali);
		this.creditiTurno = crediti;
		this.cittadine = creaCittadineIniziali(giocatori);
	}

	private HashMap<String,Carta[]> creaManiIniziali(ArrayList<String> giocatori){
		HashMap<String,Carta[]> gio = new HashMap<String,Carta[]>();
		for(String s : giocatori) {
			gio.put(s, new Carta[3]);
		}
		return gio;
	}
	
	private HashMap<String,Integer> creaCreditiIniziali(ArrayList<String> giocatori, int c){
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
	
	public void aggiornaCreditiTurno(String player, int puntata) {
		int x = crediti.get(player);
		crediti.put(player, x-puntata);
	}
	
	public int getTavolo() {
		return tavolo;
	}
	
	public String inizializzaTurno() {
		tavolo = 0;
		giocatoriTurno = giocatori;
		creditiTurno = crediti;
		mazzoTurno = mazzo;
		mazzoTurno.mix();
		carteTavolo = creaTavolo();
		mani = creaMani();
		
		return giocatoriTurno.get(0);
	}
	
	public ArrayList<String> getGiocatoriTurno() {
		return giocatoriTurno;
	}
	
	public Carta[] getMano(String n) {
		return mani.get(n);
	}
	
	public Carta[] creaTavolo() {
		Carta[] carte = new Carta[4];
		for (int i = 0 ; i < carte.length ; i++) {
			carte[i] = mazzoTurno.getCarte().getFirst();
			mazzoTurno.getCarte().remove(0);
		}
		return carte;
	}
	
	public HashMap<String,Carta[]> creaMani() {
		HashMap<String,Carta[]> m = new HashMap<String,Carta[]>();
		for(String g : giocatori) {
			Carta[] carte = new Carta[3];
			for (int i = 0 ; i < carte.length ; i++) {
				carte[i] = mazzoTurno.getCarte().getFirst();
				mazzoTurno.getCarte().remove(0);
			}
			m.put(g, carte);
		}
		return m;
	}

	public Carta[] getCarteTavolo() {
		return carteTavolo;
	}

	public int getPuntata() {
		return puntata;
	}

	public void setPuntata(int puntata) {
		this.puntata = puntata;
	}
	
}

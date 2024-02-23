package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import controller.GestoreScene;

public class Partita implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String vincitore;
	private Mazzo mazzoTurno;
	private Mazzo mazzo;
	private int turno;
	private boolean completata;
	private int mano;
	private int puntata;
	private ArrayList<String> giocatori;
	private ArrayList<String> giocatoriTurno;
	private ArrayList<String> giocatoriEliminati;
	private String codice;
	private ArrayList<String> giocatoriPuntata;
	private int creditiIniziali;
	private int tavolo;
	private Carta[] carteTavolo;
	private HashMap<String, Carta[]> mani;
	private HashMap<String, City> cittadine;
	private HashMap<String, Integer> crediti;
	
	public Partita() {
		this.mazzo = null;
		this.turno = 0;
		this.mano = 0;
		this.giocatori = null;
		this.codice = null;
		this.creditiIniziali = 0;
		this.tavolo = 0;
		this.mazzoTurno = null;
		this.carteTavolo = null;
		this.mani = null;
		this.cittadine = null;
		this.completata = false;
		this.crediti = null;
		this.giocatoriPuntata = null;
		this.vincitore = null;
		this.setPuntata(0);
	}

	public Partita(Mazzo mazzo, ArrayList<String> giocatori, String codice, int creditiIniziali) {
		this.mazzo = mazzo;
		this.giocatori = giocatori;
		this.codice = codice;
		this.turno = 1;
		this.mano = 0;
		this.tavolo = 0;
		this.setPuntata(0);
		this.creditiIniziali = creditiIniziali;
		this.mani = creaManiIniziali(giocatori);
		this.giocatoriEliminati = new ArrayList<>();
		this.mazzoTurno = null;
		this.carteTavolo = null;
		this.giocatoriPuntata = null;
		this.vincitore = null;
		this.completata = false;
		this.crediti = creaCreditiIniziali(giocatori,creditiIniziali);
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
			City c = new City(s);
			cit.put(s,c);
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
	
	public ArrayList<String> getGiocatoriEliminati() {
		return giocatoriEliminati;
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
		City citt = cittadine.get(c);
		return citt;
	}

	public int getCreditiIniziali() {
		return creditiIniziali;
	}
	
	public void aggiornaCrediti(ArrayList<String> players, int puntata) {
		giocatoriTurno = players;
		giocatoriTurno.sort(null);
		for(String p : giocatoriTurno) {
			int x = crediti.get(p);
			if(x<puntata) {
				tavolo+=x;
				crediti.put(p, 0);
			}else {
				tavolo+=puntata;
				crediti.put(p, x-puntata);
			}
		}
	}
	
	public void aggiornaCreditiTurno(String player, int p) {
		if(puntata<p) {
			puntata = p;
			giocatoriPuntata.removeAll(giocatoriPuntata);
			giocatoriPuntata.add(player);
		}else if(puntata==p) {
			giocatoriPuntata.add(player);
		}
	}
	
	public int getTavolo() {
		return tavolo;
	}
	
	public String inizializzaTurno() {
		tavolo = 0;
		vincitore = "";
		puntata = 0;		
		giocatoriTurno = new ArrayList<String>();
		giocatoriTurno.addAll(giocatori);
		mazzoTurno = new Mazzo();
		mazzoTurno.getCarte().addAll(mazzo.getCarte());
		mano = 0;
		mazzoTurno.mix();
		giocatoriPuntata = new ArrayList<String>();
		carteTavolo = creaTavolo();
		mani = creaMani();
		
		return giocatoriTurno.get(0);
	}
	
	public String aggiornaTurno() {
		if(mano<2) {
			mano++;
			puntata = 0;
			giocatoriPuntata.removeAll(giocatoriPuntata);
			return giocatoriTurno.get(0);
		}else {
			return null;
		}
	}
	
	public void nextTurn() {
		turno++;
	}
	
	public ArrayList<String> getGiocatoriTurno() {
		return giocatoriTurno;
	}
	
	public Carta[] getMano(String n) {
		return mani.get(n);
	}
	
	public Carta[] creaTavolo() {
		Carta[] carte = new Carta[3];
		for (int i = 0 ; i < carte.length ; i++) {
			carte[i] = mazzoTurno.getCarte().get(0);
			mazzoTurno.getCarte().remove(0);
		}
		return carte;
	}
	
	public HashMap<String,Carta[]> creaMani() {
		HashMap<String,Carta[]> m = new HashMap<String,Carta[]>();
		for(String g : giocatori) {
			Carta[] carte = new Carta[4];
			for (int i = 0 ; i < carte.length ; i++) {
				carte[i] = mazzoTurno.getCarte().get(0);
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

	public ArrayList<String> getGiocatoriPuntata() {
		return giocatoriPuntata;
	}
	
	public void assegnaTavolo(String winner) {
		int x = crediti.get(winner);
		crediti.put(winner,x+tavolo);
	}
	
	public String nextPlayer(String s) {
		boolean trovato = false;
		for (String str : giocatoriTurno) {
            if (trovato)
                return str;
            if (str.equals(s))
                trovato = true;
        }
		
		giocatoriTurno.trimToSize();
		
		if (giocatoriTurno.size() == 1)
			vincitore = giocatoriTurno.get(0);
		else
			vincitore = null;

		return null;
	}
	
	public String getWinner() {
		return vincitore;
	}
	
	public void eliminaGiocatoreTurno(String g) {
		giocatoriTurno.remove(g);
	}

	public void controllaCrediti() {
		for(String s : giocatori)
			if(crediti.get(s) <= 0) 
				giocatoriEliminati.add(s);
		giocatori.removeAll(giocatoriEliminati);
	}
	
	public int getMano() {
		return mano;
	}
	
	public void rimuoviCrediti(String s) {
		int x = crediti.get(s);
		crediti.put(s, x-puntata);
		tavolo += puntata;
	}
	
	public String confrontaCittadineTurno() {
		vincitore = null;
		City w = null;
		for(String s : giocatoriTurno) {
			City c = new City(s);
	    	for(int i = 0; i<this.getMano(s).length ; i++)
	    		c.aggiungiCarta(this.getMano(s)[i]);
	    	
	    	for(int i = 0; i<this.getCarteTavolo().length ; i++)
	    		c.aggiungiCarta(this.getCarteTavolo()[i]);
			w = c.compareTo(w);
			
		}
		vincitore = w.getNome();
		return vincitore;
	}
	
	public String confrontaCittadine() {
		vincitore = null;
		City w = null;
		for(String s : giocatoriTurno) {
			City c = cittadine.get(s); 
			w = c.compareTo(w);
		}
		vincitore = w.getNome();
		return vincitore;
	}
	
	public int cityMaggiore() {
		int x = 0;
		for(String y : cittadine.keySet()) {
			City c = cittadine.get(y);
			if(c.getCarte().size()>x)
				x = c.getCarte().size();
		}
		return x;
	}
	
	public void chiudiPartita() {
		completata = true;
	}
	
	public boolean checkWinner() {
		if(this instanceof PartitaATurni) {
			PartitaATurni partita = (PartitaATurni)this;
			if(getTurno()>partita.getTurni())
				return true;
			else
				if(giocatori.size()==1)
					return true;
				else if(giocatori.size()==0)
					return true;
				else
					return false;
		}else if(this instanceof PartitaAPalazzi) {
			PartitaAPalazzi partita = (PartitaAPalazzi)this;
			if(cityMaggiore()==partita.getPalazzi())
				return true;
			else
				if(giocatori.size()==1)
					return true;
				else if(giocatori.size()==0)
					return true;
				else
					return false;
		}else {
			GestoreScene.messaggioErrore("Partita non caricata correttamente");
			return false;
		}
	}

	public boolean isCompletata() {
		return completata;
	}
	
}

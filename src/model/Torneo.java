package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Torneo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String vincitore;
	private String tipo;
	private int obiettivo;
	private boolean completato;
	private ArrayList<String> giocatori;
	private ArrayList<String> giocatoriEliminati;
	private String codice;
	private int creditiIniziali;
	private HashMap<String, Integer> crediti;
	//private HashMap<String, Partita> partiteTorneo;
	
	public Torneo() {
		this.tipo = null;
		this.obiettivo = 0;
		this.giocatori = null;
		this.codice = null;
		this.creditiIniziali = 0;
		this.completato = false;
		this.crediti = null;
		this.vincitore = null;
	}

	public Torneo(String tipo, ArrayList<String> giocatori, String codice, int obiettivo, int creditiIniziali) {
		this.tipo = tipo;
		this.obiettivo = obiettivo;
		this.giocatori = giocatori;
		this.codice = codice;
		this.creditiIniziali = creditiIniziali;
		this.giocatoriEliminati = new ArrayList<>();
		this.vincitore = null;
		this.completato = false;
		this.crediti = creaCreditiIniziali(giocatori,creditiIniziali);
		//this.partiteTorneo = creaPartite();
	}

	/*private HashMap<String,Carta[]> creaPartite(ArrayList<String> giocatori){
		HashMap<String,Partita> gio = new HashMap<String,Partita>();
		for(String s : giocatori) {
			gio.put(s, new Carta[3]);
		}
		return gio;
	}*/
	
	private HashMap<String,Integer> creaCreditiIniziali(ArrayList<String> giocatori, int c){
		HashMap<String,Integer> cre = new HashMap<String,Integer>();
		for(String s : giocatori) {
			cre.put(s, creditiIniziali);
		}
		return cre;
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

	public int getCreditiIniziali() {
		return creditiIniziali;
	}
	
	public void aggiornaCrediti(ArrayList<String> players, int puntata) {
	
	}
	
	public String getWinner() {
		return vincitore;
	}
	
	public void chiudiTorneo() {
		completato = true;
	}
	
	/*
	public boolean checkWinner() {
		if(this instanceof TorneoATurni) {
			TorneoATurni torneo = (TorneoATurni)this;
			if(getTurno()>torneo.getTurni())
				return true;
			else
				if(giocatori.size()==1)
					return true;
				else if(giocatori.size()==0)
					return true;
				else
					return false;
		}else if(this instanceof TorneoAPalazzi) {
			TorneoAPalazzi torneo = (TorneoAPalazzi)this;
			if(cityMaggiore()==torneo.getPalazzi())
				return true;
			else
				if(giocatori.size()==1)
					return true;
				else if(giocatori.size()==0)
					return true;
				else
					return false;
		}else {
			GestoreScene.messaggioErrore("Torneo non caricata correttamente");
			return false;
		}
	}
	*/

	public boolean isCompletata() {
		return completato;
	}

	public String getTipo() {
		return tipo;
	}

	public int getObiettivo() {
		return obiettivo;
	}
	
}

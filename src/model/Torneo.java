package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Torneo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String vincitore;
	private String tipo;
	private int obiettivo;
	private ArrayList<String> giocatori;
	private HashMap<String, Giocatore> giocatoriCPU;
	private ArrayList<String> giocatoriEliminati;
	private String codice;
	private int creditiIniziali;
	private int stato;
	private HashMap<String, Integer> crediti;
	private HashMap<String, Partita> partiteTorneo;
	
	public Torneo() {
		this.stato = 0;
		this.giocatoriCPU = null;
		this.tipo = null;
		this.obiettivo = 0;
		this.giocatori = null;
		this.codice = null;
		this.creditiIniziali = 0;
		this.crediti = null;
		this.vincitore = null;
	}

	public Torneo(String tipo, ArrayList<String> giocatori, String codice, int obiettivo, int creditiIniziali) {
		this.tipo = tipo;
		this.giocatoriCPU = new HashMap<String,Giocatore> ();
		this.giocatori = creaGiocatori(giocatori);
		this.stato = creaStato(giocatori);
		this.obiettivo = obiettivo;
		this.codice = codice;
		this.creditiIniziali = creditiIniziali;
		this.giocatoriEliminati = new ArrayList<>();
		this.vincitore = null;
		this.crediti = creaCreditiIniziali(giocatori,creditiIniziali);
		this.partiteTorneo = new HashMap<String,Partita>();
		creaPartite();
	}

	private void creaPartite() {
		HashMap<String,Partita> games = new HashMap<String,Partita>();
		Partita p;
		String s = "";
		if(stato==4) {
			s = "Ottavo-";
		}else if(stato == 3) {
			s = "Quarto-";
		}else if(stato == 2) {
			s = "Semifinale-";
		}
		
		if(tipo.equals("Turni"))
			for(int i = 0; i < giocatori.size(); i+=2) {
				String cod = s + ((i/2) + 1);
				ArrayList<String> pl = new ArrayList<String>();
				pl.add(giocatori.get(i));
				pl.add(giocatori.get(i+1));
				p = new PartitaATurni(pl,cod,obiettivo,creditiIniziali);
				games.put(cod, p);
			}
		else
			for(int i = 0; i < giocatori.size(); i+=2) {
				String cod = s + ((i/2) + 1);
				p = new PartitaAPalazzi((ArrayList<String>)giocatori.subList(i, i+1),cod,obiettivo,creditiIniziali);
				games.put(cod, p);
			}
		
		partiteTorneo.putAll(games);
	}
	
	private ArrayList<String> creaGiocatori(ArrayList<String> g) {
		
		ArrayList<String> p = new ArrayList<String>();
		
		int x = 0;
		if(g.size() <= 16) {
			if(g.size() <= 8) {
				if(g.size() <= 4)
					x = (4-g.size());
			}else
				x = (8-g.size());
		}else 
			x = (16-g.size());
	
		Random r = new Random();
		
		for(int i = 0; i < x ; i++) {
			
			String name = "Giocatore"+i;
			
			int b = r.nextInt(2);
			
			Giocatore player;
			
			if (b == 0) {
				player = new GiocatoreCPUFacile(name);
			}else {
				player = new GiocatoreCPUDifficile(name);
			}
			
			p.add(player.getUsername());
			
			giocatoriCPU.put(player.getUsername(), player);
			
		}
			
		g.addAll(p);
		return g;
	}
	
	private int creaStato(ArrayList<String> g) {
		int x = 0;
		if(g.size() == 4)
			x = 2;
		else if(g.size() == 8)
			x = 3;	
		else if(g.size() == 16)
			x = 4;
		
		return x;
	}
	
	public HashMap<String, Partita> getPartiteTorneo() {
		return partiteTorneo;
	}

	private HashMap<String,Integer> creaCreditiIniziali(ArrayList<String> giocatori, int c){
		HashMap<String,Integer> cre = new HashMap<String,Integer>();
		for(String s : giocatori) {
			cre.put(s, creditiIniziali);
		}
		return cre;
	}
	
	public int getSize() {
		return giocatori.size() + giocatoriEliminati.size();
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

	public HashMap<String, Giocatore> getGiocatoriCPU() {
		return giocatoriCPU;
	}

	public int getCreditiIniziali() {
		return creditiIniziali;
	}
	
	public void aggiornaCrediti(ArrayList<String> players, int puntata) {
	
	}
	
	public String getWinner() {
		return vincitore;
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

	public String getTipo() {
		return tipo;
	}

	public int getObiettivo() {
		return obiettivo;
	}

	public int getStato() {
		return stato;
	}
	
}

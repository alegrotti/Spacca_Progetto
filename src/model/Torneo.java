package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class Torneo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String vincitore;
	private String tipo;
	private int obiettivo;
	private ArrayList<String> giocatori;
	private HashMap<String, Giocatore> giocatoriCPU;
	private String codice;
	private int creditiIniziali;
	private int stato;
	private int partiteFinite;
	private boolean completato;
	private HashMap<String, Integer> crediti;
	private HashMap<String, Partita> partiteTorneo;
	
	public Torneo() {
		this.stato = 0;
		this.giocatoriCPU = null;
		this.partiteFinite = 0;
		this.tipo = null;
		this.obiettivo = 0;
		this.giocatori = null;
		this.codice = null;
		this.creditiIniziali = 0;
		this.crediti = null;
		this.vincitore = null;
		this.completato = false;
	}

	public Torneo(String tipo, ArrayList<String> giocatori, String codice, int obiettivo, int creditiIniziali) {
		this.tipo = tipo;
		this.giocatoriCPU = new HashMap<String,Giocatore> ();
		this.giocatori = creaGiocatori(giocatori);
		Collections.shuffle(this.giocatori);
		this.stato = creaStato(giocatori);
		this.obiettivo = obiettivo;
		this.codice = codice;
		this.creditiIniziali = creditiIniziali;
		this.vincitore = null;
		this.crediti = creaCreditiIniziali(giocatori,creditiIniziali);
		this.partiteTorneo = new HashMap<String,Partita>();
		creaPartite();
		this.partiteFinite = 0;
		this.completato = false;
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
		}else if(stato == 1)
			s = "Finale";
		
		if(tipo.equals("Turni"))
			for(int i = 0; i < giocatori.size(); i+=2) {
				String cod = s + ((i/2) + 1);
				ArrayList<String> pl = new ArrayList<String>();
				pl.add(giocatori.get(i));
				pl.add(giocatori.get(i+1));
				p = new PartitaATurni(pl,cod,obiettivo,creditiIniziali, codice);
				games.put(cod, p);
				System.out.println("Partita del torneo "+cod+" creata");
			}
		else
			for(int i = 0; i < giocatori.size(); i+=2) {
				String cod = s + ((i/2) + 1);
				ArrayList<String> pl = new ArrayList<String>();
				pl.add(giocatori.get(i));
				pl.add(giocatori.get(i+1));
				p = new PartitaAPalazzi(pl,cod,obiettivo,creditiIniziali, codice);
				games.put(cod, p);
				System.out.println("Partita del torneo "+cod+" creata");
			}
		
		partiteTorneo.putAll(games);
	}
	
	private ArrayList<String> creaGiocatori(ArrayList<String> g) {
		
		ArrayList<String> p = new ArrayList<String>();
		
		System.out.println(g.size());
		
		int x = 0;
		if(g.size() <= 16)
			if(g.size() <= 8) {
				if(g.size() <= 4) {
					x = (4-g.size());
				}else
					x = (8-g.size());
			}else 
			x = (16-g.size());
		
		Random r = new Random();
		
		System.out.println(x);
		
		for(int i = 0; i < x ; i++) {
			
			String name = "G"+i;
			
			int b = r.nextInt(2);
			
			Giocatore player;
			
			if (b == 0)
				player = new GiocatoreCPUFacile(name);
			else
				player = new GiocatoreCPUDifficile(name);
			
			p.add(player.getUsername());
			
			giocatoriCPU.put(player.getUsername(), player);
			
		}
			
		g.addAll(p);
		return g;
	}
	
	private int creaStato(ArrayList<String> g) {
		if(g.size() == 4)
			return 2;
		else if(g.size() == 8)
			return 3;	
		else if(g.size() == 16)
			return 4;
		else
			return 0;
	}
	
	public void aggiorna() {
		
		partiteFinite = 0;
		
		controllaPartite();
		
		if(aggiornaStato()) {
			if(stato == 3)
				creaQuarti();
			else if(stato == 2) 
				creaSemifinali();
			else if(stato == 1)
				creaFinale();
			else if(stato == 0) {
				checkWinner();
				chiudiTorneo();
				DBGiocatori.aggiornaPunti(this);
			}
		}
		
	}
	
	private void creaQuarti() {
		
		ArrayList<String> g1 = new ArrayList<>();
		ArrayList<String> g2 = new ArrayList<>();
		ArrayList<String> g3 = new ArrayList<>();
		ArrayList<String> g4 = new ArrayList<>();
		
		Partita p1 = partiteTorneo.get("Ottavo-1");
		Partita p2 = partiteTorneo.get("Ottavo-2");
		Partita p3 = partiteTorneo.get("Ottavo-3");
		Partita p4 = partiteTorneo.get("Ottavo-4");
		Partita p5 = partiteTorneo.get("Ottavo-5");
		Partita p6 = partiteTorneo.get("Ottavo-6");
		Partita p7 = partiteTorneo.get("Ottavo-7");
		Partita p8 = partiteTorneo.get("Ottavo-8");
		
		if(!p1.getWinner().equals("")) 
			g1.add(p1.getWinner());
		
		if(!p2.getWinner().equals(""))
			g1.add(p2.getWinner());
		
		if(!p3.getWinner().equals("")) 
			g2.add(p3.getWinner());
		
		if(!p4.getWinner().equals(""))
			g2.add(p4.getWinner());
		
		if(!p5.getWinner().equals("")) 
			g3.add(p1.getWinner());
		
		if(!p6.getWinner().equals(""))
			g3.add(p2.getWinner());
		
		if(!p7.getWinner().equals("")) 
			g4.add(p3.getWinner());
		
		if(!p8.getWinner().equals(""))
			g4.add(p4.getWinner());

		HashMap<String,Partita> games = new HashMap<String,Partita>();
		Partita p;
		String s = "Ottavo-";
		if(tipo.equals("Turni")) {
			p = new PartitaATurni(g1,s+1,obiettivo,creditiIniziali, codice);
			games.put(p.getCodice(), p);
			
			p = new PartitaATurni(g2,s+2,obiettivo,creditiIniziali, codice);
			games.put(p.getCodice(), p);
			
			p = new PartitaATurni(g3,s+3,obiettivo,creditiIniziali, codice);
			games.put(p.getCodice(), p);
			
			p = new PartitaATurni(g4,s+4,obiettivo,creditiIniziali, codice);
			games.put(p.getCodice(), p);
		}else {
			p = new PartitaAPalazzi(g1,s+1,obiettivo,creditiIniziali, codice);
			games.put(p.getCodice(), p);
			
			p = new PartitaAPalazzi(g2,s+2,obiettivo,creditiIniziali, codice);
			games.put(p.getCodice(), p);
			
			p = new PartitaAPalazzi(g1,s+3,obiettivo,creditiIniziali, codice);
			games.put(p.getCodice(), p);
			
			p = new PartitaAPalazzi(g2,s+4,obiettivo,creditiIniziali, codice);
			games.put(p.getCodice(), p);
		}
			
		partiteTorneo.putAll(games);
		
	}
	
	private void creaSemifinali() {
		
		ArrayList<String> g1 = new ArrayList<>();
		ArrayList<String> g2 = new ArrayList<>();
		
		Partita p1 = partiteTorneo.get("Quarto-1");
		Partita p2 = partiteTorneo.get("Quarto-2");
		Partita p3 = partiteTorneo.get("Quarto-3");
		Partita p4 = partiteTorneo.get("Quarto-4");
		
		if(!p1.getWinner().equals("")) 
			g1.add(p1.getWinner());
		
		if(!p2.getWinner().equals(""))
			g1.add(p2.getWinner());
		
		if(!p3.getWinner().equals("")) 
			g2.add(p3.getWinner());
		
		if(!p4.getWinner().equals(""))
			g2.add(p4.getWinner());

		HashMap<String,Partita> games = new HashMap<String,Partita>();
		Partita p;
		String s = "Semifinale-";
		if(tipo.equals("Turni")) {
			p = new PartitaATurni(g1,s+1,obiettivo,creditiIniziali, codice);
			games.put(p.getCodice(), p);
			
			p = new PartitaATurni(g2,s+2,obiettivo,creditiIniziali, codice);
			games.put(p.getCodice(), p);
		}else {
			p = new PartitaAPalazzi(g1,s+1,obiettivo,creditiIniziali, codice);
			games.put(p.getCodice(), p);
			
			p = new PartitaAPalazzi(g2,s+2,obiettivo,creditiIniziali, codice);
			games.put(p.getCodice(), p);
		}
			
		partiteTorneo.putAll(games);
		
	}

	private void creaFinale() {	
		
		ArrayList<String> g = new ArrayList<>();
		Partita p1 = partiteTorneo.get("Semifinale-1");
		Partita p2 = partiteTorneo.get("Semifinale-2");
		
		if(!p1.getWinner().equals(""))
			g.add(p1.getWinner());
		
		if(!p2.getWinner().equals(""))
			g.add(p2.getWinner());
		
		HashMap<String,Partita> games = new HashMap<String,Partita>();
		Partita p;
		if(tipo.equals("Turni")) {
			p = new PartitaATurni(g,"Finale",obiettivo,creditiIniziali, codice);
			games.put("Finale", p);
		}else {
			p = new PartitaAPalazzi(g,"Finale",obiettivo,creditiIniziali, codice);
			games.put("Finale", p);
		}
			
		partiteTorneo.putAll(games);
		
	}
	
	private void controllaPartite() {
	
		String s = "";
		
		if(stato==4) {
			System.out.println("Controllo ottavi");
    		s="Ottavo-";
    		for(int i = 1; i < 9; i++) {
    			Partita p = partiteTorneo.get(s+i);
    			if (p.isCompletata())
    				partiteFinite++;
    		}
    		
    	}	
    	else if(stato==3) {
    		s="Quarto-";
    		for(int i = 1; i < 5; i++) {
    			Partita p = partiteTorneo.get(s+i);
    			if (p.isCompletata())
    				partiteFinite++;
    		}
		}
    	else if(stato==2) {
    		s="Semifinale-";
    		for(int i = 1; i < 3; i++) {
    			Partita p = partiteTorneo.get(s+i);
    			if (p.isCompletata())
    				partiteFinite++;
    		}

    	}
    	else if(stato==1) {
    		s="Finale";
    		Partita p = partiteTorneo.get(s);
    			if (p.isCompletata())
    				partiteFinite++;
    	}
	}
	
	private boolean aggiornaStato() {
		if( controlloStato() && stato > 0) {
			stato=stato-1;
			return true;
		}else
			return false;
	}
	
	private boolean controlloStato() {
		if ( partiteFinite == Math.pow(2, stato-1) )
			return true;
		else
			return false;
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
		return giocatori.size();
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
	
	public boolean checkWinner() {
		try{
			Partita p = partiteTorneo.get("Finale");
			vincitore = p.getWinner();
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	public String getTipo() {
		return tipo;
	}

	public void chiudiTorneo() {
		completato = true;
	}
	
	public int getObiettivo() {
		return obiettivo;
	}

	public int getStato() {
		return stato;
	}
	
	public void eliminaGiocatoriDB() {
		DBGiocatori.eliminaGiocatori(getGiocatoriCPU());
	}
	
	public void aggiornaPartita(Partita p) {
		partiteTorneo.put(p.getCodice(), p);
	}
	
	public boolean isCompletato() {
		return completato;
	}
	
}

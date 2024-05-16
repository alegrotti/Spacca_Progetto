package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import controller.GestoreScene;

public class DBGiocatori {

	public static final String DATABASE_PATH = "log/giocatoriDatabase.dat";

	private static HashMap<String,Giocatore> giocatori;
	
	public static void aggiornaDB() {
		giocatori = new HashMap<String,Giocatore>();
		GestioneFile.salvaDB(giocatori,DATABASE_PATH);
	}
	
	@SuppressWarnings("unchecked")
	public static Set<String> getGiocatori(){
		try {
			giocatori = (HashMap<String,Giocatore>)GestioneFile.caricaDB(DATABASE_PATH);
			System.out.println("Giocatori caricati da DB");
			return giocatori.keySet();
		}catch(Exception e) {
			GestoreScene.messaggioErrore("Errore caricamento giocatori");
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public static HashMap<String,Giocatore> Giocatori(){
		try {
			giocatori = (HashMap<String,Giocatore>)GestioneFile.caricaDB(DATABASE_PATH);
			System.out.println("Giocatori caricati da DB");
			return giocatori;
		}catch(Exception e) {
			GestoreScene.messaggioErrore("Errore caricamento giocatori");
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public static Giocatore getGiocatore(String username) {
		try {
			giocatori = (HashMap<String,Giocatore>)GestioneFile.caricaDB(DATABASE_PATH);
			System.out.println("Giocatore caricato da DB");
			return giocatori.get(username);
		} catch (Exception e) {
			GestoreScene.messaggioErrore("Errore caricamento giocatore");
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public static void aggiungiGiocatore(Giocatore g) {
		try {
			giocatori = (HashMap<String,Giocatore>)GestioneFile.caricaDB(DATABASE_PATH);
			giocatori.put(g.getUsername(),g);
			GestioneFile.salvaDB(giocatori,DATABASE_PATH);
			System.out.println("Giocatore aggiunto al DB");
		} catch (Exception e) {
			GestoreScene.messaggioErrore("Errore aggiunta giocatore");
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void aggiungiGiocatori(HashMap<String,Giocatore> g) {
		try {
			giocatori = (HashMap<String,Giocatore>)GestioneFile.caricaDB(DATABASE_PATH);
			giocatori.putAll(g);
			GestioneFile.salvaDB(giocatori,DATABASE_PATH);
			System.out.println("Giocatori aggiunti al DB");
		} catch (Exception e) {
			GestoreScene.messaggioErrore("Errore aggiunta giocatore");
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void eliminaGiocatore(String g) {
		try {
			giocatori = (HashMap<String,Giocatore>)GestioneFile.caricaDB(DATABASE_PATH);
			giocatori.remove(g);
			GestioneFile.salvaDB(giocatori,DATABASE_PATH);
			System.out.println("Giocatore eliminato dal DB");
		} catch (Exception e) {
			GestoreScene.messaggioErrore("Errore eliminazione giocatore");
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void eliminaGiocatori(HashMap<String,Giocatore> g) {
		try {
			giocatori = (HashMap<String,Giocatore>)GestioneFile.caricaDB(DATABASE_PATH);
			for(String s : g.keySet())
				giocatori.remove(s);
			GestioneFile.salvaDB(giocatori,DATABASE_PATH);
			System.out.println("Giocatori eliminati dal DB");
		} catch (Exception e) {
			GestoreScene.messaggioErrore("Errore eliminazione giocatore");
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void aggiornaPunti (Partita p) {
		try {
			giocatori = (HashMap<String,Giocatore>)GestioneFile.caricaDB(DATABASE_PATH);
			
			ArrayList<String> classifica = p.getClassifica();
			classifica.addAll(p.getGiocatoriEliminati());
			
			for(int i = 0 ; i < classifica.size() ; i++) {
				String s = classifica.get(i);
				
				Giocatore g = DBGiocatori.getGiocatore(s);
				
				g.aumentaPartiteGiocate();
				g.aggiungiPuntiCity(p.getCittadina(s).getPunteggio());
				
		    	if(i==0) 
		    		g.primoPosto();
		    	else if(i==1)
		    		g.secondoPosto();
		    	else if(i==2)
		    		g.terzoPosto();
		    	
	    		System.out.println(g.getPuntiPartite()+" punti aggiunti a "+g.getUsername());
	    		aggiungiGiocatore(g);
			}

			System.out.println("Punteggi aggiornati");
		} catch (Exception e) {
			GestoreScene.messaggioErrore("Errore caricamento giocatore");
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void aggiornaPunti (Torneo t) {
		try {
			giocatori = (HashMap<String,Giocatore>)GestioneFile.caricaDB(DATABASE_PATH);
			
			int k = t.getSize();
			
			ArrayList<String> sf = new ArrayList<String>();
			ArrayList<String> f = new ArrayList<String>();
			
			sf.addAll(t.getPartiteTorneo().get("Semifinale-1").getGiocatori());
			sf.addAll(t.getPartiteTorneo().get("Semifinale-2").getGiocatori());
			sf.addAll(t.getPartiteTorneo().get("Semifinale-1").getGiocatoriEliminati());
			sf.addAll(t.getPartiteTorneo().get("Semifinale-2").getGiocatoriEliminati());
			
			f.addAll(t.getPartiteTorneo().get("Finale").getGiocatori());
			f.addAll(t.getPartiteTorneo().get("Finale").getGiocatoriEliminati());
			
			for(String s : sf) {
				giocatori.get(s).semifinalistaTorneo(k);
			}
			
			for(String s : f) {
				giocatori.get(s).finalistaTorneo(k);
			}
			
			if(!t.getWinner().equals(""))
				giocatori.get(t.getWinner()).vincitoreTorneo(k);
			
			for(String s : t.getGiocatori())
				giocatori.get(s).aumentaTorneiGiocati();
			
			aggiungiGiocatori(giocatori);
			System.out.println("Punteggi aggiornati");
		} catch (Exception e) {
			GestoreScene.messaggioErrore("Errore caricamento giocatore");
		}
	}
	
}

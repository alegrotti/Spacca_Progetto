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
			
			for(String s: giocatori.keySet()) {
		    	if(classifica.get(0).contains(s)) {
		    		Giocatore g1 = DBGiocatori.getGiocatore(s);
		    		g1.primoPosto();
		    		System.out.println("Punti aggiunti al vincitore");
		    		System.out.println(DBGiocatori.getGiocatore(s).getUsername());
		    		System.out.println(DBGiocatori.getGiocatore(s).getPuntiPartite());
		    		DBGiocatori.aggiornaDB();
		    	}
		    	else if(classifica.get(1).contains(s)) {
		    		Giocatore g2 = DBGiocatori.getGiocatore(s);
		    		g2.secondoPosto();
		    		DBGiocatori.aggiornaDB();
		    	}
		    	else if(classifica.get(2) != null){
			    	if(classifica.get(2).contains(s)) {
			    		Giocatore g3 = DBGiocatori.getGiocatore(s);
			    		g3.terzoPosto();
			    		DBGiocatori.aggiornaDB();
			    	}
		    	}
		    	else 
		    		continue;
			
			GestioneFile.salvaDB(giocatori,DATABASE_PATH);
			System.out.println("Punteggi aggiornati");
		} catch (Exception e) {
			GestoreScene.messaggioErrore("Errore caricamento giocatore");
		}
	}
	
	public static void aggiornaPunti (Torneo t) {
		
	}
	
}

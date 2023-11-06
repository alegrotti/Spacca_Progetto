package model;

import java.util.HashMap;

import controller.Main;

public class DBGiocatori {

	public static final String DATABASE_PATH = "log/giocatoriDatabase.dat";

	private static HashMap<String,Giocatore> giocatori;
	
	@SuppressWarnings("unchecked")
	public static Giocatore getGiocatore(String username) {
		try {
			giocatori = (HashMap<String,Giocatore>)GestioneFile.caricaDB(DATABASE_PATH);
			return giocatori.get(username);
		} catch (Exception e) {
			Main.messaggioErrore("Errore caricamento giocatore");
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public static void aggiungiGiocatore(Giocatore g) {
		try {
			giocatori = (HashMap<String,Giocatore>)GestioneFile.caricaDB(DATABASE_PATH);
			giocatori.put(g.getUsername(),g);
			GestioneFile.salvaDB(giocatori,DATABASE_PATH);
		} catch (Exception e) {
			Main.messaggioErrore("Errore aggiunta giocatore");
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void eliminaGiocatore(String g) {
		try {
			giocatori = (HashMap<String,Giocatore>)GestioneFile.caricaDB(DATABASE_PATH);
			giocatori.remove(g);
			GestioneFile.salvaDB(giocatori,DATABASE_PATH);
		} catch (Exception e) {
			Main.messaggioErrore("Errore eliminazione giocatore");
		}
	}
	
}

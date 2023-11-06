package model;

import java.util.HashMap;

import controller.Main;

public class DBPartite {

	public static final String DATABASE_PATH = "log/partiteDatabase.dat";

	private static HashMap<String,Partita> partite;
	
	@SuppressWarnings("unchecked")
	public static boolean esistePartita(String codice) {
		try {
			partite = (HashMap<String,Partita>)GestioneFile.caricaDB(DATABASE_PATH);
			return partite.containsKey(codice);
		} catch (Exception e) {
			return false;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public static Partita getPartita(String codice) {
		try {
			partite = (HashMap<String,Partita>)GestioneFile.caricaDB(DATABASE_PATH);
			return partite.get(codice);
		} catch (Exception e) {
			Main.messaggioErrore("Errore caricamento partita");
		}
		return null;
	}
	
}

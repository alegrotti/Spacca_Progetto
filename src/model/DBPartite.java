package model;

import java.util.HashMap;
import controller.GestoreScene;

public class DBPartite {

	public static final String DATABASE_PATH = "log/partiteDatabase.dat";

	private static HashMap<String,Partita> partite;
	
	public static void aggiornaDB() {
		partite = new HashMap<String,Partita>();
		GestioneFile.salvaDB(partite,DATABASE_PATH);
	}
	
	@SuppressWarnings("unchecked")
	public static HashMap<String,Partita> getPartite(){
		partite = (HashMap<String,Partita>)GestioneFile.caricaDB(DATABASE_PATH);
		return partite;
	}
	
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
			GestoreScene.messaggioErrore("Errore caricamento partita");
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public static void aggiungiPartita(Partita p) {
		try {
			partite = (HashMap<String,Partita>)GestioneFile.caricaDB(DATABASE_PATH);
			partite.put(p.getCodice(),p);
			GestioneFile.salvaDB(partite,DATABASE_PATH);
		} catch (Exception e) {
			GestoreScene.messaggioErrore("Errore aggiunta partita");
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void eliminaPartita(String p) {
		try {
			partite = (HashMap<String,Partita>)GestioneFile.caricaDB(DATABASE_PATH);
			partite.remove(p);
			GestioneFile.salvaDB(partite,DATABASE_PATH);
		} catch (Exception e) {
			GestoreScene.messaggioErrore("Errore aggiunta partita");
		}
	}
	
}

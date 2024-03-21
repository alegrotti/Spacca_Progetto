package model;

import java.util.HashMap;
import controller.GestoreScene;

public class DBTornei {

	public static final String DATABASE_PATH = "log/torneiDatabase.dat";

	private static HashMap<String,Torneo> tornei;
	
	public static void aggiornaDB() {
		tornei = new HashMap<String,Torneo>();
		GestioneFile.salvaDB(tornei,DATABASE_PATH);
	}
	
	@SuppressWarnings("unchecked")
	public static HashMap<String,Torneo> getTornei(){
		tornei = (HashMap<String,Torneo>)GestioneFile.caricaDB(DATABASE_PATH);
		return tornei;
	}
	
	@SuppressWarnings("unchecked")
	public static boolean esisteTorneo(String codice) {
		try {
			tornei = (HashMap<String,Torneo>)GestioneFile.caricaDB(DATABASE_PATH);
			return tornei.containsKey(codice);
		} catch (Exception e) {
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static Torneo getTorneo(String codice) {
		try {
			tornei = (HashMap<String,Torneo>)GestioneFile.caricaDB(DATABASE_PATH);
			return tornei.get(codice);
		} catch (Exception e) {
			GestoreScene.messaggioErrore("Errore caricamento torneo");
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public static void aggiungiTorneo(Torneo t) {
		try {
			tornei = (HashMap<String,Torneo>)GestioneFile.caricaDB(DATABASE_PATH);
			tornei.put(t.getCodice(),t);
			GestioneFile.salvaDB(tornei,DATABASE_PATH);
		} catch (Exception e) {
			GestoreScene.messaggioErrore("Errore aggiunta giocatore");
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void eliminaTorneo(String t) {
		try {
			tornei = (HashMap<String,Torneo>)GestioneFile.caricaDB(DATABASE_PATH);
			tornei.remove(t);
			GestioneFile.salvaDB(tornei,DATABASE_PATH);
		} catch (Exception e) {
			GestoreScene.messaggioErrore("Errore eliminazione torneo");
		}
	}
	
}

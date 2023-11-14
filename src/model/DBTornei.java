package model;

import java.util.HashMap;
import java.util.Set;
import controller.GestoreScene;

public class DBTornei {

	public static final String DATABASE_PATH = "log/torneiDatabase.dat";

	private static HashMap<String,Torneo> tornei;
	
	public static void aggiornaDB() {
		tornei = new HashMap<String,Torneo>();
		GestioneFile.salvaDB(tornei,DATABASE_PATH);
	}
	
	@SuppressWarnings("unchecked")
	public static Set<String> getTornei(){
		tornei = (HashMap<String,Torneo>)GestioneFile.caricaDB(DATABASE_PATH);
		return tornei.keySet();
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
	
}

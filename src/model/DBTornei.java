package model;

import java.util.HashMap;
import java.util.Set;

import controller.Main;

public class DBTornei {

	public static final String DATABASE_PATH = "src/log/torneiDatabase.dat";

	private static HashMap<String,Torneo> tornei;
	
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
			Main.messaggioErrore("Errore aggiunta giocatore");
		}
	}
	
}

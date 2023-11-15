package model;

import java.util.HashMap;
import java.util.Set;
import controller.GestoreScene;

public class DBMazzi {

	public static final String DATABASE_PATH = "log/mazziDatabase.dat";

	private static HashMap<String,Mazzo> mazzi;
	
	public static void aggiornaDB() {
		mazzi = new HashMap<String,Mazzo>();
		GestioneFile.salvaDB(mazzi,DATABASE_PATH);
	}
	
	@SuppressWarnings("unchecked")
	public static Set<String> getMazzi(){
		mazzi = (HashMap<String,Mazzo>)GestioneFile.caricaDB(DATABASE_PATH);
		return mazzi.keySet();
	}
	
	@SuppressWarnings("unchecked")
	public static Mazzo getMazzo(String mazzo) {
		try {
			mazzi = (HashMap<String,Mazzo>)GestioneFile.caricaDB(DATABASE_PATH);
			return mazzi.get(mazzo);
		} catch (Exception e) {
			GestoreScene.messaggioErrore("Errore caricamento mazzo");
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public static void aggiungiMazzo(Mazzo m) {
		try {
			mazzi = (HashMap<String,Mazzo>)GestioneFile.caricaDB(DATABASE_PATH);
			mazzi.put(m.getNome(),m);
			GestioneFile.salvaDB(mazzi,DATABASE_PATH);
		} catch (Exception e) {
			GestoreScene.messaggioErrore("Errore aggiunta mazzo");
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void eliminaMazzo(String m) {
		try {
			mazzi = (HashMap<String,Mazzo>)GestioneFile.caricaDB(DATABASE_PATH);
			mazzi.remove(m);
			GestioneFile.salvaDB(mazzi,DATABASE_PATH);
		} catch (Exception e) {
			GestoreScene.messaggioErrore("Errore eliminazione mazzo");
		}
	}
	
}

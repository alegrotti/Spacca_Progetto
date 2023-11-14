package model;

import java.util.HashMap;
import java.util.Set;
import controller.GestoreScene;

public class DBCarte {

	public static final String DATABASE_PATH = "log/carteDatabase.dat";

	private static HashMap<String,Carta> carte;
	
	public static void aggiornaDB() {
		carte = new HashMap<String,Carta>();
		GestioneFile.salvaDB(carte,DATABASE_PATH);
	}
	
	@SuppressWarnings("unchecked")
	public static Set<String> getCarte(){
		carte = (HashMap<String,Carta>)GestioneFile.caricaDB(DATABASE_PATH);
		return carte.keySet();
	}
	
	@SuppressWarnings("unchecked")
	public static Carta getCarta(String carta) {
		try {
			carte = (HashMap<String,Carta>)GestioneFile.caricaDB(DATABASE_PATH);
			return carte.get(carta);
		} catch (Exception e) {
			GestoreScene.messaggioErrore("Errore caricamento carta");
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public static void aggiungiCarta(Carta c) {
		try {
			carte = (HashMap<String,Carta>)GestioneFile.caricaDB(DATABASE_PATH);
			System.out.println("Lettura file ok");
			carte.put(c.getNome(),c);
			System.out.println("Aggiunta carta");
			GestioneFile.salvaDB(carte,DATABASE_PATH);
			System.out.println("Salvataggio db ok");
		} catch (Exception e) {
			GestoreScene.messaggioErrore("Errore aggiunta carta");
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void eliminaCarta(String c) {
		try {
			carte = (HashMap<String,Carta>)GestioneFile.caricaDB(DATABASE_PATH);
			carte.remove(c);
			GestioneFile.salvaDB(carte,DATABASE_PATH);
		} catch (Exception e) {
			GestoreScene.messaggioErrore("Errore aggiunta carta");
		}
	}
	
}

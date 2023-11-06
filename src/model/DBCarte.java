package model;

import java.util.HashMap;

import controller.Main;

public class DBCarte {

	public static final String DATABASE_PATH = "log/carteDatabase.dat";

	private static HashMap<String,Carta> carte;
	
	@SuppressWarnings("unchecked")
	public static Carta getCarta(String carta) {
		try {
			carte = (HashMap<String,Carta>)GestioneFile.caricaDB(DATABASE_PATH);
			return carte.get(carta);
		} catch (Exception e) {
			Main.messaggioErrore("Errore caricamento carta");
		}
		return null;
	}
	
}

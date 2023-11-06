package model;

import controller.Main;

public class DBAdmin {
	
	public static final String DATABASE_PATH = "log/adminDatabase.dat";

	public static Admin getAdmin() {
		try {
			return (Admin)GestioneFile.caricaDB(DATABASE_PATH);
		}catch(Exception e) {
			Main.messaggioErrore("Impossibile caricare Admin");
		}
		return null;
	}
	
	public static void salvaAdmin (Admin admin) {
		try {
			GestioneFile.salvaDB(admin,DATABASE_PATH);
		}catch(Exception e) {
			Main.messaggioErrore("Impossibile salvare Admin");
		}
	}
	
}

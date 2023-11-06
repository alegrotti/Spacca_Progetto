package model;

public class DBAdmin {
	
	public static final String DATABASE_PATH = "log/adminDatabase.dat";

	public static Admin importaAdmin() {
		return (Admin)GestioneFile.caricaDB(DATABASE_PATH);
	}
	
	public static void salvaAdmin (Admin admin) {
		GestioneFile.salvaDB(admin,DATABASE_PATH);
	}
	
}

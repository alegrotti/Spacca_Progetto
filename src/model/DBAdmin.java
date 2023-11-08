package model;

import java.util.HashMap;

import controller.Main;

public class DBAdmin {
	
	public static final String DATABASE_PATH = "log/adminDatabase.dat";

	private static Admin admin;
	
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
	
	public static void aggiungiGiocatore(Giocatore g) {
		try {
			admin = (Admin)GestioneFile.caricaDB(DATABASE_PATH);
			admin.aggiungiGiocatore(g);
			GestioneFile.salvaDB(admin,DATABASE_PATH);
		}catch(Exception e) {
			Main.messaggioErrore("Impossibile aggiungere mazzo");
		}
	}
	
	public static void aggiungiMazzo(Mazzo m) {
		try {
			admin = (Admin)GestioneFile.caricaDB(DATABASE_PATH);
			admin.aggiungiMazzo(m);
			GestioneFile.salvaDB(admin,DATABASE_PATH);
		}catch(Exception e) {
			Main.messaggioErrore("Impossibile aggiungere mazzo");
		}
	}
	
	public static void aggiungiPartita(Partita p) {
		try {
			admin = (Admin)GestioneFile.caricaDB(DATABASE_PATH);
			admin.aggiungiPartita(p);
			GestioneFile.salvaDB(admin,DATABASE_PATH);
		}catch(Exception e) {
			Main.messaggioErrore("Impossibile aggiungere partita");
		}
	}
	
	public static void eliminaGiocatore(String g) {
		try {
			admin = (Admin)GestioneFile.caricaDB(DATABASE_PATH);
			admin.eliminaGiocatore(g);
			GestioneFile.salvaDB(admin,DATABASE_PATH);
		} catch (Exception e) {
			Main.messaggioErrore("Errore eliminazione giocatore");
		}
	}
	
	public static void eliminaMazzo(String m) {
		try {
			admin = (Admin)GestioneFile.caricaDB(DATABASE_PATH);
			admin.eliminaMazzo(m);
			GestioneFile.salvaDB(admin,DATABASE_PATH);
		} catch (Exception e) {
			Main.messaggioErrore("Errore eliminazione giocatore");
		}
	}
	
	public static void setPassword(String password) {
		try {
			admin = (Admin)GestioneFile.caricaDB(DATABASE_PATH);
			admin.setPassword(password);
			GestioneFile.salvaDB(admin,DATABASE_PATH);
		} catch (Exception e) {
			Main.messaggioErrore("Errore eliminazione giocatore");
		}
	}
	
	public static void setUsername(String username) {
		try {
			admin = (Admin)GestioneFile.caricaDB(DATABASE_PATH);
			admin.setUsername(username);
			GestioneFile.salvaDB(admin,DATABASE_PATH);
		} catch (Exception e) {
			Main.messaggioErrore("Errore eliminazione giocatore");
		}
	}
	
}

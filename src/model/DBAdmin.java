package model;

import java.util.HashMap;
import java.util.HashSet;

import controller.GestoreScene;

public class DBAdmin {
	
	public static final String DATABASE_PATH = "log/adminDatabase.dat";

	private static Admin admin;
	
	public static void aggiornaDB() {
		admin = new Admin("","");
		GestioneFile.salvaDB(admin,DATABASE_PATH);
	}
	
	public static void creaAdmin() {
		try {
			admin = (Admin)GestioneFile.caricaDB(DATABASE_PATH);

			HashSet<String> carte = new HashSet<String>();
			for(String s : DBCarte.getCarte())
				carte.add(s);
			
			HashSet<String> mazzi = new HashSet<String>();
			for(String s : DBMazzi.getMazzi())
				mazzi.add(s);
			
			HashSet<String> partite = new HashSet<String>();
			HashMap<String,Partita> p = DBPartite.getPartite();
			for(String s : p.keySet())
				partite.add(s);
			
			HashSet<String> giocatori = new HashSet<String>();
			for(String s : DBGiocatori.getGiocatori())
				giocatori.add(s);
			
			HashSet<String> tornei = new HashSet<String>();
			HashMap<String,Torneo> t = DBTornei.getTornei();
			for(String s : t.keySet())
				tornei.add(s);

			admin.inizializzaAdmin(carte,mazzi,giocatori,partite,tornei);

			GestioneFile.salvaDB(admin,DATABASE_PATH);
		}catch(Exception e) {
			GestoreScene.messaggioErrore("Errore caricamento admin");
		}
	}
	
	public static Admin getAdmin() {
		try {
			return (Admin)GestioneFile.caricaDB(DATABASE_PATH);
		}catch(Exception e) {
			GestoreScene.messaggioErrore("Impossibile caricare Admin");
		}
		return null;
	}
	
	public static void salvaAdmin (Admin admin) {
		try {
			GestioneFile.salvaDB(admin,DATABASE_PATH);
		}catch(Exception e) {
			GestoreScene.messaggioErrore("Impossibile salvare Admin");
		}
	}
	
	public static void aggiungiGiocatore(Giocatore g) {
		try {
			admin = (Admin)GestioneFile.caricaDB(DATABASE_PATH);
			admin.aggiungiGiocatore(g);
			GestioneFile.salvaDB(admin,DATABASE_PATH);
		}catch(Exception e) {
			GestoreScene.messaggioErrore("Impossibile aggiungere mazzo");
		}
	}
	
	public static void aggiungiMazzo(Mazzo m) {
		try {
			admin = (Admin)GestioneFile.caricaDB(DATABASE_PATH);
			admin.aggiungiMazzo(m);
			GestioneFile.salvaDB(admin,DATABASE_PATH);
		}catch(Exception e) {
			GestoreScene.messaggioErrore("Impossibile aggiungere mazzo");
		}
	}
	
	public static void aggiungiPartita(Partita p) {
		try {
			admin = (Admin)GestioneFile.caricaDB(DATABASE_PATH);
			admin.aggiungiPartita(p);
			GestioneFile.salvaDB(admin,DATABASE_PATH);
		}catch(Exception e) {
			GestoreScene.messaggioErrore("Impossibile aggiungere partita");
		}
	}
	
	public static void aggiungiTorneo(Torneo t) {
		try {
			admin = (Admin)GestioneFile.caricaDB(DATABASE_PATH);
			admin.aggiungiTorneo(t);
			GestioneFile.salvaDB(admin,DATABASE_PATH);
		}catch(Exception e) {
			GestoreScene.messaggioErrore("Impossibile aggiungere torneo");
		}
	}
	
	public static void eliminaGiocatore(String g) {
		try {
			admin = (Admin)GestioneFile.caricaDB(DATABASE_PATH);
			admin.eliminaGiocatore(g);
			GestioneFile.salvaDB(admin,DATABASE_PATH);
		} catch (Exception e) {
			GestoreScene.messaggioErrore("Errore eliminazione giocatore");
		}
	}
	
	public static void eliminaMazzo(String m) {
		try {
			admin = (Admin)GestioneFile.caricaDB(DATABASE_PATH);
			admin.eliminaMazzo(m);
			GestioneFile.salvaDB(admin,DATABASE_PATH);
		} catch (Exception e) {
			GestoreScene.messaggioErrore("Errore eliminazione mazzo");
		}
	}
	
	public static void eliminaPartita(String p) {
		try {
			admin = (Admin)GestioneFile.caricaDB(DATABASE_PATH);
			admin.eliminaPartita(p);
			GestioneFile.salvaDB(admin,DATABASE_PATH);
		} catch (Exception e) {
			GestoreScene.messaggioErrore("Errore eliminazione partita");
		}
	}
	
	public static void eliminaTorneo(String t) {
		try {
			admin = (Admin)GestioneFile.caricaDB(DATABASE_PATH);
			admin.eliminaTorneo(t);
			GestioneFile.salvaDB(admin,DATABASE_PATH);
		} catch (Exception e) {
			GestoreScene.messaggioErrore("Errore eliminazione torneo");
		}
	}
	
	public static void setPassword(String password) {
		try {
			admin = (Admin)GestioneFile.caricaDB(DATABASE_PATH);
			admin.setPassword(password);
			GestioneFile.salvaDB(admin,DATABASE_PATH);
		} catch (Exception e) {
			GestoreScene.messaggioErrore("Errore modifica password");
		}
	}
	
	public static void setUsername(String username) {
		try {
			admin = (Admin)GestioneFile.caricaDB(DATABASE_PATH);
			admin.setUsername(username);
			GestioneFile.salvaDB(admin,DATABASE_PATH);
		} catch (Exception e) {
			GestoreScene.messaggioErrore("Errore modifica username");
		}
	}
	
	public static String getPassword() {
		try {
			admin = (Admin)GestioneFile.caricaDB(DATABASE_PATH);
			return admin.getPassword();
		} catch (Exception e) {
			GestoreScene.messaggioErrore("Errore eliminazione giocatore");
			return null;
		}
	}
	
	public static String getUsername() {
		try {
			admin = (Admin)GestioneFile.caricaDB(DATABASE_PATH);
			return admin.getUsername();
		} catch (Exception e) {
			GestoreScene.messaggioErrore("Errore eliminazione giocatore");
			return null;
		}
	}
	
}

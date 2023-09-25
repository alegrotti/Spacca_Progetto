package model;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GestoreFile {
	
	public static final String DATABASE_PATH = "log/adminDatabase.dat";

	public Admin importaAdmin() {
		try {
			FileInputStream f = new FileInputStream(GestoreFile.DATABASE_PATH);
			ObjectInputStream inputStream =	new ObjectInputStream(f);
			Admin database = (Admin)inputStream.readObject();
			inputStream.close();
			return database;
		} catch(EOFException e) {
			System.out.println("Lettura finita");
		} catch (FileNotFoundException e) {
			System.out.println("Il file "+GestoreFile.DATABASE_PATH+" non esiste!");			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void salvaAdmin (Admin admin) {
		String nomeFile = DATABASE_PATH;
		ObjectOutputStream outputStream = null;	
		try {
			outputStream = new ObjectOutputStream(new FileOutputStream(nomeFile));
			try {
				outputStream.writeObject(admin);
				outputStream.close();
			} catch (Exception e) {
				System.out.println("errore scrittura su file");
			}
		} catch (Exception e) {
			System.out.println("errore apertura file");
		}
	}
	
	public void salvaPartita (Partita partita) {
		
	}
	
}

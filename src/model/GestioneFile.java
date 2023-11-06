package model;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GestioneFile {

	public static Object caricaDB (String DATABASE_PATH) {
		try {
			FileInputStream f = new FileInputStream(DATABASE_PATH);
			ObjectInputStream inputStream =	new ObjectInputStream(f);
			Object database = (Object)inputStream.readObject();
			inputStream.close();
			return database;
		} catch(EOFException e) {
			System.out.println("Lettura finita");
		} catch (FileNotFoundException e) {
			System.out.println("Il file "+DATABASE_PATH+" non esiste!");			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void salvaDB (Object o,String nomeFile) {
		ObjectOutputStream outputStream = null;	
		try {
			outputStream = new ObjectOutputStream(new FileOutputStream(nomeFile));
			try {
				outputStream.writeObject(o);
				outputStream.close();
			} catch (Exception e) {
				System.out.println("errore scrittura su file");
			}
		} catch (Exception e) {
			System.out.println("errore apertura file");
		}	
	}
	
}

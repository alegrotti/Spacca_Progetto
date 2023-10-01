package model;

import java.awt.Color;
import java.io.Serializable;

public class Special extends Carta implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private boolean specialType;

	public Special(String nome, String descrizione, int valore, int resi, int comm, int pubb, int cult, boolean specialType) {
		super(nome, descrizione, assegnaColore(specialType), resi, comm, pubb, cult);
		this.specialType = specialType;
	}
	
	private static Color assegnaColore(boolean specialType) {
		
		return Color.white;
	}
}

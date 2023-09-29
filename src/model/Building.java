package model;

import java.io.Serializable;
import java.awt.Color;

public class Building extends Carta implements Serializable{
	
	private static final long serialVersionUID = 1L;

	int valore;
	int resi;
	int comm;
	int pubb;
	int cult;
	String percorsoIcona;
	Gruppo group;
	
	public Building(String nome, String descrizione, int valore, int resi, int comm, int pubb, int cult, Gruppo group,String percorsoIcona) {
		super(nome, descrizione, assegnaColore(group));
		this.valore = valore;
		this.resi = resi;
		this.comm = comm;
		this.pubb = pubb;
		this.cult = cult; 
		this.group = group;
		this.percorsoIcona = percorsoIcona;
	}

	private static Color assegnaColore(Gruppo g) {
		
		return Color.white;
	}
	
}

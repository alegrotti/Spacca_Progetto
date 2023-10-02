package model;

import java.io.Serializable;
import java.awt.Color;

public class Building extends Carta implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int punteggio;
	String percorsoIcona;
	Gruppo group;
	
	public Building(String nome, String descrizione, int resi, int comm, int pubb, int cult, Gruppo group,String percorsoIcona) {
		super(nome, descrizione, assegnaColore(group), resi, comm, pubb, cult);
		this.punteggio = assegnaPunteggio(resi, comm, pubb, cult); 
		this.group = group;
		this.percorsoIcona = percorsoIcona;
	}

	private static Color assegnaColore(Gruppo g) {
		
		return Color.white;
		
	}
	
	private static int assegnaPunteggio(int resi, int comm, int pubb, int cult) {
		int x = 0;
		
		return x;
	}
	
	public int getPunteggio() {
		return punteggio;
	}
	
	public String getNome() {
		return super.getNome();
	}
	
}

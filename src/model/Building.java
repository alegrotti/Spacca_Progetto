package model;

import java.io.Serializable;
import java.awt.Color;

public class Building extends Carta implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int punteggio;
	Gruppo group;
	
	public Building(String nome, String descrizione, int resi, int comm, int pubb, int cult, String percorsoIcona,String genere) {
		super(nome, descrizione, assegnaColore(genere), resi, comm, pubb, cult, percorsoIcona,genere);
		this.punteggio = assegnaPunteggio(resi, comm, pubb, cult);
	}

	private static Color assegnaColore(String g) {
		
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
	
	public String getPercorso() {
		return super.getPercorso();
	}
	
}

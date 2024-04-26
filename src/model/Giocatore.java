package model;

import java.io.Serializable;

public class Giocatore implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String nome;
	private int partiteGiocate;
	private int torneiGiocati;
	private int partiteVinte;
	private int torneiVinti;
	private int puntiPartite;
	private int puntiTornei;
	private int puntiTotali;
	
	public Giocatore(String nome) {
		this.nome = nome;
		this.partiteGiocate = 0;
		this.torneiGiocati = 0;
		this.partiteVinte = 0;
		this.torneiVinti = 0;
		this.puntiPartite = 0;
		this.puntiTornei = 0;
		this.puntiTotali = 0;
	}
		
	public int getPartiteGiocate() {
		return partiteGiocate;
	}

	public int getTorneiGiocati() {
		return torneiGiocati;
	}
	
	public int getPartiteVinte() {
		return partiteVinte;
	}

	public int getTorneiVinti() {
		return torneiVinti;
	}

	public int getPuntiPartite() {
		return puntiPartite;
	}

	public int getPuntiTornei() {
		return puntiTornei;
	}

	public int getPuntiTotali() {
		return puntiTotali;
	}

	public String getUsername() {
		return nome;
	}

  
}

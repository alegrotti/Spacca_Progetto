package model;

import java.io.Serializable;

public class Giocatore implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String username;
	private Integer partiteGiocate;
	private Integer torneiGiocati;
	private Integer partiteVinte;
	private Integer torneiVinti;
	private Integer puntiPartite;
	private Integer puntiTornei;
	private Integer puntiTotali;
	
	public Giocatore(String nome) {
		this.username = nome;
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
		return username;
	}

  
}

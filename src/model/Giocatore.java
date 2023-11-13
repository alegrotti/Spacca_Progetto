package model;

import java.io.Serializable;
import java.util.HashMap;

public class Giocatore implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String nome;
	private int crediti;
	private HashMap <String,int[]> partiteGiocate;
	private HashMap <String,int[]> torneiGiocati;
	
	public Giocatore(String nome) {
		this.nome = nome;
		this.crediti = 0;
		partiteGiocate = new HashMap<String,int[]>();
	}
	
	public String getUsername() {
		return nome;
	}
	
	public int getCrediti() {
		return crediti;
	}

	public int[] getInfoPartita(String s) {
		return partiteGiocate.get(s);
	}
	
	public int[] getInfoTorneo(String s) {
		return torneiGiocati.get(s);
	}
  
}

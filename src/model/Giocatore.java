package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Giocatore implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String nome;
	private ArrayList<Carta> mano;
	private int crediti;
	private City citta;
	private HashMap <String,int[]> partiteGiocate;
	
	public Giocatore(String nome) {
		this.nome = nome;
		this.mano = new ArrayList<Carta>();
		this.crediti = 0;
		this.citta = new City();
		partiteGiocate = new HashMap<String,int[]>();
	}
	
	public String getUsername() {
		return nome;
	}
	
	public int getCrediti() {
		return crediti;
  }
	public City getCity() {
		return citta;
	}
  
}

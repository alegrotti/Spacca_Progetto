package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Giocatore implements Serializable{
	
	private static final long serialVersionUID = 1L;

	String nome;
	ArrayList<Carta> mano;
	int crediti;
	City citta;
	
	public Giocatore(String nome) {
		this.nome = nome;
		this.mano = new ArrayList<Carta>();
		this.crediti = 0;
		this.citta = new City();
	}
	
	public String getUsername() {
		return nome;
	}
	
	public int getCrediti() {
		return crediti;
	}
}

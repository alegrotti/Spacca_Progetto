package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Mazzo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Carta> carte;
	private String nome;
	
	public Mazzo() {
		carte = new ArrayList<>();
		nome = "";
	}
	
	public Mazzo(String nome, ArrayList<Carta> carte) {
		this.carte = carte;
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public ArrayList<Carta> getCarte(){
		return carte;
	}
	
	public void mix() {
		Collections.shuffle(carte);
	}
	
	public void rimuoviCarta(Carta s) {
		for(Carta x : carte) {
			if(x.getNome().equals(s.getNome())) {
				carte.remove(x);
				break;
			}
		}
	}
	
}

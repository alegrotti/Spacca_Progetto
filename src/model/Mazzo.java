package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Mazzo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Carta> carte;
	private String nome;
	
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
	
}

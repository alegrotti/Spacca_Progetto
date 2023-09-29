package model;

import java.awt.Color;
import java.io.Serializable;

public class Carta implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String nome;
	private String descrizione;
	private Color color;
	
	public Carta(String nome, String descrizione, Color color) {
		this.nome = nome;
		this.descrizione = descrizione;
		this.color = color;
	}
	
}

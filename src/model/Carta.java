package model;

import java.awt.Color;
import java.io.Serializable;

public class Carta implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String nome;
	private String descrizione;
	private Color color;
	private int resi;
	private int comm;
	private int pubb;
	private int cult;
	
	public Carta(String nome, String descrizione, Color color,int resi, int comm, int pubb, int cult) {
		this.resi = resi;
		this.comm = comm;
		this.pubb = pubb;
		this.cult = cult;
		this.nome = nome;
		this.descrizione = descrizione;
		this.color = color;
	}
	
}

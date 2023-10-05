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
	private String percorsoIcona;
	private String genere;
	
	public Carta(String nome, String descrizione, Color color,int resi, int comm, int pubb, int cult, String percorsoIcona, String genere) {
		this.resi = resi;
		this.comm = comm;
		this.pubb = pubb;
		this.cult = cult;
		this.nome = nome;
		this.descrizione = descrizione;
		this.color = color;
		this.percorsoIcona = percorsoIcona;
		this.genere = genere;
	}
	
	public Carta() {
		this.resi = 0;
		this.comm = 0;
		this.pubb = 0;
		this.cult = 0;
		this.nome = null;
		this.descrizione = null;
		this.color = null;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	public int getResidenziale() {
		return resi;
	}
	
	public int getCommerciale() {
		return comm;
	}
	
	public int getPubblico() {
		return pubb;
	}
	
	public int getCulturale() {
		return cult;
	}
	
	public String getPercorso() {
		return percorsoIcona;
	}

	public Color getColor() {
		return color;
	}
	
	public String getGenere() {
		return genere;
	}
	
}

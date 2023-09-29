package model;

import java.awt.Color;
import java.io.Serializable;

public class Special extends Carta implements Serializable{
	
	private static final long serialVersionUID = 1L;

	String sType;
	int resi;
	int comm;
	int pubb;
	int cult;

	public Special(String nome, String descrizione, Color color) {
		super(nome, descrizione, color);
	}
}

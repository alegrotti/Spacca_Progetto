package model;

import java.awt.Color;
import java.io.Serializable;

public class Building extends Carta implements Serializable{
	
	private static final long serialVersionUID = 1L;

	int valore;
	int resi;
	int comm;
	int publ;
	int cult;
	Color colour;
	Gruppo group;

}

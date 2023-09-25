package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Partita implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Mazzo mazzo;
	private int turno;
	private HashMap<Integer,Giocatore> postazioni;
	private String codice;
	
	
	public Partita(Mazzo mazzo, ArrayList<Giocatore> giocatori, String codice) {
		this.mazzo = mazzo;
		for(int i = 0 ; i < giocatori.size() ; i++)
			postazioni.put(i, giocatori.get(i));
		this.codice = codice;
		this.turno = 0;
			
	}
	
}

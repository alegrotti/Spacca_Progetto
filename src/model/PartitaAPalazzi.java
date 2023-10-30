package model;

import java.io.Serializable;
import java.util.ArrayList;

public class PartitaAPalazzi extends Partita implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int palazzi;

	public PartitaAPalazzi(Mazzo mazzo, ArrayList<Giocatore> giocatori, String codice, int palazzi) {
		super(mazzo, giocatori, codice);
		this.setPalazzi(palazzi);
	}

	public int getPalazzi() {
		return palazzi;
	}

	public void setPalazzi(int palazzi) {
		this.palazzi = palazzi;
	}
}

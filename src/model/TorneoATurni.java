package model;

import java.io.Serializable;
import java.util.ArrayList;

class TorneoATurni extends Torneo implements Serializable {
	private static final long serialVersionUID = 1L;
		
		private int turni;
	
		public TorneoATurni(Mazzo mazzo, ArrayList<String> giocatori, String codice, int turni, int creditiIniziali) {
			super(mazzo, giocatori, codice, creditiIniziali);
			this.setTurni(turni);
		}
	
		public int getTurni() {
			return turni;
		}
	
		public void setTurni(int turni) {
			this.turni = turni;
		}
}

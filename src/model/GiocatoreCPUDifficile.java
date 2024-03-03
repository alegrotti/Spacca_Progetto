package model;

import java.io.Serializable;
import java.util.ArrayList;

public class GiocatoreCPUDifficile extends Giocatore implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public GiocatoreCPUDifficile (String username){
		super(username);
	}
	
	public int giocaTurno(Partita p, String g) {
		City city = new City(g);
    	
    	for(int i = 0; i<p.getMano(g).length ; i++)
    		city.aggiungiCarta(p.getMano(g)[i]);
    	
    	for(int i = 0; i<p.getMano()+1 ; i++) {
    		city.aggiungiCarta(p.getCarteTavolo()[i]);
    	}
		
    	
    	
		
		return 1000;
	}
	
	public String getUsername() {
		return super.getUsername();
	}
	
	public boolean partecipa(int crediti, int puntata) {
		double x = crediti/puntata;
		if(x>1.5)
			return true;
		else
			return false;
	}
	
	public String scegliCarta(City c, ArrayList<String> carte) {
		String nome = "";
		
		int max = 0;
		
		for(String s : carte) {
			City c1 = c;
			Carta y = DBCarte.getCarta(s);
			c1.aggiungiCarta(y);
			if(c1.getPunteggio()>max) {
				max = c1.getPunteggio();
				nome = s;
			}
		}
		
		return nome;
	}
	
}

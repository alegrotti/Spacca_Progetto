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
		
    	int p5 = 110;
    	int p6 = 125;
    	int p7 = 140;
    	
    	int pMax = 0;
    	double percPuntata = 0;
    	
    	if(city.getCarte().size() == 5) {
    		pMax = p5;
			percPuntata = 0.3;
    	}else if(city.getCarte().size() == 6) {
			pMax = p6;
			percPuntata = 0.6;
    	}else if(city.getCarte().size() == 7) {
			pMax = p7;
			percPuntata = 1;
    	}
    	
    	double w = (city.getPunteggio()/(double)pMax)*percPuntata;
    	
    	int puntata = (int)(p.getCrediti(g)*w);
		
    	return puntata;
	}
	
	public String getUsername() {
		return super.getUsername();
	}
	
	public boolean partecipa(Partita p , String g) {
		int pp = p.getPuntata();
		
		int pg = giocaTurno(p,g);
		
		int dp = pp - pg;
		
		double w1 = dp / pg;
		
		City c = p.getCittadina(g);
		
		if(c.getCarte().size() == 5)
			if(w1<=0.2)
				return true;
			else 
				return false;
    	else if(c.getCarte().size() == 6)
    		if(w1<=0.3)
				return true;
			else 
				return false;
    	else
    		if(w1<=0.4)
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
			c1.rimuoviCarta(y);
			
		}
		
		return nome;
	}
	
}

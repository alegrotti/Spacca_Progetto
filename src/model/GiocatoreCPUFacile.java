package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class GiocatoreCPUFacile extends Giocatore implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public GiocatoreCPUFacile (String username){
		super(username);
	}
	
	public int giocaTurno(Partita p, String g) {
		
		if(p.getCrediti(g)>0) {
    		Random rand = new Random();
    		return rand.nextInt(p.getCrediti(g)) + 1;
    	}
    	else return 0;
	}
	
	public String getUsername() {
		return super.getUsername();
	}
	
	public boolean partecipa(Partita p , String g) {
		Random rand = new Random();
		int scelta = rand.nextInt(2);
		if(scelta == 0)
			return true;
		else 
			return false;
		
	}
	
	public String scegliCarta(City c, ArrayList<String> carte) {
		String nome = "";
	    
		if (carte.isEmpty()) {
	        return nome;
	    }
	    
	    Random rand = new Random();
	    int randomIndex = rand.nextInt(carte.size()); 
	    
	    nome = carte.get(randomIndex); 
	    
	    return nome;
	}
	
}
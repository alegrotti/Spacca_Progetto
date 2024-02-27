package model;

import java.io.Serializable;

public class GiocatoreCPUDifficile extends Giocatore implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private boolean partecipa;
	
	public GiocatoreCPUDifficile (String username){
		super(username);
		partecipa = true;
	}
	
	public int giocaTurno() {
		
		partecipa = true;
		return 1000;
		
	}
	
	public String getUsername() {
		return super.getUsername();
	}
	
	public boolean partecipa() {
		return partecipa;
	}
	
}

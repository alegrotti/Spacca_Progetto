package model;

import java.io.Serializable;

public class GiocatoreCPUDifficile extends Giocatore implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public GiocatoreCPUDifficile (String username){
		super(username);
	}
	
	public int giocaTurno() {
		return 1000;
	}
	
	public String getUsername() {
		return super.getUsername();
	}
	
	public boolean partecipa() {
		return false;
	}
	
}

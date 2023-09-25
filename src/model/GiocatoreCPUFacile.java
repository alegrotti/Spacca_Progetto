package model;

import java.io.Serializable;

public class GiocatoreCPUFacile extends Giocatore implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public GiocatoreCPUFacile (String username){
		super(username);
	}
	
	public String getUsername() {
		return super.getUsername();
	}
	
}

package model;

import java.io.Serializable;

public class GiocatoreFisico extends Giocatore implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public GiocatoreFisico (String username){
		super(username);
	}
	
	public String getUsername() {
		return super.getUsername();
	}
	
}

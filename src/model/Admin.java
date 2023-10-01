package model;

import java.io.Serializable;
import java.util.HashMap;

public class Admin implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String password;
	private String username;
	private HashMap <String,Mazzo> mazzi;
	private HashMap <String,Carta> carte;
	private HashMap <String,Giocatore> giocatori;
	private HashMap <String,Partita> partite;
	private HashMap <String,Torneo> tornei;
	
	public Admin(String username,String password) {
		this.password = password;
		this.username = username;
		this.giocatori = new HashMap <String,Giocatore>();
		this.partite = new HashMap <String,Partita>();
		this.tornei = new HashMap <String,Torneo>();
		this.mazzi = new HashMap <String,Mazzo>();
		this.carte = new HashMap <String,Carta>();
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public HashMap <String,Partita> getPartite(){
		return partite;
	}
	
	public HashMap <String,Torneo> getTornei(){
		return tornei;
	}
	
	public HashMap <String,Giocatore> getGiocatori(){
		return giocatori;
	}
	
	public HashMap<String, Mazzo> getMazzi(){
		return mazzi;
	}
	
	public HashMap<String, Carta> getCarte(){
		return carte;
	}
	
	public void aggiungiGiocatore(Giocatore g) {
		giocatori.put(g.getUsername(),g);
	}
	
	public void eliminaGiocatore(String g) {
		giocatori.remove(g);
	}
	
	public Giocatore getGiocatore(String s) {
		return giocatori.get(s);
	}
	
}

package model;

import java.io.Serializable;
import java.util.HashSet;

public class Admin implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String password;
	private String username;
	private HashSet <String> mazzi;
	private HashSet <String> carte;
	private HashSet <String> giocatori;
	private HashSet <String> partite;
	private HashSet <String> tornei;
	
	public Admin(String username,String password) {
		this.password = password;
		this.username = username;
		this.giocatori = new HashSet <String>();
		this.mazzi = new HashSet <String>();
		this.carte = new HashSet <String>();
		this.partite = new HashSet <String>();
		this.tornei = new HashSet <String>();
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
	
	public HashSet <String> getPartite(){
		return partite;
	}
	
	public HashSet <String> getTornei(){
		return tornei;
	}
	
	public HashSet <String> getGiocatori(){
		return giocatori;
	}
	
	public HashSet <String> getMazzi(){
		return mazzi;
	}
	
	public HashSet <String> getCarte(){
		return carte;
	}
	
	public void aggiungiGiocatore(Giocatore g) {
		giocatori.add(g.getUsername());
	}
	
	public void aggiungiCarta(Carta c) {
		carte.add(c.getNome());
		DBAdmin.salvaAdmin(this);
	}
	
	public void aggiungiMazzo(Mazzo m) {
		mazzi.add(m.getNome());
	}
	
	public void aggiungiPartita(Partita p) {
		partite.add(p.getCodice());
	}
	
	public void eliminaGiocatore(String g) {
		giocatori.remove(g);
	}
	
	public void eliminaCarta(String c) {
		carte.remove(c);
		DBAdmin.salvaAdmin(this);
	}
	
	public void eliminaMazzo(String m) {
		mazzi.remove(m);
	}
	
	public void eliminaPartita(String p) {
		partite.remove(p);
	}
	
	public void inizializzaAdmin(HashSet<String> carte,HashSet<String> mazzi, HashSet<String> giocatori, HashSet<String> partite, HashSet<String> tornei){
		this.giocatori = giocatori;
		this.mazzi = mazzi;
		this.carte = carte;
		this.partite = partite;
		this.tornei = tornei;
	}

}

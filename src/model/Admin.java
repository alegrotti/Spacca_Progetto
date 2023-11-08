package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Admin implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String password;
	private String username;
	private List <String> mazzi;
	private List <String> carte;
	private List <String> giocatori;
	private List <String> partite;
	private List <String> tornei;
	
	public Admin(String username,String password) {
		this.password = password;
		this.username = username;
		this.giocatori = new ArrayList <String>();
		this.mazzi = new ArrayList <String>();
		this.carte = new ArrayList <String>();
		this.partite = new ArrayList <String>();
		this.tornei = new ArrayList <String>();
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
	
	public List <String> getPartite(){
		return partite;
	}
	
	public List <String> getTornei(){
		return tornei;
	}
	
	public List <String> getGiocatori(){
		return giocatori;
	}
	
	public List <String> getMazzi(){
		return mazzi;
	}
	
	public List <String> getCarte(){
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
		mazzi.add(p.getCodice());
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
	
}

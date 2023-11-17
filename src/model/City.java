package model;

import java.io.Serializable;
import java.util.ArrayList;

public class City implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private ArrayList<Carta> carte;
	private int punteggio;
	private String nome;
	private double residenziale;
	private double commerciale;
	private double pubblico;
	private double culturale;
	
	public City(String nome) {
		this.nome = nome;
		carte = new ArrayList<Carta>();
		punteggio = 0;
		residenziale = 0;
		commerciale = 0;
		pubblico = 0;
		culturale = 0;
	}
	
	public void aggiungiCarta(Carta carta) {
		carte.add(carta);

		residenziale=0;
		commerciale=0;
		pubblico=0;
		culturale=0;
		
		for(Carta c : carte)
			if(c instanceof Building) {
				residenziale+=c.getResidenziale();
				commerciale+=c.getCommerciale();
				pubblico+=c.getPubblico();
				culturale+=c.getCulturale();
			}
		
		residenziale/=carte.size();
		commerciale/=carte.size();
		pubblico/=carte.size();
		culturale/=carte.size();
		
		for(Carta c : carte)
			if(c instanceof Special) {
				residenziale+=c.getResidenziale();
				commerciale+=c.getCommerciale();
				pubblico+=c.getPubblico();
				culturale+=c.getCulturale();
			}
		
	}
	
	public ArrayList<Carta> getCarte() {
		return carte;
	}

	public int getPunteggio() {
		return punteggio;
	}

	public String getNome() {
		return nome;
	}

	public double getResidenziale() {
		return residenziale;
	}

	public double getCommerciale() {
		return commerciale;
	}

	public double getPubblico() {
		return pubblico;
	}

	public double getCulturale() {
		return culturale;
	}
	
}

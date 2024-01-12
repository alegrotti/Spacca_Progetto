package model;

import java.io.Serializable;
import java.util.ArrayList;

public class City implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private ArrayList<Carta> carte;
	private int punteggio;
	private String nome;
	private int re;
	private int co;
	private int pu;
	private int cu;
	
	public City(String nome) {
		this.nome = nome;
		carte = new ArrayList<Carta>();
		punteggio = 0;
		re = 0;
		co = 0;
		pu = 0;
		cu = 0;
	}
	
	public void aggiungiCarta(Carta carta) {
		carte.add(carta);

		re=0;
		co=0;
		pu=0;
		cu=0;
		
		for(Carta c : carte)
			if(c instanceof Building) {
				re+=c.getResidenziale();
				co+=c.getCommerciale();
				pu+=c.getPubblico();
				cu+=c.getCulturale();
			}
		
		re=(int)(re/carte.size());
		co=(int)(co/carte.size());
		pu = (int)(pu/carte.size());
		cu = (int)(cu/carte.size());
		
		for(Carta c : carte)
			if(c instanceof Special) {
				re+=c.getResidenziale();
				co+=c.getCommerciale();
				pu+=c.getPubblico();
				cu+=c.getCulturale();
			}
		
		calcolaPunteggio();
	}
	
	public void calcolaPunteggio() {
		
		punteggio = (int)((5/2)*(re+cu+pu+co));
		punteggio += carte.size()*3;
		
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

	public int getResidenziale() {
		return re;
	}

	public int getCommerciale() {
		return co;
	}

	public int getPubblico() {
		return pu;
	}

	public int getCulturale() {
		return cu;
	}
	
}

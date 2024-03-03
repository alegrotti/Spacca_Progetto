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
		
		//bonus palazzi
		punteggio += carte.size()*3;
		
		//bonus tipi
		int n = getNGenere();
		
		switch (n) {
			case 1 :
				punteggio -= 5;
			case 2 : 
				punteggio += 10;
				break;
			case 3 : 
				punteggio += 20;
				break;
			case 4 :
				punteggio += 30;
				break;
			default:
				break;
		}
		
		
		
	}
	
	public int getNGenere() {
		int[] n = new int[4];
		for(Carta c : carte)
			switch(c.getGenere()) {
				
				case "Residenziale":
					n[0]++;
					break;
				case "Commerciale":
					n[1]++;
					break;
				case "Pubblico":
					n[2]++;
					break;
				case "commerciale":
					n[3]++;
					break;
			}
		int N = 0;
		for(int x : n)
			if(x!=0)
				N++;
		
		return N;
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
	
	public String toString() {
		return "Nome : "+nome+
			   "Carte : "+carte.size()+
			   "Punteggio : "+punteggio;
	}
	
	public City compareTo(City c) {
		if (c == null)
			return this;
		else if (getPunteggio()>c.getPunteggio())
			return this;
		else if(getPunteggio()>c.getPunteggio())
			return c;
		else {
			int nc=0;
			int nthis=0;
			int bc=0;
			int bthis=0;
			for(Carta carta : c.getCarte())
				if(carta instanceof Building)
					nc++;
				else if(carta.getGenere().equals("Bonus"))
					bc++;
				else
					bc--;
			for(Carta carta : this.getCarte())
				if(carta instanceof Building)
					nthis++;
				else if(carta.getGenere().equals("Bonus"))
					bthis++;
				else
					bthis--;
			if(nc>nthis)
				return c;
			else if(nc<nthis)
				return this;
			else {
				if(bc>bthis)
					return c;
				else if(bc<bthis)
					return this;
				else {
					int n = (int)(Math.random()*2);
					if(n>0)
						return c;
					else
						return this;
				}
			}
		}
			
	}
}

package model;

import java.awt.Color;
import java.io.Serializable;

public class Special extends Carta implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private boolean tipo;

	public Special(String nome, String descrizione, int resi, int comm, int pubb, int cult, boolean tipo,String percorsoIcona,String genere) {
		super(nome, descrizione, assegnaColore(tipo), resi, comm, pubb, cult,percorsoIcona,genere);
		this.setTipo(tipo);
	}
	
	private static Color assegnaColore(boolean specialType) {
		
		return Color.white;
	}
	
	public String getNome() {
		return super.getNome();
	}

	public boolean getTipo() {
		return tipo;
	}

	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}
}

package controller;

import javafx.fxml.FXML;
import model.Giocatore;
import model.Partita;

public class CampoGiocoController {
	
	private Partita partita;
	
	private Giocatore giocatore;
	
	public boolean impostaPartita(Partita p) {
		try {
			partita = p;
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
    @FXML
    void initialize() {
    	
    }

}

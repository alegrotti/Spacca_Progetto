package controller;

import javafx.fxml.FXML;
import model.Partita;

public class CampoGiocoController {
	
	@SuppressWarnings("unused")
	private Partita partita;
	
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

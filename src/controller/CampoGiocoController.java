package controller;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import model.Partita;

public class CampoGiocoController {
	
	private Partita partita;
	
	@FXML
    private Pane sfondo;
	
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

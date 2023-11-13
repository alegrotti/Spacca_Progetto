package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.City;

public class MostraCittadinaController {

	private City città;
	
    @FXML
    private Pagination carteCittà;

    @FXML
    private VBox centralBox;

    @FXML
    private Label punteggiVariCittà;

    @FXML
    private Label punteggioCittà;

    @FXML
    private Button riprendiPartita;

    @FXML
    private Pane sfondo;

    @FXML
    private Label titolo;

    public boolean impostaCitta(City c) {
		try {
			città = c;
			return true;
		}catch(Exception e) {
			return false;
		}
	}
    
    @FXML
    void closeWindow(ActionEvent event) {
    	riprendiPartita.getScene().getWindow().hide();
    }

    @FXML
    void initialize() {
    	titolo.setText("Cittadina di "+città.getNome());
    	punteggioCittà.setText("Punteggio cittadina: " + città.getPunteggio());
    	String s = "";
    	s+="Punteggio residenziale"+città.getResidenziale();
    	s+="\nPunteggio culturale"+città.getCulturale();
    	s+="\nPunteggio pubblico"+città.getPubblico();
    	s+="\nPunteggio commerciale"+città.getCommerciale();
    	punteggiVariCittà.setText(s);
    	
    }
    
}

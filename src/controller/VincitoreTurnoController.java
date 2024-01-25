package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import model.DBPartite;
import model.Partita;

public class VincitoreTurnoController {

	private Partita partita;
	private boolean x ; 
	
    @FXML
    private Button procediButton;

    @FXML
    private AnchorPane sfondo;

    @FXML
    private VBox sfondoBianco;

    @FXML
    private Label text;

    @FXML
    void procedi(ActionEvent event) {
    	procediButton.getScene().getWindow().hide();
    	if(x)
    		GestoreScene.scegliCartaSchermata(partita, partita.getWinner());
    	else {
    		partita.nextTurn();
    		DBPartite.aggiungiPartita(partita);
    		GestoreScene.scegliCartaSchermata(partita, partita.getWinner());
    	}
    }

    public void caricaConVincitore( ){
    	text.setText("Vincitore : "+partita.getWinner());
    	x = true;
    }
    
    public void caricaSenzaVincitore(){
    	text.setText("Nessun vincitore questo turno");
    	x = false;
    }
    
    public void importaPartita(Partita p) {
    	partita = p;	
    }
    
}

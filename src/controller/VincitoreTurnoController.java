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
	private String winner;
	
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
    	if(x) {
    		partita.assegnaTavolo(winner);
    		GestoreScene.scegliCartaSchermata(partita,winner);
    	}else {
    		partita.nextTurn();
    		DBPartite.aggiungiPartita(partita);
    		GestoreScene.prossimoTurnoPopup(partita);
    	}
    }

    public void caricaConVincitore(String winner){
    	this.winner = winner;
    	text.setText("Vincitore : "+winner+"\nCrediti vinti : "+partita.getTavolo());
    	x = true;
    }
    
    public void caricaSenzaVincitore(){
    	text.setText("Nessun vincitore questo turno"+"\nTavolo : "+partita.getTavolo());
    	x = false;
    }
    
    public void importaPartita(Partita p) {
    	partita = p;
    }
    
}

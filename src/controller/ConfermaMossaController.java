package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import model.Partita;

public class ConfermaMossaController {

	private Partita partita;
	private String giocatore;
	private int puntata;
	
    @FXML
    private Button noButton;

    @FXML
    private AnchorPane sfondo;

    @FXML
    private VBox sfondoBianco;

    @FXML
    private Label text;

    @FXML
    private Button yesButton;

    @FXML
    void ButtonNoClicked(ActionEvent event) {
    	noButton.getScene().getWindow().hide();
    }

    @FXML
    void ButtonYesClicked(ActionEvent event) {
    	partita.aggiornaCreditiTurno(giocatore,puntata);
    	
    	GestoreScene.campoDaGioco(, partita);
    }
    
    public void impostaTesto(boolean x , int pun, Partita p, String g) {
    	partita = p;
    	giocatore = g;
    	puntata = pun;
    	if(x) {
    		text.setText(g + " confermi di puntare "+pun+" crediti questa mano?");
    	}else {
    		text.setText(g + " confermi di lasciare la mano?");
    	}
    }

}


package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import model.DBPartite;
import model.Partita;

public class VincitorePartitaController {

	private Partita partita;
	
    @FXML
    private AnchorPane sfondo;

    @FXML
    private VBox sfondoBianco;

    @FXML
    private Label titoloPartita;

    @FXML
    private Button tornaHomeButton;

    @FXML
    void tornaHome(ActionEvent event) {
    	try {
    		partita.chiudiPartita();
    		DBPartite.aggiungiPartita(partita);
    	}catch(Exception e) {
    		GestoreScene.messaggioErrore("Errore salvataggio partita");
    	}
    	
    	GestoreScene.welcome(false);
    }
    
    
    public void impostaPartita(Partita p) {
    	partita = p;
    }
    
}

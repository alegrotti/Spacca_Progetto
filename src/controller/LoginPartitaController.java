package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.DBPartite;
import model.Partita;

public class LoginPartitaController {

    @FXML
    private VBox centralBox;

    @FXML
    private TextField codicePartita;

    @FXML
    private Pane sfondo;

    @FXML
    private Label titolo;

    @FXML
    void giocaPartita(ActionEvent event) {
    	try {
    		String codice = codicePartita.getText();
    		if(codice.equals(""))
    			throw new IllegalArgumentException("Nessun codice inserito");
    		if(DBPartite.esistePartita(codice)) {
    			try {
    				Partita p = DBPartite.getPartita(codice);
    				GestoreScene.campoDaGioco("", p, 0);
    		    	GestoreScene.prossimoTurnoPopup(p);
    		    	System.out.println("Partita "+codice+" caricata");
    	    	}catch(Exception e) {
    	    		GestoreScene.messaggioErrore("Errore caricamento partita");
    	    	}
    		}else {
    			throw new Exception("Partita inesistente");
    		}
    	}catch(Exception e) {
    		GestoreScene.messaggioErrore(e.getMessage());
    	}
    }

    @FXML
    void tornaWelcome(ActionEvent event) {
    	GestoreScene.welcome(false);
    }

}

package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.DBTornei;
import model.Torneo;

public class LoginTorneoController {

    @FXML
    private VBox centralBox;

    @FXML
    private TextField codiceTorneo;

    @FXML
    private Pane sfondo;

    @FXML
    private Label titolo;

    @FXML
    void giocaTorneo(ActionEvent event) {
    	try {
    		String codice = codiceTorneo.getText();
    		if(codice.equals(""))
    			throw new IllegalArgumentException("Nessun codice inserito");
    		if(DBTornei.esisteTorneo(codice)) {
    			try {
    				Torneo t = DBTornei.getTorneo(codice);
    				GestoreScene.tabelloneTorneo(t);
    		    	System.out.println("Torneo "+codice+" caricato");
    	    	}catch(Exception e) {
    	    		GestoreScene.messaggioErrore("Errore caricamento torneo");
    	    	}
    		}else {
    			throw new Exception("Torneo inesistente");
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

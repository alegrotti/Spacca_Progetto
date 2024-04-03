package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.DBTornei;

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
    		GestoreScene.tabelloneTorneo(DBTornei.getTorneo(codiceTorneo.getText()));
    	}catch(Exception e) {
    		GestoreScene.messaggioErrore("Errore apertura finestra");
    	}
    }

    @FXML
    void tornaWelcome(ActionEvent event) {
    	GestoreScene.welcome(false);
    }

}

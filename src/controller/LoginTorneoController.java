package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

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
    		Parent root = FXMLLoader.load(getClass().getResource("/view/TabelloneTorneo.fxml"));
	        Scene scenaHomepage = new Scene(root);
	        scenaHomepage.getStylesheets().add("/view/tabellonetorneo.css");
	        GestoreScene.setScene(scenaHomepage,false," - Login tournament");
    	}catch(Exception e) {
    		GestoreScene.messaggioErrore("Errore apertura finestra");
    	}
    }

    @FXML
    void tornaWelcome(ActionEvent event) {
    	GestoreScene.welcome(false);
    }

}

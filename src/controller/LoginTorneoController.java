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

    }

    @FXML
    void tornaWelcome(ActionEvent event) {
    	try {
	    	Parent root = FXMLLoader.load(getClass().getResource("/view/Welcome.fxml"));
	        Scene scenaHomepage = new Scene(root);
	        scenaHomepage.getStylesheets().add("/view/welcome.css");
	        Main.setScene(scenaHomepage,false);
    	}catch(Exception e) {
    		Main.messaggioErrore("Errore apertura finestra");
    	}
    }

}

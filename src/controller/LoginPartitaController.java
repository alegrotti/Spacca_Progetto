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
    	
    }

    @FXML
    void tornaWelcome(ActionEvent event) {
    	try {
	    	Parent root = FXMLLoader.load(getClass().getResource("/view/Welcome.fxml"));
	        Scene scenaHomepage = new Scene(root);
	        scenaHomepage.getStylesheets().add("/view/welcome.css");
	        GestoreScene gestoreScene = new GestoreScene ();
	        gestoreScene.setScene(scenaHomepage,false);
    	}catch(Exception e) {
    		
    	}
    }

}

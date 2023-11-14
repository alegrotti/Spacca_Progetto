package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class StandingController {

    @FXML
    private VBox centralBox;

    @FXML
    private Button homeButton;

    @FXML
    private Pane sfondo;
    
    @FXML
    private TableView<?> tableGenerale;

    @FXML
    private TableView<?> tablePartite;

    @FXML
    private TableView<?> tableTornei;

    @FXML
    private TabPane tabPane;

    @FXML
    private Label titolo;

    @FXML
    private Label titoloGenerali;

    @FXML
    private Label titoloPartite;

    @FXML
    private Label titoloTornei;

    @FXML
    void backWelcome(ActionEvent event) {
    	try {
	    	Parent root = FXMLLoader.load(getClass().getResource("/view/Welcome.fxml"));
	        Scene scenaHomepage = new Scene(root);
	        scenaHomepage.getStylesheets().add("/view/welcome.css");
	        GestoreScene.setScene(scenaHomepage,false," - Homepage");
    	}catch(Exception e) {
    		GestoreScene.messaggioErrore("Errore apertura finestra");
    	}
    }

}

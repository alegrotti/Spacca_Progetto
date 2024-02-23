package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class RulesController {

    @FXML
    private VBox centralBox;

    @FXML
    private Button homeButton;

    @FXML
    private Pane sfondo;

    @FXML
    private TabPane tabPane;

    @FXML
    private Label titolo;

    private Label secondoTitoloConfronto;

    @FXML
    private Label secondoTitoloDetermina;

    @FXML
    private Label secondoTitoloFIne;

    @FXML
    private Label secondoTitoloFase;

    @FXML
    private Label secondoTitoloSetup;

    @FXML
    void backWelcome(ActionEvent event) {
    	try {
	    	Parent root = FXMLLoader.load(getClass().getResource("/view/Welcome.fxml"));
	        Scene scenaHomepage = new Scene(root);
	        scenaHomepage.getStylesheets().add("/view/welcome.css");
	        GestoreScene.setScene(scenaHomepage,false," - Homepage");
    	}catch(Exception e) {
    		
    	}
    }
    
    @FXML
    void initialize() {
       
    	
    }
    

}


    

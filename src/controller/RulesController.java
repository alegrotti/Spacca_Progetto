package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

    @FXML
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
    	GestoreScene.welcome(false);
    }

    @FXML
    void initialize() {
      
    }
    

}


    

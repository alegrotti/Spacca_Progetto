package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class RulesController {

    @FXML
    private BorderPane bordoImmagine;
	
    @FXML
    private VBox centralBox;

    @FXML
    private Button homeButton;
    
    @FXML
    private Label descrizioneCarta;

    @FXML
    private Label genereCarta;

    @FXML
    private ComboBox<String> listaCarte;
    
    @FXML
    private ImageView immagineCarta;

    @FXML
    private Pane sfondo;

    @FXML
    private TabPane tabPane;
    
    @FXML
    private VBox infoCarta;
    
    @FXML
    private HBox sfondoCarta;

    @FXML
    private Label titolo;
    
    @FXML
    private Label titoloCarta;
    
    @FXML
    private Label titoloDescrizione;
    
    @FXML
    private Label titoloGenere;

    @FXML
    void backWelcome(ActionEvent event) {
    	GestoreScene.welcome(false);
    }
    
    

}


    

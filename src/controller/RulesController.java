package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
    private Label testoCarta;

    @FXML
    private ComboBox<String> listaCarte;

    @FXML
    private Pane sfondo;

    @FXML
    private TabPane tabPane;

    @FXML
    private Label titolo;

    @FXML
    void backWelcome(ActionEvent event) {
    	try {
	    	Parent root = FXMLLoader.load(getClass().getResource("/view/Welcome.fxml"));
	        Scene scenaHomepage = new Scene(root);
	        scenaHomepage.getStylesheets().add("/view/welcome.css");
	        GestoreScene gestoreScene = new GestoreScene ();
	        gestoreScene.setScene(scenaHomepage,false);
    	}catch(Exception e) {
    		
    	}
    }
    
    /*
    "Casa Familiare",
    "Negozio di Abbigliamento",
    "Scuola Elementare",
    "Parco Giochi",
    "Centro Commerciale",
    "Teatro Municipale",
    "Ospedale Cittadino",
    "Piazza del Mercato",
    "Università",
    "Complesso Residenziale",
    "Biblioteca Comunale",
    "Parchi Urbani",
    "Museo d'Arte"
     */
    
    @FXML
    void initialize() {
    	
    	ObservableList<String> carteCreate = FXCollections.observableArrayList();
    	for(String s : WelcomeController.admin.getCarte().keySet())
    		carteCreate.add(s);
    	carteCreate.sort(null);
    	listaCarte.setItems(carteCreate);   	
    }
    
    @FXML
    void cartaScelta(ActionEvent event) {
    	String s = listaCarte.getValue();
    	testoCarta.setText(s);
    }

}


    

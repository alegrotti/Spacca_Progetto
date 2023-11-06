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
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.DBAdmin;

public class PlayerAreaController {

    @FXML
    private VBox centralBox;

    @FXML
    private Button homeButton;

    @FXML
    private ComboBox<String> listaGiocatori;

    @FXML
    private Pane sfondo;

    @FXML
    private TabPane tabPane;

    @FXML
    private TableView<?> tablePartite;

    @FXML
    private TableView<?> tableTornei;

    @FXML
    private Label titolo;

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
	        Main.setScene(scenaHomepage,false);
    	}catch(Exception e) {
    		
    	}
    }
    
    @FXML
    void initialize() {
    	ObservableList<String> giocatori = FXCollections.observableArrayList();
    	for(String s : DBAdmin.getAdmin().getGiocatori())
    		giocatori.add(s);
    	giocatori.sort(null);
    	listaGiocatori.setItems(giocatori);   	
    }

    @FXML
    void cartaScelta(ActionEvent event) {
    	
    }

}

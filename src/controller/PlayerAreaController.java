package controller;

import java.util.HashMap;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.DBAdmin;
import model.DBTornei;
import model.Partita;
import model.Torneo;

public class PlayerAreaController {

	private HashMap<String,Torneo> tornei;
	private HashMap<String,Partita> partite;
	
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
    	GestoreScene.welcome(false);
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
    void giocatoreScelto(ActionEvent event) {
    	String x = listaGiocatori.getValue();
    	caricaSchermata(x);
    }
    
    private void caricaSchermata(String giocatore) {
    	tornei = DBTornei.getTornei();
    	
    }

}

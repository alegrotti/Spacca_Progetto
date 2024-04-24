package controller;

import java.util.Vector;

import javax.swing.table.TableColumn;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.DBGiocatori;
import model.Giocatore;

public class StandingController {

    @FXML
    private VBox centralBox;

    @FXML
    private VBox centralBox1;

    @FXML
    private Button homeButton;

    @FXML
    private ComboBox<?> listaGiocatori;

    @FXML
    private TableColumn<?, ?> partiteGiocateCol;

    @FXML
    private TableColumn<?, ?> partiteGiocatoreCol;

    @FXML
    private TableColumn<?, ?> partitePuntiCol;

    @FXML
    private TableColumn<> partiteVinteCol;

    @FXML
    private Pane sfondo;

    @FXML
    private TabPane tabPane;

    @FXML
    private TableView<?> tableGenerale;

    @FXML
    private TableView<?> tablePartite;

    @FXML
    private TableView<?> tablePartite2;

    @FXML
    private TableView<?> tableTornei;

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
    	GestoreScene.welcome(false);
    }

    @FXML
    void giocatoreScelto(ActionEvent event) {

    }

    @FXML 
    void initialize() {
    	GestoreLog logManager = new GestoreLog();
    	DBGiocatori db = logManager.leggiDatabase();
    	Vector<Giocatore> giocatori = db.getDatabase();
    	
    	ObservableList<Giocatore> giocatoriClassifica = FXCollections.observableArrayList();
    	
    	for (Giocatore g : giocatori) {
    		giocatoriClassifica.add(g);
    	}
    	
    	this.nomeUtente.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	this.partiteGiocate.setCellValueFactory(new PropertyValueFactory<>("partiteGiocate"));
    	this.partiteVinte.setCellValueFactory(new PropertyValueFactory<>("partiteVinte"));
    	this.partitePareggiate.setCellValueFactory(new PropertyValueFactory<>("partitePareggiate"));
    	
    	this.tabellaPunteggi.setItems(giocatoriClassifica);	

    }
    
}

package controller;

import java.util.HashMap;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
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
    private TableColumn<Giocatore,String> generaleGiocatoriCol;

    @FXML
    private TableColumn<Giocatore,Integer> generalePuntiCol;

    @FXML
    private Button homeButton;

    @FXML
    private TableColumn<Giocatore,Integer> partiteGiocateCol;

    @FXML
    private TableColumn<Giocatore,String> partiteGiocatoreCol;

    @FXML
    private TableColumn<Giocatore,Integer> partitePuntiCol;

    @FXML
    private TableColumn<Giocatore,Integer> partiteVinteCol;

    @FXML
    private Pane sfondo;

    @FXML
    private TabPane tabPane;

    @FXML
    private TableView<Giocatore> tableGenerale;

    @FXML
    private TableView<Giocatore> tablePartite;

    @FXML
    private TableView<Giocatore> tableTornei;

    @FXML
    private Label titolo;

    @FXML
    private Label titoloGenerali;

    @FXML
    private Label titoloPartite;

    @FXML
    private Label titoloTornei;

    @FXML
    private TableColumn<Giocatore,Integer> torneiGiocatiCol;

    @FXML
    private TableColumn<Giocatore,String> torneiGiocatoriCol;

    @FXML
    private TableColumn<Giocatore,Integer> torneiPuntiCol;

    @FXML
    private TableColumn<Giocatore,Integer> torneiVintiCol;

    @FXML
    void backWelcome(ActionEvent event) {
    	GestoreScene.welcome(false);
    }
    
    @FXML
    void initialize() {
    	
    	ObservableList<Giocatore> giocatoriClassifica = FXCollections.observableArrayList();
    	
    	HashMap<String, Giocatore> m = DBGiocatori.Giocatori();
    	
    	for (String s : m.keySet()) {
    		Giocatore g = m.get(s);
    		giocatoriClassifica.add(g);
    	}
    	
    	this.generaleGiocatoriCol.setCellValueFactory(new PropertyValueFactory<>("username"));
    	this.generalePuntiCol.setCellValueFactory(new PropertyValueFactory<>("puntiTotali"));
    	
    	this.partiteGiocatoreCol.setCellValueFactory(new PropertyValueFactory<>("username"));
    	this.partiteVinteCol.setCellValueFactory(new PropertyValueFactory<>("partiteVinte"));
    	this.partiteGiocateCol.setCellValueFactory(new PropertyValueFactory<>("partiteGiocate"));
    	this.partitePuntiCol.setCellValueFactory(new PropertyValueFactory<>("puntiPartite"));
    	
    	this.torneiGiocatoriCol.setCellValueFactory(new PropertyValueFactory<>("username"));
    	this.torneiVintiCol.setCellValueFactory(new PropertyValueFactory<>("torneiVinti"));
    	this.torneiGiocatiCol.setCellValueFactory(new PropertyValueFactory<>("torneiGiocati"));
    	this.torneiPuntiCol.setCellValueFactory(new PropertyValueFactory<>("puntiTornei"));
    	
    	this.tablePartite.setItems(giocatoriClassifica);	
    	this.tableTornei.setItems(giocatoriClassifica);	
    	this.tableGenerale.setItems(giocatoriClassifica);	
    	
    	
    	
    }

}

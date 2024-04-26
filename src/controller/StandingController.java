package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
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

}

package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

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

}

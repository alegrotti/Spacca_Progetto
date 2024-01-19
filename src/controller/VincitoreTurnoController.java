package controller;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import model.Partita;

public class VincitoreTurnoController {

	private Partita partita;
	
    @FXML
    private Button procediButton;

    @FXML
    private AnchorPane sfondo;

    @FXML
    private VBox sfondoBianco;

    @FXML
    private Label text;

    @FXML
    void procedi(ActionEvent event) {
    	
    }

    @FXML
    void initialize() {
    	text.setText("Vincitore : "+partita.getWinner());
    }
    
    public void importaPartita(Partita p) {
    	partita = p;
    }
    
}

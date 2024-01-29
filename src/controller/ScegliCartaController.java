package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.Carta;
import model.DBCarte;
import model.DBPartite;
import model.Partita;

import java.util.ArrayList;

public class ScegliCartaController {

	private ToggleGroup scelte;
	private Partita partita;
	private String winner;

    @FXML
    private VBox carteDaScegliere;

    @FXML
    private Button confermaButton;

    @FXML
    private Pane sfondo;

    @FXML
    private VBox sfondoBianco;

    @FXML
    private Label titolo;

    @FXML
    void chiudiTurno(ActionEvent event) {
        RadioButton selectedRadioButton = (RadioButton) scelte.getSelectedToggle();
        if (selectedRadioButton != null) {
        	String s = selectedRadioButton.getText();
        	Carta c = DBCarte.getCarta(s);
        	partita.getCittadina(winner).aggiungiCarta(c);
        	partita.getMazzo().rimuoviCarta(c);
        	partita.nextTurn();
        	DBPartite.aggiungiPartita(partita);     	
        	GestoreScene.prossimoTurnoPopup(partita);
        }else {
        	GestoreScene.messaggioErrore("Selezionare palazzo");
        }
        confermaButton.getScene().getWindow().hide();
    }

    @FXML
    void initialize() {
        scelte = new ToggleGroup();
    }

    public void inizializzaSchermata(ArrayList<String> c, Partita p, String w) {
    	winner = w;
    	partita = p;
        for (String s : c) {
            creaRadioButton(s);
        }
    }

    private void creaRadioButton(String s) {
        RadioButton rb = new RadioButton();
        rb.setText(s);
        rb.setToggleGroup(scelte);
        carteDaScegliere.getChildren().add(rb);
    }
}

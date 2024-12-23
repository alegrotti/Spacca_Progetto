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
import model.Torneo;
import model.DBCarte;
import model.DBGiocatori;
import model.DBPartite;
import model.DBTornei;
import model.GiocatoreCPUDifficile;
import model.GiocatoreCPUFacile;
import model.GiocatoreFisico;
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
        	partita.nextTurn();
        	if(partita.isTorneo()) {
        		Torneo t = DBTornei.getTorneo(partita.getCodiceTorneo());
        		t.aggiornaPartita(partita);
        		DBTornei.aggiungiTorneo(t);
        	}else
        		DBPartite.aggiungiPartita(partita);     	
        	GestoreScene.prossimoTurnoPopup(partita);
        	confermaButton.getScene().getWindow().hide();
        	
        }else {
        	GestoreScene.messaggioErrore("Selezionare palazzo");
        }
    }

    @FXML
    void initialize() {
        scelte = new ToggleGroup();
    }

    public void inizializzaSchermata(ArrayList<String> c, Partita p, String w) {
    	winner = w;
    	partita = p;
    	
    	if (DBGiocatori.getGiocatore(winner) instanceof GiocatoreFisico) {
	        for (String s : c) {
	        	creaRadioButton(s);
	        }
    	}else if (DBGiocatori.getGiocatore(winner) instanceof GiocatoreCPUDifficile) {
    		GiocatoreCPUDifficile g = (GiocatoreCPUDifficile)DBGiocatori.getGiocatore(winner);

    		String cartaScelta = g.scegliCarta(partita.getCittadina(winner),c);
    		
    		boolean t = false;
    		
    		for (String s : c) {
                RadioButton rb = new RadioButton();

                if (s.equals(cartaScelta) && t == false) {
                    rb.setText(s);
                    rb.setToggleGroup(scelte);
                    rb.setSelected(true);
                    rb.setOnAction(event -> {
        				rb.setSelected(true);
        			});
                    t=true;
                } else {
                    rb.setText(s);
                    rb.setDisable(true);
                }
                carteDaScegliere.getChildren().add(rb);
            }
    	}
    	else if (DBGiocatori.getGiocatore(winner) instanceof GiocatoreCPUFacile) {
    		GiocatoreCPUFacile g = (GiocatoreCPUFacile)DBGiocatori.getGiocatore(winner);

    		String cartaScelta = g.scegliCarta(partita.getCittadina(winner),c);
		
    		boolean t = false;
		
    		for (String s : c) {
    			RadioButton rb = new RadioButton();

    			if (s.equals(cartaScelta) && t == false) {
    				rb.setText(s);
    				rb.setToggleGroup(scelte);
    				rb.setSelected(true);
    				rb.setOnAction(event -> {
    					rb.setSelected(true);
    				});
    				t=true;
    			} else {
            	   rb.setText(s);
            	   rb.setDisable(true);
    			}
    			carteDaScegliere.getChildren().add(rb);
    		}
    	}
    }

    private void creaRadioButton(String s) {
        RadioButton rb = new RadioButton();
        rb.setText(s);
        rb.setToggleGroup(scelte);
        carteDaScegliere.getChildren().add(rb);
    }
}

package controller;

import javafx.fxml.FXML;
import model.Giocatore;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import model.Partita;
import model.DBCarte;
import model.City;

public class CampoGiocoController {

	private Partita partita;
	
	private Giocatore giocatore;
	
    @FXML
    private Button buttonLasciare;

    @FXML
    private Button buttonRilanciare;

    @FXML
    private HBox hboxMano;

    @FXML
    private HBox hboxTavolo;

    @FXML
    private ImageView iconMano1;

    @FXML
    private ImageView iconMano2;

    @FXML
    private ImageView iconMano3;

    @FXML
    private ImageView iconRetroCarta;

    @FXML
    private ImageView iconTavolo1;

    @FXML
    private ImageView iconTavolo2;

    @FXML
    private ImageView iconTavolo3;

    @FXML
    private ImageView iconTavolo4;
    
    @FXML
    private Button mostracittaButton;

    @FXML
    private Pane sfondo;
    
    @FXML
    private Pane sfondoScuro;

    @FXML
    private Label textCrediti;

    @FXML
    private Label textMoney;
    
    @FXML
    private Button confermaButton;
    
    @FXML
    void confermaButtonClicked(ActionEvent event) {

    }
    
    @FXML
    void buttonPuntareClicked(ActionEvent event) {

    }

    @FXML
    void mostracittaButtonClicked(ActionEvent event) {
    	try {
    		City c = new City("alegrotti");
    		c.aggiungiCarta(DBCarte.getCarta("Museo"));
    		c.aggiungiCarta(DBCarte.getCarta("Teatro"));
    		MostraCittadinaController.città = c;
	    	GestoreScene.mostraCittadina(null);
    	}catch(Exception e) {
    		GestoreScene.messaggioErrore("Errore apertura finestra");
    	}
    }
	
	public boolean impostaPartita(Partita p) {
		try {
			partita = p;
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
    @FXML
    void initialize() {
    	Image retro = new Image("/immagini/retrocarta.png");
    	String creditiRimanenti = "-- --";
    	
    	iconRetroCarta.setImage(retro);
    	iconMano1.setImage(retro);
    	iconMano2.setImage(retro);
    	iconMano3.setImage(retro);
    	iconTavolo1.setImage(retro);
    	iconTavolo1.setImage(retro);
    	iconTavolo2.setImage(retro);
    	iconTavolo3.setImage(retro);
    	iconTavolo4.setImage(retro);
    	
    	textMoney.setText(creditiRimanenti);
    	
    }

}

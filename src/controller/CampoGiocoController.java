package controller;

import javafx.fxml.FXML;
import model.Giocatore;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import model.Partita;

public class CampoGiocoController {

	public static Partita partita;

	//public static Giocatore giocatore;
	
    @FXML
    private Button buttonLasciare;

    @FXML
    private Button buttonRilanciare;
    
    @FXML
    private Button playButton;

    @FXML
    private HBox hboxMano;

    @FXML
    private HBox hboxTavolo;
    
    @FXML
    private ImageView homepageIcon;

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
    private Label textTurno;

    @FXML
    private Button confermaButton;
    
    @FXML
    private VBox vbox;
    
    @FXML
    void confermaButtonClicked(ActionEvent event) {

    }
    
    @FXML
    void buttonPuntareClicked(ActionEvent event) {

    }
    
    @FXML
    void homepageIconClicked(MouseEvent event) {
    	GestoreScene.messaggioRitornoHomepage("Tornando alla homepage \nperderai il turno corrente, \ncontinuare?");    	
    }

    @FXML
    void mostracittaButtonClicked(ActionEvent event) {
    	try {
    		/*
    		City c = new City("alegrotti");
    		c.aggiungiCarta(DBCarte.getCarta("Museo"));
    		c.aggiungiCarta(DBCarte.getCarta("Teatro"));
    		c.aggiungiCarta(DBCarte.getCarta("Casa familiare"));
    		c.aggiungiCarta(DBCarte.getCarta("Negozio di abbigliamento"));
    		//c.aggiungiCarta(DBCarte.getCarta("Teatro"));
	    	GestoreScene.mostraCittadina(c);
	    	*/
    		//GestoreScene.schermataPuntata(partita);
    		ArrayList<String> s = new ArrayList<String>();
    		s.add("casa");
    		s.add("museo");
    		GestoreScene.scegliCartaSchermata(s,partita);
    	}catch(Exception e) {
    		GestoreScene.messaggioErrore("Errore apertura finestra");
    	}
    }
	
    @FXML
    void playButtonClicked(ActionEvent event) {

    }
    
    @FXML
    void initialize() {
    	Image retro = new Image("/immagini/retrocarta.png");
    	Image homePage = new Image("/immagini/homepageIcon.png");
    	
    	iconRetroCarta.setImage(retro);
    	iconMano1.setImage(retro);
    	iconMano2.setImage(retro);
    	iconMano3.setImage(retro);
    	iconTavolo1.setImage(retro);
    	iconTavolo1.setImage(retro);
    	iconTavolo2.setImage(retro);
    	iconTavolo3.setImage(retro);
    	iconTavolo4.setImage(retro);
    	
    	homepageIcon.setImage(homePage);
    	
    	
    }

}

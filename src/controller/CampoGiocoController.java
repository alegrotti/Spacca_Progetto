package controller;

import javafx.fxml.FXML;
import model.Giocatore;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
    private Label textMoney;
    
    @FXML
    private Button confermaButton;
    
    @FXML
    private VBox vboxScuro;
    
    @FXML
    void confermaButtonClicked(ActionEvent event) {

    }
    
    @FXML
    void buttonPuntareClicked(ActionEvent event) {

    }
    
    @FXML
    void homepageIconClicked(MouseEvent event) {
    	System.out.println(0);
    	GestoreScene.messaggioRitornoHomepage("Homepage");
    	System.out.println(1);
    	
    }

    @FXML
    void mostracittaButtonClicked(ActionEvent event) {
    	try {
	    	Parent root = FXMLLoader.load(getClass().getResource("/view/MostraCittadina.fxml"));
	        Scene scenaHomepage = new Scene(root);
	        scenaHomepage.getStylesheets().add("/view/mostracittadina.css");
	        GestoreScene.setScene(scenaHomepage,false," - Mostra cittadina");
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
    	Image homePage = new Image("/immagini/homepageIcon.png");
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
    	
    	homepageIcon.setImage(homePage);
    	
    	textMoney.setText(creditiRimanenti);
    	
    }

}

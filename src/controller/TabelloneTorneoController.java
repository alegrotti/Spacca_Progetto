package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
//import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Partita;
import model.Torneo;

public class TabelloneTorneoController {

	private Torneo torneo;
	
    @FXML
    private Button finaleButton;

    @FXML
    private VBox finaleVBox;

    @FXML
    private Label giocatoreFinale1;

    @FXML
    private Label giocatoreFinale2;

    @FXML
    private Label giocatoreOttavo1;

    @FXML
    private Label giocatoreOttavo10;

    @FXML
    private Label giocatoreOttavo11;

    @FXML
    private Label giocatoreOttavo12;

    @FXML
    private Label giocatoreOttavo13;

    @FXML
    private Label giocatoreOttavo14;

    @FXML
    private Label giocatoreOttavo15;

    @FXML
    private Label giocatoreOttavo16;

    @FXML
    private Label giocatoreOttavo2;

    @FXML
    private Label giocatoreOttavo3;

    @FXML
    private Label giocatoreOttavo4;

    @FXML
    private Label giocatoreOttavo5;

    @FXML
    private Label giocatoreOttavo6;

    @FXML
    private Label giocatoreOttavo7;

    @FXML
    private Label giocatoreOttavo8;

    @FXML
    private Label giocatoreOttavo9;

    @FXML
    private Label giocatoreQuarto1;

    @FXML
    private Label giocatoreQuarto2;

    @FXML
    private Label giocatoreQuarto3;

    @FXML
    private Label giocatoreQuarto4;

    @FXML
    private Label giocatoreQuarto5;

    @FXML
    private Label giocatoreQuarto6;

    @FXML
    private Label giocatoreQuarto7;

    @FXML
    private Label giocatoreQuarto8;

    @FXML
    private Label giocatoreSemifinale1;

    @FXML
    private Label giocatoreSemifinale2;

    @FXML
    private Label giocatoreSemifinale3;

    @FXML
    private Label giocatoreSemifinale4;

    @FXML
    private VBox infoTorneoVBox;

    @FXML
    private Button ottavo1Button;

    @FXML
    private HBox ottavo1HBox;

    @FXML
    private Button ottavo2Button;

    @FXML
    private HBox ottavo2HBox;

    @FXML
    private Button ottavo3Button;

    @FXML
    private HBox ottavo3HBox;

    @FXML
    private Button ottavo4Button;

    @FXML
    private HBox ottavo4HBox;

    @FXML
    private Button ottavo5Button;

    @FXML
    private HBox ottavo5HBox;

    @FXML
    private Button ottavo6Button;

    @FXML
    private HBox ottavo6HBox;

    @FXML
    private Button ottavo7Button;

    @FXML
    private HBox ottavo7HBox;

    @FXML
    private Button ottavo8Button;

    @FXML
    private HBox ottavo8HBox;

    @FXML
    private Button quarto1Button;

    @FXML
    private HBox quarto1HBox;

    @FXML
    private Button quarto2Button;

    @FXML
    private HBox quarto2HBox;

    @FXML
    private Button quarto3Button;

    @FXML
    private HBox quarto3HBox;

    @FXML
    private Button quarto4Button;

    @FXML
    private HBox quarto4HBox;

    @FXML
    private Button semifinale1Button;

    @FXML
    private HBox semifinale1HBox;

    @FXML
    private Button semifinale2Button;

    @FXML
    private HBox semifinale2HBox;

    @FXML
    private HBox sfondoHBox;

    @FXML
    private Label vincitoreLabel;
    
    @FXML
    private ImageView homePageIcon;
    
    @FXML
    private VBox vboxIcon;
    
    public boolean impostaTorneo(Torneo t) {
		try {
			torneo = t;
			return true;
		}catch(Exception e) {
			return false;
		}
	}
    
    @FXML
    void initialize() {
    	Image homePage = new Image("/immagini/homepageIcon.png");
    }
    
    @FXML
    void homepageIconClicked(MouseEvent event) {
    	GestoreScene.messaggioRitornoHomepage("Tornando alla homepage \nperderai il turno corrente, \ncontinuare?");
    }

    @FXML
    void GIocaOttavo6Button(ActionEvent event) {

    }

    @FXML
    void GiocaOttavo3Button(ActionEvent event) {

    }

    @FXML
    void GiocaQuarto2Button(ActionEvent event) {

    }

    @FXML
    void giocaFinaleButton(ActionEvent event) {

    }

    @FXML
    void giocaOttavo1Button(ActionEvent event) {

    }

    @FXML
    void giocaOttavo2Button(ActionEvent event) {

    }

    @FXML
    void giocaOttavo4Button(ActionEvent event) {

    }

    @FXML
    void giocaOttavo5Button(ActionEvent event) {

    }

    @FXML
    void giocaOttavo7Button(ActionEvent event) {

    }

    @FXML
    void giocaOttavo8Button(ActionEvent event) {

    }

    @FXML
    void giocaQuarto1Button(ActionEvent event) {

    }

    @FXML
    void giocaQuarto3Button(ActionEvent event) {

    }

    @FXML
    void giocaQuarto4Button(ActionEvent event) {

    }

    @FXML
    void giocaSemifinale1Button(ActionEvent event) {

    }

    @FXML
    void giocaSemifinale2Button(ActionEvent event) {

    }

}

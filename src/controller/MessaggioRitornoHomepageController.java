package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import model.DBGiocatori;
import model.Torneo;

public class MessaggioRitornoHomepageController {

	private Torneo torneo;
	
    @FXML
    private ImageView ImageIcon;

    @FXML
    private Button noButton;

    @FXML
    private AnchorPane sfondo;

    @FXML
    private HBox sfondoBianco;

    @FXML
    private Label text;

    @FXML
    private Button yesButton;

    @FXML
    void ButtonNoClicked(ActionEvent event) {
    	noButton.getScene().getWindow().hide();
    }

    public void impostaTorneo(Torneo t) {
        torneo = t;
    }
    
    @FXML
    void ButtonYesClicked(ActionEvent event) {
    	GestoreScene.welcome(true);
    	if(torneo!=null)
    		DBGiocatori.eliminaGiocatori(torneo.getGiocatoriCPU());
    	yesButton.getScene().getWindow().hide();
    }
    
    public void impostaTesto(String testo) {
        text.setText(testo);
    }
    
    @FXML
    void initialize() {
    	Image foto = new Image("/immagini/errorefoto.jpg");
    	ImageIcon.setImage(foto);
    }
    

}

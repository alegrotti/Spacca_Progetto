package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.DBAdmin;
import javafx.scene.layout.HBox;

public class MessaggioDiUscitaController {

    @FXML
    private ImageView ImageIcon;

    @FXML
    private Button noButton;

    @FXML
    private Label text;
    
    @FXML
    private HBox sfondoBianco;

    @FXML
    private Button yesButton;
    
    @FXML
    private AnchorPane sfondo;

    @FXML
    void ButtonNoClicked(ActionEvent event) {
    	noButton.getScene().getWindow().hide();
    	Main.uscita = false;
    }

    @FXML
    void ButtonYesClicked(ActionEvent event) {
    	DBAdmin.salvaAdmin(WelcomeController.admin);
    	Platform.exit();
    }

    public void impostaTesto(String testo) {
        text.setText(testo);
    }
    
    @FXML
    void initialize() {
    	Image foto = new Image("/immagini/emoji_triste.png");
    	ImageIcon.setImage(foto);
    }
    
}


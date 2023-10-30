package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class MessaggioDiUscitaController {

    @FXML
    private ImageView ImageIcon;

    @FXML
    private Button noButton;

    @FXML
    private Label text;

    @FXML
    private Button yesButton;
    
    @FXML
    private AnchorPane sfondo;

    @FXML
    void ButtonNoClicked(ActionEvent event) {
    	noButton.getScene().getWindow().hide();
    }

    @FXML
    void ButtonYesClicked(ActionEvent event) {
    	Platform.exit();
    }

    public void impostaTesto(String testo) {
        text.setText(testo);
    }
    
    
}


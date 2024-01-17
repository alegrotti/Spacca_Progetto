package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class ConfermaMossaController {

    @FXML
    private Button noButton;

    @FXML
    private AnchorPane sfondo;

    @FXML
    private VBox sfondoBianco;

    @FXML
    private Label text;

    @FXML
    private Button yesButton;

    @FXML
    void ButtonNoClicked(ActionEvent event) {
    	noButton.getScene().getWindow().hide();
    }

    @FXML
    void ButtonYesClicked(ActionEvent event) {

    }
    
    public void impostaTesto(boolean x , int puntata) {
    	if(x) {
    		text.setText("Confermi di puntare "+puntata+" crediti questa mano?");
    	}else {
    		text.setText("Confermi di lasciare la mano?");
    	}
    }

}


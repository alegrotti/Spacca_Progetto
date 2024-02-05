package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class MessaggioController {

    @FXML
    private Button procediButton;

    @FXML
    private AnchorPane sfondo;

    @FXML
    private VBox sfondoBianco;

    @FXML
    private Label text;

    @FXML
    void procedi(ActionEvent event) {
    	procediButton.getScene().getWindow().hide();
    }

    public void impostaTesto(String s) {
    	text.setText(s);
    }
    
}

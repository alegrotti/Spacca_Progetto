package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class messaggioErroreController {

    @FXML
    private Button bottoneOk;

    @FXML
    private Label testoMessaggioErrore;

    @FXML
    void MouseOkClicked(MouseEvent event) {
    	bottoneOk.getScene().getWindow().hide();
    }
    
    

}

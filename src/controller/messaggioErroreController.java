package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class messaggioErroreController {

	private static String stringa;
	
    @FXML
    private Button bottoneOk;

    @FXML
    private Label testoMessaggioErrore;

    @FXML
    void MouseOkClicked(MouseEvent event) {
    	bottoneOk.getScene().getWindow().hide();
    }
    
    public static void impostaTesto(String s) {
    	stringa = s;
    }
    
    @FXML
    private void initialize() {
    	testoMessaggioErrore.setText(stringa);
    }

}

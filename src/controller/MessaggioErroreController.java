package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class MessaggioErroreController {

	@FXML
    private Button bottoneOk;

    @FXML
    private Pane sfondo;
	
    @FXML
    private Label testoMessaggioErrore;

    @FXML
    void mouseOkClicked(ActionEvent event) {
        bottoneOk.getScene().getWindow().hide();
    }

    public void impostaTesto(String testo) {
        testoMessaggioErrore.setText(testo);
    }

}

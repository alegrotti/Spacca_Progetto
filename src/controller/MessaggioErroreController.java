package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class MessaggioErroreController {

    @FXML
    private Button bottoneOk;
    
    @FXML
    private ImageView immagine;

    @FXML
    private Pane sfondo;

    @FXML
    private VBox sfondoBianco;

    @FXML
    private Label testoMessaggioErrore;

    @FXML
    void mouseOkClicked(ActionEvent event) {
        bottoneOk.getScene().getWindow().hide();
    }

    public void impostaTesto(String testo) {
        testoMessaggioErrore.setText(testo);
    }
    
    @FXML
    void initialize() {
    	Image foto = new Image("/immagini/errorefoto.png");
    	immagine.setImage(foto);
    }

}

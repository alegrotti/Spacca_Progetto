package controller;

import java.util.HashSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class PuntataPartitaController {

	private HashSet<String> players;
	
    @FXML
    private VBox giocatoriPuntate;

    @FXML
    private Pane sfondo;
    
    @FXML
    private VBox sfondoBianco;

    @FXML
    private Label titolo;

    @FXML
    private Label valorePuntata;
    
    @FXML
    private Button puntaButton;

    @FXML
    void confermaPuntata(ActionEvent event) {
    	puntaButton.getScene().getWindow().hide();
    }
    
    @FXML
    void initialize() {
    	players = new HashSet<String>();
    }
    
    public void inizializzaSchermata(int punti,HashSet<String> g) {
    	valorePuntata.setText("Per giocare bisogna puntare : "+punti);
    	
    	for(String s : g)
    		creaRadioButton(s);
    }
    
    private void creaRadioButton(String s) {
    	RadioButton rb = new RadioButton();
    	rb.setText(s);
    	rb.applyCss();
    	
    	rb.setOnAction(event -> {
            if (rb.isSelected()) {
                players.add(s);
            } else {
            	players.remove(s);
            }
        });
    	
    	giocatoriPuntate.getChildren().add(rb);
    }
    
    

}

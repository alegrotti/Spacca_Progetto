package controller;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class PuntataPartitaController {

	private ArrayList<String> players;
	private int crediti;
	
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
    	CampoGiocoController.partita.aggiornaCrediti(players,crediti);
    	
    	puntaButton.getScene().getWindow().hide();
    	
    }
    
    @FXML
    void initialize() {
    	players = new ArrayList<String>();
    }
    
    public void inizializzaSchermata(int punti,ArrayList<String> g) {
    	valorePuntata.setText("Per giocare bisogna puntare : "+punti);
    	crediti = punti;
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

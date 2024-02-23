package controller;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import model.DBPartite;
import model.Partita;

public class VincitoreTurnoController {

	private ArrayList<String> playersPenalizzati;
	private Partita partita;
	private boolean x ; 
	private String winner;
	
    @FXML
    private VBox hboxWinner;
	
	@FXML
    private VBox hboxPenalizzati;
	
	@FXML
    private Label creditiTesto;

    @FXML
    private Label listaPenalizzazione;
    
    @FXML
    private Label listaPenalizzazioneCrediti;

    @FXML
    private Button procediButton;

    @FXML
    private VBox sfondoBianco;

    @FXML
    private Label titoloPartita;

    @FXML
    private Label vincitoreTesto;
	
    @FXML
    private AnchorPane sfondo;

    @FXML
    void procedi(ActionEvent event) {
    	procediButton.getScene().getWindow().hide();
    	partita.controllaCrediti();
    	if(x) {
    		partita.assegnaTavolo(winner);
    		GestoreScene.scegliCartaSchermata(partita,winner);
    	}else {
    		partita.nextTurn();
    		DBPartite.aggiungiPartita(partita);
    		GestoreScene.prossimoTurnoPopup(partita);
    	}
    }

    public void caricaConVincitore(String winner){
    	this.winner = winner;
    	procediButton.setText("Scegli carta");
    	vincitoreTesto.setText("Vincitore : "+winner);
    	creditiTesto.setText("Crediti vinti : "+partita.getTavolo());
    	x = true;
    }
    
    public void caricaSenzaVincitore(){
    	vincitoreTesto.setText("Nessun vincitore questo turno");
    	creditiTesto.setText("Tavolo : "+partita.getTavolo());
    	procediButton.setText("Chiudi turno e salva");
    	x = false;
    }
    
    public void importaPartita(Partita p,ArrayList<String> g) {
    	playersPenalizzati = g;
    	partita = p;
    	
    	if(playersPenalizzati.size()!=0) {
	    	String x = "";
	    	for(String s : playersPenalizzati) {
	    		x+=s+"\n";
	    	}
	    	listaPenalizzazione.setText(x);
	    	listaPenalizzazioneCrediti.setText("Crediti persi: "+partita.getPuntata()+"");
    	}else {
    		listaPenalizzazione.setText("- - - -");
    	}	
    }
    
}

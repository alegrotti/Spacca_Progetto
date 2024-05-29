package controller;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.City;
import model.DBPartite;
import model.DBTornei;
import model.Partita;
import model.Torneo;

public class VincitoreTurnoController {

	private ArrayList<String> playersPenalizzati;
	private Partita partita;
	private boolean x ; 
	private String winner;
	
    @FXML
    private ComboBox<String> comboBox;
	
    @FXML
    private HBox hBoxCity;
    
	@FXML
    private VBox hboxWinner;
	
    @FXML
    private Button mostraCittadinaButton;
	
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
    	if(x) {
    		partita.assegnaTavolo(winner);
    		partita.controllaCrediti();
    		GestoreScene.scegliCartaSchermata(partita,winner);
    	}else {
    		partita.controllaCrediti();
    		partita.nextTurn();
    		if(partita.isTorneo()) {
        		Torneo t = DBTornei.getTorneo(partita.getCodiceTorneo());
        		t.aggiornaPartita(partita);
        		DBTornei.aggiungiTorneo(t);
        	}else
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

    	comboBox.setValue(winner);
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
    	
    	ObservableList<String> players = FXCollections.observableArrayList();
    	for(String s : partita.getGiocatori())
    		players.add(s);
    	players.sort(null);
    	comboBox.setItems(players);
    	
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
    
    @FXML
    void mostraCittadina(ActionEvent event) {
    	try {
	    	String g = comboBox.getValue();
	    	City c = new City(g);
	    	
	    	for(int i = 0; i<partita.getMano(g).length ; i++)
	    		c.aggiungiCarta(partita.getMano(g)[i]);
	    	
	    	for(int i = 0; i<partita.getCarteTavolo().length ; i++)
	    		c.aggiungiCarta(partita.getCarteTavolo()[i]);
	    	
	    	GestoreScene.mostraCittadina(c);
    	}catch(Exception e) {
    		GestoreScene.messaggioErrore("Seleziona giocatore");
    	}
    }
    
}

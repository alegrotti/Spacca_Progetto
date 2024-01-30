package controller;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.Partita;

public class PuntataPartitaController {

	private ArrayList<String> players;
	private int crediti;
	private Partita partita;
	private ArrayList<String> playersPenalizzati;
	
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
    	if(players.size() == 0) {
    		for(String x : partita.getGiocatoriPuntata()) {
    			partita.rimuoviCrediti(x);
    			playersPenalizzati.add(x);
    		}
    		GestoreScene.vincitoreTurno(partita,false,"",playersPenalizzati);
    	}else if(players.size() == 1) {
    		players.trimToSize();
    		String winner = players.getFirst();
    		if(partita.getGiocatoriPuntata().contains(winner)) {
    			for(String x : partita.getGiocatoriPuntata())
    				if(!x.equals(winner)) {
    					partita.rimuoviCrediti(x);
    					playersPenalizzati.add(x);
    				}
    			GestoreScene.vincitoreTurno(partita,true,winner,playersPenalizzati);
    		}else{
    			for(String x : partita.getGiocatoriPuntata()) {
    				if(!x.equals(winner)) {
    					partita.rimuoviCrediti(x);
    					playersPenalizzati.add(x);
    				}
    			}
    			GestoreScene.vincitoreTurno(partita,true,winner,playersPenalizzati);
    		}
    	}else{
    		partita.aggiornaCrediti(players, crediti);
        	String g = partita.aggiornaTurno();
        	
        	if(g!=null) {
        		GestoreScene.campoDaGioco(g, partita, crediti);
        	}else {
        		String winner = partita.confrontaCittadine();
        		if(partita.getGiocatoriPuntata().contains(winner)) {
        			for(String x : partita.getGiocatoriPuntata())
        				if(!x.equals(winner)) {
        					partita.rimuoviCrediti(x);
        					playersPenalizzati.add(x);
        				}
        			GestoreScene.vincitoreTurno(partita,true,winner,playersPenalizzati);
        		}else{
        			for(String x : partita.getGiocatoriPuntata()) {
        				if(!x.equals(winner)) {
        					partita.rimuoviCrediti(x);
        					playersPenalizzati.add(x);
        				}
        			}
        			GestoreScene.vincitoreTurno(partita,true,winner,playersPenalizzati);
        		}
        	}
    	}
    }
    
    @FXML
    void initialize() {
    	players = new ArrayList<String>();
    	playersPenalizzati = new ArrayList<String>();
    }
    
    public void inizializzaSchermata(Partita p) {
    	valorePuntata.setText("Per giocare bisogna puntare : "+p.getPuntata());
    	crediti = p.getPuntata();
    	for(String s : p.getGiocatoriTurno())
    		creaRadioButton(s);
    	
    	partita = p;
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

package controller;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.DBGiocatori;
import model.Giocatore;
import model.GiocatoreCPUDifficile;
import model.GiocatoreCPUFacile;
import model.GiocatoreFisico;
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
    	System.out.println(players);
    	try {
	    	if(players.size() == 0) {
	    		for(String x : partita.getGiocatoriPuntata()) {
	    			partita.rimuoviCrediti(x);
	    			playersPenalizzati.add(x);
	    		}
	    		GestoreScene.vincitoreTurno(partita,false,"",playersPenalizzati);
	    	}else if(players.size() == 1) {
	    		players.trimToSize();
	    		String winner = players.get(0);
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
	        		GestoreScene.campoDaGioco(g, partita, 1);
	        	}else {
	        		String winner = partita.confrontaCittadineTurno();
	        		if(partita.getGiocatoriPuntata().contains(winner)) {
	        			for(String x : partita.getGiocatoriPuntata())
	        				if(!x.equals(winner)) {
	        					partita.rimuoviCrediti(x);
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
	    	puntaButton.getScene().getWindow().hide();
    	}catch(Exception e) {
    		GestoreScene.messaggioErrore("Errore puntata");
    	}
    }
    
    @FXML
    void initialize() {
    	players = new ArrayList<String>();
    	playersPenalizzati = new ArrayList<String>();
    }
    
    public void inizializzaSchermata(Partita p) {
    	partita = p;
    	valorePuntata.setText("Per giocare bisogna puntare : "+p.getPuntata());
    	crediti = p.getPuntata();
    	for(String s : p.getGiocatoriTurno())
    		creaRadioButton(s);
    }
    
    private void creaRadioButton(String s) {
    	
    	Giocatore g = DBGiocatori.getGiocatore(s);
    	RadioButton rb = new RadioButton();
    	if(g instanceof GiocatoreFisico) {
	    	rb.setText(s);
	    	rb.applyCss();
	    	
	    	rb.setOnAction(event -> {
	            if (rb.isSelected()) {
	                players.add(s);
	            } else {
	            	players.remove(s);
	            }
	        });
    	}else if (g instanceof GiocatoreCPUDifficile) {
    		GiocatoreCPUDifficile p = (GiocatoreCPUDifficile) g;
    		rb.setText(s);
	    	rb.applyCss();
    		if(p.partecipa(partita,s)) {
    			players.add(s);
    			rb.setSelected(true);
    			rb.setOnAction(event -> {
    				rb.setSelected(true);
    			});
    		}else{
    			rb.setSelected(false);
    			rb.setOnAction(event -> {
    				rb.setSelected(false);
    			});
    		}
    	}
    	else if (g instanceof GiocatoreCPUFacile) {
    		GiocatoreCPUFacile p = (GiocatoreCPUFacile) g;
    		rb.setText(s);
	    	rb.applyCss();
    		if(p.partecipa(partita,s)) {
    			players.add(s);
    			rb.setSelected(true);
    			rb.setOnAction(event -> {
    				rb.setSelected(true);
    			});
    		}else{
    			rb.setSelected(false);
    			rb.setOnAction(event -> {
    				rb.setSelected(false);
    			});
    		}
    	}

    	giocatoriPuntate.getChildren().add(rb);
    }
    
    

}

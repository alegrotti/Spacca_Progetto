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
    		GestoreScene.vincitoreTurno(partita,false,"");
    		partita.rimuoviCrediti();
    		GestoreScene.messaggio(partita.getGiocatorePuntata()+" ha proposto la puntata "
    				+ "maggiore ma non ha partecipato quindi perde ugualmente "+partita.getPuntata()+" crediti");
    	}else if(players.size() == 1) {
    		players.trimToSize();
    		String winner = players.getFirst();
    		if(winner.equals(partita.getGiocatorePuntata())) {
    			GestoreScene.vincitoreTurno(partita,true,winner);
    		}else{
    			GestoreScene.vincitoreTurno(partita,true,winner);
        		partita.rimuoviCrediti();
        		GestoreScene.messaggio(partita.getGiocatorePuntata()+" ha proposto la puntata "
        				+ "maggiore ma non ha partecipato quindi perde ugualmente "+partita.getPuntata()+" crediti");
    		}
    	}else{
    		players.trimToSize();
    		String winner = players.getFirst();
    		if(winner.equals(partita.getGiocatorePuntata())) {
    			GestoreScene.vincitoreTurno(partita,true,winner);
    		}else{
    			GestoreScene.vincitoreTurno(partita,true,winner);
        		partita.rimuoviCrediti();
        		GestoreScene.messaggio(partita.getGiocatorePuntata()+" ha proposto la puntata "
        				+ "maggiore ma non ha partecipato quindi perde ugualmente "+partita.getPuntata()+" crediti");
    		}
    	}
    	
    	
    	/*
    	partita.aggiornaCrediti(players, crediti);
    	String g = partita.aggiornaTurno();
    	
    	if(g!=null) {
    		GestoreScene.campoDaGioco(g, partita, crediti);
    	}else {
    		partita.confrontaCittadine();
    		String w = partita.getWinner();
    		if(w != null) {
    			GestoreScene.vincitoreTurno(partita,true,w);
    		}else {
    			GestoreScene.vincitoreTurno(partita,false,"");
    		}
    	}
    	*/
    	
    }
    
    @FXML
    void initialize() {
    	players = new ArrayList<String>();
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

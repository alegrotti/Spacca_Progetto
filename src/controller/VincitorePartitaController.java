package controller;

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
import model.DBPartite;
import model.Partita;

public class VincitorePartitaController {

	private Partita partita;
	
    @FXML
    private Label classificato1;

    @FXML
    private Label classificato2;

    @FXML
    private Label classificato3;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private Label eliminati;

    @FXML
    private HBox hBoxCity;

    @FXML
    private Button mostraCittadinaButton;

    @FXML
    private Label restoClassifica;

    @FXML
    private AnchorPane sfondo;

    @FXML
    private VBox sfondoBianco;

    @FXML
    private Label titoloPartita;

    @FXML
    private Button tornaHomeButton;

    @FXML
    void tornaHome(ActionEvent event) {
    	try {
    		DBPartite.aggiungiPartita(partita);
    	}catch(Exception e) {
    		GestoreScene.messaggioErrore("Errore salvataggio partita");
    	}
    	
    	GestoreScene.welcome(false);
    }
    
    @FXML
    void mostraCittadina(ActionEvent event) {
    	try {
	    	String g = comboBox.getValue();
	    	GestoreScene.mostraCittadina(partita.getCittadina(g));
    	}catch(Exception e) {
    		GestoreScene.messaggioErrore("Seleziona giocatore");
    	}
    }
    
    public void impostaPartita(Partita p) {
    	partita = p;
    	
    	ObservableList<String> players = FXCollections.observableArrayList();
    	for(String s : partita.getGiocatori())
    		players.add(s);
    	players.sort(null);
    	comboBox.setItems(players);
    	
    	creaSchermata();
    }
    
    public void creaSchermata() {
    	int j = partita.getGiocatori().size();
    	if(j>=1) {
    		String g1 = partita.getClassifica().get(0);
    		classificato1.setText(g1+" - "+partita.getCittadina(g1).getCarte().size()+" palazzi e "+partita.getCrediti(g1)+" crediti");
    	}if(j>=2) {
    		String g2 = partita.getClassifica().get(1);
    		classificato2.setText(g2+" - "+partita.getCittadina(g2).getCarte().size()+" palazzi e "+partita.getCrediti(g2)+" crediti");
    	}if(j>=3) {
    		String g3 = partita.getClassifica().get(2);
    		classificato3.setText(g3+" - "+partita.getCittadina(g3).getCarte().size()+" palazzi e "+partita.getCrediti(g3)+" crediti");
    	}if(j>3) {
    		String stringa = "";
    		for(int i = 3; i < j ; i++) {
    			String g = partita.getClassifica().get(i);
    			stringa+=(g+" - "+partita.getCittadina(g).getCarte().size()+" palazzi e "
    									+partita.getCrediti(g)+" crediti\n");
    		}
    		restoClassifica.setText(stringa);
    	}
    	
    	String y = "";
    	for(int i = 0; i < partita.getGiocatoriEliminati().size() ; i++) {
			String g = partita.getGiocatoriEliminati().get(i);
			y+=(g+" - eliminato con 0 crediti\n");
		}
    	eliminati.setText(y);
    }
}

package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import model.Partita;

public class ConfermaMossaController {

	private Partita partita;
	private String giocatore;
	private int puntata;
	private boolean bool;
	
    @FXML
    private Button noButton;

    @FXML
    private AnchorPane sfondo;

    @FXML
    private VBox sfondoBianco;

    @FXML
    private Label text;

    @FXML
    private Button yesButton;

    @FXML
    void ButtonNoClicked(ActionEvent event) {
    	noButton.getScene().getWindow().hide();
    }

    @FXML
    void ButtonYesClicked(ActionEvent event) {
    	yesButton.getScene().getWindow().hide();
    	String next = partita.nextPlayer(giocatore);
    	if(bool) {
	    	partita.aggiornaCreditiTurno(giocatore,puntata);
    	} else {
	    	partita.eliminaGiocatoreTurno(giocatore);
    	}
    	
    	if(next == null) {
    		GestoreScene.campoDaGioco(next, partita, 0);
    		int j = partita.getGiocatoriTurno().size();
    		if(j >= 2 )
    			GestoreScene.schermataPuntata(partita);
    		else if (j == 1)
    			GestoreScene.vincitoreTurno(partita,true);
    		else {
    			int m = partita.getMano();
    			if(m==0)
    				GestoreScene.vincitoreTurno(partita,false);
    			else
    				GestoreScene.vincitoreTurno(partita,false);
			}
    	}
    	else
    		GestoreScene.campoDaGioco(next, partita, 1);
    	
    }
    
    public void impostaTesto(boolean x , int pun, Partita p, String g) {
    	partita = p;
    	giocatore = g;
    	puntata = pun;
    	bool = x;
    	if(x) {
    		text.setText(g + " confermi di puntare "+pun+" crediti questa mano?");
    	}else {
    		text.setText(g + " confermi di lasciare la mano?");
    	}
    }

}


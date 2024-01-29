package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.Partita;
import model.PartitaAPalazzi;
import model.PartitaATurni;

public class ProssimoTurnoController {

	private Partita partita;
	
	@FXML
    private Button backHomeButton;

    @FXML
    private Button giocaTurnoButton;
    
    @FXML
    private HBox giocatoriPartitaLabel;

    @FXML
    private Label infoGiocatori;

    @FXML
    private Label listaGiocatori;
    
    @FXML
    private Label prossimoTurnoLabel;

    @FXML
    private Label obiettivoPartita;

    @FXML
    private Pane sfondo;
    
    @FXML
    private VBox sfondoBianco;

    @FXML
    private Label titoloPartita;


    public boolean impostaPartita(Partita p) {
		try {
			partita = p;
			return true;
		}catch(Exception e) {
			return false;
		}
	}
    
    @FXML
    void backHome(ActionEvent event) {
    	try {
	    	Parent root = FXMLLoader.load(getClass().getResource("/view/Welcome.fxml"));
	        Scene scenaHomepage = new Scene(root);
	        scenaHomepage.getStylesheets().add("/view/welcome.css");
	        GestoreScene.setScene(scenaHomepage,false," - Homepage");
	        backHomeButton.getScene().getWindow().hide();
    	}catch(Exception e) {
    		GestoreScene.messaggioErrore("Errore apertura finestra");
    	}
    }

    @FXML
    void giocaTurno(ActionEvent event) {
    	giocaTurnoButton.getScene().getWindow().hide();
    	String g = partita.inizializzaTurno();
    	GestoreScene.campoDaGioco(g, partita, 1);
    }
    
    public void inizializzaSchermata() {
    	titoloPartita.setText("Partita "+partita.getCodice());
    	if(partita instanceof PartitaAPalazzi) {
			PartitaAPalazzi p1 = (PartitaAPalazzi) partita;
			obiettivoPartita.setText("Partita a palazzi - Obiettivo "+p1.getPalazzi()+" palazzi");
		}
		else {
			PartitaATurni p1 = (PartitaATurni) partita;
			obiettivoPartita.setText("Partita a turni - Obiettivo "+p1.getTurni()+" turni");
		}
    	prossimoTurnoLabel.setText("Prossimo turno - "+partita.getTurno());
    	String giocatori = "";
    	String palazzi = "";
    	for(String s : partita.getGiocatori()) {
    		giocatori+=s+"\n";
    		palazzi+=" - "+partita.getCittadina(s).getCarte().size()+" palazzi\n";
    	}
    	listaGiocatori.setText(giocatori);
    	infoGiocatori.setText(palazzi);
    }

}

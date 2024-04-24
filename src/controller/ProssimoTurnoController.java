package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import model.DBPartite;
import model.DBTornei;
import model.Partita;
import model.PartitaAPalazzi;
import model.PartitaATurni;
import model.Torneo;

public class ProssimoTurnoController {

	private Partita partita;
	
	@FXML
    private Button backHomeButton;
	
    @FXML
    private Label giocatoriEliminatiLabel;

    @FXML
    private Button giocaTurnoButton;
    
    @FXML
    private VBox giocatoriPartitaLabel;
    
    @FXML
    private Button mostraVincitore;

    @FXML
    private Label infoGiocatori;

    @FXML
    private Label listaGiocatori;
    
    @FXML
    private Label prossimoTurnoLabel;

    @FXML
    private Label obiettivoPartita;

    @FXML
    private AnchorPane sfondo;
    
    @FXML
    private VBox sfondoBianco;

    @FXML
    private Label titoloPartita;


    public boolean impostaPartita(Partita p) {
		try {
			partita = p;
			if(partita.isTorneo()) {
        		Torneo t = DBTornei.getTorneo(partita.getCodiceTorneo());
        		t.aggiornaPartita(partita);
        		DBTornei.aggiungiTorneo(t);
        	}else
        		DBPartite.aggiungiPartita(partita);     
			return true;
		}catch(Exception e) {
			return false;
		}
	}
    
    @FXML
    void backHome(ActionEvent event) {
    	GestoreScene.welcome(true);
    	if(partita.isTorneo())
    		DBTornei.getTorneo(partita.getCodiceTorneo()).eliminaGiocatoriDB();
    	backHomeButton.getScene().getWindow().hide();
    }

    @FXML
    void giocaTurno(ActionEvent event) {
    	String g = partita.inizializzaTurno();
    	GestoreScene.campoDaGioco(g, partita, 1);
    	giocaTurnoButton.getScene().getWindow().hide();
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
    	mostraVincitore.setVisible(false);
    }
    
    public void inizializzaSchermataFinale() {
    	titoloPartita.setText("Partita "+partita.getCodice());
    	if(partita instanceof PartitaAPalazzi) {
			PartitaAPalazzi p1 = (PartitaAPalazzi) partita;
			obiettivoPartita.setText("Partita a palazzi - Obiettivo "+p1.getPalazzi()+" palazzi");
		}
		else {
			PartitaATurni p1 = (PartitaATurni) partita;
			obiettivoPartita.setText("Partita a turni - Obiettivo "+p1.getTurni()+" turni");
		}
    	prossimoTurnoLabel.setText("Partita finita!");
    	String giocatori = "";
    	String palazzi = "";
    	for(String s : partita.getGiocatori()) {
    		giocatori+=s+"\n";
    		palazzi+=" - "+partita.getCittadina(s).getCarte().size()+" palazzi\n";
    	}
    	
    	String giocatoriEliminati = "";
    	for(String s : partita.getGiocatoriEliminati()) {
    		giocatoriEliminati+=s+"\n";
    	}
    	
    	giocatoriEliminatiLabel.setText(giocatoriEliminati);
    	listaGiocatori.setText(giocatori);
    	infoGiocatori.setText(palazzi);
    	giocaTurnoButton.setVisible(false);
    	backHomeButton.setVisible(false);
    	
    	if(partita.isCompletata())
    		backHomeButton.setVisible(true);
    		
    }
    
    @FXML
    void mostraVincitore(ActionEvent event) {
    	GestoreScene.vincitorePartita(partita);
    	mostraVincitore.getScene().getWindow().hide();
    }

}

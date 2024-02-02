package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import model.Partita;
import model.PartitaAPalazzi;
import model.PartitaATurni;

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
    }
    
    @FXML
    void mostraVincitore(ActionEvent event) {
    	GestoreScene.vincitorePartita(partita);
    	mostraVincitore.getScene().getWindow().hide();
    }

}

package controller;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.DBGiocatori;
import model.Partita;
import model.Torneo;

public class TabelloneTorneoController {

	private Torneo torneo;
	
    @FXML
    private Label giocatoriTorneo;
    
    @FXML
    private HBox hBoxSemifinali;
    
    @FXML
    private Label obiettivoTorneo;

    @FXML
    private Label titoloTorneo;
	
    @FXML
    private Button finaleButton;

    @FXML
    private VBox finaleVBox;

    @FXML
    private Label giocatoreFinale1;

    @FXML
    private Label giocatoreFinale2;

    @FXML
    private Label giocatoreOttavo1;

    @FXML
    private Label giocatoreOttavo10;

    @FXML
    private Label giocatoreOttavo11;

    @FXML
    private Label giocatoreOttavo12;

    @FXML
    private Label giocatoreOttavo13;

    @FXML
    private Label giocatoreOttavo14;

    @FXML
    private Label giocatoreOttavo15;

    @FXML
    private Label giocatoreOttavo16;

    @FXML
    private Label giocatoreOttavo2;

    @FXML
    private Label giocatoreOttavo3;

    @FXML
    private Label giocatoreOttavo4;

    @FXML
    private Label giocatoreOttavo5;

    @FXML
    private Label giocatoreOttavo6;

    @FXML
    private Label giocatoreOttavo7;

    @FXML
    private Label giocatoreOttavo8;

    @FXML
    private Label giocatoreOttavo9;

    @FXML
    private Label giocatoreQuarto1;

    @FXML
    private Label giocatoreQuarto2;

    @FXML
    private Label giocatoreQuarto3;

    @FXML
    private Label giocatoreQuarto4;

    @FXML
    private Label giocatoreQuarto5;

    @FXML
    private Label giocatoreQuarto6;

    @FXML
    private Label giocatoreQuarto7;

    @FXML
    private Label giocatoreQuarto8;

    @FXML
    private Label giocatoreSemifinale1;

    @FXML
    private Label giocatoreSemifinale2;

    @FXML
    private Label giocatoreSemifinale3;

    @FXML
    private Label giocatoreSemifinale4;

    @FXML
    private VBox infoTorneoVBox;

    @FXML
    private Button ottavo1Button;

    @FXML
    private HBox ottavo1HBox;

    @FXML
    private Button ottavo2Button;

    @FXML
    private HBox ottavo2HBox;

    @FXML
    private Button ottavo3Button;

    @FXML
    private HBox ottavo3HBox;

    @FXML
    private Button ottavo4Button;

    @FXML
    private HBox ottavo4HBox;

    @FXML
    private Button ottavo5Button;

    @FXML
    private HBox ottavo5HBox;

    @FXML
    private Button ottavo6Button;

    @FXML
    private HBox ottavo6HBox;

    @FXML
    private Button ottavo7Button;

    @FXML
    private HBox ottavo7HBox;

    @FXML
    private Button ottavo8Button;

    @FXML
    private HBox ottavo8HBox;

    @FXML
    private Button quarto1Button;

    @FXML
    private HBox quarto1HBox;

    @FXML
    private Button quarto2Button;

    @FXML
    private HBox quarto2HBox;

    @FXML
    private Button quarto3Button;

    @FXML
    private HBox quarto3HBox;

    @FXML
    private Button quarto4Button;

    @FXML
    private HBox quarto4HBox;

    @FXML
    private Button semifinale1Button;

    @FXML
    private HBox semifinale1HBox;

    @FXML
    private Button semifinale2Button;

    @FXML
    private HBox semifinale2HBox;

    @FXML
    private HBox sfondoHBox;

    @FXML
    private Label vincitoreLabel;
    
    @FXML
    private ImageView homePageIcon;
    
    @FXML
    private VBox vboxIcon;
    
    public boolean impostaTorneo(Torneo t) {
		try {
			torneo = t;
			DBGiocatori.aggiungiGiocatori(torneo.getGiocatoriCPU());
			return true;
		}catch(Exception e) {
			return false;
		}
	}
    
    @FXML
    void homepageIconClicked(MouseEvent event) {
    	giocatoriTorneo.getScene().getWindow().hide();
    	torneo.eliminaGiocatoriDB();
    	GestoreScene.welcome(true);
    }

    @FXML
    void GIocaOttavo6Button(ActionEvent event) {
    	GestoreScene.prossimoTurnoPopup(torneo.getPartiteTorneo().get("Ottavo-6"),true);
    }

    @FXML
    void GiocaOttavo3Button(ActionEvent event) {
    	GestoreScene.prossimoTurnoPopup(torneo.getPartiteTorneo().get("Ottavo-6"),true);
    }

    @FXML
    void GiocaQuarto2Button(ActionEvent event) {
    	GestoreScene.prossimoTurnoPopup(torneo.getPartiteTorneo().get("Quarto-2"),true);
    }

    @FXML
    void giocaFinaleButton(ActionEvent event) {
    	GestoreScene.prossimoTurnoPopup(torneo.getPartiteTorneo().get("Finale"),true);
    }

    @FXML
    void giocaOttavo1Button(ActionEvent event) {
    	GestoreScene.prossimoTurnoPopup(torneo.getPartiteTorneo().get("Ottavo-1"),true);
    }

    @FXML
    void giocaOttavo2Button(ActionEvent event) {
    	GestoreScene.prossimoTurnoPopup(torneo.getPartiteTorneo().get("Ottavo-2"),true);
    }

    @FXML
    void giocaOttavo4Button(ActionEvent event) {
    	GestoreScene.prossimoTurnoPopup(torneo.getPartiteTorneo().get("Ottavo-4"),true);
    }

    @FXML
    void giocaOttavo5Button(ActionEvent event) {
    	GestoreScene.prossimoTurnoPopup(torneo.getPartiteTorneo().get("Ottavo-5"),true);
    }

    @FXML
    void giocaOttavo7Button(ActionEvent event) {
    	GestoreScene.prossimoTurnoPopup(torneo.getPartiteTorneo().get("Ottavo-7"),true);
    }

    @FXML
    void giocaOttavo8Button(ActionEvent event) {
    	GestoreScene.prossimoTurnoPopup(torneo.getPartiteTorneo().get("Quarto-8"),true);
    }

    @FXML
    void giocaQuarto1Button(ActionEvent event) {
    	GestoreScene.prossimoTurnoPopup(torneo.getPartiteTorneo().get("Quarto-1"),true);
    }

    @FXML
    void giocaQuarto3Button(ActionEvent event) {
    	GestoreScene.prossimoTurnoPopup(torneo.getPartiteTorneo().get("Quarto-3"),true);
    }

    @FXML
    void giocaQuarto4Button(ActionEvent event) {
    	GestoreScene.prossimoTurnoPopup(torneo.getPartiteTorneo().get("Quarto-4"),true);
    }

    @FXML
    void giocaSemifinale1Button(ActionEvent event) {
    	GestoreScene.prossimoTurnoPopup(torneo.getPartiteTorneo().get("Semifinale-1"),true);
    }

    @FXML
    void giocaSemifinale2Button(ActionEvent event) {
    	GestoreScene.prossimoTurnoPopup(torneo.getPartiteTorneo().get("Semifinale-2"),true);
    }
    
    public void creaSchermata() {
    	titoloTorneo.setText("Torneo - "+torneo.getCodice());
    	vincitoreLabel.setVisible(false);
    	
    	ottavo1HBox.setVisible(false);
		ottavo2HBox.setVisible(false);
		ottavo3HBox.setVisible(false);
		ottavo4HBox.setVisible(false);
		ottavo5HBox.setVisible(false);
		ottavo6HBox.setVisible(false);
		ottavo7HBox.setVisible(false);
		ottavo8HBox.setVisible(false);
    	
		quarto1HBox.setVisible(false);
		quarto2HBox.setVisible(false);
		quarto3HBox.setVisible(false);
		quarto4HBox.setVisible(false);
		
		semifinale1HBox.setVisible(false);
		semifinale2HBox.setVisible(false);
		
		finaleVBox.setVisible(false);
		
		if(torneo.getSize() > 8) {
			creaOttavi();
    	}if(torneo.getSize() > 4) {	
    		if(torneo.getStato()<=3)
    			creaQuarti();
    	}
    	if(torneo.getStato()<=2)
    		creaSemifinali();
    	if(torneo.getStato()<=1)
    		creaFinale();
    	if(torneo.getStato()==0) {
    		vincitoreLabel.setVisible(true);
    		vincitoreLabel.setText("Il vincitore è: " + torneo.getWinner());
    	}
    		
    	obiettivoTorneo.setText("Torneo a " + torneo.getTipo());
    	giocatoriTorneo.setText("Giocatori del torneo:\n" + torneo.getGiocatori());
    
    	
    }
    
    private void creaOttavi() {
    	ottavo1HBox.setVisible(true);
		ottavo2HBox.setVisible(true);
		ottavo3HBox.setVisible(true);
		ottavo4HBox.setVisible(true);
		ottavo5HBox.setVisible(true);
		ottavo6HBox.setVisible(true);
		ottavo7HBox.setVisible(true);
		ottavo8HBox.setVisible(true);
		
		Partita o1 = torneo.getPartiteTorneo().get("Ottavo-1");
		Partita o2 = torneo.getPartiteTorneo().get("Ottavo-2");
		Partita o3 = torneo.getPartiteTorneo().get("Ottavo-3");
		Partita o4 = torneo.getPartiteTorneo().get("Ottavo-4");
		Partita o5 = torneo.getPartiteTorneo().get("Ottavo-5");
		Partita o6 = torneo.getPartiteTorneo().get("Ottavo-6");
		Partita o7 = torneo.getPartiteTorneo().get("Ottavo-7");
		Partita o8 = torneo.getPartiteTorneo().get("Ottavo-8");
		
		ArrayList<String> g1 = new ArrayList<String>();
		ArrayList<String> g2 = new ArrayList<String>();
		ArrayList<String> g3 = new ArrayList<String>();
		ArrayList<String> g4 = new ArrayList<String>();
		ArrayList<String> g5 = new ArrayList<String>();
		ArrayList<String> g6 = new ArrayList<String>();
		ArrayList<String> g7 = new ArrayList<String>();
		ArrayList<String> g8 = new ArrayList<String>();
		
		g1.addAll(o1.getGiocatori());
		g1.addAll(o1.getGiocatoriEliminati());
		
		g2.addAll(o2.getGiocatori());
		g2.addAll(o2.getGiocatoriEliminati());
		
		g3.addAll(o3.getGiocatori());
		g3.addAll(o3.getGiocatoriEliminati());
		
		g4.addAll(o4.getGiocatori());
		g4.addAll(o4.getGiocatoriEliminati());
		
		g5.addAll(o5.getGiocatori());
		g5.addAll(o5.getGiocatoriEliminati());
		
		g6.addAll(o6.getGiocatori());
		g6.addAll(o6.getGiocatoriEliminati());
		
		g7.addAll(o7.getGiocatori());
		g7.addAll(o7.getGiocatoriEliminati());
		
		g8.addAll(o8.getGiocatori());
		g8.addAll(o8.getGiocatoriEliminati());
		
		giocatoreOttavo1.setText(g1.get(0));
		giocatoreOttavo2.setText(g1.get(1));
		giocatoreOttavo3.setText(g2.get(0));
		giocatoreOttavo4.setText(g2.get(1));
		giocatoreOttavo5.setText(g3.get(0));
		giocatoreOttavo6.setText(g3.get(1));
		giocatoreOttavo7.setText(g4.get(0));
		giocatoreOttavo8.setText(g4.get(1));
		giocatoreOttavo9.setText(g5.get(0));
		giocatoreOttavo10.setText(g5.get(1));
		giocatoreOttavo11.setText(g6.get(0));
		giocatoreOttavo12.setText(g6.get(1));
		giocatoreOttavo13.setText(g7.get(0));
		giocatoreOttavo14.setText(g7.get(1));
		giocatoreOttavo15.setText(g8.get(0));
		giocatoreOttavo16.setText(g8.get(1));
		
	}
    
    private void creaQuarti() {
    	quarto1HBox.setVisible(true);
		quarto2HBox.setVisible(true);
		quarto3HBox.setVisible(true);
		quarto4HBox.setVisible(true);
		
		Partita q1 = torneo.getPartiteTorneo().get("Quarto-1");
		Partita q2 = torneo.getPartiteTorneo().get("Quarto-2");
		Partita q3 = torneo.getPartiteTorneo().get("Quarto-3");
		Partita q4 = torneo.getPartiteTorneo().get("Quarto-4");
		
		ArrayList<String> g1 = new ArrayList<String>();
		ArrayList<String> g2 = new ArrayList<String>();
		ArrayList<String> g3 = new ArrayList<String>();
		ArrayList<String> g4 = new ArrayList<String>();
		
		g1.addAll(q1.getGiocatori());
		g1.addAll(q1.getGiocatoriEliminati());
		
		g2.addAll(q2.getGiocatori());
		g2.addAll(q2.getGiocatoriEliminati());
		
		g3.addAll(q3.getGiocatori());
		g3.addAll(q3.getGiocatoriEliminati());
		
		g4.addAll(q4.getGiocatori());
		g4.addAll(q4.getGiocatoriEliminati());
		
		giocatoreQuarto1.setText(g1.get(0));
		giocatoreQuarto2.setText(g1.get(1));
		giocatoreQuarto3.setText(g2.get(0));
		giocatoreQuarto4.setText(g2.get(1));
		giocatoreQuarto5.setText(g3.get(0));
		giocatoreQuarto6.setText(g3.get(1));
		giocatoreQuarto7.setText(g4.get(0));
		giocatoreQuarto8.setText(g4.get(1));
		
	}

    private void creaSemifinali() {
    	semifinale1HBox.setVisible(true);
		semifinale2HBox.setVisible(true);
		
		Partita s1 = torneo.getPartiteTorneo().get("Semifinale-1");
		Partita s2 = torneo.getPartiteTorneo().get("Semifinale-2");
		
		ArrayList<String> g1 = new ArrayList<String>();
		ArrayList<String> g2 = new ArrayList<String>();
		
		g1.addAll(s1.getGiocatori());
		g1.addAll(s1.getGiocatoriEliminati());
		
		g2.addAll(s2.getGiocatori());
		g2.addAll(s2.getGiocatoriEliminati());
		
		giocatoreSemifinale1.setText(g1.get(0));
		giocatoreSemifinale2.setText(g1.get(1));
		giocatoreSemifinale3.setText(g2.get(0));
		giocatoreSemifinale4.setText(g2.get(1));

	}
    
    private void creaFinale() {
    	finaleVBox.setVisible(true);
    	
		Partita f1 = torneo.getPartiteTorneo().get("Finale");
		
		ArrayList<String> g1 = new ArrayList<String>();
		
		g1.addAll(f1.getGiocatori());
		g1.addAll(f1.getGiocatoriEliminati());
		
		giocatoreFinale1.setText(g1.get(0));
		giocatoreFinale2.setText(g1.get(1));
		
    }
    
}

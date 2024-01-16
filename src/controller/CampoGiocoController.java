package controller;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import model.Carta;
import model.City;
import model.Partita;

public class CampoGiocoController {

	private Partita partita;

	private String giocatore;
	
	private int tavolo;
	
	@FXML
    private TextField CreditiPuntatiField;

    @FXML
    private Button buttonLasciare;

    @FXML
    private Button buttonPuntare;

    @FXML
    private Button confermaButton;

    @FXML
    private HBox hboxMano;

    @FXML
    private HBox hboxTavolo;

    @FXML
    private ImageView homepageIcon;

    @FXML
    private ImageView iconMano1;

    @FXML
    private ImageView iconMano2;

    @FXML
    private ImageView iconMano3;

    @FXML
    private ImageView iconRetroCarta;

    @FXML
    private ImageView iconTavolo1;

    @FXML
    private ImageView iconTavolo2;

    @FXML
    private ImageView iconTavolo3;

    @FXML
    private ImageView iconTavolo4;

    @FXML
    private Button mostracittaButton;

    @FXML
    private Button playButton;

    @FXML
    private Pane sfondo;

    @FXML
    private Pane sfondoScuro;

    @FXML
    private Label textCrediti;

    @FXML
    private Label textGiocatoreCorrente;

    @FXML
    private Label textNome;

    @FXML
    private Label textNumTurno;

    @FXML
    private Label textProssGiocatori;

    @FXML
    private VBox vboxPlay;

    @FXML
    private VBox vboxProssimiGiocatori;
    
    @FXML
    private Button passaTurnoButton;

    
    @FXML
    void confermaButtonClicked(ActionEvent event) {

    }
    
    @FXML
    void buttonPuntareClicked(ActionEvent event) {
    	CreditiPuntatiField.setVisible(true);
    	confermaButton.setVisible(true);
    }
    
    @FXML
    void homepageIconClicked(MouseEvent event) {
    	GestoreScene.messaggioRitornoHomepage("Tornando alla homepage \nperderai il turno corrente, \ncontinuare?");    	
    }

    @FXML
    void mostracittaButtonClicked(ActionEvent event) {
    	try {
    		GestoreScene.mostraCittadina(partita.getCittadina(giocatore));
    	}catch(Exception e) {
    		GestoreScene.messaggioErrore("Errore apertura finestra");
    	}
    }
	
    @FXML
    void playButtonClicked(ActionEvent event) {
    	caricaSchermataPlayer();
    	vboxPlay.setVisible(false);
    }
    
    public void caricaSchermataPlayer() {
    	
    	stampaCarte(partita.getCarteTavolo(),partita.getMano(giocatore));
    	
    	mostracittaButton.setVisible(true);
    	buttonLasciare.setVisible(true);
    	buttonPuntare.setVisible(true);
    	vboxPlay.setVisible(true);
    	textGiocatoreCorrente.setVisible(true);
    	vboxProssimiGiocatori.setVisible(true);
    	
    	vboxProssimiGiocatori.setVisible(true);
    	
    	textCrediti.setText("Crediti: " +  2222 );
    	textNome.setText("E' il turno di: " + giocatore );
    }
    
    public void caricaSchermataDefault(){
    	Image retro = new Image("/immagini/retrocarta.png");
    	Image homePage = new Image("/immagini/homepageIcon.png");
    	
    	iconRetroCarta.setImage(retro);
    	iconMano1.setImage(retro);
    	iconMano2.setImage(retro);
    	iconMano3.setImage(retro);
    	
    	iconTavolo1.setImage(retro);
    	iconTavolo2.setImage(retro);
    	iconTavolo3.setImage(retro);
    	iconTavolo4.setImage(retro);
    	
    	homepageIcon.setImage(homePage);
    	
    	vboxPlay.setVisible(true);
    	vboxProssimiGiocatori.setVisible(true);
    	
    	textNumTurno.setText("Turno "+ partita.getTurno());
    	
    	textGiocatoreCorrente.setText(giocatore);
    	String x = "";
    	for(String gioc : partita.getGiocatori())
    		if(!gioc.equals(giocatore))
    			x+=gioc;
    	
    	textProssGiocatori.setText(x);
    	textNome.setText("E' il turno di: " + giocatore);
    }
    
    private void stampaCarte(Carta[] carteTavolo, Carta[] carteMano) {
    	Image[] carteT = new Image[4];
    	Image[] carteM = new Image[3];
    	
    	Image retro = new Image("/immagini/retrocarta.png");
    	
    	for(int i = 0 ; i < tavolo ; i++)
    		carteT[i] = new Image(carteTavolo[i].getPercorso());
    	
    	for(int i = tavolo ; i < carteT.length ; i++)
    		carteT[i] = retro;
    	
    	iconTavolo1.setImage(carteT[0]);
    	iconTavolo2.setImage(carteT[1]);
    	iconTavolo3.setImage(carteT[2]);
    	iconTavolo4.setImage(carteT[3]);
    	
    	for(int i = 0 ; i < carteM.length ; i++)
    		carteM[i] = new Image(carteMano[i].getPercorso());
    	
    	iconMano1.setImage(carteM[0]);
    	iconMano2.setImage(carteM[1]);
    	iconMano3.setImage(carteM[2]);
    	
    }
    
    public void setInfo(Partita p, String g) {
    	partita = p;
    	giocatore = partita.inizializzaTurno();
    }
    
    @FXML
    void initialize() {
    	partita = new Partita();
    	giocatore = "";
    	tavolo = 2;
    	Image retro = new Image("/immagini/retrocarta.png");
    	Image homePage = new Image("/immagini/homepageIcon.png");
    	
    	iconRetroCarta.setImage(retro);
    	iconMano1.setImage(retro);
    	iconMano2.setImage(retro);
    	iconMano3.setImage(retro);
    	iconTavolo1.setImage(retro);
    	iconTavolo1.setImage(retro);
    	iconTavolo2.setImage(retro);
    	iconTavolo3.setImage(retro);
    	iconTavolo4.setImage(retro);
    	
    	homepageIcon.setImage(homePage);
    	
    	vboxPlay.setVisible(false);
    	mostracittaButton.setVisible(false);
    	buttonLasciare.setVisible(false);
    	buttonPuntare.setVisible(false);
    	CreditiPuntatiField.setVisible(false);
    	confermaButton.setVisible(false);
    	vboxProssimiGiocatori.setVisible(false);
    }

}

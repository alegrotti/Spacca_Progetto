package controller;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Carta;
import model.DBGiocatori;
import model.GiocatoreCPUDifficile;
import model.GiocatoreCPUFacile;
import model.GiocatoreFisico;
import model.Partita;

public class CampoGiocoController {

	private Partita partita;

	private String giocatore;
	
	private int tavolo;
	
	@FXML
    private Button giocaButtonCPU;
	
    @FXML
    private ImageView iconMano4;
	
	@FXML
    private TextField CreditiPuntatiField;
	
	@FXML
    private Button button1;

    @FXML
    private Button button100;

    @FXML
    private Button button1000;

    @FXML
    private Button button10000;

    @FXML
    private Button button5000;

    @FXML
    private Button buttonAllIn;

    @FXML
    private Button buttonLasciare;

    @FXML
    private Button buttonPuntare;
    
    @FXML
    private Button mostraCarteCPUButton;

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
    private ImageView iconTavolo1;

    @FXML
    private ImageView iconTavolo2;

    @FXML
    private ImageView iconTavolo3;

    @FXML
    private Button mostracittaButton;
    
    @FXML
    private Button resetCrediti;

    @FXML
    private Button playButton;

    @FXML
    private AnchorPane sfondo;

    @FXML
    private HBox sfondoScuro;

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
    	int a = 0;
    	try {
    		String s = CreditiPuntatiField.getText();
    		a = Integer.parseInt(s); 
    		if(a>0) {
    			if(a<=partita.getCrediti(giocatore))
    				GestoreScene.messaggioConfermaMossa(true, a, partita, giocatore);
    			else {
    				GestoreScene.messaggioErrore("Puntata massima raggiunta: all in!");
    				CreditiPuntatiField.setText(partita.getCrediti(giocatore)+"");
    			}
    		}else
    			throw new Exception();
    	}catch(Exception e) {
    		GestoreScene.messaggioErrore("Inserire un numero intero non nullo");
    	}
    	
    }
    
    @FXML
    void lasciaTurno(ActionEvent event) {
    	GestoreScene.messaggioConfermaMossa(false, 0, partita, giocatore);
    }
    
    @FXML
    void buttonPuntareClicked(ActionEvent event) {
    	if(partita.getCrediti(giocatore) > 0) {
    		
    		CreditiPuntatiField.setVisible(true);
        	confermaButton.setVisible(true);
        	button1.setVisible(true);
        	button100.setVisible(true);
        	button1000.setVisible(true);
        	button5000.setVisible(true);
        	button10000.setVisible(true);
        	buttonAllIn.setVisible(true);
        	resetCrediti.setVisible(true);

    	}else {
			GestoreScene.messaggioConfermaMossa(true, 0, partita, giocatore);
    	}
    }
    
    @FXML
    void homepageIconClicked(MouseEvent event) {
    	GestoreScene.messaggioRitornoHomepage("Tornando alla homepage \nperderai il turno corrente, \ncontinuare?");    	
    }
    
    @FXML
    void mostraCarteCPU(ActionEvent event) {
    	stampaCarteMano(partita.getMano(giocatore));
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
    void giocaCPU(ActionEvent event) {
    	GiocatoreCPUDifficile g = (GiocatoreCPUDifficile) DBGiocatori.getGiocatore(giocatore);
    	int a = g.giocaTurno(partita,giocatore);
    	GestoreScene.messaggioCPU(true, a, partita, giocatore);
    }
	
    @FXML
    void playButtonClicked(ActionEvent event) {
    	if(DBGiocatori.getGiocatore(giocatore) instanceof GiocatoreFisico)
    		caricaSchermataPlayerFisico();
    	else if(DBGiocatori.getGiocatore(giocatore) instanceof GiocatoreCPUFacile)
    		caricaSchermataPlayerCPUFacile();
    	else if(DBGiocatori.getGiocatore(giocatore) instanceof GiocatoreCPUDifficile)
    		caricaSchermataPlayerCPUDifficile();
    	
    	vboxPlay.setVisible(false);
    }
    
    public void caricaSchermataPlayerCPUFacile() {
    	
    	giocaButtonCPU.setVisible(true);
    	
    	mostraCarteCPUButton.setVisible(true);
    	
    	mostracittaButton.setVisible(true);
    	vboxPlay.setVisible(true);
    	textGiocatoreCorrente.setVisible(true);
    	vboxProssimiGiocatori.setVisible(true);
    	
    	vboxProssimiGiocatori.setVisible(true);
    	
    	textCrediti.setVisible(true);
    	textCrediti.setText("Crediti: " + partita.getCrediti(giocatore));
    }
    
    public void caricaSchermataPlayerCPUDifficile() {
    	
    	giocaButtonCPU.setVisible(true);
    	
    	mostraCarteCPUButton.setVisible(true);
    	
    	mostracittaButton.setVisible(true);
    	vboxPlay.setVisible(true);
    	textGiocatoreCorrente.setVisible(true);
    	vboxProssimiGiocatori.setVisible(true);
    	
    	vboxProssimiGiocatori.setVisible(true);
    	
    	textCrediti.setVisible(true);
    	textCrediti.setText("Crediti: " + partita.getCrediti(giocatore));
    }
    
    public void caricaSchermataPlayerFisico() {
    	
    	stampaCarteMano(partita.getMano(giocatore));
    	
    	mostracittaButton.setVisible(true);
    	buttonLasciare.setVisible(true);
    	buttonPuntare.setVisible(true);
    	vboxPlay.setVisible(true);
    	textGiocatoreCorrente.setVisible(true);
    	vboxProssimiGiocatori.setVisible(true);
    	
    	vboxProssimiGiocatori.setVisible(true);
    	
    	textCrediti.setVisible(true);
    	textCrediti.setText("Crediti: " + partita.getCrediti(giocatore));
    }
    
    public void caricaSchermataDefault(){
    	Image retro = new Image("/immagini/retroCarta.png");
    	Image homePage = new Image("/immagini/homepageIcon.png");
    	
    	iconMano1.setImage(retro);
    	iconMano2.setImage(retro);
    	iconMano3.setImage(retro);
    	iconMano4.setImage(retro);
    	
    	stampaCarteTavolo(partita.getCarteTavolo());
    	
    	homepageIcon.setImage(homePage);
    	
    	vboxPlay.setVisible(true);
    	vboxProssimiGiocatori.setVisible(true);
    	
    	textNumTurno.setText("Turno "+ partita.getTurno());
    	
    	textGiocatoreCorrente.setText(giocatore);
    	String x = "";
    	for(int i = partita.getGiocatoriTurno().indexOf(giocatore)+1; i<partita.getGiocatoriTurno().size(); i++ )
    		x+=partita.getGiocatoriTurno().get(i)+"\n";
    	
    	textProssGiocatori.setText(x);
    	textNome.setText("E' il turno di: " + giocatore);
    	
    	textCrediti.setVisible(false);
    }
    
    private void stampaCarteTavolo(Carta[] carteTavolo) {
    	Image[] carteT = new Image[4];
    	
    	Image retro = new Image("/immagini/retrocarta.png");
    	
    	int j = tavolo+1;
    	
    	for(int i = 0 ; i < j ; i++)
    		carteT[i] = new Image(carteTavolo[i].getPercorso());
    	
    	for(int i = j ; i < carteT.length ; i++)
    		carteT[i] = retro;
    	
    	iconTavolo1.setImage(carteT[0]);
    	iconTavolo2.setImage(carteT[1]);
    	iconTavolo3.setImage(carteT[2]);
    }
    
    private void stampaCarteMano(Carta[] carteMano) {
    	Image[] carteM = new Image[4];
    	
    	for(int i = 0 ; i < carteM.length ; i++)
    		carteM[i] = new Image(carteMano[i].getPercorso());
    	
    	iconMano1.setImage(carteM[0]);
    	iconMano2.setImage(carteM[1]);
    	iconMano3.setImage(carteM[2]);
    	iconMano4.setImage(carteM[3]);
    }
    
    public void setInfo(Partita p, String g) {
    	partita = p;
    	giocatore = g;
    	tavolo = p.getMano();
    }
    
    @FXML
    void initialize() {
    	partita = new Partita();
    	giocatore = "";
    	tavolo = 2;
    	Image retro = new Image("/immagini/retrocarta.png");
    	Image homePage = new Image("/immagini/homepageIcon.png");

    	iconMano1.setImage(retro);
    	iconMano2.setImage(retro);
    	iconMano3.setImage(retro);
    	iconMano4.setImage(retro);
    	iconTavolo1.setImage(retro);
    	iconTavolo1.setImage(retro);
    	iconTavolo2.setImage(retro);
    	iconTavolo3.setImage(retro);
    	
    	homepageIcon.setImage(homePage);
    	
    	vboxPlay.setVisible(false);
    	mostracittaButton.setVisible(false);
    	buttonLasciare.setVisible(false);
    	buttonPuntare.setVisible(false);
    	CreditiPuntatiField.setVisible(false);
    	confermaButton.setVisible(false);
    	vboxProssimiGiocatori.setVisible(false);
    	textCrediti.setVisible(false);
    	
    	button1.setVisible(false);
    	button100.setVisible(false);
    	button1000.setVisible(false);
    	button5000.setVisible(false);
    	button10000.setVisible(false);
    	buttonAllIn.setVisible(false);
    	resetCrediti.setVisible(false);
    	
    	CreditiPuntatiField.setText("0");

    	giocaButtonCPU.setVisible(false);
    	mostraCarteCPUButton.setVisible(false);
    	
    }
    
    @FXML
    void punta1(ActionEvent event) {
    	int a = 0;
    	try {
    		String s = CreditiPuntatiField.getText();
    		if(s.equals(""))
    			a=0;
    		else
    			a = Integer.parseInt(s); 
    		a+=1;
    		if(a<=partita.getCrediti(giocatore))
    			CreditiPuntatiField.setText(a+"");
			else {
				CreditiPuntatiField.setText(partita.getCrediti(giocatore)+"");
			}
    	}catch(Exception e) {
    		CreditiPuntatiField.setText("1");
    	}
    }

    @FXML
    void punta100(ActionEvent event) {
    	int a = 0;
    	try {
    		String s = CreditiPuntatiField.getText();
    		if(s.equals(""))
    			a=0;
    		else
    			a = Integer.parseInt(s); 
    		a+=100;
    		if(a<=partita.getCrediti(giocatore))
    			CreditiPuntatiField.setText(a+"");
			else {
				CreditiPuntatiField.setText(partita.getCrediti(giocatore)+"");
			}
    	}catch(Exception e) {
    		CreditiPuntatiField.setText("100");
    	}
    }

    @FXML
    void punta1000(ActionEvent event) {
    	int a = 0;
    	try {
    		String s = CreditiPuntatiField.getText();
    		if(s.equals(""))
    			a=0;
    		else
    			a = Integer.parseInt(s); 
    		a+=1000;
    		if(a<=partita.getCrediti(giocatore))
    			CreditiPuntatiField.setText(a+"");
			else {
				CreditiPuntatiField.setText(partita.getCrediti(giocatore)+"");
			}
    	}catch(Exception e) {
    		CreditiPuntatiField.setText("1000");
    	}
    }

    @FXML
    void punta10000(ActionEvent event) {
    	int a = 0;
    	try {
    		String s = CreditiPuntatiField.getText();
    		if(s.equals(""))
    			a=0;
    		else
    			a = Integer.parseInt(s); 
    		a+=10000;
    		if(a<=partita.getCrediti(giocatore))
    			CreditiPuntatiField.setText(a+"");
			else {
				CreditiPuntatiField.setText(partita.getCrediti(giocatore)+"");
			}
    	}catch(Exception e) {
    		CreditiPuntatiField.setText("10000");
    	}
    }

    @FXML
    void punta5000(ActionEvent event) {
    	int a = 0;
    	try {
    		String s = CreditiPuntatiField.getText();
    		if(s.equals(""))
    			a=0;
    		else
    			a = Integer.parseInt(s); 
    		a+=5000;
    		if(a<=partita.getCrediti(giocatore))
    			CreditiPuntatiField.setText(a+"");
			else {
				CreditiPuntatiField.setText(partita.getCrediti(giocatore)+"");
			}
    	}catch(Exception e) {
    		CreditiPuntatiField.setText("5000");
    	}
    }
    
    @FXML
    void puntaTutto(ActionEvent event) {
    	CreditiPuntatiField.setText(partita.getCrediti(giocatore)+"");
    }
    
    @FXML
    void resetCrediti(ActionEvent event) {
    	CreditiPuntatiField.setText("0");
    }

}

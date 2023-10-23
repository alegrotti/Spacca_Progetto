package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import model.Giocatore;
import model.GiocatoreFisico;
import model.GiocatoreCPUFacile;
import model.GiocatoreCPUDifficile;
import model.Carta;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.GestoreFile;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;

public class AdminAreaController {
	
	private ArrayList<Carta> carteMazzo;
	
	@FXML
    private VBox centralBox;

    @FXML
    private Button eliminaMazzoButton;

    @FXML
    private TextField codicePartitaField;

    @FXML
    private Label creaGiocatoreTitolo;

    @FXML
    private Label creaNuovaPartitaTitolo;

    @FXML
    private Button eliminaGiocatoreButton;

    @FXML
    private Label fraseSliderLabel;

    @FXML
    private HBox hBoxDifficolta;

    @FXML
    private HBox hBoxSliderPartita;

    @FXML
    private Button homeButton;

    @FXML
    private Label infoAdminTitolo;

    @FXML
    private Label infoGiocatore;

    @FXML
    private ComboBox<String> listaGiocatoriButton;

    @FXML
    private ComboBox<String> listaGiocatoriNuovaPartitaButton;

    @FXML
    private Label listaGiocatoriTitolo;

    @FXML
    private Label numeroSliderPartitaLabel;

    @FXML
    private TextField nuovoGiocatoreField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button saveInfoButton;

    @FXML
    private Button savePlayerButton;

    @FXML
    private ComboBox<String> scegliGiocatoriPartitaButton;

    @FXML
    private ComboBox<String> scegliMazzoPartitaButton;

    @FXML
    private ComboBox<String> selezionaDifficoltaButton;

    @FXML
    private Pane sfondo;

    @FXML
    private Slider sliderPartita;

    @FXML
    private TabPane tabPane;

    @FXML
    private ComboBox<String> tipoDiGiocatoreButton;

    @FXML
    private ComboBox<String> tipoPartitaButton;

    @FXML
    private Label titolo;

    @FXML
    private TextField usernameField;
    
    @FXML
    private Button aggiungiCartaButton;

    @FXML
    private Label gestisciMazzoTitolo;

    @FXML
    private Label gestisciMazzoTitolo1;

    @FXML
    private Label gestisciMazzoTitolo11;

    @FXML
    private Label infoCartaDaAggiungere;

    @FXML
    private Label infoCartaDelMazzo;

    @FXML
    private ComboBox<String> listaCarteDaAggiungere;

    @FXML
    private ComboBox<String> listaCarteMazzo;

    @FXML
    private ComboBox<String> listaMazziButton;

    @FXML
    private TextField nomeMazzo;

    @FXML
    private Button rimuoviCartaDalMazzoButton;

    @FXML
    private Button salvaMazzoButton;

    
    //Admin
    @FXML
    void saveNewInfo(ActionEvent event) {
    	
    	WelcomeController.admin.setPassword(passwordField.getText());
    	WelcomeController.admin.setUsername(usernameField.getText());
    	
    	GestoreFile gestoreFile = new GestoreFile();
    	gestoreFile.salvaAdmin(WelcomeController.admin);
    	
    	inizializzaProfilo();
    }
    
    //Giocatore
    @FXML
    void aggiungiGiocatore(ActionEvent event) {
    	String tipoGiocatore = tipoDiGiocatoreButton.getValue();
    	if("Reale".equals(tipoGiocatore)) {
    		String username = nuovoGiocatoreField.getText();
    		if(!username.equals("")) {
    			Giocatore g = new GiocatoreFisico(username);
				WelcomeController.admin.aggiungiGiocatore(g);
		    	GestoreFile gestoreFile = new GestoreFile();
		    	gestoreFile.salvaAdmin(WelcomeController.admin);
    		}
    	}else{
    		String difficolta = selezionaDifficoltaButton.getValue();
    		if("Facile".equals(difficolta)) {
	    		String username = nuovoGiocatoreField.getText();
	    		if(!username.equals("")) {
	    			Giocatore g = new GiocatoreCPUFacile(username);
					WelcomeController.admin.aggiungiGiocatore(g);
			    	GestoreFile gestoreFile = new GestoreFile();
			    	gestoreFile.salvaAdmin(WelcomeController.admin);
	    		}
    		}else if("Difficile".equals(difficolta)){
    			String username = nuovoGiocatoreField.getText();
	    		if(!username.equals("")) {
	    			Giocatore g = new GiocatoreCPUDifficile(username);
					WelcomeController.admin.aggiungiGiocatore(g);
			    	GestoreFile gestoreFile = new GestoreFile();
			    	gestoreFile.salvaAdmin(WelcomeController.admin);
	    		}
    		}else {
    			
    		}
    	}
    	inizializzaNuovoGiocatore();
    }

    @FXML
    void eliminaGiocatore(ActionEvent event) {
    	String username = listaGiocatoriButton.getValue();
    	
    	WelcomeController.admin.eliminaGiocatore(username);
    	
    	GestoreFile gestoreFile = new GestoreFile();
    	gestoreFile.salvaAdmin(WelcomeController.admin);
    	
    	inizializzaNuovoGiocatore();
    }

    @FXML
    void selezionaTipoGiocatore(ActionEvent event) {
    	if("CPU".equals(tipoDiGiocatoreButton.getValue())) {
    		hBoxDifficolta.setVisible(true);
    	}else {
    		hBoxDifficolta.setVisible(false);
    	}
    	
    }
    
    @FXML
    void giocatoreSelezionato(ActionEvent event) {
    	
    	String username = listaGiocatoriButton.getValue();
    	
    	Giocatore g = WelcomeController.admin.getGiocatore(username);
    	
    	String testo = "";
    	if(g instanceof GiocatoreFisico)
    		testo = "Giocatore fisico";
    	else if(g instanceof GiocatoreCPUFacile)
    		testo = "Giocatore CPU\nDifficoltà facile";
    	else if(g instanceof GiocatoreCPUDifficile)
    		testo = "Giocatore CPU\nDifficoltà difficile";
    	
    	infoGiocatore.setText(testo);;
    }
    
    //Mazzo
    @FXML
    void eliminaMazzo(ActionEvent event) {
    	String mazzo = listaMazziButton.getValue();
    	
    	WelcomeController.admin.eliminaMazzo(mazzo);
    	
    	GestoreFile gestoreFile = new GestoreFile();
    	gestoreFile.salvaAdmin(WelcomeController.admin);
    	
    	inizializzaGestioneMazzi();
    }
    
    @FXML
    void cartaSelezionata(ActionEvent event) {
    	
    	String s = listaCarteDaAggiungere.getValue();
    	Carta c = WelcomeController.admin.getCarta(s);
    	
    	if(c!=null) {
    	
	    	String stampa =
	    			"Residenziale : "+c.getResidenziale()+
			    	"\nCommerciale : "+c.getCommerciale()+
			    	"\nPubblico : "+c.getPubblico()+
			    	"\nCulturale : "+c.getCulturale();
	    	
	    	infoCartaDaAggiungere.setText(stampa);
    	}
    }
    
    @FXML
    void aggiungiCartaAlMazzo(ActionEvent event) {
    	String carta = listaCarteDaAggiungere.getValue();
    	carteMazzo.add(WelcomeController.admin.getCarta(carta));
    	inizializzaGestioneMazzi();
    }
    
    @FXML
    void rimuoviCartaDalMazzo(ActionEvent event) {
    	
    	String carta = listaCarteMazzo.getValue();
    	
    	Carta c = WelcomeController.admin.getCarta(carta);
    	
    	carteMazzo.remove(c);
    	carteMazzo.trimToSize();
    	
    	GestoreFile gestoreFile = new GestoreFile();
    	gestoreFile.salvaAdmin(WelcomeController.admin);
    	
    	inizializzaGestioneMazzi();
    	
    }
    
    @FXML
    void cartaDelMazzoSelezionata(ActionEvent event) {
    	
    	String s = listaCarteMazzo.getValue();
    	Carta c = WelcomeController.admin.getCarta(s);
    	
    	if(c!=null) {
    	
	    	String stampa =
	    			"Residenziale : "+c.getResidenziale()+
			    	"\nCommerciale : "+c.getCommerciale()+
			    	"\nPubblico : "+c.getPubblico()+
			    	"\nCulturale : "+c.getCulturale();
	    	
	    	infoCartaDelMazzo.setText(stampa);
    	}
    	
    }
    
    
    //Partita
    @FXML
    void generaCodiceRandom(ActionEvent event) {
    	String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	    Random random = new Random();
	    char[] code = new char[8];

	    for (int i = 0; i < 8; i++) {
	        code[i] = characters.charAt(random.nextInt(characters.length()));
	    }

	    codicePartitaField.setText(new String(code));
    }
    
    @FXML
    void scegliTipoPartita(ActionEvent event) {
    	if("A turni".equals(tipoPartitaButton.getValue())) {
    		hBoxSliderPartita.setVisible(true);
    		fraseSliderLabel.setText("Numero turni: ");
    		sliderPartita.setMin(4);
    		sliderPartita.setMax(50);
    	}else if("A palazzi".equals(tipoPartitaButton.getValue())) {
    		hBoxSliderPartita.setVisible(true);
    		fraseSliderLabel.setText("Numero palazzi: ");
    		sliderPartita.setMin(3);
    		sliderPartita.setMax(20);
    	}
    }
    
    
    //Torneo
    
    

    @FXML
    void cartaDaAggiungereSelezionata(ActionEvent event) {

    }

    @FXML
    void salvaMazzo(ActionEvent event) {
    	
    }

	@FXML
    void aggiungiPartita(ActionEvent event) {

    }

    @FXML
    void eliminaGiocatoreNuovaPartita(ActionEvent event) {

    }

    @FXML
    void scegliGiocatorePartita(ActionEvent event) {

    }

    @FXML
    void scegliMazzoPartita(ActionEvent event) {

    }
    
    
    //Generale e inizializzazione
    @FXML
    void backWelcome(ActionEvent event) {
    	try {
	    	Parent root = FXMLLoader.load(getClass().getResource("/view/Welcome.fxml"));
	        Scene scenaHomepage = new Scene(root);
	        scenaHomepage.getStylesheets().add("/view/welcome.css");
	        GestoreScene gestoreScene = new GestoreScene ();
	        gestoreScene.setScene(scenaHomepage,false);
    	}catch(Exception e) {
    		
    	}
    }
    
    @FXML
    void initialize() {
    	
    	carteMazzo = new ArrayList<Carta>();
    	
    	//Profilo
    	inizializzaProfilo();
    	
    	//Nuovo giocatore
    	inizializzaNuovoGiocatore();
    	
    	//Nuova Partita
    	inizializzaNuovaPartita();
    	
    	//Gestione Mazzi
    	inizializzaGestioneMazzi();
    	
    }
    
    private void inizializzaProfilo() {
    	usernameField.setText(WelcomeController.admin.getUsername());
    	passwordField.setText(WelcomeController.admin.getPassword());
    }
    
    private void inizializzaNuovoGiocatore() {
    	tipoDiGiocatoreButton.setValue(null);
    	selezionaDifficoltaButton.setValue(null);
    	listaGiocatoriButton.setValue(null);
    	nuovoGiocatoreField.setText(null);
    	
    	ObservableList<String> difficolta = FXCollections.observableArrayList("Facile","Difficile");
    	selezionaDifficoltaButton.setItems(difficolta); 
    	
    	ObservableList<String> tipoGiocatore = FXCollections.observableArrayList("CPU","Reale");
    	tipoDiGiocatoreButton.setItems(tipoGiocatore);
    	
    	ObservableList<String> giocatori = FXCollections.observableArrayList();
    	for(String s : WelcomeController.admin.getGiocatori().keySet())
    		giocatori.add(s);
    	giocatori.sort(null);
    	listaGiocatoriButton.setItems(giocatori);
    	
    	hBoxDifficolta.setVisible(false);
    }
    
    private void inizializzaNuovaPartita() {
    	tipoPartitaButton.setValue(null);
    	scegliMazzoPartitaButton.setValue(null);
    	scegliGiocatoriPartitaButton.setValue(null);
    	
    	ObservableList<String> mazzo = FXCollections.observableArrayList();
    	
    	ObservableList<String> tipoPartita = FXCollections.observableArrayList("A turni","A palazzi");
    	tipoPartitaButton.setItems(tipoPartita);
    	
    	scegliMazzoPartitaButton.setItems(mazzo);
    	
    	ObservableList<String> giocatori = FXCollections.observableArrayList();
    	for(String s : WelcomeController.admin.getGiocatori().keySet())
    		giocatori.add(s);
    	giocatori.sort(null);
    	
    	scegliGiocatoriPartitaButton.setItems(giocatori);
    	
    	hBoxSliderPartita.setVisible(false);
    	
    	numeroSliderPartitaLabel.setText(String.valueOf((int) sliderPartita.getValue()));
    	sliderPartita.valueProperty().addListener((observable, oldValue, newValue) -> {
            int roundedValue = (int) Math.round(newValue.doubleValue());
            numeroSliderPartitaLabel.setText(String.valueOf(roundedValue));
        });
    }
    
    
    private void inizializzaGestioneMazzi() {
    	
    	nomeMazzo.setText(null);
    	listaMazziButton.setValue(null);
    	listaCarteDaAggiungere.setValue(null);
    	listaCarteMazzo.setValue(null);
    	infoCartaDelMazzo.setText(null);
    	infoCartaDaAggiungere.setText(null);
    	
    	
    	ObservableList<String> mazzi = FXCollections.observableArrayList();
    	for(String s : WelcomeController.admin.getMazzi().keySet())
    		mazzi.add(s);
    	mazzi.sort(null);
    	listaMazziButton.setItems(mazzi);
    	
    	
    	ObservableList<String> carteAggiunte = FXCollections.observableArrayList();
    	for(int i = 0; i<carteMazzo.size(); i++)
    		carteAggiunte.add(carteMazzo.get(i).getNome());
    	carteAggiunte.sort(null);
    	listaCarteMazzo.setItems(carteAggiunte);

    	ObservableList<String> carteCreate = FXCollections.observableArrayList();
    	for(String s : WelcomeController.admin.getCarte().keySet())
    		carteCreate.add(s);
    	carteCreate.sort(null);
    	listaCarteDaAggiungere.setItems(carteCreate);   

    }
    
}


package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import model.Giocatore;
import model.GiocatoreFisico;
import model.Mazzo;
import model.GiocatoreCPUFacile;
import model.GiocatoreCPUDifficile;
import model.Carta;
import model.DBAdmin;
import model.DBCarte;
import model.DBGiocatori;
import model.DBMazzi;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;

public class AdminAreaController {
	
	private ArrayList<Carta> carteMazzo;
	private HashMap<String,Giocatore> giocatoriAggiunti;

    @FXML
    private Button aggiungiCartaButton;

    @FXML
    private Label carteAggiungibiliLabel;

    @FXML
    private Label carteMazzoLabel;

    @FXML
    private VBox centralBox;

    @FXML
    private TextField codicePartitaField;

    @FXML
    private Label creaGiocatoreTitolo;

    @FXML
    private Label creaNuovaPartitaTitolo;

    @FXML
    private Button eliminaGiocatoreButton;

    @FXML
    private Button eliminaMazzoButton;

    @FXML
    private Label fraseSliderLabel;

    @FXML
    private Label gestisciMazzoTitolo;

    @FXML
    private ComboBox<String> giocatoriDaAggiungere;

    @FXML
    private ComboBox<String> giocatoriPartita;

    @FXML
    private HBox hBoxDifficolta;

    @FXML
    private HBox hBoxSliderPartita;

    @FXML
    private Button homeButton;

    @FXML
    private Label infoAdminTitolo;

    @FXML
    private Label infoCartaDaAggiungere;

    @FXML
    private Label infoCartaDelMazzo;

    @FXML
    private Label infoGiocatore;

    @FXML
    private ComboBox<String> listaCarteDaAggiungere;

    @FXML
    private ComboBox<String> listaCarteMazzo;

    @FXML
    private ComboBox<String> listaGiocatoriButton;

    @FXML
    private Label listaGiocatoriTitolo;

    @FXML
    private ComboBox<String> listaMazziButton;

    @FXML
    private TextField nomeMazzo;

    @FXML
    private Label numeroSliderPartitaLabel;

    @FXML
    private TextField nuovoGiocatoreField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button rimuoviCartaDalMazzoButton;

    @FXML
    private Button salvaMazzoButton;

    @FXML
    private Button saveInfoButton;

    @FXML
    private Button savePlayerButton;

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
    private Slider sliderCreditiPartita;
    
    @FXML
    private Label creditiSliderLabel;
    
    
    //Admin
    @FXML
    void saveNewInfo(ActionEvent event) {
    	
    	DBAdmin.getAdmin().setPassword(passwordField.getText());
    	DBAdmin.getAdmin().setUsername(usernameField.getText());
    	
    	inizializzaSchermata();
    	
    }
    
    //Giocatore
    @FXML
    void aggiungiGiocatore(ActionEvent event) {
    	String tipoGiocatore = tipoDiGiocatoreButton.getValue();
    	if("Reale".equals(tipoGiocatore)) {
    		String username = nuovoGiocatoreField.getText();
    		if(!username.equals("")) {
    			Giocatore g = new GiocatoreFisico(username);
    			DBGiocatori.aggiungiGiocatore(g);
    			DBAdmin.getAdmin().aggiungiGiocatore(g);
    		}
    	}else{
    		String difficolta = selezionaDifficoltaButton.getValue();
    		if("Facile".equals(difficolta)) {
	    		String username = nuovoGiocatoreField.getText();
	    		if(!username.equals("")) {
	    			Giocatore g = new GiocatoreCPUFacile(username);
	    			DBGiocatori.aggiungiGiocatore(g);
	    			DBAdmin.getAdmin().aggiungiGiocatore(g);
	    		}
    		}else if("Difficile".equals(difficolta)){
    			String username = nuovoGiocatoreField.getText();
	    		if(!username.equals("")) {
	    			Giocatore g = new GiocatoreCPUDifficile(username);
	    			DBGiocatori.aggiungiGiocatore(g);
	    			DBAdmin.getAdmin().aggiungiGiocatore(g);
	    		}
    		}else {
    			
    		}
    	}
    	inizializzaSchermata();
    }
    
    @FXML
    void eliminaGiocatore(ActionEvent event) {
    	String username = listaGiocatoriButton.getValue();
    	
    	DBAdmin.getAdmin().eliminaGiocatore(username);
    	
    	DBAdmin.salvaAdmin(DBAdmin.getAdmin());
    	
    	inizializzaSchermata();
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
    	
    	Giocatore g = DBGiocatori.getGiocatore(username);
    	
    	String testo = "";
    	if(g instanceof GiocatoreFisico)
    		testo = "Giocatore fisico";
    	else if(g instanceof GiocatoreCPUFacile)
    		testo = "Giocatore CPU\nDifficoltà facile";
    	else if(g instanceof GiocatoreCPUDifficile)
    		testo = "Giocatore CPU\nDifficoltà difficile";
    	
    	infoGiocatore.setText(testo);
    }
    
    //Mazzo
    @FXML
    void salvaMazzo(ActionEvent event) {
    	try {
    		String nomeMazzo = this.nomeMazzo.getText();
    		if(!nomeMazzo.equals("")) {
    			if(carteMazzo.size()!=0) {
    				Mazzo m = new Mazzo(nomeMazzo,carteMazzo);
    				DBAdmin.getAdmin().aggiungiMazzo(m);
    				DBMazzi.aggiungiMazzo(m);
	    		}else {
	    			throw new Exception("Mazzo vuoto");
	    		}
    		}else {
    			throw new Exception("Inserire nome mazzo");
    		}
    		inizializzaGestioneMazzi();
    	}catch(Exception e) {
    		Main.messaggioErrore(e.getMessage());
    	}
    }
    
    @FXML
    void eliminaMazzo(ActionEvent event) {
    	String mazzo = listaMazziButton.getValue();
    	
    	DBMazzi.eliminaMazzo(mazzo);
    	
    	DBAdmin.getAdmin().eliminaMazzo(mazzo);
    	
    	inizializzaSchermata();
    }
    
    @FXML
    void cartaSelezionata(ActionEvent event) {
    	
    	String s = listaCarteDaAggiungere.getValue();
    	Carta c = DBCarte.getCarta(s);
    	
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
    	carteMazzo.add(DBCarte.getCarta(carta));
    	String s = nomeMazzo.getText();
    	inizializzaGestioneMazzi();
    	nomeMazzo.setText(s);
    }
    
    @FXML
    void cartaDaAggiungereSelezionata(ActionEvent event) {
    	String s = listaCarteDaAggiungere.getValue();
    	Carta c = DBCarte.getCarta(s);
    	
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
    void rimuoviCartaDalMazzo(ActionEvent event) {
    	
    	String carta = listaCarteMazzo.getValue();
    	
    	Carta c = DBCarte.getCarta(carta);
    	
    	carteMazzo.remove(c);
    	carteMazzo.trimToSize();
    	
    	inizializzaGestioneMazzi();
    	
    }
    
    @FXML
    void cartaDelMazzoSelezionata(ActionEvent event) {
    	
    	String s = listaCarteMazzo.getValue();
    	Carta c = DBCarte.getCarta(s);
    	
    	if(c!=null) {
    	
	    	String stampa =
	    			"Residenziale : "+c.getResidenziale()+
			    	"\nCommerciale : "+c.getCommerciale()+
			    	"\nPubblico : "+c.getPubblico()+
			    	"\nCulturale : "+c.getCulturale();
	    	
	    	infoCartaDelMazzo.setText(stampa);
    	}
    	
    }
    
    @FXML
    void modificaMazzo(ActionEvent event){
    	/*
    	String nome = listaMazziButton.getValue();
    	
    	Mazzo m = DBMazzi.getMazzo(nome);
    	
    	System.out.println(m.getNome());
    	
    	
    	carteMazzo.clear();
    	carteMazzo.addAll(m.getCarte());
    	
    	inizializzaGestioneMazzi();
    	
    	nomeMazzo.setText(m.getNome());
    	*/
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
    void aggiungiGiocatorePartita(ActionEvent event) {
    	String giocatore = giocatoriDaAggiungere.getValue();
    	giocatoriAggiunti.put(giocatore,DBGiocatori.getGiocatore(giocatore));

    	ObservableList<String> giocatori2 = FXCollections.observableArrayList();
    	for(String s : giocatoriAggiunti.keySet())
    		giocatori2.add(s);
    	giocatori2.sort(null);
    	giocatoriPartita.setItems(giocatori2);
    	
    	giocatoriDaAggiungere.setValue(null);
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
    
    @FXML
    void eliminaGiocatoreNuovaPartita(ActionEvent event) {
    	try {
			String giocatore = giocatoriPartita.getValue();
			if(giocatore.equalsIgnoreCase(""))
				throw new Exception("Nessun giocatore selezionato");
			giocatoriAggiunti.remove(giocatore);
		
			ObservableList<String> giocatori2 = FXCollections.observableArrayList();
			for(String s : giocatoriAggiunti.keySet())
				giocatori2.add(s);
			giocatori2.sort(null);
			giocatoriPartita.setItems(giocatori2);
			
			giocatoriPartita.setValue(null);
			giocatoriDaAggiungere.setValue(null);
    	}catch(Exception e) {
    		Main.messaggioErrore(e.getMessage());
    	}
    }
    
    
    //Torneo
    


	@FXML
    void aggiungiPartita(ActionEvent event) {

    }

    @FXML
    void scegliGiocatorePartita(ActionEvent event) {

    }
    
    //Generale e inizializzazione
    @FXML
    void backWelcome(ActionEvent event) {
    	try {
	    	Parent root = FXMLLoader.load(getClass().getResource("/view/Welcome.fxml"));
	        Scene scenaHomepage = new Scene(root);
	        scenaHomepage.getStylesheets().add("/view/welcome.css");
	        Main.setScene(scenaHomepage,false);
    	}catch(Exception e) {
    		
    	}
    }
    
    @FXML
    void initialize() {
    	
    	carteMazzo = new ArrayList<Carta>();
    	giocatoriAggiunti = new HashMap<String,Giocatore>();
    	
    	inizializzaSchermata();
    	
    }
    
    private void inizializzaSchermata() {
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
    	usernameField.setText(DBAdmin.getAdmin().getUsername());
    	passwordField.setText(DBAdmin.getAdmin().getPassword());
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
    	for(String s : DBAdmin.getAdmin().getGiocatori())
    		giocatori.add(s);
    	giocatori.sort(null);
    	listaGiocatoriButton.setItems(giocatori);
    	
    	hBoxDifficolta.setVisible(false);
    }
    
    private void inizializzaNuovaPartita() {
    	tipoPartitaButton.setValue(null);
    	scegliMazzoPartitaButton.setValue(null);
    	giocatoriPartita.setValue(null);
    	giocatoriDaAggiungere.setValue(null);
    	
    	ObservableList<String> mazzi = FXCollections.observableArrayList();
    	for(String s : DBAdmin.getAdmin().getMazzi())
    		mazzi.add(s);
    	mazzi.sort(null);
    	scegliMazzoPartitaButton.setItems(mazzi);
    	
    	ObservableList<String> tipoPartita = FXCollections.observableArrayList("A turni","A palazzi");
    	tipoPartitaButton.setItems(tipoPartita);
    	
    	ObservableList<String> giocatori1 = FXCollections.observableArrayList();
    	for(String s : DBAdmin.getAdmin().getGiocatori())
    		giocatori1.add(s);
    	giocatori1.sort(null);
    	giocatoriDaAggiungere.setItems(giocatori1);
    	
    	ObservableList<String> giocatori2 = FXCollections.observableArrayList();
    	for(String s : giocatoriAggiunti.keySet())
    		giocatori2.add(s);
    	giocatori2.sort(null);
    	giocatoriPartita.setItems(giocatori2);
    	
    	hBoxSliderPartita.setVisible(false);
    	
    	numeroSliderPartitaLabel.setText(String.valueOf((int) sliderPartita.getValue()));
    	sliderPartita.valueProperty().addListener((observable, oldValue, newValue) -> {
            int roundedValue = (int) Math.round(newValue.doubleValue());
            numeroSliderPartitaLabel.setText(String.valueOf(roundedValue));
        });
    	
    	sliderCreditiPartita.setMin(1);
    	sliderCreditiPartita.setMax(100);
    	sliderCreditiPartita.setValue(0);
    	creditiSliderLabel.setText(String.valueOf((int) sliderCreditiPartita.getValue()));
    	sliderCreditiPartita.valueProperty().addListener((observable, oldValue, newValue) -> {
            int roundedValue = (int) (Math.round(newValue.doubleValue()*1000));
            creditiSliderLabel.setText(String.valueOf(roundedValue));
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
    	for(String s : DBAdmin.getAdmin().getMazzi())
    		mazzi.add(s);
    	mazzi.sort(null);
    	listaMazziButton.setItems(mazzi);
    	
    	ObservableList<String> carteAggiunte = FXCollections.observableArrayList();
    	for(int i = 0; i<carteMazzo.size(); i++)
    		carteAggiunte.add(carteMazzo.get(i).getNome());
    	carteAggiunte.sort(null);
    	listaCarteMazzo.setItems(carteAggiunte);

    	ObservableList<String> carteCreate = FXCollections.observableArrayList();
    	for(String s : DBAdmin.getAdmin().getCarte())
    		carteCreate.add(s);
    	carteCreate.sort(null);
    	listaCarteDaAggiungere.setItems(carteCreate);   

    }
    
}


package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.util.ArrayList;
import java.util.Random;
import model.Giocatore;
import model.GiocatoreFisico;
import model.GiocatoreCPUFacile;
import model.GiocatoreCPUDifficile;
import model.DBAdmin;
import model.DBGiocatori;
import model.DBPartite;
import model.DBTornei;
import model.Partita;
import model.PartitaAPalazzi;
import model.PartitaATurni;
import model.Torneo;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;

public class AdminAreaController {
	
	private ArrayList<String> giocatoriAggiunti;

	@FXML
    private VBox centralBox;

    @FXML
    private Label codiceLabel;

    @FXML
    private Label codiceLabelTitolo;

    @FXML
    private Label codiceLabelTitoloTorneo;

    @FXML
    private Label codiceLabelTorneo;

    @FXML
    private TextField codicePartitaField;

    @FXML
    private ComboBox<String> codicePartitaInCorso;

    @FXML
    private TextField codiceTorneoField;

    @FXML
    private ComboBox<String> codiceTorneoInCorso;

    @FXML
    private Label creaGiocatoreTitolo;

    @FXML
    private Label creaNuovaPartitaTitolo;

    @FXML
    private Label creaNuovoTorneoTitolo;

    @FXML
    private Label creditiInizialiLabel;

    @FXML
    private Label creditiInizialiLabelTitolo;

    @FXML
    private Label creditiInizialiLabelTitoloTorneo;

    @FXML
    private Label creditiInizialiLabelTorneo;

    @FXML
    private Label creditiSliderLabel;

    @FXML
    private Label creditiSliderLabelTorneo;

    @FXML
    private Button eliminaGiocatoreButton;

    @FXML
    private Label fraseSliderLabel;

    @FXML
    private Label fraseSliderLabel1;

    @FXML
    private ComboBox<String> giocatoriDaAggiungere;

    @FXML
    private ComboBox<String> giocatoriDaAggiungereTorneo;

    @FXML
    private Label giocatoriLabel;

    @FXML
    private Label giocatoriLabelTitolo;

    @FXML
    private Label giocatoriLabelTitoloTorneo;

    @FXML
    private Label giocatoriLabelTorneo;

    @FXML
    private HBox hBoxDifficolta;

    @FXML
    private HBox hBoxSliderPartita;

    @FXML
    private HBox hBoxSliderTorneo;

    @FXML
    private Button homeButton;

    @FXML
    private Label infoAdminTitolo;

    @FXML
    private Label infoGiocatore;

    @FXML
    private VBox infoPartita1;

    @FXML
    private VBox infoPartita2;

    @FXML
    private VBox infoTorneo1;

    @FXML
    private VBox infoTorneo2;

    @FXML
    private ComboBox<String> listaGiocatoriButton;

    @FXML
    private ListView<String> listaGiocatoriPartita;

    @FXML
    private Label listaGiocatoriTitolo;

    @FXML
    private ListView<String> listaGiocatoriTorneo;

    @FXML
    private Label numeroSliderPartitaLabel;

    @FXML
    private Label numeroSliderTorneo;

    @FXML
    private TextField nuovoGiocatoreField;

    @FXML
    private Label partitaInCorsoTitolo;

    @FXML
    private TextField passwordField;

    @FXML
    private Button saveInfoButton;

    @FXML
    private Button savePlayerButton;

    @FXML
    private ComboBox<String> selezionaDifficoltaButton;

    @FXML
    private Pane sfondo;

    @FXML
    private Slider sliderCreditiPartita;

    @FXML
    private Slider sliderCreditiTorneo;

    @FXML
    private Slider sliderPartita;

    @FXML
    private Slider sliderTorneo;

    @FXML
    private Label statoPartitaLabel;

    @FXML
    private Label statoPartitaLabelTitolo;

    @FXML
    private Label statoTorneoLabel;

    @FXML
    private Label statoTorneoLabelTitolo;

    @FXML
    private TabPane tabPane;

    @FXML
    private ComboBox<String> tipoDiGiocatoreButton;

    @FXML
    private ComboBox<String> tipoPartitaButton;

    @FXML
    private Label tipoPartitaLabel;

    @FXML
    private Label tipoPartitaLabelTitolo;

    @FXML
    private ComboBox<String> tipoTorneoButton;

    @FXML
    private Label tipoTorneoLabel;

    @FXML
    private Label tipoTorneoLabelTitolo;

    @FXML
    private Label titolo;

    @FXML
    private Label torneoInCorsoTitolo;

    @FXML
    private TextField usernameField;

    
    
    //Admin
    @FXML
    void saveNewInfo(ActionEvent event) {
    	
    	DBAdmin.setPassword(passwordField.getText());
    	DBAdmin.setUsername(usernameField.getText());
    	
    	inizializzaSchermata();
    	
    }
    
    //Giocatore
    @FXML
    void aggiungiGiocatore(ActionEvent event) {
    	try {
	    	String tipoGiocatore = tipoDiGiocatoreButton.getValue();
	    	if("Reale".equals(tipoGiocatore)) {
	    		String username = nuovoGiocatoreField.getText();
	    		if(!username.isBlank()) {
	    			Giocatore g = new GiocatoreFisico(username);
	    			DBGiocatori.aggiungiGiocatore(g);
	    			DBAdmin.aggiungiGiocatore(g);
	    		} else {
	    			GestoreScene.messaggioErrore("Inserisci nome");
	    		}
	    	}else if("CPU".equals(tipoGiocatore)){
	    		String difficolta = selezionaDifficoltaButton.getValue();
	    		if("Facile".equals(difficolta)) {
		    		String username = nuovoGiocatoreField.getText();
		    		if(!username.isBlank()) {
		    			Giocatore g = new GiocatoreCPUFacile(username);
		    			DBGiocatori.aggiungiGiocatore(g);
		    			DBAdmin.aggiungiGiocatore(g);
		    		}else {
		    			GestoreScene.messaggioErrore("Inserisci nome");
		    		}
	    		}else if("Difficile".equals(difficolta)){
	    			String username = nuovoGiocatoreField.getText();
		    		if(!username.isBlank()) {
		    			Giocatore g = new GiocatoreCPUDifficile(username);
		    			DBGiocatori.aggiungiGiocatore(g);
		    			DBAdmin.aggiungiGiocatore(g);
		    		}else {
		    			GestoreScene.messaggioErrore("Inserisci nome");
		    		}
	    		}else {
	    			GestoreScene.messaggioErrore("Seleziona difficoltà");	
    			}
	    	}else {
    			GestoreScene.messaggioErrore("Seleziona tipo");	
			}
	    	inizializzaSchermata();
    	}catch(Exception e) {
    		GestoreScene.messaggioErrore("Errore creazione giocatore");
		}
    }
    
    @FXML
    void eliminaGiocatore(ActionEvent event) {
    	String username = listaGiocatoriButton.getValue();
    	if(username==null)
    		GestoreScene.messaggioErrore("Seleziona giocatore");
    	DBAdmin.eliminaGiocatore(username);
    	DBGiocatori.eliminaGiocatore(username);
    	
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
    
    //Partita
    @FXML
    void generaCodiceRandom(ActionEvent event) {
    	String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	    Random random = new Random();
	    char[] code = new char[8];
	    code[0] = 'P';
	    

	    for (int i = 1; i < 7; i++) {
	        code[i] = characters.charAt(random.nextInt(characters.length()));
	    }

	    codicePartitaField.setText(new String(code));
    }
    
    @FXML
    void aggiungiGiocatorePartita(ActionEvent event) {
    	try {
	    	
    		String giocatore = giocatoriDaAggiungere.getValue();
    		
    		if (giocatore.equals(""))
    			throw new Exception();
    		else
    			giocatoriAggiunti.add(giocatore);
	    	
	    	ObservableList<String> giocatori2 = FXCollections.observableArrayList();
	    	for(String s : giocatoriAggiunti)
	    		giocatori2.add(s);
	    	giocatori2.sort(null);
	    	listaGiocatoriTorneo.setItems(giocatori2);
	    	
	    	giocatoriDaAggiungere.setValue(null);
	    	
    	}catch(Exception e) {
    		GestoreScene.messaggioErrore("Errore aggiunta giocatore");
    	}
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
			String giocatore = listaGiocatoriPartita.getSelectionModel().getSelectedItem();
			if(giocatore.equalsIgnoreCase(""))
				throw new Exception("Nessun giocatore selezionato");
			giocatoriAggiunti.remove(giocatore);
		
			ObservableList<String> giocatori2 = FXCollections.observableArrayList();
			for(String s : giocatoriAggiunti)
				giocatori2.add(s);
			giocatori2.sort(null);
			listaGiocatoriPartita.setItems(giocatori2);
			
			giocatoriDaAggiungere.setValue(null);
    	}catch(Exception e) {
    		GestoreScene.messaggioErrore(e.getMessage());
    	}
    }
    
	@FXML
    void aggiungiPartita(ActionEvent event) {
		try {
			String codice = codicePartitaField.getText();
			int n = Integer.parseInt(creditiSliderLabel.getText());
			if(n<1000)
				GestoreScene.messaggioErrore("Scegliere numero crediti");
			else if(!codice.equals(""))
				if(!DBAdmin.getAdmin().getPartite().contains(codice)) {
					if(tipoPartitaButton.getValue().equals("A turni")) {
						int turni = Integer.parseInt(numeroSliderPartitaLabel.getText());
						if(giocatoriAggiunti.size()>1) {
							giocatoriAggiunti.sort(null);
							Partita p = new PartitaATurni(giocatoriAggiunti,codice,turni,n);
							DBPartite.aggiungiPartita(p);
							DBAdmin.aggiungiPartita(p);
							inizializzaSchermata();
						}else {
							GestoreScene.messaggioErrore("Aggiungi almeno 2 giocatori");
						}
					}else if(tipoPartitaButton.getValue().equals("A palazzi")) {
						int palazzi = Integer.parseInt(numeroSliderPartitaLabel.getText());
						if(giocatoriAggiunti.size()>1) {	
							Partita p = new PartitaAPalazzi(giocatoriAggiunti,codice,palazzi,n);
							DBPartite.aggiungiPartita(p);
							DBAdmin.aggiungiPartita(p);
							inizializzaSchermata();
						}else 
							GestoreScene.messaggioErrore("Aggiungi almeno 2 giocatori");

					}else {
						GestoreScene.messaggioErrore("");
					}
				}else {
					GestoreScene.messaggioErrore("Codice già esistente");
				}
			else
				GestoreScene.messaggioErrore("Inserisci codice non nullo");
		}catch(Exception e) {
			GestoreScene.messaggioErrore("Errore creazione partita");
		}
    }
    
	//Partita in corso
	
    @FXML
    void copiaCodicePartita(ActionEvent event) {
    	if(codicePartitaInCorso.getValue() != null) {
    		 String testoDaCopiare = codiceLabel.getText();
	         Clipboard clipboard = Clipboard.getSystemClipboard();
	         ClipboardContent content = new ClipboardContent();
	         content.putString(testoDaCopiare);
	         clipboard.setContent(content);
    	 }else {
    		 GestoreScene.messaggioErrore("Seleziona partita");
    	 }
    }
	
    @FXML
    void eliminaPartita(ActionEvent event) {
    	String partita = codicePartitaInCorso.getValue();
    	
    	DBPartite.eliminaPartita(partita);
    	
    	DBAdmin.eliminaPartita(partita);
    	
    	inizializzaSchermata();
    }
	
    @FXML
    void mostraPartitaInCorso(ActionEvent event) {
    	String partita = codicePartitaInCorso.getValue();
    	Partita p = DBPartite.getPartita(partita);
    	if (p!=null) {
    		codiceLabel.setText(p.getCodice());
    		String gioc="";
    		for(String s : p.getGiocatori())
    			gioc+=(s+"\n");
    		giocatoriLabel.setText(gioc);
    		if(p instanceof PartitaAPalazzi) {
    			PartitaAPalazzi p1 = (PartitaAPalazzi) p;
    			tipoPartitaLabel.setText("A palazzi - "+p1.getPalazzi()+" palazzi");
    		}
    		else {
    			PartitaATurni p1 = (PartitaATurni) p;
    			tipoPartitaLabel.setText("A turni - "+p1.getTurni()+" turni");
    		}
    		creditiInizialiLabel.setText(p.getCreditiIniziali()+" crediti");
    		int turnoCorrente = p.getTurno();
    		if (turnoCorrente==0)
    			statoPartitaLabel.setText("Da iniziare");
    		else if(!p.isCompletata())
    			statoPartitaLabel.setText("In corso - Turno "+turnoCorrente);
    		else
    			statoPartitaLabel.setText("Terminata");
    	}
    }
    
    //Torneo
    
    @FXML
    void aggiungiGiocatoreTorneo(ActionEvent event) {
    	try {
    		String giocatore = giocatoriDaAggiungereTorneo.getValue();
    		
    		if (giocatore.equals(""))
    			throw new Exception();
    		else
    			giocatoriAggiunti.add(giocatore);
	    	
	    	ObservableList<String> giocatori2 = FXCollections.observableArrayList();
	    	for(String s : giocatoriAggiunti)
	    		giocatori2.add(s);
	    	giocatori2.sort(null);
	    	listaGiocatoriTorneo.setItems(giocatori2);
	    	
	    	giocatoriDaAggiungereTorneo.setValue(null);
	    	
    	}catch(Exception e) {
    		GestoreScene.messaggioErrore("Errore aggiunta giocatore");
    	}
    }
    
    @FXML
    void aggiungiTorneo(ActionEvent event) {
    	try {
			String codice = codiceTorneoField.getText();
			int n = Integer.parseInt(creditiSliderLabelTorneo.getText());
			if(n<1000)
				GestoreScene.messaggioErrore("Scegliere numero crediti");
			else if(!codice.equals(""))
				if(!DBAdmin.getAdmin().getTornei().contains(codice)) {
					if(tipoTorneoButton.getValue().equals("A turni")) {
						int turni = Integer.parseInt(numeroSliderTorneo.getText());
						if(giocatoriAggiunti.size()>1) {
							giocatoriAggiunti.sort(null);
							Torneo t = new Torneo("Turni",giocatoriAggiunti,codice,turni,n);
							DBTornei.aggiungiTorneo(t);
							DBAdmin.aggiungiTorneo(t);
							inizializzaSchermata();
						}else {
							GestoreScene.messaggioErrore("Aggiungi almeno 2 giocatori");
						}
					}else if(tipoTorneoButton.getValue().equals("A palazzi")) {
						int palazzi = Integer.parseInt(numeroSliderTorneo.getText());
						if(giocatoriAggiunti.size()>1) {	
							Torneo t = new Torneo("Palazzi",giocatoriAggiunti,codice,palazzi,n);
							DBTornei.aggiungiTorneo(t);
							DBAdmin.aggiungiTorneo(t);
							inizializzaSchermata();
						}else 
							GestoreScene.messaggioErrore("Aggiungi almeno 2 giocatori");

					}else {
						GestoreScene.messaggioErrore("");
					}
				}else {
					GestoreScene.messaggioErrore("Codice già esistente");
				}
			else
				GestoreScene.messaggioErrore("Inserisci codice non nullo");
		}catch(Exception e) {
			System.out.println(e.getMessage());
			//GestoreScene.messaggioErrore("Errore creazione torneo");
		}
    }
    
    @FXML
    void eliminaGiocatoreNuovoTorneo(ActionEvent event) {
    	try {
			String giocatore = listaGiocatoriTorneo.getSelectionModel().getSelectedItem();
			if(giocatore.equalsIgnoreCase(""))
				throw new Exception("Nessun giocatore selezionato");
			giocatoriAggiunti.remove(giocatore);
		
			ObservableList<String> giocatori2 = FXCollections.observableArrayList();
			for(String s : giocatoriAggiunti)
				giocatori2.add(s);
			giocatori2.sort(null);
			listaGiocatoriTorneo.setItems(giocatori2);
			
			giocatoriDaAggiungere.setValue(null);
    	}catch(Exception e) {
    		GestoreScene.messaggioErrore(e.getMessage());
    	}
    }
    
    @FXML
    void scegliTipoTorneo(ActionEvent event) {
    	if("A turni".equals(tipoTorneoButton.getValue())) {
    		hBoxSliderTorneo.setVisible(true);
    		fraseSliderLabel1.setText("Numero turni: ");
    		sliderTorneo.setMin(4);
    		sliderTorneo.setMax(50);
    	}else if("A palazzi".equals(tipoTorneoButton.getValue())) {
    		hBoxSliderTorneo.setVisible(true);
    		fraseSliderLabel1.setText("Numero palazzi: ");
    		sliderTorneo.setMin(3);
    		sliderTorneo.setMax(20);
    	}
    }
    
    @FXML
    void generaCodiceRandomTorneo(ActionEvent event) {
    	String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	    Random random = new Random();
	    char[] codeTorneo = new char[8];
	    codeTorneo[0] = 'T';
	    

	    for (int i = 1; i < 7; i++) {
	        codeTorneo[i] = characters.charAt(random.nextInt(characters.length()));
	    }

	    codiceTorneoField.setText(new String(codeTorneo));
    }
        
    //Torneo in corso
    @FXML
    void mostraTorneoInCorso(ActionEvent event) {
    	String torneo = codiceTorneoInCorso.getValue();
    	Torneo t = DBTornei.getTorneo(torneo); //
    	if (t!=null) {
    		codiceLabelTorneo.setText(t.getCodice());
    		String gioc="";
    		for(String s : t.getGiocatori())
    			gioc+=(s+"\n");
    		giocatoriLabelTorneo.setText(gioc);
    		if(t.getTipo().equals("A palazzi")) {
    			tipoTorneoLabel.setText("A palazzi - "+t.getObiettivo()+" palazzi");
    		}else {
    			tipoTorneoLabel.setText("A turni - "+t.getObiettivo()+" turni");
    		}
    		creditiInizialiLabelTorneo.setText(t.getCreditiIniziali()+" crediti");
    		
    	}
    }
    
    @FXML
    void eliminaTorneo(ActionEvent event) {
    	String torneo = codiceTorneoInCorso.getValue();
    	
    	DBTornei.eliminaTorneo(torneo);
    	
    	DBAdmin.eliminaTorneo(torneo);
    	
    	inizializzaSchermata();
    }
    
    @FXML
    void copiaCodiceTorneo(ActionEvent event) {
    	if(codiceTorneoInCorso.getValue() != null) {
   		 	String testoDaCopiare = codiceLabelTorneo.getText();
	        Clipboard clipboard = Clipboard.getSystemClipboard();
	        ClipboardContent content = new ClipboardContent();
	        content.putString(testoDaCopiare);
	        clipboard.setContent(content);
	   	}else {
	   		GestoreScene.messaggioErrore("Seleziona torneo");
	   	}
    }
    
    //Generale e inizializzazione
    @FXML
    void backWelcome(ActionEvent event) {
    	GestoreScene.welcome(false);
    }
    
    @FXML
    void initialize() {
    	
    	giocatoriAggiunti = new ArrayList<String>();
    	
    	inizializzaSchermata();
    	
    }
    
    private void inizializzaSchermata() {
    	//Profilo
    	inizializzaProfilo();
    	
    	//Nuovo giocatore
    	inizializzaNuovoGiocatore();
    	
    	//Nuova Partita
    	inizializzaNuovaPartita();
    	
    	//Partite in corso
    	inizializzaPartiteInCorso();
    	
    	//Nuovo Torneo
    	inizializzaNuovoTorneo();
    	
    	//Tornei in corso
    	inizializzaTorneoInCorso();
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
    	giocatoriDaAggiungere.setValue(null);
    	codicePartitaField.setText(null);
    	
    	ObservableList<String> tipoPartita = FXCollections.observableArrayList("A turni","A palazzi");
    	tipoPartitaButton.setItems(tipoPartita);
    	
    	ObservableList<String> giocatori1 = FXCollections.observableArrayList();
    	for(String s : DBAdmin.getAdmin().getGiocatori())
    		giocatori1.add(s);
    	giocatori1.sort(null);
    	giocatoriDaAggiungere.setItems(giocatori1);
    	
    	ObservableList<String> giocatori2 = FXCollections.observableArrayList();
    	for(String s : giocatoriAggiunti)
    		giocatori2.add(s);
    	giocatori2.sort(null);
    	listaGiocatoriPartita.setItems(giocatori2);
    	
    	hBoxSliderPartita.setVisible(false);
    	
    	numeroSliderPartitaLabel.setText(String.valueOf((int) sliderPartita.getValue()));
    	sliderPartita.valueProperty().addListener((observable, oldValue, newValue) -> {
            int roundedValue = (int) Math.round(newValue.doubleValue());
            numeroSliderPartitaLabel.setText(String.valueOf(roundedValue));
        });
    	
    	sliderCreditiPartita.setMin(1);
    	sliderCreditiPartita.setMax(100);
    	sliderCreditiPartita.setValue(50*1000);
    	creditiSliderLabel.setText(String.valueOf((int) sliderCreditiPartita.getValue()));
    	sliderCreditiPartita.valueProperty().addListener((observable, oldValue, newValue) -> {
            int roundedValue = (int) (Math.round(newValue.doubleValue()));
            creditiSliderLabel.setText(String.valueOf(roundedValue*1000));
        });
    }
    
    private void inizializzaNuovoTorneo() {
    	tipoTorneoButton.setValue(null);
    	giocatoriDaAggiungere.setValue(null);
    	codiceTorneoField.setText(null);
    	
    	ObservableList<String> tipoTorneo = FXCollections.observableArrayList("A turni","A palazzi");
    	tipoTorneoButton.setItems(tipoTorneo);
    	
    	ObservableList<String> giocatori1 = FXCollections.observableArrayList();
    	for(String s : DBAdmin.getAdmin().getGiocatori())
    		giocatori1.add(s);
    	giocatori1.sort(null);
    	giocatoriDaAggiungereTorneo.setItems(giocatori1);
    	ObservableList<String> giocatori2 = FXCollections.observableArrayList();
    	for(String s : giocatoriAggiunti)
    		giocatori2.add(s);
    	giocatori2.sort(null);
    	listaGiocatoriTorneo.setItems(giocatori2);
    	
    	hBoxSliderTorneo.setVisible(false);
    	
    	numeroSliderTorneo.setText(String.valueOf((int) sliderTorneo.getValue()));
    	sliderTorneo.valueProperty().addListener((observable, oldValue, newValue) -> {
            int roundedValue = (int) Math.round(newValue.doubleValue());
            numeroSliderTorneo.setText(String.valueOf(roundedValue));
        });
    	
    	sliderCreditiTorneo.setMin(1);
    	sliderCreditiTorneo.setMax(100);
    	sliderCreditiTorneo.setValue(50*1000);
    	creditiSliderLabelTorneo.setText(String.valueOf((int) sliderCreditiTorneo.getValue()));
    	sliderCreditiTorneo.valueProperty().addListener((observable, oldValue, newValue) -> {
            int roundedValue = (int) (Math.round(newValue.doubleValue()));
            creditiSliderLabelTorneo.setText(String.valueOf(roundedValue*1000));
        });
    }
    
    private void inizializzaPartiteInCorso(){
    	ObservableList<String> partite = FXCollections.observableArrayList();
    	for(String s : DBAdmin.getAdmin().getPartite())
    		partite.add(s);
    	partite.sort(null);
    	codicePartitaInCorso.setItems(partite);
    	
    	codiceLabel.setText(null);
        giocatoriLabel.setText(null);
        statoPartitaLabel.setText(null);
        creditiInizialiLabel.setText(null);
        tipoPartitaLabel.setText(null);
    }
    
   private void inizializzaTorneoInCorso(){
    	ObservableList<String> tornei = FXCollections.observableArrayList();
    	for(String s : DBAdmin.getAdmin().getTornei())
    		tornei.add(s);
    	tornei.sort(null);
    	codiceTorneoInCorso.setItems(tornei);
    	
    	codiceLabelTorneo.setText(null);
        giocatoriLabelTorneo.setText(null);
        statoTorneoLabel.setText(null);
        creditiInizialiLabelTorneo.setText(null);
        tipoTorneoLabel.setText(null);
    }
    
}

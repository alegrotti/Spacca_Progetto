package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import java.util.ArrayList;
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
import model.DBPartite;
import model.Partita;
import model.PartitaAPalazzi;
import model.PartitaATurni;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
	
	private ArrayList<Carta> carteMazzo;
	private ArrayList<String> giocatoriAggiunti;

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
    
    @FXML
    private ComboBox<String> codicePartitaInCorso;
    
    @FXML
    private Label partitaInCorsoTitolo;
    
    @FXML
    private VBox infoPartita1;

    @FXML
    private VBox infoPartita2;
    
    @FXML
    private Label codiceLabel;

    @FXML
    private Label codiceLabelTitolo;
    
    @FXML
    private Label giocatoriLabel;

    @FXML
    private Label giocatoriLabelTitolo;
    
    @FXML
    private Label statoPartitaLabel;

    @FXML
    private Label statoPartitaLabelTitolo;

    @FXML
    private Label creditiInizialiLabel;

    @FXML
    private Label creditiInizialiLabelTitolo;
    
    @FXML
    private Label tipoPartitaLabel;

    @FXML
    private Label tipoPartitaLabelTitolo;
    
    @FXML
    private ListView<String> listaGiocatoriPartita;
    
    
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
    	String tipoGiocatore = tipoDiGiocatoreButton.getValue();
    	if("Reale".equals(tipoGiocatore)) {
    		String username = nuovoGiocatoreField.getText();
    		if(!username.equals("")) {
    			Giocatore g = new GiocatoreFisico(username);
    			DBGiocatori.aggiungiGiocatore(g);
    			DBAdmin.aggiungiGiocatore(g);
    		}
    	}else{
    		String difficolta = selezionaDifficoltaButton.getValue();
    		if("Facile".equals(difficolta)) {
	    		String username = nuovoGiocatoreField.getText();
	    		if(!username.equals("")) {
	    			Giocatore g = new GiocatoreCPUFacile(username);
	    			DBGiocatori.aggiungiGiocatore(g);
	    			DBAdmin.aggiungiGiocatore(g);
	    		}
    		}else if("Difficile".equals(difficolta)){
    			String username = nuovoGiocatoreField.getText();
	    		if(!username.equals("")) {
	    			Giocatore g = new GiocatoreCPUDifficile(username);
	    			DBGiocatori.aggiungiGiocatore(g);
	    			DBAdmin.aggiungiGiocatore(g);
	    		}
    		}else {
    			
    		}
    	}
    	inizializzaSchermata();
    }
    
    @FXML
    void eliminaGiocatore(ActionEvent event) {
    	String username = listaGiocatoriButton.getValue();
    	
    	DBAdmin.eliminaGiocatore(username);
    	
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
    				DBAdmin.aggiungiMazzo(m);
    				DBMazzi.aggiungiMazzo(m);
	    		}else {
	    			throw new Exception("Mazzo vuoto");
	    		}
    		}else {
    			throw new Exception("Inserire nome mazzo");
    		}
    		inizializzaGestioneMazzi();
    	}catch(Exception e) {
    		GestoreScene.messaggioErrore(e.getMessage());
    	}
    }
    
    @FXML
    void eliminaMazzo(ActionEvent event) {
    	String mazzo = listaMazziButton.getValue();
    	
    	DBMazzi.eliminaMazzo(mazzo);
    	
    	DBAdmin.eliminaMazzo(mazzo);
    	
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
    	
    	rimuoviDaMazzo(c);
    	
    	String s = nomeMazzo.getText();
    	inizializzaGestioneMazzi();
    	nomeMazzo.setText(s);
    	
    }
    
    private void rimuoviDaMazzo(Carta carta) {
    	int x = 0;
    	for(Carta c : carteMazzo)
    		if(c.getNome().equals(carta.getNome()))
    			break;
    		else
    			x++;
    	carteMazzo.remove(x);
    	carteMazzo.trimToSize();
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
    	String nome = listaMazziButton.getValue();
    	
    	Mazzo m = DBMazzi.getMazzo(nome);
    	
    	if(m!=null) {
	    	nomeMazzo.setText(m.getNome());
	    	
	    	carteMazzo= m.getCarte();
	    	
	    	ObservableList<String> carteAggiunte = FXCollections.observableArrayList();
	    	for(int i = 0; i<carteMazzo.size(); i++)
	    		carteAggiunte.add(carteMazzo.get(i).getNome());
	    	carteAggiunte.sort(null);
	    	listaCarteMazzo.setItems(carteAggiunte);
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
    void aggiungiGiocatorePartita(ActionEvent event) {
    	String giocatore = giocatoriDaAggiungere.getValue();
    	giocatoriAggiunti.add(giocatore);

    	ObservableList<String> giocatori2 = FXCollections.observableArrayList();
    	for(String s : giocatoriAggiunti)
    		giocatori2.add(s);
    	giocatori2.sort(null);
    	listaGiocatoriPartita.setItems(giocatori2);
    	
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
			Mazzo m = DBMazzi.getMazzo(scegliMazzoPartitaButton.getValue());
			String codice = codicePartitaField.getText();
			if(!DBAdmin.getAdmin().getPartite().contains(codice)) {
				int n = Integer.parseInt(creditiSliderLabel.getText());
				if(tipoPartitaButton.getValue().equals("A turni")) {
					int turni = Integer.parseInt(numeroSliderPartitaLabel.getText());
					Partita p = new PartitaATurni(m,giocatoriAggiunti,codice,turni,n);
					DBPartite.aggiungiPartita(p);
					DBAdmin.aggiungiPartita(p);
				}else if(tipoPartitaButton.getValue().equals("A palazzi")) {
					int palazzi = Integer.parseInt(numeroSliderPartitaLabel.getText());
					Partita p = new PartitaAPalazzi(m,giocatoriAggiunti,codice,palazzi,n);
					DBPartite.aggiungiPartita(p);
					DBAdmin.aggiungiPartita(p);
				}else {
					throw new Exception();
				}
				inizializzaSchermata();
			}else {
				GestoreScene.messaggioErrore("Codice già esistente");
			}
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
    			statoPartitaLabel.setText("Da iniziare - Turno "+turnoCorrente);
    		else
    			statoPartitaLabel.setText("In corso - Turno "+turnoCorrente);
    	}
    }
    
    //Torneo
    

    
    
    
    //Generale e inizializzazione
    @FXML
    void backWelcome(ActionEvent event) {
    	try {
	    	Parent root = FXMLLoader.load(getClass().getResource("/view/Welcome.fxml"));
	        Scene scenaHomepage = new Scene(root);
	        scenaHomepage.getStylesheets().add("/view/welcome.css");
	        GestoreScene.setScene(scenaHomepage,false," - Homepage");
    	}catch(Exception e) {
    		GestoreScene.messaggioErrore("Errore apertura finestra");
    	}
    }
    
    @FXML
    void initialize() {
    	
    	carteMazzo = new ArrayList<Carta>();
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
    	
    	//Gestione Mazzi
    	inizializzaGestioneMazzi();
    	
    	//Partite in corso
    	inizializzaPartiteInCorso();
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
    	giocatoriDaAggiungere.setValue(null);
    	codicePartitaField.setText(null);
    	
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
    	sliderCreditiPartita.setValue(0);
    	creditiSliderLabel.setText(String.valueOf((int) sliderCreditiPartita.getValue()));
    	sliderCreditiPartita.valueProperty().addListener((observable, oldValue, newValue) -> {
            int roundedValue = (int) (Math.round(newValue.doubleValue()));
            creditiSliderLabel.setText(String.valueOf(roundedValue*1000));
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
    
}


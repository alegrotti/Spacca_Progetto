package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Random;
import model.Giocatore;
import model.GiocatoreFisico;
import model.Gruppo;
import model.Special;
import model.GiocatoreCPUFacile;
import model.GiocatoreCPUDifficile;
import model.Carta;
import model.Building;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import model.GestoreFile;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;

public class AdminAreaController {

	private static Path origine;
	private static Path destinazione;
	
    @FXML
    private VBox centralBox;

    @FXML
    private TextField codicePartitaField;

    @FXML
    private Label creaGiocatoreTitolo;
    
    @FXML
    private Label creaNuovaPartitaTitolo;
    
    @FXML
    private TextArea descrizioneCartaTesto;

    @FXML
    private Button eliminaGiocatoreButton;

    @FXML
    private Label fraseSliderLabel;

    @FXML
    private Button homeButton;
    
    @FXML
    private HBox hBoxIcona;

    @FXML
    private HBox hBoxDifficolta;
    
    @FXML
    private HBox hBoxSliderPartita;
    
    @FXML
    private HBox hBoxPuntiCommerciale;

    @FXML
    private HBox hBoxPuntiCulturale;

    @FXML
    private HBox hBoxPuntiPubblico;

    @FXML
    private HBox hBoxPuntiResidenziale;

    @FXML
    private Label infoAdminTitolo;

    @FXML
    private Label infoGiocatore;

    @FXML
    private ComboBox<String> listaGiocatoriButton;

    @FXML
    private ComboBox<String> listaCarteNuovaPartitaButton;

    @FXML
    private ComboBox<String> listaGiocatoriNuovaPartitaButton2;

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
    private TextField codicePartitaField1;

    @FXML
    private Label creaNuovaCartaTitolo;

    @FXML
    private ComboBox<String> genereNuovaCarta;

    @FXML
    private Label labelPunteggioCommerciale;

    @FXML
    private Label labelPunteggioCulturale;

    @FXML
    private Label labelPunteggioResidenziale;
    
    @FXML
    private Label labelPunteggioPubblico;

    @FXML
    private ComboBox<String> listaCarteCreaCarta;

    @FXML
    private ComboBox<String> listaGiocatoriNuovaPartitaButton;

    @FXML
    private Slider sliderPunteggioCommerciale;

    @FXML
    private Slider sliderPunteggioCulturale;

    @FXML
    private Slider sliderPunteggioPubblico;

    @FXML
    private Slider sliderPunteggioResidenziale;

    @FXML
    private ComboBox<String> tipoNuovaCarta;
    
    @FXML
    private TextField nomeNuovaCarta;
    
    @FXML
    private Label iconaCaricataMessaggio;

    @FXML
    void caricaIconaNuovaCarta(ActionEvent event) {
    	FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Immagini", "*.jpg", "*.png", "*.jpeg"));
        File selectedFile = fileChooser.showOpenDialog(Main.parentWindow);

        if (selectedFile != null) {
            String selectedFilePath = selectedFile.getAbsolutePath();

            String percorsoProgetto = System.getProperty("user.dir");
            String percorsoCartellaDestinazione = percorsoProgetto + "/src/immagini";

            AdminAreaController.origine = Path.of(selectedFilePath);

			AdminAreaController.destinazione = Paths.get(percorsoCartellaDestinazione, origine.getFileName().toString());

			iconaCaricataMessaggio.setText(selectedFilePath);
        }
    }
    
    
    @FXML
    void creaCarta(ActionEvent event) {
    	
    	try {
    		Carta c = new Carta();
    		String nomeCarta = nomeNuovaCarta.getText();
    		String descrizioneCarta = descrizioneCartaTesto.getText();
    		int resi = Integer.parseInt(labelPunteggioResidenziale.getText());
        	int comm = Integer.parseInt(labelPunteggioResidenziale.getText());
        	int pubb = Integer.parseInt(labelPunteggioResidenziale.getText());
        	int cult = Integer.parseInt(labelPunteggioResidenziale.getText());
        	if("Edificio".equals(tipoNuovaCarta.getValue())) {
        		switch(genereNuovaCarta.getValue()) {
        			case "Residenziale" :
        				c = new Building(nomeCarta,descrizioneCarta,resi,comm,pubb,cult,Gruppo.Residenziale,destinazione.toString());
        				break;
        			case "Commerciale" :
        				c = new Building(nomeCarta,descrizioneCarta,resi,comm,pubb,cult,Gruppo.Commerciale,destinazione.toString());
        				break;
        			case "Pubblico" :
        				c = new Building(nomeCarta,descrizioneCarta,resi,comm,pubb,cult,Gruppo.Pubblico,destinazione.toString());
        				break;
        			case "Culturale" :
        				c = new Building(nomeCarta,descrizioneCarta,resi,comm,pubb,cult,Gruppo.Culturale,destinazione.toString());
        				break;
        		}
        	}else{
        		if("Bonus".equals(genereNuovaCarta.getValue())) {
    	    		c = new Special(nomeCarta,descrizioneCarta,resi,comm,pubb,cult,true,"percorso_bonus");
        		}else if("Malus".equals(genereNuovaCarta.getValue())){
        			c = new Special(nomeCarta,descrizioneCarta,resi,comm,pubb,cult,true,"percorso_malus");
        		}else {
        			
        		}
        	}
        	WelcomeController.admin.aggiungiCarta(c);
	    	GestoreFile gestoreFile = new GestoreFile();
	    	gestoreFile.salvaAdmin(WelcomeController.admin);
	    	Files.copy(origine, destinazione, StandardCopyOption.REPLACE_EXISTING);

	    	inizializzaCreaCarta();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
        
    	inizializzaCreaCarta();
    	
    }

    @FXML
    void eliminaCartaNuovaCarta(ActionEvent event) {
    	String nomeCarta = listaCarteCreaCarta.getValue();
    	
    	Carta c = WelcomeController.admin.getCarta(nomeCarta);
    	
    	WelcomeController.admin.eliminaCarta(nomeCarta);
    	
    	if(c instanceof Building) {
    		Building b = (Building)c;
    		String percorsoFoto = b.getPercorso();
            try {
                Files.deleteIfExists(Paths.get(percorsoFoto));
            } catch (IOException e) {
                e.printStackTrace();
            }
    	}
    	
    	GestoreFile gestoreFile = new GestoreFile();
    	gestoreFile.salvaAdmin(WelcomeController.admin);
    	
    	inizializzaCreaCarta();
    }

    @FXML
    void scegliGenereNuovaCarta(ActionEvent event) {

    }

    @FXML
    void scegliTipoNuovaCarta(ActionEvent event) {
    	if("Edificio".equals(tipoNuovaCarta.getValue())) {
    		ObservableList<String> genereCarta = FXCollections.observableArrayList("Residenziale","Commerciale","Pubblico","Culturale");
    		genereNuovaCarta.setItems(genereCarta);
        	sliderPunteggioCommerciale.setMax(10);
        	sliderPunteggioPubblico.setMax(10);
        	sliderPunteggioResidenziale.setMax(10);
        	sliderPunteggioCulturale.setMax(10);
        	hBoxIcona.setVisible(true);
    	}else if("Special".equals(tipoNuovaCarta.getValue())) {
    		ObservableList<String> genereCarta = FXCollections.observableArrayList("Bonus","Malus");
    		genereNuovaCarta.setItems(genereCarta);
    		sliderPunteggioCommerciale.setMax(4);
        	sliderPunteggioPubblico.setMax(4);
        	sliderPunteggioResidenziale.setMax(4);
        	sliderPunteggioCulturale.setMax(4);
        	hBoxIcona.setVisible(false);
    	}
    }
    
    @FXML
    void aggiungiPartita(ActionEvent event) {

    }

    @FXML
    void eliminaCarteNuovaPartita(ActionEvent event) {

    }

    @FXML
    void eliminaGiocatoreNuovaPartita(ActionEvent event) {

    }

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
    void scegliGiocatorePartita(ActionEvent event) {

    }

    @FXML
    void scegliMazzoPartita(ActionEvent event) {

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
    
    @FXML
    void saveNewInfo(ActionEvent event) {
    	
    	WelcomeController.admin.setPassword(passwordField.getText());
    	WelcomeController.admin.setUsername(usernameField.getText());
    	
    	GestoreFile gestoreFile = new GestoreFile();
    	gestoreFile.salvaAdmin(WelcomeController.admin);
    	
    	inizializzaProfilo();
    	
    }

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
    	
    	//Profilo
    	inizializzaProfilo();
    	
    	//Nuovo giocatore
    	inizializzaNuovoGiocatore();
    	
    	//Nuova Partita
    	inizializzaNuovaPartita();
    	
    	//Nuova carta
    	inizializzaCreaCarta();
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
    
    private void inizializzaCreaCarta() {
    	nomeNuovaCarta.setText(null);
    	descrizioneCartaTesto.setText(null);
    	tipoNuovaCarta.setValue(null);
    	listaCarteCreaCarta.setValue(null);
    	genereNuovaCarta.setValue(null);
    	
    	ObservableList<String> tipoCarta = FXCollections.observableArrayList("Edificio","Special");
    	tipoNuovaCarta.setItems(tipoCarta); 
    	
    	ObservableList<String> carteCreate = FXCollections.observableArrayList();
    	for(String s : WelcomeController.admin.getCarte().keySet())
    		carteCreate.add(s);
    	carteCreate.sort(null);
    	listaCarteCreaCarta.setItems(carteCreate);
    	
    	hBoxIcona.setVisible(false);
    	
    	sliderPunteggioCommerciale.setMin(0);
    	sliderPunteggioResidenziale.setMin(0);
    	sliderPunteggioCulturale.setMin(0);
    	sliderPunteggioPubblico.setMin(0);
    	
    	inizializzaSlider(labelPunteggioCommerciale,sliderPunteggioCommerciale);
    	inizializzaSlider(labelPunteggioResidenziale,sliderPunteggioResidenziale);
    	inizializzaSlider(labelPunteggioCulturale,sliderPunteggioCulturale);
    	inizializzaSlider(labelPunteggioPubblico,sliderPunteggioPubblico);
    }
    
    private void inizializzaSlider(Label label, Slider slider){
    	slider.setValue(0);
    	label.setText(String.valueOf((int) slider.getValue()));
    	slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            int roundedValue = (int) Math.round(newValue.doubleValue());
            label.setText(String.valueOf(roundedValue));
        });
    	slider.setMin(0);
    	slider.setMax(10);
    }

}

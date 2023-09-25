package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import java.util.Random;
import model.Giocatore;
import model.GiocatoreFisico;
import model.GiocatoreCPUFacile;
import model.GiocatoreCPUDifficile;
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

	private static ObservableList<String> giocatoriPartita;
	private static ObservableList<String> cartePartita;
	
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
    private Label fraseSliderLabel;

    @FXML
    private Button homeButton;

    @FXML
    private HBox hBoxDifficolta;
    
    @FXML
    private HBox hBoxSliderPartita;

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
    	ObservableList<String> giocatori = FXCollections.observableArrayList();
    	for(String s : WelcomeController.admin.getGiocatori().keySet())
    		giocatori.add(s);
    	giocatori.sort(null);
    	listaGiocatoriButton.setItems(giocatori);
    	scegliGiocatoriPartitaButton.setItems(giocatori);
    	nuovoGiocatoreField.clear();
    	tipoDiGiocatoreButton.setValue(null);
    }

    @FXML
    void eliminaGiocatore(ActionEvent event) {
    	String username = listaGiocatoriButton.getValue();
    	
    	WelcomeController.admin.eliminaGiocatore(username);
    	
    	GestoreFile gestoreFile = new GestoreFile();
    	gestoreFile.salvaAdmin(WelcomeController.admin);
    	
    	ObservableList<String> giocatori = FXCollections.observableArrayList();
    	for(String s : WelcomeController.admin.getGiocatori().keySet())
    		giocatori.add(s);
    	giocatori.sort(null);
    	listaGiocatoriButton.setItems(giocatori);
    	scegliGiocatoriPartitaButton.setItems(giocatori);
    	listaGiocatoriButton.setValue(null);
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
    	
    	usernameField.setText(WelcomeController.admin.getUsername());
    	passwordField.setText(WelcomeController.admin.getPassword());
    	
    	//Nuovo giocatore
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
    	
    	//Nuova Partita
    	ObservableList<String> mazzo = FXCollections.observableArrayList();
    	
    	ObservableList<String> tipoPartita = FXCollections.observableArrayList("A turni","A palazzi");
    	tipoPartitaButton.setItems(tipoPartita);
    	
    	scegliMazzoPartitaButton.setItems(mazzo);
    	
    	scegliGiocatoriPartitaButton.setItems(giocatori);
    	
    	hBoxSliderPartita.setVisible(false);
    	
    	numeroSliderPartitaLabel.setText(String.valueOf((int) sliderPartita.getValue()));
    	sliderPartita.valueProperty().addListener((observable, oldValue, newValue) -> {
            int roundedValue = (int) Math.round(newValue.doubleValue());
            numeroSliderPartitaLabel.setText(String.valueOf(roundedValue));
        });
    }

}

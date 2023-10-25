package controller;

import java.nio.file.Files;
import java.nio.file.Paths;
import model.GestoreFile;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import model.Carta;
import model.Building;
import model.Special;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class SettingController {

	@FXML
    private Button backButton;

    @FXML
    private VBox centralBox;

    @FXML
    private TextArea descrizione;

    @FXML
    private TextField genere;

    @FXML
    private ComboBox<String> listaCarte;
    
    @FXML
    private Label labelCo;

    @FXML
    private Label labelCu;

    @FXML
    private Label labelPu;

    @FXML
    private Label labelRe;

    @FXML
    private TextField nome;

    @FXML
    private Button saveButton;

    @FXML
    private Pane sfondo;

    @FXML
    private Slider sliderCo;

    @FXML
    private Slider sliderCu;

    @FXML
    private Slider sliderPu;

    @FXML
    private Slider sliderRe;

    @FXML
    private Label titolo;
    
    @FXML
    void cartaScelta(ActionEvent event) {
    	
    	String carta = listaCarte.getValue();
    	
    	Carta c = WelcomeController.admin.getCarta(carta);
    	
    	nome.setText(c.getNome());
		descrizione.setText(c.getDescrizione());
		sliderRe.setValue(c.getResidenziale());
		sliderCo.setValue(c.getCommerciale());
		sliderPu.setValue(c.getPubblico());
		sliderCu.setValue(c.getCulturale());

    }

    @FXML
    void creaBonus(ActionEvent event) {
    	String nomeCarta = nome.getText();
		String descrizioneCarta = descrizione.getText();
		int resi = (int) sliderRe.getValue();
    	int comm = (int) sliderCo.getValue();
    	int pubb = (int) sliderPu.getValue();
    	int cult = (int) sliderCu.getValue();
    	String percorso = "/immagini/cartabonus.jpg";
    	
    	Carta c = new Special(nomeCarta,descrizioneCarta,resi,comm,pubb,cult,true,percorso,"Bonus");
    	
    	WelcomeController.admin.aggiungiCarta(c);
    	GestoreFile gestoreFile = new GestoreFile();
    	gestoreFile.salvaAdmin(WelcomeController.admin);
    	
    	inizializzaFinestra();
    }

    @FXML
    void creaEdificio(ActionEvent event) {

		String nomeCarta = nome.getText();
		String descrizioneCarta = descrizione.getText();
		int resi = (int) sliderRe.getValue();
    	int comm = (int) sliderCo.getValue();
    	int pubb = (int) sliderPu.getValue();
    	int cult = (int) sliderCu.getValue();
    	String percorso = "/immagini/" + nomeCarta.replaceAll("\\s", "").toLowerCase() + ".jpg";
    	Carta c = new Building(nomeCarta,descrizioneCarta,resi,comm,pubb,cult,percorso,genere.getText());
    	
    	WelcomeController.admin.aggiungiCarta(c);
    	GestoreFile gestoreFile = new GestoreFile();
    	gestoreFile.salvaAdmin(WelcomeController.admin);
    	
    	inizializzaFinestra();
    }

    @FXML
    void creaMalus(ActionEvent event) {

    	String nomeCarta = nome.getText();
		String descrizioneCarta = descrizione.getText();
		int resi = (int) sliderRe.getValue();
    	int comm = (int) sliderCo.getValue();
    	int pubb = (int) sliderPu.getValue();
    	int cult = (int) sliderCu.getValue();
    	String percorso = "/immagini/cartamalus.jpg";
    	
    	Carta c = new Special(nomeCarta,descrizioneCarta,resi,comm,pubb,cult,false,percorso,"Malus");
    	
    	WelcomeController.admin.aggiungiCarta(c);
    	GestoreFile gestoreFile = new GestoreFile();
    	gestoreFile.salvaAdmin(WelcomeController.admin);
    	
    	inizializzaFinestra();
    }

    @FXML
    void eliminaCarta(ActionEvent event) {

    	String nomeCarta = listaCarte.getValue();
    	
    	Carta c = WelcomeController.admin.getCarta(nomeCarta);
    	
    	WelcomeController.admin.eliminaCarta(nomeCarta);
    	
    	GestoreFile gestoreFile = new GestoreFile();
    	gestoreFile.salvaAdmin(WelcomeController.admin);
    	
    	inizializzaFinestra();
    	
    }

    @FXML
    void saveNewSettings(ActionEvent event) {

    }

    @FXML
    void tornaWelcome(ActionEvent event) {
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
    	inizializzaFinestra();
    }

    private void inizializzaFinestra() {
    	
    	ObservableList<String> carte = FXCollections.observableArrayList();
    	for(String s : WelcomeController.admin.getCarte().keySet())
    		carte.add(s);
    	carte.sort(null);
    	
    	listaCarte.setItems(carte);
    	
    	inizializzaSlider(labelCo,sliderCo);
    	inizializzaSlider(labelRe,sliderRe);
    	inizializzaSlider(labelCu,sliderCu);
    	inizializzaSlider(labelPu,sliderPu);
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

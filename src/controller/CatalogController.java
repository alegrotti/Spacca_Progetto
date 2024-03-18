package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.Carta;
import model.DBAdmin;
import model.DBCarte;

public class CatalogController {

    @FXML
    private Button backButton;

    @FXML
    private BorderPane bordoFoto;

    @FXML
    private VBox centralBox;

    @FXML
    private Label descrizioneCarta;

    @FXML
    private Label genereCarta;

    @FXML
    private ImageView immagineCarta;

    @FXML
    private VBox infoCarta;

    @FXML
    private ComboBox<String> listaCarte;

    @FXML
    private Pane sfondo;

    @FXML
    private HBox sfondoCarta;

    @FXML
    private Label titolo;

    @FXML
    private Label titoloCarta;

    @FXML
    private Label titoloDescrizione;

    @FXML
    private Label titoloGenere;
    
    @FXML
    private Label titoloPunteggi;
    
    @FXML
    private Label punteggiCarte;

    @FXML
    void initialize() {
    	
    	ObservableList<String> carteCreate = FXCollections.observableArrayList();
    	for(String s : DBAdmin.getAdmin().getCarte())
    		carteCreate.add(s);
    	carteCreate.sort(null);
    	listaCarte.setItems(carteCreate);   
    	
    }
    
    @FXML
    void cartaScelta(ActionEvent event) {
    	String s = listaCarte.getValue();
    	Carta c = DBCarte.getCarta(s);
    	stampaCarta(c);
    	
    }
    
    private void stampaCarta(Carta c) {
    	titoloCarta.setText(c.getNome());

    	descrizioneCarta.setText(c.getDescrizione());
    	
    	punteggiCarte.setText("Residenziale : "+c.getResidenziale()+
		    	"\nCommerciale : "+c.getCommerciale()+
		    	"\nPubblico : "+c.getPubblico()+
		    	"\nCulturale : "+c.getCulturale());

    	genereCarta.setText(c.getGenere());
    	
    	String imageURL = c.getPercorso();
    	
    	System.out.println(c.getPercorso());
        
        Image image = new Image(imageURL);
        immagineCarta.setImage(image);
        immagineCarta.setPreserveRatio(true);
        
    }

    @FXML
    void tornaWelcome(ActionEvent event) {
    	GestoreScene.welcome(false);
    }

}
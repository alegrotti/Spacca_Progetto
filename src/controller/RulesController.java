package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.Carta;
import model.DBAdmin;
import model.DBCarte;

public class RulesController {

    @FXML
    private BorderPane bordoImmagine;
	
    @FXML
    private VBox centralBox;

    @FXML
    private Button homeButton;
    
    @FXML
    private Label descrizioneCarta;

    @FXML
    private Label genereCarta;

    @FXML
    private ComboBox<String> listaCarte;
    
    @FXML
    private ImageView immagineCarta;

    @FXML
    private Pane sfondo;

    @FXML
    private TabPane tabPane;
    
    @FXML
    private VBox infoCarta;
    
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
    void backWelcome(ActionEvent event) {
    	try {
	    	Parent root = FXMLLoader.load(getClass().getResource("/view/Welcome.fxml"));
	        Scene scenaHomepage = new Scene(root);
	        scenaHomepage.getStylesheets().add("/view/welcome.css");
	        Main.setScene(scenaHomepage,false," - Homepage");
    	}catch(Exception e) {
    		
    	}
    }
    
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
    	
    	
    	genereCarta.setText(c.getGenere());
    	
    	String imageURL = c.getPercorso();
        
        Image image = new Image(imageURL);
        immagineCarta.setImage(image);
        immagineCarta.setPreserveRatio(true);
        
    }

}


    

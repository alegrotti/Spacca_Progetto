package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import model.Partita;

public class VincitorePartitaController {

	private Partita partita;
	
    @FXML
    private AnchorPane sfondo;

    @FXML
    private VBox sfondoBianco;

    @FXML
    private Label titoloPartita;

    @FXML
    private Button tornaHomeButton;

    @FXML
    void tornaHome(ActionEvent event) {
    	try {
    		Parent root = FXMLLoader.load(getClass().getResource("/view/Welcome.fxml"));
	        Scene scenaHomepage = new Scene(root);
	        scenaHomepage.getStylesheets().add("/view/welcome.css");
	        GestoreScene.setScene(scenaHomepage,false," - Homepage");
    	}catch(Exception e) {
    		GestoreScene.messaggioErrore("Errore apertura finestra");
    	}
    }
    
    
    public void impostaPartita(Partita p) {
    	partita = p;
    }
    
}

package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.DBPartite;

public class LoginPartitaController {

    @FXML
    private VBox centralBox;

    @FXML
    private TextField codicePartita;

    @FXML
    private Pane sfondo;

    @FXML
    private Label titolo;

    @FXML
    void giocaPartita(ActionEvent event) {
    	try {
    		String codice = codicePartita.getText();
    		if(codice.equals(""))
    			throw new IllegalArgumentException("Nessun codice inserito");
    		if(DBPartite.esistePartita(codice)) {
    			try {
    		    	FXMLLoader loader = new FXMLLoader(Main.class.getResource("/view/CampoGioco.fxml"));
    				Parent root = loader.load();
    				CampoGiocoController.partita = DBPartite.getPartita(codice);
    				Scene scenaHomepage = new Scene(root);
    		        scenaHomepage.getStylesheets().add("/view/campogioco.css");
    		        GestoreScene.setScene(scenaHomepage,false,(" - Game "+codice));
    		        GestoreScene.prossimoTurnoPopup(DBPartite.getPartita(codice));
    	    	}catch(IllegalArgumentException e) {
    	    		throw e;
    	    	}catch(IOException e) {
    	    		throw new Exception("Errore apertura finestra");
    	    	}
    		}else {
    			throw new Exception("Partita inesistente");
    		}
    	}catch(Exception e) {
    		GestoreScene.messaggioErrore(e.getMessage());
    	}
    }

    @FXML
    void tornaWelcome(ActionEvent event) {
    	try {
	    	Parent root = FXMLLoader.load(getClass().getResource("/view/Welcome.fxml"));
	        Scene scenaHomepage = new Scene(root);
	        scenaHomepage.getStylesheets().add("/view/welcome.css");
	        GestoreScene.setScene(scenaHomepage,false," - Homepage");
    	}catch(Exception e) {
    		GestoreScene.messaggioErrore("Errore apertura finestra");
    	}
    }

}

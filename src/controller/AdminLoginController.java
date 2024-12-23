package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.DBAdmin;


public class AdminLoginController {

    @FXML
    private Button backButton;

    @FXML
    private VBox centralBox;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordButton;

    @FXML
    private Pane sfondo;

    @FXML
    private Label titolo;

    @FXML
    private TextField usernameButton;

    //Controllo per username e password
    @FXML
    void checkLogin(ActionEvent event) {
    	try {
	    	if(usernameButton.getText().equals(DBAdmin.getUsername()))
	    		if(passwordButton.getText().equals(DBAdmin.getPassword())) {
	    			try {
	    		    	Parent root = FXMLLoader.load(getClass().getResource("/view/AdminArea.fxml"));
	    		        Scene scenaHomepage = new Scene(root);
	    		        scenaHomepage.getStylesheets().add("/view/adminarea.css");
	    		        GestoreScene.setScene(scenaHomepage,false," - Area admin");
	    		        System.out.println("Accesso admin eseguito");
	    	    	}catch(Exception e) {	
	    	    		throw new Exception("Errore apertura finestra");
	    	    	}
	    		}else
	    			throw new Exception("Password errata");
	    	else
	    		throw new Exception("Username errato");
    	}
	    catch(Exception e) {
	    	GestoreScene.messaggioErrore(e.getMessage());
	    }
    }

    @FXML
    void tornaWelcome(ActionEvent event) {
    	GestoreScene.welcome(false);
    }
    
}

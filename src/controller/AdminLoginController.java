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

    @FXML
    void checkLogin(ActionEvent event) {
    	if(usernameButton.getText().equals(WelcomeController.admin.getUsername()))
    		if(passwordButton.getText().equals(WelcomeController.admin.getPassword())) {
    			try {
    		    	Parent root = FXMLLoader.load(getClass().getResource("/view/AdminArea.fxml"));
    		        Scene scenaHomepage = new Scene(root);
    		        scenaHomepage.getStylesheets().add("/view/adminarea.css");
    		        Main.setScene(scenaHomepage,false);
    	    	}catch(Exception e) {	
    	    		Main.messaggioErrore("Errore apertura finestra");
    	    	}
    		}else {
    			Main.messaggioErrore("Password errata");
    			initialize();
    		}
    	else{
			Main.messaggioErrore("Nome utente errato");
			initialize();
		}
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
    	//usernameButton.setText(WelcomeController.admin.getUsername());
    	//passwordButton.setText(WelcomeController.admin.getPassword());
    }

}

package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import model.DBAdmin;
/*
import model.DBCarte;
import model.DBGiocatori;
import model.DBMazzi;
import model.DBPartite;
import model.DBTornei;
*/

public class WelcomeController {
	
	@FXML
    private Button adminLogin;

    @FXML
    private VBox centralBox;

    @FXML
    private Button exitButton;

    @FXML
    private Button impostazioniButton;

    @FXML
    private Button playGameButton;

    @FXML
    private Button playTournamentButton;

    @FXML
    private Button playerArea;

    @FXML
    private Button rulesButton;

    @FXML
    private StackPane sfondo;

    @FXML
    private Button standingsButton;

    @FXML
    private Label titolo;

    @FXML
    void closeProgram(ActionEvent event) {
    	DBAdmin.salvaAdmin(DBAdmin.getAdmin());
    	Platform.exit();
    }

    @FXML
    void openAdminLogin(ActionEvent event) {
    	try {
	    	Parent root = FXMLLoader.load(getClass().getResource("/view/AdminLogin.fxml"));
	        Scene scenaHomepage = new Scene(root);
	        scenaHomepage.getStylesheets().add("/view/adminlogin.css");
	        GestoreScene.setScene(scenaHomepage,false," - Area admin login");
    	}catch(Exception e) {
    		GestoreScene.messaggioErrore("Errore apertura finestra");
    	}
    }

    @FXML
    void openPlayerArea(ActionEvent event) {
    	try {
	    	Parent root = FXMLLoader.load(getClass().getResource("/view/PlayerArea.fxml"));
	        Scene scenaHomepage = new Scene(root);
	        scenaHomepage.getStylesheets().add("/view/playerarea.css");
	        GestoreScene.setScene(scenaHomepage,false," - Player area");
    	}catch(Exception e) {
    		GestoreScene.messaggioErrore("Errore apertura finestra");
    	}
    }

    @FXML
    void openRules(ActionEvent event) {
    	try {
	    	Parent root = FXMLLoader.load(getClass().getResource("/view/Rules.fxml"));
	        Scene scenaHomepage = new Scene(root);
	        scenaHomepage.getStylesheets().add("/view/rules.css");
	        GestoreScene.setScene(scenaHomepage,false," - Regole e catalogo carte");
    	}catch(Exception e) {
    		GestoreScene.messaggioErrore("Errore apertura finestra");
    	}
    }

    @FXML
    void openSettings(ActionEvent event) {
    	try {
	    	Parent root = FXMLLoader.load(getClass().getResource("/view/Catalog.fxml"));
	        Scene scenaHomepage = new Scene(root);
	        scenaHomepage.getStylesheets().add("/view/catalog.css");
	        GestoreScene.setScene(scenaHomepage,false," - Catalogo carte");
    	}catch(Exception e) {
    		GestoreScene.messaggioErrore("Errore apertura finestra");
    	}
    }

    @FXML
    void openStandings(ActionEvent event) {
    	try {
	    	Parent root = FXMLLoader.load(getClass().getResource("/view/Standing.fxml"));
	        Scene scenaHomepage = new Scene(root);
	        scenaHomepage.getStylesheets().add("/view/standing.css");
	        GestoreScene.setScene(scenaHomepage,false," - Storico partite");
    	}catch(Exception e) {
    		GestoreScene.messaggioErrore("Errore apertura finestra");
    	}
    }

    @FXML
    void playGame(ActionEvent event) {
    	try {
    		Parent root = FXMLLoader.load(getClass().getResource("/view/LoginPartita.fxml"));
	        Scene scenaHomepage = new Scene(root);
	        scenaHomepage.getStylesheets().add("/view/loginpartita.css");
	        GestoreScene.setScene(scenaHomepage,false," - Login partita");
    	}catch(Exception e) {
    		GestoreScene.messaggioErrore("Errore apertura finestra");
    	}
    }
    
    @FXML
    void playTournament(ActionEvent event) {
    	try {
    		Parent root = FXMLLoader.load(getClass().getResource("/view/LoginTorneo.fxml"));
	        Scene scenaHomepage = new Scene(root);
	        scenaHomepage.getStylesheets().add("/view/logintorneo.css");
	        GestoreScene.setScene(scenaHomepage,false," - Login tournament");
    	}catch(Exception e) {
    		GestoreScene.messaggioErrore("Errore apertura finestra");
    	}
    }
    
}

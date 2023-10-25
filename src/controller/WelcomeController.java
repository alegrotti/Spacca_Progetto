package controller;

import java.util.HashMap;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Admin;
import model.Carta;
import model.GestoreFile;
import model.Mazzo;
import model.Partita;
import model.Torneo;

public class WelcomeController {
	
	public static Admin admin;
	public static HashMap <String,Partita> partite;
	public static HashMap <String,Torneo> tornei;
	public static HashMap <String,Carta> carte;
	public static HashMap <String,Mazzo> mazzi;
	
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
    private Pane sfondo;

    @FXML
    private Button standingsButton;

    @FXML
    private Label titolo;

    @FXML
    void closeProgram(ActionEvent event) {
    	Platform.exit();
    }

    @FXML
    void openAdminLogin(ActionEvent event) {
    	try {
	    	Parent root = FXMLLoader.load(getClass().getResource("/view/AdminLogin.fxml"));
	        Scene scenaHomepage = new Scene(root);
	        scenaHomepage.getStylesheets().add("/view/adminlogin.css");
	        GestoreScene gestoreScene = new GestoreScene ();
	        gestoreScene.setScene(scenaHomepage,false);
    	}catch(Exception e) {
    		
    	}
    }

    @FXML
    void openPlayerArea(ActionEvent event) {
    	try {
	    	Parent root = FXMLLoader.load(getClass().getResource("/view/PlayerArea.fxml"));
	        Scene scenaHomepage = new Scene(root);
	        scenaHomepage.getStylesheets().add("/view/playerarea.css");
	        GestoreScene gestoreScene = new GestoreScene ();
	        gestoreScene.setScene(scenaHomepage,false);
    	}catch(Exception e) {
    		
    	}
    }

    @FXML
    void openRules(ActionEvent event) {
    	try {
	    	Parent root = FXMLLoader.load(getClass().getResource("/view/Rules.fxml"));
	        Scene scenaHomepage = new Scene(root);
	        scenaHomepage.getStylesheets().add("/view/rules.css");
	        GestoreScene gestoreScene = new GestoreScene ();
	        gestoreScene.setScene(scenaHomepage,false);
    	}catch(Exception e) {
    		
    	}
    }

    @FXML
    void openSettings(ActionEvent event) {
    	try {
	    	Parent root = FXMLLoader.load(getClass().getResource("/view/Setting.fxml"));
	        Scene scenaHomepage = new Scene(root);
	        scenaHomepage.getStylesheets().add("/view/setting.css");
	        GestoreScene gestoreScene = new GestoreScene ();
	        gestoreScene.setScene(scenaHomepage,false);
    	}catch(Exception e) {
    		
    	}
    }

    @FXML
    void openStandings(ActionEvent event) {
    	try {
	    	Parent root = FXMLLoader.load(getClass().getResource("/view/Standing.fxml"));
	        Scene scenaHomepage = new Scene(root);
	        scenaHomepage.getStylesheets().add("/view/standing.css");
	        GestoreScene gestoreScene = new GestoreScene ();
	        gestoreScene.setScene(scenaHomepage,false);
    	}catch(Exception e) {
    		
    	}
    }

    @FXML
    void playGame(ActionEvent event) {
    	try {
	    	Parent root = FXMLLoader.load(getClass().getResource("/view/messaggioErrore.fxml"));
	        Scene scenaHomepage = new Scene(root);
	        scenaHomepage.getStylesheets().add("/view/messaggioErrore.css");
	        Stage stage = new Stage();
	        stage.setScene(scenaHomepage);
	        stage.initOwner(Main.parentWindow);
	        stage.initModality(Modality.APPLICATION_MODAL);
	        stage.show();
	        
    	}catch(Exception e) {
    		
    	}

    }
    
    @FXML
    void playTournament(ActionEvent event) {

    }
    
    @FXML
    void initialize(){
    	
    	GestoreFile gestoreFile = new GestoreFile();
    	
    	Admin a = gestoreFile.importaAdmin();
    	
    	admin = a;
    	partite = a.getPartite();
    	tornei = a.getTornei();
    }

}

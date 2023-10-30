package controller;

import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.GestoreFile;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class Main extends Application {
	
	public static Stage parentWindow;
	
	@Override
	public void start(Stage stage) throws Exception {

		parentWindow = stage;
		
		Parent root = FXMLLoader.load(getClass().getResource("/view/Welcome.fxml"));
        Scene scenaHomepage = new Scene(root);
        scenaHomepage.getStylesheets().add("/view/welcome.css");
        setScene(scenaHomepage,false);
        
        //Gestione chiusura finestra
        parentWindow.setOnCloseRequest(event -> {

        	try {
    			FXMLLoader loader = new FXMLLoader(Main.class.getResource("/view/MessaggioDiUscita.fxml"));
    			Parent parent = loader.load();
    			
    			Scene exitScene = new Scene(parent);
    			exitScene.getStylesheets().add("/view/messaggiodiuscita.css");
    			
    			Stage exitStage = new Stage();
    			exitStage.setScene(exitScene);
    			exitStage.initOwner(parentWindow);
    			exitStage.initModality(Modality.APPLICATION_MODAL);
    			exitStage.setTitle("SPACCA - Errore");
    	        Image image = new Image("/immagini/icon.jpg");
    	        exitStage.getIcons().add(image);
    			
    	        exitStage.show();
    		} catch (Exception e) {
    			
    		}
        	
        });
     
	}
	
	public static void main (String[] args) {
		launch(args);
	}
	
	public static void setScene (Scene scena, boolean t) {
		parentWindow.setScene(scena);
        parentWindow.setResizable(false);
        parentWindow.setMaximized(t);
        parentWindow.setTitle("SPACCA");
        Image image = new Image("/immagini/icon.jpg");
        parentWindow.getIcons().add(image);
        parentWindow.show();
	}
	
	public static void messaggioErrore(String s) {
		
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("/view/MessaggioErrore.fxml"));
			Parent root = loader.load();
			
			MessaggioErroreController controller = loader.getController();
			controller.impostaTesto(s);
			
			Scene errorScene = new Scene(root);
			errorScene.getStylesheets().add("/view/messaggioerrore.css");
			
			Stage errorStage = new Stage();
			errorStage.setScene(errorScene);
			errorStage.initOwner(parentWindow);
			errorStage.initModality(Modality.APPLICATION_MODAL);
	        errorStage.setTitle("SPACCA - Errore");
	        Image image = new Image("/immagini/icon.jpg");
	        errorStage.getIcons().add(image);
			
			errorStage.show();
		} catch (Exception e) {
			
		}
		
	}
	

}
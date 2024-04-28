package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static Stage parentWindow;
	
	@Override
	public void start(Stage stage) throws Exception {

		parentWindow = stage;
		Parent root = FXMLLoader.load(getClass().getResource("/view/Welcome.fxml"));
        Scene scenaHomepage = new Scene(root);
        scenaHomepage.getStylesheets().add("/view/welcome.css");
        GestoreScene.setScene(scenaHomepage,false," - Homepage");
        
        //Gestione chiusura finestra
        parentWindow.setOnCloseRequest(event -> {
			try {
				GestoreScene.messaggioDiUscita("Chiudere e salvare?");
				event.consume();
			} catch (Exception e) {
				GestoreScene.messaggioErrore("Errore apertura scheda");
			}
        });
     
	}
	
	public static void main (String[] args) {
    	launch(args);
	}

}
package controller;

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
            Alert alert = new Alert(AlertType.CONFIRMATION, "Chiudere e salvare?");
            alert.setHeaderText(null);

            alert.setTitle("SPACCA");
            
	        Image image = new Image("/immagini/icon.jpg");
            Stage alertStage = (Stage) alert.getDialogPane().getScene().getWindow();
            alertStage.getIcons().add(image);
            
            alert.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO);

            ButtonType result = alert.showAndWait().orElse(ButtonType.NO);
            
            if (result == ButtonType.NO) {
                event.consume();
            }else {
            	GestoreFile.salvaAdmin(WelcomeController.admin);
            	Platform.exit();
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
			errorStage.setResizable(false);
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
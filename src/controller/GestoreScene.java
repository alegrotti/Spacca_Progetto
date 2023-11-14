package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Partita;

public class GestoreScene {

	public static void setScene (Scene scena, boolean t, String title) {
		Main.parentWindow.setScene(scena);
		Main.parentWindow.setResizable(false);
		Main.parentWindow.setMaximized(false);
		Main.parentWindow.setTitle("SPACCA"+title);
		Main.parentWindow.centerOnScreen();
        Image image = new Image("/immagini/icon.jpg");
        Main.parentWindow.getIcons().add(image);
        Main.parentWindow.show();
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
			errorStage.initOwner(Main.parentWindow);
			errorStage.initModality(Modality.APPLICATION_MODAL);
	        errorStage.setTitle("SPACCA - Errore");
	        Image image = new Image("/immagini/icon.jpg");
	        errorStage.getIcons().add(image);
			
			errorStage.show();
		} catch (Exception e) {
			messaggioDiUscita("Errore, salva ed esci");
		}		
	}
	
	public static void messaggioDiUscita(String s) {
			
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("/view/MessaggioDiUscita.fxml"));
			Parent root = loader.load();
			
			MessaggioDiUscitaController controller = loader.getController();
			controller.impostaTesto(s);
			
			Scene exitScene = new Scene(root);
			exitScene.getStylesheets().add("/view/messaggiodiuscita.css");
			
			Stage exitStage = new Stage();
			exitStage.setScene(exitScene);
			exitStage.initOwner(Main.parentWindow);
			exitStage.initModality(Modality.APPLICATION_MODAL);
			exitStage.setTitle("SPACCA - Uscita senza salvataggio");
	        Image image = new Image("/immagini/icon.jpg");
	        exitStage.getIcons().add(image);
			
	        exitStage.show();
		} catch (Exception e) {
			messaggioErrore("Errore apertura finestra");
		}	
	}

	public static void prossimoTurnoPopup(Partita p) {
		try {
			ProssimoTurnoController.partita = p;
			System.out.println(0);
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("/view/ProssimoTurno.fxml"));
			Parent root = loader.load();
			System.out.println(1);
			Scene prossimoTurno= new Scene(root);
			prossimoTurno.getStylesheets().add("/view/prossimoturno.css");
			System.out.println(2);
			Stage popupStage = new Stage();
			popupStage.setScene(prossimoTurno);
			popupStage.initOwner(Main.parentWindow);
			popupStage.initModality(Modality.APPLICATION_MODAL);
			popupStage.setTitle("SPACCA - Prossimo turno partita");
	        Image image = new Image("/immagini/icon.jpg");
	        popupStage.getIcons().add(image);
	        
	        popupStage.show();
		} catch (Exception e) {
			messaggioErrore("Errore apertura finestra");
		}
	}
	
}

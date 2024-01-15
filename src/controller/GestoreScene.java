package controller;

import java.util.ArrayList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.City;
import model.DBPartite;
import model.Partita;

public class GestoreScene {

	public static void setScene (Scene scena, boolean t, String title) {
		Main.parentWindow.setScene(scena);
		Main.parentWindow.setResizable(false);
		Main.parentWindow.setMaximized(false);
		Main.parentWindow.setTitle("SPACCA"+title);
		Main.parentWindow.setResizable(false);
		Main.parentWindow.setMaximized(false);
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
			errorStage.setMaximized(false);
			errorStage.centerOnScreen();
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
			exitStage.setMaximized(false);
			exitStage.centerOnScreen();
			exitStage.setResizable(false);
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
	
	public static void messaggioRitornoHomepage(String s) {
		
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("/view/MessaggioRitornoHomepage.fxml"));
			Parent root = loader.load();

			MessaggioRitornoHomepageController controller = loader.getController();
			controller.impostaTesto(s);
			
			Scene returnScene = new Scene(root);
			returnScene.getStylesheets().add("/view/messaggioritornohomepage.css");
			
			Stage returnStage = new Stage();
			returnStage.setResizable(false);
			returnStage.setScene(returnScene);
			returnStage.initOwner(Main.parentWindow);
			returnStage.initModality(Modality.APPLICATION_MODAL);
			returnStage.setTitle("SPACCA - Ritorno homepage senza salvataggio");
	        Image image = new Image("/immagini/icon.jpg");
	        returnStage.getIcons().add(image);
			
	        returnStage.show();
		} catch (Exception e) {
			messaggioErrore("Errore apertura finestra");
		}	
	}

	public static void prossimoTurnoPopup(Partita p) {
		try {
			ProssimoTurnoController.partita = p;
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("/view/ProssimoTurno.fxml"));
			Parent root = loader.load();
			
			Scene prossimoTurno= new Scene(root);
			prossimoTurno.getStylesheets().add("/view/prossimoturno.css");
			
			Stage popupStage = new Stage();
			popupStage.setMaximized(false);
			popupStage.centerOnScreen();
			popupStage.setResizable(false);
			popupStage.setScene(prossimoTurno);
			popupStage.initOwner(Main.parentWindow);
			popupStage.initModality(Modality.APPLICATION_MODAL);
			popupStage.setTitle("SPACCA - Prossimo turno partita");
	        Image image = new Image("/immagini/icon.jpg");
	        popupStage.getIcons().add(image);
	        
	        popupStage.setOnCloseRequest(event -> {
				event.consume();
	        });
	        
	        popupStage.show();
		} catch (Exception e) {
			messaggioErrore("Errore apertura finestra");
		}
	}
	
	public static void mostraCittadina(City c) {
		try {
			MostraCittadinaController.città = c;
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("/view/MostraCittadina.fxml"));
			Parent root = loader.load();
			
			Scene scene= new Scene(root);
			scene.getStylesheets().add("/view/mostracittadina.css");
			
			Stage stage = new Stage();
			stage.setMaximized(false);
			stage.centerOnScreen();
			stage.setResizable(false);
			stage.setScene(scene);
			stage.initOwner(Main.parentWindow);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setTitle("SPACCA - Mostra cittadina");
	        Image image = new Image("/immagini/icon.jpg");
	        stage.getIcons().add(image);
	        stage.show();
		} catch (Exception e) {
			messaggioErrore("Errore apertura finestra");
		}
	}
	
	public static void schermataPuntata(Partita p) {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("/view/PuntataPartita.fxml"));
			Parent root = loader.load();
			
			PuntataPartitaController c = loader.getController();
			
			//c.inizializzaSchermata(p.getPuntata(),p.getGiocatoriTurno());
			c.inizializzaSchermata(23,new ArrayList<String>());
			
			Scene scene= new Scene(root);
			scene.getStylesheets().add("/view/puntatapartita.css");
			
			Stage stage = new Stage();
			stage.setMaximized(false);
			stage.centerOnScreen();
			stage.setResizable(false);
			stage.setScene(scene);
			stage.initOwner(Main.parentWindow);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setTitle("SPACCA - Punta");
	        Image image = new Image("/immagini/icon.jpg");
	        stage.getIcons().add(image);
	        stage.show();
		} catch (Exception e) {
			messaggioErrore("Errore apertura finestra");
		}
	}
	
	public static void scegliCartaSchermata(ArrayList<String> carte) {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("/view/ScegliCarta.fxml"));
			Parent root = loader.load();
			
			ScegliCartaController c = loader.getController();
			
			c.inizializzaSchermata(carte);
			
			Scene scene= new Scene(root);
			scene.getStylesheets().add("/view/sceglicarta.css");
			
			Stage stage = new Stage();
			stage.setMaximized(false);
			stage.centerOnScreen();
			stage.setResizable(false);
			stage.setScene(scene);
			stage.initOwner(Main.parentWindow);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setTitle("SPACCA - Scegli carta fine turno");
	        Image image = new Image("/immagini/icon.jpg");
	        stage.getIcons().add(image);
	        stage.show();
		} catch (Exception e) {
			messaggioErrore("Errore apertura finestra");
		}
	}
	
	public static void campoDaGioco(String codice,String g,Partita p) {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("/view/CampoGioco.fxml"));
			Parent root = loader.load();
			CampoGiocoController controller = loader.getController();
			controller.caricaSchermataDefault(g);
			CampoGiocoController.partita = DBPartite.getPartita(codice);
			Scene scenaHomepage = new Scene(root);
	        scenaHomepage.getStylesheets().add("/view/campogioco.css");
	        setScene(scenaHomepage,false,(" - Game "+codice));
		} catch (Exception e) {
			messaggioErrore("Errore apertura finestra");
		}
	}
	
}

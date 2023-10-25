package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static Stage parentWindow;
	
	@Override
	public void start(Stage stage) throws Exception {

		parentWindow = stage;
		
		Parent root = FXMLLoader.load(getClass().getResource("/view/Welcome.fxml"));
        Scene scenaHomepage = new Scene(root);
        scenaHomepage.getStylesheets().add("/view/welcome.css");
        setScene(scenaHomepage,false);
     
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
		
		/*
		try {

			Parent root = FXMLLoader.load(FXMLLoader.class.getResource("/view/messaggioErrore.fxml"));
			Scene scenaHomepage = new Scene(root);
	        scenaHomepage.getStylesheets().add("/view/messaggioErrore.css");
	        messaggioErroreController.impostaTesto(s);
	        Stage stage = new Stage();
	        stage.setScene(scenaHomepage);
	        stage.initOwner(Main.parentWindow);
	        stage.initModality(Modality.APPLICATION_MODAL);
	        stage.show();
	        
    	}catch(Exception e) {
    		
    	}
    	*/
		
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("/view/messaggioErrore.fxml"));
			Parent root = loader.load();
			
			messaggioErroreController controller = loader.getController();
			controller.impostaTesto(s);
			
			Scene errorScene = new Scene(root);
			errorScene.getStylesheets().add("/view/messaggioErrore.css");
			
			Stage errorStage = new Stage();
			errorStage.setScene(errorScene);
			errorStage.initOwner(parentWindow);
			errorStage.initModality(Modality.APPLICATION_MODAL);
			errorStage.showAndWait();
		} catch (Exception e) {
			e.printStackTrace(); // Gestisci l'eccezione in modo appropriato
		}
		
	}
	

}
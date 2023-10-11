// version 1.0.0

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
        GestoreScene gestoreScene = new GestoreScene ();
        gestoreScene.setScene(scenaHomepage,false);
        
        //main
     
	}
	
	public static void main (String[] args) {
		launch(args);
	}

}
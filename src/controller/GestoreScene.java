package controller;

import javafx.scene.Scene;
import javafx.scene.image.Image;

public class GestoreScene {
	
	public void setScene (Scene scena, boolean t) {
		Main.parentWindow.setScene(scena);
        Main.parentWindow.setResizable(false);
        Main.parentWindow.setMaximized(t);
        Main.parentWindow.setTitle("Pokeropoly");
        Image image = new Image("/immagini/icon.jpg");
        Main.parentWindow.getIcons().add(image);
        Main.parentWindow.show();
	}
	
}

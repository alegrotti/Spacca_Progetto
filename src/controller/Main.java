package controller;

import model.DBAdmin;
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
		
    	//DBAdmin.aggiornaDB();
    	//DBCarte.aggiornaDB();
    	//DBGiocatori.aggiornaDB();
    	//DBMazzi.aggiornaDB();
    	//DBPartite.aggiornaDB();
    	//DBTornei.aggiornaDB();
		
		//simulaCitta();
		
		DBAdmin.creaAdmin();
		
		launch(args);

	}
	
	/*
	public static void simulaCitta() {
		HashMap<String,Carta> map = DBCarte.Carte();
		List<String> keysAsArray = new ArrayList<String>(map.keySet());
		Random r = new Random();
		
		int t = 0;
		City C = new City ("Prova");
		int p = 0;
		//int x = 5;
		
		for(int x = 7; x < 8; x++) { 
			t = 0;
			p = 0;
			while(t<100000000) {
				C = new City ("Prova");
				for(int i = 0; i < x ; i++ ) {
					Carta c = map.get(keysAsArray.get(r.nextInt(keysAsArray.size())));
					C.aggiungiCarta(c);
					
					if(C.getPunteggio() > p)
						p = C.getPunteggio();
				}
				t++;
			}
			
			System.out.println(x+" => Tent: "+t+" , Punt: "+p);
			for(Carta c : C.getCarte())
				System.out.print(c.getNome()+" , ");
			System.out.println();
		}
	}
	*/
}
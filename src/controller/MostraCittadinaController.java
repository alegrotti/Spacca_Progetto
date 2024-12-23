package controller;

import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import model.City;

public class MostraCittadinaController {

	private City città;
	
	private List<Image> listaImmagini;
	
    @FXML
    private Pagination stampaCarte;
    
    @FXML
    private VBox infoCarte;

    @FXML
    private VBox centralBox;

    @FXML
    private Label punteggiVari;

    @FXML
    private Label punteggioTotale;

    @FXML
    private Button riprendiPartita;

    @FXML
    private Pane sfondo;

    @FXML
    private Label titolo;

    @FXML
    void closeWindow(ActionEvent event) {
    	riprendiPartita.getScene().getWindow().hide();
    }

    public void creaSchermata() {
        titolo.setText("Cittadina di \n" + città.getNome());
        punteggioTotale.setText("Punteggio cittadina: " + città.getPunteggio());

        String s = "Punteggio residenziale : " + città.getResidenziale() +
                   "\nPunteggio culturale : " + città.getCulturale() +
                   "\nPunteggio pubblico : " + città.getPubblico() +
                   "\nPunteggio commerciale : " + città.getCommerciale();
        punteggiVari.setText(s);

        listaImmagini = new ArrayList<>();
        città.getCarte().forEach(carta -> listaImmagini.add(new Image(carta.getPercorso())));

        boolean z = listaImmagini.size()==0;
        
        stampaCarte.setVisible(!z);
        
        if(!z) {
        	stampaCarte.setCurrentPageIndex(0);
        	stampaCarte.setPageCount(listaImmagini.size());
        	stampaCarte.setPageFactory(new Callback<Integer, Node>() {
        	       public Node call(Integer indicePagina) {
        	    	   ImageView imageView = new ImageView(listaImmagini.get(indicePagina));
        	    	   imageView.setFitWidth(225);
	    		       imageView.setFitHeight(315);
	    		       return imageView;
        	       }
        	   });
        }
    }
    
    public void importaCitta(City c) {
    	città = c;
    }
    
}

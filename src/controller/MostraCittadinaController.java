package controller;

import java.util.ArrayList;
import java.util.List;
import model.Carta;
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
import model.City;

public class MostraCittadinaController {

	public static City città;
	
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

    @FXML
    void initialize() {
    	titolo.setText("Cittadina di "+città.getNome());
    	punteggioTotale.setText("Punteggio cittadina: " + città.getPunteggio());
    	
    	String s = "";
    	s+="Punteggio residenziale : "+città.getResidenziale();
    	s+="\nPunteggio culturale : "+città.getCulturale();
    	s+="\nPunteggio pubblico : "+città.getPubblico();
    	s+="\nPunteggio commerciale : "+città.getCommerciale();
    	punteggiVari.setText(s);
    	
    	//inizializzaPagination();
    	
    	listaImmagini = new ArrayList<Image>();
    	
    	for(int i =0 ; i<città.getCarte().size() ; i++)
        	listaImmagini.add(new Image(città.getCarte().get(i).getPercorso()));
    	
    	stampaCarte.setPageCount(listaImmagini.size());
    	
    	stampaCarte.setPageFactory(this::creaPagina);
    	
    }
    
    private ImageView creaPagina(int indicePagina) {
        ImageView imageView = new ImageView();
        
        imageView.setImage(listaImmagini.get(indicePagina));

        imageView.setFitWidth(200);
        imageView.setFitHeight(260);

        return imageView;
    }
    
}

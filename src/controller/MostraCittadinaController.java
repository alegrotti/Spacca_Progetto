package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
	
    @FXML
    private Pagination stampaCarte;

    @FXML
    private VBox centralBox;

    @FXML
    private Label punteggiVariCittà;

    @FXML
    private Label punteggioCittà;

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
    	punteggioCittà.setText("Punteggio cittadina: " + città.getPunteggio());
    	
    	String s = "";
    	s+="Punteggio residenziale : "+città.getResidenziale();
    	s+="\nPunteggio culturale : "+città.getCulturale();
    	s+="\nPunteggio pubblico : "+città.getPubblico();
    	s+="\nPunteggio commerciale : "+città.getCommerciale();
    	punteggiVariCittà.setText(s);
    	
    	inizializzaPagination();
    }
    
    private void inizializzaPagination() {
    	String[] percorsi = new String[città.getCarte().size()];
    	for(int i = 0 ; i < percorsi.length ; i++)
    		percorsi[i] = città.getCarte().get(i).getPercorso();
    	
    	stampaCarte = createPhotoPagination(percorsi, 1);
    	
    	//carteCittà = createPhotoPagination(percorsi, 1);
        //centralBox.getChildren().add(stampaCarte);
    }
    
    private Pagination createPhotoPagination(String[] imageUrls, int imagesPerPage) {
        Pagination pagination = new Pagination((imageUrls.length + imagesPerPage - 1) / imagesPerPage, 0);
        pagination.setPageFactory(pageIndex -> createPage(imageUrls, imagesPerPage, pageIndex));
        return pagination;
    }

    private ImageView createPage(String[] imageUrls, int imagesPerPage, int pageIndex) {
        int fromIndex = pageIndex * imagesPerPage;
        int toIndex = Math.min(fromIndex + imagesPerPage, imageUrls.length);

        ImageView imageView = new ImageView();
        imageView.setFitWidth(400);
        imageView.setFitHeight(300);

        for (int i = fromIndex; i < toIndex; i++) {
            Image image = new Image(imageUrls[i]);
            imageView.setImage(image);
        }

        return imageView;
    }
    
 
    
}

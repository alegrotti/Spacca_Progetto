package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import model.Partita;

public class CampoGiocoController {

    @FXML
    private Button buttonLasciare;

    @FXML
    private Button buttonRilanciare;

    @FXML
    private HBox hboxMano;

    @FXML
    private HBox hboxTavolo;

    @FXML
    private ImageView iconMano1;

    @FXML
    private ImageView iconMano2;

    @FXML
    private ImageView iconMano3;

    @FXML
    private ImageView iconRetroCarta;

    @FXML
    private ImageView iconTavolo1;

    @FXML
    private ImageView iconTavolo2;

    @FXML
    private ImageView iconTavolo3;

    @FXML
    private ImageView iconTavolo4;

    @FXML
    private Pane sfondo;
    
    @FXML
    private Pane sfondoScuro;

    @FXML
    private Label textCrediti;

    @FXML
    private Label textMoney;
	
	@SuppressWarnings("unused")
	private Partita partita;
	
	public boolean impostaPartita(Partita p) {
		try {
			partita = p;
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
    @FXML
    void initialize() {
    	
    }

}

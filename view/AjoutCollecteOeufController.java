package view;

import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.ConnectionBD;

public class AjoutCollecteOeufController {

	   @FXML
	    private JFXTextField typeOeuf;

	    @FXML
	    private JFXTextField idBande;

	    @FXML
	    private JFXTextField prixAlveole;

	    @FXML
	    private JFXTextField quantite;
	    
	    @FXML
	    private JFXDatePicker dateCollecte;

	    @FXML
	    private JFXTextField qteCassee;

	    @FXML
	    private JFXTextField incubation;

	    @FXML
	    private JFXButton okBouton;

	    @FXML
	    private JFXButton annulerBouton;
	    
	    private Main main=new Main(); 
	    
	    @FXML
		void handleCancelButton(ActionEvent event) throws Exception {
			main.getStageDelete().close();
		}
	    
	    @FXML
		void handleOkButton(ActionEvent event) throws IOException, SQLException {
			
			ConnectionBD connectionBD=new ConnectionBD();
			MenuFerController menuFerController = new MenuFerController();
			ArrayList<String> strings =new ArrayList<String>();
			strings.add(quantite.getText());
			strings.add(dateCollecte.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
			strings.add(incubation.getText());
			strings.add(idBande.getText());
			strings.add(prixAlveole.getText());
			strings.add(qteCassee.getText());
			strings.add(typeOeuf.getText());
			connectionBD.ajoutCollecteOeuf(strings);
			menuFerController.setTables();
			main.getStageDelete().close();
			connectionBD.Close();
		}
}

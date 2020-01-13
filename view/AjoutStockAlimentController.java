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

public class AjoutStockAlimentController {

	  @FXML
	    private JFXTextField idAliment;

	    @FXML
	    private JFXTextField idEmploye;

	    @FXML
	    private JFXTextField idFournisseur;

	    @FXML
	    private JFXTextField quantite;
	    
	    @FXML
	    private JFXDatePicker date;

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
			strings.add(date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
			strings.add(idAliment.getText());
			strings.add(idEmploye.getText());
			strings.add(idFournisseur.getText());
			connectionBD.ajoutStockAliment(strings);
			menuFerController.setTables();
			main.getStageDelete().close();
			connectionBD.Close();
		}
}

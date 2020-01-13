package view;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import application.Main;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import model.ConnectionBD;

public class AjoutStockAlimentController implements Initializable{

	  @FXML
	    private JFXComboBox idAliment;

	    @FXML
	    private JFXTextField idEmploye;

	    @FXML
	    private JFXComboBox idFournisseur;

	    @FXML
	    private JFXTextField quantite;
	    
	    @FXML
	    private JFXDatePicker date;

	    @FXML
	    private JFXButton okBouton;

	    @FXML
	    private JFXButton annulerBouton;
	    
	    private Main main=new Main(); 
	    
	    private ObservableList<String> data;
	    
		private ConnectionBD connectionBD =new ConnectionBD();
		
	    @FXML
		void handleCancelButton(ActionEvent event) throws Exception {
			main.getStageDelete().close();
		}
	    
	    @FXML
		void handleOkButton(ActionEvent event) throws IOException, SQLException {
			
			MenuFerController menuFerController = new MenuFerController();
			ArrayList<String> strings =new ArrayList<String>();
			strings.add(quantite.getText());
			strings.add(date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
			strings.add(connectionBD.getAlimentId(idAliment.getValue().toString()));
			strings.add(idEmploye.getText());
			strings.add(connectionBD.getFournisseurId(idFournisseur.getValue().toString()));
			connectionBD.ajoutStockAliment(strings);
			menuFerController.setTables();
			main.getStageDelete().close();
			connectionBD.Close();
		}

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			try {
				data = connectionBD.getAlimentNom();
				idAliment.setItems(data);
				data = connectionBD.getFournisseurNom();
				idFournisseur.setItems(data);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
}

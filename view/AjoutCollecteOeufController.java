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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import model.ConnectionBD;

public class AjoutCollecteOeufController implements Initializable{

	   @FXML
	    private JFXTextField typeOeuf;

	    @FXML
	    private JFXComboBox idBande;

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
	    
private static Main main=new Main(); 

private ConnectionBD connectionBD=new ConnectionBD();

private ObservableList<String> data = FXCollections.observableArrayList();    
	    @FXML
		void handleBoutonAnnuler(ActionEvent event) throws Exception {
			main.getStage().close();
		}
	    
	    @FXML
		void handleBoutonOk(ActionEvent event) throws IOException, SQLException  {
			
			
			MenuFerController menuFerController = new MenuFerController();
			ArrayList<String> strings =new ArrayList<String>();
			strings.add(quantite.getText());
			strings.add(dateCollecte.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
			strings.add(incubation.getText());
			strings.add(idBande.getValue().toString());
			strings.add(prixAlveole.getText());
			strings.add(qteCassee.getText());
			strings.add(typeOeuf.getText());
			connectionBD.ajoutCollecteOeuf(strings);
			menuFerController.setTables();
			main.getStageDelete().close();
			connectionBD.Close();
		}

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			try {
				data = connectionBD.getBandeId();
				idBande.setItems(data);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
		}
}

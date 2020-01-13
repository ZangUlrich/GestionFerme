package view;

import application.Main;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.ConnectionBD;

public class MenuComController implements Initializable {

	 	@FXML
	    private JFXButton ajoutButtonCollecteOeuf;

	    @FXML
	    private JFXButton deleteButtonCollecteOeuf;

	    @FXML
	    private JFXButton modifButtonCollecteOeuf;

	    @FXML
	    private TableView<?> tableCollecteOeuf;

	    @FXML
	    private JFXButton ajoutButtonVentes;
	    
	    @FXML
	    private JFXButton ajoutButtonVentesOeuf;
	    
	    @FXML
	    private TableView<?> tableVentesOeuf;
	    
	    @FXML
	    private JFXButton deleteButtonVentes;

	    @FXML
	    private JFXButton modifButtonVentes;

	    @FXML
	    private TableView<?> tableVentes;

	    @FXML
	    private TableView<?> tableRace;

	    @FXML
	    private TableView<?> tableBande;

	    @FXML
	    void handleAddButtonCollecteOeuf(ActionEvent event) {

	    }

	    private Main main=new Main();
	    
	    @FXML
	    void handleAddButtonVentes(ActionEvent event) throws IOException {
	    	Stage newStage = new Stage();
			main.ajoutVente(newStage);
	    }

	    @FXML
	    void handleAddButtonVentesOeuf(ActionEvent event) throws IOException {
	    	Stage newStage = new Stage();
			main.ajoutVenteOeuf(newStage);
	    }
	    
	    @FXML
	    void handleDeleteButtonCollecteOeuf(ActionEvent event) {

	    }

	    @FXML
	    void handleDeleteButtonVentes(ActionEvent event) {

	    }

	    @FXML
	    void handleModifButtonCollecteOeuf(ActionEvent event) {

	    }

	    @FXML
	    void handleModifButtonVentes(ActionEvent event) {

	    }
	    
		@FXML
		static ObservableList<ObservableList> data=FXCollections.observableArrayList();	    
	    
		static TableView<?> tablerefVenduOeuf;
		static TableView<?> tablerefVendu;
		static TableView<?> tablerefCollecteOeuf;
		static TableView<?> tablerefRace;
		static TableView<?> tablerefBande;

		/**
		 * Permet la mise à jour des tables
		 */
		void setTables() {
			ConnectionBD connectionBD=new ConnectionBD(); 
			tablerefVenduOeuf.getColumns().clear();
			tablerefBande.getColumns().clear();
			tablerefVendu.getColumns().clear();
			tablerefRace.getColumns().clear();
			tablerefCollecteOeuf.getColumns().clear();
			try {
				connectionBD.afficheRace(data, tablerefRace);
				connectionBD.afficheVenteOeuf(data, tablerefVenduOeuf);	
				connectionBD.afficheBande(data, tablerefBande);
				connectionBD.afficheCollecteOeuf(data, tablerefCollecteOeuf);
				connectionBD.afficheVentes(data, tablerefVendu);
				
			} catch (SQLException e) {
				e.printStackTrace(); } try { connectionBD.Close(); } catch (SQLException e) {
					e.printStackTrace(); }
		}


	    
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			
			tablerefRace=tableRace;
			tablerefBande=tableBande;
			tablerefVendu=tableVentes;
			tablerefCollecteOeuf=tableCollecteOeuf;
			tablerefVenduOeuf=tableVentesOeuf;
			
			ConnectionBD connectionBD=new ConnectionBD(); try {
				connectionBD.afficheRace(data, tableRace);
				connectionBD.afficheBande(data, tableBande);
				connectionBD.afficheCollecteOeuf(data, tableCollecteOeuf);
				connectionBD.afficheVentes(data, tableVentes);
				connectionBD.afficheVenteOeuf(data, tableVentesOeuf);
			} catch (SQLException e) {
				e.printStackTrace(); } try { connectionBD.Close(); } catch (SQLException e) {
					e.printStackTrace(); }
			
		}
	
	
	
}

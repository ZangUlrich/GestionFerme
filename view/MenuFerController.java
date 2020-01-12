package view;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.jar.Manifest;

import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.ConnectionBD;
import application.Main;


public class MenuFerController implements Initializable {

	@FXML
	private JFXButton ajoutButtonRace;

	@FXML
	private JFXButton deleteButtonSuppression;

	@FXML
	private JFXButton modifButtonRace;

	@FXML
	private TableView<?> tableRace;

	@FXML
	private JFXButton ajoutButtonBande;

	@FXML
	private JFXButton deleteButtonBande;

	@FXML
	private JFXButton modifButtonBande;

	@FXML
	private TableView<?> tableBande;

	@FXML
	private JFXButton ajoutButtonAliment;

	@FXML
	private JFXButton deleteButtonAliment;

	@FXML
	private JFXButton modifButtonAlimen;

	@FXML
	private TableView<?> tableAliment;

	@FXML
	private JFXButton ajoutButtonStockAliment;

	@FXML
	private JFXButton deleteButtonStockAliment;

	@FXML
	private JFXButton modifButtonAliment;

	@FXML
	private TableView<?> tableStockAli;

	@FXML
	private JFXButton ajoutButtonFournis;

	@FXML
	private JFXButton deleteButtonFournis;

	@FXML
	private JFXButton modifButtonFournis;

	@FXML
	private TableView<?> tableFournis;

	@FXML
	private TableView<?> tableCollecteOeuf;

	@FXML
	private JFXButton ajoutButtonCollecteOeuf;

	@FXML
	private JFXButton deleteButtonCollecteOeuf;

	@FXML
	private JFXButton modifButtonCollecteOeuf;

	@FXML
	static ObservableList<ObservableList> data=FXCollections.observableArrayList();;
	
	private Main main=new Main();
		
	@FXML
	void handleAddButtonAliment(ActionEvent event) {
		
	}

	@FXML
	void handleAddButtonBande(ActionEvent event) {

	}

	@FXML
	void handleAddButtonCollecteOeuf(ActionEvent event) {

	}

	@FXML
	void handleAddButtonFournis(ActionEvent event) {

	}

	@FXML
	void handleAddButtonRace(ActionEvent event) throws IOException {
		Stage newStage = new Stage();
		main.ajoutRace(newStage);
	}

	@FXML
	void handleAddButtonStockAliment(ActionEvent event) {
		
	}

	@FXML
	void handleDeleteButtonAliment(ActionEvent event) throws IOException {
		Stage newStage=new Stage();
		strNomTable="Aliment";
		strId="idAli=";
		main.suppression(newStage);
	}

	@FXML
	void handleDeleteButtonBande(ActionEvent event) throws IOException {
		Stage newStage=new Stage();
		strNomTable="Bande";
		strId="idBande=";
		main.suppression(newStage);
	}

	@FXML
	void handleDeleteButtonCollecteOeuf(ActionEvent event) throws IOException {
		Stage newStage=new Stage();
		strNomTable="CollecteOeuf";
		strId="idCollect=";
		main.suppression(newStage);
	}

	@FXML
	void handleDeleteButtonFournis(ActionEvent event) throws IOException {
		Stage newStage=new Stage();
		strNomTable="Fournisseur";
		strId="idFourn=";
		main.suppression(newStage);
	}

	@FXML
	void handleDeleteButtonRace(ActionEvent event) throws IOException {
		Stage newStage=new Stage();
		strNomTable="Race";
		strId="idRace=";
		main.suppression(newStage);
		
	}
	
	@FXML
	void handleDeleteButtonStockAliment(ActionEvent event) throws IOException {
		Stage newStage=new Stage();
		strNomTable="StockAliment";
		strId="idStock=";
		main.suppression(newStage);
	}

	//String permettent de savoir dans quelle table on doit supprimer des
	//données.
	static String strNomTable=null;
	static String strId=null;
	
	//tableView servant à la mise à jour lors de la suppression, ajout
	//et modification des données
	
	static TableView<?> tablerefRace;
	static TableView<?> tablerefBande;
	static TableView<?> tablerefStockAliment;
	static TableView<?> tablerefFournisseur;
	static TableView<?> tablerefAliment;
	static TableView<?> tablerefCollecteOeuf;
	
	/**
	 * Permet la mise à jour des tables
	 */
	void setTables() {
		ConnectionBD connectionBD=new ConnectionBD(); 
		tablerefRace.getColumns().clear();
		tablerefBande.getColumns().clear();
		tablerefStockAliment.getColumns().clear();
		tablerefFournisseur.getColumns().clear();
		tablerefAliment.getColumns().clear();
		tablerefCollecteOeuf.getColumns().clear();
		try {
			connectionBD.afficheRace(data, tablerefRace);
			connectionBD.afficheAliment(data, tablerefAliment);	
			connectionBD.afficheBande(data, tablerefBande);
			connectionBD.afficheCollecteOeuf(data, tablerefCollecteOeuf);
			connectionBD.afficheFournisseur(data, tablerefFournisseur);
			connectionBD.afficheStockAliment(data, tablerefStockAliment);

		} catch (SQLException e) {
			e.printStackTrace(); } try { connectionBD.Close(); } catch (SQLException e) {
				e.printStackTrace(); }
	}
	


	@FXML
	void handleModifButtonAliment(ActionEvent event) {

	}

	@FXML
	void handleModifButtonBande(ActionEvent event) {

	}

	@FXML
	void handleModifButtonCollecteOeuf(ActionEvent event) {

	}

	@FXML
	void handleModifButtonFournis(ActionEvent event) {

	}

	@FXML
	void handleModifButtonRace(ActionEvent event) {

	}

	@FXML
	void handleModifButtonStockAliment(ActionEvent event) {

	}

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tablerefRace=tableRace;
		tablerefBande=tableBande;
		tablerefAliment=tableAliment;
		tablerefStockAliment=tableStockAli;
		tablerefCollecteOeuf=tableCollecteOeuf;
		tablerefFournisseur=tableFournis;
		
		ConnectionBD connectionBD=new ConnectionBD(); try {
			connectionBD.afficheRace(data, tableRace);
			connectionBD.afficheAliment(data, tableAliment);	
			connectionBD.afficheBande(data, tableBande);
			connectionBD.afficheCollecteOeuf(data, tableCollecteOeuf);
			connectionBD.afficheFournisseur(data, tableFournis);
			connectionBD.afficheStockAliment(data, tableStockAli);

		} catch (SQLException e) {
			e.printStackTrace(); } try { connectionBD.Close(); } catch (SQLException e) {
				e.printStackTrace(); }
	}
}

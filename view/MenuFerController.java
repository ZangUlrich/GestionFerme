package view;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import model.ConnectionBD;


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
	private ObservableList<ObservableList> data;


	/*
	 * @FXML void handleAddButtonAlim(ActionEvent event) throws Exception {
	 * 
	 * }
	 * 
	 * @FXML void handleAddButtonBande(ActionEvent event) throws Exception {
	 * 
	 * }
	 * 
	 * @FXML void handleAddButtonCollecteOeuf(ActionEvent event) throws Exception {
	 * 
	 * }
	 * 
	 * @FXML void handleAddButtonFourn(ActionEvent event) throws Exception {
	 * 
	 * }
	 * 
	 * @FXML void handleAddButtonRace(ActionEvent event) throws Exception {
	 * 
	 * }
	 * 
	 * @FXML void handleAddButtonStockAl(ActionEvent event) throws Exception {
	 * 
	 * }
	 * 
	 * @FXML void handleDeleteButtonAlim(ActionEvent event) throws Exception {
	 * 
	 * }
	 * 
	 * @FXML void handleDeleteButtonBande(ActionEvent event) throws Exception {
	 * 
	 * }
	 * 
	 * @FXML void handleDeleteButtonCollecteOeuf(ActionEvent event) throws Exception
	 * {
	 * 
	 * }
	 * 
	 * @FXML void handleDeleteButtonFourn(ActionEvent event) throws Exception {
	 * 
	 * }
	 * 
	 * @FXML void handleDeleteButtonRace(ActionEvent event) throws Exception {
	 * 
	 * }
	 * 
	 * @FXML void handleDeleteButtonStockAl(ActionEvent event) throws Exception {
	 * 
	 * }
	 * 
	 * @FXML void handleLoginButton(ActionEvent event) throws Exception {
	 * 
	 * }
	 * 
	 * @FXML void handleModifButtonAlim(ActionEvent event) throws Exception {
	 * 
	 * }
	 * 
	 * @FXML void handleModifButtonBande(ActionEvent event) throws Exception {
	 * 
	 * }
	 * 
	 * @FXML void handleModifButtonCollecteOeuf(ActionEvent event) throws Exception
	 * {
	 * 
	 * }
	 * 
	 * @FXML void handleModifButtonFourn(ActionEvent event) throws Exception {
	 * 
	 * }
	 * 
	 * @FXML void handleModifButtonRace(ActionEvent event) throws Exception {
	 * 
	 * }
	 * 
	 * @FXML void handleModifButtonStockAl(ActionEvent event) throws Exception {
	 * 
	 * }
	 * 
	 * @FXML void handleParamButton(ActionEvent event) throws Exception {
	 * 
	 * }
	 */

	@Override
	public void initialize(URL location, ResourceBundle resources) {
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

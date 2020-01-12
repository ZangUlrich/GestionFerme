package view;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
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

	    @FXML
	    void handleAddButtonVentes(ActionEvent event) {

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
		private ObservableList<ObservableList> data;	    
	    
	    
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			ConnectionBD connectionBD=new ConnectionBD(); try {
				connectionBD.afficheRace(data, tableRace);
				connectionBD.afficheBande(data, tableBande);
				connectionBD.afficheCollecteOeuf(data, tableCollecteOeuf);
				connectionBD.afficheVentes(data, tableVentes);
			} catch (SQLException e) {
				e.printStackTrace(); } try { connectionBD.Close(); } catch (SQLException e) {
					e.printStackTrace(); }
			
		}
	
	
	
}

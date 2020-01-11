package view;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import model.ConnectionBD;

public class MenuComController implements Initializable {

	 @FXML
	    private JFXButton ajoutButton;

	    @FXML
	    private JFXButton deleteButton;

	    @FXML
	    private TableView<?> tableRace;

	    @FXML
	    private JFXButton ajoutButton1;

	    @FXML
	    private JFXButton deleteButton1;

	    @FXML
	    private TableView<?> tableBande;

	    @FXML
	    private JFXButton ajoutButton2;

	    @FXML
	    private JFXButton deleteButton2;

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

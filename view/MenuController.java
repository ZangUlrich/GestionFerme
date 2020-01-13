package view;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import model.ConnectionBD;


public class MenuController implements Initializable{

	@FXML
    private JFXButton ajoutButton;

    @FXML
    private JFXButton deleteButton;

    @FXML
    private TableView<?> tableRace;
    
    @FXML
    private TableView<?> tableBande;
    
    @FXML
    private ObservableList<ObservableList> data=FXCollections.observableArrayList();
    
    @FXML
    private TableView<?> tableAliment;

    @FXML
    private TableView<?> tableStockAli;

    @FXML
    private TableView<?> tableFournis;

    @FXML
    private TableView<?> tableCollecteOeuf;

    @FXML
    private TableView<?> tableIncubation;

    @FXML
    private TableView<?> tableVaccin;

    @FXML
    private TableView<?> tableMaladie;
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		  ConnectionBD connectionBD=new ConnectionBD(); try {
		  connectionBD.afficheRace(data, tableRace);
		  connectionBD.afficheBande(data, tableBande);
		  connectionBD.afficheAliment(data, tableAliment);
		  connectionBD.afficheCollecteOeuf(data, tableCollecteOeuf);
		  connectionBD.afficheFournisseur(data, tableFournis);
		  connectionBD.afficheIncubation(data, tableIncubation);
		  connectionBD.afficheMaladie(data, tableMaladie);
		  connectionBD.afficheStockAliment(data, tableStockAli);
		  connectionBD.afficheVaccin(data, tableVaccin);
		  
		  } catch (SQLException e) {
		  e.printStackTrace(); } try { connectionBD.Close(); } catch (SQLException e) {
		  e.printStackTrace(); }
		 
		 		
	}
	

}

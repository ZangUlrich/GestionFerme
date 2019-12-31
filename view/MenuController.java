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


public class MenuController implements Initializable{

	@FXML
    private JFXButton ajoutButton;

    @FXML
    private JFXButton deleteButton;

    @FXML
    private TableView<?> table;
    private ObservableList<ObservableList> data;
    
    
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		/*
		 * ConnectionBD connectionBD=new ConnectionBD(); try {
		 * connectionBD.afficheRace(data, table); } catch (SQLException e) {
		 * e.printStackTrace(); } try { connectionBD.Close(); } catch (SQLException e) {
		 * e.printStackTrace(); }
		 */		
	}
	

}

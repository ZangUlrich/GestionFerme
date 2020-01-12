package view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import application.Main;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import model.ConnectionBD;

public class SuppressionController implements Initializable{
	

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private JFXButton okButton;

	@FXML
	private JFXButton cancelButton;

	@FXML
	private JFXTextField insertionId;

	
	
	@FXML
	void handleCancelButton(ActionEvent event) {
		
		main.getStageDelete().close();
	}
	
	private Main main=new Main();
	
	@FXML
	void handleOkButton(ActionEvent event) throws SQLException {
		ConnectionBD connectionBD=new ConnectionBD();
		MenuFerController menuFerController = new MenuFerController();
		connectionBD.suppression(menuFerController.strNomTable, menuFerController.strId+insertionId.getText());
		menuFerController.setTables();
		main.getStageDelete().close();
	}



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
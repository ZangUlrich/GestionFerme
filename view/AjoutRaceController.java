package view;

import java.sql.SQLException;
import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.ConnectionBD;



public class AjoutRaceController {


	@FXML
	private JFXButton okButton;

	@FXML
	private JFXTextField nomRace;

	@FXML
	private JFXTextField descRace;

	@FXML
	private JFXTextField prixRace;

	@FXML
	private JFXButton cancelButton;
	
	private Main main=new Main();
	
	@FXML
	void handleCancelButton(ActionEvent event) {
		main.getStageDelete().close();
	}

	@FXML
	void handleOkButton(ActionEvent event) throws SQLException {
		
		ConnectionBD connectionBD=new ConnectionBD();
		MenuFerController menuFerController = new MenuFerController();
		ArrayList<String> strings =new ArrayList<String>();
		strings.add(nomRace.getText());
		strings.add(descRace.getText());
		strings.add(prixRace.getText());
		connectionBD.ajoutRace(strings);
		menuFerController.setTables();
		main.getStageDelete().close();
	}

}


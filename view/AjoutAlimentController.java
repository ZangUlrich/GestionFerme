package view;

import java.sql.SQLException;
import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.ConnectionBD;


public class AjoutAlimentController {



	@FXML
	private Label addLabel;

	@FXML
	private Label nameLabel;

	@FXML
	private Label priceLabel;

	@FXML
	private Label descripLabel;

	@FXML
	private JFXTextField nomAliment;

	@FXML
	private JFXTextArea descAliment;

	@FXML
	private JFXTextField prixAliment;

	@FXML
	private JFXButton okButton;

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
		strings.add(nomAliment.getText());
		strings.add(descAliment.getText());
		strings.add(prixAliment.getText());
		connectionBD.ajoutAliment(strings);
		menuFerController.setTables();
		main.getStageDelete().close();
	}

}

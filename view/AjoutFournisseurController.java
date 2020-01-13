package view;

import java.sql.SQLException;
import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.ConnectionBD;

public class AjoutFournisseurController {



	@FXML
	private JFXTextField nomFourn;

	@FXML
	private JFXTextField adresseFourn;

	@FXML
	private JFXTextField numeroFourn;

	@FXML
	private JFXTextField siteWebFourn;

	@FXML
	private JFXTextField TypeFourn;

	@FXML
	private JFXTextField emailFourn;

	@FXML
	private JFXButton cancelButton;

	@FXML
	private JFXButton okButton;

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
		strings.add(nomFourn.getText());
		strings.add(adresseFourn.getText());
		strings.add(numeroFourn.getText());
		strings.add(emailFourn.getText());
		strings.add(siteWebFourn.getText());
		strings.add(TypeFourn.getText());
		connectionBD.ajoutFournisseur(strings);
		menuFerController.setTables();
		main.getStageDelete().close();
	}

}


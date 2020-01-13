package view;

import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.ConnectionBD;

public class AjoutBandeController {

	@FXML
	private JFXTextField idRace;

	@FXML
	private JFXTextField prixAchat;

	@FXML
	private JFXTextField age;

	@FXML
	private JFXTextField prixVente;

	@FXML
	private JFXTextField quantite;

	@FXML
	private JFXTextField idFournisseur;

	@FXML
	private JFXButton okButton;

	@FXML
	private JFXButton cancelButton;

	@FXML
    private JFXDatePicker dateDemarrage;
	
	@FXML
    private JFXTextField batiment;

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
		strings.add(quantite.getText());
		strings.add(age.getText());
		strings.add(idRace.getText());
		strings.add(prixAchat.getText());
		strings.add(prixVente.getText());
		strings.add(dateDemarrage.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		strings.add(idFournisseur.getText());
		strings.add(batiment.getText());
		connectionBD.ajoutBande(strings);
		menuFerController.setTables();
		main.getStageDelete().close();
	}

}




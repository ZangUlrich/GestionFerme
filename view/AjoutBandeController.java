package view;

import java.net.URL;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import model.ConnectionBD;

public class AjoutBandeController implements Initializable {

	@FXML
	private JFXComboBox idRace;

	private ObservableList<String> data;
	
	@FXML
	private JFXTextField prixAchat;

	@FXML
	private JFXTextField age;

	@FXML
	private JFXTextField prixVente;

	@FXML
	private JFXTextField quantite;

	@FXML
	private JFXComboBox idFourn;

	@FXML
	private JFXButton okButton;

	@FXML
	private JFXButton cancelButton;

	@FXML
    private JFXDatePicker dateDemarrage;
	
	@FXML
    private JFXTextField batiment;

	private Main main=new Main();
	
	private ConnectionBD connectionBD=new ConnectionBD();
	
	@FXML
	void handleCancelButton(ActionEvent event) {
		main.getStageDelete().close();
	}

	@FXML
	void handleOkButton(ActionEvent event) throws SQLException {
		
		
		MenuFerController menuFerController = new MenuFerController();
		ArrayList<String> strings =new ArrayList<String>();
		strings.add(quantite.getText());
		strings.add(age.getText());
		strings.add(connectionBD.getRaceId(idRace.getValue().toString()));
		strings.add(prixAchat.getText());
		strings.add(prixVente.getText());
		strings.add(dateDemarrage.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		strings.add(connectionBD.getFournisseurId(idFourn.getValue().toString()));
		strings.add(batiment.getText());
		System.out.println(strings);
		connectionBD.ajoutBande(strings);
		menuFerController.setTables();
		main.getStageDelete().close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		try {
			data = connectionBD.getRaceNom();
			idRace.setItems(data);
			data = connectionBD.getFournisseurNom();
			idFourn.setItems(data);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

}




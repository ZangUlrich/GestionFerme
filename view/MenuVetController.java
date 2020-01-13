package view;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import model.ConnectionBD;

public class MenuVetController implements Initializable{

	@FXML
	private JFXButton ajoutButtonVaccins;

	@FXML
	private JFXButton deleteButtonVaccins;

	@FXML
	private JFXButton modifButtonVaccins;

	@FXML
    private TableView<?> tableVaccins;
	
	@FXML
    private TableView<?> tableMaladies;

    @FXML
    private TableView<?> tableBande;
	
	@FXML
	private JFXButton ajoutButtonMaladies;

	@FXML
	private JFXButton deleteButtonMaladies;

	@FXML
	private JFXButton modifButtonMaladies;
	
	@FXML
    void handleAddButtonMaladies(ActionEvent event) {

    }

    @FXML
    void handleAddButtonVaccins(ActionEvent event) {

    }

    @FXML
    void handleDeleteButtonMaladies(ActionEvent event) {

    }

    @FXML
    void handleDeleteButtonVaccins(ActionEvent event) {

    }

    @FXML
    void handleModifButtonMaladies(ActionEvent event) {

    }

    @FXML
    void handleModifButtonVaccins(ActionEvent event) {

    }
	
	static ObservableList<ObservableList> data=FXCollections.observableArrayList();
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		ConnectionBD connectionBD=new ConnectionBD(); try {
			connectionBD.afficheBande(data, tableBande);
			connectionBD.afficheMaladie(data, tableMaladies);
			connectionBD.afficheVaccin(data, tableVaccins);
			
		} catch (SQLException e) {
			e.printStackTrace(); } try { connectionBD.Close(); } catch (SQLException e) {
				e.printStackTrace(); }


	}




}

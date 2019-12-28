package view;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;


public class MenuController implements Initializable{

	@FXML
    private JFXButton ajoutButton;

    @FXML
    private JFXButton deleteButton;

    @FXML
    private TableView<?> table;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	

}

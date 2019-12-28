package view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class LoginController implements Initializable{

	@FXML
	private JFXTextField user_name;

	@FXML
	private JFXTextField user_password;

	@FXML
	private JFXButton loginButton;

	@FXML
	private JFXButton cancelButton;

	@FXML
	private Label statut_label;
	
	private static Main main=new Main(); 
	
	@FXML
	void handleCancelButton(ActionEvent event) throws Exception {
		main.getStage().close();
	}

	@FXML
	void handleLoginButton(ActionEvent event) throws IOException, SQLException {
		String str;
		ConnectionBD connectionBD=new ConnectionBD();
		str= connectionBD.employes(user_name.getText(),user_password.getText());
		if (str==null) {
			statut_label.setText("Incorrecte");
		}
		else {
			System.out.println(str);
			if (str.equals("cont")) {
				main.menu();
			}
			else if (str.equals("vet")) {
				main.menu_vet();
			}
			else if (str.equals("com")) {
				main.menu_com();
			}
			else {
				main.menu_fer();
			}
			
		}
		connectionBD.Close();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}

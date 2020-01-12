package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	private static Stage ref;
	private static Stage ref1;
	
	public Stage getStage() {
		return ref;
	}
	
	public Stage getStageDelete() {
		return ref1;
	}
	
	@Override
	public void start(Stage primaryStage) throws IOException {
			
			URL ressource = Main.class.getResource("../view/Login.fxml"); 
			Parent root = FXMLLoader.load(ressource);
			Scene scene = new Scene(root);
			primaryStage.setTitle("Ferme");
			ref=primaryStage;
			System.out.println(ref);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
	}
	
	public void menu() throws IOException {
		URL ressource = Main.class.getResource("../view/Menu.fxml"); 
		Parent root = FXMLLoader.load(ressource);
		Scene scene = new Scene(root);
		System.out.println(ref);
		ref.setScene(scene);
		ref.setTitle("Controlleur");
		ref.setResizable(true);
		ref.setScene(scene);
		ref.show();
	}
	
	public void menu_vet() throws IOException {
		URL ressource = Main.class.getResource("../view/Menu_vet.fxml"); 
		Parent root = FXMLLoader.load(ressource);
		Scene scene = new Scene(root);
		System.out.println(ref);
		ref.setScene(scene);
		ref.setTitle("Veterinaire");
		ref.setResizable(true);
		ref.setScene(scene);
		ref.show();
	}
	
	public void menu_com() throws IOException {
		URL ressource = Main.class.getResource("../view/Menu_com.fxml"); 
		Parent root = FXMLLoader.load(ressource);
		Scene scene = new Scene(root);
		System.out.println(ref);
		ref.setScene(scene);
		ref.setTitle("Commercial");
		ref.setResizable(true);
		ref.setScene(scene);
		ref.show();
	}
	
	public void menu_fer() throws IOException {
		URL ressource = Main.class.getResource("../view/Menu_fer.fxml"); 
		Parent root = FXMLLoader.load(ressource);
		Scene scene = new Scene(root);
		System.out.println(ref);
		ref.setScene(scene);
		ref.setTitle("Fermier");
		ref.setResizable(true);
		ref.setScene(scene);
		ref.show();
	}
	
	public void suppression(Stage newstage) throws IOException {
		URL ressource = Main.class.getResource("../view/Suppression.fxml"); 
		Parent root = FXMLLoader.load(ressource);
		Scene scene = new Scene(root);
		ref1=newstage;
		newstage.setScene(scene);
		newstage.setTitle("Suppression");
		newstage.setResizable(false);
		newstage.setScene(scene);
		newstage.show();
	}
	
	public void ajoutRace(Stage newstage) throws IOException {
		URL ressource = Main.class.getResource("../view/Ajout_race.fxml"); 
		Parent root = FXMLLoader.load(ressource);
		Scene scene = new Scene(root);
		ref1=newstage;
		newstage.setScene(scene);
		newstage.setTitle("Ajout de Race");
		newstage.setResizable(false);
		newstage.setScene(scene);
		newstage.show();
	}
	
	
	
	public static void main(String[] args) throws SQLException {
		launch(args);
	}
}

package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

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
			primaryStage.setTitle("Login");
			ref=primaryStage;
			ref.getIcons().add(new Image(Main.class.getResourceAsStream("iconApp.png")));
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
		ref.getIcons().add(new Image(Main.class.getResourceAsStream("iconApp.png")));
		ref.setScene(scene);
		ref.setTitle("Controlleur");
		ref.setResizable(false);
		ref.setScene(scene);
		ref.show();
	}
	
	public void menu_vet() throws IOException {
		URL ressource = Main.class.getResource("../view/Menu_vet.fxml"); 
		Parent root = FXMLLoader.load(ressource);
		Scene scene = new Scene(root);
		System.out.println(ref);
		ref.getIcons().add(new Image(Main.class.getResourceAsStream("iconApp.png")));
		ref.setScene(scene);
		ref.setTitle("Veterinaire");
		ref.setResizable(false);
		ref.setScene(scene);
		ref.show();
	}
	
	public void menu_com() throws IOException {
		URL ressource = Main.class.getResource("../view/Menu_com.fxml"); 
		Parent root = FXMLLoader.load(ressource);
		Scene scene = new Scene(root);
		System.out.println(ref);
		ref.getIcons().add(new Image(Main.class.getResourceAsStream("iconApp.png")));
		ref.setScene(scene);
		ref.setTitle("Commercial");
		ref.setResizable(false);
		ref.setScene(scene);
		ref.show();
	}
	
	public void menu_fer() throws IOException {
		URL ressource = Main.class.getResource("../view/Menu_fer.fxml"); 
		Parent root = FXMLLoader.load(ressource);
		Scene scene = new Scene(root);
		ref.getIcons().add(new Image(Main.class.getResourceAsStream("iconApp.png")));
		System.out.println(ref);
		ref.setScene(scene);
		ref.setTitle("Fermier");
		ref.setResizable(false);
		ref.setScene(scene);
		ref.show();
	}
	
	public void suppression(Stage newstage) throws IOException {
		URL ressource = Main.class.getResource("../view/Suppression.fxml"); 
		Parent root = FXMLLoader.load(ressource);
		Scene scene = new Scene(root);
		ref1=newstage;
		ref1.getIcons().add(new Image(Main.class.getResourceAsStream("iconApp.png")));
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
		ref1.getIcons().add(new Image(Main.class.getResourceAsStream("iconApp.png")));
		newstage.setScene(scene);
		newstage.setTitle("Ajout de Race");
		newstage.setResizable(false);
		newstage.setScene(scene);
		newstage.show();
	}
	
	public void ajoutFournisseur(Stage newstage) throws IOException {
		URL ressource = Main.class.getResource("../view/AjoutFournisseur.fxml"); 
		Parent root = FXMLLoader.load(ressource);
		Scene scene = new Scene(root);
		ref1=newstage;
		ref1.getIcons().add(new Image(Main.class.getResourceAsStream("iconApp.png")));
		newstage.setScene(scene);
		newstage.setTitle("Ajout de Fournisseur");
		newstage.setResizable(false);
		newstage.setScene(scene);
		newstage.show();
	}

	public void ajoutAliment(Stage newstage) throws IOException {
		URL ressource = Main.class.getResource("../view/Ajout_aliment.fxml"); 
		Parent root = FXMLLoader.load(ressource);
		Scene scene = new Scene(root);
		ref1=newstage;
		ref1.getIcons().add(new Image(Main.class.getResourceAsStream("iconApp.png")));
		newstage.setScene(scene);
		newstage.setTitle("Ajout d'Aliment");
		newstage.setResizable(false);
		newstage.setScene(scene);
		newstage.show();
	}

	
	public void ajoutBande(Stage newstage) throws IOException {
		URL ressource = Main.class.getResource("../view/Ajout_bande.fxml"); 
		Parent root = FXMLLoader.load(ressource);
		Scene scene = new Scene(root);
		ref1=newstage;
		ref1.getIcons().add(new Image(Main.class.getResourceAsStream("iconApp.png")));
		newstage.setScene(scene);
		newstage.setTitle("Ajout d'une bande");
		newstage.setResizable(false);
		newstage.setScene(scene);
		newstage.show();
	}
	
	public void ajoutCollecteOeuf(Stage newstage) throws IOException {
		URL ressource = Main.class.getResource("../view/Ajout_collecte_oeuf.fxml"); 
		Parent root = FXMLLoader.load(ressource);
		Scene scene = new Scene(root);
		ref1=newstage;
		ref1.getIcons().add(new Image(Main.class.getResourceAsStream("iconApp.png")));
		newstage.setScene(scene);
		newstage.setTitle("Ajout d'une bande");
		newstage.setResizable(false);
		newstage.setScene(scene);
		newstage.show();
	}
	
	public void ajoutStockAliment(Stage newstage) throws IOException {
		URL ressource = Main.class.getResource("../view/Ajout_stockaliment.fxml"); 
		Parent root = FXMLLoader.load(ressource);
		Scene scene = new Scene(root);
		ref1=newstage;
		ref1.getIcons().add(new Image(Main.class.getResourceAsStream("iconApp.png")));
		newstage.setScene(scene);
		newstage.setTitle("Ajout d'un stock d'aliment");
		newstage.setResizable(false);
		newstage.setScene(scene);
		newstage.show();
	}
	
	public void ajoutVente(Stage newstage) throws IOException {
		URL ressource = Main.class.getResource("../view/Ajout_vendu.fxml"); 
		Parent root = FXMLLoader.load(ressource);
		Scene scene = new Scene(root);
		ref1=newstage;
		ref1.getIcons().add(new Image(Main.class.getResourceAsStream("iconApp.png")));
		newstage.setScene(scene);
		newstage.setTitle("Ajout d'une vente de poule");
		newstage.setResizable(false);
		newstage.setScene(scene);
		newstage.show();
	}
	
	public void ajoutVenteOeuf(Stage newstage) throws IOException {
		URL ressource = Main.class.getResource("../view/Ajout_vendu_oeuf.fxml"); 
		Parent root = FXMLLoader.load(ressource);
		Scene scene = new Scene(root);
		ref1=newstage;
		ref1.getIcons().add(new Image(Main.class.getResourceAsStream("iconApp.png")));
		newstage.setScene(scene);
		newstage.setTitle("Ajout d'une vente d'oeuf");
		newstage.setResizable(false);
		newstage.setScene(scene);
		newstage.show();
	}
	
	
	public static void main(String[] args) throws SQLException {
		launch(args);
	}
}

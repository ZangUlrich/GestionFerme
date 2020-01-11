package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.util.Callback;

/**
 * Classe de connection à la bd et de manipulation des différentes
 * requetes. Caractérisée par l'attribut <B>con</B> de type Connection
 * @author HARA_ZANG_Ulrich
 * 
 */
public class ConnectionBD {
	private Connection con;
	/**
	 * Constructeur de la classe ConnectionBD permettant d'initialiser la connection
	 * a la base de données.
	 */
	public ConnectionBD() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println(e);
		}

		try {
			String BDD = "volailleDor"; //A modifier en fonction de votre base de données
			String url = "jdbc:mysql://localhost:3306/" + BDD;
			String user = "root"; //A modifier selon la base de données concernée
			String passwd = "L@vieestungrandmystere17p165"; //A modifier selon la base de données concernée
			con=DriverManager.getConnection(url,user,passwd);
		} catch (SQLException e) {
			System.err.println(e);
		}
	}

	/**
	 * Methode permettant d'obtenir la connection <B>con</B>
	 * @return la Connection au la base de données 
	 */
	Connection obtenirConnection() {
		return con;
	}

	/**
	 * Methode permettant de vérifier si un utilisateur entre au niveau du
	 * login existe dans la base de données.
	 * @param user un String qui contient le nom d'utilisateur entre dans le login
	 * @param pswd un String qui contient le mot de passe entre dans le login
	 * @return un String qui contient le type de l'employe: cont, vet, com, fer, ou null
	 * si la requete n'aboutit pas
	 * @throws SQLException
	 */
	public String employes(String user,String pswd) throws SQLException {
		String str = null;
		Statement statement=null;
		String query =null;
		ResultSet resultSet=null;
		statement= (Statement) con.createStatement();
		query= "select typeEm from employes where ";	
		query+="user='";
		query+=user+"' and login='"+pswd+"'";
		resultSet=statement.executeQuery(query);

		while(resultSet.next()) {
			str=resultSet.getString(1);
		}
		
		return str;
	}
	
	public void afficheRace(ObservableList<ObservableList> data,TableView tableview) throws SQLException
	{
		System.out.println("Table race");
		data = FXCollections.observableArrayList();
		Statement statement=null;
		String query =null;
		ResultSet resultSet=null;
		statement= (Statement) con.createStatement();
		query="select * from Race";
		resultSet=statement.executeQuery(query);
		
		for(int i=0 ; i<resultSet.getMetaData().getColumnCount(); i++){
            //We are using non property style for making dynamic table
            final int j = i;                
            TableColumn col = new TableColumn(resultSet.getMetaData().getColumnName(i+1));
            col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
                    return new SimpleStringProperty(param.getValue().get(j).toString());                        
                }                    
            });

            tableview.getColumns().addAll(col); 
            System.out.println("Column ["+i+"] ");
        }

        /********************************
         * Data added to ObservableList *
         ********************************/
        while(resultSet.next()){
            //Iterate Row
            ObservableList<String> row = FXCollections.observableArrayList();
            for(int i=1 ; i<=resultSet.getMetaData().getColumnCount(); i++){
                //Iterate Column
                row.add(resultSet.getString(i));
            }
            System.out.println("Row [1] added "+row );
            data.add(row);

        }

        //FINALLY ADDED TO TableView
        tableview.setItems(data);

	}

	public void afficheBande(ObservableList<ObservableList> data,TableView tableview) throws SQLException
	{
		System.out.println("Table bande");
		data = FXCollections.observableArrayList();
		Statement statement=null;
		String query =null;
		ResultSet resultSet=null;
		statement= (Statement) con.createStatement();
		query="select * from Bande";
		resultSet=statement.executeQuery(query);
		
		for(int i=0 ; i<resultSet.getMetaData().getColumnCount(); i++){
            //We are using non property style for making dynamic table
            final int j = i;                
            TableColumn col = new TableColumn(resultSet.getMetaData().getColumnName(i+1));
            col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
                    return new SimpleStringProperty(param.getValue().get(j).toString());                        
                }                    
            });

            tableview.getColumns().addAll(col); 
            System.out.println("Column ["+i+"] ");
        }

        /********************************
         * Data added to ObservableList *
         ********************************/
        while(resultSet.next()){
            //Iterate Row
            ObservableList<String> row = FXCollections.observableArrayList();
            for(int i=1 ; i<=resultSet.getMetaData().getColumnCount(); i++){
                //Iterate Column
                row.add(resultSet.getString(i));
            }
            System.out.println("Row [1] added "+row );
            data.add(row);

        }

        //FINALLY ADDED TO TableView
        tableview.setItems(data);

	}
	
	
	public void afficheAliment(ObservableList<ObservableList> data,TableView tableview) throws SQLException
	{
		System.out.println("Table Aliment");
		data = FXCollections.observableArrayList();
		Statement statement=null;
		String query =null;
		ResultSet resultSet=null;
		statement= (Statement) con.createStatement();
		query="select * from Aliment";
		resultSet=statement.executeQuery(query);
		
		for(int i=0 ; i<resultSet.getMetaData().getColumnCount(); i++){
            //We are using non property style for making dynamic table
            final int j = i;                
            TableColumn col = new TableColumn(resultSet.getMetaData().getColumnName(i+1));
            col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
                    return new SimpleStringProperty(param.getValue().get(j).toString());                        
                }                    
            });

            tableview.getColumns().addAll(col); 
            System.out.println("Column ["+i+"] ");
        }

        /********************************
         * Data added to ObservableList *
         ********************************/
        while(resultSet.next()){
            //Iterate Row
            ObservableList<String> row = FXCollections.observableArrayList();
            for(int i=1 ; i<=resultSet.getMetaData().getColumnCount(); i++){
                //Iterate Column
                row.add(resultSet.getString(i));
            }
            System.out.println("Row [1] added "+row );
            data.add(row);

        }

        //FINALLY ADDED TO TableView
        tableview.setItems(data);

	}
	
	
	public void afficheStockAliment(ObservableList<ObservableList> data,TableView tableview) throws SQLException
	{
		System.out.println("Table StockAliment");
		data = FXCollections.observableArrayList();
		Statement statement=null;
		String query =null;
		ResultSet resultSet=null;
		statement= (Statement) con.createStatement();
		query="select * from StockAliment";
		resultSet=statement.executeQuery(query);
		
		for(int i=0 ; i<resultSet.getMetaData().getColumnCount(); i++){
            //We are using non property style for making dynamic table
            final int j = i;                
            TableColumn col = new TableColumn(resultSet.getMetaData().getColumnName(i+1));
            col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
                    return new SimpleStringProperty(param.getValue().get(j).toString());                        
                }                    
            });

            tableview.getColumns().addAll(col); 
            System.out.println("Column ["+i+"] ");
        }

        /********************************
         * Data added to ObservableList *
         ********************************/
        while(resultSet.next()){
            //Iterate Row
            ObservableList<String> row = FXCollections.observableArrayList();
            for(int i=1 ; i<=resultSet.getMetaData().getColumnCount(); i++){
                //Iterate Column
                row.add(resultSet.getString(i));
            }
            System.out.println("Row [1] added "+row );
            data.add(row);

        }

        //FINALLY ADDED TO TableView
        tableview.setItems(data);

	}
	
	public void afficheFournisseur(ObservableList<ObservableList> data,TableView tableview) throws SQLException
	{
		System.out.println("Table fournisseur");
		data = FXCollections.observableArrayList();
		Statement statement=null;
		String query =null;
		ResultSet resultSet=null;
		statement= (Statement) con.createStatement();
		query="select * from Fournisseur";
		resultSet=statement.executeQuery(query);
		
		for(int i=0 ; i<resultSet.getMetaData().getColumnCount(); i++){
            //We are using non property style for making dynamic table
            final int j = i;                
            TableColumn col = new TableColumn(resultSet.getMetaData().getColumnName(i+1));
            col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
                    return new SimpleStringProperty(param.getValue().get(j).toString());                        
                }                    
            });

            tableview.getColumns().addAll(col); 
            System.out.println("Column ["+i+"] ");
        }

        /********************************
         * Data added to ObservableList *
         ********************************/
        while(resultSet.next()){
            //Iterate Row
            ObservableList<String> row = FXCollections.observableArrayList();
            for(int i=1 ; i<=resultSet.getMetaData().getColumnCount(); i++){
                //Iterate Column
                row.add(resultSet.getString(i));
            }
            System.out.println("Row [1] added "+row );
            data.add(row);

        }

        //FINALLY ADDED TO TableView
        tableview.setItems(data);

	}
	
	
	public void afficheCollecteOeuf(ObservableList<ObservableList> data,TableView tableview) throws SQLException
	{
		System.out.println("Table collecte Oeuf");
		data = FXCollections.observableArrayList();
		Statement statement=null;
		String query =null;
		ResultSet resultSet=null;
		statement= (Statement) con.createStatement();
		query="select * from CollecteOeuf";
		resultSet=statement.executeQuery(query);
		
		for(int i=0 ; i<resultSet.getMetaData().getColumnCount(); i++){
            //We are using non property style for making dynamic table
            final int j = i;                
            TableColumn col = new TableColumn(resultSet.getMetaData().getColumnName(i+1));
            col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
                    return new SimpleStringProperty(param.getValue().get(j).toString());                        
                }                    
            });

            tableview.getColumns().addAll(col); 
            System.out.println("Column ["+i+"] ");
        }

        /********************************
         * Data added to ObservableList *
         ********************************/
        while(resultSet.next()){
            //Iterate Row
            ObservableList<String> row = FXCollections.observableArrayList();
            for(int i=1 ; i<=resultSet.getMetaData().getColumnCount(); i++){
                //Iterate Column
                row.add(resultSet.getString(i));
            }
            System.out.println("Row [1] added "+row );
            data.add(row);

        }

        //FINALLY ADDED TO TableView
        tableview.setItems(data);

	}
	
	
	public void afficheIncubation(ObservableList<ObservableList> data,TableView tableview) throws SQLException
	{
		System.out.println("Table Incubation");
		data = FXCollections.observableArrayList();
		Statement statement=null;
		String query =null;
		ResultSet resultSet=null;
		statement= (Statement) con.createStatement();
		query="select * from Incubation";
		resultSet=statement.executeQuery(query);
		
		for(int i=0 ; i<resultSet.getMetaData().getColumnCount(); i++){
            //We are using non property style for making dynamic table
            final int j = i;                
            TableColumn col = new TableColumn(resultSet.getMetaData().getColumnName(i+1));
            col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
                    return new SimpleStringProperty(param.getValue().get(j).toString());                        
                }                    
            });

            tableview.getColumns().addAll(col); 
            System.out.println("Column ["+i+"] ");
        }

        /********************************
         * Data added to ObservableList *
         ********************************/
        while(resultSet.next()){
            //Iterate Row
            ObservableList<String> row = FXCollections.observableArrayList();
            for(int i=1 ; i<=resultSet.getMetaData().getColumnCount(); i++){
                //Iterate Column
                row.add(resultSet.getString(i));
            }
            System.out.println("Row [1] added "+row );
            data.add(row);

        }

        //FINALLY ADDED TO TableView
        tableview.setItems(data);

	}
	
	public void afficheVaccin(ObservableList<ObservableList> data,TableView tableview) throws SQLException
	{
		System.out.println("Table vaccin");
		data = FXCollections.observableArrayList();
		Statement statement=null;
		String query =null;
		ResultSet resultSet=null;
		statement= (Statement) con.createStatement();
		query="select * from Vaccin";
		resultSet=statement.executeQuery(query);
		
		for(int i=0 ; i<resultSet.getMetaData().getColumnCount(); i++){
            //We are using non property style for making dynamic table
            final int j = i;                
            TableColumn col = new TableColumn(resultSet.getMetaData().getColumnName(i+1));
            col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
                    return new SimpleStringProperty(param.getValue().get(j).toString());                        
                }                    
            });

            tableview.getColumns().addAll(col); 
            System.out.println("Column ["+i+"] ");
        }

        /********************************
         * Data added to ObservableList *
         ********************************/
        while(resultSet.next()){
            //Iterate Row
            ObservableList<String> row = FXCollections.observableArrayList();
            for(int i=1 ; i<=resultSet.getMetaData().getColumnCount(); i++){
                //Iterate Column
                row.add(resultSet.getString(i));
            }
            System.out.println("Row [1] added "+row );
            data.add(row);

        }

        //FINALLY ADDED TO TableView
        tableview.setItems(data);

	}
	
	public void afficheMaladie(ObservableList<ObservableList> data,TableView tableview) throws SQLException
	{
		System.out.println("Table maladie");
		data = FXCollections.observableArrayList();
		Statement statement=null;
		String query =null;
		ResultSet resultSet=null;
		statement= (Statement) con.createStatement();
		query="select * from Maladie";
		resultSet=statement.executeQuery(query);
		
		for(int i=0 ; i<resultSet.getMetaData().getColumnCount(); i++){
            //We are using non property style for making dynamic table
            final int j = i;                
            TableColumn col = new TableColumn(resultSet.getMetaData().getColumnName(i+1));
            col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
                    return new SimpleStringProperty(param.getValue().get(j).toString());                        
                }                    
            });

            tableview.getColumns().addAll(col); 
            System.out.println("Column ["+i+"] ");
        }

        /********************************
         * Data added to ObservableList *
         ********************************/
        while(resultSet.next()){
            //Iterate Row
            ObservableList<String> row = FXCollections.observableArrayList();
            for(int i=1 ; i<=resultSet.getMetaData().getColumnCount(); i++){
                //Iterate Column
                row.add(resultSet.getString(i));
            }
            System.out.println("Row [1] added "+row );
            data.add(row);

        }

        //FINALLY ADDED TO TableView
        tableview.setItems(data);

	}
	
	
	public void afficheVentes(ObservableList<ObservableList> data,TableView tableview) throws SQLException
	{
		System.out.println("Table Ventes");
		data = FXCollections.observableArrayList();
		Statement statement=null;
		String query =null;
		ResultSet resultSet=null;
		statement= (Statement) con.createStatement();
		query="select * from Ventes";
		resultSet=statement.executeQuery(query);
		
		for(int i=0 ; i<resultSet.getMetaData().getColumnCount(); i++){
            //We are using non property style for making dynamic table
            final int j = i;                
            TableColumn col = new TableColumn(resultSet.getMetaData().getColumnName(i+1));
            col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
                    return new SimpleStringProperty(param.getValue().get(j).toString());                        
                }                    
            });

            tableview.getColumns().addAll(col); 
            System.out.println("Column ["+i+"] ");
        }

        /********************************
         * Data added to ObservableList *
         ********************************/
        while(resultSet.next()){
            //Iterate Row
            ObservableList<String> row = FXCollections.observableArrayList();
            for(int i=1 ; i<=resultSet.getMetaData().getColumnCount(); i++){
                //Iterate Column
                row.add(resultSet.getString(i));
            }
            System.out.println("Row [1] added "+row );
            data.add(row);

        }

        //FINALLY ADDED TO TableView
        tableview.setItems(data);

	}
	
	
	
	/**
	 * Methode de fermeture de la connection a la bd
	 * @throws SQLException
	 */
	public void Close() throws SQLException {
		con.close();
	}
}

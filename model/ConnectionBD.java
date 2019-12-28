package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;

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
			String BDD = "volailleDor";
			String url = "jdbc:mysql://localhost:3306/" + BDD;
			String user = "root";
			String passwd = "L@vieestungrandmystere17p165";
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
	
	/**
	 * Methode de fermeture de la connection a la bd
	 * @throws SQLException
	 */
	public void Close() throws SQLException {
		con.close();
	}
}

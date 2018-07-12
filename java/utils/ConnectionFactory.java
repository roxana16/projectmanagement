package utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionFactory {
	
	public static Connection getConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/gestionar";
			String username = "root";
			String password = "sqlroot";
			
			Connection connection = DriverManager.getConnection(url, username, password);
			
			return connection;
		} catch (SQLException | ClassNotFoundException ex) {
			throw new RuntimeException("Error connecting to the database", ex);
		}
	}
}

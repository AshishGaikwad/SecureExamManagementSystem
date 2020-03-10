package batu.dev.sem.utils;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class MySQLConnector {
	private final static  String lDatabaseURL = Util.getProperty("Config", "DBURL") ;
	private final static  String lDatabaseUser = Util.getProperty("Config", "DBUSER") ;
	private final static String lDatabasePass = Util.getProperty("Config", "DBPASS") ;
	
	private static Connection lConnection= null;
	
	
	private static MySQLConnector lMySQLConnector = null;
	
	
	//Singleton Desing pattern implemented here for flexible connection
	public static MySQLConnector getInstance()
	{
		if(lMySQLConnector == null)
		{
			synchronized (MySQLConnector.class) {
				lMySQLConnector = new MySQLConnector();
			}
		}
		return lMySQLConnector;
	}
	
	public static Connection getConnection()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			lConnection = (Connection) DriverManager.getConnection(lDatabaseURL, lDatabaseUser, lDatabasePass);
			return lConnection;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	

	public static void main(String[] args) throws SQLException {
//		System.out.println("Connetion "+getConnection());
	}
	
}

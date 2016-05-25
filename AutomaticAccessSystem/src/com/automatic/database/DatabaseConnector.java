
package com.automatic.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector 
{
	public Connection getConnection()
	{
		try
		{
			String connectionURL = "jdbc:mysql://localhost:3306/automatic_system";
			Connection connection = null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(connectionURL,  "root", "");

			return connection;
		}
		catch(Exception ex)
		{
		  ex.printStackTrace();
		  System.out.println("failure here "+ex.getMessage());
		}
		return null;
	}

}

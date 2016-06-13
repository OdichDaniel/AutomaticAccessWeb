package com.automatic.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseUtils
{
	public boolean checkAccessStatus(Connection connection, String studentNumber, String fingerprint)
	{
		String checkStatus = "SELECT * FROM students WHERE studentnumber='"+studentNumber+"' AND fingerprint_id='"+fingerprint+"'";
		try 
		{
			PreparedStatement statement = connection.prepareStatement(checkStatus);
			ResultSet set = statement.executeQuery();
			if(set.next())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (SQLException e) 
		{
			
			e.printStackTrace();
			System.out.println("dbutils========"+e.getMessage());
			return false;
		}

	}

}

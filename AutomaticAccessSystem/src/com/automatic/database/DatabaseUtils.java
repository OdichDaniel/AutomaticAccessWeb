package com.automatic.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseUtils
{
	public boolean checkAccessStatus(Connection connection, String studentNumber, String accessCode)
	{
		String checkStatus = "SELECT * FROM Access WHERE student_number='"+studentNumber+"' AND access_code='"+accessCode+"' AND has_checked_out=0";
		try 
		{
			PreparedStatement statement = connection.prepareStatement(checkStatus);
			ResultSet set = statement.executeQuery();
			if(!set.next())
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
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
			return false;
		}

	}

}

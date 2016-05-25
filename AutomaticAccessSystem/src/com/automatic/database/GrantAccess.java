package com.automatic.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GrantAccess
{
	private String studentNumber;
	private String accessCode;
	
	public GrantAccess(String studentNumber, String accessCode)
	{
		this.studentNumber = studentNumber;
		this.accessCode = accessCode;
	}
	
	public boolean isGranted()
	{
		DatabaseConnector connector = new DatabaseConnector();
		DatabaseUtils dbUtils = new DatabaseUtils();
		
		if(dbUtils.checkAccessStatus(connector.getConnection(), studentNumber, accessCode))
		{
			String accessString = "INSERT INTO Access(student_number, access_code, has_checked_out) VALUES('"+studentNumber+"', '"+accessCode+"', 0)";
			PreparedStatement stat;
			try {
				stat = connector.getConnection().prepareStatement(accessString);
				stat.execute();
				return true;
			} catch (SQLException e) 
			{
				e.printStackTrace();
				System.out.println(e.getMessage());
				return false;
			}
			
		}
		else
		{
			return false;
		}
		
	}

}

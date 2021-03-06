package com.automatic.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GrantAccess
{
	private String studentNumber;
	private String floor;
	private String fingerId;
	
	public GrantAccess(String studentNumber, String floor, String fingerId)
	{
		this.studentNumber = studentNumber;
		this.floor = floor;
		this.fingerId = fingerId;
	}
	
	public boolean isGranted()
	{
		DatabaseConnector connector = new DatabaseConnector();
		DatabaseUtils dbUtils = new DatabaseUtils();
		
		if(dbUtils.checkAccessStatus(connector.getConnection(), studentNumber, fingerId))
		{
			String accessString = "INSERT INTO access(studentnumber, floor) VALUES('"+studentNumber+"', '"+floor+"')";
			PreparedStatement stat;
			try {
				stat = connector.getConnection().prepareStatement(accessString);
				stat.execute();
				return true;
			} catch (SQLException e) 
			{
				e.printStackTrace();
				System.out.println("fuck here =="+e.getMessage());
				return false;
			}
			
		}
		else
		{
			return false;
		}
		
	}

}

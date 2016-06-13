package com.automatic.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.automatic.models.StudentDetail;

public class StudentDetails
{
	public StudentDetail getStudentDetails(Connection connection, String studentnumber)
	{
		String query = "SELECT studentnumber, course, duration FROM students WHERE studentnumber='"+studentnumber+"'";
		try
		{
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet set = statement.executeQuery();
			StudentDetail details = new StudentDetail();
			if(set.next())
			{
				details.setStudentNumber(set.getString("studentnumber"));
				details.setCourse(set.getString("course"));
				details.setCourseDuration(set.getString("duration"));
			}
			return details;
			
		}
		catch (SQLException e)
		{
		
			e.printStackTrace();
			return null;
		}
	}

}

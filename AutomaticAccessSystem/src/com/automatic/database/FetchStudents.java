package com.automatic.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.automatic.models.StudentModel;

public class FetchStudents
{
	public static List<StudentModel> getStudentList()
	{
		DatabaseConnector connector = new DatabaseConnector();
		String queryString = "SELECT * FROM students";
		
		
		try {
			Statement statement = connector.getConnection().createStatement();
			ResultSet set = statement.executeQuery(queryString);
		
			List<StudentModel> list = new ArrayList<StudentModel>();
			while(set.next())
			{
				StudentModel model = new StudentModel();

				model.setFirstName(set.getString("firstname"));
				model.setSecondName(set.getString("secondname"));
				model.setStudentNumber(set.getString("studentnumber"));
				model.setCourse(set.getString("course"));
				model.setCourseDuration(set.getString("duration"));
				
				list.add(model);
			}
									
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return null;
	}

}

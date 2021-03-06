package com.automatic.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class CreateStudentHelper 
{
	private Connection connection;
	private String studentNumber;
	private String firstName;
	private String secondName;
	private String course;
	private String courseDuration;
	private String semester;
	private String tuition;
	
	public CreateStudentHelper(Connection connection, String firstName, String secondName, String studentnumber,
			String course, String courseDuration, String tuition)
	{
		this.connection = connection;
		this.firstName = firstName;
		this.secondName = secondName;
		this.studentNumber = studentnumber;
		this.course = course;
		this.courseDuration = courseDuration;
		this.tuition = tuition;
		
	}
	
	public CreateStudentHelper(Connection connection)
	{
		this.connection = connection;
		
	}
	public boolean checkStudent(String StudentNumber)
	{
		String checkStudentExists = "SELECT * FROM students WHERE studentnumber='"+studentNumber+"'";
		
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(checkStudentExists);
			ResultSet set = statement.executeQuery();
			
			if(!set.next())
			{
				return true;
			}
			else
			{
				return false;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.out.println(e.getMessage());
			return false;
		}
		
	}
	
	public String insertStudent()
	{
		String insertStatement = "INSERT INTO students(firstname, secondname, studentnumber, course, duration, tuition) VALUES('"+firstName+"','"
		+secondName+"', '"+studentNumber+"', '"+course+"', '"+courseDuration+"', '"+tuition+"')";
		
		try {
			PreparedStatement statement = connection.prepareStatement(insertStatement);
			statement.execute();
			
			return "created";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static int updateStudent(Connection connection, String studentNumber, String fingerId)
	{
		String update = "UPDATE students SET fingerprint_id='"+fingerId+"' WHERE studentnumber='"+studentNumber+"'";
		try {
			PreparedStatement statement = connection.prepareStatement(update);
			int s = statement.executeUpdate();
			return s;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return 0;
		}
	}

}

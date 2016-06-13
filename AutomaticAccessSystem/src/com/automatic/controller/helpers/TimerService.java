package com.automatic.controller.helpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.automatic.database.DatabaseConnector;


@Component
public class TimerService {

	DatabaseConnector connector;
	public void updateStudentRecord()
	{
		System.out.println("scheduler running...");
		
		String queryStatement = "SELECT * FROM finance";
		
		if(getDate().equals(getSetDate()))
		{
			connector = new DatabaseConnector();
			Connection connection = connector.getConnection();
			PreparedStatement statement;
			ResultSet set = null;
			try
			{
				statement = connection.prepareStatement(queryStatement);
				set = statement.executeQuery();
				
				while(set.next())
				{
					String tuition = set.getString("tuition");
					String studentnumber = set.getString("studentnumber");
					System.out.println(studentnumber + "==="+tuition);
					
					int updateSuccess;
					
					do
					{
						updateSuccess = updateTuition(studentnumber, tuition);
					}while(updateSuccess == 0);
					
				}
			} 
			catch (SQLException e)
			{
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			finally
			{
				try {
					set.close();
				} catch (SQLException e) {
					
				}
				finally
				{
					try {
						connection.close();
					} catch (SQLException e) {
						
					}
				}
			}
		}
		
		
	}
	
	private int updateTuition(String studentnumber, String amount)
	{
		connector = new DatabaseConnector();
		Connection connection = connector.getConnection();
		PreparedStatement statement = null;
		String chopChopMoneey = String.valueOf((Integer.valueOf(amount) - 10483));
		
		String updateTuition = "UPDATE finance SET tuition='"+chopChopMoneey+"' WHERE studentnumber='"+studentnumber+"'";
		
		try
		{
			statement = connection.prepareStatement(updateTuition);
			return statement.executeUpdate();
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
			return 0;
		}
		finally
		{
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	private String getDate()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		return formatter.format(new Date());
	}
	
	public String getSetDate()
	{
		String getDate = "SELECT * from date";
		DatabaseConnector connector = new DatabaseConnector();
		try {
			PreparedStatement statement = connector.getConnection().prepareStatement(getDate);
			ResultSet set = statement.executeQuery();
			String date = null;
			if(set.next())
			{
				date = set.getString("date");
				return date;
			}
			else
			{
				return " ";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return " ";
		}
	}
}

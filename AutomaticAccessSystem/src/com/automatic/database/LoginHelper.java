package com.automatic.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.automatic.models.LoginQueryModel;

public class LoginHelper
{
	public static List<LoginQueryModel> getCredentials(Connection connection, String username, String password)
	{
		String queryStatement = "SELECT * FROM users WHERE username='"+username+"' AND password='"+password+"'";
		try {
			PreparedStatement statement = connection.prepareStatement(queryStatement);
			ResultSet resultSet = statement.executeQuery();
			
			List<LoginQueryModel> credentials = new ArrayList<LoginQueryModel>();
			
			while(resultSet.next())
			{
				LoginQueryModel queryModel = new LoginQueryModel();
				queryModel.setUsername(resultSet.getString("username"));
				queryModel.setPassword(resultSet.getString("password"));
				queryModel.setRole(resultSet.getString("role"));
				credentials.add(queryModel);
			}
		
			return credentials;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("failure here "+e.getMessage());
			return null;
		}
	}

}

package com.automatic.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class CommonDBUtils
{

	public int updatePassword(String oldPassword, String newPassword, Connection connection)
	{
	    System.out.println(oldPassword);
	    System.out.println(newPassword);
		String updateQuery = "UPDATE users SET password='"+newPassword+"' WHERE password='"+oldPassword+"'";
		try {
			PreparedStatement statement = connection.prepareStatement(updateQuery);
			int updated =statement.executeUpdate();
			return updated;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}

}

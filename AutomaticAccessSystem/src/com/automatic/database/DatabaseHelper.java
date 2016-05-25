package com.automatic.database;

import java.sql.Connection;

public class DatabaseHelper extends CommonDBUtils
{
	DatabaseConnector connector;
	public DatabaseHelper()
	{
		this.connector = new DatabaseConnector();
	}
	
	@Override
	public int updatePassword(String oldPassword, String newPassword, Connection connection)
	{
		return super.updatePassword(oldPassword, newPassword, connector.getConnection());
	}

}

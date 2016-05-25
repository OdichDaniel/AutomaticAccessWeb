package com.automatic.models;

public class AccessModel
{
	private int statusCode;
	private String message;
	
	public void setStatusCode(int statusCode)
	{
		this.statusCode = statusCode;
	}
	public int getStatusCode()
	{
		return this.statusCode;
	}
	
	public void setMessage(String message)
	{
		this.message = message;
	}
	
	public String getMessage()
	{
		return this.message;
	}

}

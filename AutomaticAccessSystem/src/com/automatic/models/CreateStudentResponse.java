package com.automatic.models;

public class CreateStudentResponse
{
	private int statusCode;
	private String accessCode;
	private String message;
	
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getAccessCode() {
		return accessCode;
	}
	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}

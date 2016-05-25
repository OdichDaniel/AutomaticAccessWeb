package com.automatic.models;

public class LoginModel
{
	private String username;
	private String password;
	private String loginCredentialError;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setLoginCredentialError(String loginCredentialError)
	{
		this.loginCredentialError = loginCredentialError;
	}
	
	public String getLoginCredentialError()
	{
		return this.loginCredentialError;
	}
	
	

}

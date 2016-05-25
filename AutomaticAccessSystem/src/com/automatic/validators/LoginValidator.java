package com.automatic.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.automatic.database.DatabaseConnector;
import com.automatic.database.LoginHelper;
import com.automatic.models.LoginModel;

public class LoginValidator implements Validator
{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return LoginModel.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
		LoginModel form = (LoginModel) target;
		    
	        if(form.getUsername().length()<1)
	        {
	        	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "valid.username");
	        }
	        
	        if(form.getPassword().length()<1)
	        {
	        	  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "valid.password");
	        }

	      
	       
	        else if(form.getUsername().length()>1 && form.getPassword().length()>1)
	        {
	        	 DatabaseConnector connector = new DatabaseConnector();
	 	        //System.out.println("the password is "+DatabaseUtil.getCredentials(connector.getConnection(), form.getUsername(), form.getPassword()).get(0).getPassword());
	 	        if(LoginHelper.getCredentials(connector.getConnection(), form.getUsername(), form.getPassword()).isEmpty())
	 	        {
	 	        	ValidationUtils.rejectIfEmpty(errors, "loginCredentialError", "valid.loginCredential");
	 	        }
	        }
		
	}

}

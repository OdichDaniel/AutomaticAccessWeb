package com.automatic.controller.helpers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.automatic.database.DatabaseConnector;
import com.automatic.database.DatabaseUtils;
import com.automatic.database.LoginHelper;
import com.automatic.models.LoginQueryModel;

@Component
public class CustomLoginAuthenticator implements AuthenticationProvider
{
	private String username;
	private String password;

	@Override
	public Authentication authenticate(Authentication authentication)throws AuthenticationException {
		
		this.username = authentication.getName();
	    this.password = authentication.getCredentials().toString();
		DatabaseConnector connector = new DatabaseConnector();
		List<LoginQueryModel> list = LoginHelper.getCredentials(connector.getConnection(), username, password);
	    if(!list.isEmpty())
	    {
	    	
	    	List<GrantedAuthority> ga = new ArrayList<GrantedAuthority>();
	    	ga.add(new SimpleGrantedAuthority(list.get(0).getRole()));
	    	return new UsernamePasswordAuthenticationToken(username, password, ga);
	    }
	    else
	    {
	    	return null;
	    }
		
		
	}

	@Override
	public boolean supports(Class<?> auth) {
		// TODO Auto-generated method stub
        return auth.equals(UsernamePasswordAuthenticationToken.class);
	}

}

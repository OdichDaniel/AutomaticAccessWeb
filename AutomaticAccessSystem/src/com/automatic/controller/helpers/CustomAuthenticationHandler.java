package com.automatic.controller.helpers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

public class CustomAuthenticationHandler extends SimpleUrlAuthenticationSuccessHandler
{
	  private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	  private String role;
	  
	    @Override
	    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
	            throws IOException {
	    	
	        String targetUrl = determineTargetUrl(authentication);
	 
	        if (response.isCommitted()) {
	            System.out.println("Can't redirect");
	            return;
	        }
	        
	        response.setHeader("ROLE", role);
	        request.setAttribute("ROLE", role);
	 
	        redirectStrategy.sendRedirect(request, response, targetUrl);
	    }
	 
	    protected String determineTargetUrl(Authentication authentication) {
	        String url = "";
	 
	        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
	 
	        List<String> roles = new ArrayList<String>();
	 
	        for (GrantedAuthority a : authorities) {
	            roles.add(a.getAuthority());
	        }
	 
	        if (isAuthenticated(roles)) {
	            url = "/allStudents";
	           
	            
	        } else {
	            url = "/accessDenied";
	        }
	 
	        return url;
	    }
	    
	   
	 
	    private boolean isAuthenticated(List<String> roles) {
	        if (roles.contains("ROLE_ADMIN") || roles.contains("ROLE_USER")) {
	            return true;
	        }
	        return false;
	    }

}

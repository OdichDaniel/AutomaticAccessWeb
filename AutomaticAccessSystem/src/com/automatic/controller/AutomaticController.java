package com.automatic.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.automatic.database.CreateStudentHelper;
import com.automatic.database.DatabaseConnector;
import com.automatic.database.FetchStudents;
import com.automatic.database.GrantAccess;
import com.automatic.models.AccessModel;
import com.automatic.models.CreateStudentResponse;
import com.automatic.models.LoginModel;
import com.automatic.models.StudentModel;

@Controller
public class AutomaticController
{
	
	@RequestMapping(value = "/loginpage", method = RequestMethod.GET)
	public ModelAndView getLogin(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) 
	{
		  ModelAndView model = new ModelAndView();
		  if (error != null) {
				model.addObject("error", "Invalid username and password!");
			  }

			  if (logout != null) {
				model.addObject("msg", "You've been logged out successfully.");
			  }
		  model.setViewName("loginpage");
	      return model;
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/home")
	public String submitLogin(Model model, @Validated LoginModel loginModel, BindingResult result)
	{
		String returnVal = "register";
		
	        if(result.hasErrors())
            {
	        	loginModel.setLoginCredentialError(null);
	        	model.addAttribute("form", loginModel);
	            returnVal = "loginpage";
	        }
	        else 
	        {
	        	model.addAttribute("form", loginModel);
	        }      
	        return returnVal;	
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value="/createStudent", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CreateStudentResponse> createStudent(@RequestParam("firstname") String firstname, @RequestParam("secondname") String secondname,
			@RequestParam("studentnumber") String studentnumber, @RequestParam("course") String course, @RequestParam("duration") String courseDuration,
			@RequestParam("tuition") String tuition)
	{
		DatabaseConnector connector = new DatabaseConnector();
		CreateStudentResponse response = new CreateStudentResponse();
		System.out.println("called");
		CreateStudentHelper helper = new CreateStudentHelper(connector.getConnection(), firstname, secondname, studentnumber, course, courseDuration, tuition);
		
		if(helper.checkStudent(studentnumber))
		{
			String accessCode = helper.insertStudent();
			response.setStatusCode(201);
			response.setAccessCode(accessCode);
			response.setMessage("Student successfully created");
			return new ResponseEntity<CreateStudentResponse>(response, HttpStatus.CREATED);
		}
		else
		{
			response.setStatusCode(409);
			response.setAccessCode(null);
			response.setMessage("Student wasn't created");
			return new ResponseEntity<CreateStudentResponse>(response, HttpStatus.CONFLICT);
		}
		
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/access", produces = MediaType.ALL_VALUE)
	public ResponseEntity<String> accessHandler(@RequestParam("studentNumber") String studentNumber, @RequestParam("accessCode") String accessCode)
	{
		GrantAccess grantAccess = new GrantAccess(studentNumber, accessCode, null);
		
		return new ResponseEntity<String>(String.valueOf(grantAccess.isGranted()), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="checkout", produces = MediaType.ALL_VALUE)
	public ResponseEntity<String> checkOut(@RequestParam("accessCode") String accessCode)
	{
		return new ResponseEntity<String>(null);
	}

}

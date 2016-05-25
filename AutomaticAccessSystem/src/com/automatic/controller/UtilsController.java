package com.automatic.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.automatic.database.DatabaseHelper;
import com.automatic.database.FetchStudents;
import com.automatic.models.CreateStudentResponse;
import com.automatic.models.StudentDetail;
import com.automatic.models.StudentModel;

@Controller
public class UtilsController
{
	@RequestMapping(method = RequestMethod.GET, value = "allStudents")
	public ModelAndView getAllStudents()
	{
		//HashMap<String, Object> model = new HashMap<String, Object>();
		//model.put("students", FetchStudents.getStudentList());
		
		ModelAndView modelAndView = new ModelAndView("allStudents");
		modelAndView.addObject("students", FetchStudents.getStudentList());

		return modelAndView;
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value="returnHome")
	public ModelAndView returnHome()
	{
		return new ModelAndView("register");
	}
	
	@RequestMapping(method = RequestMethod.GET, value="rights")
	public ModelAndView noRights()
	{
		return new ModelAndView("rights");
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "profile")
	public ModelAndView studentProfile(@RequestParam("studentNumber") String studentNumber, @RequestParam("firstName") String firstName,
			@RequestParam("secondName") String secondName)
	{
		
		ModelAndView mv = new ModelAndView("profilepage");
		mv.addObject("studentNumber", studentNumber);
		mv.addObject("firstName", firstName);
		mv.addObject("secondName", secondName);
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "changepassword")
	public ModelAndView changePassword()
	{
		
		ModelAndView mv = new ModelAndView("changepasswordPage");
		
		return mv;
	}
	

	@RequestMapping(method = RequestMethod.GET, value = "details", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentDetail> getNumber(@RequestParam("studentNumber") String studentNumber)
	{
		
		StudentDetail detail = new StudentDetail();
		detail.setStudentNumber(studentNumber);
		detail.setCourse("Forestry");
		detail.setCourseDuration("3");
		detail.setTution("1,000,000");
		
		return new ResponseEntity<StudentDetail>(detail, HttpStatus.OK);
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/loginpage?logout";
	}
	@RequestMapping(value="submitpassword", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UpdateResponse> changeUserpassword(@RequestParam("oldpass") String oldPassword, @RequestParam("newpass") String newPassword)
	{
		DatabaseHelper helper = new DatabaseHelper();
		int result = helper.updatePassword(oldPassword, newPassword, null);
		
		UpdateResponse response = new UpdateResponse();
		response.setMessage("Update");
		response.setCode(String.valueOf(result));
		
		return new ResponseEntity<UpdateResponse>(response, HttpStatus.OK);
	}
	
	private class UpdateResponse
	{
		public String message;
		public String code;
		
		public void setMessage(String message)
		{
			this.message = message;
		}
		public String getMessage()
		{
			return this.message;
		}
		
		public void setCode(String code)
		{
			this.code = code;
		}
		public String getCode()
		{
			return this.code;
		}
	}
}

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<html>
	<head>
	<title>Home</title>
	<link rel='stylesheet' href='webjars/bootstrap/3.0.0/css/bootstrap.css'>
	<link rel='stylesheet' href='resources/css/automatic_style.css'>
	<link rel='stylesheet' href='resources/sweetalert-master/dist/sweetalert.css'>
	<script src="resources/angular-1.4.9/angular.js"></script> 
	<script src="resources/js/app.js"></script>
	<script src="resources/sweetalert-master/dist/sweetalert.min.js"></script>
	</head>
	<body ng-app="validateStudentData" ng-controller="mainController">
	 
	 <div id="admin_top_banner">
	 <div id="welcome_tag"><font id="welcome_text" color="#ffffff">Welcome ${form.username}</font><a href="" id="sign_out_text" class="pull-right">Sign out</a></div>
	  
	 
	 </div>
	 
	  <div id='sidemenu'>
       <ul>
         <li><a href='#'><span>All students</span></a></li>
         <li><a href='#'><span>Change password</span></a></li>
         <li><a href='#'><span>Sign out</span></a></li>
    </ul>
   </div>
	 
	 <div id="form-div">
	 
	 <form id="submit_student_form" name="studentData" ng-submit="studentData.$valid && submitForm(studentData.$valid)" novalidate>
	 <div class="form-group">
	 <input type="text" name="firstName" ng-class="{'has-error': studentData.firstName.$invalid && !studentData.firstName.$pristine}" ng-model="firstName" placeholder="First name" class="form-control" required="required"/>
	 <p ng-class="{'firstname-error-text': studentData.firstName.$invalid && !studentData.firstName.$pristine}" ng-show="studentData.firstName.$invalid && !studentData.firstName.$pristine" class="help-block">First name is required.</p>
	 </div>
	 
	 <div class="form-group">
	 <input type="text" name="secondName" ng-class="{'has-error': studentData.secondName.$invalid && !studentData.secondName.$pristine}" ng-model="secondName" placeholder="Second name" class="form-control" required="required"/>
	 <p ng-class="{'secondname-error-text': studentData.secondName.$invalid && !studentData.secondName.$pristine}" ng-show="studentData.secondName.$invalid && !studentData.secondName.$pristine" class="help-block">Second name is required.</p>
	 </div>
	 
	  <div class="form-group">
	 <input type="text" name="studentNumber" ng-class="{'has-error': studentData.studentNumber.$invalid && !studentData.studentNumber.$pristine}" ng-model="studentNumber" placeholder="Student number" class="form-control" required="required"/>
	 <p ng-class="{'studentnumber-error-text': studentData.studentNumber.$invalid && !studentData.studentNumber.$pristine}" ng-show="studentData.studentNumber.$invalid && !studentData.studentNumber.$pristine" class="help-block">Student number is required.</p>
	 </div>
	 
	 
	 <div class="form-group">
	 <input type="text" ng-class="{'has-error': studentData.course.$invalid && !studentData.course.$pristine}" name="course" ng-model="course" placeholder="Course" class="form-control" required="required"/>
	 <p ng-class="{'course-error-text': studentData.course.$invalid && !studentData.course.$pristine}" ng-show="studentData.course.$invalid && !studentData.course.$pristine" class="help-block">Course is required.</p>
	 </div>
	 
	 <div class="form-group">
	 <input type="text" name="courseDuration" ng-class="{'has-error': studentData.courseDuration.$invalid && !studentData.courseDuration.$pristine}" ng-model="courseDuration" placeholder="Course duration" class="form-control" required="required"/>
	 <p ng-class="{'courseduration-error-text': studentData.courseDuration.$invalid && !studentData.courseDuration.$pristine}" ng-show="studentData.courseDuration.$invalid && !studentData.courseDuration.$pristine" class="help-block">Course duration is required.</p>
	 </div>
	
	 <button type="submit" class="btn btn-primary" ng-disabled="studentData.$invalid">Submit</button>
	 
	 </form>
	 </div>
	 

	</body>
	</html>
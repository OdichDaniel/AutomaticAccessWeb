<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<link rel='stylesheet' href='webjars/bootstrap/3.0.0/css/bootstrap.css'>
<script src='resources/jquery/dist/jquery.min.js'></script>

	<link rel='stylesheet' href='resources/css/turn_around.css'>
	<link rel='stylesheet' href='resources/sweetalert-master/dist/sweetalert.css'>
	<script src="resources/angular-1.4.9/angular.js"></script> 
	<script src="resources/js/app.js"></script>
	<script src="resources/js/assassin.js"></script>
	<script src="resources/sweetalert-master/dist/sweetalert.min.js"></script>
	<script>
  
   
</script>


</head>
<body class="body-container" ng-app="validateStudentData" ng-controller="mainController">

<%            
  response.setHeader("pragma", "no-cache");            
  response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");           
  response.setHeader("Expires", "0");
%>

 <div class="banner"><tiles:insertAttribute name="header"/></div>
<div  class='sidemenu'><tiles:insertAttribute name="menu"/></div>
<div  class="button"><tiles:insertAttribute name="menuButtons"/></div>
      
   
<div class='content-body'>
   
   <div class="register-container"><tiles:insertAttribute name="body"/></div>
    <div class="student-container"><tiles:insertAttribute name="table"/></div>
     <div class="profile-container"><tiles:insertAttribute name="profile"/></div>
     <div class="changepassword-container"><tiles:insertAttribute name="changepassword"></tiles:insertAttribute></div>
</div>
 
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<link rel='stylesheet' href='webjars/bootstrap/3.0.0/css/bootstrap.css'>
	<link rel='stylesheet' href='resources/css/automatic_style.css'>
	<link rel='stylesheet' href='resources/sweetalert-master/dist/sweetalert.css'>
	<script src="resources/angular-1.4.9/angular.js"></script> 
	<script src="resources/js/app.js"></script>
	<script src="resources/sweetalert-master/dist/sweetalert.min.js"></script>
</head>
<body id="outer_container" ng-app="validateStudentData" ng-controller="mainController">

<div id="admin_top_banner"><tiles:insertAttribute name="header"/></div>
<div  id='sidemenu'><tiles:insertAttribute name="menu"/></div>
<div class='content_body'>
   
   <div class="body_container"><tiles:insertAttribute name="body"/></div>
    <div class="student_table"><tiles:insertAttribute name="table"/></div>
     <div class="content"><tiles:insertAttribute name="profile"/></div>
</div>

</body>
</html>
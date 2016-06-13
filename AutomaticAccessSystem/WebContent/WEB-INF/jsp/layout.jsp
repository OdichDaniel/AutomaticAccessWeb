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
	<link rel="stylesheet" href="resources/css/datepicker.css">
	<link rel='stylesheet' href='resources/sweetalert-master/dist/sweetalert.css'>
	<script src="resources/angular-1.4.9/angular.js"></script> 
	<script src="resources/js/app.js"></script>
	<script src="resources/js/assassin.js"></script>
	<script src="resources/sweetalert-master/dist/sweetalert.min.js"></script>
    <script src="resources/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.min.js"></script>
    
    
    
</head>
<body class="body-container" ng-app="validateStudentData" ng-controller="mainController">
<% String role = (String)request.getAttribute("ROLE"); %>

<%            
  response.setHeader("pragma", "no-cache");            
  response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");           
  response.setHeader("Expires", "0");
%>



<div>
<c:set var="role" value="<%= role %>"/>
<c:set var="role_admin" value="ROLE_ADMIN"/>
<c:set var="role_user" value="ROLE_USER"/>
<c:if test="${role ==role_admin}">

 <div class="banner"><tiles:insertAttribute name="header"/></div>
<div  class='sidemenu'><tiles:insertAttribute name="menu"/></div>
<div  class="button"><tiles:insertAttribute name="menuButtons"/></div>


</c:if>

<c:if test="${role ==role_user}">

 <div class="banner"><tiles:insertAttribute name="header"/></div>
<div  class='sidemenu'><tiles:insertAttribute name="menu"/></div>
<div  class="button"><tiles:insertAttribute name="staffMenu"/></div>

</c:if>

</div>  
   
   <div class='content-body'>
   
   <div class="register-container"><tiles:insertAttribute name="register"/></div>
    <div class="student-container"><tiles:insertAttribute name="table"/></div>
     <div class="profile-container"><tiles:insertAttribute name="profile"/></div>
     <div class="adduser-container"><tiles:insertAttribute name="adduser"/></div>
     <div class="changepassword-container"><tiles:insertAttribute name="changepassword"></tiles:insertAttribute></div>
</div>

<div class="modal fade" id="grace" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Modal Header</h4>
        </div>
        <div class="modal-body">
          <p>Some text in the modal.</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  
</div>
 
</html>
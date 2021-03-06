<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
<title>Login</title>
<link rel='stylesheet' href='webjars/bootstrap/3.0.0/css/bootstrap.css'>
<style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}

#login-box {
	width: 30%;
	padding: 20px;
	margin: 100px auto;
	background: #fff;
	border-radius: 8px;
	-moz-border-radius: 8px;
	border: 2px solid #d3dbde;
}
#message-holder
{
   padding:10px;
   background:#d3dbde;
   border-radius:3px;
}
</style>
<SCRIPT type="text/javascript">
    window.history.forward();
    function noBack() { window.history.forward(); }
</SCRIPT>
</head>
<body  onload="noBack();" onpageshow="if (event.persisted) noBack();" onunload="">
	
	<div id="login-box">

     <div id="message-holder"><h2>Login with Username and Password</h2></div>
		

		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
		<c:if test="${not empty logout_message}">
		<div class="msg">${logout_message}</div>
		</c:if>

		<form name='loginForm'
		  action="<c:url value='/j_spring_security_check' />" method='POST'>

		<table cellpadding="5" style="width:100%;">
		     
		    <tr ><td>Username</td></tr>
			<tr id="spacer">
				
				<td><input class="form-control" type='text' name='username'></td>
			</tr>
			 <tr><td>Password</td></tr>
			<tr id="spacer">
			
				<td><input class="form-control" type='password' name='password' /></td>
			</tr>
			<tr>
				<td><input class="btn btn-primary btn-block" name="submit" type="submit" value="Login" /></td>
			</tr>
		  </table>

		  <input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />

		</form>
	</div>

</body>
</html>
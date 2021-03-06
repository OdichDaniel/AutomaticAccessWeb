<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel='stylesheet' href='webjars/bootstrap/3.0.0/css/bootstrap.css'>
<script src="resources/js/validator.js"></script>
<link rel='stylesheet' href='resources/sweetalert-master/dist/sweetalert.css'>
<script>
$(window).load(function()
{
  
   $('.hold-widgets').validator().on('submit', function (e) {
  if (e.isDefaultPrevented()) {
    // handle the invalid form...
     changePassword();
  } else {
    // everything looks good!
    alert("look good");
  }
}) 
});


//call to change password
var changePassword = function()
{
  var http = new XMLHttpRequest();
  var newPassword = document.getElementById("inputPassword").value;
  var oldPassword = document.getElementById("oldpassword").value;
	var url = "http://localhost:8080/AutomaticAccessSystem/submitpassword?oldpass="+oldPassword+"&newpass="+newPassword;
	http.open("GET", url, true);
	
	http.onreadystatechange = function() {
	    var status = http.status;
	    if(http.readyState == 4 && http.status == 200) {
	       
	        var obj = JSON.parse(http.responseText);
	        var failedState = 0;  
	        if(obj.code == 0)
	        {
	           swal("Oopps"," The password does not exist", "error");   
	        }
	        else
	        {
	          swal("Success"," You have successfully changed your password", "success");   
	        }
	        
	    }
	    else
	    {
	    	response = "";
	    }
   }
   http.send(null);
}
</script>



</head>
<body>

<div class="change-password-container">
<form autocomplete="off" class="hold-widgets" role="form" data-toggle="validator">

<div class="form-widgets">
<div class="form-group">
<input type="password" placeholder="Old password" id="oldpassword" class="form-control" required="required"/>
</div>

<div class="form-group">
<input type="password" data-minlength="6" placeholder="New password" class="form-control" id="inputPassword"/>
 <div class="help-block">Minimum of 6 characters</div>
</div>

<div class="form-group">
<input type="password" placeholder="Confirm password" class="form-control"  id="inputPasswordConfirm" data-match="#inputPassword" data-match-error="Whoops, these don't match" placeholder="Confirm" required>
<div class="help-block with-errors"></div>
</div>
<div> <button type="submit" class="btn btn-primary">Submit</button></div>
</div>
</form>>



</body>
</html>
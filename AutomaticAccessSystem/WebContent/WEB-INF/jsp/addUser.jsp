<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="resources/js/validator.js"></script>

<script>
$(window).load(function()
{
  
   $('.hold-widgets').validator().on('submit', function (e) {
  if (e.isDefaultPrevented()) {
    // handle the invalid form...
     addUser();
  } else {
    // everything looks good!
    alert("look good");
  }
}) 
});


//call to change password
var addUser = function()
{
  var http = new XMLHttpRequest();
  var username = document.getElementById("username_new").value;
  var password = document.getElementById("password_new").value;
  var role = document.getElementById("role_new").value;
	var url = "http://localhost:8080/AutomaticAccessSystem/createuser?username="+username+"&password="+password+"&role="+role;
	http.open("GET", url, true);
	
	http.onreadystatechange = function() {
	    var status = http.status;
	    if(http.readyState == 4 && http.status == 200) {
	       
	       
	       swal("Success"," User created", "success");   
	    }
	    else
	    {
	         
	         swal("Failed"," User was not created", "error");   
	    }
   }
   http.send(null);
}
</script>

</head>
<body>

<div class="form-div">

 <div class="change-password-container">
<form autocomplete="off" class="hold-widgets" role="form" data-toggle="validator">

<div class="form-widgets">
<div class="form-group">
<input type="text" placeholder="Username" id="username_new" class="form-control" required="required"/>
</div>

<div class="form-group">
<input type="password" data-minlength="6" placeholder="Password" id="password_new" class="form-control" required="required"/>
 <div class="help-block">Minimum of 6 characters</div>
</div>

<div class="form-group">
<input type="password" placeholder="Confirm password" id="confirm" data-match="#password_new" data-match-error="Whoops, these don't match" class="form-control" required="required"/>
<div class="help-block with-errors"></div>
</div>


<div class="form-group">
<input type="text" placeholder="Role" id="role_new" class="form-control" required="required"/>
</div>


<div class="form-group">
<button type="submit" onclick="addUser();" class="btn btn-primary btn-block">Submit</button></div>
</div>
</form>
</div>

</body>
</html>
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
    
     register();
  } else {
    
  }
}) 
});


//call to change password
var register = function()
{
  var http = new XMLHttpRequest();
  var firstname = document.getElementById("firstname").value;
  var secondname = document.getElementById("secondname").value;
  var studentnumber = document.getElementById("studentnumber").value;
  var course = document.getElementById("course").value;
  var duration = document.getElementById("courseduration").value;
  var tuition = document.getElementById("tuition").value;
	var url = "http://localhost:8080/AutomaticAccessSystem/createStudent?firstname="+firstname+"&secondname="+secondname+"&studentnumber="+studentnumber+"&course="+course+"&duration="+duration+"&tuition="+tuition;
		
	http.open("POST", url, false);
	
	http.onreadystatechange = function() {
	    var status = http.status;
	    if(http.readyState == 4 && http.status == 201) {
	       
	        swal("Success"," Student successfully registered", "success");   
	    }
	    else
	    {
	          swal("Failed", http.status, "error");   
	    }
   }
  http.send(null);
}
</script>



</head>


<body>
<div class="form-div">

     <div>
     <p id="register-message">Fill in the details to register student</p>
     <hr id="horizontal-rule">
     </div>
     
 <div class="change-password-container">
<form autocomplete="off" role="form" data-toggle="validator">

<div class="form-widgets">
<div class="form-group">
<input type="text" placeholder="First name" id="firstname" class="form-control" required="required"/>
</div>

<div class="form-group">
<input type="text" placeholder="Second name" id="secondname" class="form-control" required="required"/>
</div>

<div class="form-group">
<input type="text" placeholder="Student number" id="studentnumber" class="form-control" required="required"/>
</div>

<div class="form-group">
<input type="text" placeholder="Course" id="course" class="form-control" required="required"/>
</div>

<div class="form-group">
<input type="text" placeholder="Course duration" id="courseduration" class="form-control" required="required"/>
</div>

<div class="form-group">
<input type="text" placeholder="Tuition" id="tuition" class="form-control" required="required"/>
</div>
<div class="form-group">
<button type="submit" onclick="register();" class="btn btn-primary btn-block">Submit</button></div>
</div>
</form>
</div>
</body>
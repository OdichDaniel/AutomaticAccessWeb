<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">

window.onload = function ()
{
    
	var runAsync = getDetails();
   
}

var getDetails = function()
{
  var http = new XMLHttpRequest();
	var url = "http://localhost:8080/AutomaticAccessSystem/details?studentNumber=858874";
	http.open("GET", url, true);
	
	http.onreadystatechange = function() {
	    var status = http.status;
	    if(http.readyState == 4 && http.status == 200) {
	       
	        var obj = JSON.parse(http.responseText);
	        document.getElementById("student-number").innerHTML = obj.studentNumber;
	        document.getElementById("course").innerHTML = obj.course;
	        document.getElementById("course-duration").innerHTML = obj.courseDuration;
	        document.getElementById("tuition").innerHTML = obj.tuition;
	        toggle_visibility("preloader6");
	        
	    }
	    else
	    {
	    	response = "";
	    }
	
	
	
   }
   http.send(null);
}

  function toggle_visibility(id) {
       var e = document.getElementById(id);
       if(e.style.display == 'block')
          e.style.display = 'none';
       else
          e.style.display = 'block';
   }
  
</script>
<script>
  
    $(document).ready(function()
    {
 		var str=location.href.toLowerCase();
        $('.navigation li a').each(function()
         {
                if (str.indexOf(this.href.toLowerCase()) > -1) 
                {
						$("li.highlight").removeClass("highlight");
                        $(this).parent().addClass("highlight"); 
                }
         });
          
		$('li.highlight').parents().each(function()
		{
												  
					if ($(this).is('li'))
					{
						$(this).addClass("highlight"); 
						}							  
		});
	   });  

</script>
</head>
<body>
<div id="student-name">${firstName}&nbsp;&nbsp;${secondName}</div>
<div id="image-container">
  <img src="resources/images/profile.png" />
</div>



<div class="student-profile-container">
<div class="student-profile">
<div id="preloader6"></div>
<table>
<tr><td style="padding-right:120px; padding-bottom:20px;">Student number</td><td id="student-number"></td></tr>
<tr><td style="padding-right:120px; padding-bottom:20px;">Course</td><td id="course">Computer engineering</td></tr>
<tr><td style="padding-right:120px; padding-bottom:20px;">Course duration</td><td id="course-duration">4</td></tr>
<tr><td style="padding-right:120px; padding-bottom:20px;">Tuition</td><td id="tuition">858488</td></tr>
</table>
</div>
</div>


</body>
</html>
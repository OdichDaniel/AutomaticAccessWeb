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
  var number = ${studentNumber};
  var http = new XMLHttpRequest();
	var url = "http://localhost:8080/AutomaticAccessSystem/details?studentnumber="+number;
	http.open("GET", url, true);
	
	http.onreadystatechange = function() {
	    var status = http.status;
	    if(http.readyState == 4 && http.status == 200) {
	       
	       
	        var obj = JSON.parse(http.responseText);
	        document.getElementById("student-number").innerHTML = obj.studentNumber;
	        document.getElementById("course").innerHTML = obj.course;
	        document.getElementById("course-duration").innerHTML = obj.courseDuration;
	       
	       
	        
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

</head>
<body>
<div id="student-name">${firstName}&nbsp;&nbsp;${secondName}</div>
<div class="image-container">
  <img id="profile-image" src="resources/images/profile.png"></image>
  
</div>



<div class="student-profile-container">
<div class="student-profile">

<table style="margin:10px;">
<tr><td style="padding-right:120px; padding-bottom:20px;">Student number</td><td style="padding-right:120px; padding-bottom:20px;" id="student-number"><p>${studenNumber}</p></td></tr>
<tr><td style="padding-right:120px; padding-bottom:20px;">Course</td><td style="padding-right:120px; padding-bottom:20px;" id="course"></td></tr>
<tr><td style="padding-right:120px; padding-bottom:20px;">Course duration</td><td style="padding-right:120px; padding-bottom:20px;" id="course-duration"></td></tr>

</table>
</div>
</div>

 <table class = "table">
      <thead>
         <tr>
            <th>Time</th>
            <th>Floor</th>
            
         </tr>
      </thead>
      <tbody>
         <c:forEach var="access" items="${accesses}" >
            <tr style="font-size: 10">
               <td>
                 
                     <c:out value="${access.time}"></c:out>
                 
               </td>
               <td>
                  <c:out value="${access.floor}"></c:out>
               </td>
               
            </tr>
         </c:forEach>
      </tbody>
   </table>


</body>
</html>
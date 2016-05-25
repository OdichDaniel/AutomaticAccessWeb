<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">

$(function(){
    // this will get the full URL at the address bar
    var url = window.location.href; 

    // passes on every "a" tag 
    $("#sub-header a").each(function() {
            // checks if its the same on the address bar
        if(url == (this.href)) { 
            $(this).closest("li").addClass("active");
        }
    });
});
  
</script>
</head>
<body>

<table class = "table">
   
   <thead>
      <tr>
         <th>First name</th>
         <th>Second name</th>
         <th>Student number</th>
         <th>Course</th>
         <th>Course duration</th>
      </tr>
   </thead>
   
   <tbody>
     <c:forEach var="student" items="${students}" >
            <tr style="font-size: 10">
                <td><a id="name_link" href="/AutomaticAccessSystem/profile?studentNumber=${student.studentNumber}&firstName=${student.firstName}&secondName=${student.secondName}"><c:out value="${student.firstName}"></c:out></a></td>
                <td><c:out value="${student.secondName}"></c:out></td>
                <td><c:out value="${student.studentNumber}"></c:out></td>
                <td><c:out value="${student.course}"></c:out></td>
                <td><c:out value="${student.courseDuration}"></c:out></td>
            </tr>
            </c:forEach>
   </tbody>
	
</table>


</body>
</html>
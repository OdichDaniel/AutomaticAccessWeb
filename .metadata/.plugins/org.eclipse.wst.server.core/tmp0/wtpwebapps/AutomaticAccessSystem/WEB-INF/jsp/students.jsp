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
   <div class="control-button-holder"><button id="edit-button" class="btn btn-default btn-sm">Edit</button>
      <button id="delete-button" class="btn btn-default btn-sm">Delete</button>
   </div>
   <div id="myModal" class="modal">
      <!-- Modal content -->
      <div class="modal-content">
         <span class="close">x</span>
         <form autocomplete="off" class="hold-widget-edit" role="form" data-toggle="validator">
            <div class="form-widget-edit">
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
               <div class="form-group"> <button type="submit" class="btn btn-primary btn-block">Submit</button></div>
            </div>
            
      </div>
      </form>>
   </div>
   </div>
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
               <td>
                  <a id="name_link" href="/AutomaticAccessSystem/profile?studentNumber=${student.studentNumber}&firstName=${student.firstName}&secondName=${student.secondName}">
                     <c:out value="${student.firstName}"></c:out>
                  </a>
               </td>
               <td>
                  <c:out value="${student.secondName}"></c:out>
               </td>
               <td>
                  <c:out value="${student.studentNumber}"></c:out>
               </td>
               <td>
                  <c:out value="${student.course}"></c:out>
               </td>
               <td>
                  <c:out value="${student.courseDuration}"></c:out>
               </td>
            </tr>
         </c:forEach>
      </tbody>
   </table>
   <script type="text/javascript">
      var modal = document.getElementById('myModal');
      
      // Get the button that opens the modal
      var btn = document.getElementById("edit-button");
      
      // Get the <span> element that closes the modal
      var span = document.getElementsByClassName("close")[0];
      
      // When the user clicks on the button, open the modal
      btn.onclick = function() {
          modal.style.display = "block";
      }
      
      // When the user clicks on <span> (x), close the modal
      span.onclick = function() {
          modal.style.display = "none";
      }
      
      // When the user clicks anywhere outside of the modal, close it
      window.onclick = function(event) {
          if (event.target == modal) {
              modal.style.display = "none";
          }
      }
   </script>
</body>


</html>
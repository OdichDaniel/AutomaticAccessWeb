<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel='stylesheet' href='resources/css/turn_around.css'>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.js"></script>
<script type="text/javascript">

window.onload = function ()
{
  $( "#menu" ).menu({
    
    select: function( e, ui ) {
        
        // Remove the highlight class from any existing items.
        $( this ).find( "a.ui-state-highlight" )
                 .removeClass( "ui-state-highlight" );
     
        // Adds the "ui-state-highlight" class to the selected item.
        ui.item.find( "> a")
               .addClass( "ui-state-highlight ui-corner-all" );     
    
    }
    
});
   
}

</script>
</head>
<body>

<body>

     <ul id="menu">
         <li><a href="/AutomaticAccessSystem/registerStudent"><span>Register</span></a>
         <li><a href='/AutomaticAccessSystem/allStudents'><span>All students</span></a></li>
        
         <li><a href='/AutomaticAccessSystem/logout'><span>Logout</span></a></li>
    </ul>

</body>

</body>
</html>

<div id="welcome_tag">
<img id="welcome-avatar" src="resources/images/profile.png" />
<font id="welcome_text" color="#333333">Welcome ${USERNAME}</font>
 <li class="dropdown pull-right">
            <a href="#" data-toggle="dropdown" class="dropdown-toggle">Settings</a>
            <ul class="dropdown-menu">
                <li><a class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal" href="#">Grace period</a></li>
            </ul>
        </li>
        
        
           <div id="myModal"  data-backdrop="false" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Set period</h4>
      </div>
      <div class="modal-body">
        
        
        <form id="main">
            <input id="date" class="form-control datepicker" placeholder="Date" type="text">
          </form>
        
      </div>
      <div class="modal-footer">
        <button type="button" onclick="changeDate();" class="btn btn-default" data-dismiss="modal">Change date</button>
      </div>
    </div>

  </div>
</div>
        
       
</div>


<script>
    $(document).ready(function() {
        $("#main input").datepicker();
    });
</script>

<<script type="text/javascript">

var changeDate = function()
   {
    
       var modal = document.getElementById('myModal');
       var date = document.getElementById("date").value;
       
       
          
	   var url = "http://localhost:8080/AutomaticAccessSystem/date?date="+date;
	   
	   
	   var http = new XMLHttpRequest();
		
	  http.open("POST", url, true);
	 
	
	http.onreadystatechange = function() {
	    var status = http.status;
	    if(http.readyState == 4 && http.status == 200) {
	       
	       modal.style.display = "none";
	       
	        swal("Success"," Date changed", "success");   
	    }
	    else
	    {
	        modal.style.display = "none";
	          swal("Failed", "Couldn't change date", "error");   
	    }
   }
  http.send(null);
}

</script>

 
     

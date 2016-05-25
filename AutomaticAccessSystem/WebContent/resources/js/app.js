var validationStudentData = angular.module('validateStudentData', []);

// create angular controller
validationStudentData.controller('mainController', function($scope, $http) {

	// function to submit the form after all validation has occurred			
	$scope.submitForm = function(isValid) {

		// check to make sure the form is completely valid
		if (isValid) { 
			
			$http.post("http://localhost:8080/AutomaticAccessSystem/createStudent?firstname="+$scope.firstName+"&secondname="
					+$scope.secondName+"&studentnumber="+$scope.studentNumber+"&course="+$scope.course+"&duration="+$scope.courseDuration+"&tuition="+$scope.tuition).
					success(function(data, status)
					{	
					   
					   // alert(mResponse.accessCode)
					    swal("Student created", "", "success")    
					
					}).error(function(error, status)
					{
						//alert("failed");
						$scope.data.error = { message: error, status: status};
				        alert($scope.data.error.status); 
						swal("Student not created", "Student with registration number "+$scope.data.error.status+" already exist", "error");
					});
			
			
			
		}

	};
	


});
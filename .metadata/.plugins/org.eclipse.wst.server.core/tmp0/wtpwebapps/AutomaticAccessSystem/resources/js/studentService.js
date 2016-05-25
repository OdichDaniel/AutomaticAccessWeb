'use strict'

App.factory('studentService', ['$http', '$q', function($http, $q)
{
	return
	{
		createSudent:function($firstname, $secondname, $course, $studentnumber, $courseduration)
		{
			return $http.post("http://localhost:8080/AutomaticAccessSystem/createStudent?firstname="+$firstname+"&secondname="
				+$secondname+"&course="+$course+"&studentnumber="+$studentnumber+"&courseduration="+$courseduration).then
			(
				function(response)
				{
					return response.data;
				},
				function(errResponse)
				{
					return $q.reject(errResponse);
				}
			)
		}
	}

}]);
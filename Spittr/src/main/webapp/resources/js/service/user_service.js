/**
 * 
 */

app.factory('UserService' , [ '$http' , '$q' , function($http, $q)	{
	var REST_SERVICE_API = 'http://localhost:8082/spittr/';

	var factory = {
			fetchSpitters: fetchSpitters,
			createSpitter: createSpitter,
			deleteSpitter: deleteSpitter,
			updateSpitter: updateSpitter,
			createSpittle: createSpittle,
			updateSpittle: updateSpittle,
			fetchSpittles: fetchSpittles
	};

	return factory;
	
	function fetchSpitters()	{
		var deferred = $q.defer();
		$http.get(REST_SERVICE_API + "/spitter/fetchSpitters" ).then( function (response)	{
			deferred.resolve(response.data);
		},
		function(errResponse)	{
			console.error('Error while fetching Users');
			deferred.reject(errResponse);
		}
	);
		return deferred.promise;
	}
	
	function createSpitter(spitter)	{
		var deferred = $q.defer();
		$http.post(REST_SERVICE_API + "spitter/createSpitter" , spitter).then( function (response)	{
			deferred.resolve(response.data);
		},
		function(errResponse)	{
			console.error('Error while creating spitter');
			deferred.reject(errResponse);
		}
	);
		return deferred.promise;
	}
	
	
	function deleteSpitter(spitterID)	{
		var deferred = $q.defer();
		$http.get(REST_SERVICE_API + "spitter/deleteSpitter/" + spitterID).then( function( response)	{
			deferred.resolve(response.data);
		},
		function(errResponse)	{
			console.error('Error while deleting spitter');
			deferred.reject(errResponse);
		});
		
		return deferred.promise;
	}
	
	function updateSpitter(spitter)	{
		var deferred = $q.defer();
		$http.post(REST_SERVICE_API + "spitter/updateSpitter" , spitter).then( function (response)	{
			deferred.resolve(response.data);
		},
		function(errResponse)	{
			console.error('Error while creating spitter');
			deferred.reject(errResponse);
		}
		);
		return deferred.promise;
	}
	
	function createSpittle()	{
		var deferred = $q.defer();
		$http.get(fetchSpitters).then( function (response)	{
			deferred.resolve(response.data);
		},
		function(errResponse)	{
			console.error('Error while fetching Users');
			deferred.reject(errResponse);
		}
	);
		return deferred.promise;
	}
	
	function updateSpittle()	{
		var deferred = $q.defer();
		$http.get(fetchSpitters).then( function (response)	{
			deferred.resolve(response.data);
		},
		function(errResponse)	{
			console.error('Error while fetching Users');
			deferred.reject(errResponse);
		}
	);
		return deferred.promise;
	}
	
	function fetchSpittles()	{
		var deferred = $q.defer();
		$http.get(fetchSpitters).then( function (response)	{
			deferred.resolve(response.data);
		},
		function(errResponse)	{
			console.error('Error while fetching Users');
			deferred.reject(errResponse);
		}
	);
		return deferred.promise;
	}
	
	
}]);
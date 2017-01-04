/**
 * 
 */

app.controller('UserController' , ['$scope', 'UserService', function($scope, UserService)	{
	var self = this;
	self.spitter = {id:null , username: '' , address: '' , email: ''};
	self.spitters = [];
	self.submit = submit;
	self.remove = remove;
	self.reset = reset;
	
	fetchSpitters();
	
	function fetchSpitters()	{
		UserService.fetchSpitters().then(function(d)	{
			self.spitters = d;
		},
		function(errResponse)	{
			console.error('Error while fetching spitters');
		});
	}
	
	function createSpitter(spitter)	{
		UserService.createSpitter(spitter).then(function(d)	{
			fetchSpitters();
		},
		function(errResponse)	{
			console.error('Error while fetching spitters');
		});
	}
	
	function fetchSpitters()	{
		UserService.fetchSpitters().then(function(d)	{
			self.spitters = d;
		},
		function(errResponse)	{
			console.error('Error while fetching spitters');
		});
	}
	
	function fetchSpitters()	{
		UserService.fetchSpitters().then(function(d)	{
			self.spitters = d;
		},
		function(errResponse)	{
			console.error('Error while fetching spitters');
		});
	}
	
	function fetchSpitters()	{
		UserService.fetchSpitters().then(function(d)	{
			self.spitters = d;
		},
		function(errResponse)	{
			console.error('Error while fetching spitters');
		});
	}
	
	function fetchSpitters()	{
		UserService.fetchSpitters().then(function(d)	{
			self.spitters = d;
		},
		function(errResponse)	{
			console.error('Error while fetching spitters');
		});
	}

}])
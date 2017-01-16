/**
 * 
 */

app.controller('UserController' , ['$scope', 'UserService', function($scope, UserService)	{
	var self = this;
	self.spitter = {userID:null , firstName: '' , lastName: '' , email: ''};
	self.spitters = [];
	self.submit = submit;
	self.remove = remove;
	self.reset = reset;
	self.edit = edit;
	
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
			console.error('Error while creating spitter');
		});
	}
	
	function deleteSpitter(spitterID)	{
		UserService.deleteSpitter(spitterID).then( fetchSpitters,
				function(errResponse)	{
			console.error("Error while deleting spitters");
		});
	}
	
	function updateSpitter(spitter)	{
		UserService.updateSpitter(spitter).then ( fetchSpitters,
				function(errResponse)	{
			console.error("Error while updating spitter")
		});
	}
	
	
	/*function fetchSpitters()	{
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
	}*/
	
	function submit() {
        if(self.spitter.userID === null){
            console.log('Saving New User', self.user);
            createSpitter(self.spitter);
        }else{
            updateSpitter(self.spitter);
            console.log('User updated with id ', self.spitter.userID);
        }
        reset();
    }
	
	function edit(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.spitters.length; i++){
            if(self.spitters[i].userID === id) {
                self.spitter = angular.copy(self.spitters[i]);
                break;
            }
        }
    }
 
    function remove(id){
        console.log('id to be deleted', id);
        if(self.spitter.userID === id) {//clean form if the user to be deleted is shown there.
            reset();
        }
        deleteSpitter(id);
    }
    
    function reset(){
        self.spitter={userID:null,username:'',address:'',email:''};
        $scope.myForm.$setPristine(); //reset Form
    }
}])
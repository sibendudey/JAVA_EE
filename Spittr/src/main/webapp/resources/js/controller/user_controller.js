/**
 * 
 */

app.controller('UserController' , ['$scope', 'UserService', function($scope, UserService)	{
	var self = this;
	self.spitter = {id:null , firstName: '' , lastName: '' , email: ''};
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
	
	function submit() {
        if(self.user.id===null){
            console.log('Saving New User', self.user);
            createUser(self.user);
        }else{
            updateUser(self.user, self.user.id);
            console.log('User updated with id ', self.user.id);
        }
        reset();
    }
	
	function edit(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.users.length; i++){
            if(self.users[i].id === id) {
                self.user = angular.copy(self.users[i]);
                break;
            }
        }
    }
 
    function remove(id){
        console.log('id to be deleted', id);
        if(self.user.id === id) {//clean form if the user to be deleted is shown there.
            reset();
        }
        deleteUser(id);
    }
    
    function reset(){
        self.user={id:null,username:'',address:'',email:''};
        $scope.myForm.$setPristine(); //reset Form
    }
}])
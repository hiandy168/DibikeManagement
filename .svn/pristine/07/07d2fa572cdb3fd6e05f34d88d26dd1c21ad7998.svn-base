vm.controller('logList',['$scope','$http',function($scope,$http){
	
	var username=window.localStorage.getItem("username");
	var password=window.localStorage.getItem("password");
	
	if(username==null || password==null){
		window.location.href="./login.html";
	}else{
		$scope.username=username;
	}
	
	var date=new Date();
	var hour=date.getHours();
	
	if(hour>12){
		$scope.greet='下午好';
	}else{
		$scope.greet='上午好';
	}
	
	$scope.loginout=function(){
		localStorage.removeItem("username");
        localStorage.removeItem("password");
    	window.location.href="./login.html";
	}
	
}]);
var vm = angular.module('userApp',[]);

vm.controller('userList',['$scope','$http',function($scope,$http){
	
	$scope.user=true;
	$scope.isDisabled = true;
	
	var username=window.localStorage.getItem("username");
	var password=window.localStorage.getItem("password");
	
	$http({
		method:'POST',
		params:{
			"username":username,
            "password":password
		},
		url:'/DibikeManagement/manage/login.do',
		dataType:'json',
		
	}).success(function(result){
		$scope.username=username;
		$scope.dataList=result.data;
		
	}).error(function(result){
		
	});
	
	$scope.changeUser=function(){
		$scope.isDisabled = false;
		
		$scope.submitUser=function(){
			
			$scope.isDisabled = true;
			
			var newname=$('.user').val();
			
			$http({
				method:'POST',
				params:{
					"oldName":username,
		            "newName":newname
				},
				url:'/DibikeManagement/manage/updateManage.do',
				dataType:'json',
				
			}).success(function(result){
				
				
				
			}).error(function(result){
				
			});
			
		}
		
		
	}
	
	
	$scope.loginout=function(){
		localStorage.removeItem("username");
        localStorage.removeItem("password");
    	window.location.href="./login.html";
	}
	
}]);
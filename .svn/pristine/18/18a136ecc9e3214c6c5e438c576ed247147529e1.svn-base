vm.controller('roleList',['$scope','$http',function($scope,$http){
	
	$scope.role=true;
	
	$http({
		method:'POST',
		url:'/DibikeManagement/manage/role.do',
		dataType:'json',
	}).success(function(result){
		$scope.jobList=result.data || {};
	}).error(function(result){
		
	});
	
	
	$scope.choose=function(arg,index){
		$http({
			method:'POST',
			params:{
				"manageID":arg
	        },
			url:'/DibikeManagement/manage/updateRole.do',
			dataType:'json',
			
		}).success(function(result){
			$scope.jobList[index].role_name=result.data;
		}).error(function(result){
			
		});
	}
	
}]);
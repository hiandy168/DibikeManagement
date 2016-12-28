vm.controller('userList',['$scope','$filter','$http',function($scope,$filter,$http){
	
	$http({
		method:'POST',
		url:'/DibikeManagement/certification/queryNoCheck.do',
		dataType:'json',
	}).success(function(result){
		$scope.queryNoCheck=result.data || {};
	}).error(function(result){
			
	});
	
	$http({
		method:'POST',
		url:'/DibikeManagement/certification/queryPass.do',
		dataType:'json',
	}).success(function(result){
		$scope.queryPass=result.data || {};
	}).error(function(result){
			
	});
	
	$http({
		method:'POST',
		url:'/DibikeManagement/certification/queryNoPass.do',
		dataType:'json',
	}).success(function(result){
		$scope.queryNoPass=result.data || {};
		
	}).error(function(result){
			
	});
	
	$scope.audit=function(index){
		window.localStorage.setItem("index",index);
    	window.location.href='/DibikeManagement/userAudit.html';
	}
	
	$scope.search=function(e){
		var keycode = window.event?e.keyCode:e.which;
        if (keycode == 13){  
            $scope.fnFilter();  
        }  
	}
	
	$scope.fnFilter=function(){
		$scope.filterVal=angular.element('.filter').val();
		$scope.queryNoCheck=$filter('filter')($scope.queryNoCheck,$scope.filterVal);
		$scope.queryPass=$filter('filter')($scope.queryPass,$scope.filterVal);
		$scope.queryNoPass=$filter('filter')($scope.queryNoPass,$scope.filterVal);
	}
	
}]);
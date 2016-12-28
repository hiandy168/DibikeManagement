vm.controller('informList',['$scope','$filter','$http',function($scope,$filter,$http){
	
	$http({
		method:'POST',
		url:'/DibikeManagement/report_illegal_stop/queryNoCheck.do',
		dataType:'json',
	}).success(function(result){
		var NoCheck=result.data;
		$scope.NoCheck=NoCheck;
		
	}).error(function(result){
		
	});
	
	$http({
		method:'POST',
		url:'/DibikeManagement/report_illegal_stop/queryPass.do',
		dataType:'json',
	}).success(function(result){
		var queryPass=result.data;
		$scope.queryPass=queryPass;
		
	}).error(function(result){
			
	});
	
	$http({
		method:'POST',
		url:'/DibikeManagement/report_illegal_stop/queryNoPass.do',
		dataType:'json',
	}).success(function(result){
		var queryNoPass=result.data;
		$scope.queryNoPass=queryNoPass;
		
	}).error(function(result){
			
	});
	
	$scope.search=function(e){
		var keycode = window.event?e.keyCode:e.which;
        if (keycode == 13){  
            $scope.fnFilter();  
        }  
	}
	
	$scope.fnFilter=function(){
		$scope.filterVal=angular.element('.filter').val();
		$scope.NoCheck=$filter('filter')($scope.NoCheck,$scope.filterVal);
		$scope.queryPass=$filter('filter')($scope.queryPass,$scope.filterVal);
		$scope.queryNoPass=$filter('filter')($scope.queryNoPass,$scope.filterVal);
	}
	
	$scope.audit=function(index){
		window.localStorage.setItem("index",index);
    	window.location.href='/DibikeManagement/informAudit.html';
	}
	
}]);
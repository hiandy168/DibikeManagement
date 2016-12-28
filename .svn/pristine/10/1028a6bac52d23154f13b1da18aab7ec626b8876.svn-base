vm.controller('bikeList',['$scope','$filter','$http',function($scope,$filter,$http){
	
	$scope.all=[];
	
	$http({
		method:'POST',
		url:'/DibikeManagement/bikeFault/queryNoCheck.do',
		dataType:'json',
	}).success(function(result){
		$scope.NoCheck=result.data || {};
		$scope.all.push($scope.NoCheck);
		
	}).error(function(result){
			
	});
	
	
	$http({
		method:'POST',
		url:'/DibikeManagement/bikeFault/queryPass.do',
		dataType:'json',
	}).success(function(result){
		$scope.queryPass=result.data || {};
		$scope.all.push($scope.queryPass);
	}).error(function(result){
		
	});
	
	
	$http({
		method:'POST',
		url:'/DibikeManagement/bikeFault/queryNoPass.do',
		dataType:'json',
	}).success(function(result){
		$scope.queryNoPass=result.data || {};
		$scope.all.push($scope.queryNoPass);
		
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
    	window.location.href='/DibikeManagement/bikeAudit.html';
	}
	
}]);
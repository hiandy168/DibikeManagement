vm.controller('userList',['$scope','$filter','$http',function($scope,$filter,$http){
	
	$http({
		method:'POST',
		url:'/DibikeManagement/certification/queryNoCheck.do',
		dataType:'json',
	}).success(function(result){
		var queryNoCheck=result.data || {};
		$scope.queryNoCheck=queryNoCheck;
		
		$scope.search=function(e){
			var keycode = window.event?e.keyCode:e.which;
	        if (keycode == 13){  
	            $scope.fnFilter();  
	        }  
		}
		
		$scope.fnFilter=function(){
			$scope.filterVal=angular.element('.filter').val();
			$scope.queryNoCheck=$filter('filter')(queryNoCheck,$scope.filterVal);
		}
		
	}).error(function(result){
			
	});
	
	$scope.audit=function(index){
		window.localStorage.setItem("index",index);
    	window.location.href='/DibikeManagement/userAudit.html';
		
	}
	
}]);
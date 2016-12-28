vm.controller('userList',['$scope','$filter','$http',function($scope,$filter,$http){
	
	$http({
		method:'POST',
		url:'/DibikeManagement/certification/queryNoPass.do',
		dataType:'json',
	}).success(function(result){
		var queryNoPass=result.data || {};
		$scope.queryNoPass=queryNoPass;
		
		$scope.search=function(e){
			var keycode = window.event?e.keyCode:e.which;
	        if (keycode == 13){  
	            $scope.fnFilter();  
	        }  
		}
		
		$scope.fnFilter=function(){
			$scope.filterVal=angular.element('.filter').val();
			$scope.queryNoPass=$filter('filter')(queryNoPass,$scope.filterVal);
		}
		
	}).error(function(result){
		
	});
	
	
	
}]);
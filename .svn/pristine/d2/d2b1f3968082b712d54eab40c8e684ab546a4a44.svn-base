vm.controller('userList',['$scope','$filter','$http',function($scope,$filter,$http){
	
	$http({
		method:'POST',
		url:'/DibikeManagement/certification/queryPass.do',
		dataType:'json',
	}).success(function(result){
		var queryPass=result.data || {};
		$scope.queryPass=queryPass;
		
		$scope.search=function(e){
			var keycode = window.event?e.keyCode:e.which;
	        if (keycode == 13){  
	            $scope.fnFilter();  
	        }  
		}
		
		$scope.fnFilter=function(){
			$scope.filterVal=angular.element('.filter').val();
			$scope.queryPass=$filter('filter')(queryPass,$scope.filterVal);
		}
		
	}).error(function(result){
			
	});
	
	
	
}]);
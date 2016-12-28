vm.controller('informList',['$scope','$filter','$http',function($scope,$filter,$http){
	
	$http({
		method:'POST',
		url:'/DibikeManagement/report_illegal_stop/queryNoCheck.do',
		dataType:'json',
	}).success(function(result){
		var NoCheck=result.data;
		$scope.NoCheck=NoCheck;
		
		$scope.search=function(e){
			var keycode = window.event?e.keyCode:e.which;
	        if (keycode == 13){  
	            $scope.fnFilter();  
	        }  
		}
		
		$scope.fnFilter=function(){
			$scope.filterVal=angular.element('.filter').val();
			$scope.NoCheck=$filter('filter')(NoCheck,$scope.filterVal);
		}
		
		$scope.audit=function(index){
			window.localStorage.setItem("index",index);
	    	window.location.href='/DibikeManagement/informAudit.html';
		}
		
	}).error(function(result){
			
	});
	
	
	$scope.audit=function(index){
		window.localStorage.setItem("index",index);
    	window.location.href='/DibikeManagement/informAudit.html';
	}
	
	
	
}]);
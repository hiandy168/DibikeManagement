vm.controller('promotionList',['$scope','$http',function($scope,$http){
	
	$http({
		method:'POST',
		url:'/DibikeManagement/report_illegal_stop/query.do',
		dataType:'json',
	}).success(function(result){
		$scope.promotion=result.data;
		
		$scope.query=function(id){
			window.localStorage.setItem("id",id);
	    	window.location.href='/DibikeManagement/promotionList.html';
		}
		
	}).error(function(result){
		
	});
	
	
}]);
vm.controller('membersList',['$scope','$http',function($scope,$http){
	
	$http({
		method:'POST',
		url:'/DibikeManagement/member/findAllMembers.do',
		dataType:'json',
	}).success(function(result){
		$scope.member=result.data;
		console.log($scope.member);
	}).error(function(result){
		
	});
	
}]);
vm.controller('MemberList',['$scope','$http',function($scope,$http){
	
	$http({
		method:'POST',
		url:'/DibikeManagement/memberInfo/findAllMemberInfos.do',
		dataType:'json',
	}).success(function(result){
		$scope.member=result.data;
		
	}).error(function(result){
		
	});
	
}]);
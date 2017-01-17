vm.controller('MemberList',['$scope','$http','$filter',function($scope,$http,filter){
	
	$http({
		method:'POST',
		params:{
			"number":1,
		},
		url:'/DibikeManagement/memberInfo/findAllMemberInfos.do',
		dataType:'json',
	}).success(function(result){
		$scope.count=result.data[0];
		$scope.page=result.data[1];
		$scope.member=result.data[2];
		
		angular.forEach($scope.member,function(value,i){
			var reg =/^[0-9]*$/;
			
			if(!reg.test(value.nickName)){
				value.nickName=value.nickName
			}else{
				value.nickName=''
			}
			
		});
		
		$(".tcdPageCode").createPage({
			 pageCount:$scope.page,
		     current:1,
		     backFn:function(page){
		    	 $http({
					method:'POST',
					params:{
						"number":page,
					},
					url:'/DibikeManagement/memberInfo/findAllMemberInfos.do',
					dataType:'json'
				}).success(function(result){
					$scope.count=result.data[0];
					$scope.page=result.data[1];
					$scope.member=result.data[2];
					
				}).error(function(result){
						
				});
		    	 
		    	
		     }
		})
		
	}).error(function(result){
		
	});
	
}]);
vm.controller('userphone',['$scope','$http',function($scope,$http){
	
	$scope.query=function(){
		var reg = /^1\d{10}$/;
		$scope.phone=angular.element('.phone').val();
		
		if(reg.test($scope.phone)){
			$http({
				method:'POST',
				params:{
					"phone":$scope.phone,
		        },
				url:'/DibikeManagement/member/findByPhone.do',
				dataType:'json',
			}).success(function(result){
				if(status==0){
					$scope.name=result.data;
				}else{
					
				}

			}).error(function(result){
				alert('无此手机号的信息!!!')
			});
		}else{
			alert('请输入正确的11位手机号!!!')
		}
	}

}]);
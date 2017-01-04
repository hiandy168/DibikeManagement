vm.controller('PaymentsList',['$scope','$http',function($scope,$http){
	
	$http({
		method:'POST',
		url:'/DibikeManagement/wechat/findweChatPayments.do',
		dataType:'json',
	}).success(function(result){
		$scope.payments=result.data;
		
		$scope.export=function(){
			$http({
				method:'POST',
				url:'/DibikeManagement/export/excelweChatPayments.do',
				dataType:'json',
			}).success(function(result){
				if(status==0){
					alert('导出成功!!!')
				}
			}).error(function(result){
				
			});
		}
		
	}).error(function(result){
		
	});
	
}]);
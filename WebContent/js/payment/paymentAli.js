vm.controller('paymentAli',['$scope','$http',function($scope,$http){
	
	$http({
		method:'POST',
		url:'/DibikeManagement/aliPayment/findAliPayments.do',
		dataType:'json',
	}).success(function(result){
		$scope.payments=result.data;
		
		$scope.export=function(){
			$http({
				method:'POST',
				url:'/DibikeManagement/export/excelAlipay_payment.do',
				
			}).success(function(result){
				
			}).error(function(result){
				
			});
		}
		
	}).error(function(result){
		
	});
	
}]);
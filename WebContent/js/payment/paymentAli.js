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
				dataType:'text'
			}).success(function(result){
				if(status==0){
					alert('导出成功!!!');
					document.location.href='/DibikeManagement/export/excelAlipay_payment.do'
			    }
			}).error(function(result){
				
			});
			
		}
		
		$scope.channel=function(){
			angular.element('.execl_fix').show();
			
			$scope.files=function(){
				var oMyForm = new FormData();
    			oMyForm.append("file", $('#file')[0].files[0]);
				
    			$http({
    	            method:'POST',
    	            url:'/DibikeManagement/import/excelAlipay_payment.do',
    	            data: oMyForm,
    	            headers: {
    	            	'Content-Type':undefined
    	            },
    	            transformRequest:angular.identity,
    	            async: true
    	        }).success(function(response){
    	        	alert('成功导入!!!')
    	        }).error(function(){
    	        	alert('文件有误!!!')
    	        });
    			
    			/*$.ajax({
    				url:'/DibikeManagement/import/excelAlipay_payment.do',
    			    type: 'POST',
    			    cache: false,
    			    data: oMyForm,
    			    processData: false,
    			    contentType: false,
    			    async: false
    			}).done(function(res) {
    				alert('成功导入!!!')
    			}).fail(function(res) {
    				alert('文件有误!!!')
    			});*/
			}
			
			$scope.close=function(){
				angular.element('.execl_fix').hide();
			}
			
		}
		
	}).error(function(result){
		
	});
	
	
	
}]);
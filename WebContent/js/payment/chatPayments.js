vm.controller('PaymentsList',['$scope','$http',function($scope,$http){
	
	$http({
		method:'POST',
		params:{
			"number":1,
		},
		url:'/DibikeManagement/wechat/findweChatPayments.do',
		dataType:'json',
	}).success(function(result){
		$scope.count=result.data[0];
		$scope.page=result.data[1];
		$scope.payments=result.data[2];
		
		$(".tcdPageCode").createPage({
			 pageCount:$scope.page,
		     current:1,
		     backFn:function(page){
		    	 $http({
					method:'POST',
					params:{
						"number":page,
					},
					url:'/DibikeManagement/wechat/findweChatPayments.do',
					dataType:'json',
				}).success(function(result){
					$scope.count=result.data[0];
					$scope.page=result.data[1];
					$scope.payments=result.data[2];
				}).error(function(result){
						
				});
		     }
		})
		
		$scope.export=function(){
			var number=angular.element('.current').html();
			
			$http({
				method:'POST',
				params:{
					"number":number,
				},
				url:'/DibikeManagement/export/excelweChatPayments.do',
				dataType:'text'
			}).success(function(result){
				if(status==0){
					alert('导出成功!!!');
					document.location.href='/DibikeManagement/export/excelweChatPayments.do?number='+number
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
    			
    		}
			
			$scope.close=function(){
				angular.element('.execl_fix').hide();
			}
		}
		
	}).error(function(result){
		
	});
	
}]);
vm.controller('importBikeList',['$scope','$http',function($scope,$http){
	
	$scope.channel=function(){
		angular.element('.execl_fix').show();
		
		$scope.files=function(){
			var oMyForm = new FormData();
			oMyForm.append("file", $('#file')[0].files[0]);
			
			$http({
	            method:'POST',
	            url:'/DibikeManagement/import/excelBike.do',
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
	
}]);
vm.controller('detailList',['$scope','$http',function($scope,$http){
	
	$http({
		method:'POST',
		params:{
			"number":1,
		},
		url:'/DibikeManagement/bikeFault/checkDetail.do',
		dataType:'json',
	}).success(function(result){
		$scope.count=result.data[0];
		$scope.page=result.data[1];
		$scope.detail=result.data[2];
		
		$scope.export=function(){
			$http({
				method:'POST',
				params:{
					"number":1,
				},
				url:'/DibikeManagement/export/excelBike_fault.do',
				dataType:'text'
			}).success(function(result){
				if(status==0){
					alert('导出成功!!!');
					document.location.href='/DibikeManagement/export/excelBike_fault.do?number='+1;
				}
			}).error(function(result){
				
			});
			
		}
		
		angular.element('.pagination li a').on('click',function(){
			var num=$(this).html();
			$(this).parents('.pagination li').addClass('active');
			
			$http({
				method:'POST',
				params:{
					"number":num,
				},
				url:'/DibikeManagement/bikeFault/checkDetail.do',
				dataType:'json',
			}).success(function(result){
				$scope.detail=result.data[2] || {};
				
			}).error(function(result){
					
			});
			
		})
		
	}).error(function(result){
			
	});
	
	
	
}]);
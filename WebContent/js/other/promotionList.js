vm.controller('promotionList',['$scope','$http',function($scope,$http){
	
	var id=window.localStorage.getItem("id");
	
	$http({
		method:'POST',
		params:{
			"id":id,
        },
        url:'/DibikeManagement/report_illegal_stop/query.do',
		dataType:'json',
	}).success(function(result){
		$scope.promotion=result.data;
		
		$scope.end=function(bikeNo){
			
			$http({
				method:'POST',
				params:{
					"bikeNO":bike,
		        },
		        url:'/DibikeManagement/push/pushMessage.do',
			}).success(function(result){
				if(status==0){
					alert('推送成功!!!');
					localStorage.removeItem("id");
					history.back();
				}else{
					alert('推送失败!!!');
				}
				
			}).error(function(result){
				
			});
		}
		
	}).error(function(result){
		
	});
	
	$scope.gohistory=function(){
		localStorage.removeItem("id");
		history.back();
	}
	
}]);
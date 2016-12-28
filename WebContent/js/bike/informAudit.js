vm.controller('informList',['$scope','$http',function($scope,$http){
	
	var index=window.localStorage.getItem("index");
	
	$http({
		method:'POST',
		params:{
			"id":index,
        },
		url:'/DibikeManagement/report_illegal_stop/check.do',
		dataType:'json',
	}).success(function(result){
		$scope.audit=result.data;
		
		$scope.pass=function(){
			$http({
				method:'POST',
				params:{
					"id":index,
		        },
				url:'/DibikeManagement/report_illegal_stop/checkPass.do'
			}).success(function(result){
				if(status==0){
					localStorage.removeItem("index");
					alert('操作成功  审核通过');
					window.location.href='/DibikeManagement/informPass.html';
				}else{
					alert('网络连接有误');
				}
				
			}).error(function(result){
					
			});
		}
		
		$scope.noPass=function(){
			$http({
				method:'POST',
				params:{
					"id":index,
		        },
				url:'/DibikeManagement/report_illegal_stop/checkNoPass.do'
			}).success(function(result){
				if(status==0){
					localStorage.removeItem("index");
					alert('操作成功  审核不通过');
					window.location.href='/DibikeManagement/informNoPass.html';
				}else{
					alert('网络连接有误');
				}
				
			}).error(function(result){
					
			});
		}
		
	}).error(function(result){
			
	});
	
	$scope.gohistory=function(){
		localStorage.removeItem("index");
		history.back();
	}
	
}]);
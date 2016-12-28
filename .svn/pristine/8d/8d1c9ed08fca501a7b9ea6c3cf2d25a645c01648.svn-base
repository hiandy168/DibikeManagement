vm.controller('audit',['$scope','$http',function($scope,$http){
	
	var index=window.localStorage.getItem("index");
	
	$http({
		method:'POST',
		params:{
			"memberID":index,
        },
		url:'/DibikeManagement/certification/check.do',
		dataType:'json',
	}).success(function(result){
		$scope.pic=result.data;
	}).error(function(result){
			
	});
	
	
	$scope.pass=function(){
		$http({
			method:'POST',
			params:{
				"memberID":index
			},
			url:'/DibikeManagement/certification/checkPass.do',
		}).success(function(result){
			if(status==0){
				alert('操作成功  审核通过!!!');
				localStorage.removeItem("memberID");
				window.location.href='/DibikeManagement/userPass.html';
			}else{
				
			}
			
		}).error(function(result){
				
		});
	}
	
	
	$scope.noPass=function(){
		$http({
			method:'POST',
			params:{
				"memberID":index
			},
			url:'/DibikeManagement/certification/checkNoPass.do',
		}).success(function(result){
			if(status==0){
				alert('操作成功  审核不通过!!!');
				localStorage.removeItem("memberID");
				window.location.href='/DibikeManagement/userNoPass.html';
			}else{
				
			}
				
		}).error(function(result){
				
		});
	}
	
	$scope.gohistory=function(){
		localStorage.removeItem("index");
		history.back();
	}
	
}]);
vm.controller('depositList',['$scope','$http',function($scope,$http){
	
	$scope.cash=299;
	
	$scope.save=function(){
		var reg = /^([1-9]\d{0,15}|0)(\.\d{0,2})?$/;
		
		var deposit=angular.element('.deposit').val();
		var money=angular.element('.money').val();
		
		if(deposit.length==0 || money.length==0){
			alert('请输入金额')
		}else if(isNaN(deposit) || isNaN(money)){
			alert('请输入正确的金额')
		}else if(parseInt(deposit)!=deposit){
			alert('押金只能输入整数金额')
		}else if(!reg.test(money)){
			alert('单价最多输入2位小数')
		}else{
			$http({
				method:'POST',
				params:{
	    			"deposit":deposit,
	                "money":money
	    		},
				url:'/DibikeManagement/deposit/add.do',
				
			}).success(function(result){
				if(status==0){
					alert('增加成功!!!');
					$http({
						method:'POST',
						url:'/DibikeManagement/deposit/query.do',
						dataType:'json'
					}).success(function(result){
						$scope.deposit=result.data;
						
					}).error(function(result){
						
					});
				}
				
				
			}).error(function(result){
				
			});
		}
		
	}
	
	$http({
		method:'POST',
		url:'/DibikeManagement/deposit/query.do',
		dataType:'json'
	}).success(function(result){
		$scope.deposit=result.data;
		
		$scope.upStatus=function(id,status){
			$http({
				method:'POST',
				params:{
	    			"id":id,
	    			"status":status
	            },
				url:'/DibikeManagement/deposit/updateStatus.do',
			}).success(function(result){
				if(result.status==0){
					alert('操作成功!!');
					$http({
						method:'POST',
						url:'/DibikeManagement/deposit/query.do',
						dataType:'json'
					}).success(function(result){
						$scope.deposit=result.data;
						
					}).error(function(result){
						
					});
				}
			}).error(function(result){
				
			});
		}
		
	}).error(function(result){
		
	});
	
	
	
}]);
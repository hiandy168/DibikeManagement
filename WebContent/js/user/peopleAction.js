vm.controller('peopleList',['$scope','$http',function($scope,$http){
	
	$http({
		method:'POST',
		url:'/DibikeManagement/manage/queryManage.do',
		dataType:'json'
	}).success(function(result){
		$scope.people=result.data
		
		$scope.selectDel=function(manageID){
			$http({
				method:'POST',
				params:{
					"manageID":manageID
	    		},
				url:'/DibikeManagement/action/checkManage.do',
				dataType:'json'
			}).success(function(result){
				$scope.privilege=result.data;
				
			}).error(function(result){
				
			});
		}
		
		
		
	}).error(function(result){
		
	});
	
	$http({
		method:'POST',
		url:'/DibikeManagement/action/checkManage.do',
		dataType:'json'
	}).success(function(result){
		$scope.privilege=result.data;
		
	}).error(function(result){
		
	});
	
	
	$scope.save=function(){
		var people=angular.element("input[name='people']:checked").val();
		var pri=angular.element("input[name='privilege']");
	
		var arrPri=[];
	
		for(var i=0; i<pri.length; i++){
			if(pri[i].checked){
				arrPri.push(pri[i].value)
			}
		};
		
		if(people==null){
			alert('请选择用户再提交！！！')
		}else if(arrPri.length==0){
			alert('请选择权限再提交！！！')
		}else{
			console.log(people);
			console.log(arrPri);
			$http({
				method:'POST',
				params:{
					"manageID": people,
	    			"actionIDs": arrPri
	    		},
				url:'/DibikeManagement/action/updateManageAction.do',
			}).success(function(result){
				if(result.status==0){
					alert('保存成功!!!')
				}
			}).error(function(result){
					
			});
		}
	
	}
	
}]);


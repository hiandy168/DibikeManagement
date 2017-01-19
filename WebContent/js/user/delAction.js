vm.controller('delManageList',['$scope','$http',function($scope,$http){
	
	$http({
		method:'POST',
		url:'/DibikeManagement/action/queryAllRole.do',
		dataType:'json',
	}).success(function(result){
		$scope.department=result.data;
		
		$http({
			method:'POST',
			params:{
				"roleID":3
	        },
			url:'/DibikeManagement/action/checkRole.do',
			dataType:'json',
		}).success(function(result){
			$scope.privilege=result.data;
			
		}).error(function(result){
				
		});
		
		$scope.selectDel=function(roleID){
			$http({
				method:'POST',
				params:{
					"roleID":roleID
		        },
				url:'/DibikeManagement/action/checkRole.do',
				dataType:'json',
			}).success(function(result){
				$scope.privilege=result.data;
				
			}).error(function(result){
					
			});
		}
		
		$scope.save=function(){
			var del=angular.element("input[name='department']:checked").val();
			var pri=angular.element("input[name='privilege']");
			
			var arrPri=[];
		
			for(var i=0; i<pri.length; i++){
				if(pri[i].checked){
					arrPri.push(pri[i].value)
				}
			};
			
			if(del==null || arrPri.length==0){
				alert('请选择部门和部门权限再提交！！！')
			}else{
				$http({
					method:'POST',
					params:{
						"roleID":del,
		    			"actionIDs":arrPri
		    		},
					url:'/DibikeManagement/action/updateRoleAction.do',
				}).success(function(result){
					if(result.status==0){
						alert('保存成功!!!')
					}
				}).error(function(result){
						
				});
			}
		
		}
		
	}).error(function(result){
		
	});
	
	
	
	
	
}]);
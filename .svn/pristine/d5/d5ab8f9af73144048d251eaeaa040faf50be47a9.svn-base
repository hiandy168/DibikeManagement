vm.controller('jurisdictionList',['$scope','$http',function($scope,$http){
	
	$http({
		method:'POST',
		url:'/DibikeManagement/privilege/queryAll.do',
		dataType:'json',
	}).success(function(result){
		$scope.department=result.data[0];
		$scope.privilege=result.data[1];
		
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
				alert('请选择部门和权限，不能为空')
			}else{
				console.log(del);
				console.log(arrPri);
			}
			
		}
		
	}).error(function(result){
			
	});
	
	
	
}]);
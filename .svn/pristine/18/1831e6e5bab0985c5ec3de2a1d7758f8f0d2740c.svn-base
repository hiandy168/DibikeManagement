vm.controller('addActionList',['$scope','$http',function($scope,$http){
	
	$http({
		method:'POST',
		url:'/DibikeManagement/action/queryPidName.do',
		dataType:'json',
	}).success(function(result){
		$scope.pidname=result.data;
	}).error(function(result){
		
	});
	
	$scope.save=function(){
		var pid=angular.element("input[name='pidname']:checked").val();
		var menu=angular.element(".meu").val();
		
		var reg = /^[\u4e00-\u9fa5]{4,6}$/;
		
		if(pid==null){
			alert('请选择要添加的权限!!!')
		}else if(!reg.test(menu)){
			alert('请输入4-6个汉字')
		}else{
			$http({
				method:'POST',
				params:{
					"pid":pid,
					"name":menu
		        },
				url:'/DibikeManagement/action/addAction.do',
				dataType:'json',
			}).success(function(result){
				if(status==0){
					alert('添加成功!!!')
				}
			}).error(function(result){
				
			});
		}
		
	}
	
}]);
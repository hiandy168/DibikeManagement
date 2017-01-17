vm.controller('roleList',['$scope','$http',function($scope,$http){
	
	$scope.submit=function(e){
		var keycode = window.event?e.keyCode:e.which;
        if (keycode == 13){  
            $scope.save();  
        }  
	}
	
	$scope.save=function(){
		var name=angular.element("input.name").val();
		
		var reg = /^[\u4E00-\u9FA5\uF900-\uFA2D]{2,4}$/;
		
		if(!reg.test(name)){
			alert('请输入2-4个汉字');
		}else{
			$http({
				method:'POST',
				params:{
					"name":name
		        },
				url:'/DibikeManagement/role/addRole.do',
				dataType:'json',
			}).success(function(result){
				if(status==0){
					alert('添加成功!!!');
				}
			}).error(function(result){
				
			});
		}
	}

}]);


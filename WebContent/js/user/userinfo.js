vm.controller('userList',['$scope','$http',function($scope,$http){
	
	var username=window.localStorage.getItem("username");
	$scope.username=username;
	
	$scope.change= function (e) {      
        var keycode = window.event?e.keyCode:e.which;
        if (keycode == 13){  
            $scope.changeUser();  
        }  
    }  
	
	$scope.changeUser=function(){
		var newname=$('.username').val();
		if(newname==username){
			alert('修改后的用户名不能和原来的用户名一致');
		}else{
			$http({
				method:'POST',
				params:{
					"oldName":username,
			           "newName":newname
				},
				url:'/DibikeManagement/manage/updateManage.do',
				dataType:'json',
					
			}).success(function(result){
					
				alert('用户名修改成功,重新登录');
				localStorage.removeItem("username");
			    localStorage.removeItem("password");
			    window.location.href="./login.html";
					
					
			}).error(function(result){
					
			});
		}
			
	}
	
}]);
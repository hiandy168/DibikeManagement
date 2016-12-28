vm.controller('passWList',['$scope','$http',function($scope,$http){
	
	$scope.password=true;
	var password=window.localStorage.getItem("password");
	
	$scope.change= function (e) {      
        var keycode = window.event?e.keyCode:e.which;
        if (keycode == 13){  
            $scope.changePass();  
        }  
    }  
	
	$scope.changePass=function(){
			
		var oldpass=angular.element('.oldpass').val();
		var pass1=angular.element('.pass1').val();
		var pass2=angular.element('.pass2').val();
			
			
		if(oldpass!=password){
			alert('原密码不正确,请重新输入');
		}else if(pass1==oldpass||pass2==oldpass){
			alert('旧密码不能和新密码一致,请重新输入');
		}else if(pass1!==pass2){
			alert('2次输入的新密码不一致,请重新输入');
		}else if(pass1.length!=6 && pass2.length!=6){
			alert('密码的长度必须是6位,请重新输入');
		}else{
			$http({
				method:'POST',
				params:{
					"name":username,
					"newPassword":pass2
				},
				url:'/DibikeManagement/manage/updateManagePassword.do',
				dataType:'json',
			}).success(function(result){
				console.log(result);
				if(result.status==0){
					alert('密码修改成功,重新登录');
					localStorage.removeItem("username");
				    localStorage.removeItem("password");
				    window.location.href="./login.html";
				}else{
						
				}
					
					
			}).error(function(result){
					
			});
		}
	}
		
}]);
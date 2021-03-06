vm.controller('backupList',['$scope','$http',function($scope,$http){
	
	$http({
		method:'POST',
		url:'/DibikeManagement/file/check.do',
		dataType:'json'
	}).success(function(result){
		$scope.sql=result.data;
		
		$scope.upload=function(fileName,path){
			$http({
				method:'POST',
				params:{
					"path":path,
					"fileName":fileName
	    		},
				url:'/DibikeManagement/file/download.do',
			}).success(function(result){
				window.open('/DibikeManagement/file/download.do?path='+path+'&fileName='+fileName)
			}).error(function(result){
				
			});
		}
		
	}).error(function(result){
		
	});
	
}]);


vm.controller('bikeMap',['$scope','$http',function($scope,$http){
	
	$http({
		method:'POST',
		url:'/DibikeManagement/bike/query.do',
		dataType:'json',
	}).success(function(result){
		
		var mapObj = new AMap.Map('container',{
			resizeEnable: true,
			center:[result.data[0].lng, result.data[0].lat],
			zoom: 17,
			isHotspot: true,
		});
		
		
		mapObj.plugin(["AMap.Marker","AMap.Geolocation","AMap.ToolBar","AMap.Scale","AMap.MapType","AMap.OverView"],
			function(){
				mapObj.addControl(new AMap.Marker({
					map:mapObj,
					position:[121.502079,31.27404]
				}));
				
				mapObj.addControl(new AMap.ToolBar({
					position:'LT',
					offset:new AMap.Pixel(20,20),
					ruler:false,
					noIpLocate:true,
					liteStyle:false
				}));
					
				mapObj.addControl(new AMap.Scale({
					position:'LB',
					offset: new AMap.Pixel(30,30),
				}));
					
				mapObj.addControl(new AMap.OverView({
					isOpen:true,
					visible:true
				}));
					
				mapObj.addControl(new AMap.MapType({
					defaultType: 0,
					showTraffic: false,
					showRoad: false
				}));
				
		});
		
		AMap.service(["AMap.PlaceSearch","AMap.Geocoder"], function() {
		    var placeSearch = new AMap.PlaceSearch({ 
		        pageSize: 5,
		        city: "021", 
		        map: mapObj,
		        panel: "panel"
		    });
		    
		    //placeSearch.search('贝庆单车')
		    
		    var geocoder = new AMap.Geocoder({
			   city: "021"
		    });
		   
		   
		   var arr=[];
		   angular.forEach(result.data,function(value,i){
				geocoder.getAddress(value.lng+','+value.lat, function(status,result) {
				    if (status === 'complete' && result.info === 'OK') {
				    	console.log(result.regeocode.formattedAddress);
				    	
				    	placeSearch.search(result.regeocode.formattedAddress);
				    }else{
				         
				    }
				});
				this.push(value.lng+','+value.lat);
				
		   },arr);
		   console.log(arr);
		   
		});
		
		
	
	}).error(function(result){
		
	});
	
	
}]);
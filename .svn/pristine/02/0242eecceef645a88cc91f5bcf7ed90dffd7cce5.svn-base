vm.controller('userSList',['$scope','$http',function($scope,$http){
	
	$scope.week=echarts.init(document.getElementById('week'));
	$scope.month=echarts.init(document.getElementById('month'));
	
	weekOption= {
			backgroundColor:'#109ba3',
			title:{
				 x:'center',
				 y:'top',    
				 text: '用户本周注册量',
				 subtext:'Weeks registrations',
				 padding:10,  
				 textStyle:{
					 fontSize:18,
					 fontWeight:'bolder',
					 color:'#fff'
				 },
				 subtextStyle:{
					 fontSize: 14,
					 fontWeight: 'normal',
					 color: '#fff'
				 }
			},
			tooltip : {
		        trigger:'item'
		    },
		    toolbox: {
		       show: true,
		       orient: 'vertical',
		       y: 'center',
		       padding: 30, 
		       feature: {
		        	dataView: {
		            	show : true,
		                title : '数据视图',
		                readOnly: true,
		                lang : ['数据视图','关闭','刷新']
		        	},
		            magicType:{
		            	title : {
		            		 line: '折线图切换',
		                     bar: '柱形图切换',
		                },
		            	type: ['line','bar'],
		            	
		            },
		        }
		    },
		    calculable : true,
		    xAxis :[
		        {
		            type : 'category',
		            boundaryGap : false,
		            data : ['周一','周二','周三','周四','周五','周六','周日'],
		            axisLine:{  
		                lineStyle:{  
		                    color:'#ff00ae',  
		                    width:3
		                 }  
		            },
		        }
		    ],
		    yAxis : [
		         {
		             type: 'value',
		             axisLine:{  
		                lineStyle:{  
		                    color:'#ffff00',  
		                    width:3  
		                 }  
		             },  
		         }
		    ],
		    series:[
		        {
		            name:'注册量',
		            type:'line',
		            itemStyle: {
		            	normal:{
		            		color:'#eb6588',
		            		areaStyle: {
		            			type: 'default'
		            		}
		            	}
		            },
		            data:[120,132,101,134,90,230,210]
		        }
		    ]
		};

		monthOption = {
			backgroundColor:'#109ba3',
			title:{
				x: 'center',
				y: 'top',    
				text: '用户本周注册量',
				subtext: 'Weeks registrations',
				padding: 10,  
				textStyle:{
					fontSize: 18,
					fontWeight: 'bolder',
					color: '#fff'
				},
				subtextStyle:{
					fontSize: 14,
					fontWeight: 'normal',
					color: '#fff'
				}
			},
		    tooltip : {
		        trigger: 'item'
		    },
		    toolbox: {
		    	show: true,
		        padding: 15,  
		        
		        feature: {
		            dataView: {
		            	show: true, 
		            	readOnly: false
		            },
		            magicType : {
		            	show: true, 
		            	type: ['line','bar']
		            },
		        }
		    },
		    calculable : true,
		    xAxis : [
		        {
		            type : 'category',
		            boundaryGap : false,
		            data : ['第一周','第二周','第三周','第四周']
		        }
		    ],
		    yAxis : [
		        {
		            type : 'value'
		        }
		    ],
		    series : [
		        {
		            name:'注册量',
		            type:'line',
		            stack: '总量',
		            itemStyle: {
		            	normal: 
		            	{	
		            		color:'#eb6588',
		            		areaStyle: 
		            		{
		            			type: 'default'}
		            		}
		            	},
		            data:[100,80,350,169]
		        }
		     ]
		};
	
	
	$scope.week.setOption(weekOption);
	$scope.month.setOption(monthOption);
	
	
	$http({
		method:'POST',
		url:'/DibikeManagement/member/countMember.do',
		dataType:'json',
	}).success(function(result){
		console.log(result);
		
	}).error(function(result){
		
	}); 
	
}]);
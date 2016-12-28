package com.Dibike.controller;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.Dibike.common.HTTP;
import com.Dibike.common.Platform_Response;
import com.Dibike.common.Result;
import com.Dibike.entity.Bike;
import com.Dibike.service.BikeService;

/**
 * @author wuxiang
 * @version 创建时间：2016年12月27日 下午3:05:16
 * 
 */

@Controller
@RequestMapping("/gps")
public class GPSController {
	private static Logger logger = Logger.getLogger(GPSController.class);
	
	@Resource 
	private BikeService BikeService;
	
	@RequestMapping(value = "/GpsReturn")
	@ResponseBody
	public Result GpsReturn(String deviceid) throws IOException{
		logger.info("-------根据车辆编号或锁的编号来查看是否返回信息------");
		//根据车辆编号发送指令
		Platform_Response platform_Response = new Platform_Response();
		platform_Response.setVersion(1);
		platform_Response.setUserid("201612208beiqing");
		platform_Response.setCmd("open");
		platform_Response.setDeviceid(deviceid);
		platform_Response.setSerialnum(10);
		String str = platform_Response.getOrder();
		HTTP.appadd("http://47.90.39.93:8888", str);
		//根据回调指令进行判断()
		Bike bike=BikeService.findDeviceid(deviceid);
		Result result = new Result();
		if(bike.getRemark().equals("ok")){
			result.setStatus("0");
			result.setMsg("GPS正在工作");
			result.setData(bike.getRemark());
		}else{
			result.setStatus("1");
			result.setMsg("GPS异常");
			result.setData(bike.getRemark());
		}
		return result;
	}
}

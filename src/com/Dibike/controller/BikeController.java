package com.Dibike.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Dibike.common.Result;
import com.Dibike.entity.Bike;
import com.Dibike.service.BikeService;

@Controller
@RequestMapping("/bike")
public class BikeController {
	private static Logger logger = Logger.getLogger(BikeController.class);
	@Resource 
	private BikeService bikeService;

	@RequestMapping(value = "/query")
	@ResponseBody
	public Result query(){
		logger.info("-------查询单车信息------");
		Result result = new Result();
		List<Bike> list = bikeService.findAll();
		result.setData(list);
		result.setStatus("0");
		return result;
	}
}

package com.Dibike.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Dibike.common.Result;
import com.Dibike.common.UtilDate;
import com.Dibike.entity.Bike_fault;
import com.Dibike.entity.MemberInfo;
import com.Dibike.entity.Point;
import com.Dibike.service.BikeFaultService;
import com.Dibike.service.MemberInfoService;
import com.Dibike.service.PointService;

@Controller
@RequestMapping("/bikeFault")
public class BikeFaultController {
	private static Logger logger = Logger.getLogger(BikeFaultController.class);
	@Resource 
	private BikeFaultService bikeFaultService;
	
	@Resource 
	private PointService pointService;
	
	@Resource
	private MemberInfoService memberInfoService;
	
	@RequestMapping(value = "/queryNoCheck")
	@ResponseBody
	public Result queryNoCheck(){
		logger.info("-------查询单车故障未审核------");
		Result result = new Result();
		String status = "R";
		List<Bike_fault> list = bikeFaultService.findByStatus(status);
		result.setData(list);
		result.setStatus("0");
		return result;
	}
	
	@RequestMapping(value = "/queryPass")
	@ResponseBody
	public Result queryPass(){
		logger.info("-------查询单车故障已审核------");
		Result result = new Result();
		String status = "O";
		List<Bike_fault> list = bikeFaultService.findByStatus(status);
		result.setData(list);
		result.setStatus("0");
		return result;
	}
	
	@RequestMapping(value = "/queryNoPass")
	@ResponseBody
	public Result queryNoPass(){
		logger.info("-------查询单车故障审核驳回------");
		Result result = new Result();
		String status = "N";
		List<Bike_fault> list = bikeFaultService.findByStatus(status);
		result.setData(list);
		result.setStatus("0");
		return result;
	}
	
	@RequestMapping(value = "/check")
	@ResponseBody
	public Result check(String id){
		logger.info("-------单车故障审核------");
		Result result = new Result();
		Bike_fault bike_fault = bikeFaultService.findById(id);
		result.setStatus("0");
		result.setData(bike_fault);
		return result;
	}
	
	@RequestMapping(value = "/checkPass")
	@ResponseBody
	public Result checkPass(String id){
		logger.info("-------单车故障审核通过------");
		Result result = new Result();
		Bike_fault bike_fault = bikeFaultService.findById(id);
		bike_fault.setStatus("O");
		bikeFaultService.updateBike_fault(bike_fault);
		//审核通过的给上报该故障的用户积分加一分
		MemberInfo memberInfo = memberInfoService.findByMemberID(bike_fault.getMemberID());
		if(memberInfo == null){
			result.setStatus("1");
			return result;
		}
		int i = Integer.parseInt(memberInfo.getPoint());
		String number = String.valueOf(i+1);
		Point point = new Point();
		point.setMemberID(bike_fault.getMemberID());
		point.setNumber(number);
		point.setTime(UtilDate.getDateFormatter());
		point.setPoint_name("单车故障审核通过");
		pointService.savePoint(point);
		memberInfo.setPoint(number);
		memberInfoService.updateMemberInfo(memberInfo);
		result.setStatus("0");
		return result;
	}
	
	@RequestMapping(value = "/checkNoPass")
	@ResponseBody
	public Result checkNoPass(String id){
		logger.info("-------单车故障审核驳回------");
		Result result = new Result();
		Bike_fault bike_fault = bikeFaultService.findById(id);
		bike_fault.setStatus("N");
		bikeFaultService.updateBike_fault(bike_fault);
		result.setStatus("0");
		return result;
	}
	
	private int pageSize = 15;// 每页显示条数
	@RequestMapping(value = "/checkDetail")
	@ResponseBody
	public Result checkDetail(String number){
		logger.info("-------分页查询单车故障信息------");
		Result result = new Result();
//		if (pageNum == 0) {
//			pageNum = 1;
//		}
		int pageNum = Integer.parseInt(number);
		int totalRow = bikeFaultService.findAll().size();// 总记录条数
		int totalPage = totalRow / pageSize + (totalRow % pageSize > 0 ? 1 : 0);// 总页数
		List<Bike_fault> list = bikeFaultService.findList( pageNum, pageSize);
		List lists = new ArrayList();
		lists.add(totalRow+"");
		lists.add(totalPage+"");
		lists.add(list);
		result.setData(lists);
		result.setStatus("0");
		return result;
	}
	

}

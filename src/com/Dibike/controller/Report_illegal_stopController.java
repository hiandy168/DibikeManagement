package com.Dibike.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Dibike.common.Result;
import com.Dibike.entity.MemberInfo;
import com.Dibike.entity.Point;
import com.Dibike.entity.Report_illegal_stop;
import com.Dibike.service.MemberInfoService;
import com.Dibike.service.PointService;
import com.Dibike.service.Report_illegal_stopService;

@Controller
@RequestMapping("/report_illegal_stop")
public class Report_illegal_stopController{
	private static Logger logger = Logger.getLogger(Report_illegal_stopController.class);
	@Resource 
	private Report_illegal_stopService report_illegal_stopService;
	
	@Resource 
	private PointService pointService;
	
	@Resource
	private MemberInfoService memberInfoService;
	
	@RequestMapping(value = "/queryNoCheck")
	@ResponseBody
	public Result queryNoCheck(){
		logger.info("-------查询举报违停未审核------");
		Result result = new Result();
		String status = "N";
		List<Report_illegal_stop> list = report_illegal_stopService.findByStatus(status);
		result.setData(list);
		result.setStatus("0");
		return result;
	}
	
	@RequestMapping(value = "/queryPass")
	@ResponseBody
	public Result queryPass(){
		logger.info("-------查询举报违停已审核------");
		Result result = new Result();
		String status = "Y";
		List<Report_illegal_stop> list = report_illegal_stopService.findByStatus(status);
		result.setData(list);
		result.setStatus("0");
		return result;
	}
	
	@RequestMapping(value = "/queryNoPass")
	@ResponseBody
	public Result queryNoPass(){
		logger.info("-------查询举报违停审核驳回------");
		Result result = new Result();
		String status = "R";
		List<Report_illegal_stop> list = report_illegal_stopService.findByStatus(status);
		result.setData(list);
		result.setStatus("0");
		return result;
	}
	
	
	@RequestMapping(value = "/check")
	@ResponseBody
	public Result check(String id){
		logger.info("-------举报违停审核------");
		Result result = new Result();
		Report_illegal_stop report_illegal_stop = report_illegal_stopService.findById(id);
		result.setStatus("0");
		result.setData(report_illegal_stop);
		return result;
	}
	
	@RequestMapping(value = "/checkPass")
	@ResponseBody
	public Result checkPass(String id){
		logger.info("-------举报违停审核通过------");
		Result result = new Result();
		Report_illegal_stop report_illegal_stop = report_illegal_stopService.findById(id);
		report_illegal_stop.setStatus("Y");
		report_illegal_stopService.updateReport_illegal_stop(report_illegal_stop);
		//审核通过的给举报违停的用户积分加一分
		MemberInfo memberInfo = memberInfoService.findByMemberID(report_illegal_stop.getMemberID());
		if(memberInfo == null){
			result.setStatus("1");
			return result;
		}
		int i = Integer.parseInt(memberInfo.getPoint());
		String number = String.valueOf(i+1);
		Point point = new Point();
		point.setMemberID(report_illegal_stop.getMemberID());
		point.setNumber(number);
		point.setPoint_name("举报违停通过");
		pointService.savePoint(point);
		memberInfo.setPoint(number);
		memberInfoService.updateMemberInfo(memberInfo);
		result.setStatus("0");
		return result;
	}
	
	@RequestMapping(value = "/checkNoPass")
	@ResponseBody
	public Result checkNoPass(String id){
		logger.info("-------举报违停审核驳回------");
		Result result = new Result();
		Report_illegal_stop report_illegal_stop = report_illegal_stopService.findById(id);
		report_illegal_stop.setStatus("R");
		report_illegal_stopService.updateReport_illegal_stop(report_illegal_stop);
		result.setStatus("0");
		return result;
	}

}































package com.Dibike.controller;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Dibike.common.DateUtils;
import com.Dibike.common.ExcelFileGenerator;
import com.Dibike.entity.Alipay_payment;
import com.Dibike.entity.Bike_fault;
import com.Dibike.entity.WeChat_payment;
import com.Dibike.service.AlipayPaymentService;
import com.Dibike.service.BikeFaultService;
import com.Dibike.service.WechatService;

@Controller
@RequestMapping("/export")
public class ExportExcelController {
	private int pageSize = 15;// 每页显示条数
	@Resource 
	private BikeFaultService bikeFaultService;
	@Resource
	private AlipayPaymentService alipayPaymentService;
	@Resource
	private WechatService wechatService;
 	
	@RequestMapping(value = "/excelBike_fault")
	@ResponseBody
	public String excelBike_fault(HttpServletResponse response,String number) throws Exception{
		List<String> fieldName = new ArrayList<String>();
		fieldName.add("自行车编号");
		fieldName.add("问题");
		fieldName.add("问题描述");
		fieldName.add("状态");
		fieldName.add("城市");
		fieldName.add("地址");
		fieldName.add("上报时间");
		int pageNum = Integer.parseInt(number);
		List<Bike_fault> bike_faults = bikeFaultService.findList( pageNum, pageSize);
		List<List<String>> fieldData = new ArrayList<List<String>>();
		for(Bike_fault bike_fault:bike_faults){
			List<String> list = new ArrayList<String>();
			list.add(bike_fault.getBikeNO());
			list.add(bike_fault.getQuestion());
			list.add(bike_fault.getDescription());
			list.add(bike_fault.getStatus());
			list.add(bike_fault.getCity());
			list.add(bike_fault.getAddress());
			list.add(bike_fault.getTime());
			fieldData.add(list);
		}
		ExcelFileGenerator excelFileGenerator = new ExcelFileGenerator(fieldName, fieldData);
		String filename = "车辆故障明细报表（"+DateUtils.dateToStringWithExcel(new Date())+"）.xls";
		try {
			filename = new String(filename.getBytes("gbk"),"iso-8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-disposition", "attachment;filename="+filename);
		response.setBufferSize(1024);
		OutputStream os = response.getOutputStream();
		excelFileGenerator.expordExcel(os);
		return null;
	}
	
	@RequestMapping(value = "/excelAlipay_payment")
	@ResponseBody
	public String excelAlipay_payment(HttpServletResponse response) throws Exception{
		List<String> fieldName = new ArrayList<String>();
		fieldName.add("支付宝交易号");
		fieldName.add("商户订单号");
		fieldName.add("订单标题");
		fieldName.add("订单金额");
		fieldName.add("交易状态");
		fieldName.add("通知时间");
		List<Alipay_payment> alipayPayments = alipayPaymentService.findAllAlipay_payments();
		List<List<String>> fieldData = new ArrayList<List<String>>();
		for(Alipay_payment alipayPayment:alipayPayments){
			List<String> list = new ArrayList<String>();
			list.add(alipayPayment.getTrade_no());
			list.add(alipayPayment.getOut_trade_no());
			list.add(alipayPayment.getSubject());
			list.add(alipayPayment.getTotal_amount());
			list.add(alipayPayment.getTrade_status());
			list.add(alipayPayment.getNotify_time());
			fieldData.add(list);
		}
		ExcelFileGenerator excelFileGenerator = new ExcelFileGenerator(fieldName, fieldData);
		String filename = "支付宝支付明细报表（"+DateUtils.dateToStringWithExcel(new Date())+"）.xls";
		try {
			filename = new String(filename.getBytes("gbk"),"iso-8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-disposition", "attachment;filename="+filename);
		response.setBufferSize(1024);
		OutputStream os = response.getOutputStream();
		excelFileGenerator.expordExcel(os);
		return null;
	}
	
	@RequestMapping(value = "/excelweChatPayments")
	@ResponseBody
	public String excelweChatPayments(HttpServletResponse response) throws Exception{
		List<String> fieldName = new ArrayList<String>();
		fieldName.add("商户订单号");
		fieldName.add("微信支付订单号");
		fieldName.add("总金额");
		fieldName.add("支付完成时间");
		fieldName.add("备注");
		List<WeChat_payment> weChat_payments=wechatService.findAllWeChat_payments();
		List<List<String>> fieldData = new ArrayList<List<String>>();
		for(WeChat_payment weChat_payment:weChat_payments){
			List<String> list = new ArrayList<String>();
			list.add(weChat_payment.getOut_trade_no());
			list.add(weChat_payment.getTransaction_id());
			list.add(weChat_payment.getTotal_fee());
			list.add(weChat_payment.getTime_end());
			list.add(weChat_payment.getRemark());
			fieldData.add(list);
		}
		ExcelFileGenerator excelFileGenerator = new ExcelFileGenerator(fieldName, fieldData);
		String filename = "微信支付明细报表（"+DateUtils.dateToStringWithExcel(new Date())+"）.xls";
		try {
			filename = new String(filename.getBytes("gbk"),"iso-8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-disposition", "attachment;filename="+filename);
		response.setBufferSize(1024);
		OutputStream os = response.getOutputStream();
		excelFileGenerator.expordExcel(os);
		return null;
	}
	
}





























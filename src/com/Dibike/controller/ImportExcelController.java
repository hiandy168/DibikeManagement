package com.Dibike.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.Dibike.common.GenerateSqlFromExcel;
import com.Dibike.common.Result;
import com.Dibike.entity.Alipay_payment;
import com.Dibike.service.AlipayPaymentService;
import com.Dibike.service.BikeFaultService;
import com.Dibike.service.WechatService;


@Controller
@RequestMapping("/import")
public class ImportExcelController {
	@Resource 
	private BikeFaultService bikeFaultService;
	@Resource
	private AlipayPaymentService alipayPaymentService;
	@Resource
	private WechatService wechatService;
	
	@RequestMapping(value = "/excelAlipay_payment")
	@ResponseBody
	public Result excelAlipay_payment(@RequestParam(value="file")MultipartFile file) throws Exception{
		CommonsMultipartFile cf= (CommonsMultipartFile)file; 
        DiskFileItem fi = (DiskFileItem)cf.getFileItem(); 
        File f = fi.getStoreLocation();
		Result result = new Result();
		//读取excel的数据，将数据导入到数据库中
		GenerateSqlFromExcel fromExcel = new GenerateSqlFromExcel();
		//存放所有行的数据
		ArrayList<String[]> arrayList = fromExcel.generateUserSql(f);
		/**
		 * List<String> errorList:用来添加错误信息的集合
		 *   * 如果没有错误：errorList==null
		 *   * 如果存在错误：errorList有值
		 */
		List<String> errorList = new ArrayList<String>();
		//将ArrayList<String[]>转换成List<Alipay_payment>，同时完成校验
		List<Alipay_payment> alipayPayments = this.fromAlipay_paymentExcelListToPOList(arrayList,errorList);
		//如果存在错误：errorList有值
		if(errorList!=null && errorList.size()>0){
			result.setData(errorList);
			result.setStatus("1");
			result.setMsg("导入失败");
			return result;
		}
		//如果没有错误：errorList==null
		else{
			//执行保存
			for(Alipay_payment alipayPayment:alipayPayments){
				alipayPaymentService.saveAlipay_payment(alipayPayment);
			}
		}
		result.setStatus("0");
		result.setMsg("导入成功");
		return result;
	}

	//将ArrayList<String[]>转换成List<Alipay_payment>
	private List<Alipay_payment> fromAlipay_paymentExcelListToPOList(ArrayList<String[]> arrayList,List<String> errorList) {
		//返回的结果集
		List<Alipay_payment> alipayPayments = new ArrayList<Alipay_payment>();
		//遍历所有行的数据
		if(arrayList!=null && arrayList.size()>0){
			for(int i=0;i<arrayList.size();i++){
				//获取的是每一行的数据（模板上的字段：支付宝交易号	商户订单号	   订单标题	订单金额	交易状态	通知时间	）
				String [] arrays = arrayList.get(i);
				//将每一行的数据封装到Po对象
				Alipay_payment alipay_payment = new Alipay_payment();
				//将值从数组中读取出来，放置到PO对象中
				//支付宝交易号
				if(StringUtils.isNotBlank(arrays[0])){
					alipay_payment.setTrade_no(arrays[0]);
				}
//				else{
//					errorList.add("第"+(i+2)+"行，第"+(0+1)+"列，支付宝交易号不能为空！");
//				}
				//商户订单号
				if(StringUtils.isNotBlank(arrays[1])){
					alipay_payment.setOut_trade_no(arrays[1]);
				}
				//订单标题
				if(StringUtils.isNotBlank(arrays[2])){
					alipay_payment.setSubject(arrays[2]);
				}
				//订单金额
				if(StringUtils.isNotBlank(arrays[3])){
					alipay_payment.setTotal_amount(arrays[3]);
				}
				//交易状态
				if(StringUtils.isNotBlank(arrays[4])){
					alipay_payment.setTrade_status(arrays[4]);
				}
				//通知时间
				if(StringUtils.isNotBlank(arrays[5])){
					alipay_payment.setNotify_time(arrays[5]);
				}
				alipayPayments.add(alipay_payment);
			}
		}
		return alipayPayments;
	}
	
}



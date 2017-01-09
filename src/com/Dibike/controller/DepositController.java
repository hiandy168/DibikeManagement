package com.Dibike.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.Dibike.common.PathConfig;
import com.Dibike.common.Result;
import com.Dibike.entity.Dictionaries_table;
import com.Dibike.service.Dictionaries_tableService;

@Controller
@RequestMapping("/deposit")
public class DepositController {
	private static Logger logger = Logger.getLogger(DepositController.class);
	@Resource 
	private Dictionaries_tableService dictionaries_tableService;
	
	@RequestMapping(value = "/add")
	@ResponseBody
	public Result add(String deposit,String money){
		logger.info("-------增加押金------");
		Result result = new Result();
		Dictionaries_table dictionaries_table = new Dictionaries_table();
		dictionaries_table.setDeposit(deposit);
		dictionaries_table.setMoney(money);
		dictionaries_table.setStatus("N");
		dictionaries_table.setBank1(PathConfig.Share_path);
		dictionaries_tableService.saveDictionaries_table(dictionaries_table);
		result.setStatus("0");
		result.setMsg("增加押金成功");
		return result;
	}
	
	@RequestMapping(value = "/query")
	@ResponseBody
	public Result query(){
		logger.info("-------查询押金------");
		Result result = new Result();
		List<Dictionaries_table> lists = dictionaries_tableService.findAll();
		result.setData(lists);
		result.setStatus("0");
		result.setMsg("查询押金成功");
		return result;
	}
	
	
	@RequestMapping(value = "/updateStatus")
	@ResponseBody
	public Result updateStatus(String id,String status){
		logger.info("-------启动或关闭押金------");
		Result result = new Result();
		Dictionaries_table dictionaries_table = dictionaries_tableService.findById(id);
		if(status.equals("Y")){
			dictionaries_table.setStatus("N");
			dictionaries_tableService.updateDictionaries_table(dictionaries_table);
		}else{
			dictionaries_table.setStatus("Y");
			dictionaries_tableService.updateDictionaries_table(dictionaries_table);
		}
		result.setStatus("0");
		result.setMsg("启动或关闭押金");
		return result;
	}
	
	

}

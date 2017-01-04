package com.Dibike.controller;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.Dibike.common.Result;
import com.Dibike.entity.MemberInfo;
import com.Dibike.service.MemberInfoService;

/**
 * @author wuxiang
 * @version 创建时间：2017年1月2日 下午3:45:20
 * 
 */
@Controller
@RequestMapping("/memberInfo")
public class MemberInfoController {
	private static Logger logger = Logger.getLogger(MemberInfoController.class);
	@Resource 
	private MemberInfoService memberInfoService;
	
	@RequestMapping(value = "/findAllMemberInfos")
	@ResponseBody
	public Result findAllMemberInfos(){
		logger.info("-------查询所有的会员中心------");
		Result result=new Result();
		List<MemberInfo> list=memberInfoService.findAllMemberInfos();
		if(list==null){
			result.setStatus("1");
			result.setMsg("所有会员查询失败");
			result.setData(null);
			return result;
		}else{
			result.setStatus("0");
			result.setMsg("所有会员查询成功");
			result.setData(list);
			return result;
		}
	}
	

}

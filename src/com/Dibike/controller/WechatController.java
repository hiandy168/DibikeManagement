package com.Dibike.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.Dibike.common.Result;
import com.Dibike.entity.WeChat_payment;
import com.Dibike.service.WechatService;

/**
 * @author wuxiang
 * @version 创建时间：2017年1月2日 下午5:01:02
 * 
 */
@Controller
@RequestMapping("/wechat")
public class WechatController {
	private static Logger logger = Logger.getLogger(WechatController.class);
	@Resource
	private WechatService wechatService;
	private int pageSize = 15;// 每页显示条数

	@RequestMapping(value = "/findweChatPayments")
	@ResponseBody
	public Result findweChatPayments(String number) {
		logger.info("-------分页查询所有微信支付明细------");
		Result result = new Result();
		int pageNum = Integer.parseInt(number);
		int totalRow = wechatService.findAllWeChat_payments().size();
		int totalPage = totalRow / pageSize + (totalRow % pageSize > 0 ? 1 : 0);// 总页数
		List<WeChat_payment> list = wechatService.findList(pageNum, pageSize);
		List lists = new ArrayList();
		lists.add(totalRow + "");
		lists.add(totalPage + "");
		lists.add(list);
		result.setData(lists);
		result.setMsg("分页查询成功");
		result.setStatus("0");
		return result;
	}
}

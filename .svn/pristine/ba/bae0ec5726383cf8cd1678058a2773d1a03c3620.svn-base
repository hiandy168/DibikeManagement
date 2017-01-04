package com.Dibike.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.Dibike.common.AlipayConfig;
import com.Dibike.common.Result;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.request.AlipayUserAccountGetRequest;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayUserAccountGetResponse;


/**
 * @author wuxiang
 * @version 创建时间：2016年12月30日 下午1:46:33
 * 
 */

@Controller
@RequestMapping("/payment")
public class PaymentController {
	private static Logger logger = Logger.getLogger(PaymentController.class);
	
	@RequestMapping(value = "/FindAlipay")
	@ResponseBody
	public Result FindAlipay(String paychange) throws AlipayApiException{
		logger.info("-----------查询支付宝账户余额------------");
		if(paychange.equals("BQKJ123")){
			AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.url, AlipayConfig.app_id,
					AlipayConfig.private_key, "json", "GBK", AlipayConfig.ali_public_key);
			String Alipay_Code = "71f2866496c84cf3ba1c9bab0555UB45";
			AlipaySystemOauthTokenRequest request_oauth = new AlipaySystemOauthTokenRequest();
            request_oauth.setGrantType("authorization_code");
            request_oauth.setCode("Alipay_Code");
            AlipaySystemOauthTokenResponse response_oauth = alipayClient.execute(request_oauth);
			AlipayUserAccountGetRequest request = new AlipayUserAccountGetRequest();
			AlipayUserAccountGetResponse response = alipayClient.execute(request,response_oauth.getAccessToken());
			if(response.isSuccess()){
				System.out.println("调用成功");
				} else {
				System.out.println("调用失败");
				}
		}
		return null;
		
	}
	

}

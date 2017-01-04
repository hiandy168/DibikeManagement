package com.Dibike.service;
import java.util.List;
import com.Dibike.entity.Alipay_payment;

/**
       * @author wuxiang
       * @version 创建时间：2017年1月2日 下午5:10:10
       * 
     */
public interface AlipayPaymentService {
	/**
	 * 查询所有微信支付明细
	 * @param 
	 * @return  list
	 */
	public List<Alipay_payment>  findAllAlipay_payments();

}

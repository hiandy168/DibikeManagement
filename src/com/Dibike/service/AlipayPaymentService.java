package com.Dibike.service;
import java.util.List;
import com.Dibike.entity.Alipay_payment;
import com.Dibike.entity.Bike_fault;

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

	public void saveAlipay_payment(Alipay_payment alipayPayment);
	
	public List<Alipay_payment> findList(int pageNum, int pageSize);

}

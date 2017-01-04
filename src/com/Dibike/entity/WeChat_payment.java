package com.Dibike.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wuxiang
 * @version 创建时间：2016年12月21日 上午11:10:47
 * 
 */
@Entity
@Table(name = "wechat_payment")

public class WeChat_payment {
	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/**
	 * 用户ID
	 */
	@Column(name = "memberID")
	private String memberID;

	/**
	 * 应用ID
	 */
	@Column(name = "appid")
	private String appid;

	/**
	 * 随机字符串
	 */
	@Column(name = "nonce_str")
	private String nonce_str;

	/**
	 * 商户订单号
	 */
	@Column(name = "out_trade_no")
	private String out_trade_no;

	/**
	 * 微信支付订单号
	 */
	@Column(name = "transaction_id")
	private String transaction_id;

	/**
	 * 业务结果
	 */
	@Column(name = "result_code")
	private String result_code;

	/**
	 * 签名
	 */
	@Column(name = "sign")
	private String sign;

	/**
	 * 商户号
	 */
	@Column(name = "mch_id")
	private String mch_id;

	/**
	 * 总金额
	 */
	@Column(name = "total_fee")
	private String total_fee;

	/**
	 * 支付完成时间
	 */
	@Column(name = "time_end")
	private String time_end;

	/**
	 * 用户标识
	 */
	@Column(name = "openid")
	private String openid;

	/**
	 * 付款银行
	 */
	@Column(name = "bank_type")
	private String bank_type;

	/**
	 * 现金支付金额
	 */
	@Column(name = "cash_fee")
	private String cash_fee;

	/**
	 * 状态
	 */
	@Column(name = "status")
	private String status;

	/**
	 * 备注
	 */
	@Column(name = "remark")
	private String remark;

	/**
	 * 备用字段
	 */
	@Column(name = "bank1")
	private String bank1;

	/**
	 * 备用字段
	 */
	@Column(name = "bank2")
	private String bank2;

	/**
	 * 备用字段
	 */
	@Column(name = "bank3")
	private String bank3;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getResult_code() {
		return result_code;
	}

	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}

	public String getTime_end() {
		return time_end;
	}

	public void setTime_end(String time_end) {
		this.time_end = time_end;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getBank_type() {
		return bank_type;
	}

	public void setBank_type(String bank_type) {
		this.bank_type = bank_type;
	}

	public String getCash_fee() {
		return cash_fee;
	}

	public void setCash_fee(String cash_fee) {
		this.cash_fee = cash_fee;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getBank1() {
		return bank1;
	}

	public void setBank1(String bank1) {
		this.bank1 = bank1;
	}

	public String getBank2() {
		return bank2;
	}

	public void setBank2(String bank2) {
		this.bank2 = bank2;
	}

	public String getBank3() {
		return bank3;
	}

	public void setBank3(String bank3) {
		this.bank3 = bank3;
	}

}

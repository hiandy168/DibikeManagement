package com.Dibike.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alipay_payment")
public class Alipay_payment {
	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/**
	 * 会员ID
	 */
	@Column(name = "memberID")
	private String memberID;

	/**
	 * 支付宝分配给开发者的应用Id
	 */
	@Column(name = "app_id")
	private String app_id;

	/**
	 * 买家支付宝账号
	 */
	@Column(name = "buyer_logon_id")
	private String buyer_logon_id;

	/**
	 * 买家支付宝用户号
	 */
	@Column(name = "buyer_id")
	private String buyer_id;

	/**
	 * 通知时间
	 */
	@Column(name = "notify_time")
	private String notify_time;

	/**
	 * 支付宝交易号
	 */
	@Column(name = "trade_no")
	private String trade_no;

	/**
	 * 商户订单号
	 */
	@Column(name = "out_trade_no")
	private String out_trade_no;

	/**
	 * 商户业务号
	 */
	@Column(name = "out_biz_no")
	private String out_biz_no;

	/**
	 * 交易状态
	 */
	@Column(name = "trade_status")
	private String trade_status;

	/**
	 * 订单金额
	 */
	@Column(name = "total_amount")
	private String total_amount;

	/**
	 * 商品描述
	 */
	@Column(name = "body")
	private String body;

	/**
	 * 交易创建时间
	 */
	@Column(name = "gmt_create")
	private String gmt_create;

	/**
	 * 交易付款时间
	 */
	@Column(name = "gmt_payment")
	private String gmt_payment;

	/**
	 * 订单标题
	 */
	@Column(name = "subject")
	private String subject;

	/**
	 * 开票金额
	 */
	@Column(name = "invoice_amount")
	private String invoice_amount;

	/**
	 * 支付金额
	 */
	@Column(name = "amount")
	private String amount;

	/**
	 * 签名
	 */
	@Column(name = "sign")
	private String sign;

	/**
	 * 总退款金额
	 */
	@Column(name = "refund_fee")
	private String refund_fee;

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

	public String getApp_id() {
		return app_id;
	}

	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}

	public String getBuyer_logon_id() {
		return buyer_logon_id;
	}

	public void setBuyer_logon_id(String buyer_logon_id) {
		this.buyer_logon_id = buyer_logon_id;
	}

	public String getBuyer_id() {
		return buyer_id;
	}

	public void setBuyer_id(String buyer_id) {
		this.buyer_id = buyer_id;
	}

	public String getNotify_time() {
		return notify_time;
	}

	public void setNotify_time(String notify_time) {
		this.notify_time = notify_time;
	}

	public String getTrade_no() {
		return trade_no;
	}

	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getOut_biz_no() {
		return out_biz_no;
	}

	public void setOut_biz_no(String out_biz_no) {
		this.out_biz_no = out_biz_no;
	}

	public String getTrade_status() {
		return trade_status;
	}

	public void setTrade_status(String trade_status) {
		this.trade_status = trade_status;
	}

	public String getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(String total_amount) {
		this.total_amount = total_amount;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getGmt_create() {
		return gmt_create;
	}

	public void setGmt_create(String gmt_create) {
		this.gmt_create = gmt_create;
	}

	public String getGmt_payment() {
		return gmt_payment;
	}

	public void setGmt_payment(String gmt_payment) {
		this.gmt_payment = gmt_payment;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getInvoice_amount() {
		return invoice_amount;
	}

	public void setInvoice_amount(String invoice_amount) {
		this.invoice_amount = invoice_amount;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getRefund_fee() {
		return refund_fee;
	}

	public void setRefund_fee(String refund_fee) {
		this.refund_fee = refund_fee;
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

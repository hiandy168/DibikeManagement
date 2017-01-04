package com.Dibike.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "H5_Page")
public class H5_Page {
	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/**
	 * 用户协议
	 */
	@Column(name = "user_agreement")
	private String user_agreement;

	/**
	 * 关于
	 */
	@Column(name = "about")
	private String about;

	/**
	 * 押金说明
	 */
	@Column(name = "deposit_explain")
	private String deposit_explain;

	/**
	 * 我的实名认证无法通过
	 */
	@Column(name = "unable_pass")
	private String unable_pass;
	
	/**
	 * 充值说明
	 */
	@Column(name = "pay_explain")
	private String pay_explain;
	
	/**
	 * 找不到车
	 */
	@Column(name = "not_found")
	private String not_found;
	/**
	 * 实名认证时提示身份信息已存在	
	 */
	@Column(name = "message_exist")
	private String message_exist;
	/**
	 * 邀请码是什么
	 */
	@Column(name = "invitation_code")
	private String invitation_code;
	/**
	 * 我需要更换手机号
	 */
	@Column(name = "change_phone")
	private String change_phone;
	/**
	 * 预约能为我保留多久
	 */
	@Column(name = "order_retain")
	private String order_retain;
	/**
	 * 预约怎么找到我的车
	 */
	@Column(name = "find_car")
	private String find_car;
	/**
	 * 开不了锁
	 */
	@Column(name = "notOpen_lock")
	private String notOpen_lock;
	/**
	 * 如何关锁
	 */
	@Column(name = "what_locking")
	private String what_locking;
	/**
	 * 为什么交押金，押金与车费有什么不同
	 */
	@Column(name = "different")
	private String different;
	
	/**
	 * 为什么交押金，押金与车费有什么不同
	 */
	@Column(name = "not_account")
	private String not_account;
	/**
	 * 假如我的骑车费用超过余额，导致余额为负怎么办
	 */
	@Column(name = "balance_lose")
	private String balance_lose;
	/**
	 * 使用贝庆单车怎么收费
	 */
	@Column(name = "how_charge")
	private String how_charge;
	/**
	 * 在哪还车
	 */
	@Column(name = "car_also")
	private String car_also;
	/**
	 * 服务区域 
	 */
	@Column(name = "coverage")
	private String coverage;
	/**
	 * 我住的地方还没有公共停车带怎么办
	 */
	@Column(name = "public_parking")
	private String public_parking;
	/**
	 * 单车限行路段
	 */
	@Column(name = "limit_line")
	private String limit_line;
	/**
	 * 贝庆单车介绍
	 */
	@Column(name = "bike_introduce")
	private String bike_introduce;
	/**
	 * 为什么骑车有点重
	 */
	@Column(name = "bike_repeat")
	private String bike_repeat;
	/**
	 * 我发现了单车怎么通知贝庆
	 */
	@Column(name = "how_notice")
	private String how_notice;
	/**
	 * 贝庆是谁
	 */
	@Column(name = "is_who")
	private String is_who;
	/**
	 * 我想加入贝庆
	 */
	@Column(name = "want_join")
	private String want_join;
	/**
	 * 做贝庆单车的初衷是什么
	 */
	@Column(name = "original_intention")
	private String original_intention;
	/**
	 * 负面记录是什么，如何申述
	 */
	@Column(name = "how_appeal")
	private String how_appeal;
	/**
	 * 什么是贝庆信用分
	 */
	@Column(name = "credit_score")
	private String credit_score;
	/**
	 * 信用分太低了会怎样
	 */
	@Column(name = "point_low")
	private String point_low;
	/**
	 * 联系我们
	 */
	@Column(name = "connect_us")
	private String connect_us;
	/**
	 * 状态
	 */
	@Column(name = "status")
	private String status;
	/**
	 * 备注
	 */
	@Column(name = "bank1")
	private String bank1;
	/**
	 * 备注
	 */
	@Column(name = "bank2")
	private String bank2;
	/**
	 * 备注
	 */
	@Column(name = "bank3")
	private String bank3;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_agreement() {
		return user_agreement;
	}
	public void setUser_agreement(String user_agreement) {
		this.user_agreement = user_agreement;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getDeposit_explain() {
		return deposit_explain;
	}
	public void setDeposit_explain(String deposit_explain) {
		this.deposit_explain = deposit_explain;
	}
	public String getUnable_pass() {
		return unable_pass;
	}
	public void setUnable_pass(String unable_pass) {
		this.unable_pass = unable_pass;
	}
	public String getPay_explain() {
		return pay_explain;
	}
	public void setPay_explain(String pay_explain) {
		this.pay_explain = pay_explain;
	}
	public String getNot_found() {
		return not_found;
	}
	public void setNot_found(String not_found) {
		this.not_found = not_found;
	}
	public String getMessage_exist() {
		return message_exist;
	}
	public void setMessage_exist(String message_exist) {
		this.message_exist = message_exist;
	}
	public String getInvitation_code() {
		return invitation_code;
	}
	public void setInvitation_code(String invitation_code) {
		this.invitation_code = invitation_code;
	}
	public String getChange_phone() {
		return change_phone;
	}
	public void setChange_phone(String change_phone) {
		this.change_phone = change_phone;
	}
	public String getOrder_retain() {
		return order_retain;
	}
	public void setOrder_retain(String order_retain) {
		this.order_retain = order_retain;
	}
	public String getFind_car() {
		return find_car;
	}
	public void setFind_car(String find_car) {
		this.find_car = find_car;
	}
	public String getNotOpen_lock() {
		return notOpen_lock;
	}
	public void setNotOpen_lock(String notOpen_lock) {
		this.notOpen_lock = notOpen_lock;
	}
	public String getWhat_locking() {
		return what_locking;
	}
	public void setWhat_locking(String what_locking) {
		this.what_locking = what_locking;
	}
	public String getDifferent() {
		return different;
	}
	public void setDifferent(String different) {
		this.different = different;
	}
	public String getNot_account() {
		return not_account;
	}
	public void setNot_account(String not_account) {
		this.not_account = not_account;
	}
	public String getBalance_lose() {
		return balance_lose;
	}
	public void setBalance_lose(String balance_lose) {
		this.balance_lose = balance_lose;
	}
	public String getHow_charge() {
		return how_charge;
	}
	public void setHow_charge(String how_charge) {
		this.how_charge = how_charge;
	}
	public String getCar_also() {
		return car_also;
	}
	public void setCar_also(String car_also) {
		this.car_also = car_also;
	}
	public String getCoverage() {
		return coverage;
	}
	public void setCoverage(String coverage) {
		this.coverage = coverage;
	}
	public String getPublic_parking() {
		return public_parking;
	}
	public void setPublic_parking(String public_parking) {
		this.public_parking = public_parking;
	}
	public String getLimit_line() {
		return limit_line;
	}
	public void setLimit_line(String limit_line) {
		this.limit_line = limit_line;
	}
	public String getBike_introduce() {
		return bike_introduce;
	}
	public void setBike_introduce(String bike_introduce) {
		this.bike_introduce = bike_introduce;
	}
	public String getBike_repeat() {
		return bike_repeat;
	}
	public void setBike_repeat(String bike_repeat) {
		this.bike_repeat = bike_repeat;
	}
	public String getHow_notice() {
		return how_notice;
	}
	public void setHow_notice(String how_notice) {
		this.how_notice = how_notice;
	}
	public String getIs_who() {
		return is_who;
	}
	public void setIs_who(String is_who) {
		this.is_who = is_who;
	}
	public String getWant_join() {
		return want_join;
	}
	public void setWant_join(String want_join) {
		this.want_join = want_join;
	}
	public String getOriginal_intention() {
		return original_intention;
	}
	public void setOriginal_intention(String original_intention) {
		this.original_intention = original_intention;
	}
	public String getHow_appeal() {
		return how_appeal;
	}
	public void setHow_appeal(String how_appeal) {
		this.how_appeal = how_appeal;
	}
	public String getCredit_score() {
		return credit_score;
	}
	public void setCredit_score(String credit_score) {
		this.credit_score = credit_score;
	}
	public String getPoint_low() {
		return point_low;
	}
	public void setPoint_low(String point_low) {
		this.point_low = point_low;
	}
	public String getConnect_us() {
		return connect_us;
	}
	public void setConnect_us(String connect_us) {
		this.connect_us = connect_us;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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

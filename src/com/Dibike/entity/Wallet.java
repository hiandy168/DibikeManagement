package com.Dibike.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wjf
 * @version 创建时间：2016-10-18 下午3:21:58
 */
@Entity
@Table(name = "wallet")
public class Wallet {
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
	 * 金额
	 */
	@Column(name = "money")
	private String money;

	/**
	 * 方式
	 */
	@Column(name = "mode")
	private String mode;

	/**
	 * 事件
	 */
	@Column(name = "event")
	private String event;

	/**
	 * 产生事件日期
	 */
	@Column(name = "createDate")
	private String createDate;

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

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
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

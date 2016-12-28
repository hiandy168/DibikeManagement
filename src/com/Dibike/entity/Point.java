package com.Dibike.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "point")
public class Point {
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
	 * 时间
	 */
	@Column(name = "time")
	private String time;


	/**
	 * 积分数
	 */
	@Column(name = "number")
	private String number;

	/**
	 * 产生事件名
	 */
	@Column(name = "point_name")
	private String point_name;
	
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPoint_name() {
		return point_name;
	}

	public void setPoint_name(String point_name) {
		this.point_name = point_name;
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

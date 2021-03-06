package com.Dibike.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wjf
 * @version 创建时间：2016-10-18 上午9:57:06
 */
@Entity
@Table(name = "memberinfo")
public class MemberInfo {
	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/**
	 * 性别
	 */
	@Column(name = "sex")
	private String sex;

	/**
	 * 生日
	 */
	@Column(name = "birthday")
	private String birthday;

	/**
	 * 昵称
	 */
	@Column(name = "nickName")
	private String nickName;

	/**
	 * 积分
	 */
	@Column(name = "point")
	private String point;

	/**
	 * 金额
	 */
	@Column(name = "money")
	private String money;

	/**
	 * 押金
	 */
	@Column(name = "deposit")
	private String deposit;

	/**
	 * 状态
	 */
	@Column(name = "status")
	private String status;

	/**
	 * 用户ID
	 */
	@Column(name = "memberID")
	private String memberID;

	/**
	 * 会员等级
	 */
	@Column(name = "grade")
	private String grade;

	/**
	 * 专属邀请码
	 */
	@Column(name = "InvitationCode")
	private String InvitationCode;
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
	/**
	 * 备用字段
	 */
	@Column(name = "bank4")
	private String bank4;
	
	/**
	 * 备用字段
	 */
	@Column(name = "bank5")
	private String bank5;
	/**
	 * 备用字段
	 */
	@Column(name = "bank6")
	private String bank6;
	
	/**
	 * 备用字段
	 */
	@Column(name = "bank7")
	private String bank7;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getDeposit() {
		return deposit;
	}

	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getInvitationCode() {
		return InvitationCode;
	}

	public void setInvitationCode(String invitationCode) {
		InvitationCode = invitationCode;
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
	
	public String getBank4() {
		return bank4;
	}

	public void setBank4(String bank4) {
		this.bank4 = bank4;
	}

	public String getBank5() {
		return bank5;
	}
	public void setBank5(String bank5) {
		this.bank5 = bank5;
	}
	public String getBank6() {
		return bank6;
	}

	public void setBank6(String bank6) {
		this.bank6 = bank6;
	}

	public String getBank7() {
		return bank7;
	}

	public void setBank7(String bank7) {
		this.bank7 = bank7;
	}
	
	

}

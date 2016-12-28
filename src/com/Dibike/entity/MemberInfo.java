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
@Table(name = "memberInfo")
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
	
}

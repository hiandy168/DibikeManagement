package com.Dibike.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wjf
 * @version 创建时间：2016-10-18 下午5:36:22
 */
@Entity
@Table(name = "journey_details")
public class Journey_details {
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
	 * 行程ID
	 */
	@Column(name = "journeyID")
	private String journeyID;

	/**
	 * 自行车编号
	 */
	@Column(name = "bikeNO")
	private String bikeNO;

	/**
	 * 骑车时间
	 */
	@Column(name = "ridingTime")
	private String ridingTime;
	
	/**
	 * 节约碳排量
	 */
	@Column(name = "carbonEmissions")
	private String carbonEmissions;
	
	/**
	 * 卡路里
	 */
	@Column(name = "calorie")
	private String calorie;
	
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

	public String getJourneyID() {
		return journeyID;
	}

	public void setJourneyID(String journeyID) {
		this.journeyID = journeyID;
	}

	public String getBikeNO() {
		return bikeNO;
	}

	public void setBikeNO(String bikeNO) {
		this.bikeNO = bikeNO;
	}

	public String getRidingTime() {
		return ridingTime;
	}

	public void setRidingTime(String ridingTime) {
		this.ridingTime = ridingTime;
	}

	public String getCarbonEmissions() {
		return carbonEmissions;
	}

	public void setCarbonEmissions(String carbonEmissions) {
		this.carbonEmissions = carbonEmissions;
	}

	public String getCalorie() {
		return calorie;
	}

	public void setCalorie(String calorie) {
		this.calorie = calorie;
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

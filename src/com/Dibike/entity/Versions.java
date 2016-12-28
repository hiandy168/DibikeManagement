package com.Dibike.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * @author wjf
 * @version 创建时间：2016-10-18 下午5:43:54
 */
@Entity
@Table(name = "versions")
public class Versions {
	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/**
	 * 安卓版本
	 */
	@Column(name = "android_version")
	private String android_version;

	/**
	 * 苹果版本
	 */
	@Column(name = "ios_version")
	private String ios_version;



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

	public String getAndroid_version() {
		return android_version;
	}

	public void setAndroid_version(String android_version) {
		this.android_version = android_version;
	}

	public String getIos_version() {
		return ios_version;
	}

	public void setIos_version(String ios_version) {
		this.ios_version = ios_version;
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

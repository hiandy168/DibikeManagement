package com.Dibike.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wjf
 * @version 创建时间：2016-10-18 下午2:14:31
 */
@Entity
@Table(name = "action")
public class Action {
	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/**
	 * 权限ID
	 */
	@Column(name = "actionID")
	private String actionID;
	
	/**
	 * 权限父ID
	 */
	@Column(name = "pid")
	private String pid;

	/**
	 * 权限名字
	 */
	@Column(name = "name")
	private String name;
	


	/**
	 * 地址
	 */
	@Column(name = "url")
	private String url;
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
	
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getActionID() {
		return actionID;
	}

	public void setActionID(String actionID) {
		this.actionID = actionID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

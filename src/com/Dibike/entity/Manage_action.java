package com.Dibike.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wjf
 * @version 创建时间：2016-10-18 下午2:21:32
 */
@Entity
@Table(name = "manage_action")
public class Manage_action {
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
	 * 用户ID
	 */
	@Column(name = "manageID")
	private String manageID;

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

	public String getManageID() {
		return manageID;
	}

	public void setManageID(String manageID) {
		this.manageID = manageID;
	}

	
	
}

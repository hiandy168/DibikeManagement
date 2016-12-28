package com.Dibike.service;

import java.util.List;

import com.Dibike.entity.ActionCloumn;

public interface ActionCloumnService {
	/**
	 * 根据用户id manageID查询权限栏信息
	 * @param manageID
	 * @return
	 */
	public List<ActionCloumn> findByManageID(String manageID);

}

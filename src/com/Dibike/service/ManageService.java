package com.Dibike.service;

import java.util.List;
import java.util.Map;

import com.Dibike.entity.Manage;

public interface ManageService {
	/**
	 * 根据管理员登录账号name查询管理员信息
	 * @param name
	 * @return
	 */
	public Manage findByName(String name);
	/**
	 * 修改个人信息
	 * @param manage
	 * @return
	 */
	public void updateManage(Manage manage);
	/**
	 * 增加管理员
	 * @param manage
	 * @return
	 */
	public void saveManage(Manage manage);
	public List<Manage> findByRoleID(String roleID);
	

}

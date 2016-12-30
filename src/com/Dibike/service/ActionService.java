package com.Dibike.service;

import java.util.List;

import com.Dibike.entity.Action;

public interface ActionService {
	/**
	 * 根据用户id manageID查询权限信息
	 * @param manageID
	 * @return
	 */
	public List<Action> findByActionID(String actionID);

	public List<String> findpidsByManageID(String manageID);
	public List<String> findmidNameByManageID(String manageID,String pid);
	List<Action> findAllAction();

	List<Action> findByRoleID(String roleID);

	List<Action> findActionSon(String actionID);

	public List<String> findAllpids();

	public List<String> findActionSonBypid(String pid);

	public List<String> findpidsByRoleID(String roleID);

	public List<String> findmidNameByRoleID(String pid,String roleID);

	public void saveAction(Action action);

	public List<String> findNameAndActionIDByPid(String pid);

}

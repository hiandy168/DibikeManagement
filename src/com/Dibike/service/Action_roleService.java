package com.Dibike.service;

import java.util.List;

import com.Dibike.entity.Action_role;

public interface Action_roleService {

	List<Action_role> findByRoleID(String roleID);

	void deleteAction_role(Action_role action_role);

	void saveAction_role(Action_role action_role);

}

package com.Dibike.service;

import java.util.List;

import com.Dibike.entity.Action;

public interface PrivilegeService {

	List<Action> findAllAction();

	List<Action> findByRoleID(String roleID);

}

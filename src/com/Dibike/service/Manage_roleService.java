package com.Dibike.service;

import java.util.List;

import com.Dibike.entity.Manage_role;



public interface Manage_roleService {
	
	public List<Manage_role> findByRoleID(String roleID);

	public void saveManage_role(Manage_role manage_role);

}

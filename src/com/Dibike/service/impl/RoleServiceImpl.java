package com.Dibike.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.Dibike.common.BaseDao;
import com.Dibike.entity.Role;
import com.Dibike.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService{

	@Resource
	private BaseDao<Role> baseDao;
	@Override
	public List<Role> findAllRole() {
		List<Role> list = baseDao.find("from Role");
		if (list.size() == 0) {
			return null;
		} else {
			return list;
		}
	}
	@Override
	public List<Role> findByRoleID(String roleID) {
		List<Role> list = baseDao.find("from Role where roleID='"+roleID+"'");
		if (list.size() == 0) {
			return null;
		} else {
			return list;
		}
	}
	@Override
	public Role findByName(String name) {
		List<Role> list = baseDao.find("from Role where name='"+name+"'");
		if (list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
	}
	@Override
	public void saveRole(Role role) {
		baseDao.save(role);
	}

}

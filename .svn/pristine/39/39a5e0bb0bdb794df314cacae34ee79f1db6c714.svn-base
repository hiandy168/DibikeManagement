package com.Dibike.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.Dibike.common.BaseDao;
import com.Dibike.entity.Manage_role;
import com.Dibike.service.Manage_roleService;

@Service("manage_roleService")
public class Manage_roleServiceImpl implements Manage_roleService{
	@Resource
	private BaseDao<Manage_role> baseDao;
	
	@Override
	public List<Manage_role> findByRoleID(String roleID) {
		List<Manage_role> lists = baseDao.find("from Manage_role where roleID='"+roleID+"'");
		if(lists.size()==0){
			return null;
		}else{
			return lists;
		}
	}

}

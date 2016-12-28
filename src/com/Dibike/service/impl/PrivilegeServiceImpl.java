package com.Dibike.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.Dibike.common.BaseDao;
import com.Dibike.entity.Action;
import com.Dibike.entity.Manage;
import com.Dibike.service.PrivilegeService;

@Service("privilegeService")
public class PrivilegeServiceImpl implements PrivilegeService{

	@Resource
	private BaseDao<Action> baseDao;
	@Override
	public List<Action> findAllAction() {
		List<Action> list = baseDao.find("from Action");
		if (list.size() == 0) {
			return null;
		} else {
			return list;
		}
	}
	@Override
	public List<Action> findByRoleID(String roleID) {
		List<Action> lists = 
				baseDao.find("select a from Action a,Action_role ar  where a.actionID=ar.actionID and ar.roleID='"+roleID+"'");
		if(lists.size() == 0){
			return null;
		}else{
			return lists;
		}
	}

}

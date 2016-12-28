package com.Dibike.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.Dibike.common.BaseDao;
import com.Dibike.entity.Action_role;
import com.Dibike.service.Action_roleService;

@Service("action_roleService")
public class Action_roleServiceImpl implements Action_roleService{
	@Resource
	private BaseDao<Action_role> baseDao;

	@Override
	public List<Action_role> findByRoleID(String roleID) {
		List<Action_role> list = baseDao.find("from Action_role where roleID='"+roleID+"'");
		if (list.size() == 0) {
			return null;
		} else {
			return list;
		}
		
	}

	@Override
	public void deleteAction_role(Action_role action_role) {
		// TODO Auto-generated method stub
		baseDao.delete(action_role);
	}

	@Override
	public void saveAction_role(Action_role action_role) {
		// TODO Auto-generated method stub
		baseDao.save(action_role);
	}

}

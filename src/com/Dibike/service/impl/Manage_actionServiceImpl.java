package com.Dibike.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.Dibike.common.BaseDao;
import com.Dibike.entity.Manage_action;
import com.Dibike.service.Manage_actionService;

@Service("manage_actionService")
public class Manage_actionServiceImpl implements Manage_actionService{

	@Resource
	private BaseDao<Manage_action> baseDao;
	@Override
	public List<Manage_action> findByManageID(String manageID) {
		List<Manage_action> lists = baseDao.find("from Manage_action where manageID='"+manageID+"'");
		if(lists.size()==0){
			return null;
		}else{
			return lists;
		}
	}
	@Override
	public void deleteManage_action(Manage_action manage_action) {
		baseDao.delete(manage_action);
		
	}

}

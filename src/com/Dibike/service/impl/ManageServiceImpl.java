package com.Dibike.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.Dibike.common.BaseDao;
import com.Dibike.entity.Manage;
import com.Dibike.service.ManageService;

@Service("manageService")
public class ManageServiceImpl implements ManageService{

	@Resource
	private BaseDao<Manage> baseDao;
	
	public Manage findByName(String name) {
		List<Manage> lists = baseDao.find("from Manage where name='"+name+"'");
		if(lists.size() == 0){
			return null;
		}else{
			return lists.get(0);
		}
	}


	@Override
	public void updateManage(Manage manage) {
		baseDao.update(manage);
	}

	@Override
	public void saveManage(Manage manage) {
		baseDao.save(manage);
		
	}


	@Override
	public List<Manage> findByRoleID(String roleID) {
		List<Manage> lists = 
		baseDao.find("select m from Manage m,Manage_role mr where m.manageID=mr.manageID and mr.roleID='"+roleID+"'");
		if(lists.size() == 0){
			return null;
		}else{
			return lists;
		}
	}
	

	

}

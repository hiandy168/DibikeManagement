package com.Dibike.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.Dibike.common.BaseDao;
import com.Dibike.entity.ActionCloumn;
import com.Dibike.service.ActionCloumnService;

@Service("actionCloumnService")
public class ActionCloumnServiceImpl implements ActionCloumnService{
	@Resource
	private BaseDao<ActionCloumn> baseDao;
	
	public List<ActionCloumn> findByManageID(String manageID) {
		List<ActionCloumn> lists = baseDao.find("SELECT DISTINCT(ac) "+
				"from ActionCloumn ac,Action a,Action_role ar,Role r,Manage_role mr,Manage m "+
				"WHERE mr.manageID='"+manageID+"'and "+ 
							"r.roleID=mr.roleID and "+ 
							"ar.roleID=r.roleID and "+ 
							"a.actionID=ar.actionID and "+ 
							"ac.actionCloumnID=a.actionCloumnID");
		if(lists.size() == 0){
			return null;
		}else{
			return lists;
		}
	}

}

package com.Dibike.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.Dibike.common.BaseDao;
import com.Dibike.entity.MemberInfo;
import com.Dibike.service.MemberInfoService;

/**
 * @author wjf
 * @version 创建时间：2016-10-19 下午3:28:43
 */
@Service("memberInfoService")
public class MemberInfoServiceImpl implements MemberInfoService{
@Resource
private BaseDao<MemberInfo> baseDao;
	@Override
	public MemberInfo findByMemberID(String memberID) {
		// TODO Auto-generated method stub
		List<MemberInfo> lists=baseDao.find("from MemberInfo where memberID='"+memberID+"'");
		if(lists.size()==0){
			return null;
		}else{
			return lists.get(0);
		}
		
	}

	@Override
	public void saveMemberInfo(MemberInfo memberInfo) {
		// TODO Auto-generated method stub
		baseDao.save(memberInfo);
	}

	@Override
	public void updateMemberInfo(MemberInfo memberInfo) {
		// TODO Auto-generated method stub
		baseDao.update(memberInfo);
	}


}

package com.Dibike.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.Dibike.common.BaseDao;
import com.Dibike.entity.Journey;
import com.Dibike.service.JourneyService;

/**
 * @author wjf
 * @version 创建时间：2016-10-19 下午4:10:17
 */
@Service("journeyService")
public class JourneyServiceImpl implements JourneyService{
	@Resource
	private BaseDao<Journey> baseDao;
	@Override
	public Journey findByMemberID(String memberID) {
		// TODO Auto-generated method stub
		List<Journey> lists=baseDao.find("from Journey where memberID='"+memberID+"'");
		if(lists.size()==0){
			return null;
		}else{
			return lists.get(0);
		}
	}

	@Override
	public void saveJourney(Journey journey) {
		// TODO Auto-generated method stub
		baseDao.save(journey);
	}

	@Override
	public void updateJourney(Journey journey) {
		// TODO Auto-generated method stub
		baseDao.update(journey);
	}

}

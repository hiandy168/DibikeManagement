package com.Dibike.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.Dibike.common.BaseDao;
import com.Dibike.entity.Journey_details;
import com.Dibike.service.Journey_detailsService;

@Service("Journey_detailsService")
public class Journey_detailsServiceImpl implements Journey_detailsService {
	@Resource
	private BaseDao<Journey_details> baseDao;

	@Override
	public List<Journey_details> findByMemberID(String memberID) {
		List<Journey_details> list = baseDao.find("from Journey_details where memberID='" + memberID + "'");
		if (list.size() == 0) {
			return null;
		} else {
			return list;
		}
	}

	@Override
	public void saveJourney_details(Journey_details journey_details) {
		baseDao.save(journey_details);
	}

	@Override
	public Journey_details findMB(String memberID, String bikeNO) {
		List<Journey_details> list = baseDao.find(
				"from Journey_details where memberID='" + memberID + "' and bikeNO='" + bikeNO + "' and bank1='N'");
		if (list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
	}

	@Override
	public void deleteJourney_details(Journey_details journey_details) {
		baseDao.delete(journey_details);
	}

	@Override
	public void updateJourney_details(Journey_details journey_details) {
		baseDao.update(journey_details);
	}
}

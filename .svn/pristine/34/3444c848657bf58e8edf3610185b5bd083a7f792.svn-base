package com.Dibike.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.Dibike.common.BaseDao;
import com.Dibike.entity.Certification;
import com.Dibike.service.CertificationService;

@Service("certificationService")
public class CertificationServiceImpl implements CertificationService{
	@Resource
	private BaseDao<Certification> baseDao;

	@Override
	public List<Certification> findByStatus(String status) {
		List<Certification> list = baseDao.find("from Certification where status='"+status+"'");
		if (list.size() == 0) {
			return null;
		} else {
			return list;
		}
	}

	@Override
	public void updateCertification(Certification certification) {
		baseDao.update(certification);
		
	}

	@Override
	public Certification findByMemberID(String memberID) {
		List<Certification> list = baseDao.find("from Certification where memberID='"+memberID+"'");
		if (list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
	}

}

package com.Dibike.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.Dibike.common.BaseDao;
import com.Dibike.entity.Sms;
import com.Dibike.service.SmsService;

@Service("smsService")
public class SmsServiceImpl implements SmsService {
	@Resource
	private BaseDao<Sms> baseDao;

	@Override
	public void saveSms(Sms sms) {
		baseDao.save(sms);
	}

	@Override
	public Sms findByMoblie(String phone) {
		List<Sms> sms = baseDao.find("from Sms where moblie ='" + phone + "'");
		if (sms.size() == 0) {
			return null;
		}
		return sms.get(0);
	}

	@Override
	public void deleteSmsByMoblie(Sms sms) {
		baseDao.delete(sms);
	}
}

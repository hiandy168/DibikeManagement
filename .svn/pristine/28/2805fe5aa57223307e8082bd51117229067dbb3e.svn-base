package com.Dibike.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.Dibike.common.BaseDao;
import com.Dibike.entity.Bike_fault;
import com.Dibike.entity.Dictionaries_table;
import com.Dibike.service.Dictionaries_tableService;

@Service("dictionaries_tableService")
public class Dictionaries_tableServiceImpl implements Dictionaries_tableService{
	@Resource
	private BaseDao<Dictionaries_table> baseDao;

	@Override
	public void saveDictionaries_table(Dictionaries_table dictionaries_table) {
		baseDao.save(dictionaries_table);
		
	}

	@Override
	public List<Dictionaries_table> findAll() {
		List<Dictionaries_table> list = baseDao.find("from Dictionaries_table ");
		if (list.size() == 0) {
			return null;
		} else {
			return list;
		}
	}

	@Override
	public Dictionaries_table findById(String id) {
		List<Dictionaries_table> list = baseDao.find("from Dictionaries_table where id='"+id+"'");
		if (list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
	}

	@Override
	public void updateDictionaries_table(Dictionaries_table dictionaries_table) {
		baseDao.update(dictionaries_table);
	}
	
	@Override
	public Dictionaries_table findAlls() {
		List<Dictionaries_table> list = baseDao.find("from Dictionaries_table where status='Y'");
		if (list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
	}

}

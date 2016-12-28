package com.Dibike.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.Dibike.common.BaseDao;
import com.Dibike.entity.Wallet;
import com.Dibike.service.WalletService;

/**
 * @author wjf
 * @version 创建时间：2016-10-19 下午3:50:35
 */
@Service("walletService")
public class WalletServiceImpl implements WalletService{
	@Resource
	private BaseDao<Wallet> baseDao;
@Override
	public Wallet findByMemberID(String memberID) {
		// TODO Auto-generated method stub
	List<Wallet> lists=baseDao.find("from Wallet where memberID='"+memberID+"'");
	if(lists.size()==0){
		return null;
	}else{
		return lists.get(0);
	}
	}

	@Override
	public void saveWallet(Wallet wallet) {
		// TODO Auto-generated method stub
		baseDao.save(wallet);
	}

	@Override
	public void updateWallet(Wallet wallet) {
		// TODO Auto-generated method stub
		baseDao.update(wallet);
	}

}

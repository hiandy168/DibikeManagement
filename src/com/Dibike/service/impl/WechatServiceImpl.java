package com.Dibike.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.Dibike.common.BaseDao;
import com.Dibike.entity.WeChat_payment;
import com.Dibike.service.WechatService;

/**
 * @author wuxiang
 * @version 创建时间：2017年1月2日 下午4:34:08
 * 
 */
@Service("wechatService")
public class WechatServiceImpl implements WechatService{

	@Resource
	private BaseDao<WeChat_payment> baseDao;
	
	public List<WeChat_payment> findAllWeChat_payments() {
		List<WeChat_payment> list=baseDao.find("from WeChat_payment");
		if(list.size()==0){
			return null;
		}else{
			return list;
		}
	}
}
		
	


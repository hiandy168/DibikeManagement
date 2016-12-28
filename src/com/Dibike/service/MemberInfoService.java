package com.Dibike.service;

import com.Dibike.entity.MemberInfo;

/**
 * @author wjf
 * @version 创建时间：2016-10-19 下午3:28:23
 */
public interface MemberInfoService {
	/**
	 * 根据会员ID查询会员信息
	 * @param memberID
	 * @return
	 */
	public MemberInfo findByMemberID(String memberID);
	/**
	 * 保存会员信息
	 * @param memberInfo
	 */
	public void saveMemberInfo(MemberInfo memberInfo);
	/**
	 * 更新会员信息
	 * @param memberInfo
	 */
	public void updateMemberInfo(MemberInfo memberInfo);
}

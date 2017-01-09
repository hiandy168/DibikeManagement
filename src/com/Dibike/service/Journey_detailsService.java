package com.Dibike.service;

import java.util.List;

import com.Dibike.entity.Journey_details;

public interface Journey_detailsService {
	/**
	 * 根据memberID查询行程详情
	 * 
	 * @return
	 */
	public List<Journey_details> findByMemberID(String memberID);

	/**
	 * 添加行程详情
	 * 
	 * @param journey_details
	 */
	public void saveJourney_details(Journey_details journey_details);

	/**
	 * 根据memberID和bikeNO查询行程详情
	 * 
	 * @return
	 */
	public Journey_details findMB(String memberID, String bikeNO);

	/**
	 * 删除
	 * 
	 * @param journey_details
	 */
	public void deleteJourney_details(Journey_details journey_details);

	/**
	 * 修改
	 * 
	 * @param journey_details
	 */
	public void updateJourney_details(Journey_details journey_details);
}

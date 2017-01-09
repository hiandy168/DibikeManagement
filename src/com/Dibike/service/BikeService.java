package com.Dibike.service;

import java.util.List;

import com.Dibike.entity.Bike;

public interface BikeService {
	/**
	 * 根据自行车编号bikeNO查询自行车信息
	 * 
	 * @param bikeNO
	 * @return
	 */
	public Bike findByBikeNO(String bikeNO);

	/**
	 * 修改自行车信息
	 * 
	 * @param bike
	 */
	public void upBike(Bike bike);
	
	/**
	 * 根据设备编号deviceID查询自行车信息
	 * 
	 * @param deviceid
	 * @return
	 */
	public Bike findDeviceid(String deviceID);

	public void saveBike(Bike bike);

	public List<Bike> findAll();
	
	/**
	 * 根据memberID查询自行车信息
	 * 
	 * @param memberID
	 * @return
	 */
	public Bike findByMemberID(String memberID);


}

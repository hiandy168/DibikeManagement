package com.Dibike.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wjf
 * @version 创建时间：2016-10-18 下午5:43:54
 */
@Entity
@Table(name = "bike")
public class Bike {
	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/**
	 * 会员ID
	 */
	@Column(name = "memberID")
	private String memberID;

	/**
	 * 自行车编号
	 */
	@Column(name = "bikeNO")
	private String bikeNO;

	/**
	 * 自行车所在地址
	 */
	@Column(name = "address")
	private String address;

	/**
	 * 经度
	 */
	@Column(name = "lng")
	private String lng;

	/**
	 * 纬度
	 */
	@Column(name = "lat")
	private String lat;

	/**
	 * 位置信息的时间
	 */
	@Column(name = "time")
	private String time;

	/**
	 * 锁的定位方式
	 */
	@Column(name = "bike_method")
	private String bike_method;

	/**
	 * 手机经度
	 */
	@Column(name = "phone_lng")
	private String phone_lng;

	/**
	 * 手机纬度
	 */
	@Column(name = "phone_lat")
	private String phone_lat;

	/**
	 * 手机地址
	 */
	@Column(name = "phone_address")
	private String phone_address;

	/**
	 * 状态
	 */
	@Column(name = "status")
	private String status;

	/**
	 * 城市
	 */
	@Column(name = "city")
	private String city;

	/**
	 * 备注
	 */
	@Column(name = "remark")
	private String remark;

	/**
	 * 收费编号
	 */
	@Column(name = "code")
	private String code;

	/**
	 * 单价
	 */
	@Column(name = "price")
	private String price;

	/**
	 * 设备编号
	 */
	@Column(name = "deviceID")
	private String deviceID;

	/**
	 * 电池电量
	 */
	@Column(name = "battery")
	private String battery;

	/**
	 * 备用字段
	 */
	@Column(name = "bank1")
	private String bank1;

	/**
	 * 备用字段
	 */
	@Column(name = "bank2")
	private String bank2;

	/**
	 * 备用字段
	 */
	@Column(name = "bank3")
	private String bank3;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBikeNO() {
		return bikeNO;
	}

	public void setBikeNO(String bikeNO) {
		this.bikeNO = bikeNO;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getBank1() {
		return bank1;
	}

	public void setBank1(String bank1) {
		this.bank1 = bank1;
	}

	public String getBank2() {
		return bank2;
	}

	public void setBank2(String bank2) {
		this.bank2 = bank2;
	}

	public String getBank3() {
		return bank3;
	}

	public void setBank3(String bank3) {
		this.bank3 = bank3;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	/**
	 * @return the lng
	 */
	public String getLng() {
		return lng;
	}

	/**
	 * @param lng
	 *            the lng to set
	 */
	public void setLng(String lng) {
		this.lng = lng;
	}

	/**
	 * @return the lat
	 */
	public String getLat() {
		return lat;
	}

	/**
	 * @param lat
	 *            the lat to set
	 */
	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getBike_method() {
		return bike_method;
	}

	public void setBike_method(String bike_method) {
		this.bike_method = bike_method;
	}

	public String getPhone_lng() {
		return phone_lng;
	}

	public void setPhone_lng(String phone_lng) {
		this.phone_lng = phone_lng;
	}

	public String getPhone_lat() {
		return phone_lat;
	}

	public void setPhone_lat(String phone_lat) {
		this.phone_lat = phone_lat;
	}

	public String getPhone_address() {
		return phone_address;
	}

	public void setPhone_address(String phone_address) {
		this.phone_address = phone_address;
	}

	public String getDeviceID() {
		return deviceID;
	}

	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}

	public String getBattery() {
		return battery;
	}

	public void setBattery(String battery) {
		this.battery = battery;
	}

}

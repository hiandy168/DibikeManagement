/**
 * 
 */
package com.Dibike.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wuxiang
 * @version 创建时间：2016年11月14日 上午11:09:06
 * 
 */
@Entity
@Table(name = "startImg")
public class StartImg {
	/**
	 * Id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	/**
	 * 图片ID
	 */
	@Column(name = "imgID")
	private String imgID;
	
	/**
	 * 地址
	 */
	@Column(name = "address")
	private String address;
	
	/**
	 * 作用位置
	 */
	@Column(name = "active_site")
	private String  active_site;
	
	
	/**
	 * 备注
	 */
	@Column(name = "remark")
	private String remark;
	
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
	
	/**
	 * 第一张地址
	 */
	@Column(name = "OneImg")
	private String OneImg;
	

	/**
	 * 第二张地址
	 */
	@Column(name = "TwoImg")
	private String TwoImg;
	
	/**
	 * 第三张地址
	 */
	@Column(name = "ThreeImg")
	private String ThreeImg;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImgID() {
		return imgID;
	}

	public void setImgID(String imgID) {
		this.imgID = imgID;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getActive_site() {
		return active_site;
	}

	public void setActive_site(String active_site) {
		this.active_site = active_site;
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

	/**
	 * @return the oneImg
	 */
	public String getOneImg() {
		return OneImg;
	}

	/**
	 * @param oneImg the oneImg to set
	 */
	public void setOneImg(String oneImg) {
		OneImg = oneImg;
	}

	/**
	 * @return the twoImg
	 */
	public String getTwoImg() {
		return TwoImg;
	}

	/**
	 * @param twoImg the twoImg to set
	 */
	public void setTwoImg(String twoImg) {
		TwoImg = twoImg;
	}

	/**
	 * @return the threeImg
	 */
	public String getThreeImg() {
		return ThreeImg;
	}

	/**
	 * @param threeImg the threeImg to set
	 */
	public void setThreeImg(String threeImg) {
		ThreeImg = threeImg;
	}
	
	
	
	

}

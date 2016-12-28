package com.Dibike.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wjf
 * @version 创建时间：2016-10-18 上午9:53:37
 */
@Entity
@Table(name = "sms")
public class Sms {
		/**
		 * ID
		 */
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;

		/**
		 * 手机号
		 */
		@Column(name = "moblie")
		private String moblie;

		/**
		 * 验证码产生时间
		 */
		@Column(name = "createAt")
		private String createAt;

		/**
		 * 状态
		 */
		@Column(name = "status")
		private String status;

		/**
		 * 最后失效时间
		 */
		@Column(name = "endAt")
		private String endAt;

		/**
		 * 验证码
		 */
		@Column(name = "code")
		private String code;


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

		public String getMoblie() {
			return moblie;
		}

		public void setMoblie(String moblie) {
			this.moblie = moblie;
		}

		public String getCreateAt() {
			return createAt;
		}

		public void setCreateAt(String createAt) {
			this.createAt = createAt;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getEndAt() {
			return endAt;
		}

		public void setEndAt(String endAt) {
			this.endAt = endAt;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
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
		
		

		

}

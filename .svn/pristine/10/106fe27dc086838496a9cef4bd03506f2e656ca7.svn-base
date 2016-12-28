package com.Dibike.common;

import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.Map.Entry;



/**
 * @author wuxiang
 * @version 创建时间：2016年12月20日 下午1:59:02
 * 
 */
public class Platform_Response {
	private String userid;
	private String cmd;
	private String deviceid;
	private int serialnum;
	private String UserKey;
	private String sign;
	private int version;

	public String getOrder() throws UnsupportedEncodingException {
		LinkedHashMap<String, Object> treeMap = new LinkedHashMap<String, Object>();
		treeMap.put("version", this.version);
		treeMap.put("userid", this.userid);
		treeMap.put("cmd", this.cmd);
		treeMap.put("deviceid", this.deviceid);
		treeMap.put("serialnum", this.serialnum);
		StringBuilder sb = new StringBuilder();
		for (String key : treeMap.keySet()) {
			sb.append(key).append(":").append(treeMap.get(key)).append(",");
		}
		LockMD5 md5 = new LockMD5();
		sign = md5.getMD5ofStr((this.userid + this.cmd + this.deviceid + this.serialnum + "beiqing"));
		treeMap.put("sign", sign.toLowerCase());
		StringBuilder str = new StringBuilder();
		str.append("{\n");
		int b = 0;
		int a = treeMap.entrySet().size();
		for (Entry<String, Object> entry : treeMap.entrySet()) {
			b++;
			if (b == a) {
				str.append("\"" + entry.getKey() + "\"" + ":" + "\"" + entry.getValue() + "\"");
			} else {
				str.append("\"" + entry.getKey() + "\"" + ":" + "\"" + entry.getValue() + "\"" + ",");
			}
		}
		str.append("}");
		System.out.println(str.toString());
		return str.toString();
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public String getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}

	public String getUserKey() {
		return UserKey;
	}

	public void setUserKey(String userKey) {
		UserKey = userKey;
	}

	public String getsign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public int getSerialnum() {
		return serialnum;
	}

	public void setSerialnum(int serialnum) {
		this.serialnum = serialnum;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
}

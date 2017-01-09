package com.Dibike.Test;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.Dibike.common.HTTP;
import com.Dibike.common.Platform_Response;

public class DD {
	public static void main(String[] args) throws ParseException, UnsupportedEncodingException {
		//String[] str = new String[2];
		//str = Coordinate.transform(22.619318, 113.971981);
		//String KM = MapDistance.getDistance("113.971981", "22.619318", "113.97691281281674", "22.61637771692696");
		//System.out.println(str[1] + "," + str[0]);
		//System.out.println(KM);
		
		//SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//Date begin = dfs.parse("2016-11-01 09:05:50");
		//Date end = dfs.parse("2016-11-01 09:05:52");
		//long between = (end.getTime() - begin.getTime()) / 1000;// 除以1000是为了转换成秒
		//long min = between / 60;
		//System.out.println(between);
		
		Platform_Response platform_Response = new Platform_Response();
		platform_Response.setVersion(1);
		platform_Response.setUserid("201612208beiqing");
		platform_Response.setCmd("select");
		platform_Response.setDeviceid("63070666983");
		platform_Response.setSerialnum(60);
		String str = platform_Response.getOrder();
		HTTP.appadd("http://47.90.39.93:8888", str);
		
		// BigDecimal b1 = new BigDecimal("10.2");
         //BigDecimal b2 = new BigDecimal("10.01");
        //System.out.println(b1.subtract(b2).toString()); 
		
		//List<Object> list=new ArrayList<Object>();
		//List<Object> list = null;
		//String z1="AA";
		//String z2="BB";
		//if(list==null){
		//System.out.println(z1);
		//}else 
		//if(list.size()==0){
			//System.out.println(z2);
		//}
	}
}

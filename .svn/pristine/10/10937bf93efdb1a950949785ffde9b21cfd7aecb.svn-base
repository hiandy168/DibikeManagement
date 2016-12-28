package com.Dibike.common;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * @author wjf
 * @version 创建时间：2016-10-20 下午3:42:19
 */
public class JsonFormat {
	JsonObject jsonObject = new JsonObject();//创建json格式的数据  
	  
    JsonArray jsonArray = new JsonArray();//json格式的数组  

    JsonObject jsonObjArr = new JsonObject();
    /**
     * 基本格式
     * @param code
     * @param message
     * @param data
     * 如：{"resultCode":"01001","resultMsg":"请求成功"}
     * @return
     */
public JsonObject Format(String code ,String message){
	jsonObjArr.addProperty("resultCode", code);
	jsonObjArr.addProperty("resultMsg", message);
	
	return jsonObjArr;
}
/**
 * 标准格式
 * @param name
 * @param element
 * @return
 */
public JsonObject Format(String name,JsonElement element){
	jsonObjArr.add(name, element);
	return jsonObjArr;
}
    /**
     * 基本格式
     * @param code
     * @param message
     * @param data
     * 如：{"resultCode":"01001","resultMsg":"请求成功","data":null}
     * @return
     */
public String normFormat(String code ,String message){
	jsonObjArr = Format(code, message);
	jsonObjArr.add("data", null);
	
	return jsonObjArr.toString();
}

/**
 * 
 * @param code
 * @param message
 * @param data
 * 如：{"resultCode":"01001","resultMsg":"请求成功","data":{"id":1,"memberID":"201610200114"}}
 * @return
 */
public String ElementFormat(String code,String message,JsonElement data){
	  jsonObjArr = Format(code, message);
	 jsonObjArr.add("data", data);
	
	return jsonObjArr.toString();
}
/**
 * 
 * @param code
 * @param message
 * @param name
 * @param data
 * 如：{"resultCode":"01001","resultMsg":"请求成功","data":{"memberInfo":{"id":1,"memberID":"201610200114"}}}
 * @return
 */
public String ElementFormatO(String code,String message,String name,JsonElement data){
	jsonObjArr = Format(code, message);
	 JsonObject jsonObj = new JsonObject();
	 jsonObj.add(name, data);
	jsonObjArr.add("data", jsonObj);
	
	return jsonObjArr.toString();
}
/**
 * 集合
 * @param code
 * @param message
 * @param name
 * @param list
 * @return
 */
public String ListFormat(String code,String message,String name,JsonArray list){
	jsonObjArr = Format(code, message);
	 JsonObject jsonObj = new JsonObject();
	 jsonObj.add(name, list);
	jsonObjArr.add("data", jsonObj);
	return jsonObjArr.toString();
}
public static void main(String[] args) {
	@SuppressWarnings("unused")
	JsonFormat jf=new JsonFormat();
//	String a =jf.normFormat("11", "上大号",).toString();
//	System.out.println(a);
}
}

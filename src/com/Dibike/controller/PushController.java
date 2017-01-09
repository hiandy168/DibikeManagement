package com.Dibike.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Dibike.common.BaseController;
import com.Dibike.common.JsonFormat;
import com.Dibike.common.MapDistance;
import com.Dibike.common.Result;
import com.Dibike.common.Tests;
import com.Dibike.common.UtilDate;
import com.Dibike.entity.Bike;
import com.Dibike.entity.Dictionaries_table;
import com.Dibike.entity.Journey;
import com.Dibike.entity.Journey_details;
import com.Dibike.entity.MemberInfo;
import com.Dibike.entity.Point;
import com.Dibike.service.BikeService;
import com.Dibike.service.Dictionaries_tableService;
import com.Dibike.service.JourneyService;
import com.Dibike.service.Journey_detailsService;
import com.Dibike.service.MemberInfoService;
import com.Dibike.service.PointService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * @author wuxiang
 * @version 创建时间：2017年1月7日 下午5:49:57
 * 
 */
@Controller
@RequestMapping("/push")
public class PushController extends BaseController {
	private static Logger logger = Logger.getLogger(BikeController.class);
	private Gson gson = new Gson();
	private JsonFormat jsonFormat = new JsonFormat();
	@Resource
	private BikeService bikeService;
	@Resource
	private JourneyService journeyService;
	@Resource
	private PointService pointService;
	@Resource
	private Journey_detailsService journey_detailsService;
	@Resource
	private MemberInfoService memberInfoService;
	@Resource
	private Dictionaries_tableService dictionaries_tableService;
	
	
	@RequestMapping(value = "/pushMessage")
	@ResponseBody
	public Result pushMessage(String deviceid) throws ParseException, IOException{
		System.out.println("--------------------------------------------------------------");
		Bike bike = bikeService.findDeviceid(deviceid);
		Journey journey = journeyService.findMB(bike.getMemberID(), bike.getBikeNO());
		String message=IpStatus(bike, journey.getEndDate(),bike.getLng(),bike.getLat());
		MemberInfo memberInfo = memberInfoService.findByMemberID(bike.getMemberID());
		Bike mbikes = bikeService.findByMemberID(bike.getMemberID());
		mbikes.setMemberID("");
		mbikes.setBank2("");
		bikeService.upBike(mbikes);
		if (memberInfo != null) {
			Tests tests = new Tests();
			tests.testSendPush(message, bike.getMemberID());
			logger.info(message);
			System.out.println(message);
			response.getWriter().println(message);
			Result result = new Result();
			result.setStatus("0");
			result.setMsg("推送成功");
			return result;
		} else {
			Result result = new Result();
			result.setStatus("1");
			result.setMsg("推送失败");
			return result;
		}
	}
	
	
	public String IpStatus(Bike bikes, String time, String strlng, String strlat) throws ParseException, IOException {
		bikes.setStatus("O");
		bikeService.upBike(bikes);
		Journey journey = journeyService.findMB(bikes.getMemberID(), bikes.getBikeNO());
		logger.info(time);
		journey.setEndDate(time);
		journey.setClose_lng(strlng);
		journey.setClose_lat(strlat);
		journey.setJourneyID(String.valueOf(System.currentTimeMillis()));
		journey.setBank1("");
		journeyService.updateJourney(journey);
		Journey_details journey_details = journey_detailsService.findMB(bikes.getMemberID(), bikes.getBikeNO());
		journey_details.setClose_lng(strlng);
		journey_details.setClose_lat(strlat);
		journey_details.setJourneyID(String.valueOf(journey.getJourneyID()));
		journey_details.setBank1("");
		journey_detailsService.updateJourney_details(journey_details);
		SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date begin = dfs.parse(journey.getStartDate());
		Date end = dfs.parse(journey.getEndDate());
		long between = (end.getTime() - begin.getTime()) / 1000;// 除以1000是为了转换成秒
		int m = 0;
		long min = 0;
		if (between < 60) {
			m = 1;
		} else {
			min = between / 60;
			m = (int) min;
		}
		int summoney = 0;
		Dictionaries_table dictionaries_table = dictionaries_tableService.findAlls();
		if (dictionaries_table.getMoney().equals("0")) {
			summoney = 0;
			Point point = new Point();
			point.setMemberID(bikes.getMemberID());
			point.setTime(UtilDate.getDateFormatter());
			point.setNumber(Integer.toString(summoney));
			point.setPoint_name("骑行完毕加" + summoney + "分");
			pointService.savePoint(point);
		} else {
			int money = m / 60 * Integer.parseInt(dictionaries_table.getMoney());
			int y = m % 60;
			if (y != 0) {
				summoney = money += Integer.parseInt(dictionaries_table.getMoney());
			}
			Point point = new Point();
			point.setMemberID(bikes.getMemberID());
			point.setTime(UtilDate.getDateFormatter());
			point.setNumber(Integer.toString(summoney));
			point.setPoint_name("骑行完毕加" + summoney + "分");
			pointService.savePoint(point);
		}
		String KM = MapDistance.getDistance(journey.getOpen_lng(), journey.getOpen_lat(), journey.getClose_lng(),
				journey.getClose_lat());
		String carbonEmissions = Integer.toString((m * 140));
		String calorie = Integer.toString((m * 49));
		journey.setRidingCost(Integer.toString(summoney));
		journey.setRidingTime(Integer.toString(m));
		journeyService.updateJourney(journey);
		journey_details.setBank1(KM);
		journey_details.setCalorie(calorie);
		journey_details.setCarbonEmissions(carbonEmissions);
		journey_details.setRidingTime(Integer.toString(m));
		journey_detailsService.updateJourney_details(journey_details);
		MemberInfo memberInfo = memberInfoService.findByMemberID(bikes.getMemberID());
		int p = Integer.parseInt(memberInfo.getPoint());
		BigDecimal bigDecimal = new BigDecimal(memberInfo.getMoney());
		BigDecimal bigDecimal2 = new BigDecimal(Integer.toString(summoney));
		int sum = p + summoney / 1;
		String summy = bigDecimal.subtract(bigDecimal2).toString();
		memberInfo.setPoint(Integer.toString(sum));
		memberInfo.setMoney(summy);
		memberInfoService.updateMemberInfo(memberInfo);
		bikes.setStatus("O");
		bikeService.upBike(bikes);
		JsonObject jsonObj = new JsonObject();
		jsonObj.add("journeyID", gson.toJsonTree(journey.getJourneyID()));
		jsonObj.add("time", gson.toJsonTree(Integer.toString(m)));
		jsonObj.add("carbonEmissions", gson.toJsonTree(carbonEmissions));
		jsonObj.add("calorie", gson.toJsonTree(calorie));
		jsonObj.add("km", gson.toJsonTree(KM));
		jsonObj.add("hf", gson.toJsonTree(Double.toString(summoney)));
		jsonObj.add("point", gson.toJsonTree(memberInfo.getPoint()));
		jsonObj.add("money", gson.toJsonTree(memberInfo.getMoney()));
		jsonObj.add("open_lng", gson.toJsonTree(journey.getOpen_lng()));
		jsonObj.add("open_lat", gson.toJsonTree(journey.getOpen_lat()));
		jsonObj.add("close_lng", gson.toJsonTree(journey.getClose_lng()));
		jsonObj.add("close_lat", gson.toJsonTree(journey.getClose_lat()));
		jsonObj.add("cmd", gson.toJsonTree("close"));
		String str = jsonFormat.ElementFormat("01001", "请求成功", jsonObj);
		logger.info(str);
		return str;
	}

}

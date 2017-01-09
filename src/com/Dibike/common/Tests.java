package com.Dibike.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cn.jpush.api.JPushClient;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;

public class Tests {
	protected static final Logger LOG = LoggerFactory.getLogger(Tests.class);
	private static final String appKey = "34468234e44e21aebf9b0244";
	private static final String masterSecret = "89eab07e4492f5d1bc72ba8a";
	private static String msg = "ADC";
	private static String memberID;

	public static void main(String[] args) {
		testSendPush(msg, memberID);
	}

	public static void testSendPush(String msg, String memberID) {
		JPushClient jpushClient = new JPushClient(masterSecret, appKey, 1);
		PushPayload payload = buildPushObject_all_all_alert(msg, memberID);
		try {
			PushResult result = jpushClient.sendPush(payload);
			LOG.info("Got result - " + result);
		} catch (APIConnectionException e) {
			LOG.error("Connection error. Should retry later. ", e);
		} catch (APIRequestException e) {
			LOG.error("Error response from JPush server. Should review and fix it. ", e);
			LOG.info("HTTP Status: " + e.getStatus());
			LOG.info("Error Code: " + e.getErrorCode());
			LOG.info("Error Message: " + e.getErrorMessage());
			LOG.info("Msg ID: " + e.getMsgId());
		}
	}

	public static PushPayload buildPushObject_all_all_alert(String msg, String memberID) {
		return PushPayload.newBuilder().setPlatform(Platform.all()).setAudience(Audience.alias(memberID))
				.setMessage(Message.newBuilder().setMsgContent(msg).build()).build();
	}
}

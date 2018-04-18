package com.sinco.carnation.sys.service;

import com.sinco.messager.mobile.MobileMessage;
import com.sinco.messager.mobile.MobileOSType;
import com.sinco.messager.mobile.jpush.AlertMobileMessage;
import com.sinco.messager.mobile.jpush.JpushMobileMessageHandler;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

public class MobileMessageHandlerEx extends JpushMobileMessageHandler{
	private JPushClient jpushClient;
	
	public MobileMessageHandlerEx(String appKey, String masterSecret) {
		super(appKey, masterSecret);
	    this.jpushClient = new JPushClient(masterSecret, appKey, 3);
	}
	
	public void sendMessage(Long uid, MobileMessage message) throws APIConnectionException, APIRequestException {
	    PushPayload.Builder builder = makeBuilder(MobileOSType.ALL, message);
	    builder.setAudience(Audience.alias(getAliasFlag() + uid));
	    PushPayload payload = builder.build();
	    jpushClient.sendPush(payload);
	}
	
	public void sendMessage(Long uid, MobileMessage message, MobileOSType type) throws APIConnectionException, APIRequestException {
	    PushPayload.Builder builder = makeBuilder(type, message);
	    builder.setAudience(Audience.alias(getAliasFlag() + uid));
	    PushPayload payload = builder.build();
	    jpushClient.sendPush(payload);
	}

	private PushPayload.Builder makeBuilder(MobileOSType osType, MobileMessage mobileMessage) {
		if(mobileMessage instanceof AlertMobileMessage){
			AlertMobileMessage message = (AlertMobileMessage) mobileMessage;
			if(MobileOSType.IOS == osType){
				IosNotification ios = IosNotification.newBuilder().setAlert(message.getMessage()).setSound(message.getSound()).setBadge(message.getBadge()).addExtras(message.getExts()).build();
				return PushPayload.newBuilder().setPlatform(Platform.ios()).setNotification(Notification.newBuilder().addPlatformNotification(ios).build());
			}else if(MobileOSType.ANDROID == osType){
				AndroidNotification and = AndroidNotification.newBuilder().setAlert(message.getMessage()).setTitle(message.getTitle()).addExtras(message.getExts()).build();
				return PushPayload.newBuilder().setPlatform(Platform.android()).setNotification(Notification.newBuilder().addPlatformNotification(and).build());
			}else{
				IosNotification ios = IosNotification.newBuilder().setAlert(message.getMessage()).setSound(message.getSound()).setBadge(message.getBadge()).addExtras(message.getExts()).build();
				AndroidNotification and = AndroidNotification.newBuilder().setAlert(message.getMessage()).setTitle(message.getTitle()).addExtras(message.getExts()).build();
				return PushPayload.newBuilder().setPlatform(Platform.all()).setNotification(Notification.newBuilder().addPlatformNotification(and).addPlatformNotification(ios).build());
			}
		}else{
			if(MobileOSType.IOS == osType){
				MobileMessage message = mobileMessage;
				return PushPayload.newBuilder().setPlatform(Platform.ios()).setMessage(Message.newBuilder().setMsgContent(message.getMessage()).setTitle(message.getTitle()).addExtras(message.getExts()).build());
			}else if(MobileOSType.ANDROID == osType){
				MobileMessage message = mobileMessage;
				return PushPayload.newBuilder().setPlatform(Platform.android()).setMessage(Message.newBuilder().setMsgContent(message.getMessage()).setTitle(message.getTitle()).addExtras(message.getExts()).build());
			}else{
				MobileMessage message = mobileMessage;
				return PushPayload.newBuilder().setPlatform(Platform.all()).setMessage(Message.newBuilder().setMsgContent(message.getMessage()).setTitle(message.getTitle()).addExtras(message.getExts()).build());
			}
		}
	}

}

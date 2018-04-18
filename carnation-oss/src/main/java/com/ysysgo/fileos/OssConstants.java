package com.ysysgo.fileos;

import java.util.HashMap;
import java.util.Map;

public class OssConstants {
	public static final String OSS_ACCESSKEYID="LTAIw8whRTXp8XUn";
	public static final String OSS_ACCESSKEYSECRET="REFTBfIkdRExA5PI6nBlOoChzSv9ju";
	
	
	/**
	 * 获取OSS参数配置
	 * @param isMock
	 * @return
	 */
	public static Map<String, String> getOssConstantSet(boolean isMock){
		Map<String, String> ossConstantMap=new HashMap<>();
		//笼统存储位置
		ossConstantMap.put("OSS_ENDPOINT", "http://f2.ysysgo.com");
		ossConstantMap.put("OSS_BUCKET", "file2-ysysgo");
		//资料（商家等资料）存储位置
		ossConstantMap.put("OSS_DATA_ENDPOINT", "http://f3.ysysgo.com");
		ossConstantMap.put("OSS_DATA_BUCKET", "file3-ysysgo");
		//自营商品、礼品存储位置
		ossConstantMap.put("OSS_GOODS_ENDPOINT", "http://f4.ysysgo.com");
		ossConstantMap.put("OSS_GOODS_BUCKET", "file4-ysysgo");
		//商家商品，精选专区
		ossConstantMap.put("OSS_SELLER_GOODS_ENDPOINT", "http://f5.ysysgo.com");
		ossConstantMap.put("OSS_SELLER_GOODS_BUCKET", "file5-ysysgo");		
		//健康圈图片
		ossConstantMap.put("OSS_HEALTH_CIRCLE_ENDPOINT", "http://f6.ysysgo.com");
		ossConstantMap.put("OSS_HEALTH_CIRCLE_BUCKET", "file6-ysysgo");	
		
		//测试环境
		if(isMock){
			//笼统存储位置
			ossConstantMap.put("OSS_ENDPOINT", "http://f2.ysysgo.cn");
			ossConstantMap.put("OSS_BUCKET", "file2-ysysgo-mock");
			//资料（商家等资料）存储位置
			ossConstantMap.put("OSS_DATA_ENDPOINT", "http://f3.ysysgo.cn");
			ossConstantMap.put("OSS_DATA_BUCKET", "file3-ysysgo-mock");
			//自营商品、礼品存储位置
			ossConstantMap.put("OSS_GOODS_ENDPOINT", "http://f4.ysysgo.cn");
			ossConstantMap.put("OSS_GOODS_BUCKET", "file4-ysysgo-mock");
			//商家商品，精选专区
			ossConstantMap.put("OSS_SELLER_GOODS_ENDPOINT", "http://f5.ysysgo.cn");
			ossConstantMap.put("OSS_SELLER_GOODS_BUCKET", "file5-ysysgo-mock");
			//健康圈图片
			ossConstantMap.put("OSS_HEALTH_CIRCLE_ENDPOINT", "http://f6.ysysgo.cn");
			ossConstantMap.put("OSS_HEALTH_CIRCLE_BUCKET", "file6-ysysgo-mock");	
		}
		
		return ossConstantMap;
	}
	
	
	/*-------------生产环境-------------*/
	//笼统存储位置
	public static final String OSS_ENDPOINT="http://f2.ysysgo.com";
	public static final String OSS_BUCKET="file2-ysysgo";
	//订单商品快照存储位置
	public static final String OSS_ORDER_SNAPSHOOT_ENDPOINT="http://f3.ysysgo.com";
	public static final String OSS_ORDER_SNAPSHOOT_BUCKET="file3-ysysgo";
	//自营商品、礼品存储位置
	public static final String OSS_GOODS_ENDPOINT="http://f4.ysysgo.com";
	public static final String OSS_GOODS_BUCKET="file4-ysysgo";
	//商家商品，精选专区
	public static final String OSS_SELLER_GOODS_ENDPOINT="http://f5.ysysgo.com";
	public static final String OSS_SELLER_GOODS_BUCKET="file5-ysysgo";
	
	
	
	
	/*-------------测试环境--------------*/
	//笼统存储位置
	public static final String OSS_ENDPOINT_MOCK="http://f2.ysysgo.cn";
	public static final String OSS_BUCKET_MOCK="file2-ysysgo-mock";
	//订单商品快照存储位置
	public static final String OSS_ORDER_SNAPSHOOT_ENDPOINT_MOCK="http://f3.ysysgo.cn";
	public static final String OSS_ORDER_SNAPSHOOT_BUCKET_MOCK="file3-ysysgo-mock";
	//自营商品、礼品存储位置
	public static final String OSS_GOODS_ENDPOINT_MOCK="http://f4.ysysgo.cn";
	public static final String OSS_GOODS_BUCKET_MOCK="file4-ysysgo-mock";
	//商家商品，精选专区
	public static final String OSS_SELLER_GOODS_ENDPOINT_MOCK="http://f5.ysysgo.cn";
	public static final String OSS_SELLER_GOODS_BUCKET_MOCK="file5-ysysgo";
}

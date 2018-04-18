/**   
 * @(#)EnumShowStatus.java	2016年12月12日	上午11:43:57	   
 *     
 * Copyrights (C) 2016艺龙旅行网保留所有权利
 */
package com.sinco.carnation.elong.model.elong;

import java.util.HashMap;
import java.util.Map;

/**
 * (类型功能说明描述)
 *
 * <p>
 * 修改历史:											<br>  
 * 修改日期    		修改人员   	版本	 		修改内容<br>  
 * -------------------------------------------------<br>  
 * 2016年12月12日 上午11:43:57   user     1.0    	初始化创建<br>
 * </p> 
 *
 * @author		user 
 * @version		1.0  
 * @since		JDK1.7
 */
public enum EnumShowStatus {
	/**
	 * 担保失败
	 */
	GuaranteeFailed(1),
	
	/**
	 * 等待担保
	 */
	WaitGuarantee(2),
	
	/**
	 * 等待确认
	 */
	WaitConfirm(4),
	
	/**
	 * 等待支付
	 */
	WaitPay(8),
	
	/**
	 * 等待入住
	 */
	WaitCheckIn(16),
	
	/**
	 * 酒店拒绝订单
	 */
	HotelReject(32),
	
	/**
	 * 未入住
	 */
	UnArrivaled(64),
	
	/**
	 * 已离店
	 */
	Departured(128),
	
	/**
	 * 已取消
	 */
	Canceled(256),
	
	/**
	 * 已确认
	 */
	Confirmed(512),
	
	/**
	 * 已入住
	 */
	Arrivaled(1024),
	
	/**
	 * 担保处理中
	 */
	ProcessingGuarantee(2048),
	
	/**
	 * 支付处理中
	 */
	ProcessingPay(4096),
	
	/**
	 * 支付失败
	 */
	PayFailed(8192);
	
	private final long value;
	
	private EnumShowStatus(long v){
		this.value = v;
	}
	
	public long getValue(){
		return value;
	}
	
	public static EnumShowStatus parseEnumShowStatus(long v){
        for (EnumShowStatus c: EnumShowStatus.values()) {
            if (c.value == v) {
                return c;
            }
        }
        throw new IllegalArgumentException("");
	}
	
	private static final Map<Long,String> mapInfo = new HashMap<Long,String>();
	static {
		mapInfo.put((long)1, "担保失败");
		mapInfo.put((long)2, "等待担保");
		mapInfo.put((long)4, "等待确认");
		mapInfo.put((long)8, "等待支付");
		mapInfo.put((long)16, "等待核实入住");
		mapInfo.put((long)32, "酒店拒绝订单");
		mapInfo.put((long)64, "未入住");
		mapInfo.put((long)128, "已经离店");
		mapInfo.put((long)256, "已经取消");
		mapInfo.put((long)512, "已经确认");
		mapInfo.put((long)1024, "已经入住");
		mapInfo.put((long)2048, "正在担保-处理中");
		mapInfo.put((long)4096, "正在支付-处理中");
		mapInfo.put((long)8192, "支付失败");
	}
	
	public static String getDescription(Long key){
		return mapInfo.containsKey(key)?mapInfo.get(key):"--";
	}
	
	/**
	 * 
	 * 获取枚举的描述
	 *
	 * @return
	 */
	public String getDescription(){
		return getDescription(this.value);
	}
}

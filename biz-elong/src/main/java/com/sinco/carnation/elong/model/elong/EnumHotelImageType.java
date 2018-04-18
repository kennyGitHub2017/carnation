/**   
 * @(#)EnumHotelImageType.java	2016年12月12日	下午3:33:45	   
 *     
 * Copyrights (C) 2016艺龙旅行网保留所有权利
 */
package com.sinco.carnation.elong.model.elong;

import java.util.HashMap;
import java.util.Map;

/**
 * 图片类型
 *
 * <p>
 * 修改历史:											<br>  
 * 修改日期    		修改人员   	版本	 		修改内容<br>  
 * -------------------------------------------------<br>  
 * 2016年12月12日 下午3:33:45   user     1.0    	初始化创建<br>
 * </p> 
 *
 * @author		user 
 * @version		1.0  
 * @since		JDK1.7
 */
public enum EnumHotelImageType {
	Restaurant(1),
	
	RecreationFacilities(2),
	
	Meeting(3),
	
	Exterior(5),
	
	Reception(6),
	
	GuestRoom(8),
	
	Others(10),
	
	PublicArea(11),
	
	NearbyAttractions(12);
	
	private final int value;
	
	private EnumHotelImageType(int v){
		this.value = v;
	}
	
	public int getValue(){
		return this.value;
	}
	
	public static EnumHotelImageType parseEnumHotelImageType(int v){
		for (EnumHotelImageType element : EnumHotelImageType.values()) {
			if(element.getValue() == v){
				return element;
			}
		}
		
		throw new IllegalArgumentException(String.valueOf(v));
	}
	
	public String getDescription(){
		return getImageTitle(this.getValue());
	}
	
	private static final Map<Integer, String> imageTypeMap = new HashMap<Integer, String>();
	
	static {
		imageTypeMap.put(1, "餐厅");
		imageTypeMap.put(2, "休闲");
		imageTypeMap.put(3, "会议室");
		imageTypeMap.put(5, "外观");
		imageTypeMap.put(6, "大堂/接待台");
		imageTypeMap.put(8, "客房");
		imageTypeMap.put(10, "其他");
		imageTypeMap.put(11, "公共区域");
		imageTypeMap.put(12, "周边景点");
	}
	
	/**
	 * 
	 * 获取对应的图片样式
	 *
	 * @param imageType
	 * @return
	 */
	public static String getImageTitle(Integer imageType){
		return imageTypeMap.get(imageType);
	}
}

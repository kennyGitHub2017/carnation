/**   
 * @(#)AppConfigUtil.java	2016年11月21日	下午4:45:03	   
 *     
 * Copyrights (C) 2016艺龙旅行网保留所有权利
 */
package com.sinco.carnation.elong.util;

import java.io.UnsupportedEncodingException;
import java.util.ResourceBundle;

/**
 * 公共配置信息获取
 *
 * <p>
 * 修改历史:											<br>  
 * 修改日期    		修改人员   	版本	 		修改内容<br>  
 * -------------------------------------------------<br>  
 * 2016年11月21日 下午4:45:03   user     1.0    	初始化创建<br>
 * </p> 
 *
 * @author		user 
 * @version		1.0  
 * @since		JDK1.7
 */
public class AppConfigUtil {
	public static ResourceBundle COMMON_CONFIG = ResourceBundle.getBundle("custom/env/common");

	/**
	 * 获取common.propety配置文件里的Key-value
	 * @param key
	 * @return
	 */
	public static String getCommonConfig(String key) {
		String str = AppConfigUtil.COMMON_CONFIG.getString(key);
		if (str == null) {
			return "";
		}
		try {
			str = new String(str.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}
}

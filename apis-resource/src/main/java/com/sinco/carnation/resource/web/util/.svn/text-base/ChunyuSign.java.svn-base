package com.sinco.carnation.resource.web.util;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.Properties;

import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 春雨医生特有的签名方式
 * @author tw
 *
 */
public class ChunyuSign {
	private static final Logger LOG = LoggerFactory.getLogger(ChunyuSign.class);
	/**
	 * 合作方标识
	 */
	public static final String PARTNER;
	/**
	 * 合作方密钥
	 */
	public static final String PARTNER_KEY;
	
	public static final String HOST_URL;
	public static final String LOGIN_URL;
	public static final String PROBLEM_URL;
	
	static{
		Properties pros = init();
		PARTNER = pros.getProperty("chunyu.partner", "");
		PARTNER_KEY = pros.getProperty("chunyu.partner_key", "");
		HOST_URL = pros.getProperty("chunyu.host_url", "");
		LOGIN_URL = pros.getProperty("chunyu.login_url", "");
		PROBLEM_URL = pros.getProperty("chunyu.problem_url", "");
	}
	
	public static Properties init(){
		Resource res = new ClassPathResource("application.properties");
		Properties pros = new Properties();
		InputStream is = null;
		try {
			is = res.getInputStream();
			pros.load(is);
		} catch (Exception e) {
			LOG.warn("加载配置文件失败：application.properties", e);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
				}
			}
		}
		return pros;
	}
	
	/**
	 * 计算签名
	 * @param atime 时间戳
	 * @param user_id 用户标识
	 * @return 签名字串
	 */
	public static String getSign(Long atime, String user_id) {
        try{
        	String info = PARTNER_KEY + atime + user_id;
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] srcBytes = info.getBytes();
            md5.update(srcBytes);
            byte[] resultBytes = md5.digest();
            String resultString = new String(new Hex().encode(resultBytes));
            return resultString.substring(8, 24);
        }catch(Exception e){
        	LOG.error("生成签名失败「春雨医生」", e);
        	return null;
        }
    }
	
	/**
	 * 验证签名的正确性
	 * @param atime 时间戳
	 * @param user_id 用户标识
	 * @param sign 原签名字串
	 * @return 成功true,失败false
	 */
	public static boolean verifySign(Long atime, String user_id, String sign){
		return sign != null && sign.equals(getSign(atime, user_id));
	}
	
}

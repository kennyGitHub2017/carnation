package com.sinco.biz.common.orcl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import vc.thinker.b2b2c.core.tools.Md5Encrypt;

import com.alibaba.fastjson.JSONObject;

public class OrclService {
	private static Logger logger = LoggerFactory.getLogger(OrclService.class);
	private static String code;
	private static String key;
	private static String url;
	
	private static String clientId;
	private static String sevenKey;
	private static String sevenUrl;

	public static String getCode() {
		return code;
	}

	public static void setCode(String code) {
		OrclService.code = code;
	}

	public static String getKey() {
		return key;
	}

	public static void setKey(String key) {
		OrclService.key = key;
	}

	public static String getUrl() {
		return url;
	}

	public static void setUrl(String url) {
		OrclService.url = url;
	}
	

	public static String getClientId() {
		return clientId;
	}

	public static void setClientId(String clientId) {
		OrclService.clientId = clientId;
	}

	public static String getSevenKey() {
		return sevenKey;
	}

	public static void setSevenKey(String sevenKey) {
		OrclService.sevenKey = sevenKey;
	}

	public static String getSevenUrl() {
		return sevenUrl;
	}

	public static void setSevenUrl(String sevenUrl) {
		OrclService.sevenUrl = sevenUrl;
	}

	/**
	 * 返回json
	 * 
	 * @param schema_name
	 *            :调用方法名
	 * @param params
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("rawtypes")
	public static String getOrclResult(String schema_name, Map params) {
		BufferedReader in = null;
		String result = "";
		String address = "";
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("HHmss");
		// String code_ = "YUNSHANG" + "123456" +
		// dateFormat.format(date).toString();
		String code_ = code + key + dateFormat.format(date).toString();
		String md5 = Md5Encrypt.md5(code_).toLowerCase();
		// JSONObject json = JSONObject.fromObject(params);
		String parameter = JSONObject.toJSONString(params);
		try {
			// String address =
			// "http://192.168.1.154:8899/DataInterface.aspx?schema_name="+schema_name+"&client_id=YUNSHANG&md5="
			// + md5 + "&parameter=" + URLEncoder.encode(parameter,"utf-8");
			address = url + "?schema_name=" + schema_name + "&client_id=" + code + "&md5=" + md5
					+ "&parameter=" + URLEncoder.encode(parameter, "utf-8");
			URL url = new URL(address);
			URLConnection con = url.openConnection();
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			logger.info("result===" + result);
			in.close();
		} catch (IOException e) {
			logger.error("[get orcl result] error, result=" + result + "schema_name=" + schema_name
					+ "address===" + address, e);
			throw new RuntimeException("[get orcl result]");
		}
		return result;
	}
	
	/***
	 * 七步系统对接底层
	 * @param schema_name
	 * @param params
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String getSevenOraclResult (String schema_name, Map params) {
		BufferedReader in = null;
		String result = "";
		String sendUrl = "";
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("HHmmss");
		String code_ = clientId + sevenKey + dateFormat.format(date).toString();
		String md5 = Md5Encrypt.md5(code_).toLowerCase();
		String parameter = JSONObject.toJSONString(params);
		
		try {
			 sendUrl = sevenUrl + "?schema_name=" + schema_name + "&client_id=" + clientId + "&md5=" + md5
					+ "&parameter=" + URLEncoder.encode(parameter, "utf-8");
			
			URL url = new URL(sendUrl);
			URLConnection con = url.openConnection();
			in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			logger.info("result===" + result);
			in.close();
			
		} catch (IOException e) {
			logger.debug("SEVEN ORACLE CLIENT {}", e);
		}
		return result;
	}
}

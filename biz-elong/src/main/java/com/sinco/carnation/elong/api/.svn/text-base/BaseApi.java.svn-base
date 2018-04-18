package com.sinco.carnation.elong.api;

import java.lang.reflect.ParameterizedType;

import com.sinco.carnation.elong.model.elong.EnumLocal;
import com.sinco.carnation.elong.util.AppConfigUtil;
import com.sinco.carnation.elong.util.Http;
import com.sinco.carnation.elong.util.JsonUtil;
import com.sinco.carnation.elong.util.Tool;

/**
 * 
 * T:请求条件实体 T2:返回实体
 * 
 * <p>
 * 修改历史: <br>
 * 修改日期 修改人员 版本 修改内容<br>
 * -------------------------------------------------<br>
 * 2016年11月21日 下午3:11:39 user 1.0 初始化创建<br>
 * </p>
 * 
 * @author user
 * @version 1.0
 * @since JDK1.7
 */
public abstract class BaseApi<T, T2> {

	private static String appUser = null;
	private static String appKey = null;
	private static String appSecret = null;
	private static double version = 1.1;
	private static EnumLocal locale = EnumLocal.en_US;
	private static String serverHost = null;

	// 返回实体的类型
	public Class<T2> T2Class = null;

	// 是否打印请求参数与返回参数
	private final static boolean isVerbosed = true;
	// 请求、返回参数类型：json
	private final static String format = "json";

	/**
	 * 
	 * (构造函数说明)
	 * 
	 */
	@SuppressWarnings("unchecked")
	public BaseApi() {
		// 通过反射获取返回实体的类型数据
		ParameterizedType type = (ParameterizedType) (getClass().getGenericSuperclass());
		java.lang.reflect.Type[] types = type.getActualTypeArguments();
		if (types != null && types.length > 1) {
			T2Class = (Class<T2>) types[1];
		}

		// 加载配置信息
		loadConf();
	}

	/**
	 * 
	 * 加载所有配置信息
	 * 
	 */
	private void loadConf() {
		appUser = AppConfigUtil.getCommonConfig("appUser");
		appKey = AppConfigUtil.getCommonConfig("appKey");
		appSecret = AppConfigUtil.getCommonConfig("appSecret");
		serverHost = AppConfigUtil.getCommonConfig("serverHost");
		version = Double.parseDouble(AppConfigUtil.getCommonConfig("version"));
		String localeString = AppConfigUtil.getCommonConfig("locale");
		if ("en_US".equals(localeString)) {
			locale = EnumLocal.en_US;
		} else {
			locale = EnumLocal.zh_CN;
		}

		if (appUser == null || appUser.equals("")) {
			System.out.println("ERROR - plz conf appUser in  test.conf\r\n");
		} else if (appKey == null || appKey.equals("")) {
			System.out.println("ERROR - plz conf appKey in  test.conf\r\n");
		} else if (appSecret == null || appSecret.equals("")) {
			System.out.println("ERROR - plz conf appSecret in  test.conf\r\n");
		} else if (serverHost == null || serverHost.equals("")) {
			System.out.println("ERROR - plz conf serverHost in  test.conf\r\n");
		}
	}

	/*********************************************** start 抽象方法 start ******************************************************/
	public abstract String method();

	public abstract boolean isRequiredSSL();

	/*********************************************** end 抽象方法 end ******************************************************/

	/**
	 * elong api 返回的字符串
	 */
	private String responseData;

	/**
	 * 
	 * 提供外部最终调用的方法
	 * 
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public T2 Invoke(T t) {
		if (appUser == null || appUser.equals("")) {
			System.out.println("please set appUser and keys.");
			return null;
		}
		T2 result = null;
		try {
			BaseRequst<T> req = new BaseRequst<T>();
			req.Version = version;
			req.Local = locale;
			req.Request = t;

			// 请求参数转换为Json字符串
			String str = JsonUtil.entity2Json(req);
			if (isVerbosed) {
				System.out.println("request info:" + str);
			}

			// 产生签名
			long epoch = System.currentTimeMillis() / 1000;
			String sig = Tool.md5(epoch + Tool.md5(str + appKey) + appSecret);

			// 产生请求链接
			String url = "http" + (this.isRequiredSSL() ? "s" : "") + "://" + serverHost + "/rest?format="
					+ format + "&method=";
			url += this.method();
			url += "&user=" + appUser + "&timestamp=";
			url += epoch;
			url += "&signature=";
			url += sig;
			url += "&data=" + Tool.encodeUri(str);;
			if (isVerbosed) {
				System.out.println();
				System.out.println("request url:" + url);
			}

			// 发送请求
			responseData = Http.Send("GET", url, "");
			if (isVerbosed) {
				System.out.println();
				System.out.println("response raw data:" + responseData);
			}

			// 返回值处理
			responseData = responseData.trim();
			result = JsonUtil.jsonToObject(responseData, T2Class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public String getResponseData() {
		return responseData;
	}

	public void setResponseData(String responseData) {
		this.responseData = responseData;
	}

}

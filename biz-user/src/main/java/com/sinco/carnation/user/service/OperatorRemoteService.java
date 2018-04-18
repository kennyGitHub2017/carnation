package com.sinco.carnation.user.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.plexus.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinco.biz.common.orcl.OrclService;
import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.constant.OrclSchmaNameConstants;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import vc.thinker.b2b2c.core.tools.CommUtil;

/**
 * 与结算系统对接，远程获取运营商关系
 * 
 * @author xing.wen
 * 
 */
@Service
public class OperatorRemoteService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	public OrclUserBaseService orclUserBaseService;
	@Autowired
	private OrclService orclService;

	/**
	 * 根据运营商编号，网络关系
	 * 
	 * @param operatorCode
	 * @return
	 */
	public Map<Integer, Long> getNETParentLevelByCode(String operatorCode) {
		Map<String, String> parameter = new HashMap<String, String>();
		parameter.put("USER_ALIAS", operatorCode);
		@SuppressWarnings("static-access")
		String resultJsonStr = orclService.getOrclResult(OrclSchmaNameConstants.GET_USER_PARENT_NET,
				parameter);
		logger.info("[remote operator] get remote operator.operator code = " + operatorCode
				+ ",result json = " + resultJsonStr);
		if (StringUtils.isBlank(resultJsonStr)) {
			logger.error(
					"[remote operator] get remote error. result is empty ,operator code = " + operatorCode);
			throw new RuntimeException("[remote operator] error.");
		}
		try {
			JSONObject resultJson = JSONObject.fromObject(resultJsonStr);
			if ("success".equals(resultJson.getString("result"))) {
				JSONArray dataArray = resultJson.getJSONArray("data");
				if (null != dataArray && dataArray.size() > 0) {
					Map<Integer, Long> resultmp = new HashMap<Integer, Long>();
					for (int i = 0; i < dataArray.size(); i++) {
						JSONObject jsonobj = dataArray.getJSONObject(i);
						int level = jsonobj.containsKey("LEVEL") ? jsonobj.getInt("LEVEL") : 0;
						if (0 == level) {
							continue;
						}
						String code = jsonobj.containsKey("PARENT_ALIAS") ? jsonobj.getString("PARENT_ALIAS")
								: "";
						if (StringUtils.isEmpty(code)) {
							continue;
						}
						UserAccountBO userAccount = new UserAccountBO();
						userAccount.setLoginName(code);
						orclUserBaseService.insertOrclUser(userAccount);
						if (null != userAccount) {
							resultmp.put(level, userAccount.getUid());
						}
					}
					return resultmp;
				}
				return null;
			} else {
				logger.error("[remote operator] get remote error. operator code = " + operatorCode
						+ ",result json =" + resultJsonStr);
				throw new RuntimeException("[remote operator] error.");
			}
		} catch (Exception e) {
			logger.error("[remote operator] get remote error.result format error, operator code = "
					+ operatorCode + ",result json =" + resultJsonStr, e);
			throw new RuntimeException("[remote operator] error.", e);
		}
	}

	/**
	 * 根据运营商编号，获取运营商的直推
	 * 
	 * @param code区域号
	 * @return json,demo [{code:00001,level:1,arecode:4343343},{code:00001,level:1,arecode :4343343}]
	 */
	public Map<Integer, Long> getRemoteOperatorLevelByCode(String operatorCode) {
		Map<String, String> parameter = new HashMap<String, String>();
		parameter.put("USER_ALIAS", operatorCode);
		@SuppressWarnings("static-access")
		String resultJsonStr = orclService.getOrclResult(OrclSchmaNameConstants.GET_USER_INTRODUCER_NET,
				parameter);
		logger.info("[remote operator] get remote operator.operator code = " + operatorCode
				+ ",result json = " + resultJsonStr);
		if (StringUtils.isBlank(resultJsonStr)) {
			logger.error(
					"[remote operator] get remote error. result is empty ,operator code = " + operatorCode);
			throw new RuntimeException("[remote operator] error.");
		}
		try {
			JSONObject resultJson = JSONObject.fromObject(resultJsonStr);
			if ("success".equals(resultJson.getString("result"))) {
				JSONArray dataArray = resultJson.getJSONArray("data");
				if (null != dataArray && dataArray.size() > 0) {
					Map<Integer, Long> resultmp = new HashMap<Integer, Long>();
					for (int i = 0; i < dataArray.size(); i++) {
						JSONObject jsonobj = dataArray.getJSONObject(i);
						String code = jsonobj.containsKey("USER_ALIAS")
								? jsonobj.getString("USER_ALIAS") : "";
						if (StringUtils.isEmpty(code)) {
							continue;
						}
						int level = jsonobj.containsKey("LEVEL") ? jsonobj.getInt("LEVEL") : 0;
						if (0 == level) {
							continue;
						}
						UserAccountBO userAccount = new UserAccountBO();
						userAccount.setLoginName(code);
						orclUserBaseService.insertOrclUser(userAccount);
						if (null != userAccount) {
							resultmp.put(level, userAccount.getUid());
						}
					}
					return resultmp;
				}
				return null;
			} else {
				logger.error("[remote operator] get remote error. operator code = " + operatorCode
						+ ",result json =" + resultJsonStr);
				throw new RuntimeException("[remote operator] error.");
			}
		} catch (Exception e) {
			logger.error("[remote operator] get remote error.result format error, operator code = "
					+ operatorCode + ",result json =" + resultJsonStr, e);
			throw new RuntimeException("[remote operator] error.", e);
		}
	}

	/**
	 * 根据CN登录号查询 直销系统推荐关系
	 * 
	 * @param operatorCode
	 *            CN登录账号
	 * @return json,demo [{code:00001,level:1,arecode:4343343},{code:00001,level:1,arecode :4343343}]
	 */
	public List<String> getRemoteCNuserNameByCode(String operatorCode) {
		Map<String, String> parameter = new HashMap<String, String>();
		parameter.put("USER_ALIAS", operatorCode);
		@SuppressWarnings("static-access")
		String resultJsonStr = orclService.getOrclResult(OrclSchmaNameConstants.GET_USER_INTRODUCER_NET_U,
				parameter);
		logger.info("[remote operator] get remote operator.operator code = " + operatorCode
				+ ",result json = " + resultJsonStr);
		List<String> listString = new ArrayList<>();
		if (StringUtils.isBlank(resultJsonStr)) {
			logger.error(
					"[remote operator] get remote error. result is empty ,operator code = " + operatorCode);
			throw new RuntimeException("[remote operator] error.");
		}
		try {
			JSONObject resultJson = JSONObject.fromObject(resultJsonStr);
			if ("success".equals(resultJson.getString("result"))) {
				JSONArray dataArray = resultJson.getJSONArray("data");
				if (null != dataArray && dataArray.size() > 0) {
					for (int i = 0; i < dataArray.size(); i++) {
						JSONObject jsonobj = dataArray.getJSONObject(i);
						String code = jsonobj.containsKey("USER_ALIAS") ? jsonobj.getString("USER_ALIAS")
								: "";
						if (CommUtil.isNotNull(code)) {
							listString.add(code);
						}
					}
				}
				return listString;
			} else {
				logger.error("[remote operator] get remote error. operator code = " + operatorCode
						+ ",result json =" + resultJsonStr);
				throw new RuntimeException("[remote operator] error.");
			}
		} catch (Exception e) {
			logger.error("[remote operator] get remote error.result format error, operator code = "
					+ operatorCode + ",result json =" + resultJsonStr, e);
			throw new RuntimeException("[remote operator] error.", e);
		}
	}

	public static void main(String args[]) {
		//网体
		//parent_net();
		//直推
		getnet();
	}

	@SuppressWarnings({"static-access", "unused"})
	private static void parent_net() {
		Map<String, String> parameter = new HashMap<String, String>();
		parameter.put("USER_ALIAS", "CN23637063");
		String code = "YUNSHANG";
		String key = "123456";
		String url = "http://222.122.195.61:8090/DataInterface.aspx";
		OrclService orclService = new OrclService();
		orclService.setCode(code);
		orclService.setKey(key);
		orclService.setUrl(url);
		String resultJsonStr = orclService.getOrclResult(OrclSchmaNameConstants.GET_USER_PARENT_NET,
				parameter);
		System.out.println(resultJsonStr);

		JSONObject resultJson = JSONObject.fromObject(resultJsonStr);
		if ("success".equals(resultJson.getString("result"))) {
			JSONArray dataArray = resultJson.getJSONArray("data");
			if (null != dataArray && dataArray.size() > 0) {
				Map<Integer, Long> resultmp = new HashMap<Integer, Long>();
				for (int i = 0; i < dataArray.size(); i++) {
					JSONObject jsonobj = dataArray.getJSONObject(i);
					int level = jsonobj.containsKey("LEVEL") ? jsonobj.getInt("LEVEL") : 0;
					if (0 == level) {
						continue;
					}
					String coderesult = jsonobj.containsKey("PARENT_ALIAS") ? jsonobj.getString("PARENT_ALIAS")
							: "";
					if (StringUtils.isEmpty(code)) {
						continue;
					}
					System.out.println(coderesult);
				}
			}
		}
	}

	@SuppressWarnings({"static-access", "unused"})
	private static void getnet() {
		Map<String, String> parameter = new HashMap<String, String>();
		parameter.put("USER_ALIAS", "CN54130243");
		String code = "YUNSHANG";
		String key = "123456";
		String url = "http://222.122.195.61:8090/DataInterface.aspx";
		OrclService orclService = new OrclService();
		orclService.setCode(code);
		orclService.setKey(key);
		orclService.setUrl(url);
		String resultJsonStr = orclService.getOrclResult(OrclSchmaNameConstants.GET_USER_INTRODUCER_NET,
				parameter);
		System.out.println(resultJsonStr);

		JSONObject resultJson = JSONObject.fromObject(resultJsonStr);
		if ("success".equals(resultJson.getString("result"))) {
			JSONArray dataArray = resultJson.getJSONArray("data");
			if (null != dataArray && dataArray.size() > 0) {
				Map<Integer, Long> resultmp = new HashMap<Integer, Long>();
				for (int i = 0; i < dataArray.size(); i++) {
					JSONObject jsonobj = dataArray.getJSONObject(i);
					String coderesult = jsonobj.containsKey("USER_ALIAS")
							? jsonobj.getString("USER_ALIAS") : "";
					if (StringUtils.isEmpty(code)) {
						continue;
					}
					int level = jsonobj.containsKey("LEVEL") ? jsonobj.getInt("LEVEL") : 0;
					if (0 == level) {
						continue;
					}
					System.out.println(coderesult);
				}
			}
		}
	}
}

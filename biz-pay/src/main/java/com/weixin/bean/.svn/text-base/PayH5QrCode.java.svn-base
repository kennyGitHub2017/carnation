package com.weixin.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.weixin.utils.Signature;

/**
 * 
 * @author louiseliu
 * 
 */
public class PayH5QrCode {

	private String appId = "";
	private String timeStamp = "";
	private String nonceStr = "";
	private String sign = "";
	private String prepayId = "";

	public String getPrepay_id() {
		return prepayId;
	}

	public void setPrepay_id(String prepay_id) {
		this.prepayId = prepay_id;
	}

	/**
	 * @param product_id
	 */
	public PayH5QrCode(String appid, String key, String prepay_id) {
		setAppId(appid);
		setTimeStamp(System.currentTimeMillis() / 1000 + "");
		setNonceStr(UUID.randomUUID().toString().replace("-", ""));
		setPrepay_id(prepay_id);

		try {
			/*Map<String, String> map = BeanUtils.describe(this);
			map.remove("class");
			map.remove("prepay_id");
			map.remove("sign");
			*/
			Map<String, String> map = new HashMap<String, String>();
			map.put("appId", appid);
			map.put("timeStamp", this.getTimeStamp());
			map.put("nonceStr", this.getNonceStr());
			map.put("package", "prepay_id=" + prepay_id);
			map.put("signType", "MD5");

			String sign = Signature.generateSign(map, key, false);
			setSign(sign);
		} catch (Exception e) {

		}
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
}

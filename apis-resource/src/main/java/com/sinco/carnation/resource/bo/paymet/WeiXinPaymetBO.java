package com.sinco.carnation.resource.bo.paymet;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "WeiXinPaymet", desc = "微信相关参数")
public class WeiXinPaymetBO {

	@JsonProperty("appid")
	@FieldMapping(desc = "公众账号ID")
	private String appid;

	@JsonProperty("noncestr")
	@FieldMapping(desc = "随机字符串")
	private String noncestr;

	@JsonProperty("package1")
	@FieldMapping(desc = "扩展字段")
	private String package1 = "Sign=WXPay";

	@JsonProperty("partnerid")
	@FieldMapping(desc = "商户号")
	private String partnerid;

	@JsonProperty("prepayid")
	@FieldMapping(desc = "预支付交易会话ID")
	private String prepayid;

	@JsonProperty("timestamp")
	@FieldMapping(desc = "时间戳")
	private String timestamp;

	@JsonProperty("sign")
	@FieldMapping(desc = "微信支付paysignkey")
	private String sign;

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getNoncestr() {
		return noncestr;
	}

	public void setNoncestr(String noncestr) {
		this.noncestr = noncestr;
	}

	public String getPackage1() {
		return package1;
	}

	public void setPackage1(String package1) {
		this.package1 = package1;
	}

	public String getPartnerid() {
		return partnerid;
	}

	public void setPartnerid(String partnerid) {
		this.partnerid = partnerid;
	}

	public String getPrepayid() {
		return prepayid;
	}

	public void setPrepayid(String prepayid) {
		this.prepayid = prepayid;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
}

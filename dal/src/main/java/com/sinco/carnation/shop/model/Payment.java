package com.sinco.carnation.shop.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.math.BigDecimal;
import java.util.Date;

public class Payment extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3658088011814322184L;

	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/**  **/
	private Integer deleteStatus;

	/**  **/
	private BigDecimal alipayRate;

	/**  **/
	private String chinabankAccount;

	/**  **/
	private String chinabankKey;

	/** 支付货币种类 **/
	private String currencyCode;

	/**  **/
	private Boolean install;

	/**  **/
	private Integer interfaceType;

	/**
	 * 支付方式标识代码,alipay为支付宝， alipay_wap为支付宝手机网页支付， alipay_app为支付宝APP版，99bill为快钱，
	 * tenpay为财付通,balance为预存款，payafter为货到付款(V2.0版本增加商品是否支持货到付款属性，取消该付款方式)，
	 * outline为线下支付(已经取消该付款方式，只接受在线付款、货到付款、预存款付款) wx_app为手机端微信支付 wx_pay为手机端微信支付
	 */
	private String mark;

	/**  **/
	private String merchantAcctid;

	/**  **/
	private String name;

	/**  **/
	private String partner;

	/** paypal商户id **/
	private String paypalUserId;

	/**  **/
	private String pid;

	/** 支付手续费 **/
	private BigDecimal poundage;

	/**  **/
	private String rmbKey;

	/**  **/
	private String safeKey;

	/**  **/
	private String sellerEmail;

	/**  **/
	private String spname;

	/**  **/
	private String tenpayKey;

	/**  **/
	private String tenpayPartner;

	/**  **/
	private Integer tradeMode;

	/** 微信支付AppSecret **/
	private String wxAppsecret;

	/** 微信支付appid **/
	private String wxAppid;

	/** 微信支付paySignKey **/
	private String wxPaysignkey;

	/**  **/
	private String appPrivateKey;

	/**  **/
	private String appPublicKey;

	/**  **/
	private String content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Integer getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Integer deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public BigDecimal getAlipayRate() {
		return alipayRate;
	}

	public void setAlipayRate(BigDecimal alipayRate) {
		this.alipayRate = alipayRate;
	}

	public String getChinabankAccount() {
		return chinabankAccount;
	}

	public void setChinabankAccount(String chinabankAccount) {
		this.chinabankAccount = chinabankAccount;
	}

	public String getChinabankKey() {
		return chinabankKey;
	}

	public void setChinabankKey(String chinabankKey) {
		this.chinabankKey = chinabankKey;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public Boolean getInstall() {
		return install;
	}

	public void setInstall(Boolean install) {
		this.install = install;
	}

	public Integer getInterfaceType() {
		return interfaceType;
	}

	public void setInterfaceType(Integer interfaceType) {
		this.interfaceType = interfaceType;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getMerchantAcctid() {
		return merchantAcctid;
	}

	public void setMerchantAcctid(String merchantAcctid) {
		this.merchantAcctid = merchantAcctid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getPaypalUserId() {
		return paypalUserId;
	}

	public void setPaypalUserId(String paypalUserId) {
		this.paypalUserId = paypalUserId;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public BigDecimal getPoundage() {
		return poundage;
	}

	public void setPoundage(BigDecimal poundage) {
		this.poundage = poundage;
	}

	public String getRmbKey() {
		return rmbKey;
	}

	public void setRmbKey(String rmbKey) {
		this.rmbKey = rmbKey;
	}

	public String getSafeKey() {
		return safeKey;
	}

	public void setSafeKey(String safeKey) {
		this.safeKey = safeKey;
	}

	public String getSellerEmail() {
		return sellerEmail;
	}

	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}

	public String getSpname() {
		return spname;
	}

	public void setSpname(String spname) {
		this.spname = spname;
	}

	public String getTenpayKey() {
		return tenpayKey;
	}

	public void setTenpayKey(String tenpayKey) {
		this.tenpayKey = tenpayKey;
	}

	public String getTenpayPartner() {
		return tenpayPartner;
	}

	public void setTenpayPartner(String tenpayPartner) {
		this.tenpayPartner = tenpayPartner;
	}

	public Integer getTradeMode() {
		return tradeMode;
	}

	public void setTradeMode(Integer tradeMode) {
		this.tradeMode = tradeMode;
	}

	public String getWxAppsecret() {
		return wxAppsecret;
	}

	public void setWxAppsecret(String wxAppsecret) {
		this.wxAppsecret = wxAppsecret;
	}

	public String getWxAppid() {
		return wxAppid;
	}

	public void setWxAppid(String wxAppid) {
		this.wxAppid = wxAppid;
	}

	public String getWxPaysignkey() {
		return wxPaysignkey;
	}

	public void setWxPaysignkey(String wxPaysignkey) {
		this.wxPaysignkey = wxPaysignkey;
	}

	public String getAppPrivateKey() {
		return appPrivateKey;
	}

	public void setAppPrivateKey(String appPrivateKey) {
		this.appPrivateKey = appPrivateKey;
	}

	public String getAppPublicKey() {
		return appPublicKey;
	}

	public void setAppPublicKey(String appPublicKey) {
		this.appPublicKey = appPublicKey;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
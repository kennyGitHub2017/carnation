package com.sinco.carnation.resource.bo.integral;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(desc = "订单详情", domainName = "IntegralOrderDetails")
public class IntegralOrderDetailsBO {

	@JsonProperty("id")
	@FieldMapping(desc = "订单id")
	private Long id;

	@JsonProperty("igoOrderSn")
	@FieldMapping(desc = "订单号")
	private String igoOrderSn;

	@JsonProperty("orderStatus")
	@FieldMapping(desc = "订单状态|0为已提交未付款，20为付款成功，30为已发货，40为已收货完成,-1为已经取消，此时不归还用户积分")
	private Integer igoStatus;

	@JsonProperty("status")
	@FieldMapping(desc = "订单状态")
	private String status;

	/** 总共消费积分 **/
	@JsonProperty("igoTotalIntegral")
	@FieldMapping(desc = "总共消费积分")
	private Integer igoTotalIntegral;

	/** 购物车运费 **/
	@JsonProperty("igoTransFee")
	@FieldMapping(desc = "购物车运费")
	private BigDecimal igoTransFee;

	@JsonProperty("addTime")
	@FieldMapping(desc = "时间")
	private Date addTime;

	/** 支付方式，使用mark标识 **/
	@JsonProperty("igoPayment")
	@FieldMapping(desc = "支付方式，使用mark标识 ")
	private String igoPayment;

	@JsonProperty("payment")
	@FieldMapping(desc = "支付方式")
	private String payment;

	/** 支付时间 **/
	@JsonProperty("igoPayTime")
	@FieldMapping(desc = "支付时间")
	private Date igoPayTime;

	/** 兑换附言 **/
	@JsonProperty("igoMsg")
	@FieldMapping(desc = "兑换附言 ")
	private String igoMsg;

	/** 收货人姓名,确认订单后，将买家的收货地址所有信息添加到订单中，该订单与买家收货地址没有任何关联 **/
	@JsonProperty("receiverName")
	@FieldMapping(desc = "收货人姓名,确认订单后，将买家的收货地址所有信息添加到订单中，该订单与买家收货地址没有任何关联 ")
	private String receiverName;

	/** 收货人地区,例如：辽宁省沈阳市铁西区 **/
	@JsonProperty("receiverArea")
	@FieldMapping(desc = "收货人地区,例如：辽宁省沈阳市铁西区 ")
	private String receiverArea;

	/** 收货人邮政编码 **/
	@JsonProperty("receiverZip")
	@FieldMapping(desc = "收货人邮政编码  ")
	private String receiverZip;

	/** 收货人详细地址，例如：凌空二街56-1号，4单元2楼1号 **/
	@JsonProperty("receiverAreaInfo")
	@FieldMapping(desc = "收货人详细地址，例如：凌空二街56-1号，4单元2楼1号  ")
	private String receiverAreaInfo;

	/** 收货人联系电话 **/
	@JsonProperty("receiverTelephone")
	@FieldMapping(desc = "收货人联系电话 ")
	private String receiverTelephone;

	/** 收货人手机号码 **/
	@JsonProperty("receiverMobile")
	@FieldMapping(desc = "收货人手机号码 ")
	private String receiverMobile;

	@JsonProperty("igoExpressInfo")
	@FieldMapping(desc = "物流公司信息")
	private String igoExpressInfo;

	@JsonProperty("expressInfo")
	@FieldMapping(desc = "物流公司信息")
	private String expressInfo;

	@JsonProperty("expressCompanyId")
	@FieldMapping(desc = "物流公司id")
	private String expressCompanyId;

	/** 物流单号 **/
	@JsonProperty("igoShipCode")
	@FieldMapping(desc = "物流单号 ")
	private String igoShipCode;

	/** 发货时间 **/
	@JsonProperty("igoShipTime")
	@FieldMapping(desc = "发货时间 ")
	private Date igoShipTime;

	/** 发货说明 **/
	@JsonProperty("igoShipContent")
	@FieldMapping(desc = "发货说明")
	private String igoShipContent;

	@JsonProperty("igoList")
	@FieldMapping(desc = "礼品信息")
	private List<IGoBO> igoList;

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIgoOrderSn() {
		return igoOrderSn;
	}

	public void setIgoOrderSn(String igoOrderSn) {
		this.igoOrderSn = igoOrderSn;
	}

	public Integer getIgoStatus() {
		return igoStatus;
	}

	public void setIgoStatus(Integer igoStatus) {
		this.igoStatus = igoStatus;
	}

	public Integer getIgoTotalIntegral() {
		return igoTotalIntegral;
	}

	public void setIgoTotalIntegral(Integer igoTotalIntegral) {
		this.igoTotalIntegral = igoTotalIntegral;
	}

	public BigDecimal getIgoTransFee() {
		return igoTransFee;
	}

	public void setIgoTransFee(BigDecimal igoTransFee) {
		this.igoTransFee = igoTransFee;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public String getIgoPayment() {
		return igoPayment;
	}

	public void setIgoPayment(String igoPayment) {
		this.igoPayment = igoPayment;
	}

	public Date getIgoPayTime() {
		return igoPayTime;
	}

	public void setIgoPayTime(Date igoPayTime) {
		this.igoPayTime = igoPayTime;
	}

	public String getIgoMsg() {
		return igoMsg;
	}

	public void setIgoMsg(String igoMsg) {
		this.igoMsg = igoMsg;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverArea() {
		return receiverArea;
	}

	public void setReceiverArea(String receiverArea) {
		this.receiverArea = receiverArea;
	}

	public String getReceiverZip() {
		return receiverZip;
	}

	public void setReceiverZip(String receiverZip) {
		this.receiverZip = receiverZip;
	}

	public String getReceiverAreaInfo() {
		return receiverAreaInfo;
	}

	public void setReceiverAreaInfo(String receiverAreaInfo) {
		this.receiverAreaInfo = receiverAreaInfo;
	}

	public String getReceiverTelephone() {
		return receiverTelephone;
	}

	public void setReceiverTelephone(String receiverTelephone) {
		this.receiverTelephone = receiverTelephone;
	}

	public String getReceiverMobile() {
		return receiverMobile;
	}

	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile;
	}

	public String getIgoExpressInfo() {
		return igoExpressInfo;
	}

	public void setIgoExpressInfo(String igoExpressInfo) {
		this.igoExpressInfo = igoExpressInfo;
	}

	public String getIgoShipCode() {
		return igoShipCode;
	}

	public void setIgoShipCode(String igoShipCode) {
		this.igoShipCode = igoShipCode;
	}

	public Date getIgoShipTime() {
		return igoShipTime;
	}

	public void setIgoShipTime(Date igoShipTime) {
		this.igoShipTime = igoShipTime;
	}

	public String getIgoShipContent() {
		return igoShipContent;
	}

	public void setIgoShipContent(String igoShipContent) {
		this.igoShipContent = igoShipContent;
	}

	public String getExpressInfo() {
		return expressInfo;
	}

	public void setExpressInfo(String expressInfo) {
		this.expressInfo = expressInfo;
	}

	public List<IGoBO> getIgoList() {
		return igoList;
	}

	public void setIgoList(List<IGoBO> igoList) {
		this.igoList = igoList;
	}

	public String getExpressCompanyId() {
		return expressCompanyId;
	}

	public void setExpressCompanyId(String expressCompanyId) {
		this.expressCompanyId = expressCompanyId;
	}

}

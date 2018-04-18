package com.sinco.carnation.shop.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.math.BigDecimal;
import java.util.Date;

public class IntegralGoodsOrder extends BaseModel {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8432011012013432999L;

	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/**  **/
	private Boolean deleteStatus;

	/** 订单编号，以igo开头 **/
	private String igoOrderSn;

	/** 支付时间 **/
	private Date igoPayTime;

	/** 支付方式，使用mark标识 **/
	private String igoPayment;

	/** 物流单号 **/
	private String igoShipCode;

	/** 发货时间 **/
	private Date igoShipTime;

	/** 订单状态，0为已提交未付款，20为付款成功，30为已发货，40为已收货完成,-1为已经取消，此时不归还用户积分 **/
	private Integer igoStatus;

	/** 总共消费积分 **/
	private Integer igoTotalIntegral;

	/** 购物车运费 **/
	private BigDecimal igoTransFee;

	/** 收货人姓名,确认订单后，将买家的收货地址所有信息添加到订单中，该订单与买家收货地址没有任何关联 **/
	private String receiverName;

	/** 收货人地区,例如：辽宁省沈阳市铁西区 **/
	private String receiverArea;

	/** 收货人详细地址，例如：凌空二街56-1号，4单元2楼1号 **/
	private String receiverAreaInfo;

	/** 收货人手机号码 **/
	private String receiverMobile;

	/** 收货人联系电话 **/
	private String receiverTelephone;

	/** 收货人邮政编码 **/
	private String receiverZip;

	/** 订单用户 **/
	private Long igoUserId;

	/** 订单中商品信息，使用json管理[{id,5,goods_name,"adsfsd"}] **/
	private String goodsInfo;

	/**
	 * 物流公司信息json{"express_company_id":1,"express_company_name":"顺丰快递","express_company_mark":"shunfeng",
	 * "express_company_type":"EXPRESS"}
	 **/
	private String igoExpressInfo;

	/** 兑换附言 **/
	private String igoMsg;

	/** 支付说明 **/
	private String igoPayMsg;

	/** 发货说明 **/
	private String igoShipContent;

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

	public Boolean getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Boolean deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public String getIgoOrderSn() {
		return igoOrderSn;
	}

	public void setIgoOrderSn(String igoOrderSn) {
		this.igoOrderSn = igoOrderSn;
	}

	public Date getIgoPayTime() {
		return igoPayTime;
	}

	public void setIgoPayTime(Date igoPayTime) {
		this.igoPayTime = igoPayTime;
	}

	public String getIgoPayment() {
		return igoPayment;
	}

	public void setIgoPayment(String igoPayment) {
		this.igoPayment = igoPayment;
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

	public String getReceiverAreaInfo() {
		return receiverAreaInfo;
	}

	public void setReceiverAreaInfo(String receiverAreaInfo) {
		this.receiverAreaInfo = receiverAreaInfo;
	}

	public String getReceiverMobile() {
		return receiverMobile;
	}

	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile;
	}

	public String getReceiverTelephone() {
		return receiverTelephone;
	}

	public void setReceiverTelephone(String receiverTelephone) {
		this.receiverTelephone = receiverTelephone;
	}

	public String getReceiverZip() {
		return receiverZip;
	}

	public void setReceiverZip(String receiverZip) {
		this.receiverZip = receiverZip;
	}

	public Long getIgoUserId() {
		return igoUserId;
	}

	public void setIgoUserId(Long igoUserId) {
		this.igoUserId = igoUserId;
	}

	public String getGoodsInfo() {
		return goodsInfo;
	}

	public void setGoodsInfo(String goodsInfo) {
		this.goodsInfo = goodsInfo;
	}

	public String getIgoExpressInfo() {
		return igoExpressInfo;
	}

	public void setIgoExpressInfo(String igoExpressInfo) {
		this.igoExpressInfo = igoExpressInfo;
	}

	public String getIgoMsg() {
		return igoMsg;
	}

	public void setIgoMsg(String igoMsg) {
		this.igoMsg = igoMsg;
	}

	public String getIgoPayMsg() {
		return igoPayMsg;
	}

	public void setIgoPayMsg(String igoPayMsg) {
		this.igoPayMsg = igoPayMsg;
	}

	public String getIgoShipContent() {
		return igoShipContent;
	}

	public void setIgoShipContent(String igoShipContent) {
		this.igoShipContent = igoShipContent;
	}
}
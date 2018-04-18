package com.sinco.carnation.shop.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class FreeApplyLog extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1811497924423584398L;

	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/**  **/
	private Boolean deleteStatus;

	/** 0为待审核 5为申请通过 等待收货 -5申请失败 -10为过期作废 **/
	private Integer applyStatus;

	/** 是否已评价使用体验 默认为0未评价 1为已评价 2不可评价 **/
	private Integer evaluateStatus;

	/** 评价的时间 **/
	private Date evaluateTime;

	/** 申请的相关0元试用id **/
	private Long freeGoodsId;

	/** 0元试用名称 **/
	private String freeGoodsName;

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

	/** 快递单号 **/
	private String shipCode;

	/** 发货地址Id **/
	private Long shipAddrId;

	/** 卖家的店铺id **/
	private Long storeId;

	/** 申请者的id **/
	private Long userId;

	/** 申请者名称 **/
	private String userName;

	/** 是否为自营申请 **/
	private Integer whetherSelf;

	/** 申请原因 **/
	private String applyReason;

	/**
	 * 物流公司信息json{"express_company_id":1,"express_company_name":"顺丰快递","express_company_mark":"shunfeng",
	 * "express_company_type":"EXPRESS"}
	 **/
	private String expressInfo;

	/** 发货详细地址 **/
	private String shipAddr;

	/** 使用体验 **/
	private String useExperience;

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

	public Integer getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(Integer applyStatus) {
		this.applyStatus = applyStatus;
	}

	public Integer getEvaluateStatus() {
		return evaluateStatus;
	}

	public void setEvaluateStatus(Integer evaluateStatus) {
		this.evaluateStatus = evaluateStatus;
	}

	public Date getEvaluateTime() {
		return evaluateTime;
	}

	public void setEvaluateTime(Date evaluateTime) {
		this.evaluateTime = evaluateTime;
	}

	public Long getFreeGoodsId() {
		return freeGoodsId;
	}

	public void setFreeGoodsId(Long freeGoodsId) {
		this.freeGoodsId = freeGoodsId;
	}

	public String getFreeGoodsName() {
		return freeGoodsName;
	}

	public void setFreeGoodsName(String freeGoodsName) {
		this.freeGoodsName = freeGoodsName;
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

	public String getShipCode() {
		return shipCode;
	}

	public void setShipCode(String shipCode) {
		this.shipCode = shipCode;
	}

	public Long getShipAddrId() {
		return shipAddrId;
	}

	public void setShipAddrId(Long shipAddrId) {
		this.shipAddrId = shipAddrId;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getWhetherSelf() {
		return whetherSelf;
	}

	public void setWhetherSelf(Integer whetherSelf) {
		this.whetherSelf = whetherSelf;
	}

	public String getApplyReason() {
		return applyReason;
	}

	public void setApplyReason(String applyReason) {
		this.applyReason = applyReason;
	}

	public String getExpressInfo() {
		return expressInfo;
	}

	public void setExpressInfo(String expressInfo) {
		this.expressInfo = expressInfo;
	}

	public String getShipAddr() {
		return shipAddr;
	}

	public void setShipAddr(String shipAddr) {
		this.shipAddr = shipAddr;
	}

	public String getUseExperience() {
		return useExperience;
	}

	public void setUseExperience(String useExperience) {
		this.useExperience = useExperience;
	}
}
package com.sinco.carnation.user.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.math.BigDecimal;
import java.util.Date;

public class RebateRecord extends BaseModel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**  **/
    private Long id;

    /** 运营商id，有的话填，没有留空 **/
    private Long operatorId;

    /** 商户id **/
    private Long sellerUserId;

    /** 得到返润用户 **/
    private Long userId;

    /** 订单id **/
    private Long orderId;

    /**  **/
    private String rebateCode;

    /** 订单用户id **/
    private Long orderUserId;

    /** 消费码金额 **/
    private BigDecimal codeAmount;

    /** 返润状态：0未发放，1已发放 **/
    private String rebateStatus;

    /** 返利类型说明:101会员消费分润；102注册会员分润；103会员管理分润；104注册店分润A；105终端管理分润；106注册关联分润；107区级管理分润；108市级管理分润；109注册店分润B；110终端服务分润；111区级服务分润；112市级服务分润；201终端手续费分润；202区级手续费分润；203市级手续费分润；204手续费分润；301会员推荐返润；302店铺推荐返润 **/
    private String rebateType;

    /** 返润金额 **/
    private BigDecimal rebateAmount;

    /** 发放时间 **/
    private Date sendTime;

    /** 创建时间 **/
    private Date createTime;

    /** 用户角色:buyer,seller,operator **/
    private String userType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public Long getSellerUserId() {
        return sellerUserId;
    }

    public void setSellerUserId(Long sellerUserId) {
        this.sellerUserId = sellerUserId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getRebateCode() {
        return rebateCode;
    }

    public void setRebateCode(String rebateCode) {
        this.rebateCode = rebateCode;
    }

    public Long getOrderUserId() {
        return orderUserId;
    }

    public void setOrderUserId(Long orderUserId) {
        this.orderUserId = orderUserId;
    }

    public BigDecimal getCodeAmount() {
        return codeAmount;
    }

    public void setCodeAmount(BigDecimal codeAmount) {
        this.codeAmount = codeAmount;
    }

    public String getRebateStatus() {
        return rebateStatus;
    }

    public void setRebateStatus(String rebateStatus) {
        this.rebateStatus = rebateStatus;
    }

    public String getRebateType() {
        return rebateType;
    }

    public void setRebateType(String rebateType) {
        this.rebateType = rebateType;
    }

    public BigDecimal getRebateAmount() {
        return rebateAmount;
    }

    public void setRebateAmount(BigDecimal rebateAmount) {
        this.rebateAmount = rebateAmount;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
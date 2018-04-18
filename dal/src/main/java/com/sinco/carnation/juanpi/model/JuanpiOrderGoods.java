package com.sinco.carnation.juanpi.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.math.BigDecimal;
import java.util.Date;

public class JuanpiOrderGoods extends BaseModel {
	private static final long serialVersionUID = -2610854480709376092L;

	/**  **/
    private Long id;

    /** 商品新增时间 **/
    private Date addTime;

    /** 商品ID **/
    private Long goodsid;

    /** 商品标题 **/
    private String goodstitle;

    /** 商品数量 **/
    private Long goodsnumber;

    /** 商品总价 **/
    private BigDecimal goodsmoney;

    /** 当前结算比例 **/
    private BigDecimal brokerageratiocale;

    /** 商品可得佣金额 **/
    private BigDecimal commission;

    /** 云尚可得佣金额 **/
    private BigDecimal yunCommission;

    /** 1为待处理(订单正在进行)2为待结算3为已结算4为不可结算 **/
    private Integer status;

    /** 卷皮订单ID **/
    private Long orderId;

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

    public Long getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Long goodsid) {
        this.goodsid = goodsid;
    }

    public String getGoodstitle() {
        return goodstitle;
    }

    public void setGoodstitle(String goodstitle) {
        this.goodstitle = goodstitle;
    }

    public Long getGoodsnumber() {
        return goodsnumber;
    }

    public void setGoodsnumber(Long goodsnumber) {
        this.goodsnumber = goodsnumber;
    }

    public BigDecimal getGoodsmoney() {
        return goodsmoney;
    }

    public void setGoodsmoney(BigDecimal goodsmoney) {
        this.goodsmoney = goodsmoney;
    }

    public BigDecimal getBrokerageratiocale() {
        return brokerageratiocale;
    }

    public void setBrokerageratiocale(BigDecimal brokerageratiocale) {
        this.brokerageratiocale = brokerageratiocale;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public BigDecimal getYunCommission() {
        return yunCommission;
    }

    public void setYunCommission(BigDecimal yunCommission) {
        this.yunCommission = yunCommission;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
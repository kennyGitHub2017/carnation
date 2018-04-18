package com.sinco.carnation.shop.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.math.BigDecimal;
import java.util.Date;

public class ActivityGoods extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5756728164951851250L;

	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/**  **/
	private Boolean deleteStatus;

	/** 开始时间 **/
	private Date acBeginTime;

	/** 结束时间 **/
	private Date acEndTime;

	/** 铜牌会员折扣率 **/
	private BigDecimal acRebate;

	/** 银牌会员折扣率 **/
	private BigDecimal acRebate1;

	/** 金牌会员折扣率 **/
	private BigDecimal acRebate2;

	/** 超级会员折扣率 **/
	private BigDecimal acRebate3;

	/** 活动序号 **/
	private Integer acSequence;

	/** 活动状态，0为关闭，1为启动 **/
	private Integer acStatus;

	/** 活动标题 **/
	private String acTitle;

	/** 标题页面横幅,主图片最佳尺寸：950X320 **/
	private String acAcc;

	/** 活动专题页右侧图片,最佳尺寸250X320 **/
	private String acAcc2;

	/** 活动专题页右侧图片,最佳尺寸250X320 **/
	private String acAcc3;

	/** 活动说明 **/
	private String acContent;

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

	public Date getAcBeginTime() {
		return acBeginTime;
	}

	public void setAcBeginTime(Date acBeginTime) {
		this.acBeginTime = acBeginTime;
	}

	public Date getAcEndTime() {
		return acEndTime;
	}

	public void setAcEndTime(Date acEndTime) {
		this.acEndTime = acEndTime;
	}

	public BigDecimal getAcRebate() {
		return acRebate;
	}

	public void setAcRebate(BigDecimal acRebate) {
		this.acRebate = acRebate;
	}

	public BigDecimal getAcRebate1() {
		return acRebate1;
	}

	public void setAcRebate1(BigDecimal acRebate1) {
		this.acRebate1 = acRebate1;
	}

	public BigDecimal getAcRebate2() {
		return acRebate2;
	}

	public void setAcRebate2(BigDecimal acRebate2) {
		this.acRebate2 = acRebate2;
	}

	public BigDecimal getAcRebate3() {
		return acRebate3;
	}

	public void setAcRebate3(BigDecimal acRebate3) {
		this.acRebate3 = acRebate3;
	}

	public Integer getAcSequence() {
		return acSequence;
	}

	public void setAcSequence(Integer acSequence) {
		this.acSequence = acSequence;
	}

	public Integer getAcStatus() {
		return acStatus;
	}

	public void setAcStatus(Integer acStatus) {
		this.acStatus = acStatus;
	}

	public String getAcTitle() {
		return acTitle;
	}

	public void setAcTitle(String acTitle) {
		this.acTitle = acTitle;
	}

	public String getAcAcc() {
		return acAcc;
	}

	public void setAcAcc(String acAcc) {
		this.acAcc = acAcc;
	}

	public String getAcAcc2() {
		return acAcc2;
	}

	public void setAcAcc2(String acAcc2) {
		this.acAcc2 = acAcc2;
	}

	public String getAcAcc3() {
		return acAcc3;
	}

	public void setAcAcc3(String acAcc3) {
		this.acAcc3 = acAcc3;
	}

	public String getAcContent() {
		return acContent;
	}

	public void setAcContent(String acContent) {
		this.acContent = acContent;
	}
}
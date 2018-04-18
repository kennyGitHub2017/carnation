package com.sinco.carnation.o2o.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class StoreGroupAdjust extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3752675607425550829L;

	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/**  **/
	private Boolean deleteStatus;

	/** 所调整的主营类目 **/
	private String adjustGcMain;

	/** 所调整的主营类目id **/
	private Long adjustGcMainId;

	/** 类型，gc-调整经营类目， **/
	private String adjustType;

	/** 0-已成功提交申请，5-申请被拒绝 **/
	private Integer applyStatus;

	/** 店铺id **/
	private Long storeId;

	/** 店铺名称 **/
	private String storeName;

	/** 所要调整的经营类目信息， **/
	private String adjustGcInfo;

	/** 审核拒绝原因， **/
	private String refusedDesc;

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

	public String getAdjustGcMain() {
		return adjustGcMain;
	}

	public void setAdjustGcMain(String adjustGcMain) {
		this.adjustGcMain = adjustGcMain;
	}

	public Long getAdjustGcMainId() {
		return adjustGcMainId;
	}

	public void setAdjustGcMainId(Long adjustGcMainId) {
		this.adjustGcMainId = adjustGcMainId;
	}

	public String getAdjustType() {
		return adjustType;
	}

	public void setAdjustType(String adjustType) {
		this.adjustType = adjustType;
	}

	public Integer getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(Integer applyStatus) {
		this.applyStatus = applyStatus;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getAdjustGcInfo() {
		return adjustGcInfo;
	}

	public void setAdjustGcInfo(String adjustGcInfo) {
		this.adjustGcInfo = adjustGcInfo;
	}

	public String getRefusedDesc() {
		return refusedDesc;
	}

	public void setRefusedDesc(String refusedDesc) {
		this.refusedDesc = refusedDesc;
	}

}
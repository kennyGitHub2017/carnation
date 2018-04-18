package com.sinco.carnation.store.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class StoreAdjustInfo extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1858112533241146230L;

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

	/** 所调整的店铺等级id **/
	private Long adjustStoreGradeId;

	/** 所调整的店铺等级 **/
	private String adjustStoreGrade;

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

	public Long getAdjustStoreGradeId() {
		return adjustStoreGradeId;
	}

	public void setAdjustStoreGradeId(Long adjustStoreGradeId) {
		this.adjustStoreGradeId = adjustStoreGradeId;
	}

	public String getAdjustStoreGrade() {
		return adjustStoreGrade;
	}

	public void setAdjustStoreGrade(String adjustStoreGrade) {
		this.adjustStoreGrade = adjustStoreGrade;
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
}
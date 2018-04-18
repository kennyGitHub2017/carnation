package com.sinco.carnation.o2o.bo;

import java.math.BigDecimal;
import java.util.Date;

import com.sinco.carnation.o2o.model.GroupEvaluationStoreTotal;
import com.sinco.carnation.o2o.model.GroupGoods;
import com.sinco.carnation.store.model.Store;
import com.sinco.dic.client.annotation.DicMappingModel;
import com.sinco.dic.client.annotation.DicNameMapping;

/**
 * 
 * BO 用于返回数据
 * 
 */

@DicMappingModel
public class GroupGoodsBO extends GroupGoods {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6064223249160536353L;

	@DicNameMapping(type = GroupClassBO.class, codeField = "ggGcId", mergeChar = ">", isFull = true)
	private String groupClassName;
	private String nickName;
	private String mobile;
	private String orderId;
	private String groupSn;
	private String gcName;

	private Long fid;

	private Store store;
	private Integer status;
	private String storeName;
	private Date orderTime;
	private String storeAddress;
	/** 经度 **/
	private BigDecimal storeLat;
	/** 纬度 **/
	private BigDecimal storeLon;
	private Integer gradeId;// 店铺等级

	private Double distance;// 距离

	/** 用于存储多张图片，用|分隔 */
	private String imagePaths;
	private String licenseCTelephone;// 公司紧急联系人手机

	private Float evaluationAverage;// 服务评分
	/**
	 * 店铺服务评价
	 */
	private GroupEvaluationStoreTotal evaluationStoreTotal;
	private Date createTime;

	private String operatorCode;
	private String operatorName;

	/**
	 * "店铺电话"
	 */
	private String storeTelephone;

	/**
	 * 得到店铺总评价数
	 * 
	 * @return
	 */
	public int getStoreEvaluationCount() {
		int totalCount = 0;
		if (evaluationStoreTotal != null) {
			if (evaluationStoreTotal.getOne() != null) {
				totalCount += evaluationStoreTotal.getOne();
			}
			if (evaluationStoreTotal.getTwo() != null) {
				totalCount += evaluationStoreTotal.getTwo();
			}
			if (evaluationStoreTotal.getThree() != null) {
				totalCount += evaluationStoreTotal.getThree();
			}
			if (evaluationStoreTotal.getFour() != null) {
				totalCount += evaluationStoreTotal.getFour();
			}
			if (evaluationStoreTotal.getFive() != null) {
				totalCount += evaluationStoreTotal.getFive();
			}
		}
		return totalCount;
	}

	/**
	 * 得到店铺服务平均分
	 * 
	 * @return
	 */
	public Float getStoreEvaluationAverage() {
		float result = 5;

		if (evaluationStoreTotal != null) {
			int totalCount = 0;
			int totalScore = 0;
			if (evaluationStoreTotal.getOne() != null) {
				totalCount += evaluationStoreTotal.getOne();
				totalScore += evaluationStoreTotal.getOne();
			}
			if (evaluationStoreTotal.getTwo() != null) {
				totalScore += evaluationStoreTotal.getTwo() * 2;
				totalCount += evaluationStoreTotal.getTwo();
			}
			if (evaluationStoreTotal.getThree() != null) {
				totalScore += evaluationStoreTotal.getThree() * 3;
				totalCount += evaluationStoreTotal.getThree();
			}
			if (evaluationStoreTotal.getFour() != null) {
				totalScore += evaluationStoreTotal.getFour() * 4;
				totalCount += evaluationStoreTotal.getFour();
			}
			if (evaluationStoreTotal.getFive() != null) {
				totalScore += evaluationStoreTotal.getFive() * 5;
				totalCount += evaluationStoreTotal.getFive();
			}

			if (totalCount != 0) {
				result = totalScore / totalCount;
			}
		}
		return (float) (Math.round(result * 10)) / 10; // 结果保留一位小数点
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public String getImagePaths() {
		return imagePaths;
	}

	public void setImagePaths(String imagePaths) {
		this.imagePaths = imagePaths;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public String getGroupClassName() {
		return groupClassName;
	}

	public void setGroupClassName(String groupClassName) {
		this.groupClassName = groupClassName;
	}

	/**
	 * 得到是否过期
	 * 
	 * @return
	 */
	public Boolean getIsExpired() {
		if (this.getBeginTime().before(new Date()) && this.getEndTime().after(new Date())) {
			return false;
		}
		return true;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getMobile() {
		return mobile;
	}

	public Long getFid() {
		return fid;
	}

	public void setFid(Long fid) {
		this.fid = fid;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getGroupSn() {
		return groupSn;
	}

	public void setGroupSn(String groupSn) {
		this.groupSn = groupSn;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getGcName() {
		return gcName;
	}

	public void setGcName(String gcName) {
		this.gcName = gcName;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public BigDecimal getStoreLat() {
		return storeLat;
	}

	public void setStoreLat(BigDecimal storeLat) {
		this.storeLat = storeLat;
	}

	public BigDecimal getStoreLon() {
		return storeLon;
	}

	public void setStoreLon(BigDecimal storeLon) {
		this.storeLon = storeLon;
	}

	public Integer getGradeId() {
		return gradeId;
	}

	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}

	public String getLicenseCTelephone() {
		return licenseCTelephone;
	}

	public void setLicenseCTelephone(String licenseCTelephone) {
		this.licenseCTelephone = licenseCTelephone;
	}

	public GroupEvaluationStoreTotal getEvaluationStoreTotal() {
		return evaluationStoreTotal;
	}

	public void setEvaluationStoreTotal(GroupEvaluationStoreTotal evaluationStoreTotal) {
		this.evaluationStoreTotal = evaluationStoreTotal;
	}

	public Float getEvaluationAverage() {
		return evaluationAverage;
	}

	public void setEvaluationAverage(Float evaluationAverage) {
		this.evaluationAverage = evaluationAverage;
	}

	public String getOperatorCode() {
		return operatorCode;
	}

	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getStoreTelephone() {
		return storeTelephone;
	}

	public void setStoreTelephone(String storeTelephone) {
		this.storeTelephone = storeTelephone;
	}

}
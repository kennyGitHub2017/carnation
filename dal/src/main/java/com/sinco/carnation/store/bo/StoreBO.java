package com.sinco.carnation.store.bo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.sinco.carnation.o2o.bo.GroupClassBO;
import com.sinco.carnation.o2o.model.GroupEvaluationStoreTotal;
import com.sinco.carnation.store.model.Store;
import com.sinco.carnation.store.model.StorePoint;
import com.sinco.carnation.store.model.StoreSlide;
import com.sinco.carnation.sys.model.Area;
import com.sinco.dic.client.annotation.DicMappingModel;
import com.sinco.dic.client.annotation.DicNameMapping;

/**
 * BO 用于返回数据
 */
@DicMappingModel
public class StoreBO extends Store {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6249468630426932749L;

	private String gradeName;
	private String gradeContent;

	@DicNameMapping(type = GroupClassBO.class, codeField = "groupMainId", mergeChar = "", isFull = true)
	private String gcName;
	@DicNameMapping(type = Area.class, codeField = "areaId", mergeChar = "-", isFull = true)
	private String areaName;
	private String parentAreaName;
	private String name;// 店主姓名
	private String userName;// 店主用户名
	private String nickname;// 店主昵称
	private String telephone;// 店主电话
	private String email;// 店主邮件
	private String licenseAreaInfo;// 营业执照所在地
	private String licenseCAreaInfo;// 公司所在地
	@DicNameMapping(codeField = "bankAreaId", isFull = true, mergeChar = "", type = Area.class)
	private String bankAreaInfo; // 开户银行支行所在地
	@DicNameMapping(codeField = "areaId", isFull = true, mergeChar = "", type = Area.class)
	private String areaInfo; // 店铺所在地
	private StorePoint point;
	private String loginName;
	private BigDecimal storeEvaluate;// 店铺综合评分
	private int num;// 店铺商品数量
	private List<StoreSlide> slides;
	private String operatorCode;// 隶属运营商编号
	private String operatorName;
	private String operatorPhone;
	private String operatorUserName;
	private String operatorAreaId;
	@DicNameMapping(type = Area.class, codeField = "operatorAreaId", mergeChar = "-", isFull = true)
	private String operatorAreaName;
	private BigDecimal couponPayAmount;// 劵销售总额
	private BigDecimal chargePayAmount;// 刷卡销售额
	private BigDecimal rebateAmount;// 消费返润总额
	private String failReseaon;// 商户申请失败原因
	private String licenseBusinessScope;// 经营范围
	private Double distance;// 距离
	private Float evaluationAverage;// 服务评分
	private Long uid;
	private String area;// 地区
	private BigDecimal storeLat;
	private BigDecimal storeLon;
	private String storeTelephone;// 店铺电话RE
	private String invitatCode;// 店铺邀请码
	private String licenseCDesc;// 公司简介
	private BigDecimal rebateConsumeAmount;// 商户返润
	private BigDecimal rebateFeeAmount;// 手续费返润
	private Long storeId;// 商户id
	private String is_o2o;
	private String licenseCName;// 营业执照公司名称

	private String licenseCContact; // 联系人姓名
	private String licenseLegalName;// 法人姓名
	private String licenseLegalIdCard;// 法人身份证号码
	private String licenseLegalIdCardFrontPath;// 法人身份证正面照片
	private String licenseLegalIdCardBackPath;// 法人身份证反面照片
	private String licenseImagePath;// 营业执照
	private String otherPhotoPath;// 其他图片
	private String organizationImagePath;// 供应商 申请存放授权书
	private String industry;// 所属行业

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getIs_o2o() {
		return is_o2o;
	}

	public void setIs_o2o(String is_o2o) {
		this.is_o2o = is_o2o;
	}

	/**
	 * 环境图片路径
	 */
	private String storeInfoPath;

	/**
	 * 店铺服务评价
	 */
	private GroupEvaluationStoreTotal evaluationStoreTotal;

	// 用户昵称
	private String nickName;
	private Date createTime;

	private String className;
	private String mobile;

	private Long operatorId;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getOperatorAreaName() {
		return operatorAreaName;
	}

	public void setOperatorAreaName(String operatorAreaName) {
		this.operatorAreaName = operatorAreaName;
	}

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
		float result = 0;

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
			}else{
				result=5;
			}
		}else{
			result=5;
		}
		return (float) (Math.round(result * 10)) / 10; // 结果保留一位小数点
	}

	public String getOperatorPhone() {
		return operatorPhone;
	}

	public void setOperatorPhone(String operatorPhone) {
		this.operatorPhone = operatorPhone;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getOperatorUserName() {
		return operatorUserName;
	}

	public void setOperatorUserName(String operatorUserName) {
		this.operatorUserName = operatorUserName;
	}

	public String getOperatorAreaId() {
		return operatorAreaId;
	}

	public void setOperatorAreaId(String operatorAreaId) {
		this.operatorAreaId = operatorAreaId;
	}

	public String getStoreInfoPath() {
		return storeInfoPath;
	}

	public void setStoreInfoPath(String storeInfoPath) {
		this.storeInfoPath = storeInfoPath;
	}

	public String getGcName() {
		return gcName;
	}

	public void setGcName(String gcName) {
		this.gcName = gcName;
	}

	public GroupEvaluationStoreTotal getEvaluationStoreTotal() {
		return evaluationStoreTotal;
	}

	public void setEvaluationStoreTotal(GroupEvaluationStoreTotal evaluationStoreTotal) {
		this.evaluationStoreTotal = evaluationStoreTotal;
	}

	public List<StoreSlide> getSlides() {
		return slides;
	}

	public void setSlides(List<StoreSlide> slides) {
		this.slides = slides;
	}

	public StorePoint getPoint() {
		return point;
	}

	public void setPoint(StorePoint point) {
		this.point = point;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getParentAreaName() {
		return parentAreaName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public void setParentAreaName(String parentAreaName) {
		this.parentAreaName = parentAreaName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLicenseAreaInfo() {
		return licenseAreaInfo;
	}

	public void setLicenseAreaInfo(String licenseAreaInfo) {
		this.licenseAreaInfo = licenseAreaInfo;
	}

	public String getLicenseCAreaInfo() {
		return licenseCAreaInfo;
	}

	public void setLicenseCAreaInfo(String licenseCAreaInfo) {
		this.licenseCAreaInfo = licenseCAreaInfo;
	}

	public String getBankAreaInfo() {
		return bankAreaInfo;
	}

	public void setBankAreaInfo(String bankAreaInfo) {
		this.bankAreaInfo = bankAreaInfo;
	}

	public String getAreaInfo() {
		return areaInfo;
	}

	public void setAreaInfo(String areaInfo) {
		this.areaInfo = areaInfo;
	}

	public String getGradeContent() {
		return gradeContent;
	}

	public void setGradeContent(String gradeContent) {
		this.gradeContent = gradeContent;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public BigDecimal getStoreEvaluate() {
		return storeEvaluate;
	}

	public void setStoreEvaluate(BigDecimal storeEvaluate) {
		this.storeEvaluate = storeEvaluate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getOperatorCode() {
		return operatorCode;
	}

	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}

	public BigDecimal getCouponPayAmount() {
		return couponPayAmount;
	}

	public void setCouponPayAmount(BigDecimal couponPayAmount) {
		this.couponPayAmount = couponPayAmount;
	}

	public BigDecimal getChargePayAmount() {
		return chargePayAmount;
	}

	public void setChargePayAmount(BigDecimal chargePayAmount) {
		this.chargePayAmount = chargePayAmount;
	}

	public BigDecimal getRebateAmount() {
		return rebateAmount;
	}

	public void setRebateAmount(BigDecimal rebateAmount) {
		this.rebateAmount = rebateAmount;
	}

	public String getFailReseaon() {
		return failReseaon;
	}

	public void setFailReseaon(String failReseaon) {
		this.failReseaon = failReseaon;
	}

	public String getLicenseBusinessScope() {
		return licenseBusinessScope;
	}

	public void setLicenseBusinessScope(String licenseBusinessScope) {
		this.licenseBusinessScope = licenseBusinessScope;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Float getEvaluationAverage() {
		return evaluationAverage;
	}

	public void setEvaluationAverage(Float evaluationAverage) {
		this.evaluationAverage = evaluationAverage;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
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

	public String getStoreTelephone() {
		return storeTelephone;
	}

	public void setStoreTelephone(String storeTelephone) {
		this.storeTelephone = storeTelephone;
	}

	public String getInvitatCode() {
		return invitatCode;
	}

	public void setInvitatCode(String invitatCode) {
		this.invitatCode = invitatCode;
	}

	public String getLicenseCDesc() {
		return licenseCDesc;
	}

	public void setLicenseCDesc(String licenseCDesc) {
		this.licenseCDesc = licenseCDesc;
	}

	public BigDecimal getRebateConsumeAmount() {
		return rebateConsumeAmount;
	}

	public void setRebateConsumeAmount(BigDecimal rebateConsumeAmount) {
		this.rebateConsumeAmount = rebateConsumeAmount;
	}

	public BigDecimal getRebateFeeAmount() {
		return rebateFeeAmount;
	}

	public void setRebateFeeAmount(BigDecimal rebateFeeAmount) {
		this.rebateFeeAmount = rebateFeeAmount;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Long getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	public String getLicenseCName() {
		return licenseCName;
	}

	public void setLicenseCName(String licenseCName) {
		this.licenseCName = licenseCName;
	}

	public String getLicenseCContact() {
		return licenseCContact;
	}

	public void setLicenseCContact(String licenseCContact) {
		this.licenseCContact = licenseCContact;
	}

	public String getLicenseLegalName() {
		return licenseLegalName;
	}

	public void setLicenseLegalName(String licenseLegalName) {
		this.licenseLegalName = licenseLegalName;
	}

	public String getLicenseLegalIdCard() {
		return licenseLegalIdCard;
	}

	public void setLicenseLegalIdCard(String licenseLegalIdCard) {
		this.licenseLegalIdCard = licenseLegalIdCard;
	}

	public String getLicenseLegalIdCardFrontPath() {
		return licenseLegalIdCardFrontPath;
	}

	public void setLicenseLegalIdCardFrontPath(String licenseLegalIdCardFrontPath) {
		this.licenseLegalIdCardFrontPath = licenseLegalIdCardFrontPath;
	}

	public String getLicenseImagePath() {
		return licenseImagePath;
	}

	public void setLicenseImagePath(String licenseImagePath) {
		this.licenseImagePath = licenseImagePath;
	}

	public String getOtherPhotoPath() {
		return otherPhotoPath;
	}

	public void setOtherPhotoPath(String otherPhotoPath) {
		this.otherPhotoPath = otherPhotoPath;
	}

	public String getLicenseLegalIdCardBackPath() {
		return licenseLegalIdCardBackPath;
	}

	public void setLicenseLegalIdCardBackPath(String licenseLegalIdCardBackPath) {
		this.licenseLegalIdCardBackPath = licenseLegalIdCardBackPath;
	}

	public String getOrganizationImagePath() {
		return organizationImagePath;
	}

	public void setOrganizationImagePath(String organizationImagePath) {
		this.organizationImagePath = organizationImagePath;
	}





}
package com.sinco.carnation.store.vo;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.sinco.carnation.sys.model.Area;
import com.sinco.dic.client.annotation.DicMappingModel;
import com.sinco.dic.client.annotation.DicNameMapping;

@DicMappingModel
public class StoreVO {

	@DicNameMapping(type = Area.class, codeField = "areaId", mergeChar = "-", isFull = true)
	private String areaName;

	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/**  **/
	private Boolean deleteStatus;

	/** 银行开户名 **/
	private String bankAccountName;

	/** 公司银行账号 **/
	private String bankCAccount;

	/** 银行联行号 **/
	private String bankLineNum;

	/** 开户行支行名称 **/
	private String bankName;

	/** 满就送套餐结束时间 **/
	private Date buygiftMealEndTime;

	/** 组合销售套餐结束日期 **/
	private Date combinEndTime;

	/** 店铺二级域名修改次数，受商城设置影响 **/
	private Integer domainModifyCount;

	/** 满就减套餐结束时间 **/
	private Date enoughreduceMealEndTime;

	/** 店铺收藏人气 **/
	private Integer favoriteCount;

	/** 主营类目Id，当店铺只经营主营类目时（商城1级分类），商家发布商品时可以选择该类目下的所有分类 **/
	private Long gcMainId;

	/** 团购套餐结束时间 **/
	private Date groupMealEndTime;

	/** 营业执照详细地址 **/
	private String licenseAddress;

	/** 经营范围 **/
	private String licenseBusinessScope;

	/** 公司详细地址 **/
	private String licenseCAddress;

	/** 公司紧急联系人 **/
	private String licenseCContact;

	/** 公司紧急联系人手机 **/
	private String licenseCMobile;

	/** 营业执照上公司名称 **/
	private String licenseCName;

	/** 公司电话 **/
	private String licenseCTelephone;

	/** 营业期限结束时间 **/
	private Date licenseEndDate;

	/** 营业执照上成立日期 **/
	private Date licenseEstablishDate;

	/** 法人身份证号 **/
	private String licenseLegalIdCard;

	/** 法人姓名 **/
	private String licenseLegalName;

	/** 营业执照号 **/
	private String licenseNum;

	/** 注册资金 **/
	private String licenseRegCapital;

	/** 营业期限开始时间 **/
	private Date licenseStartDate;

	/** 组织机构代码证 **/
	private String organizationCode;

	/** 店铺发送的邮件数量 **/
	private Integer sendEmailCount;

	/** 店铺发送的短信数量 **/
	private Integer sendSmsCount;

	/** 店铺详细地址 **/
	private String storeAddress;

	/** 店铺本次结算总佣金,生成账单时增加，结算账单完成时减少 **/
	private BigDecimal storeCommissionAmount;

	/** 店铺等级，根据好评数累加 **/
	private Integer storeCredit;

	/** 保存后的信息，需要在店铺装修页面点击保存按钮， **/
	private String storeDecorateOldTheme;

	/**
	 * 店铺装修主题信息，不存在时使用默认主题（default）,共7个店铺主题，default(默认)，black(黑色),blue(蓝色),green
	 * (绿色),orange(橘黄),pink(粉色),purple(紫色),
	 **/
	private String storeDecorateTheme;

	/** 店铺当前拥有邮件数量 **/
	private Integer storeEmailCount;

	/**  **/
	private String storeMsn;

	/** 店铺名称 **/
	private String storeName;

	/** 店主真实姓名 **/
	private String storeOwer;

	/** 店主身份证号 **/
	private String storeOwerCard;

	/** 店铺本次结算总结算金额,生成账单时增加，结算账单完成时减少 **/
	private BigDecimal storePayoffAmount;

	/** 店铺qq **/
	private String storeQq;

	/** 是否被推荐 **/
	private Boolean storeRecommend;

	/** 店铺推荐时间,根据推荐时间倒序显示明星店铺 **/
	private Date storeRecommendTime;

	/** 店铺本次结算总销售金额，生成账单时总销售金额增加，账单结算完成后总结算金额减少 **/
	private BigDecimal storeSaleAmount;

	/** 店铺二级域名 **/
	private String storeSecondDomain;

	/** 店铺当前拥有短信数量 **/
	private Integer storeSmsCount;

	/** 管理员审核店铺通过的时间，即店铺开店时间 **/
	private Date storeStartTime;

	/** 店铺电话号码 **/
	private String storeTelephone;

	/**  **/
	private String storeWw;

	/** 店铺邮编 **/
	private String storeZip;

	/** 纳税人识别号 **/
	private String taxCode;

	/** 纳税人类型 **/
	private String taxType;

	/** 纳税人类型识别码 **/
	private String taxTypeCode;

	/** 店铺有效期，用在收费店铺等级，超过有效期，自动将为免费店铺,为空时表示无限期 **/
	private Date validity;

	/** 店铺地址，这里保存的是最底层地址 **/
	private Long areaId;

	/** 开户行所在地 **/
	private Long bankAreaId;

	/** 银行开户许可证电子版 **/
	private Long bankPermitImageId;

	/** 认证身份证 **/
	private Long cardId;

	/** 店铺等级 **/
	private Long gradeId;

	/** 营业执照所在地 **/
	private Long licenseAreaId;

	/** 公司所在地 **/
	private Long licenseCAreaId;

	/** 营业执照副本电子版 **/
	private Long licenseImageId;

	/** 法人身份证号 **/
	private Long licenseLegalIdcardImageId;

	/** 组织机构代码证电子版 **/
	private Long organizationImageId;

	/** 店铺banner **/
	private Long storeBannerId;

	/** 店铺营业执照 **/
	private Long storeLicenseId;

	/** 店铺logo **/
	private String storeLogoPath;

	/** 一般纳税人资格证电子版 **/
	private Long taxGeneralCardId;

	/** 税务登记证电子版 **/
	private Long taxRegCardId;

	/**
	 * 店铺经营类，[{"gc_list":[2, 8, 3, 6, 7, 5],"m_id":1}]，当店铺申请店铺时选择了详细类目，商家发布商品时只可选择所有的详细类目
	 **/
	private String gcDetailInfo;

	/**
	 * 店铺短信邮件功能设置信息，使用json管理[{"id":1,"title":"买家申请退货通知 ","mark": "email_toseller_order_return_apply_notify "
	 * ,"sms_count":0,"email_count":0,"sms_open":1,"email_open":0},{},{}],id，
	 * 对应系统模板id，mark为模板标识，当使用id查询不到模板时使用mark查询，sms_count为该功能已发短信数量， sms_open为该功能短信是否开启,0关闭，1开启
	 **/
	private String smsEmailInfo;

	/**
	 * 店铺装修背景设置信息{"bg_img_id":"1","bg_img_src":"upload/store/123asdfsadf.jpg",
	 * "bg_color":"black","repeat":"repeat"}
	 **/
	private String storeDecorateBackgroundInfo;

	/** 保存后的信息，需要在店铺装修页面点击保存按钮， **/
	private String storeDecorateBackgroundOldInfo;

	/**
	 * 店铺装修基础模块信息，店铺基础模块不可编辑，可以设置是否显示，基础模块包括：店铺banner、店铺头部右侧店铺信息，店铺通栏导航、使用json管理
	 * [{"store_head_right":"true"},{"store_head_right":"false"}]
	 **/
	private String storeDecorateBaseInfo;

	/** 保存后的信息，需要在店铺装修页面点击保存按钮， **/
	private String storeDecorateBaseOldInfo;

	/** 店铺装修信息，使用json管理[{},{}]，装修完成后与老装修信息一致，用于预览 **/
	private String storeDecorateInfo;

	/** 店铺装修信息，老的店铺装修信息，当用户撤销刚刚装修的店铺信息时，返回老的店铺装修信息, **/
	private String storeDecorateOldInfo;

	/** 店铺介绍 **/
	private String storeInfo;

	/**
	 * 用户店铺快捷菜单，使用json管理[{"menu_name":"商品分类",,"menu_url","xxxx.htm"},{
	 * "menu_name":"商品分类",,"menu_url","xxxx.htm"}]
	 **/
	private String storeQuickMenu;

	/** 店铺SEO描述 **/
	private String storeSeoDescription;

	/** 店铺SEO关键字 **/
	private String storeSeoKeywords;

	/** 违规原因 **/
	private String violationReseaon;

	private Long uid;

	private String validityStr;

	private String loginName;

	private Integer storeStatus;

	/** 是否商城店铺 **/
	private Boolean isShop;
	/** 是否服务店铺 **/
	private Boolean isO2o;
	/** 是否安装POS机 **/
	private Boolean isEepay;

	/** 经度 **/
	private BigDecimal storeLat;

	/** 纬度 **/
	private BigDecimal storeLon;

	/** 主营类目 */
	private String groupMainId;

	/** 机具编码 **/
	private String implementNumber;

	/** 机具类型 **/
	private Integer posType;

	/** 联行行号 **/
	private String lineNumber;

	/** 签约密码 **/
	private String password;

	/** 营运商用户id **/
	private Long operatorUserId;

	/** 营运商级别 **/
	private Integer level;

	/** 开始时间 **/
	private String startTime;

	/** 结束时间 **/
	private String endTime;

	/****/
	private Integer isBeLong;

	/** 营运商id **/
	private Long operatorId;

	/** 刷卡机mid **/
	private String eepayMid;

	/** 刷卡机key **/
	private String eepayKey;

	private Long gcMainIdClone;

	private Long operatorAreaId;

	private String mobile;

	private String beginTimeStr;

	private String endTimeStr;

	private String operatorCode;
	private String operatorName;
	private String operatorPhone;
	private Integer ownType;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Long getGcMainIdClone() {
		return gcMainIdClone;
	}

	public void setGcMainIdClone(Long gcMainIdClone) {
		this.gcMainIdClone = gcMainIdClone;
	}

	public String getEepayMid() {
		return eepayMid;
	}

	public void setEepayMid(String eepayMid) {
		this.eepayMid = eepayMid;
	}

	public String getEepayKey() {
		return eepayKey;
	}

	public void setEepayKey(String eepayKey) {
		this.eepayKey = eepayKey;
	}

	public String getGroupMainId() {
		return groupMainId;
	}

	public void setGroupMainId(String groupMainId) {
		this.groupMainId = groupMainId;
	}

	public Integer getStoreStatus() {
		return storeStatus;
	}

	public void setStoreStatus(Integer storeStatus) {
		this.storeStatus = storeStatus;
	}

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

	public String getBankAccountName() {
		return bankAccountName;
	}

	public void setBankAccountName(String bankAccountName) {
		this.bankAccountName = bankAccountName;
	}

	public String getBankCAccount() {
		return bankCAccount;
	}

	public void setBankCAccount(String bankCAccount) {
		this.bankCAccount = bankCAccount;
	}

	public String getBankLineNum() {
		return bankLineNum;
	}

	public void setBankLineNum(String bankLineNum) {
		this.bankLineNum = bankLineNum;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Date getBuygiftMealEndTime() {
		return buygiftMealEndTime;
	}

	public void setBuygiftMealEndTime(Date buygiftMealEndTime) {
		this.buygiftMealEndTime = buygiftMealEndTime;
	}

	public Date getCombinEndTime() {
		return combinEndTime;
	}

	public void setCombinEndTime(Date combinEndTime) {
		this.combinEndTime = combinEndTime;
	}

	public Integer getDomainModifyCount() {
		return domainModifyCount;
	}

	public void setDomainModifyCount(Integer domainModifyCount) {
		this.domainModifyCount = domainModifyCount;
	}

	public Date getEnoughreduceMealEndTime() {
		return enoughreduceMealEndTime;
	}

	public void setEnoughreduceMealEndTime(Date enoughreduceMealEndTime) {
		this.enoughreduceMealEndTime = enoughreduceMealEndTime;
	}

	public Integer getFavoriteCount() {
		return favoriteCount;
	}

	public void setFavoriteCount(Integer favoriteCount) {
		this.favoriteCount = favoriteCount;
	}

	public Long getGcMainId() {
		return gcMainId;
	}

	public void setGcMainId(Long gcMainId) {
		this.gcMainId = gcMainId;
	}

	public Date getGroupMealEndTime() {
		return groupMealEndTime;
	}

	public void setGroupMealEndTime(Date groupMealEndTime) {
		this.groupMealEndTime = groupMealEndTime;
	}

	public String getLicenseAddress() {
		return licenseAddress;
	}

	public void setLicenseAddress(String licenseAddress) {
		this.licenseAddress = licenseAddress;
	}

	public String getLicenseBusinessScope() {
		return licenseBusinessScope;
	}

	public void setLicenseBusinessScope(String licenseBusinessScope) {
		this.licenseBusinessScope = licenseBusinessScope;
	}

	public String getLicenseCAddress() {
		return licenseCAddress;
	}

	public void setLicenseCAddress(String licenseCAddress) {
		this.licenseCAddress = licenseCAddress;
	}

	public String getLicenseCContact() {
		return licenseCContact;
	}

	public void setLicenseCContact(String licenseCContact) {
		this.licenseCContact = licenseCContact;
	}

	public String getLicenseCMobile() {
		return licenseCMobile;
	}

	public void setLicenseCMobile(String licenseCMobile) {
		this.licenseCMobile = licenseCMobile;
	}

	public String getLicenseCName() {
		return licenseCName;
	}

	public void setLicenseCName(String licenseCName) {
		this.licenseCName = licenseCName;
	}

	public String getLicenseCTelephone() {
		return licenseCTelephone;
	}

	public void setLicenseCTelephone(String licenseCTelephone) {
		this.licenseCTelephone = licenseCTelephone;
	}

	public Date getLicenseEndDate() {
		return licenseEndDate;
	}

	public void setLicenseEndDate(Date licenseEndDate) {
		this.licenseEndDate = licenseEndDate;
	}

	public Date getLicenseEstablishDate() {
		return licenseEstablishDate;
	}

	public void setLicenseEstablishDate(Date licenseEstablishDate) {
		this.licenseEstablishDate = licenseEstablishDate;
	}

	public String getLicenseLegalIdCard() {
		return licenseLegalIdCard;
	}

	public void setLicenseLegalIdCard(String licenseLegalIdCard) {
		this.licenseLegalIdCard = licenseLegalIdCard;
	}

	public String getLicenseLegalName() {
		return licenseLegalName;
	}

	public void setLicenseLegalName(String licenseLegalName) {
		this.licenseLegalName = licenseLegalName;
	}

	public String getLicenseNum() {
		return licenseNum;
	}

	public void setLicenseNum(String licenseNum) {
		this.licenseNum = licenseNum;
	}

	public String getLicenseRegCapital() {
		return licenseRegCapital;
	}

	public void setLicenseRegCapital(String licenseRegCapital) {
		this.licenseRegCapital = licenseRegCapital;
	}

	public Date getLicenseStartDate() {
		return licenseStartDate;
	}

	public void setLicenseStartDate(Date licenseStartDate) {
		this.licenseStartDate = licenseStartDate;
	}

	public String getOrganizationCode() {
		return organizationCode;
	}

	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}

	public Integer getSendEmailCount() {
		return sendEmailCount;
	}

	public void setSendEmailCount(Integer sendEmailCount) {
		this.sendEmailCount = sendEmailCount;
	}

	public Integer getSendSmsCount() {
		return sendSmsCount;
	}

	public void setSendSmsCount(Integer sendSmsCount) {
		this.sendSmsCount = sendSmsCount;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public BigDecimal getStoreCommissionAmount() {
		return storeCommissionAmount;
	}

	public void setStoreCommissionAmount(BigDecimal storeCommissionAmount) {
		this.storeCommissionAmount = storeCommissionAmount;
	}

	public Integer getStoreCredit() {
		return storeCredit;
	}

	public void setStoreCredit(Integer storeCredit) {
		this.storeCredit = storeCredit;
	}

	public String getStoreDecorateOldTheme() {
		return storeDecorateOldTheme;
	}

	public void setStoreDecorateOldTheme(String storeDecorateOldTheme) {
		this.storeDecorateOldTheme = storeDecorateOldTheme;
	}

	public String getStoreDecorateTheme() {
		return storeDecorateTheme;
	}

	public void setStoreDecorateTheme(String storeDecorateTheme) {
		this.storeDecorateTheme = storeDecorateTheme;
	}

	public Integer getStoreEmailCount() {
		return storeEmailCount;
	}

	public void setStoreEmailCount(Integer storeEmailCount) {
		this.storeEmailCount = storeEmailCount;
	}

	public String getStoreMsn() {
		return storeMsn;
	}

	public void setStoreMsn(String storeMsn) {
		this.storeMsn = storeMsn;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreOwer() {
		return storeOwer;
	}

	public void setStoreOwer(String storeOwer) {
		this.storeOwer = storeOwer;
	}

	public String getStoreOwerCard() {
		return storeOwerCard;
	}

	public void setStoreOwerCard(String storeOwerCard) {
		this.storeOwerCard = storeOwerCard;
	}

	public BigDecimal getStorePayoffAmount() {
		return storePayoffAmount;
	}

	public void setStorePayoffAmount(BigDecimal storePayoffAmount) {
		this.storePayoffAmount = storePayoffAmount;
	}

	public String getStoreQq() {
		return storeQq;
	}

	public void setStoreQq(String storeQq) {
		this.storeQq = storeQq;
	}

	public Boolean getStoreRecommend() {
		return storeRecommend;
	}

	public void setStoreRecommend(Boolean storeRecommend) {
		this.storeRecommend = storeRecommend;
	}

	public Date getStoreRecommendTime() {
		return storeRecommendTime;
	}

	public void setStoreRecommendTime(Date storeRecommendTime) {
		this.storeRecommendTime = storeRecommendTime;
	}

	public BigDecimal getStoreSaleAmount() {
		return storeSaleAmount;
	}

	public void setStoreSaleAmount(BigDecimal storeSaleAmount) {
		this.storeSaleAmount = storeSaleAmount;
	}

	public String getStoreSecondDomain() {
		return storeSecondDomain;
	}

	public void setStoreSecondDomain(String storeSecondDomain) {
		this.storeSecondDomain = storeSecondDomain;
	}

	public Integer getStoreSmsCount() {
		return storeSmsCount;
	}

	public void setStoreSmsCount(Integer storeSmsCount) {
		this.storeSmsCount = storeSmsCount;
	}

	public Date getStoreStartTime() {
		return storeStartTime;
	}

	public void setStoreStartTime(Date storeStartTime) {
		this.storeStartTime = storeStartTime;
	}

	public String getStoreLogoPath() {
		return storeLogoPath;
	}

	public void setStoreLogoPath(String storeLogoPath) {
		this.storeLogoPath = storeLogoPath;
	}

	public String getStoreTelephone() {
		return storeTelephone;
	}

	public void setStoreTelephone(String storeTelephone) {
		this.storeTelephone = storeTelephone;
	}

	public String getStoreWw() {
		return storeWw;
	}

	public void setStoreWw(String storeWw) {
		this.storeWw = storeWw;
	}

	public String getStoreZip() {
		return storeZip;
	}

	public void setStoreZip(String storeZip) {
		this.storeZip = storeZip;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public String getTaxType() {
		return taxType;
	}

	public void setTaxType(String taxType) {
		this.taxType = taxType;
	}

	public String getTaxTypeCode() {
		return taxTypeCode;
	}

	public void setTaxTypeCode(String taxTypeCode) {
		this.taxTypeCode = taxTypeCode;
	}

	public Date getValidity() {
		return validity;
	}

	public void setValidity(Date validity) {
		this.validity = validity;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public Long getBankAreaId() {
		return bankAreaId;
	}

	public void setBankAreaId(Long bankAreaId) {
		this.bankAreaId = bankAreaId;
	}

	public Long getBankPermitImageId() {
		return bankPermitImageId;
	}

	public void setBankPermitImageId(Long bankPermitImageId) {
		this.bankPermitImageId = bankPermitImageId;
	}

	public Long getCardId() {
		return cardId;
	}

	public void setCardId(Long cardId) {
		this.cardId = cardId;
	}

	public Long getGradeId() {
		return gradeId;
	}

	public void setGradeId(Long gradeId) {
		this.gradeId = gradeId;
	}

	public Long getLicenseAreaId() {
		return licenseAreaId;
	}

	public void setLicenseAreaId(Long licenseAreaId) {
		this.licenseAreaId = licenseAreaId;
	}

	public Long getLicenseCAreaId() {
		return licenseCAreaId;
	}

	public void setLicenseCAreaId(Long licenseCAreaId) {
		this.licenseCAreaId = licenseCAreaId;
	}

	public Long getLicenseImageId() {
		return licenseImageId;
	}

	public void setLicenseImageId(Long licenseImageId) {
		this.licenseImageId = licenseImageId;
	}

	public Long getLicenseLegalIdcardImageId() {
		return licenseLegalIdcardImageId;
	}

	public void setLicenseLegalIdcardImageId(Long licenseLegalIdcardImageId) {
		this.licenseLegalIdcardImageId = licenseLegalIdcardImageId;
	}

	public Long getOrganizationImageId() {
		return organizationImageId;
	}

	public void setOrganizationImageId(Long organizationImageId) {
		this.organizationImageId = organizationImageId;
	}

	public Long getStoreBannerId() {
		return storeBannerId;
	}

	public void setStoreBannerId(Long storeBannerId) {
		this.storeBannerId = storeBannerId;
	}

	public Long getStoreLicenseId() {
		return storeLicenseId;
	}

	public void setStoreLicenseId(Long storeLicenseId) {
		this.storeLicenseId = storeLicenseId;
	}

	public Long getTaxGeneralCardId() {
		return taxGeneralCardId;
	}

	public void setTaxGeneralCardId(Long taxGeneralCardId) {
		this.taxGeneralCardId = taxGeneralCardId;
	}

	public Long getTaxRegCardId() {
		return taxRegCardId;
	}

	public void setTaxRegCardId(Long taxRegCardId) {
		this.taxRegCardId = taxRegCardId;
	}

	public String getGcDetailInfo() {
		return gcDetailInfo;
	}

	public void setGcDetailInfo(String gcDetailInfo) {
		this.gcDetailInfo = gcDetailInfo;
	}

	public String getSmsEmailInfo() {
		return smsEmailInfo;
	}

	public void setSmsEmailInfo(String smsEmailInfo) {
		this.smsEmailInfo = smsEmailInfo;
	}

	public String getStoreDecorateBackgroundInfo() {
		return storeDecorateBackgroundInfo;
	}

	public void setStoreDecorateBackgroundInfo(String storeDecorateBackgroundInfo) {
		this.storeDecorateBackgroundInfo = storeDecorateBackgroundInfo;
	}

	public String getStoreDecorateBackgroundOldInfo() {
		return storeDecorateBackgroundOldInfo;
	}

	public void setStoreDecorateBackgroundOldInfo(String storeDecorateBackgroundOldInfo) {
		this.storeDecorateBackgroundOldInfo = storeDecorateBackgroundOldInfo;
	}

	public String getStoreDecorateBaseInfo() {
		return storeDecorateBaseInfo;
	}

	public void setStoreDecorateBaseInfo(String storeDecorateBaseInfo) {
		this.storeDecorateBaseInfo = storeDecorateBaseInfo;
	}

	public String getStoreDecorateBaseOldInfo() {
		return storeDecorateBaseOldInfo;
	}

	public void setStoreDecorateBaseOldInfo(String storeDecorateBaseOldInfo) {
		this.storeDecorateBaseOldInfo = storeDecorateBaseOldInfo;
	}

	public String getStoreDecorateInfo() {
		return storeDecorateInfo;
	}

	public void setStoreDecorateInfo(String storeDecorateInfo) {
		this.storeDecorateInfo = storeDecorateInfo;
	}

	public String getStoreDecorateOldInfo() {
		return storeDecorateOldInfo;
	}

	public void setStoreDecorateOldInfo(String storeDecorateOldInfo) {
		this.storeDecorateOldInfo = storeDecorateOldInfo;
	}

	public String getStoreInfo() {
		return storeInfo;
	}

	public void setStoreInfo(String storeInfo) {
		this.storeInfo = storeInfo;
	}

	public String getStoreQuickMenu() {
		return storeQuickMenu;
	}

	public void setStoreQuickMenu(String storeQuickMenu) {
		this.storeQuickMenu = storeQuickMenu;
	}

	public String getStoreSeoDescription() {
		return storeSeoDescription;
	}

	public void setStoreSeoDescription(String storeSeoDescription) {
		this.storeSeoDescription = storeSeoDescription;
	}

	public String getStoreSeoKeywords() {
		return storeSeoKeywords;
	}

	public void setStoreSeoKeywords(String storeSeoKeywords) {
		this.storeSeoKeywords = storeSeoKeywords;
	}

	public String getViolationReseaon() {
		return violationReseaon;
	}

	public void setViolationReseaon(String violationReseaon) {
		this.violationReseaon = violationReseaon;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getValidityStr() {
		return validityStr;
	}

	public void setValidityStr(String validityStr) {
		this.validityStr = validityStr;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Boolean getIsShop() {
		return isShop;
	}

	public void setIsShop(Boolean isShop) {
		this.isShop = isShop;
	}

	public Boolean getIsO2o() {
		return isO2o;
	}

	public void setIsO2o(Boolean isO2o) {
		this.isO2o = isO2o;
	}

	public Boolean getIsEepay() {
		return isEepay;
	}

	public void setIsEepay(Boolean isEepay) {
		this.isEepay = isEepay;
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

	public String getAreaSheng() {
		if (StringUtils.isNotEmpty(areaName)) {
			String[] areaArr = areaName.split("-");
			if (areaArr.length > 0) {
				return areaArr[0];
			}
		}
		return null;
	}

	public String getAreaShi() {
		if (StringUtils.isNotEmpty(areaName)) {
			String[] areaArr = areaName.split("-");
			if (areaArr.length > 1) {
				return areaArr[1];
			}
		}
		return null;
	}

	public String getAreaXian() {
		if (StringUtils.isNotEmpty(areaName)) {
			String[] areaArr = areaName.split("-");
			if (areaArr.length > 2) {
				return areaArr[2];
			}
		}
		return null;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getImplementNumber() {
		return implementNumber;
	}

	public void setImplementNumber(String implementNumber) {
		this.implementNumber = implementNumber;
	}

	public Integer getPosType() {
		return posType;
	}

	public void setPosType(Integer posType) {
		this.posType = posType;
	}

	public String getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Integer getIsBeLong() {
		return isBeLong;
	}

	public void setIsBeLong(Integer isBeLong) {
		this.isBeLong = isBeLong;
	}

	public Long getOperatorUserId() {
		return operatorUserId;
	}

	public void setOperatorUserId(Long operatorUserId) {
		this.operatorUserId = operatorUserId;
	}

	public Long getOperatorAreaId() {
		return operatorAreaId;
	}

	public void setOperatorAreaId(Long operatorAreaId) {
		this.operatorAreaId = operatorAreaId;
	}

	public String getBeginTimeStr() {
		return beginTimeStr;
	}

	public void setBeginTimeStr(String beginTimeStr) {
		this.beginTimeStr = beginTimeStr;
	}

	public String getEndTimeStr() {
		return endTimeStr;
	}

	public void setEndTimeStr(String endTimeStr) {
		this.endTimeStr = endTimeStr;
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

	public String getOperatorPhone() {
		return operatorPhone;
	}

	public void setOperatorPhone(String operatorPhone) {
		this.operatorPhone = operatorPhone;
	}

	public Integer getOwnType() {
		return ownType;
	}

	public void setOwnType(Integer ownType) {
		this.ownType = ownType;
	}

}
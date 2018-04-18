package com.sinco.carnation.store.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.math.BigDecimal;
import java.util.Date;

public class Store extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8327358067637877679L;

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

	/**
	 * 店铺状态，0为提交开店申请，1运营商审批,2运营商审批失败 5平台审核,6平台审核失败,10第三方支付审核,11第三方支付审批失败,15为正常营业（审核成功）,20违规关闭 ,
	 * 25到期关闭,26,到期后申请续费
	 **/
	private Integer storeStatus;

	/** 店铺电话号码 **/
	private String storeTelephone;

	/**  **/
	private String storeWw;

	/** 店铺邮编 **/
	private String storeZip;

	/** 店铺有效期，用在收费店铺等级，超过有效期，自动将为免费店铺,为空时表示无限期 **/
	private Date validity;

	/** 店铺地址，这里保存的是最底层地址 **/
	private Long areaId;

	/** 开户行所在地 **/
	private Long bankAreaId;

	/** 银行开户许可证电子版 **/
	private String bankPermitImagePath;

	/** 认证身份证 **/
	private Long cardId;

	/** 店铺等级 **/
	private Long gradeId;

	/**  **/
	private String storeBannerPath;

	/**  **/
	private String storeLicensePath;

	/**  **/
	private String storeLogoPath;
	
	/** 店铺封面图 **/
	private String storeCoverPath;

	/** 是否商城店铺 **/
	private Boolean isShop;

	/** 是否服务店铺 **/
	private Boolean isO2o;

	/** 经度 **/
	private BigDecimal storeLat;

	/** 纬度 **/
	private BigDecimal storeLon;

	/** 邀请码 **/
	private String invitationCode;

	/** 劵销售总额 **/
	private BigDecimal couponPayAmount;

	/** 刷卡销售额 **/
	private BigDecimal chargePayAmount;

	/** 消费返润总额 **/
	private BigDecimal rebateAmount;

	/** 返润比例 **/
	private BigDecimal commissionRebate;

	/** 创建用户id **/
	private Long createUserId;

	/** 刷卡机mid **/
	private String eepayMid;

	/** 刷卡机key **/
	private String eepayKey;

	/** 是否安装刷卡机 **/
	private Boolean isEepay;

	/** 服务主营类目，存储类目Id **/
	private Long groupMainId;

	/** 服务详细类目 **/
	private String groupDetailInfo;

	/** 服务折扣 **/
	private BigDecimal groupDiscount;

	/** 公司紧急联系人手机 **/
	private String licenseCMobile;

	/** 营业执照上公司名称 **/
	private String licenseCName;

	/**
	 * 店铺经营类，[{"gc_list":[2, 8, 3, 6, 7, 5],"m_id":1}]，当店铺申请店铺时选择了详细类目，商家发布商品时只可选择所有的详细类目
	 **/
	private String gcDetailInfo;

	/**
	 * 店铺短信邮件功能设置信息，使用json管理[{"id":1,"title":"买家申请退货通知 ","mark": "email_toseller_order_return_apply_notify "
	 * ,"sms_count":0,"email_count":0, "sms_open":1,"email_open":0},{},{}],id，对应系统模板id
	 * ，mark为模板标识，当使用id查询不到模板时使用mark查询 ，sms_count为该功能已发短信数量，sms_open为该功能短信是否开启,0关闭，1开启
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

	/** 机具编码 **/
	private String implementNumber;

	/** 机具类型 **/
	private Integer posType;

	/** 客户端类型 **/
	private Integer addType;

	/** 联行行号 **/
	private String lineNumber;

	/** 签约密码 **/
	private String password;

	/** 线下刷卡收益总额 **/
	private BigDecimal profitAmount;

	/** 商户标签 **/
	private String storeTarget;
	private String licenseCEmail;
	/**
	 * 是否被隶属运营商推广 add by yuleijia
	 */
	private Boolean isExtension;
	/**
	 * 推荐运营商 
	 */
	private String recommend;  //add by yuleijia on 2017.4.15

	
	public String getRecommend() {
		return recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

	public Boolean getIsExtension() {
		return isExtension;
	}

	public void setIsExtension(Boolean isExtension) {
		this.isExtension = isExtension;
	}

	public String getStoreTarget() {
		return storeTarget;
	}

	public void setStoreTarget(String storeTarget) {
		this.storeTarget = storeTarget;
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

	public Integer getStoreStatus() {
		return storeStatus;
	}

	public void setStoreStatus(Integer storeStatus) {
		this.storeStatus = storeStatus;
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

	public String getBankPermitImagePath() {
		return bankPermitImagePath;
	}

	public void setBankPermitImagePath(String bankPermitImagePath) {
		this.bankPermitImagePath = bankPermitImagePath;
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

	public String getStoreBannerPath() {
		return storeBannerPath;
	}

	public void setStoreBannerPath(String storeBannerPath) {
		this.storeBannerPath = storeBannerPath;
	}

	public String getStoreLicensePath() {
		return storeLicensePath;
	}

	public void setStoreLicensePath(String storeLicensePath) {
		this.storeLicensePath = storeLicensePath;
	}

	public String getStoreLogoPath() {
		return storeLogoPath;
	}

	public void setStoreLogoPath(String storeLogoPath) {
		this.storeLogoPath = storeLogoPath;
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

	public String getInvitationCode() {
		return invitationCode;
	}

	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
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

	public BigDecimal getCommissionRebate() {
		return commissionRebate;
	}

	public void setCommissionRebate(BigDecimal commissionRebate) {
		this.commissionRebate = commissionRebate;
	}

	public Long getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
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

	public Boolean getIsEepay() {
		return isEepay;
	}

	public void setIsEepay(Boolean isEepay) {
		this.isEepay = isEepay;
	}

	public Long getGroupMainId() {
		return groupMainId;
	}

	public void setGroupMainId(Long groupMainId) {
		this.groupMainId = groupMainId;
	}

	public String getGroupDetailInfo() {
		return groupDetailInfo;
	}

	public void setGroupDetailInfo(String groupDetailInfo) {
		this.groupDetailInfo = groupDetailInfo;
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

	public BigDecimal getGroupDiscount() {
		return groupDiscount;
	}

	public void setGroupDiscount(BigDecimal groupDiscount) {
		this.groupDiscount = groupDiscount;
	}

	public void setViolationReseaon(String violationReseaon) {
		this.violationReseaon = violationReseaon;
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

	public Integer getAddType() {
		return addType;
	}

	public void setAddType(Integer addType) {
		this.addType = addType;
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

	public BigDecimal getProfitAmount() {
		return profitAmount;
	}

	public void setProfitAmount(BigDecimal profitAmount) {
		this.profitAmount = profitAmount;
	}

	public String getLicenseCEmail() {
		return licenseCEmail;
	}

	public void setLicenseCEmail(String licenseCEmail) {
		this.licenseCEmail = licenseCEmail;
	}

	public String getStoreCoverPath() {
		return storeCoverPath;
	}

	public void setStoreCoverPath(String storeCoverPath) {
		this.storeCoverPath = storeCoverPath;
	}

}
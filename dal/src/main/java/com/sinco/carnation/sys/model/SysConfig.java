package com.sinco.carnation.sys.model;

import java.math.BigDecimal;
import java.util.Date;

public class SysConfig {
	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/**  **/
	private Integer deleteStatus;

	/** 商城访问地址，填写商城网址 **/
	private String address;

	/** 安卓客户端下载地址 **/
	private String androidDownload;

	/** 安卓客户端版本号 **/
	private String androidVersion;

	/** 手机推送的API key,使用百度的推送服务,系统集成百度推送接口 **/
	private String apiKey;

	/** 是否启用App下载，默认为0不启用，1为启用 **/
	private Integer appDownload;

	/** 卖家发货后，达到该时间系统自动确认收货 **/
	private Integer autoOrderConfirm;

	/** 订单确认收货后到达该时间，系统自动管理订单评价功能 **/
	private Integer autoOrderEvaluate;

	/** 卖家发货后达到该时长，给买家发送即将自动确认收货的短信、邮件提醒 **/
	private Integer autoOrderNotice;

	/** 买家申请退货，到达该时间未能输入退货单号及物流公司，退货失败并且订单变为待评价，订单状态为49 **/
	private Integer autoOrderReturn;

	/**  **/
	private Integer bigHeight;

	/** 大尺寸像素高 **/
	private Integer bigWidth;

	/** 满就送促销价格 按每30天多少金币算,默认是300个金币每30天 **/
	private Integer buygiftMealGold;

	/** 满就送开启状态 0为关闭 1为开启 **/
	private Integer buygiftStatus;

	/** 申请圈子是否需要审核，0为不需要审核，1为需要审核 **/
	private Integer circleAudit;

	/** 用户可创建圈子数量，可以在平台中设置 **/
	private Integer circleCount;

	/** 用户创建圈子限制信息，（保存用户等级信息，只有用户等级大于等于该等级时才可以申请创建圈子，0为不限制，1为铜牌，2银牌，3金牌，4超级） **/
	private Integer circleLimit;

	/** 系统圈子开启状态，1为开启 **/
	private Integer circleOpen;

	/** 组合销套餐费用，单位为金币/30天 **/
	private Integer combinAmount;

	/** 组合销售中的最大商品数量 **/
	private Integer combinCount;

	/** 组合销售方案数量 **/
	private Integer combinSchemeCount;

	/** 组合销套开启状态 **/
	private Integer combinStatus;

	/** 公司简称，用在超级管理平台的左下角显示 **/
	private String companyName;

	/** 举报失效，以订单完成时间开始计算，单位为天 **/
	private Integer complaintTime;

	/** 消费比例(赠送积分) **/
	private Integer consumptionRatio;

	/** 版权信息 **/
	private String copyRight;

	/** 货币符号，默认为人民币¥ **/
	private String currencyCode;

	/** 预存款 **/
	private Boolean deposit;

	/** 商城SEO描述 **/
	private String description;

	/** 店铺二级域名运行修改次数，0为无限制 **/
	private Integer domainAllowCount;

	/** 邮件是否开启 **/
	private Boolean emailEnable;

	/** stmp服务器 **/
	private String emailHost;

	/** stmp端口 **/
	private Integer emailPort;

	/** 邮箱密码 **/
	private String emailPws;

	/** 邮件发送测试 **/
	private String emailTest;

	/** 发件人 **/
	private String emailUser;

	/** 邮箱用户名 **/
	private String emailUserName;

	/** 邮件购买状态，0为商家不可购买邮件,1为商家可购买邮件 **/
	private Integer emailBuy;

	/** 邮件购买金额，以100封邮件为单位 **/
	private Integer emailBuyCost;

	/** 邮件发送是否启用队列，默认是不启用队列，相关发送邮件的地方都是及时发送邮件，启用队列后效率高，但是会滞后发送,0：不启用，1：启用 **/
	private Integer emailQueue;

	/** 第三方店铺最大满就送数量，默认1个 **/
	private Integer enoughreduceMaxCount;

	/** 满就送促销价格 按每30天多少金币算,默认是300个金币每30天 **/
	private Integer enoughreduceMealGold;

	/** 满就减开启状态 0为关闭 1为开启 **/
	private Integer enoughreduceStatus;

	/** 评价追加期限 默认180天 **/
	private Integer evaluateAddDeadline;

	/** 评价修改期限 默认30天 **/
	private Integer evaluateEditDeadline;

	/** 每个订单(赠送积分) **/
	private Integer everyindentLimit;

	/** 金币 **/
	private Boolean gold;

	/** 金币市值，默认是一个金币抵制1元 **/
	private Integer goldMarketValue;

	/** 团购 **/
	private Boolean groupBuy;

	/** 团购套餐价格 按每30天多少金币算,默认是300个金币每30天 **/
	private Integer groupMealGold;

	/** 生活类团购退货时效，如电影票，购买付款后，在该天数内可以申请退款 **/
	private Integer grouplifeOrderReturn;

	/** 热门搜索 **/
	private String hotSearch;

	/** 服务热门搜索 **/
	private String o2oHotSearch;

	/** 允许图片上传的最大值 **/
	private Integer imageFilesize;

	/** 图片保存类型 **/
	private String imageSaveType;

	/** 图片的后缀名 **/
	private String imageSuffix;

	/** 图片服务器地址 **/
	private String imageWebServer;

	/** 订单评论(赠送积分) **/
	private Integer indentComment;

	/** 积分 **/
	private Boolean integral;

	/** 充值积分兑换比率 **/
	private Integer integralRate;

	/** 开启积分商城 **/
	private Boolean integralStore;

	/** Iphone客户端下载地址 **/
	private String iosDownload;

	/** Iphone客户端版本号 **/
	private String iosVersion;

	/** 商城SEO关键字 **/
	private String keywords;

	/** 快递100类型，0为免费版快递查询，1为收费版快递查询，默认为免费版快递查询 **/
	private Integer kuaidiType;

	/** 全文索引更新时间 **/
	private Date luceneUpdate;

	/** lucene写索引是否启用队列，默认是发布商品后即刻写索引，效率较低，启用队列后效率高,但是会滞后写入,0：不启用，1：启用 **/
	private Integer lucenenQueue;

	/** 会员每日登陆(赠送积分) **/
	private Integer memberDayLogin;

	/** 会员注册(赠送积分) **/
	private Integer memberRegister;

	/** meta的author信息 **/
	private String metaAuthor;

	/** meta的generator **/
	private String metaGenerator;

	/**  **/
	private Integer middleHeight;

	/** 中尺寸像素宽 **/
	private Integer middleWidth;

	/** 是否开通殴飞充值接口 **/
	private Boolean ofcard;

	/** 手机充值的利润值，用户充值手机时候，系统会查询殴飞接口实际收费，根据殴飞的收费加上该利润值，作为用户缴纳的最终金额 **/
	private BigDecimal ofcardMobileProfit;

	/** 殴飞充值接口用户名 **/
	private String ofcardUserid;

	/** 殴飞充值接口密码 **/
	private String ofcardUserpws;

	/** 系统总结算金额(应结算) **/
	private BigDecimal payoffAllAmount;

	/** 系统总结算金额(实际结算) **/
	private BigDecimal payoffAllAmountReality;

	/** 系统总销售佣金 **/
	private BigDecimal payoffAllCommission;

	/** 系统总销售金额 **/
	private BigDecimal payoffAllSale;

	/** 月结算次数，可以设置为1次、2次、3次、4次 **/
	private Integer payoffCount;

	/** 下次结算日期，每天0:00计算系统下次结算时间 **/
	private Date payoffDate;

	/** 结算通知消息类型，0为系统默认消息，1为自定义消息 **/
	private Integer payoffMagType;

	/** 前端poweredby **/
	private String poweredby;

	/** 用户发帖限制信息（保存用户等级信息，只有用户等级大于等于该等级时才可以发布帖子，0为不限制，1为铜牌，2银牌，3金牌，4超级） **/
	private Integer publishPostLimit;

	/** 发帖身份限制，0为所有人可发帖，1为只能商家可发帖 **/
	private Integer publishSellerLimit;

	/** 是否允许QQ登录 **/
	private Boolean qqLogin;

	/** QQ登录Id **/
	private String qqLoginId;

	/** QQ登录key **/
	private String qqLoginKey;

	/** 是否开启二维码登录，默认为0不开启，1为开启，开启后使用app扫描二维码即可完成pc端登录 **/
	private Integer qrLogin;

	/** 是否开通二级域名 **/
	private Boolean secondDomainOpen;

	/** 手机推送的Secret key,使用百度的推送服务 **/
	private String secretKey;

	/** 商品咨询验证 **/
	private Boolean securityCodeConsult;

	/** 前台登陆验证 **/
	private Boolean securityCodeLogin;

	/** 前台注册验证 **/
	private Boolean securityCodeRegister;

	/** 验证码类型 **/
	private String securityCodeType;

	/** 是否允许新浪微博登录 **/
	private Boolean sinaLogin;

	/** 新浪微博Id **/
	private String sinaLoginId;

	/** 新浪微博key **/
	private String sinaLoginKey;

	/**  **/
	private Integer smallHeight;

	/** 最小尺寸像素宽 **/
	private Integer smallWidth;

	/** 短信平台开启 **/
	private Boolean smsEnbale;

	/** 短信平台用户密码 **/
	private String smsPassword;

	/** 短信测试发送账号 **/
	private String smsTest;

	/** 短信平台发送地址 **/
	private String smsUrl;

	/** 短信平台用户名 **/
	private String smsUserName;

	/** 短信购买状态，0为商家不可购买短信,1为商家可购买短信 **/
	private Integer smsBuy;

	/** 短信购买金额，以100条短信为单位 **/
	private Integer smsBuyCost;

	/** 短信发送是否启用队列，默认是不启用队列，相关发送短信的地方都及时发送短信，启用队列后效率高，但是会滞后发送,0：不启用，1：启用 **/
	private Integer smsQueue;

	/** 允许店铺申请 **/
	private Boolean storeAllow;

	/** 系统语言 **/
	private String sysLanguage;

	/** 商城标题 **/
	private String title;

	/** 用户上传文件路径 **/
	private String uploadFilePath;

	/** 游客咨询 **/
	private Boolean visitorConsult;

	/** 代金券 **/
	private Boolean voucher;

	/** 当前网站平台样式，默认为蓝色 **/
	private String websiteCss;

	/** 网站名称 **/
	private String websiteName;

	/** 网站状态(开/关) **/
	private Boolean websiteState;

	/** 微信账号 **/
	private String weixinAccount;

	/** 微信App Id，申请开发者成功后微信生成的AppId **/
	private String weixinAppId;

	/** 微信AppSecret，申请开发者成功后微信生成的AppSecret **/
	private String weixinAppSecret;

	/** 微信商城的状态，0为为开启，1为开启状态 **/
	private Integer weixinStore;

	/** 微信token，申请开发者时自己填写的token **/
	private String weixinToken;

	/** 商城是否开启了0元试用0元试用 0为否 1为是 **/
	private Integer whetherFree;

	/** 直通车商品显示方式，0为没有任何限制，1为按照商品分类显示，在商品分类搜索页中是否按照该页中分类进行显示 **/
	private Integer ztcGoodsView;

	/** 直通车起价，用户可以任意设定价格，必须大于该价格，价格越高排序也靠前 **/
	private Integer ztcPrice;

	/** 直通车状态 **/
	private Boolean ztcStatus;

	/** 平台登录页的左上角Logo **/
	private Long adminLoginLogoId;

	/** 平台管理中心左上角的Logo **/
	private Long adminManageLogoId;

	/** 默认商品图片 **/
	private Long goodsImageId;

	/** 默认用户图标 **/
	private Long memberIconId;

	/** 二维码中心Logo图片 **/
	private Long qrLogoId;

	/** 默认店铺标志 **/
	private Long storeImageId;

	/** 平台微信商城ogo **/
	private Long storeWeixinLogoId;

	/** 网站logo **/
	private Long websiteLogoId;

	/** 微信二维码图片 **/
	private Long weixinQrImgId;

	/** 欢迎词图片 **/
	private Long welcomeImgId;

	/** 网站关闭原因 **/
	private String closeReason;

	/** 三方代码统计 **/
	private String codeStat;

	/** kuaidi100快递查询Id，卖家需自行向http://www.kuaidi100.com申请接口id，下个版本公司内部出版接口查询 **/
	private String kuaidiId;

	/** 快递100收费推送接口，能够快速查询系统快递信息 **/
	private String kuaidiId2;

	/** 自定义结算通知 **/
	private String payoffMagAuto;

	/** 系统默认结算通知 **/
	private String payoffMagDefault;

	/** QQ域名验证信息 **/
	private String qqDomainCode;

	/** 平台客服QQ，一行一个 **/
	private String serviceQqList;

	/** 平台客服电话，一行一个 **/
	private String serviceTelphoneList;

	/** 百度分享代码 **/
	private String shareCode;

	/** 新浪微博域名验证信息 **/
	private String sinaDomainCode;

	/** 平台支付方式启用情况，使用json管理，如{"alipay":true,"99bill":false} **/
	private String storePayment;

	/** 系统保留二级域名 **/
	private String sysDomain;

	/** 店铺样式管理使用字符串管理 **/
	private String templates;

	/** 会员等级数据，使用json管理 **/
	private String userLevel;

	/** 关注微信时候的欢迎词 **/
	private String weixinWelecomeContent;

	private BigDecimal commissionRebateRate;

	/**
	 * 第三方支付公司代理号
	 */
	private String eeepayAgentNo;

	/**
	 * 第三方支付公司手续费
	 */
	private BigDecimal eeepayFee;
	/**
	 * 微商城地址
	 */
	private String mobileAddress;
	/**
	 * 静态文件地址
	 */
	private String staticServerAddress;

	public String getMobileAddress() {
		return mobileAddress;
	}

	public void setMobileAddress(String mobileAddress) {
		this.mobileAddress = mobileAddress;
	}

	public String getEeepayAgentNo() {
		return eeepayAgentNo;
	}

	public void setEeepayAgentNo(String eeepayAgentNo) {
		this.eeepayAgentNo = eeepayAgentNo;
	}

	public BigDecimal getEeepayFee() {
		return eeepayFee;
	}

	public void setEeepayFee(BigDecimal eeepayFee) {
		this.eeepayFee = eeepayFee;
	}

	public BigDecimal getCommissionRebateRate() {
		return commissionRebateRate;
	}

	public void setCommissionRebateRate(BigDecimal commissionRebateRate) {
		this.commissionRebateRate = commissionRebateRate;
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

	public Integer getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Integer deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAndroidDownload() {
		return androidDownload;
	}

	public void setAndroidDownload(String androidDownload) {
		this.androidDownload = androidDownload;
	}

	public String getAndroidVersion() {
		return androidVersion;
	}

	public void setAndroidVersion(String androidVersion) {
		this.androidVersion = androidVersion;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public Integer getAppDownload() {
		return appDownload;
	}

	public void setAppDownload(Integer appDownload) {
		this.appDownload = appDownload;
	}

	public Integer getAutoOrderConfirm() {
		return autoOrderConfirm;
	}

	public void setAutoOrderConfirm(Integer autoOrderConfirm) {
		this.autoOrderConfirm = autoOrderConfirm;
	}

	public Integer getAutoOrderEvaluate() {
		return autoOrderEvaluate;
	}

	public void setAutoOrderEvaluate(Integer autoOrderEvaluate) {
		this.autoOrderEvaluate = autoOrderEvaluate;
	}

	public Integer getAutoOrderNotice() {
		return autoOrderNotice;
	}

	public void setAutoOrderNotice(Integer autoOrderNotice) {
		this.autoOrderNotice = autoOrderNotice;
	}

	public Integer getAutoOrderReturn() {
		return autoOrderReturn;
	}

	public void setAutoOrderReturn(Integer autoOrderReturn) {
		this.autoOrderReturn = autoOrderReturn;
	}

	public Integer getBigHeight() {
		return bigHeight;
	}

	public void setBigHeight(Integer bigHeight) {
		this.bigHeight = bigHeight;
	}

	public Integer getBigWidth() {
		return bigWidth;
	}

	public void setBigWidth(Integer bigWidth) {
		this.bigWidth = bigWidth;
	}

	public Integer getBuygiftMealGold() {
		return buygiftMealGold;
	}

	public void setBuygiftMealGold(Integer buygiftMealGold) {
		this.buygiftMealGold = buygiftMealGold;
	}

	public Integer getBuygiftStatus() {
		return buygiftStatus;
	}

	public void setBuygiftStatus(Integer buygiftStatus) {
		this.buygiftStatus = buygiftStatus;
	}

	public Integer getCircleAudit() {
		return circleAudit;
	}

	public void setCircleAudit(Integer circleAudit) {
		this.circleAudit = circleAudit;
	}

	public Integer getCircleCount() {
		return circleCount;
	}

	public void setCircleCount(Integer circleCount) {
		this.circleCount = circleCount;
	}

	public Integer getCircleLimit() {
		return circleLimit;
	}

	public void setCircleLimit(Integer circleLimit) {
		this.circleLimit = circleLimit;
	}

	public Integer getCircleOpen() {
		return circleOpen;
	}

	public void setCircleOpen(Integer circleOpen) {
		this.circleOpen = circleOpen;
	}

	public Integer getCombinAmount() {
		return combinAmount;
	}

	public void setCombinAmount(Integer combinAmount) {
		this.combinAmount = combinAmount;
	}

	public Integer getCombinCount() {
		return combinCount;
	}

	public void setCombinCount(Integer combinCount) {
		this.combinCount = combinCount;
	}

	public Integer getCombinSchemeCount() {
		return combinSchemeCount;
	}

	public void setCombinSchemeCount(Integer combinSchemeCount) {
		this.combinSchemeCount = combinSchemeCount;
	}

	public Integer getCombinStatus() {
		return combinStatus;
	}

	public void setCombinStatus(Integer combinStatus) {
		this.combinStatus = combinStatus;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Integer getComplaintTime() {
		return complaintTime;
	}

	public void setComplaintTime(Integer complaintTime) {
		this.complaintTime = complaintTime;
	}

	public Integer getConsumptionRatio() {
		return consumptionRatio;
	}

	public void setConsumptionRatio(Integer consumptionRatio) {
		this.consumptionRatio = consumptionRatio;
	}

	public String getCopyRight() {
		return copyRight;
	}

	public void setCopyRight(String copyRight) {
		this.copyRight = copyRight;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public Boolean getDeposit() {
		return deposit;
	}

	public void setDeposit(Boolean deposit) {
		this.deposit = deposit;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getDomainAllowCount() {
		return domainAllowCount;
	}

	public void setDomainAllowCount(Integer domainAllowCount) {
		this.domainAllowCount = domainAllowCount;
	}

	public Boolean getEmailEnable() {
		return emailEnable;
	}

	public void setEmailEnable(Boolean emailEnable) {
		this.emailEnable = emailEnable;
	}

	public String getEmailHost() {
		return emailHost;
	}

	public void setEmailHost(String emailHost) {
		this.emailHost = emailHost;
	}

	public Integer getEmailPort() {
		return emailPort;
	}

	public void setEmailPort(Integer emailPort) {
		this.emailPort = emailPort;
	}

	public String getEmailPws() {
		return emailPws;
	}

	public void setEmailPws(String emailPws) {
		this.emailPws = emailPws;
	}

	public String getEmailTest() {
		return emailTest;
	}

	public void setEmailTest(String emailTest) {
		this.emailTest = emailTest;
	}

	public String getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}

	public String getEmailUserName() {
		return emailUserName;
	}

	public void setEmailUserName(String emailUserName) {
		this.emailUserName = emailUserName;
	}

	public Integer getEmailBuy() {
		return emailBuy;
	}

	public void setEmailBuy(Integer emailBuy) {
		this.emailBuy = emailBuy;
	}

	public Integer getEmailBuyCost() {
		return emailBuyCost;
	}

	public void setEmailBuyCost(Integer emailBuyCost) {
		this.emailBuyCost = emailBuyCost;
	}

	public Integer getEmailQueue() {
		return emailQueue;
	}

	public void setEmailQueue(Integer emailQueue) {
		this.emailQueue = emailQueue;
	}

	public Integer getEnoughreduceMaxCount() {
		return enoughreduceMaxCount;
	}

	public void setEnoughreduceMaxCount(Integer enoughreduceMaxCount) {
		this.enoughreduceMaxCount = enoughreduceMaxCount;
	}

	public Integer getEnoughreduceMealGold() {
		return enoughreduceMealGold;
	}

	public void setEnoughreduceMealGold(Integer enoughreduceMealGold) {
		this.enoughreduceMealGold = enoughreduceMealGold;
	}

	public Integer getEnoughreduceStatus() {
		return enoughreduceStatus;
	}

	public void setEnoughreduceStatus(Integer enoughreduceStatus) {
		this.enoughreduceStatus = enoughreduceStatus;
	}

	public Integer getEvaluateAddDeadline() {
		return evaluateAddDeadline;
	}

	public void setEvaluateAddDeadline(Integer evaluateAddDeadline) {
		this.evaluateAddDeadline = evaluateAddDeadline;
	}

	public Integer getEvaluateEditDeadline() {
		return evaluateEditDeadline;
	}

	public void setEvaluateEditDeadline(Integer evaluateEditDeadline) {
		this.evaluateEditDeadline = evaluateEditDeadline;
	}

	public Integer getEveryindentLimit() {
		return everyindentLimit;
	}

	public void setEveryindentLimit(Integer everyindentLimit) {
		this.everyindentLimit = everyindentLimit;
	}

	public Boolean getGold() {
		return gold;
	}

	public void setGold(Boolean gold) {
		this.gold = gold;
	}

	public Integer getGoldMarketValue() {
		return goldMarketValue;
	}

	public void setGoldMarketValue(Integer goldMarketValue) {
		this.goldMarketValue = goldMarketValue;
	}

	public Boolean getGroupBuy() {
		return groupBuy;
	}

	public void setGroupBuy(Boolean groupBuy) {
		this.groupBuy = groupBuy;
	}

	public Integer getGroupMealGold() {
		return groupMealGold;
	}

	public void setGroupMealGold(Integer groupMealGold) {
		this.groupMealGold = groupMealGold;
	}

	public Integer getGrouplifeOrderReturn() {
		return grouplifeOrderReturn;
	}

	public void setGrouplifeOrderReturn(Integer grouplifeOrderReturn) {
		this.grouplifeOrderReturn = grouplifeOrderReturn;
	}

	public String getHotSearch() {
		return hotSearch;
	}

	public void setHotSearch(String hotSearch) {
		this.hotSearch = hotSearch;
	}

	public Integer getImageFilesize() {
		return imageFilesize;
	}

	public void setImageFilesize(Integer imageFilesize) {
		this.imageFilesize = imageFilesize;
	}

	public String getImageSaveType() {
		return imageSaveType;
	}

	public void setImageSaveType(String imageSaveType) {
		this.imageSaveType = imageSaveType;
	}

	public String getImageSuffix() {
		return imageSuffix;
	}

	public void setImageSuffix(String imageSuffix) {
		this.imageSuffix = imageSuffix;
	}

	public String getImageWebServer() {
		return imageWebServer;
	}

	public void setImageWebServer(String imageWebServer) {
		this.imageWebServer = imageWebServer;
	}

	public Integer getIndentComment() {
		return indentComment;
	}

	public void setIndentComment(Integer indentComment) {
		this.indentComment = indentComment;
	}

	public Boolean getIntegral() {
		return integral;
	}

	public void setIntegral(Boolean integral) {
		this.integral = integral;
	}

	public Integer getIntegralRate() {
		return integralRate;
	}

	public void setIntegralRate(Integer integralRate) {
		this.integralRate = integralRate;
	}

	public Boolean getIntegralStore() {
		return integralStore;
	}

	public void setIntegralStore(Boolean integralStore) {
		this.integralStore = integralStore;
	}

	public String getIosDownload() {
		return iosDownload;
	}

	public void setIosDownload(String iosDownload) {
		this.iosDownload = iosDownload;
	}

	public String getIosVersion() {
		return iosVersion;
	}

	public void setIosVersion(String iosVersion) {
		this.iosVersion = iosVersion;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public Integer getKuaidiType() {
		return kuaidiType;
	}

	public void setKuaidiType(Integer kuaidiType) {
		this.kuaidiType = kuaidiType;
	}

	public Date getLuceneUpdate() {
		return luceneUpdate;
	}

	public void setLuceneUpdate(Date luceneUpdate) {
		this.luceneUpdate = luceneUpdate;
	}

	public Integer getLucenenQueue() {
		return lucenenQueue;
	}

	public void setLucenenQueue(Integer lucenenQueue) {
		this.lucenenQueue = lucenenQueue;
	}

	public Integer getMemberDayLogin() {
		return memberDayLogin;
	}

	public void setMemberDayLogin(Integer memberDayLogin) {
		this.memberDayLogin = memberDayLogin;
	}

	public Integer getMemberRegister() {
		return memberRegister;
	}

	public void setMemberRegister(Integer memberRegister) {
		this.memberRegister = memberRegister;
	}

	public String getMetaAuthor() {
		return metaAuthor;
	}

	public void setMetaAuthor(String metaAuthor) {
		this.metaAuthor = metaAuthor;
	}

	public String getMetaGenerator() {
		return metaGenerator;
	}

	public void setMetaGenerator(String metaGenerator) {
		this.metaGenerator = metaGenerator;
	}

	public Integer getMiddleHeight() {
		return middleHeight;
	}

	public void setMiddleHeight(Integer middleHeight) {
		this.middleHeight = middleHeight;
	}

	public Integer getMiddleWidth() {
		return middleWidth;
	}

	public void setMiddleWidth(Integer middleWidth) {
		this.middleWidth = middleWidth;
	}

	public Boolean getOfcard() {
		return ofcard;
	}

	public void setOfcard(Boolean ofcard) {
		this.ofcard = ofcard;
	}

	public BigDecimal getOfcardMobileProfit() {
		return ofcardMobileProfit;
	}

	public void setOfcardMobileProfit(BigDecimal ofcardMobileProfit) {
		this.ofcardMobileProfit = ofcardMobileProfit;
	}

	public String getOfcardUserid() {
		return ofcardUserid;
	}

	public void setOfcardUserid(String ofcardUserid) {
		this.ofcardUserid = ofcardUserid;
	}

	public String getOfcardUserpws() {
		return ofcardUserpws;
	}

	public void setOfcardUserpws(String ofcardUserpws) {
		this.ofcardUserpws = ofcardUserpws;
	}

	public BigDecimal getPayoffAllAmount() {
		return payoffAllAmount;
	}

	public void setPayoffAllAmount(BigDecimal payoffAllAmount) {
		this.payoffAllAmount = payoffAllAmount;
	}

	public BigDecimal getPayoffAllAmountReality() {
		return payoffAllAmountReality;
	}

	public void setPayoffAllAmountReality(BigDecimal payoffAllAmountReality) {
		this.payoffAllAmountReality = payoffAllAmountReality;
	}

	public BigDecimal getPayoffAllCommission() {
		return payoffAllCommission;
	}

	public void setPayoffAllCommission(BigDecimal payoffAllCommission) {
		this.payoffAllCommission = payoffAllCommission;
	}

	public BigDecimal getPayoffAllSale() {
		return payoffAllSale;
	}

	public void setPayoffAllSale(BigDecimal payoffAllSale) {
		this.payoffAllSale = payoffAllSale;
	}

	public Integer getPayoffCount() {
		return payoffCount;
	}

	public void setPayoffCount(Integer payoffCount) {
		this.payoffCount = payoffCount;
	}

	public Date getPayoffDate() {
		return payoffDate;
	}

	public void setPayoffDate(Date payoffDate) {
		this.payoffDate = payoffDate;
	}

	public Integer getPayoffMagType() {
		return payoffMagType;
	}

	public void setPayoffMagType(Integer payoffMagType) {
		this.payoffMagType = payoffMagType;
	}

	public String getPoweredby() {
		return poweredby;
	}

	public void setPoweredby(String poweredby) {
		this.poweredby = poweredby;
	}

	public Integer getPublishPostLimit() {
		return publishPostLimit;
	}

	public void setPublishPostLimit(Integer publishPostLimit) {
		this.publishPostLimit = publishPostLimit;
	}

	public Integer getPublishSellerLimit() {
		return publishSellerLimit;
	}

	public void setPublishSellerLimit(Integer publishSellerLimit) {
		this.publishSellerLimit = publishSellerLimit;
	}

	public Boolean getQqLogin() {
		return qqLogin;
	}

	public void setQqLogin(Boolean qqLogin) {
		this.qqLogin = qqLogin;
	}

	public String getQqLoginId() {
		return qqLoginId;
	}

	public void setQqLoginId(String qqLoginId) {
		this.qqLoginId = qqLoginId;
	}

	public String getQqLoginKey() {
		return qqLoginKey;
	}

	public void setQqLoginKey(String qqLoginKey) {
		this.qqLoginKey = qqLoginKey;
	}

	public Integer getQrLogin() {
		return qrLogin;
	}

	public void setQrLogin(Integer qrLogin) {
		this.qrLogin = qrLogin;
	}

	public Boolean getSecondDomainOpen() {
		return secondDomainOpen;
	}

	public void setSecondDomainOpen(Boolean secondDomainOpen) {
		this.secondDomainOpen = secondDomainOpen;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public Boolean getSecurityCodeConsult() {
		return securityCodeConsult;
	}

	public void setSecurityCodeConsult(Boolean securityCodeConsult) {
		this.securityCodeConsult = securityCodeConsult;
	}

	public Boolean getSecurityCodeLogin() {
		return securityCodeLogin;
	}

	public void setSecurityCodeLogin(Boolean securityCodeLogin) {
		this.securityCodeLogin = securityCodeLogin;
	}

	public Boolean getSecurityCodeRegister() {
		return securityCodeRegister;
	}

	public void setSecurityCodeRegister(Boolean securityCodeRegister) {
		this.securityCodeRegister = securityCodeRegister;
	}

	public String getSecurityCodeType() {
		return securityCodeType;
	}

	public void setSecurityCodeType(String securityCodeType) {
		this.securityCodeType = securityCodeType;
	}

	public Boolean getSinaLogin() {
		return sinaLogin;
	}

	public void setSinaLogin(Boolean sinaLogin) {
		this.sinaLogin = sinaLogin;
	}

	public String getSinaLoginId() {
		return sinaLoginId;
	}

	public void setSinaLoginId(String sinaLoginId) {
		this.sinaLoginId = sinaLoginId;
	}

	public String getSinaLoginKey() {
		return sinaLoginKey;
	}

	public void setSinaLoginKey(String sinaLoginKey) {
		this.sinaLoginKey = sinaLoginKey;
	}

	public Integer getSmallHeight() {
		return smallHeight;
	}

	public void setSmallHeight(Integer smallHeight) {
		this.smallHeight = smallHeight;
	}

	public Integer getSmallWidth() {
		return smallWidth;
	}

	public void setSmallWidth(Integer smallWidth) {
		this.smallWidth = smallWidth;
	}

	public Boolean getSmsEnbale() {
		return smsEnbale;
	}

	public void setSmsEnbale(Boolean smsEnbale) {
		this.smsEnbale = smsEnbale;
	}

	public String getSmsPassword() {
		return smsPassword;
	}

	public void setSmsPassword(String smsPassword) {
		this.smsPassword = smsPassword;
	}

	public String getSmsTest() {
		return smsTest;
	}

	public void setSmsTest(String smsTest) {
		this.smsTest = smsTest;
	}

	public String getSmsUrl() {
		return smsUrl;
	}

	public void setSmsUrl(String smsUrl) {
		this.smsUrl = smsUrl;
	}

	public String getSmsUserName() {
		return smsUserName;
	}

	public void setSmsUserName(String smsUserName) {
		this.smsUserName = smsUserName;
	}

	public Integer getSmsBuy() {
		return smsBuy;
	}

	public void setSmsBuy(Integer smsBuy) {
		this.smsBuy = smsBuy;
	}

	public Integer getSmsBuyCost() {
		return smsBuyCost;
	}

	public void setSmsBuyCost(Integer smsBuyCost) {
		this.smsBuyCost = smsBuyCost;
	}

	public Integer getSmsQueue() {
		return smsQueue;
	}

	public void setSmsQueue(Integer smsQueue) {
		this.smsQueue = smsQueue;
	}

	public Boolean getStoreAllow() {
		return storeAllow;
	}

	public void setStoreAllow(Boolean storeAllow) {
		this.storeAllow = storeAllow;
	}

	public String getSysLanguage() {
		return sysLanguage;
	}

	public void setSysLanguage(String sysLanguage) {
		this.sysLanguage = sysLanguage;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUploadFilePath() {
		return uploadFilePath;
	}

	public void setUploadFilePath(String uploadFilePath) {
		this.uploadFilePath = uploadFilePath;
	}

	public Boolean getVisitorConsult() {
		return visitorConsult;
	}

	public void setVisitorConsult(Boolean visitorConsult) {
		this.visitorConsult = visitorConsult;
	}

	public Boolean getVoucher() {
		return voucher;
	}

	public void setVoucher(Boolean voucher) {
		this.voucher = voucher;
	}

	public String getWebsiteCss() {
		return websiteCss;
	}

	public void setWebsiteCss(String websiteCss) {
		this.websiteCss = websiteCss;
	}

	public String getWebsiteName() {
		return websiteName;
	}

	public void setWebsiteName(String websiteName) {
		this.websiteName = websiteName;
	}

	public Boolean getWebsiteState() {
		return websiteState;
	}

	public void setWebsiteState(Boolean websiteState) {
		this.websiteState = websiteState;
	}

	public String getWeixinAccount() {
		return weixinAccount;
	}

	public void setWeixinAccount(String weixinAccount) {
		this.weixinAccount = weixinAccount;
	}

	public String getWeixinAppId() {
		return weixinAppId;
	}

	public void setWeixinAppId(String weixinAppId) {
		this.weixinAppId = weixinAppId;
	}

	public String getWeixinAppSecret() {
		return weixinAppSecret;
	}

	public void setWeixinAppSecret(String weixinAppSecret) {
		this.weixinAppSecret = weixinAppSecret;
	}

	public Integer getWeixinStore() {
		return weixinStore;
	}

	public void setWeixinStore(Integer weixinStore) {
		this.weixinStore = weixinStore;
	}

	public String getWeixinToken() {
		return weixinToken;
	}

	public void setWeixinToken(String weixinToken) {
		this.weixinToken = weixinToken;
	}

	public Integer getWhetherFree() {
		return whetherFree;
	}

	public void setWhetherFree(Integer whetherFree) {
		this.whetherFree = whetherFree;
	}

	public Integer getZtcGoodsView() {
		return ztcGoodsView;
	}

	public void setZtcGoodsView(Integer ztcGoodsView) {
		this.ztcGoodsView = ztcGoodsView;
	}

	public Integer getZtcPrice() {
		return ztcPrice;
	}

	public void setZtcPrice(Integer ztcPrice) {
		this.ztcPrice = ztcPrice;
	}

	public Boolean getZtcStatus() {
		return ztcStatus;
	}

	public void setZtcStatus(Boolean ztcStatus) {
		this.ztcStatus = ztcStatus;
	}

	public Long getAdminLoginLogoId() {
		return adminLoginLogoId;
	}

	public void setAdminLoginLogoId(Long adminLoginLogoId) {
		this.adminLoginLogoId = adminLoginLogoId;
	}

	public Long getAdminManageLogoId() {
		return adminManageLogoId;
	}

	public void setAdminManageLogoId(Long adminManageLogoId) {
		this.adminManageLogoId = adminManageLogoId;
	}

	public Long getGoodsImageId() {
		return goodsImageId;
	}

	public void setGoodsImageId(Long goodsImageId) {
		this.goodsImageId = goodsImageId;
	}

	public Long getMemberIconId() {
		return memberIconId;
	}

	public void setMemberIconId(Long memberIconId) {
		this.memberIconId = memberIconId;
	}

	public Long getQrLogoId() {
		return qrLogoId;
	}

	public void setQrLogoId(Long qrLogoId) {
		this.qrLogoId = qrLogoId;
	}

	public Long getStoreImageId() {
		return storeImageId;
	}

	public void setStoreImageId(Long storeImageId) {
		this.storeImageId = storeImageId;
	}

	public Long getStoreWeixinLogoId() {
		return storeWeixinLogoId;
	}

	public void setStoreWeixinLogoId(Long storeWeixinLogoId) {
		this.storeWeixinLogoId = storeWeixinLogoId;
	}

	public Long getWebsiteLogoId() {
		return websiteLogoId;
	}

	public void setWebsiteLogoId(Long websiteLogoId) {
		this.websiteLogoId = websiteLogoId;
	}

	public Long getWeixinQrImgId() {
		return weixinQrImgId;
	}

	public void setWeixinQrImgId(Long weixinQrImgId) {
		this.weixinQrImgId = weixinQrImgId;
	}

	public Long getWelcomeImgId() {
		return welcomeImgId;
	}

	public void setWelcomeImgId(Long welcomeImgId) {
		this.welcomeImgId = welcomeImgId;
	}

	public String getCloseReason() {
		return closeReason;
	}

	public void setCloseReason(String closeReason) {
		this.closeReason = closeReason;
	}

	public String getCodeStat() {
		return codeStat;
	}

	public void setCodeStat(String codeStat) {
		this.codeStat = codeStat;
	}

	public String getKuaidiId() {
		return kuaidiId;
	}

	public void setKuaidiId(String kuaidiId) {
		this.kuaidiId = kuaidiId;
	}

	public String getKuaidiId2() {
		return kuaidiId2;
	}

	public void setKuaidiId2(String kuaidiId2) {
		this.kuaidiId2 = kuaidiId2;
	}

	public String getPayoffMagAuto() {
		return payoffMagAuto;
	}

	public void setPayoffMagAuto(String payoffMagAuto) {
		this.payoffMagAuto = payoffMagAuto;
	}

	public String getPayoffMagDefault() {
		return payoffMagDefault;
	}

	public void setPayoffMagDefault(String payoffMagDefault) {
		this.payoffMagDefault = payoffMagDefault;
	}

	public String getQqDomainCode() {
		return qqDomainCode;
	}

	public void setQqDomainCode(String qqDomainCode) {
		this.qqDomainCode = qqDomainCode;
	}

	public String getServiceQqList() {
		return serviceQqList;
	}

	public void setServiceQqList(String serviceQqList) {
		this.serviceQqList = serviceQqList;
	}

	public String getServiceTelphoneList() {
		return serviceTelphoneList;
	}

	public void setServiceTelphoneList(String serviceTelphoneList) {
		this.serviceTelphoneList = serviceTelphoneList;
	}

	public String getShareCode() {
		return shareCode;
	}

	public void setShareCode(String shareCode) {
		this.shareCode = shareCode;
	}

	public String getSinaDomainCode() {
		return sinaDomainCode;
	}

	public void setSinaDomainCode(String sinaDomainCode) {
		this.sinaDomainCode = sinaDomainCode;
	}

	public String getStorePayment() {
		return storePayment;
	}

	public void setStorePayment(String storePayment) {
		this.storePayment = storePayment;
	}

	public String getSysDomain() {
		return sysDomain;
	}

	public void setSysDomain(String sysDomain) {
		this.sysDomain = sysDomain;
	}

	public String getTemplates() {
		return templates;
	}

	public void setTemplates(String templates) {
		this.templates = templates;
	}

	public String getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}

	public String getWeixinWelecomeContent() {
		return weixinWelecomeContent;
	}

	public void setWeixinWelecomeContent(String weixinWelecomeContent) {
		this.weixinWelecomeContent = weixinWelecomeContent;
	}

	public String getO2oHotSearch() {
		return o2oHotSearch;
	}

	public void setO2oHotSearch(String o2oHotSearch) {
		this.o2oHotSearch = o2oHotSearch;
	}

	public String getStaticServerAddress() {
		return staticServerAddress;
	}

	public void setStaticServerAddress(String staticServerAddress) {
		this.staticServerAddress = staticServerAddress;
	}
	
}
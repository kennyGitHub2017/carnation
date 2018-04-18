package com.sinco.carnation.resource.web.response.register;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.ArticleBO;
import com.sinco.carnation.resource.bo.CustomerBO;
import com.sinco.carnation.resource.bo.OpNoticesBO;
import com.sinco.carnation.resource.bo.RelationBO;
import com.sinco.carnation.resource.bo.UserDocumentBO;
import com.sinco.carnation.resource.bo.UserIntegralBO;
import com.sinco.carnation.resource.bo.check.UserSignBO;
import com.sinco.carnation.resource.bo.o2o.OperatorBankBO;
import com.sinco.carnation.resource.bo.o2o.StoreBankBO;

public class SearchCustomerResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("customer")
	@ReturnMapping(desc = "用户信息 ")
	private CustomerBO customer;

	@JsonProperty("integral")
	@ReturnMapping(desc = "用户积分信息")
	private UserIntegralBO integral;

	@JsonProperty("availableBalance")
	@ReturnMapping(desc = "用户云豆")
	private double availableBalance;

	@JsonProperty("recordBalance")
	@ReturnMapping(desc = "预分润云豆")
	private double recordBalance;

	@JsonProperty("balance")
	@ReturnMapping(desc = "用户财富")
	private BigDecimal balance;

	@JsonProperty("storeBankInfo")
	@ReturnMapping(desc = "商户银行信息")
	private StoreBankBO storeBankInfo;

	@JsonProperty("operatorBankInfo")
	@ReturnMapping(desc = "商营运商银行信息")
	private OperatorBankBO operatorBankInfo;

	@JsonProperty("userSign")
	@ReturnMapping(desc = "用户签到对象")
	private UserSignBO userSign;

	@JsonProperty("bindingMobile")
	@ReturnMapping(desc = "第三方平台是否绑定平台帐号")
	private String bindingMobile;

	@JsonProperty("isBinding")
	@ReturnMapping(desc = "第三方平台是否绑定标志")
	private Boolean isBinding;

	@JsonProperty("bindingOpenId")
	@ReturnMapping(desc = "第三方平台是否绑定平台id")
	private String bindingOpenId;

	@JsonProperty("documet")
	@ReturnMapping(desc = "系统帮助")
	private UserDocumentBO documet;

	@JsonProperty("articleList")
	@ReturnMapping(desc = "平台发给商户公告")
	private List<ArticleBO> opArticleList;

	@JsonProperty("opNoticesBOs")
	@ReturnMapping(desc = "营运发给商户公告")
	private List<OpNoticesBO> opNoticesBOs;

	@JsonProperty("articleBO")
	@ReturnMapping(desc = "营运商公告和商户平台公告明细")
	private ArticleBO articleBO;

	@JsonProperty("noticesBO")
	@ReturnMapping(desc = "营运商发给商户的公告明细")
	private OpNoticesBO noticesBO;

	@JsonProperty("articMarkleList")
	@ReturnMapping(desc = "文章列表")
	private List<ArticleBO> articMarkleList;

	@JsonProperty("articMarkleDetails")
	@ReturnMapping(desc = "公告详情")
	private ArticleBO articMarkleDetails;

	@JsonProperty("ralationList")
	@ReturnMapping(desc = "邀请人明细")
	private List<RelationBO> ralationList;

	@JsonProperty("relationCount")
	@ReturnMapping(desc = "邀请人总数")
	private Long relationCount;

	@JsonProperty("isCloudPassword")
	@ReturnMapping(desc = "是否设置了云豆密码")
	private boolean isCloudPassword = false;

	@JsonProperty("mobile")
	@ReturnMapping(desc = "手机号码")
	private String mobile;

	@JsonProperty("levelOneCount")
	@ReturnMapping(desc = "第一级别人数")
	private int levelOneCount;

	@JsonProperty("levelTwoCount")
	@ReturnMapping(desc = "第二级别人数")
	private int levelTwoCount;

	@JsonProperty("levelThreeCount")
	@ReturnMapping(desc = "第三级别人数")
	private int levelThreeCount;

	@JsonProperty("cNBonus")
	@ReturnMapping(desc = "CN账户的奖金")
	private double cNBonus;

	@JsonProperty("cNRepeat")
	@ReturnMapping(desc = "CN账户的云购币(冲销币)")
	private double cNRepeat;
	
	@JsonProperty("countMoney")
	@ReturnMapping(desc = "用户总云豆")
	private double countMoney;
	
	@JsonProperty("cNrecharge")
	@ReturnMapping(desc = "充值账户余额")
	private double cNrecharge;
	
	@JsonProperty("cnIntegral")
	@ReturnMapping(desc = "CN会员购物积分")
	private double cnIntegral;

	public int getLevelOneCount() {
		return levelOneCount;
	}

	public double getcNBonus() {
		return cNBonus;
	}

	public void setcNBonus(double cNBonus) {
		this.cNBonus = cNBonus;
	}

	public double getcNRepeat() {
		return cNRepeat;
	}

	public void setcNRepeat(double cNRepeat) {
		this.cNRepeat = cNRepeat;
	}

	public void setLevelOneCount(int levelOneCount) {
		this.levelOneCount = levelOneCount;
	}

	public int getLevelTwoCount() {
		return levelTwoCount;
	}

	public void setLevelTwoCount(int levelTwoCount) {
		this.levelTwoCount = levelTwoCount;
	}

	public int getLevelThreeCount() {
		return levelThreeCount;
	}

	public void setLevelThreeCount(int levelThreeCount) {
		this.levelThreeCount = levelThreeCount;
	}

	public ArticleBO getArticMarkleDetails() {
		return articMarkleDetails;
	}

	public void setArticMarkleDetails(ArticleBO articMarkleDetails) {
		this.articMarkleDetails = articMarkleDetails;
	}

	public UserIntegralBO getIntegral() {
		return integral;
	}

	public void setIntegral(UserIntegralBO integral) {
		this.integral = integral;
	}

	public CustomerBO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerBO customer) {
		this.customer = customer;
	}

	public double getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public StoreBankBO getStoreBankInfo() {
		return storeBankInfo;
	}

	public void setStoreBankInfo(StoreBankBO storeBankInfo) {
		this.storeBankInfo = storeBankInfo;
	}

	public OperatorBankBO getOperatorBankInfo() {
		return operatorBankInfo;
	}

	public void setOperatorBankInfo(OperatorBankBO operatorBankInfo) {
		this.operatorBankInfo = operatorBankInfo;
	}

	public String getBindingMobile() {
		return bindingMobile;
	}

	public void setBindingMobile(String bindingMobile) {
		this.bindingMobile = bindingMobile;
	}

	public Boolean getIsBinding() {
		return isBinding;
	}

	public void setIsBinding(Boolean isBinding) {
		this.isBinding = isBinding;
	}

	public String getBindingOpenId() {
		return bindingOpenId;
	}

	public void setBindingOpenId(String bindingOpenId) {
		this.bindingOpenId = bindingOpenId;
	}

	public UserSignBO getUserSign() {
		return userSign;
	}

	public void setUserSign(UserSignBO userSign) {
		this.userSign = userSign;
	}

	public UserDocumentBO getDocumet() {
		return documet;
	}

	public void setDocumet(UserDocumentBO documet) {
		this.documet = documet;
	}

	public List<ArticleBO> getOpArticleList() {
		return opArticleList;
	}

	public void setOpArticleList(List<ArticleBO> opArticleList) {
		this.opArticleList = opArticleList;
	}

	public List<OpNoticesBO> getOpNoticesBOs() {
		return opNoticesBOs;
	}

	public void setOpNoticesBOs(List<OpNoticesBO> opNoticesBOs) {
		this.opNoticesBOs = opNoticesBOs;
	}

	public ArticleBO getArticleBO() {
		return articleBO;
	}

	public void setArticleBO(ArticleBO articleBO) {
		this.articleBO = articleBO;
	}

	public OpNoticesBO getNoticesBO() {
		return noticesBO;
	}

	public void setNoticesBO(OpNoticesBO noticesBO) {
		this.noticesBO = noticesBO;
	}

	public List<ArticleBO> getArticMarkleList() {
		return articMarkleList;
	}

	public void setArticMarkleList(List<ArticleBO> articMarkleList) {
		this.articMarkleList = articMarkleList;
	}

	public List<RelationBO> getRalationList() {
		return ralationList;
	}

	public void setRalationList(List<RelationBO> ralationList) {
		this.ralationList = ralationList;
	}

	public Long getRelationCount() {
		return relationCount;
	}

	public void setRelationCount(Long relationCount) {
		this.relationCount = relationCount;
	}

	public boolean isCloudPassword() {
		return isCloudPassword;
	}

	public void setCloudPassword(boolean isCloudPassword) {
		this.isCloudPassword = isCloudPassword;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public double getRecordBalance() {
		return recordBalance;
	}

	public void setRecordBalance(double recordBalance) {
		this.recordBalance = recordBalance;
	}

	public double getCountMoney() {
		return countMoney;
	}

	public void setCountMoney(double countMoney) {
		this.countMoney = countMoney;
	}

	public double getcNrecharge() {
		return cNrecharge;
	}

	public void setcNrecharge(double cNrecharge) {
		this.cNrecharge = cNrecharge;
	}

	public double getCnIntegral() {
		return cnIntegral;
	}

	public void setCnIntegral(double cnIntegral) {
		this.cnIntegral = cnIntegral;
	}

	// @JsonProperty("uid")
	// @ReturnMapping(desc="用户id")
	// private Long uid;
	//
	// @JsonProperty("nickName")
	// @ReturnMapping(desc="用户昵称")
	// private String nickName;
	//
	// @JsonProperty("name")
	// @ReturnMapping(desc="用户名称")
	// private String name;
	//
	// @JsonProperty("allergHistory")
	// @ReturnMapping(desc="用户过敏史")
	// private String allergHistory;
	//
	// @JsonProperty("sex")
	// @ReturnMapping(desc="性别")
	// private Long sex;
	//
	// @JsonProperty("height")
	// @ReturnMapping(desc="用户身高")
	// private Long height;
	//
	// @JsonProperty("weight")
	// @ReturnMapping(desc="用户体重")
	// private Long weight;
	//
	// @JsonProperty("birthDate")
	// @ReturnMapping(desc="用户生日")
	// private String birthDate;
	//
	// @JsonProperty("headImgPath")
	// @ReturnMapping(desc="用户头像路径")
	// private String headImgPath;
	//
	// @JsonProperty("email")
	// @ReturnMapping(desc="用户电子邮件")
	// private String email;
	//
	// @JsonProperty("mobile")
	// @ReturnMapping(desc="用户手机")
	// private String mobile;
	//
	// @JsonProperty("status")
	// @ReturnMapping(desc="用户状态")
	// private String status;
	//
	// @JsonProperty("creatBy")
	// @ReturnMapping(desc="创建人")
	// private String creatBy;
	//
	// // @JsonProperty("createTime")
	// // @ReturnMapping(desc="用户创建时间")
	// // private String createTime;
	// //
	// // @JsonProperty("updateBy")
	// // @ReturnMapping(desc="用户修改时间")
	// // private String updateBy;
	//
	// public Long getUid() {
	// return uid;
	// }
	//
	// public void setUid(Long uid) {
	// this.uid = uid;
	// }
	//
	// public String getNickName() {
	// return nickName;
	// }
	//
	// public void setNickName(String nickName) {
	// this.nickName = nickName;
	// }
	//
	// public String getName() {
	// return name;
	// }
	//
	// public void setName(String name) {
	// this.name = name;
	// }
	//
	// public String getAllergHistory() {
	// return allergHistory;
	// }
	//
	// public void setAllergHistory(String allergHistory) {
	// this.allergHistory = allergHistory;
	// }
	//
	// public Long getSex() {
	// return sex;
	// }
	//
	// public void setSex(Long sex) {
	// this.sex = sex;
	// }
	//
	// public Long getHeight() {
	// return height;
	// }
	//
	// public void setHeight(Long height) {
	// this.height = height;
	// }
	//
	// public Long getWeight() {
	// return weight;
	// }
	//
	// public void setWeight(Long weight) {
	// this.weight = weight;
	// }
	//
	// public String getBirthDate() {
	// return birthDate;
	// }
	//
	// public void setBirthDate(String birthDate) {
	// this.birthDate = birthDate;
	// }
	//
	// public String getHeadImgPath() {
	// return headImgPath;
	// }
	//
	// public void setHeadImgPath(String headImgPath) {
	// this.headImgPath = headImgPath;
	// }
	//
	// public String getEmail() {
	// return email;
	// }
	//
	// public void setEmail(String email) {
	// this.email = email;
	// }
	//
	// public String getMobile() {
	// return mobile;
	// }
	//
	// public void setMobile(String mobile) {
	// this.mobile = mobile;
	// }
	//
	// public String getStatus() {
	// return status;
	// }
	//
	// public void setStatus(String status) {
	// this.status = status;
	// }
	//
	// public String getCreatBy() {
	// return creatBy;
	// }
	//
	// public void setCreatBy(String creatBy) {
	// this.creatBy = creatBy;
	// }
	//
	//
	// public String getUpdateTime() {
	// return updateTime;
	// }
	//
	// public void setUpdateTime(String updateTime) {
	// this.updateTime = updateTime;
	// }
	//
	// public boolean isDelet() {
	// return isDelet;
	// }
	//
	// public void setDelet(boolean isDelet) {
	// this.isDelet = isDelet;
	// }
	//
	// public static long getSerialversionuid() {
	// return serialVersionUID;
	// }
	//
	// @JsonProperty("updateTime")
	// @ReturnMapping(desc="用户修改时间")
	// private String updateTime;
	//
	// @JsonProperty("isDelete")
	// @ReturnMapping(desc="是否删除")
	// private boolean isDelet;
}

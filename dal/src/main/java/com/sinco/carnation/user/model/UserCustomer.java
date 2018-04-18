package com.sinco.carnation.user.model;

import java.math.BigDecimal;
import java.util.Date;

import com.sinco.mybatis.dal.model.BaseModel;

public class UserCustomer extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5309632882687210775L;

	/** 用户id **/
	private Long uid;

	private String createBy; // 创建者
	private Date createTime;// 创建日期
	private String updateBy; // 更新者
	private Date updateTime;// 更新日期

	/** 姓名 **/
	private String name;

	/** 昵称 **/
	private String nickname;

	/** 药物过敏史 **/
	private String allergicHistory;

	/** 性别 1，男 2，女 **/
	private Integer sex;

	/** 身高 **/
	private Integer height;

	/** 体重 **/
	private Integer weight;

	/** 出生日期 **/
	private Date birthdate;

	/** 头像路径 **/
	private String headImgPath;

	/** 邮箱 **/
	private String email;

	/** 手机 **/
	private String mobile;

	/** 状态 1:正常 2：未激活 **/
	private String status;

	/** 是否删除 **/
	private Boolean isDeleted;

	/** 家族药物过敏史 **/
	private String transHistory;

	/** 家族遗传病史 **/
	private String transGenetic;

	/** 冻结余额 **/
	private BigDecimal freezeBlance;

	/** 用户积分 **/
	private Integer integral;

	/** 金币 **/
	private Integer gold;

	/** 用户发票信息 **/
	private String invoice;

	/** 发票类型 **/
	private Integer invoiceType;

	/** 用户所申请的自提点id **/
	private Long deliveryId;

	/** 用户保密 **/
	private String userMark;
	/** 血型 **/
	private String blood;
	/**
	 * 该用户总商品消费金额，1、用于计算用户等级，消费越高，等级越高。2、平台发放优惠券时（如：限制人数100人），按照用户消费金额排序，前100人可以得到该优惠券
	 */
	private BigDecimal userGoodsFee;

	/** 用户个性签名 **/
	private String userSignature;

	/** 扩展字段 **/
	private String extend;

	public String getExtend() {
		return extend;
	}

	public void setExtend(String extend) {
		this.extend = extend;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getAllergicHistory() {
		return allergicHistory;
	}

	public void setAllergicHistory(String allergicHistory) {
		this.allergicHistory = allergicHistory;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getHeadImgPath() {
		return headImgPath;
	}

	public void setHeadImgPath(String headImgPath) {
		this.headImgPath = headImgPath;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getTransHistory() {
		return transHistory;
	}

	public void setTransHistory(String transHistory) {
		this.transHistory = transHistory;
	}

	public String getTransGenetic() {
		return transGenetic;
	}

	public void setTransGenetic(String transGenetic) {
		this.transGenetic = transGenetic;
	}

	public BigDecimal getFreezeBlance() {
		return freezeBlance;
	}

	public void setFreezeBlance(BigDecimal freezeBlance) {
		this.freezeBlance = freezeBlance;
	}

	public Integer getIntegral() {
		return integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	public Integer getGold() {
		return gold;
	}

	public void setGold(Integer gold) {
		this.gold = gold;
	}

	public String getInvoice() {
		return invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	public Integer getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(Integer invoiceType) {
		this.invoiceType = invoiceType;
	}

	public Long getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
	}

	public String getUserMark() {
		return userMark;
	}

	public void setUserMark(String userMark) {
		this.userMark = userMark;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getBlood() {
		return blood;
	}

	public void setBlood(String blood) {
		this.blood = blood;
	}

	public BigDecimal getUserGoodsFee() {
		return userGoodsFee;
	}

	public void setUserGoodsFee(BigDecimal userGoodsFee) {
		this.userGoodsFee = userGoodsFee;
	}

	public String getUserSignature() {
		return userSignature;
	}

	public void setUserSignature(String userSignature) {
		this.userSignature = userSignature;
	}
}
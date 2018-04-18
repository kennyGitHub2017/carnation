package com.sinco.carnation.market.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.math.BigDecimal;
import java.util.Date;

public class ActRedPackage extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3168306813713561512L;

	/** 主键id **/
	private Long id;

	/** code编码 **/
	private String vcode;

	/** 最新金额 **/
	private BigDecimal minMoney;

	/** 最大金额 **/
	private BigDecimal maxMoney;

	/** 红包类型 1-随机,2-固定(取min_money) **/
	private Byte fixType;

	/** 方案名称 **/
	private String schemeName;

	/** 发行量,0为不限制 **/
	private Long totalCount;

	/** 总发行金额 **/
	private BigDecimal totalMoney;

	/** 领取量 **/
	private Long getCount;

	/** 每人限领取量,0为不限制 **/
	private Long perLimitCount;

	/** 权重 **/
	private Integer priority;

	/** 商家类型 0 通用 1 自营2 商家 **/
	private Byte shopType;

	/** 商家Id **/
	private Long storeId;

	/** 终端类型 1 通用 2 手机App 3 Web **/
	private Byte terminalType;

	/** 是否启用 **/
	private Byte isEnabled;

	/** 封面图片路径 **/
	private String logoPath;

	/** 限领用户条件 0 无条件 1 新会员 2 老会员（无消费）3 老会员（有消费） **/
	private Byte userType;

	/** 领取方式 0 无限 1 注册2 买后3 买前 4 随机 **/
	private Byte getType;

	/** 活动位置 0 无 1登录前 2 登录后3 活动页面 4 首页 5 购物车 6 付款后(逗号拆分) **/
	private String actPosition;

	/** 开始时间 **/
	private Date startTime;

	/** 结束时间 **/
	private Date endTime;

	/** 删除状态 0 正常数据(默认值),1 删除状态' **/
	private Byte deleteStatus;

	/**  **/
	private Long createBy;

	/**  **/
	private Date createTime;

	/**  **/
	private Long modifyBy;

	/**  **/
	private Date modifyTime;

	/** 拆包数量 **/
	private Long currentOpenCount;

	/** 领取数量 **/
	private Long currentGetCount;

	/** 描述 **/
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVcode() {
		return vcode;
	}

	public void setVcode(String vcode) {
		this.vcode = vcode;
	}

	public BigDecimal getMinMoney() {
		return minMoney;
	}

	public void setMinMoney(BigDecimal minMoney) {
		this.minMoney = minMoney;
	}

	public BigDecimal getMaxMoney() {
		return maxMoney;
	}

	public void setMaxMoney(BigDecimal maxMoney) {
		this.maxMoney = maxMoney;
	}

	public Byte getFixType() {
		return fixType;
	}

	public void setFixType(Byte fixType) {
		this.fixType = fixType;
	}

	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public BigDecimal getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}

	public Long getGetCount() {
		return getCount;
	}

	public void setGetCount(Long getCount) {
		this.getCount = getCount;
	}

	public Long getPerLimitCount() {
		return perLimitCount;
	}

	public void setPerLimitCount(Long perLimitCount) {
		this.perLimitCount = perLimitCount;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Byte getShopType() {
		return shopType;
	}

	public void setShopType(Byte shopType) {
		this.shopType = shopType;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public Byte getTerminalType() {
		return terminalType;
	}

	public void setTerminalType(Byte terminalType) {
		this.terminalType = terminalType;
	}

	public Byte getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Byte isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getLogoPath() {
		return logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

	public Byte getUserType() {
		return userType;
	}

	public void setUserType(Byte userType) {
		this.userType = userType;
	}

	public Byte getGetType() {
		return getType;
	}

	public void setGetType(Byte getType) {
		this.getType = getType;
	}

	public String getActPosition() {
		return actPosition;
	}

	public void setActPosition(String actPosition) {
		this.actPosition = actPosition;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Byte getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Byte deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(Long modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Long getCurrentOpenCount() {
		return currentOpenCount;
	}

	public void setCurrentOpenCount(Long currentOpenCount) {
		this.currentOpenCount = currentOpenCount;
	}

	public Long getCurrentGetCount() {
		return currentGetCount;
	}

	public void setCurrentGetCount(Long currentGetCount) {
		this.currentGetCount = currentGetCount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
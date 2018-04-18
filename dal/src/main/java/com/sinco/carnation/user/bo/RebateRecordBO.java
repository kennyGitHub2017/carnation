package com.sinco.carnation.user.bo;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

import com.sinco.carnation.shop.RebateConstants;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.user.model.Operator;
import com.sinco.carnation.user.model.RebateRecord;
import com.sinco.dic.client.annotation.DicMappingModel;
import com.sinco.dic.client.annotation.DicNameMapping;

/**
 * 
 * BO 用于返回数据
 * 
 */
@DicMappingModel
public class RebateRecordBO extends RebateRecord {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4995939371705850068L;

	private BigDecimal totalRebateAmout;// 总分润

	private Integer years;// 年
	private Integer months;// 月

	private String localGroupName;// 线下服务名称
	private String nickname;// 消费者昵称
	private String mobile;// 消费者电话
	private String groupSn;// 消费码
	private String userNickName;
	private BigDecimal rebateAmount;// 分润金额
	private String ggName;// 服务名称
	private String storeName;
	private Long storeId;
	private String loginName;

	private String orderType;// 订单/消费码

	private Operator operator;

	@DicNameMapping(type = Area.class, codeField = "operator.operatorAreaId", mergeChar = "-", isFull = true)
	private String operatorAreaName;

	public String getOperatorAreaName() {
		return operatorAreaName;
	}

	public void setOperatorAreaName(String operatorAreaName) {
		this.operatorAreaName = operatorAreaName;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public String getRebateName() {
		if (StringUtils.isNotEmpty(super.getRebateType())) {
			return RebateConstants.getRebateNameByType(super.getRebateType());
		}
		return null;
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

	public BigDecimal getTotalRebateAmout() {
		return totalRebateAmout;
	}

	public void setTotalRebateAmout(BigDecimal totalRebateAmout) {
		this.totalRebateAmout = totalRebateAmout;
	}

	public Integer getYears() {
		return years;
	}

	public void setYears(Integer years) {
		this.years = years;
	}

	public Integer getMonths() {
		return months;
	}

	public void setMonths(Integer months) {
		this.months = months;
	}

	public String getLocalGroupName() {
		return localGroupName;
	}

	public void setLocalGroupName(String localGroupName) {
		this.localGroupName = localGroupName;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGroupSn() {
		return groupSn;
	}

	public void setGroupSn(String groupSn) {
		this.groupSn = groupSn;
	}

	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	public BigDecimal getRebateAmount() {
		return rebateAmount;
	}

	public void setRebateAmount(BigDecimal rebateAmount) {
		this.rebateAmount = rebateAmount;
	}

	public String getGgName() {
		return ggName;
	}

	public void setGgName(String ggName) {
		this.ggName = ggName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

}
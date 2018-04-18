package com.sinco.carnation.o2o.bo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.sinco.carnation.o2o.model.GroupOrder;
import com.sinco.carnation.store.model.Store;
import com.sinco.carnation.user.model.UserCustomer;

/**
 * 
 * BO 用于返回数据
 * 
 */
@SuppressWarnings("serial")
public class GroupOrderBO extends GroupOrder {
	private List<GroupInfoBO> groupInfoBOList;
	// 买家信息
	private UserCustomer userCustomer;
	String StoreMobile;
	private String groupSn;// 消费码
	private BigDecimal totalRebateAmout;// 总分润
	private BigDecimal monthTotalPrice;// 月总收入
	private Integer years;// 年
	private Integer months;// 月
	private String nickName;
	private String mobile;
	// 商户信息
	private Store store;
	private BigDecimal goodsPrice;
	private String goodsCount;
	private String groupAccPath;
	private String ggName;
	private BigDecimal totalPrice;
	private Integer status;
	private String storeName;
	private String storeTelephone;
	private Date endTime;
	private String storeAddress;

	private BigDecimal storeLat;
	private BigDecimal storeLon;
	private BigDecimal groupPrice;// 消费码价格
	// 原始价格（折扣前）
	private BigDecimal originalPrice;
	GroupComplaintBO groupComplaintBO;

	public String getStoreMobile() {
		return StoreMobile;
	}

	public void setStoreMobile(String storeMobile) {
		StoreMobile = storeMobile;
	}

	public GroupComplaintBO getGroupComplaintBO() {
		return groupComplaintBO;
	}

	public void setGroupComplaintBO(GroupComplaintBO groupComplaintBO) {
		this.groupComplaintBO = groupComplaintBO;
	}

	// 状态数量
	private Integer statusCount;

	public String getStoreTelephone() {
		return storeTelephone;
	}

	public void setStoreTelephone(String storeTelephone) {
		this.storeTelephone = storeTelephone;
	}

	public Integer getStatusCount() {
		return statusCount;
	}

	public void setStatusCount(Integer statusCount) {
		this.statusCount = statusCount;
	}

	public String getGoodsCount() {
		return goodsCount;
	}

	public void setGoodsCount(String goodsCount) {
		this.goodsCount = goodsCount;
	}

	public BigDecimal getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(BigDecimal goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public List<GroupInfoBO> getGroupInfoBOList() {
		return groupInfoBOList;
	}

	public void setGroupInfoBOList(List<GroupInfoBO> groupInfoBOList) {
		this.groupInfoBOList = groupInfoBOList;
	}

	public UserCustomer getUserCustomer() {
		return userCustomer;
	}

	public void setUserCustomer(UserCustomer userCustomer) {
		this.userCustomer = userCustomer;
	}

	public String getGroupSn() {
		return groupSn;
	}

	public void setGroupSn(String groupSn) {
		this.groupSn = groupSn;
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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public BigDecimal getMonthTotalPrice() {
		return monthTotalPrice;
	}

	public void setMonthTotalPrice(BigDecimal monthTotalPrice) {
		this.monthTotalPrice = monthTotalPrice;
	}

	public String getGroupAccPath() {
		return groupAccPath;
	}

	public void setGroupAccPath(String groupAccPath) {
		this.groupAccPath = groupAccPath;
	}

	public String getGgName() {
		return ggName;
	}

	public void setGgName(String ggName) {
		this.ggName = ggName;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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

	public BigDecimal getGroupPrice() {
		return groupPrice;
	}

	public void setGroupPrice(BigDecimal groupPrice) {
		this.groupPrice = groupPrice;
	}

	public BigDecimal getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(BigDecimal originalPrice) {
		this.originalPrice = originalPrice;
	}
}
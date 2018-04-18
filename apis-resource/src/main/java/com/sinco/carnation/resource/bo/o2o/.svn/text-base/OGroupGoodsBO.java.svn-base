package com.sinco.carnation.resource.bo.o2o;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "GroupGoods", desc = "团购商品信息")
public class OGroupGoodsBO {

	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;

	@JsonProperty("ggName")
	@FieldMapping(desc = "商品名称")
	private String ggName;

	@JsonProperty("costPrice")
	@FieldMapping(desc = "原价")
	private BigDecimal costPrice;

	@JsonProperty("ggRebate")
	@FieldMapping(desc = "团购折扣")
	private BigDecimal ggRebate;

	@JsonProperty("groupPrice")
	@FieldMapping(desc = "团队价 ")
	private BigDecimal groupPrice;

	@JsonProperty("ggStatus")
	@FieldMapping(desc = "商品状态 |  0为上架，1为在仓库中，3为店铺过期自动下架，-2为违规下架状态")
	private Integer ggStatus;

	@JsonProperty("groupAccPath")
	@FieldMapping(desc = "团购图片")
	private String groupAccPath;

	@JsonProperty("groupDesc")
	@FieldMapping(desc = "服务描述")
	private String groupMobileDesc;

	@JsonProperty("beginTime")
	@FieldMapping(desc = "开始时间")
	private Date beginTime;

	@JsonProperty("endTime")
	@FieldMapping(desc = "结束时间")
	private Date endTime;

	@JsonProperty("selledCount")
	@FieldMapping(desc = "已经售出的数量")
	private Integer selledCount;

	@JsonProperty("groupNotice")
	@FieldMapping(desc = "购买须知")
	private String groupNotice;

	@JsonProperty("nickName")
	@FieldMapping(desc = "消费用户昵称")
	private String nickName;

	@JsonProperty("mobile")
	@FieldMapping(desc = "消费用户手机")
	private String mobile;

	@JsonProperty("groupSn")
	@FieldMapping(desc = "消费码")
	private String groupSn;

	@JsonProperty("status")
	@FieldMapping(desc = "券消费状态|默认为0，使用后为1，过期为-1")
	private Integer status;

	@JsonProperty("storeName")
	@FieldMapping(desc = "店铺名称")
	private String storeName;

	@JsonProperty("storeAddress")
	@FieldMapping(desc = "店铺地址")
	private String storeAddress;

	@JsonProperty("likeGoodsList")
	@FieldMapping(desc = "猜你喜欢列表")
	private List<OGroupGoodsBO> likeGoodsList;

	@JsonProperty("distance")
	@FieldMapping(desc = "距离")
	private Double distance;

	@JsonProperty("licenseCTelephone")
	@FieldMapping(desc = "公司电话")
	private String licenseCTelephone;// 店铺电话

	@JsonProperty("storeLat")
	@FieldMapping(desc = "纬度")
	private Double storeLat;

	@JsonProperty("storeLon")
	@FieldMapping(desc = "经度")
	private Double storeLon;

	@JsonProperty("storeTelephone")
	@FieldMapping(desc = "店铺电话")
	private String storeTelephone;

	@JsonProperty("storeId")
	@FieldMapping(desc = "店铺id")
	private Long storeId;

	@JsonProperty("groupCount")
	@FieldMapping(desc = "库存数量")
	private Integer groupCount;

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGgName() {
		return ggName;
	}

	public void setGgName(String ggName) {
		this.ggName = ggName;
	}

	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}

	public BigDecimal getGgRebate() {
		return ggRebate;
	}

	public void setGgRebate(BigDecimal ggRebate) {
		this.ggRebate = ggRebate;
	}

	public BigDecimal getGroupPrice() {
		return groupPrice;
	}

	public void setGroupPrice(BigDecimal groupPrice) {
		this.groupPrice = groupPrice;
	}

	public Integer getGgStatus() {
		return ggStatus;
	}

	public void setGgStatus(Integer ggStatus) {
		this.ggStatus = ggStatus;
	}

	public String getGroupAccPath() {
		return groupAccPath;
	}

	public void setGroupAccPath(String groupAccPath) {
		this.groupAccPath = groupAccPath;
	}

	public String getGroupMobileDesc() {
		return groupMobileDesc;
	}

	public void setGroupMobileDesc(String groupMobileDesc) {
		this.groupMobileDesc = groupMobileDesc;
	}

	public Integer getSelledCount() {
		return selledCount;
	}

	public void setSelledCount(Integer selledCount) {
		this.selledCount = selledCount;
	}

	public String getGroupNotice() {
		return groupNotice;
	}

	public void setGroupNotice(String groupNotice) {
		this.groupNotice = groupNotice;
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

	public Date getBeginTime() {
		return beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public List<OGroupGoodsBO> getLikeGoodsList() {
		return likeGoodsList;
	}

	public void setLikeGoodsList(List<OGroupGoodsBO> likeGoodsList) {
		this.likeGoodsList = likeGoodsList;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public String getLicenseCTelephone() {
		return licenseCTelephone;
	}

	public void setLicenseCTelephone(String licenseCTelephone) {
		this.licenseCTelephone = licenseCTelephone;
	}

	public Double getStoreLat() {
		return storeLat;
	}

	public void setStoreLat(Double storeLat) {
		this.storeLat = storeLat;
	}

	public Double getStoreLon() {
		return storeLon;
	}

	public void setStoreLon(Double storeLon) {
		this.storeLon = storeLon;
	}

	public String getStoreTelephone() {
		return storeTelephone;
	}

	public void setStoreTelephone(String storeTelephone) {
		this.storeTelephone = storeTelephone;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public Integer getGroupCount() {
		return groupCount;
	}

	public void setGroupCount(Integer groupCount) {
		this.groupCount = groupCount;
	}

}

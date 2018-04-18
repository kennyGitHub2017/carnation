package com.sinco.carnation.goods.bo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.nutz.json.Json;

import com.sinco.carnation.goods.GoodsConstants;
import com.sinco.carnation.goods.model.Goods;
import com.sinco.carnation.shop.model.Transport;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.user.bo.UserGoodsClassBO;
import com.sinco.dic.client.annotation.DicMappingModel;
import com.sinco.dic.client.annotation.DicNameMapping;

/**
 * 
 * BO 用于返回数据
 * 
 */
@SuppressWarnings("serial")
@DicMappingModel
public class GoodsBO extends Goods {

	@DicNameMapping(type = GoodsClassBO.class, codeField = "gcId", mergeChar = ">", isFull = true)
	private String goodsClassName;

	private String brandName;

	private String userName;

	// 店铺二级域名
	private String storeSecondDomain;

	private String goodsSpecIds;

	private String goodsProperties;

	private String intentoryDetails;

	private String userClassIds;

	private String imageIds;

	private String fCodeProfix;

	private String fCodeCount;

	private String currentStatus;

	private String publishDay;
	private String publishHour;
	private String publishMin;

	private BigDecimal mobilePrice;
	private String storeName;
	private String likebBrandName;// 增加字段根据品牌模糊查询商品
	private String img_pids;//图片和路径
	private String goodsSpecificationIds;//产品选择的规格
    

    /** 移动M站落地页完整URL (cps推广url) **/
    private String targetUrlM;
    private Integer isJuanpi;
    private Integer isTuangou;
    /** 商品拼团价格，单位“元”，两位小数 **/
    private BigDecimal tuanCprice;

	// private String deliveryAreaSheng;
	// private String deliveryAreaShi;
	// private String deliveryAreaXian;

	public String getLikebBrandName() {
		return likebBrandName;
	}

	public void setLikebBrandName(String likebBrandName) {
		this.likebBrandName = likebBrandName;
	}

	private BigDecimal goodsShowPrice;

	private List<GoodsSpecPropertyBO> goodsSpecsList;

	private List<GoodsPhotoBO> goodsPhotosList;

	private List<UserGoodsClassBO> goodsUgcs;

	private StoreBO goodsStore;

	private Transport transport;
	// 用户昵称
	private String nickName;
	private Date createTime;
	private String keyWordIdStr; // 关键字字符串

	private BigDecimal needYgb; // 需要的云购币
	private BigDecimal needMoney;// 需要的现金
	private Integer isYgb;// 是否是云购币商品0否 1是 ，其他否

	public boolean getInventoryStatus() {
		if (super.getGoodsInventory() <= 0) {
			return true;
		}
		return false;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public void setMobilePrice(BigDecimal mobilePrice) {
		this.mobilePrice = mobilePrice;
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	public BigDecimal getMobilePrice() {
		if (GoodsConstants.GOODS_INVENTORY_TYPE_SPEC.equals(super.getInventoryType())) {
			List<Map> list = Json.fromJson(ArrayList.class, super.getGoodsInventoryDetail());
			if (CollectionUtils.isNotEmpty(list)) {
				for (Map map : list) {
					if (mobilePrice == null) {
						if (map.get("mobilePrice") != null)
							mobilePrice = new BigDecimal(map.get("mobilePrice").toString());
					} else {
						if (map.get("mobilePrice") != null && !map.get("mobilePrice").equals("")) {
							if (mobilePrice.doubleValue() >= new BigDecimal(map.get("mobilePrice").toString())
									.doubleValue()) {
								mobilePrice = new BigDecimal(map.get("mobilePrice").toString());
							}
						}
					}
				}
			}
		}
		if (mobilePrice != null) {
			mobilePrice = mobilePrice.setScale(2, BigDecimal.ROUND_HALF_UP);
		} else {
			if (getHasMobilePrice() != null) {
				if (getHasMobilePrice()) {
					mobilePrice = getGoodsMobilePrice();
				}
			}
		}
		return mobilePrice;
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	public BigDecimal getGoodsShowPrice() {
		if (GoodsConstants.GOODS_INVENTORY_TYPE_SPEC.equals(super.getInventoryType())) {
			List<Map> list = Json.fromJson(ArrayList.class, super.getGoodsInventoryDetail());
			if (CollectionUtils.isNotEmpty(list)) {
				Map defaultMap = null;
				for (Map map : list) {
					if (goodsShowPrice == null) {
						goodsShowPrice = new BigDecimal(map.get("price").toString());
						defaultMap = map;
					} else {
						if (goodsShowPrice.doubleValue() > new BigDecimal(map.get("price").toString())
								.doubleValue()) {
							goodsShowPrice = new BigDecimal(map.get("price").toString());
							defaultMap = map;
						}
					}
				}
				if (defaultMap != null) {
					if (defaultMap.get("selfAddPrice") != null) {
						this.setSelfAddPrice(new BigDecimal(defaultMap.get("selfAddPrice").toString()));
					}
					if (defaultMap.get("cnSelfAddPrice") != null) {
						this.setCnSelfAddPrice(new BigDecimal(defaultMap.get("cnSelfAddPrice").toString()));
					}
				}
			} else {
				goodsShowPrice = getGoodsCurrentPrice();
			}
		} else {
			goodsShowPrice = getGoodsCurrentPrice();
		}
		if (goodsShowPrice != null) {
			goodsShowPrice = goodsShowPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
		}
		if ("juanpi".equals(super.getInventoryType())) {
			goodsShowPrice = getGoodsCurrentPrice();
		}
		return goodsShowPrice;
	}

	public void setGoodsShowPrice(BigDecimal goodsShowPrice) {
		this.goodsShowPrice = goodsShowPrice;
	}

	// public String getDeliveryAreaSheng() {
	// return deliveryAreaSheng;
	// }
	//
	// public void setDeliveryAreaSheng(String deliveryAreaSheng) {
	// this.deliveryAreaSheng = deliveryAreaSheng;
	// }
	//
	// public String getDeliveryAreaShi() {
	// return deliveryAreaShi;
	// }
	//
	// public void setDeliveryAreaShi(String deliveryAreaShi) {
	// this.deliveryAreaShi = deliveryAreaShi;
	// }
	//
	// public String getDeliveryAreaXian() {
	// return deliveryAreaXian;
	// }
	//
	// public void setDeliveryAreaXian(String deliveryAreaXian) {
	// this.deliveryAreaXian = deliveryAreaXian;
	// }

	public List<UserGoodsClassBO> getGoodsUgcs() {
		return goodsUgcs;
	}

	public void setGoodsUgcs(List<UserGoodsClassBO> goodsUgcs) {
		this.goodsUgcs = goodsUgcs;
	}

	public String getUserClassIds() {
		return userClassIds;
	}

	public void setUserClassIds(String userClassIds) {
		this.userClassIds = userClassIds;
	}

	public String getPublishDay() {
		return publishDay;
	}

	public void setPublishDay(String publishDay) {
		this.publishDay = publishDay;
	}

	public String getPublishHour() {
		return publishHour;
	}

	public void setPublishHour(String publishHour) {
		this.publishHour = publishHour;
	}

	public String getPublishMin() {
		return publishMin;
	}

	public void setPublishMin(String publishMin) {
		this.publishMin = publishMin;
	}

	public Transport getTransport() {
		return transport;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

	public StoreBO getGoodsStore() {
		return goodsStore;
	}

	public void setGoodsStore(StoreBO goodsStore) {
		this.goodsStore = goodsStore;
	}

	public List<GoodsPhotoBO> getGoodsPhotosList() {
		return goodsPhotosList;
	}

	public void setGoodsPhotosList(List<GoodsPhotoBO> goodsPhotosList) {
		this.goodsPhotosList = goodsPhotosList;
	}

	public List<GoodsSpecPropertyBO> getGoodsSpecsList() {
		return goodsSpecsList;
	}

	public void setGoodsSpecsList(List<GoodsSpecPropertyBO> goodsSpecsList) {
		this.goodsSpecsList = goodsSpecsList;
	}

	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	public String getGoodsSpecIds() {
		return goodsSpecIds;
	}

	public void setGoodsSpecIds(String goodsSpecIds) {
		this.goodsSpecIds = goodsSpecIds;
	}

	public String getGoodsProperties() {
		return goodsProperties;
	}

	public void setGoodsProperties(String goodsProperties) {
		this.goodsProperties = goodsProperties;
	}

	public String getIntentoryDetails() {
		return intentoryDetails;
	}

	public void setIntentoryDetails(String intentoryDetails) {
		this.intentoryDetails = intentoryDetails;
	}

	public String getImageIds() {
		return imageIds;
	}

	public void setImageIds(String imageIds) {
		this.imageIds = imageIds;
	}

	public String getfCodeProfix() {
		return fCodeProfix;
	}

	public void setfCodeProfix(String fCodeProfix) {
		this.fCodeProfix = fCodeProfix;
	}

	public String getfCodeCount() {
		return fCodeCount;
	}

	public void setfCodeCount(String fCodeCount) {
		this.fCodeCount = fCodeCount;
	}

	public String getStoreSecondDomain() {
		return storeSecondDomain;
	}

	public void setStoreSecondDomain(String storeSecondDomain) {
		this.storeSecondDomain = storeSecondDomain;
	}

	public String getGoodsClassName() {
		return goodsClassName;
	}

	public void setGoodsClassName(String goodsClassName) {
		this.goodsClassName = goodsClassName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getKeyWordIdStr() {
		return keyWordIdStr;
	}

	public void setKeyWordIdStr(String keyWordIdStr) {
		this.keyWordIdStr = keyWordIdStr;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public BigDecimal getNeedYgb() {
		return needYgb;
	}

	public void setNeedYgb(BigDecimal needYgb) {
		this.needYgb = needYgb;
	}

	public BigDecimal getNeedMoney() {
		return needMoney;
	}

	public void setNeedMoney(BigDecimal needMoney) {
		this.needMoney = needMoney;
	}

	public Integer getIsYgb() {
		return isYgb;
	}

	public void setIsYgb(Integer isYgb) {
		this.isYgb = isYgb;
	}

	public String getImg_pids() {
		return img_pids;
	}

	public void setImg_pids(String img_pids) {
		this.img_pids = img_pids;
	}

	public String getGoodsSpecificationIds() {
		return goodsSpecificationIds;
	}

	public void setGoodsSpecificationIds(String goodsSpecificationIds) {
		this.goodsSpecificationIds = goodsSpecificationIds;
	}

	public String getTargetUrlM() {
		return targetUrlM;
	}

	public void setTargetUrlM(String targetUrlM) {
		this.targetUrlM = targetUrlM;
	}

	public Integer getIsJuanpi() {
		return isJuanpi;
	}

	public void setIsJuanpi(Integer isJuanpi) {
		this.isJuanpi = isJuanpi;
	}

	public Integer getIsTuangou() {
		if (null == isTuangou) {
			return 0;
		}
		return isTuangou;
	}

	public void setIsTuangou(Integer isTuangou) {
		this.isTuangou = isTuangou;
	}

	public BigDecimal getTuanCprice() {
		if (null == tuanCprice) {
			return new BigDecimal(0);
		}
		return tuanCprice;
	}

	public void setTuanCprice(BigDecimal tuanCprice) {
		this.tuanCprice = tuanCprice;
	}



}
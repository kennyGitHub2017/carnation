package com.sinco.carnation.resource.vo.search;

import com.sinco.api.annotation.Param;
import com.sinco.api.util.BasicPageParamVo;

public class ShopSearchGoodsVO extends BasicPageParamVo {

	@Param(desc = "商品对应的大分类")
	private Long gcId;

	@Param(desc = "价格:goods_current_price|销量:goods_salenum|综合:add_time")
	private String orderBy;

	@Param(desc = "排序类型|降序asc|升序desc")
	private String orderType;

	@Param(desc = "商品品牌")
	private Long goodsBrandId;

	@Param(desc = "商品名称")
	private String goodsName;

	@Param(desc = "店铺名称")
	private String storeName;

	@Param(desc = "商品属性|如:|6,白色")
	private String properties;

	@Param(desc = "商品类型：-1全部0自营商品1商家商品")
	private Integer goodsType;

	@Param(desc = "0支持货到付款")
	private String goodsCod;

	@Param(desc = "1卖家包邮")
	private String goodsTransfee;

	@Param(desc = "-1全部0仅显示有货")
	private Integer goodsInventory;

	@Param(desc = "关键字")
	private String keyword;

	@Param(desc = "只看BV值：0=不看 1=看")
	private Integer onlyCN;
	
	@Param(desc = "类搜索;格式 二级ID_三级ID 如:12_654")
	private String queryGc;
	
	@Param(desc ="是否拼团0否 ;1 是")
	private Integer isTuangou;

	public Integer getOnlyCN() {
		return onlyCN;
	}

	public void setOnlyCN(Integer onlyCN) {
		this.onlyCN = onlyCN;
	}

	public Long getGcId() {
		return gcId;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setGcId(Long gcId) {
		this.gcId = gcId;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public Long getGoodsBrandId() {
		return goodsBrandId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public String getStoreName() {
		return storeName;
	}

	public String getProperties() {
		return properties;
	}

	public void setGoodsBrandId(Long goodsBrandId) {
		this.goodsBrandId = goodsBrandId;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public void setProperties(String properties) {
		this.properties = properties;
	}

	public Integer getGoodsType() {
		return goodsType;
	}

	public String getGoodsCod() {
		return goodsCod;
	}

	public String getGoodsTransfee() {
		return goodsTransfee;
	}

	public Integer getGoodsInventory() {
		return goodsInventory;
	}

	public void setGoodsType(Integer goodsType) {
		this.goodsType = goodsType;
	}

	public void setGoodsCod(String goodsCod) {
		this.goodsCod = goodsCod;
	}

	public void setGoodsTransfee(String goodsTransfee) {
		this.goodsTransfee = goodsTransfee;
	}

	public void setGoodsInventory(Integer goodsInventory) {
		this.goodsInventory = goodsInventory;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getQueryGc() {
		return queryGc;
	}

	public void setQueryGc(String queryGc) {
		this.queryGc = queryGc;
	}

	public Integer getIsTuangou() {
		return isTuangou;
	}

	public void setIsTuangou(Integer isTuangou) {
		this.isTuangou = isTuangou;
	}
	
}

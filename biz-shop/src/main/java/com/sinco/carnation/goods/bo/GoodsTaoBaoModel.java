package com.sinco.carnation.goods.bo;

import java.math.BigDecimal;
import java.util.Date;

public class GoodsTaoBaoModel {

	private String name;// 产品名称
	private BigDecimal price;// 市场价格
	private String desc;// 产品描述
	private String pic_url;// 产品的主图片地址
	private Date modified;// 修改时间
	private String pic_path;// 产品对应的图片路径
	private String shop_price;// 产品的店内价格
	private String standard_price;// 产品的标准价格
	private Long product_id;// 产品ID
	private Date created;// 创建时间
	private String cat_name;// 商品类目名称

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getPic_url() {
		return pic_url;
	}

	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public String getPic_path() {
		return pic_path;
	}

	public void setPic_path(String pic_path) {
		this.pic_path = pic_path;
	}

	public String getShop_price() {
		return shop_price;
	}

	public void setShop_price(String shop_price) {
		this.shop_price = shop_price;
	}

	public String getStandard_price() {
		return standard_price;
	}

	public void setStandard_price(String standard_price) {
		this.standard_price = standard_price;
	}

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getCat_name() {
		return cat_name;
	}

	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}

}

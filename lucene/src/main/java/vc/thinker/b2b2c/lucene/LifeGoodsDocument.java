package vc.thinker.b2b2c.lucene;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "lifegoods", type = "lifegoods", shards = 3, replicas = 1, refreshInterval = "-1")
public class LifeGoodsDocument  extends EsDocument{
	@Id
    @Field(type = FieldType.String, store = true)
	private String id;
	@Field(type = FieldType.String, store = true,indexAnalyzer="index_ansj",searchAnalyzer="query_ansj")
	private String title;
	@Field(type = FieldType.String, store = true,indexAnalyzer="index_ansj",searchAnalyzer="query_ansj")
	private String content;
    @Field(type = FieldType.String, store = true)
	private String type;
    @Field(type = FieldType.Double, store = true)
	private double store_price;
    @Field(type = FieldType.Long, store = true)
	private long add_time;
    @Field(type = FieldType.String, store = true)
	private String goods_salenum;
    @Field(type = FieldType.String, store = true)
	private String goods_cat;
    @Field(type = FieldType.String, store = true)
	private String goods_rate;
    @Field(type = FieldType.String, store = true)
	private String cost_price;
    @Field(type = FieldType.String, store = true)
	private String goods_area;
    @Field(type = FieldType.String, store = true)
	private String main_photo_url;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getStore_price() {
		return store_price;
	}
	public void setStore_price(double store_price) {
		this.store_price = store_price;
	}
	public long getAdd_time() {
		return add_time;
	}
	public void setAdd_time(long add_time) {
		this.add_time = add_time;
	}
	public String getGoods_salenum() {
		return goods_salenum;
	}
	public void setGoods_salenum(String goods_salenum) {
		this.goods_salenum = goods_salenum;
	}
	public String getGoods_cat() {
		return goods_cat;
	}
	public void setGoods_cat(String goods_cat) {
		this.goods_cat = goods_cat;
	}
	public String getGoods_rate() {
		return goods_rate;
	}
	public void setGoods_rate(String goods_rate) {
		this.goods_rate = goods_rate;
	}
	public String getCost_price() {
		return cost_price;
	}
	public void setCost_price(String cost_price) {
		this.cost_price = cost_price;
	}
	public String getGoods_area() {
		return goods_area;
	}
	public void setGoods_area(String goods_area) {
		this.goods_area = goods_area;
	}
	public String getMain_photo_url() {
		return main_photo_url;
	}
	public void setMain_photo_url(String main_photo_url) {
		this.main_photo_url = main_photo_url;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LifeGoodsDocument [id=");
		builder.append(id);
		builder.append(", title=");
		builder.append(title);
		builder.append(", content=");
		builder.append(content);
		builder.append(", type=");
		builder.append(type);
		builder.append(", store_price=");
		builder.append(store_price);
		builder.append(", add_time=");
		builder.append(add_time);
		builder.append(", goods_salenum=");
		builder.append(goods_salenum);
		builder.append(", goods_cat=");
		builder.append(goods_cat);
		builder.append(", goods_rate=");
		builder.append(goods_rate);
		builder.append(", cost_price=");
		builder.append(cost_price);
		builder.append(", goods_area=");
		builder.append(goods_area);
		builder.append(", main_photo_url=");
		builder.append(main_photo_url);
		builder.append("]");
		return builder.toString();
	}



}

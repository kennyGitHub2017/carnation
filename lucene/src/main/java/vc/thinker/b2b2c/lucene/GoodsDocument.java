package vc.thinker.b2b2c.lucene;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;
@Document(indexName = "goods", type = "goods", shards = 3, replicas = 1, refreshInterval = "-1")
public class GoodsDocument extends EsDocument{
	@Id
    @Field(type = FieldType.String, store = true)
	private String id;
	@Field(type = FieldType.String, store = true)
	private String main_photo_url;
	@Field(type = FieldType.String, store = true)
    private String photos_url;
	@Field(type = FieldType.String, store = true,indexAnalyzer="index_ansj",searchAnalyzer="query_ansj")
	private String title;
    @Field(type = FieldType.String, store = true,indexAnalyzer="index_ansj",searchAnalyzer="query_ansj")
    private String content;
    @Field(type = FieldType.String, store = true)
    private String type;
    @Field(type = FieldType.Long, store = true)
	private long add_time;
    @Field(type = FieldType.Integer, store = true)
	private int goods_salenum;
    @Field(type = FieldType.Integer, store = true)
	private int goods_collect;
    @Field(type = FieldType.Double, store = true)
	private double well_evaluate;
    @Field(type = FieldType.Double, store = true)
	private double store_price;
    @Field(type = FieldType.Integer, store = true)
	private int goods_inventory;
    @Field(type = FieldType.String, store = true)
	private String goods_type;
    @Field(type = FieldType.String, store = true)
	private String goods_evas;
    @Field(type = FieldType.String, store = true)
	private String goods_brandname;
    @Field(type = FieldType.String, store = true)
	private String goods_class;
    @Field(type = FieldType.String, store = true)
	private String goods_cod;
    @Field(type = FieldType.String, store = true)
	private String goods_transfee;
    @Field(type = FieldType.String, store = true)
	private String whether_active;
    @Field(type = FieldType.String, store = true)
	private String f_sale_type;
    @Field(type = FieldType.Boolean, store = true)
    private boolean has_mobile_price;
    @Field(type = FieldType.Boolean, store = true)
    private boolean has_exchange_integral;
    @Field(type = FieldType.Double, store = true)
	private double mobile_price;
    @Field(type=FieldType.String,store=true,index=FieldIndex.not_analyzed)
    private String[] target;
    //CN会员登陆商城页面需要展示BV值，添加 2017-02-27 tw
    @Field(type = FieldType.Double, store = true)
    private double goods_price;
    @Field(type = FieldType.Double, store = true)
	private double self_add_price;
    @Field(type = FieldType.Double, store = true)
	private double cn_self_add_price;
    @Field(type = FieldType.Integer, store = true)
	private int ex_price_flag;
    @Field(type = FieldType.String, store = true)
    private String inventory_type;
    @Field(type = FieldType.Double, store = true)
    private double bv;
    //非CN会员登陆需要过滤精品专区商品，添加 2017-07-11 tw
    @Field(type = FieldType.Integer, store = true)
    private int is_ygb;
    //卷皮商品新增属性
    @Field(type = FieldType.Integer, store = true)
    private int is_juanpi;
    @Field(type = FieldType.String, store = true)
    private String juanpi_class;
    @Field(type = FieldType.Integer, store = true)
    private int is_tuangou;
    @Field(type = FieldType.Double, store = true)
    private double tuangou_price;
    @Field(type = FieldType.String, store = true)
    private String target_url_m;
    
	public double getBv() {
		return bv;
	}
	public void setBv(double bv) {
		this.bv = bv;
	}
	public String[] getTarget() {
		return target;
	}
	public void setTarget(String[] target) {
		this.target = target;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getMain_photo_url() {
		return main_photo_url;
	}
	public void setMain_photo_url(String main_photo_url) {
		this.main_photo_url = main_photo_url;
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
	public long getAdd_time() {
		return add_time;
	}
	public void setAdd_time(long add_time) {
		this.add_time = add_time;
	}
	public int getGoods_salenum() {
		return goods_salenum;
	}
	public void setGoods_salenum(int goods_salenum) {
		this.goods_salenum = goods_salenum;
	}
	public int getGoods_collect() {
		return goods_collect;
	}
	public void setGoods_collect(int goods_collect) {
		this.goods_collect = goods_collect;
	}
	public double getWell_evaluate() {
		return well_evaluate;
	}
	public void setWell_evaluate(double well_evaluate) {
		this.well_evaluate = well_evaluate;
	}
	public double getStore_price() {
		return store_price;
	}
	public void setStore_price(double store_price) {
		this.store_price = store_price;
	}
	public int getGoods_inventory() {
		return goods_inventory;
	}
	public void setGoods_inventory(int goods_inventory) {
		this.goods_inventory = goods_inventory;
	}
	public String getGoods_type() {
		return goods_type;
	}
	public void setGoods_type(String goods_type) {
		this.goods_type = goods_type;
	}

	public String getPhotos_url() {
		return photos_url;
	}
	public void setPhotos_url(String photos_url) {
		this.photos_url = photos_url;
	}
	public String getGoods_evas() {
		return goods_evas;
	}
	public void setGoods_evas(String goods_evas) {
		this.goods_evas = goods_evas;
	}
	public String getGoods_brandname() {
		return goods_brandname;
	}
	public void setGoods_brandname(String goods_brandname) {
		this.goods_brandname = goods_brandname;
	}
	public String getGoods_class() {
		return goods_class;
	}
	public void setGoods_class(String goods_class) {
		this.goods_class = goods_class;
	}
	public String getGoods_cod() {
		return goods_cod;
	}
	public void setGoods_cod(String goods_cod) {
		this.goods_cod = goods_cod;
	}
	public String getGoods_transfee() {
		return goods_transfee;
	}
	public void setGoods_transfee(String goods_transfee) {
		this.goods_transfee = goods_transfee;
	}
	public String getWhether_active() {
		return whether_active;
	}
	public void setWhether_active(String whether_active) {
		this.whether_active = whether_active;
	}
	public String getF_sale_type() {
		return f_sale_type;
	}
	public void setF_sale_type(String f_sale_type) {
		this.f_sale_type = f_sale_type;
	}
	public boolean getHas_mobile_price() {
		return has_mobile_price;
	}
	public void setHas_mobile_price(boolean has_mobile_price) {
		this.has_mobile_price = has_mobile_price;
	}
	public boolean getHas_exchange_integral() {
		return has_exchange_integral;
	}
	public void setHas_exchange_integral(boolean has_exchange_integral) {
		this.has_exchange_integral = has_exchange_integral;
	}
	public double getMobile_price() {
		return mobile_price;
	}
	public void setMobile_price(double mobile_price) {
		this.mobile_price = mobile_price;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GoodsDocument [id=");
		builder.append(id);
		builder.append(", main_photo_url=");
		builder.append(main_photo_url);
		builder.append(", photos_url=");
		builder.append(photos_url);
		builder.append(", title=");
		builder.append(title);
		builder.append(", content=");
		builder.append(content);
		builder.append(", type=");
		builder.append(type);
		builder.append(", add_time=");
		builder.append(add_time);
		builder.append(", goods_salenum=");
		builder.append(goods_salenum);
		builder.append(", goods_collect=");
		builder.append(goods_collect);
		builder.append(", well_evaluate=");
		builder.append(well_evaluate);
		builder.append(", store_price=");
		builder.append(store_price);
		builder.append(", goods_inventory=");
		builder.append(goods_inventory);
		builder.append(", goods_type=");
		builder.append(goods_type);
		builder.append(", goods_evas=");
		builder.append(goods_evas);
		builder.append(", goods_brandname=");
		builder.append(goods_brandname);
		builder.append(", goods_class=");
		builder.append(goods_class);
		builder.append(", goods_cod=");
		builder.append(goods_cod);
		builder.append(", goods_transfee=");
		builder.append(goods_transfee);
		builder.append(", whether_active=");
		builder.append(whether_active);
		builder.append(", f_sale_type=");
		builder.append(f_sale_type);
		builder.append(", has_exchange_integral=");
		builder.append(has_exchange_integral);
		builder.append(", has_mobile_price=");
		builder.append(has_mobile_price);
		builder.append(", mobile_price=");
		builder.append(mobile_price);
		builder.append(",target=");
		builder.append(target);
		builder.append(", goods_price=");
		builder.append(goods_price);
		builder.append(", self_add_price=");
		builder.append(self_add_price);
		builder.append(", cn_self_add_price=");
		builder.append(cn_self_add_price);
		builder.append(", ex_price_flag=");
		builder.append(ex_price_flag);
		builder.append("]");
		return builder.toString();
	}
	public double getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(double goods_price) {
		this.goods_price = goods_price;
	}
	public double getSelf_add_price() {
		return self_add_price;
	}
	public void setSelf_add_price(double self_add_price) {
		this.self_add_price = self_add_price;
	}
	public double getCn_self_add_price() {
		return cn_self_add_price;
	}
	public void setCn_self_add_price(double cn_self_add_price) {
		this.cn_self_add_price = cn_self_add_price;
	}
	public int getEx_price_flag() {
		return ex_price_flag;
	}
	public void setEx_price_flag(int ex_price_flag) {
		this.ex_price_flag = ex_price_flag;
	}
	public String getInventory_type() {
		return inventory_type;
	}
	public void setInventory_type(String inventory_type) {
		this.inventory_type = inventory_type;
	}
	public int getIs_ygb() {
		return is_ygb;
	}
	public void setIs_ygb(int is_ygb) {
		this.is_ygb = is_ygb;
	}
	public Integer getIs_juanpi() {
		return is_juanpi;
	}
	public void setIs_juanpi(Integer is_juanpi) {
		this.is_juanpi = is_juanpi;
	}
	public String getJuanpi_class() {
		return juanpi_class;
	}
	public void setJuanpi_class(String juanpi_class) {
		this.juanpi_class = juanpi_class;
	}
	public double getTuangou_price() {
		return tuangou_price;
	}
	public void setTuangou_price(double tuangou_price) {
		this.tuangou_price = tuangou_price;
	}
	public Integer getIs_tuangou() {
		return is_tuangou;
	}
	public void setIs_tuangou(Integer is_tuangou) {
		this.is_tuangou = is_tuangou;
	}

	public String getTarget_url_m() {
		return target_url_m;
	}

	public void setTarget_url_m(String target_url_m) {
		this.target_url_m = target_url_m;
	}
	
}

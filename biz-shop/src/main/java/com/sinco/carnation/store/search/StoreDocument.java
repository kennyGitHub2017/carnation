package com.sinco.carnation.store.search;

import org.slf4j.Logger;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.GeoPointField;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import vc.thinker.b2b2c.lucene.EsDocument;

@Document(indexName = "store", type = "store", shards = 3, replicas = 1, refreshInterval = "-1")
public class StoreDocument extends EsDocument {

	private static final Logger log = org.slf4j.LoggerFactory.getLogger(StoreDocument.class);

	@Id
	@Field(type = FieldType.String, store = true)
	private String id;

	// @Field(type = FieldType.String, store = true,index=FieldIndex.analyzed)
	@Field(type = FieldType.String, store = true, indexAnalyzer = "index_ansj", searchAnalyzer = "query_ansj")
	// @Field(type = FieldType.String, store = true,indexAnalyzer="index_ansj",searchAnalyzer="query_ansj")
	private String storeName;

	@GeoPointField
	private GeoPoint location;

	@Field(type = FieldType.Long, store = true)
	private Long cityId;

	@Field(type = FieldType.Long, store = true)
	private Long areaId;

	@Field(type = FieldType.Long, store = true)
	private Long[] classIds;

	@Field(type = FieldType.String, store = true, indexAnalyzer = "index_ansj", searchAnalyzer = "query_ansj")
	private String areaInfo;

	@Field(type = FieldType.String, store = true)
	private String storeInfoPath;

	@Field(type = FieldType.Integer, store = true)
	private Integer storeEvaluationCount;

	@Field(type = FieldType.Integer, store = true)
	private Integer storeEvaluationAverage;

	@Field(type = FieldType.String, store = true)
	private String storeAddress;

	@Field(type = FieldType.String, store = true, index = FieldIndex.not_analyzed)
	private String[] target;

	@Field(type = FieldType.Float, store = true)
	private Float evaluationAverage;

	@Field(type = FieldType.String, store = true)
	private String storeMainInfoPath;

	/**
	 * 总销量
	 */
	@Field(type = FieldType.Long, store = true)
	private Long sales;

	/**
	 * 正常上架的总服务数量
	 */
	@Field(type = FieldType.Integer, store = true)
	private Integer normalGoodsCount;

	/**
	 * 距离，米
	 */
	private Integer distance;

	public String getStoreMainInfoPath() {
		return storeMainInfoPath;
	}

	public void setStoreMainInfoPath(String storeMainInfoPath) {
		this.storeMainInfoPath = storeMainInfoPath;
	}

	public Float getEvaluationAverage() {
		return evaluationAverage;
	}

	public void setEvaluationAverage(Float evaluationAverage) {
		this.evaluationAverage = evaluationAverage;
	}

	public String[] getTarget() {
		return target;
	}

	public void setTarget(String[] target) {
		this.target = target;
	}

	public Integer getNormalGoodsCount() {
		return normalGoodsCount;
	}

	public void setNormalGoodsCount(Integer normalGoodsCount) {
		this.normalGoodsCount = normalGoodsCount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public GeoPoint getLocation() {
		return location;
	}

	public void setLocation(GeoPoint location) {
		this.location = location;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public Long[] getClassIds() {
		return classIds;
	}

	public void setClassIds(Long[] classIds) {
		this.classIds = classIds;
	}

	public String getAreaInfo() {
		return areaInfo;
	}

	public void setAreaInfo(String areaInfo) {
		this.areaInfo = areaInfo;
	}

	public String getStoreInfoPath() {
		return storeInfoPath;
	}

	public void setStoreInfoPath(String storeInfoPath) {
		this.storeInfoPath = storeInfoPath;
	}

	public Integer getStoreEvaluationCount() {
		return storeEvaluationCount;
	}

	public void setStoreEvaluationCount(Integer storeEvaluationCount) {
		this.storeEvaluationCount = storeEvaluationCount;
	}

	public Integer getStoreEvaluationAverage() {
		return storeEvaluationAverage;
	}

	public void setStoreEvaluationAverage(Integer storeEvaluationAverage) {
		this.storeEvaluationAverage = storeEvaluationAverage;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public Long getSales() {
		return sales;
	}

	public void setSales(Long sales) {
		this.sales = sales;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	/**
	 * 排序类型
	 * 
	 * @author james
	 * 
	 */
	public static enum StoreOrderType {

		DEFAULT, // 默认
		DISTANCE, // 距离
		SALES, // 销量
		CREDIT;// 好评

		/**
		 * Returns the {@link Direction} enum for the given {@link String} value.
		 * 
		 * @param value
		 * @return
		 */
		public static StoreOrderType fromString(String value) {
			try {
				return StoreOrderType.valueOf(value.toUpperCase());
			} catch (Exception e) {
				log.error("{} from StoreOrderType error", value);
				return DEFAULT;
			}
		}
	}
}

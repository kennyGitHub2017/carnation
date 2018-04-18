package com.sinco.carnation.goods.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReturnGoodsLogExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public ReturnGoodsLogExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	public boolean isDistinct() {
		return distinct;
	}

	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Long value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Long value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Long value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Long value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Long value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Long value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Long> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Long> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Long value1, Long value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Long value1, Long value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andAddTimeIsNull() {
			addCriterion("add_time is null");
			return (Criteria) this;
		}

		public Criteria andAddTimeIsNotNull() {
			addCriterion("add_time is not null");
			return (Criteria) this;
		}

		public Criteria andAddTimeEqualTo(Date value) {
			addCriterion("add_time =", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeNotEqualTo(Date value) {
			addCriterion("add_time <>", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeGreaterThan(Date value) {
			addCriterion("add_time >", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("add_time >=", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeLessThan(Date value) {
			addCriterion("add_time <", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeLessThanOrEqualTo(Date value) {
			addCriterion("add_time <=", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeIn(List<Date> values) {
			addCriterion("add_time in", values, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeNotIn(List<Date> values) {
			addCriterion("add_time not in", values, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeBetween(Date value1, Date value2) {
			addCriterion("add_time between", value1, value2, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeNotBetween(Date value1, Date value2) {
			addCriterion("add_time not between", value1, value2, "addTime");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusIsNull() {
			addCriterion("delete_status is null");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusIsNotNull() {
			addCriterion("delete_status is not null");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusEqualTo(Boolean value) {
			addCriterion("delete_status =", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotEqualTo(Boolean value) {
			addCriterion("delete_status <>", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusGreaterThan(Boolean value) {
			addCriterion("delete_status >", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusGreaterThanOrEqualTo(Boolean value) {
			addCriterion("delete_status >=", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusLessThan(Boolean value) {
			addCriterion("delete_status <", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusLessThanOrEqualTo(Boolean value) {
			addCriterion("delete_status <=", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusIn(List<Boolean> values) {
			addCriterion("delete_status in", values, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotIn(List<Boolean> values) {
			addCriterion("delete_status not in", values, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusBetween(Boolean value1, Boolean value2) {
			addCriterion("delete_status between", value1, value2, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotBetween(Boolean value1, Boolean value2) {
			addCriterion("delete_status not between", value1, value2, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andExpressCodeIsNull() {
			addCriterion("express_code is null");
			return (Criteria) this;
		}

		public Criteria andExpressCodeIsNotNull() {
			addCriterion("express_code is not null");
			return (Criteria) this;
		}

		public Criteria andExpressCodeEqualTo(String value) {
			addCriterion("express_code =", value, "expressCode");
			return (Criteria) this;
		}

		public Criteria andExpressCodeNotEqualTo(String value) {
			addCriterion("express_code <>", value, "expressCode");
			return (Criteria) this;
		}

		public Criteria andExpressCodeGreaterThan(String value) {
			addCriterion("express_code >", value, "expressCode");
			return (Criteria) this;
		}

		public Criteria andExpressCodeGreaterThanOrEqualTo(String value) {
			addCriterion("express_code >=", value, "expressCode");
			return (Criteria) this;
		}

		public Criteria andExpressCodeLessThan(String value) {
			addCriterion("express_code <", value, "expressCode");
			return (Criteria) this;
		}

		public Criteria andExpressCodeLessThanOrEqualTo(String value) {
			addCriterion("express_code <=", value, "expressCode");
			return (Criteria) this;
		}

		public Criteria andExpressCodeLike(String value) {
			addCriterion("express_code like", value, "expressCode");
			return (Criteria) this;
		}

		public Criteria andExpressCodeNotLike(String value) {
			addCriterion("express_code not like", value, "expressCode");
			return (Criteria) this;
		}

		public Criteria andExpressCodeIn(List<String> values) {
			addCriterion("express_code in", values, "expressCode");
			return (Criteria) this;
		}

		public Criteria andExpressCodeNotIn(List<String> values) {
			addCriterion("express_code not in", values, "expressCode");
			return (Criteria) this;
		}

		public Criteria andExpressCodeBetween(String value1, String value2) {
			addCriterion("express_code between", value1, value2, "expressCode");
			return (Criteria) this;
		}

		public Criteria andExpressCodeNotBetween(String value1, String value2) {
			addCriterion("express_code not between", value1, value2, "expressCode");
			return (Criteria) this;
		}

		public Criteria andGoodsAllPriceIsNull() {
			addCriterion("goods_all_price is null");
			return (Criteria) this;
		}

		public Criteria andGoodsAllPriceIsNotNull() {
			addCriterion("goods_all_price is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsAllPriceEqualTo(String value) {
			addCriterion("goods_all_price =", value, "goodsAllPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsAllPriceNotEqualTo(String value) {
			addCriterion("goods_all_price <>", value, "goodsAllPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsAllPriceGreaterThan(String value) {
			addCriterion("goods_all_price >", value, "goodsAllPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsAllPriceGreaterThanOrEqualTo(String value) {
			addCriterion("goods_all_price >=", value, "goodsAllPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsAllPriceLessThan(String value) {
			addCriterion("goods_all_price <", value, "goodsAllPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsAllPriceLessThanOrEqualTo(String value) {
			addCriterion("goods_all_price <=", value, "goodsAllPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsAllPriceLike(String value) {
			addCriterion("goods_all_price like", value, "goodsAllPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsAllPriceNotLike(String value) {
			addCriterion("goods_all_price not like", value, "goodsAllPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsAllPriceIn(List<String> values) {
			addCriterion("goods_all_price in", values, "goodsAllPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsAllPriceNotIn(List<String> values) {
			addCriterion("goods_all_price not in", values, "goodsAllPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsAllPriceBetween(String value1, String value2) {
			addCriterion("goods_all_price between", value1, value2, "goodsAllPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsAllPriceNotBetween(String value1, String value2) {
			addCriterion("goods_all_price not between", value1, value2, "goodsAllPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsCommissionRateIsNull() {
			addCriterion("goods_commission_rate is null");
			return (Criteria) this;
		}

		public Criteria andGoodsCommissionRateIsNotNull() {
			addCriterion("goods_commission_rate is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsCommissionRateEqualTo(BigDecimal value) {
			addCriterion("goods_commission_rate =", value, "goodsCommissionRate");
			return (Criteria) this;
		}

		public Criteria andGoodsCommissionRateNotEqualTo(BigDecimal value) {
			addCriterion("goods_commission_rate <>", value, "goodsCommissionRate");
			return (Criteria) this;
		}

		public Criteria andGoodsCommissionRateGreaterThan(BigDecimal value) {
			addCriterion("goods_commission_rate >", value, "goodsCommissionRate");
			return (Criteria) this;
		}

		public Criteria andGoodsCommissionRateGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("goods_commission_rate >=", value, "goodsCommissionRate");
			return (Criteria) this;
		}

		public Criteria andGoodsCommissionRateLessThan(BigDecimal value) {
			addCriterion("goods_commission_rate <", value, "goodsCommissionRate");
			return (Criteria) this;
		}

		public Criteria andGoodsCommissionRateLessThanOrEqualTo(BigDecimal value) {
			addCriterion("goods_commission_rate <=", value, "goodsCommissionRate");
			return (Criteria) this;
		}

		public Criteria andGoodsCommissionRateIn(List<BigDecimal> values) {
			addCriterion("goods_commission_rate in", values, "goodsCommissionRate");
			return (Criteria) this;
		}

		public Criteria andGoodsCommissionRateNotIn(List<BigDecimal> values) {
			addCriterion("goods_commission_rate not in", values, "goodsCommissionRate");
			return (Criteria) this;
		}

		public Criteria andGoodsCommissionRateBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("goods_commission_rate between", value1, value2, "goodsCommissionRate");
			return (Criteria) this;
		}

		public Criteria andGoodsCommissionRateNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("goods_commission_rate not between", value1, value2, "goodsCommissionRate");
			return (Criteria) this;
		}

		public Criteria andGoodsCountIsNull() {
			addCriterion("goods_count is null");
			return (Criteria) this;
		}

		public Criteria andGoodsCountIsNotNull() {
			addCriterion("goods_count is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsCountEqualTo(String value) {
			addCriterion("goods_count =", value, "goodsCount");
			return (Criteria) this;
		}

		public Criteria andGoodsCountNotEqualTo(String value) {
			addCriterion("goods_count <>", value, "goodsCount");
			return (Criteria) this;
		}

		public Criteria andGoodsCountGreaterThan(String value) {
			addCriterion("goods_count >", value, "goodsCount");
			return (Criteria) this;
		}

		public Criteria andGoodsCountGreaterThanOrEqualTo(String value) {
			addCriterion("goods_count >=", value, "goodsCount");
			return (Criteria) this;
		}

		public Criteria andGoodsCountLessThan(String value) {
			addCriterion("goods_count <", value, "goodsCount");
			return (Criteria) this;
		}

		public Criteria andGoodsCountLessThanOrEqualTo(String value) {
			addCriterion("goods_count <=", value, "goodsCount");
			return (Criteria) this;
		}

		public Criteria andGoodsCountLike(String value) {
			addCriterion("goods_count like", value, "goodsCount");
			return (Criteria) this;
		}

		public Criteria andGoodsCountNotLike(String value) {
			addCriterion("goods_count not like", value, "goodsCount");
			return (Criteria) this;
		}

		public Criteria andGoodsCountIn(List<String> values) {
			addCriterion("goods_count in", values, "goodsCount");
			return (Criteria) this;
		}

		public Criteria andGoodsCountNotIn(List<String> values) {
			addCriterion("goods_count not in", values, "goodsCount");
			return (Criteria) this;
		}

		public Criteria andGoodsCountBetween(String value1, String value2) {
			addCriterion("goods_count between", value1, value2, "goodsCount");
			return (Criteria) this;
		}

		public Criteria andGoodsCountNotBetween(String value1, String value2) {
			addCriterion("goods_count not between", value1, value2, "goodsCount");
			return (Criteria) this;
		}

		public Criteria andGoodsIdIsNull() {
			addCriterion("goods_id is null");
			return (Criteria) this;
		}

		public Criteria andGoodsIdIsNotNull() {
			addCriterion("goods_id is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsIdEqualTo(Long value) {
			addCriterion("goods_id =", value, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdNotEqualTo(Long value) {
			addCriterion("goods_id <>", value, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdGreaterThan(Long value) {
			addCriterion("goods_id >", value, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
			addCriterion("goods_id >=", value, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdLessThan(Long value) {
			addCriterion("goods_id <", value, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdLessThanOrEqualTo(Long value) {
			addCriterion("goods_id <=", value, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdIn(List<Long> values) {
			addCriterion("goods_id in", values, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdNotIn(List<Long> values) {
			addCriterion("goods_id not in", values, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdBetween(Long value1, Long value2) {
			addCriterion("goods_id between", value1, value2, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdNotBetween(Long value1, Long value2) {
			addCriterion("goods_id not between", value1, value2, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsMainphotoPathIsNull() {
			addCriterion("goods_mainphoto_path is null");
			return (Criteria) this;
		}

		public Criteria andGoodsMainphotoPathIsNotNull() {
			addCriterion("goods_mainphoto_path is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsMainphotoPathEqualTo(String value) {
			addCriterion("goods_mainphoto_path =", value, "goodsMainphotoPath");
			return (Criteria) this;
		}

		public Criteria andGoodsMainphotoPathNotEqualTo(String value) {
			addCriterion("goods_mainphoto_path <>", value, "goodsMainphotoPath");
			return (Criteria) this;
		}

		public Criteria andGoodsMainphotoPathGreaterThan(String value) {
			addCriterion("goods_mainphoto_path >", value, "goodsMainphotoPath");
			return (Criteria) this;
		}

		public Criteria andGoodsMainphotoPathGreaterThanOrEqualTo(String value) {
			addCriterion("goods_mainphoto_path >=", value, "goodsMainphotoPath");
			return (Criteria) this;
		}

		public Criteria andGoodsMainphotoPathLessThan(String value) {
			addCriterion("goods_mainphoto_path <", value, "goodsMainphotoPath");
			return (Criteria) this;
		}

		public Criteria andGoodsMainphotoPathLessThanOrEqualTo(String value) {
			addCriterion("goods_mainphoto_path <=", value, "goodsMainphotoPath");
			return (Criteria) this;
		}

		public Criteria andGoodsMainphotoPathLike(String value) {
			addCriterion("goods_mainphoto_path like", value, "goodsMainphotoPath");
			return (Criteria) this;
		}

		public Criteria andGoodsMainphotoPathNotLike(String value) {
			addCriterion("goods_mainphoto_path not like", value, "goodsMainphotoPath");
			return (Criteria) this;
		}

		public Criteria andGoodsMainphotoPathIn(List<String> values) {
			addCriterion("goods_mainphoto_path in", values, "goodsMainphotoPath");
			return (Criteria) this;
		}

		public Criteria andGoodsMainphotoPathNotIn(List<String> values) {
			addCriterion("goods_mainphoto_path not in", values, "goodsMainphotoPath");
			return (Criteria) this;
		}

		public Criteria andGoodsMainphotoPathBetween(String value1, String value2) {
			addCriterion("goods_mainphoto_path between", value1, value2, "goodsMainphotoPath");
			return (Criteria) this;
		}

		public Criteria andGoodsMainphotoPathNotBetween(String value1, String value2) {
			addCriterion("goods_mainphoto_path not between", value1, value2, "goodsMainphotoPath");
			return (Criteria) this;
		}

		public Criteria andGoodsNameIsNull() {
			addCriterion("goods_name is null");
			return (Criteria) this;
		}

		public Criteria andGoodsNameIsNotNull() {
			addCriterion("goods_name is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsNameEqualTo(String value) {
			addCriterion("goods_name =", value, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameNotEqualTo(String value) {
			addCriterion("goods_name <>", value, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameGreaterThan(String value) {
			addCriterion("goods_name >", value, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
			addCriterion("goods_name >=", value, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameLessThan(String value) {
			addCriterion("goods_name <", value, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameLessThanOrEqualTo(String value) {
			addCriterion("goods_name <=", value, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameLike(String value) {
			addCriterion("goods_name like", value, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameNotLike(String value) {
			addCriterion("goods_name not like", value, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameIn(List<String> values) {
			addCriterion("goods_name in", values, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameNotIn(List<String> values) {
			addCriterion("goods_name not in", values, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameBetween(String value1, String value2) {
			addCriterion("goods_name between", value1, value2, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameNotBetween(String value1, String value2) {
			addCriterion("goods_name not between", value1, value2, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceIsNull() {
			addCriterion("goods_price is null");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceIsNotNull() {
			addCriterion("goods_price is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceEqualTo(String value) {
			addCriterion("goods_price =", value, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceNotEqualTo(String value) {
			addCriterion("goods_price <>", value, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceGreaterThan(String value) {
			addCriterion("goods_price >", value, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceGreaterThanOrEqualTo(String value) {
			addCriterion("goods_price >=", value, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceLessThan(String value) {
			addCriterion("goods_price <", value, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceLessThanOrEqualTo(String value) {
			addCriterion("goods_price <=", value, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceLike(String value) {
			addCriterion("goods_price like", value, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceNotLike(String value) {
			addCriterion("goods_price not like", value, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceIn(List<String> values) {
			addCriterion("goods_price in", values, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceNotIn(List<String> values) {
			addCriterion("goods_price not in", values, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceBetween(String value1, String value2) {
			addCriterion("goods_price between", value1, value2, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceNotBetween(String value1, String value2) {
			addCriterion("goods_price not between", value1, value2, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsReturnStatusIsNull() {
			addCriterion("goods_return_status is null");
			return (Criteria) this;
		}

		public Criteria andGoodsReturnStatusIsNotNull() {
			addCriterion("goods_return_status is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsReturnStatusEqualTo(String value) {
			addCriterion("goods_return_status =", value, "goodsReturnStatus");
			return (Criteria) this;
		}

		public Criteria andGoodsReturnStatusNotEqualTo(String value) {
			addCriterion("goods_return_status <>", value, "goodsReturnStatus");
			return (Criteria) this;
		}

		public Criteria andGoodsReturnStatusGreaterThan(String value) {
			addCriterion("goods_return_status >", value, "goodsReturnStatus");
			return (Criteria) this;
		}

		public Criteria andGoodsReturnStatusGreaterThanOrEqualTo(String value) {
			addCriterion("goods_return_status >=", value, "goodsReturnStatus");
			return (Criteria) this;
		}

		public Criteria andGoodsReturnStatusLessThan(String value) {
			addCriterion("goods_return_status <", value, "goodsReturnStatus");
			return (Criteria) this;
		}

		public Criteria andGoodsReturnStatusLessThanOrEqualTo(String value) {
			addCriterion("goods_return_status <=", value, "goodsReturnStatus");
			return (Criteria) this;
		}

		public Criteria andGoodsReturnStatusLike(String value) {
			addCriterion("goods_return_status like", value, "goodsReturnStatus");
			return (Criteria) this;
		}

		public Criteria andGoodsReturnStatusNotLike(String value) {
			addCriterion("goods_return_status not like", value, "goodsReturnStatus");
			return (Criteria) this;
		}

		public Criteria andGoodsReturnStatusIn(List<String> values) {
			addCriterion("goods_return_status in", values, "goodsReturnStatus");
			return (Criteria) this;
		}

		public Criteria andGoodsReturnStatusNotIn(List<String> values) {
			addCriterion("goods_return_status not in", values, "goodsReturnStatus");
			return (Criteria) this;
		}

		public Criteria andGoodsReturnStatusBetween(String value1, String value2) {
			addCriterion("goods_return_status between", value1, value2, "goodsReturnStatus");
			return (Criteria) this;
		}

		public Criteria andGoodsReturnStatusNotBetween(String value1, String value2) {
			addCriterion("goods_return_status not between", value1, value2, "goodsReturnStatus");
			return (Criteria) this;
		}

		public Criteria andGoodsTypeIsNull() {
			addCriterion("goods_type is null");
			return (Criteria) this;
		}

		public Criteria andGoodsTypeIsNotNull() {
			addCriterion("goods_type is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsTypeEqualTo(Integer value) {
			addCriterion("goods_type =", value, "goodsType");
			return (Criteria) this;
		}

		public Criteria andGoodsTypeNotEqualTo(Integer value) {
			addCriterion("goods_type <>", value, "goodsType");
			return (Criteria) this;
		}

		public Criteria andGoodsTypeGreaterThan(Integer value) {
			addCriterion("goods_type >", value, "goodsType");
			return (Criteria) this;
		}

		public Criteria andGoodsTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("goods_type >=", value, "goodsType");
			return (Criteria) this;
		}

		public Criteria andGoodsTypeLessThan(Integer value) {
			addCriterion("goods_type <", value, "goodsType");
			return (Criteria) this;
		}

		public Criteria andGoodsTypeLessThanOrEqualTo(Integer value) {
			addCriterion("goods_type <=", value, "goodsType");
			return (Criteria) this;
		}

		public Criteria andGoodsTypeIn(List<Integer> values) {
			addCriterion("goods_type in", values, "goodsType");
			return (Criteria) this;
		}

		public Criteria andGoodsTypeNotIn(List<Integer> values) {
			addCriterion("goods_type not in", values, "goodsType");
			return (Criteria) this;
		}

		public Criteria andGoodsTypeBetween(Integer value1, Integer value2) {
			addCriterion("goods_type between", value1, value2, "goodsType");
			return (Criteria) this;
		}

		public Criteria andGoodsTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("goods_type not between", value1, value2, "goodsType");
			return (Criteria) this;
		}

		public Criteria andRefundStatusIsNull() {
			addCriterion("refund_status is null");
			return (Criteria) this;
		}

		public Criteria andRefundStatusIsNotNull() {
			addCriterion("refund_status is not null");
			return (Criteria) this;
		}

		public Criteria andRefundStatusEqualTo(Integer value) {
			addCriterion("refund_status =", value, "refundStatus");
			return (Criteria) this;
		}

		public Criteria andRefundStatusNotEqualTo(Integer value) {
			addCriterion("refund_status <>", value, "refundStatus");
			return (Criteria) this;
		}

		public Criteria andRefundStatusGreaterThan(Integer value) {
			addCriterion("refund_status >", value, "refundStatus");
			return (Criteria) this;
		}

		public Criteria andRefundStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("refund_status >=", value, "refundStatus");
			return (Criteria) this;
		}

		public Criteria andRefundStatusLessThan(Integer value) {
			addCriterion("refund_status <", value, "refundStatus");
			return (Criteria) this;
		}

		public Criteria andRefundStatusLessThanOrEqualTo(Integer value) {
			addCriterion("refund_status <=", value, "refundStatus");
			return (Criteria) this;
		}

		public Criteria andRefundStatusIn(List<Integer> values) {
			addCriterion("refund_status in", values, "refundStatus");
			return (Criteria) this;
		}

		public Criteria andRefundStatusNotIn(List<Integer> values) {
			addCriterion("refund_status not in", values, "refundStatus");
			return (Criteria) this;
		}

		public Criteria andRefundStatusBetween(Integer value1, Integer value2) {
			addCriterion("refund_status between", value1, value2, "refundStatus");
			return (Criteria) this;
		}

		public Criteria andRefundStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("refund_status not between", value1, value2, "refundStatus");
			return (Criteria) this;
		}

		public Criteria andReturnContentIsNull() {
			addCriterion("return_content is null");
			return (Criteria) this;
		}

		public Criteria andReturnContentIsNotNull() {
			addCriterion("return_content is not null");
			return (Criteria) this;
		}

		public Criteria andReturnContentEqualTo(String value) {
			addCriterion("return_content =", value, "returnContent");
			return (Criteria) this;
		}

		public Criteria andReturnContentNotEqualTo(String value) {
			addCriterion("return_content <>", value, "returnContent");
			return (Criteria) this;
		}

		public Criteria andReturnContentGreaterThan(String value) {
			addCriterion("return_content >", value, "returnContent");
			return (Criteria) this;
		}

		public Criteria andReturnContentGreaterThanOrEqualTo(String value) {
			addCriterion("return_content >=", value, "returnContent");
			return (Criteria) this;
		}

		public Criteria andReturnContentLessThan(String value) {
			addCriterion("return_content <", value, "returnContent");
			return (Criteria) this;
		}

		public Criteria andReturnContentLessThanOrEqualTo(String value) {
			addCriterion("return_content <=", value, "returnContent");
			return (Criteria) this;
		}

		public Criteria andReturnContentLike(String value) {
			addCriterion("return_content like", value, "returnContent");
			return (Criteria) this;
		}

		public Criteria andReturnContentNotLike(String value) {
			addCriterion("return_content not like", value, "returnContent");
			return (Criteria) this;
		}

		public Criteria andReturnContentIn(List<String> values) {
			addCriterion("return_content in", values, "returnContent");
			return (Criteria) this;
		}

		public Criteria andReturnContentNotIn(List<String> values) {
			addCriterion("return_content not in", values, "returnContent");
			return (Criteria) this;
		}

		public Criteria andReturnContentBetween(String value1, String value2) {
			addCriterion("return_content between", value1, value2, "returnContent");
			return (Criteria) this;
		}

		public Criteria andReturnContentNotBetween(String value1, String value2) {
			addCriterion("return_content not between", value1, value2, "returnContent");
			return (Criteria) this;
		}

		public Criteria andReturnOrderIdIsNull() {
			addCriterion("return_order_id is null");
			return (Criteria) this;
		}

		public Criteria andReturnOrderIdIsNotNull() {
			addCriterion("return_order_id is not null");
			return (Criteria) this;
		}

		public Criteria andReturnOrderIdEqualTo(Long value) {
			addCriterion("return_order_id =", value, "returnOrderId");
			return (Criteria) this;
		}

		public Criteria andGoodsGspIdsEqualTo(String value) {
			addCriterion("goods_gsp_ids =", value, "goodsGspIds");
			return (Criteria) this;
		}

		public Criteria andReturnOrderIdNotEqualTo(Long value) {
			addCriterion("return_order_id <>", value, "returnOrderId");
			return (Criteria) this;
		}

		public Criteria andReturnOrderIdGreaterThan(Long value) {
			addCriterion("return_order_id >", value, "returnOrderId");
			return (Criteria) this;
		}

		public Criteria andReturnOrderIdGreaterThanOrEqualTo(Long value) {
			addCriterion("return_order_id >=", value, "returnOrderId");
			return (Criteria) this;
		}

		public Criteria andReturnOrderIdLessThan(Long value) {
			addCriterion("return_order_id <", value, "returnOrderId");
			return (Criteria) this;
		}

		public Criteria andReturnOrderIdLessThanOrEqualTo(Long value) {
			addCriterion("return_order_id <=", value, "returnOrderId");
			return (Criteria) this;
		}

		public Criteria andReturnOrderIdIn(List<Long> values) {
			addCriterion("return_order_id in", values, "returnOrderId");
			return (Criteria) this;
		}

		public Criteria andReturnOrderIdNotIn(List<Long> values) {
			addCriterion("return_order_id not in", values, "returnOrderId");
			return (Criteria) this;
		}

		public Criteria andReturnOrderIdBetween(Long value1, Long value2) {
			addCriterion("return_order_id between", value1, value2, "returnOrderId");
			return (Criteria) this;
		}

		public Criteria andReturnOrderIdNotBetween(Long value1, Long value2) {
			addCriterion("return_order_id not between", value1, value2, "returnOrderId");
			return (Criteria) this;
		}

		public Criteria andReturnServiceIdIsNull() {
			addCriterion("return_service_id is null");
			return (Criteria) this;
		}

		public Criteria andReturnServiceIdIsNotNull() {
			addCriterion("return_service_id is not null");
			return (Criteria) this;
		}

		public Criteria andReturnServiceIdEqualTo(String value) {
			addCriterion("return_service_id =", value, "returnServiceId");
			return (Criteria) this;
		}

		public Criteria andReturnServiceIdNotEqualTo(String value) {
			addCriterion("return_service_id <>", value, "returnServiceId");
			return (Criteria) this;
		}

		public Criteria andReturnServiceIdGreaterThan(String value) {
			addCriterion("return_service_id >", value, "returnServiceId");
			return (Criteria) this;
		}

		public Criteria andReturnServiceIdGreaterThanOrEqualTo(String value) {
			addCriterion("return_service_id >=", value, "returnServiceId");
			return (Criteria) this;
		}

		public Criteria andReturnServiceIdLessThan(String value) {
			addCriterion("return_service_id <", value, "returnServiceId");
			return (Criteria) this;
		}

		public Criteria andReturnServiceIdLessThanOrEqualTo(String value) {
			addCriterion("return_service_id <=", value, "returnServiceId");
			return (Criteria) this;
		}

		public Criteria andReturnServiceIdLike(String value) {
			addCriterion("return_service_id like", value, "returnServiceId");
			return (Criteria) this;
		}

		public Criteria andReturnServiceIdNotLike(String value) {
			addCriterion("return_service_id not like", value, "returnServiceId");
			return (Criteria) this;
		}

		public Criteria andReturnServiceIdIn(List<String> values) {
			addCriterion("return_service_id in", values, "returnServiceId");
			return (Criteria) this;
		}

		public Criteria andReturnServiceIdNotIn(List<String> values) {
			addCriterion("return_service_id not in", values, "returnServiceId");
			return (Criteria) this;
		}

		public Criteria andReturnServiceIdBetween(String value1, String value2) {
			addCriterion("return_service_id between", value1, value2, "returnServiceId");
			return (Criteria) this;
		}

		public Criteria andReturnServiceIdNotBetween(String value1, String value2) {
			addCriterion("return_service_id not between", value1, value2, "returnServiceId");
			return (Criteria) this;
		}

		public Criteria andSelfAddressIsNull() {
			addCriterion("self_address is null");
			return (Criteria) this;
		}

		public Criteria andSelfAddressIsNotNull() {
			addCriterion("self_address is not null");
			return (Criteria) this;
		}

		public Criteria andSelfAddressEqualTo(String value) {
			addCriterion("self_address =", value, "selfAddress");
			return (Criteria) this;
		}

		public Criteria andSelfAddressNotEqualTo(String value) {
			addCriterion("self_address <>", value, "selfAddress");
			return (Criteria) this;
		}

		public Criteria andSelfAddressGreaterThan(String value) {
			addCriterion("self_address >", value, "selfAddress");
			return (Criteria) this;
		}

		public Criteria andSelfAddressGreaterThanOrEqualTo(String value) {
			addCriterion("self_address >=", value, "selfAddress");
			return (Criteria) this;
		}

		public Criteria andSelfAddressLessThan(String value) {
			addCriterion("self_address <", value, "selfAddress");
			return (Criteria) this;
		}

		public Criteria andSelfAddressLessThanOrEqualTo(String value) {
			addCriterion("self_address <=", value, "selfAddress");
			return (Criteria) this;
		}

		public Criteria andSelfAddressLike(String value) {
			addCriterion("self_address like", value, "selfAddress");
			return (Criteria) this;
		}

		public Criteria andSelfAddressNotLike(String value) {
			addCriterion("self_address not like", value, "selfAddress");
			return (Criteria) this;
		}

		public Criteria andSelfAddressIn(List<String> values) {
			addCriterion("self_address in", values, "selfAddress");
			return (Criteria) this;
		}

		public Criteria andSelfAddressNotIn(List<String> values) {
			addCriterion("self_address not in", values, "selfAddress");
			return (Criteria) this;
		}

		public Criteria andSelfAddressBetween(String value1, String value2) {
			addCriterion("self_address between", value1, value2, "selfAddress");
			return (Criteria) this;
		}

		public Criteria andSelfAddressNotBetween(String value1, String value2) {
			addCriterion("self_address not between", value1, value2, "selfAddress");
			return (Criteria) this;
		}

		public Criteria andStoreIdIsNull() {
			addCriterion("store_id is null");
			return (Criteria) this;
		}

		public Criteria andStoreIdIsNotNull() {
			addCriterion("store_id is not null");
			return (Criteria) this;
		}

		public Criteria andStoreIdEqualTo(Long value) {
			addCriterion("store_id =", value, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdNotEqualTo(Long value) {
			addCriterion("store_id <>", value, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdGreaterThan(Long value) {
			addCriterion("store_id >", value, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdGreaterThanOrEqualTo(Long value) {
			addCriterion("store_id >=", value, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdLessThan(Long value) {
			addCriterion("store_id <", value, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdLessThanOrEqualTo(Long value) {
			addCriterion("store_id <=", value, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdIn(List<Long> values) {
			addCriterion("store_id in", values, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdNotIn(List<Long> values) {
			addCriterion("store_id not in", values, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdBetween(Long value1, Long value2) {
			addCriterion("store_id between", value1, value2, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdNotBetween(Long value1, Long value2) {
			addCriterion("store_id not between", value1, value2, "storeId");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNull() {
			addCriterion("user_id is null");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNotNull() {
			addCriterion("user_id is not null");
			return (Criteria) this;
		}

		public Criteria andUserIdEqualTo(Long value) {
			addCriterion("user_id =", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotEqualTo(Long value) {
			addCriterion("user_id <>", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThan(Long value) {
			addCriterion("user_id >", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
			addCriterion("user_id >=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThan(Long value) {
			addCriterion("user_id <", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThanOrEqualTo(Long value) {
			addCriterion("user_id <=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdIn(List<Long> values) {
			addCriterion("user_id in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotIn(List<Long> values) {
			addCriterion("user_id not in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdBetween(Long value1, Long value2) {
			addCriterion("user_id between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotBetween(Long value1, Long value2) {
			addCriterion("user_id not between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andUserNameIsNull() {
			addCriterion("user_name is null");
			return (Criteria) this;
		}

		public Criteria andUserNameIsNotNull() {
			addCriterion("user_name is not null");
			return (Criteria) this;
		}

		public Criteria andUserNameEqualTo(String value) {
			addCriterion("user_name =", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotEqualTo(String value) {
			addCriterion("user_name <>", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameGreaterThan(String value) {
			addCriterion("user_name >", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("user_name >=", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLessThan(String value) {
			addCriterion("user_name <", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLessThanOrEqualTo(String value) {
			addCriterion("user_name <=", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLike(String value) {
			addCriterion("user_name like", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotLike(String value) {
			addCriterion("user_name not like", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameIn(List<String> values) {
			addCriterion("user_name in", values, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotIn(List<String> values) {
			addCriterion("user_name not in", values, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameBetween(String value1, String value2) {
			addCriterion("user_name between", value1, value2, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotBetween(String value1, String value2) {
			addCriterion("user_name not between", value1, value2, "userName");
			return (Criteria) this;
		}
	}

	public static class Criteria extends GeneratedCriteria {

		protected Criteria() {
			super();
		}
	}

	public static class Criterion {
		private String condition;

		private Object value;

		private Object secondValue;

		private boolean noValue;

		private boolean singleValue;

		private boolean betweenValue;

		private boolean listValue;

		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}
}
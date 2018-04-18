package com.sinco.carnation.shop.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsReceiptExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public GoodsReceiptExample() {
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

		public Criteria andOfIdIsNull() {
			addCriterion("of_id is null");
			return (Criteria) this;
		}

		public Criteria andOfIdIsNotNull() {
			addCriterion("of_id is not null");
			return (Criteria) this;
		}

		public Criteria andOfIdEqualTo(Long value) {
			addCriterion("of_id =", value, "ofId");
			return (Criteria) this;
		}

		public Criteria andOfIdNotEqualTo(Long value) {
			addCriterion("of_id <>", value, "ofId");
			return (Criteria) this;
		}

		public Criteria andOfIdGreaterThan(Long value) {
			addCriterion("of_id >", value, "ofId");
			return (Criteria) this;
		}

		public Criteria andOfIdGreaterThanOrEqualTo(Long value) {
			addCriterion("of_id >=", value, "ofId");
			return (Criteria) this;
		}

		public Criteria andOfIdLessThan(Long value) {
			addCriterion("of_id <", value, "ofId");
			return (Criteria) this;
		}

		public Criteria andOfIdLessThanOrEqualTo(Long value) {
			addCriterion("of_id <=", value, "ofId");
			return (Criteria) this;
		}

		public Criteria andOfIdIn(List<Long> values) {
			addCriterion("of_id in", values, "ofId");
			return (Criteria) this;
		}

		public Criteria andOfIdNotIn(List<Long> values) {
			addCriterion("of_id not in", values, "ofId");
			return (Criteria) this;
		}

		public Criteria andOfIdBetween(Long value1, Long value2) {
			addCriterion("of_id between", value1, value2, "ofId");
			return (Criteria) this;
		}

		public Criteria andOfIdNotBetween(Long value1, Long value2) {
			addCriterion("of_id not between", value1, value2, "ofId");
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

		public Criteria andGoodsNumIsNull() {
			addCriterion("goods_num is null");
			return (Criteria) this;
		}

		public Criteria andGoodsNumIsNotNull() {
			addCriterion("goods_num is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsNumEqualTo(Integer value) {
			addCriterion("goods_num =", value, "goodsNum");
			return (Criteria) this;
		}

		public Criteria andGoodsNumNotEqualTo(Integer value) {
			addCriterion("goods_num <>", value, "goodsNum");
			return (Criteria) this;
		}

		public Criteria andGoodsNumGreaterThan(Integer value) {
			addCriterion("goods_num >", value, "goodsNum");
			return (Criteria) this;
		}

		public Criteria andGoodsNumGreaterThanOrEqualTo(Integer value) {
			addCriterion("goods_num >=", value, "goodsNum");
			return (Criteria) this;
		}

		public Criteria andGoodsNumLessThan(Integer value) {
			addCriterion("goods_num <", value, "goodsNum");
			return (Criteria) this;
		}

		public Criteria andGoodsNumLessThanOrEqualTo(Integer value) {
			addCriterion("goods_num <=", value, "goodsNum");
			return (Criteria) this;
		}

		public Criteria andGoodsNumIn(List<Integer> values) {
			addCriterion("goods_num in", values, "goodsNum");
			return (Criteria) this;
		}

		public Criteria andGoodsNumNotIn(List<Integer> values) {
			addCriterion("goods_num not in", values, "goodsNum");
			return (Criteria) this;
		}

		public Criteria andGoodsNumBetween(Integer value1, Integer value2) {
			addCriterion("goods_num between", value1, value2, "goodsNum");
			return (Criteria) this;
		}

		public Criteria andGoodsNumNotBetween(Integer value1, Integer value2) {
			addCriterion("goods_num not between", value1, value2, "goodsNum");
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

		public Criteria andGoodsPriceEqualTo(BigDecimal value) {
			addCriterion("goods_price =", value, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceNotEqualTo(BigDecimal value) {
			addCriterion("goods_price <>", value, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceGreaterThan(BigDecimal value) {
			addCriterion("goods_price >", value, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("goods_price >=", value, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceLessThan(BigDecimal value) {
			addCriterion("goods_price <", value, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("goods_price <=", value, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceIn(List<BigDecimal> values) {
			addCriterion("goods_price in", values, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceNotIn(List<BigDecimal> values) {
			addCriterion("goods_price not in", values, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("goods_price between", value1, value2, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("goods_price not between", value1, value2, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsSpecIdIsNull() {
			addCriterion("goods_spec_id is null");
			return (Criteria) this;
		}

		public Criteria andGoodsSpecIdIsNotNull() {
			addCriterion("goods_spec_id is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsSpecIdEqualTo(Long value) {
			addCriterion("goods_spec_id =", value, "goodsSpecId");
			return (Criteria) this;
		}

		public Criteria andGoodsSpecIdNotEqualTo(Long value) {
			addCriterion("goods_spec_id <>", value, "goodsSpecId");
			return (Criteria) this;
		}

		public Criteria andGoodsSpecIdGreaterThan(Long value) {
			addCriterion("goods_spec_id >", value, "goodsSpecId");
			return (Criteria) this;
		}

		public Criteria andGoodsSpecIdGreaterThanOrEqualTo(Long value) {
			addCriterion("goods_spec_id >=", value, "goodsSpecId");
			return (Criteria) this;
		}

		public Criteria andGoodsSpecIdLessThan(Long value) {
			addCriterion("goods_spec_id <", value, "goodsSpecId");
			return (Criteria) this;
		}

		public Criteria andGoodsSpecIdLessThanOrEqualTo(Long value) {
			addCriterion("goods_spec_id <=", value, "goodsSpecId");
			return (Criteria) this;
		}

		public Criteria andGoodsSpecIdIn(List<Long> values) {
			addCriterion("goods_spec_id in", values, "goodsSpecId");
			return (Criteria) this;
		}

		public Criteria andGoodsSpecIdNotIn(List<Long> values) {
			addCriterion("goods_spec_id not in", values, "goodsSpecId");
			return (Criteria) this;
		}

		public Criteria andGoodsSpecIdBetween(Long value1, Long value2) {
			addCriterion("goods_spec_id between", value1, value2, "goodsSpecId");
			return (Criteria) this;
		}

		public Criteria andGoodsSpecIdNotBetween(Long value1, Long value2) {
			addCriterion("goods_spec_id not between", value1, value2, "goodsSpecId");
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

		public Criteria andStoreIdIsNull() {
			addCriterion("store_id is null");
			return (Criteria) this;
		}

		public Criteria andStoreIdIsNotNull() {
			addCriterion("store_id is not null");
			return (Criteria) this;
		}

		public Criteria andStoreIdEqualTo(String value) {
			addCriterion("store_id =", value, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdNotEqualTo(String value) {
			addCriterion("store_id <>", value, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdGreaterThan(String value) {
			addCriterion("store_id >", value, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdGreaterThanOrEqualTo(String value) {
			addCriterion("store_id >=", value, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdLessThan(String value) {
			addCriterion("store_id <", value, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdLessThanOrEqualTo(String value) {
			addCriterion("store_id <=", value, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdLike(String value) {
			addCriterion("store_id like", value, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdNotLike(String value) {
			addCriterion("store_id not like", value, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdIn(List<String> values) {
			addCriterion("store_id in", values, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdNotIn(List<String> values) {
			addCriterion("store_id not in", values, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdBetween(String value1, String value2) {
			addCriterion("store_id between", value1, value2, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdNotBetween(String value1, String value2) {
			addCriterion("store_id not between", value1, value2, "storeId");
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
package com.sinco.carnation.operation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZTCGoldLogExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public ZTCGoldLogExample() {
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

		public Criteria andStoreNameIsNull() {
			addCriterion("store_name is null");
			return (Criteria) this;
		}

		public Criteria andStoreNameIsNotNull() {
			addCriterion("store_name is not null");
			return (Criteria) this;
		}

		public Criteria andStoreNameEqualTo(String value) {
			addCriterion("store_name =", value, "storeName");
			return (Criteria) this;
		}

		public Criteria andStoreNameNotEqualTo(String value) {
			addCriterion("store_name <>", value, "storeName");
			return (Criteria) this;
		}

		public Criteria andStoreNameGreaterThan(String value) {
			addCriterion("store_name >", value, "storeName");
			return (Criteria) this;
		}

		public Criteria andStoreNameGreaterThanOrEqualTo(String value) {
			addCriterion("store_name >=", value, "storeName");
			return (Criteria) this;
		}

		public Criteria andStoreNameLessThan(String value) {
			addCriterion("store_name <", value, "storeName");
			return (Criteria) this;
		}

		public Criteria andStoreNameLessThanOrEqualTo(String value) {
			addCriterion("store_name <=", value, "storeName");
			return (Criteria) this;
		}

		public Criteria andStoreNameLike(String value) {
			addCriterion("store_name like", value, "storeName");
			return (Criteria) this;
		}

		public Criteria andStoreNameNotLike(String value) {
			addCriterion("store_name not like", value, "storeName");
			return (Criteria) this;
		}

		public Criteria andStoreNameIn(List<String> values) {
			addCriterion("store_name in", values, "storeName");
			return (Criteria) this;
		}

		public Criteria andStoreNameNotIn(List<String> values) {
			addCriterion("store_name not in", values, "storeName");
			return (Criteria) this;
		}

		public Criteria andStoreNameBetween(String value1, String value2) {
			addCriterion("store_name between", value1, value2, "storeName");
			return (Criteria) this;
		}

		public Criteria andStoreNameNotBetween(String value1, String value2) {
			addCriterion("store_name not between", value1, value2, "storeName");
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

		public Criteria andZglContentIsNull() {
			addCriterion("zgl_content is null");
			return (Criteria) this;
		}

		public Criteria andZglContentIsNotNull() {
			addCriterion("zgl_content is not null");
			return (Criteria) this;
		}

		public Criteria andZglContentEqualTo(String value) {
			addCriterion("zgl_content =", value, "zglContent");
			return (Criteria) this;
		}

		public Criteria andZglContentNotEqualTo(String value) {
			addCriterion("zgl_content <>", value, "zglContent");
			return (Criteria) this;
		}

		public Criteria andZglContentGreaterThan(String value) {
			addCriterion("zgl_content >", value, "zglContent");
			return (Criteria) this;
		}

		public Criteria andZglContentGreaterThanOrEqualTo(String value) {
			addCriterion("zgl_content >=", value, "zglContent");
			return (Criteria) this;
		}

		public Criteria andZglContentLessThan(String value) {
			addCriterion("zgl_content <", value, "zglContent");
			return (Criteria) this;
		}

		public Criteria andZglContentLessThanOrEqualTo(String value) {
			addCriterion("zgl_content <=", value, "zglContent");
			return (Criteria) this;
		}

		public Criteria andZglContentLike(String value) {
			addCriterion("zgl_content like", value, "zglContent");
			return (Criteria) this;
		}

		public Criteria andZglContentNotLike(String value) {
			addCriterion("zgl_content not like", value, "zglContent");
			return (Criteria) this;
		}

		public Criteria andZglContentIn(List<String> values) {
			addCriterion("zgl_content in", values, "zglContent");
			return (Criteria) this;
		}

		public Criteria andZglContentNotIn(List<String> values) {
			addCriterion("zgl_content not in", values, "zglContent");
			return (Criteria) this;
		}

		public Criteria andZglContentBetween(String value1, String value2) {
			addCriterion("zgl_content between", value1, value2, "zglContent");
			return (Criteria) this;
		}

		public Criteria andZglContentNotBetween(String value1, String value2) {
			addCriterion("zgl_content not between", value1, value2, "zglContent");
			return (Criteria) this;
		}

		public Criteria andZglGoldIsNull() {
			addCriterion("zgl_gold is null");
			return (Criteria) this;
		}

		public Criteria andZglGoldIsNotNull() {
			addCriterion("zgl_gold is not null");
			return (Criteria) this;
		}

		public Criteria andZglGoldEqualTo(Integer value) {
			addCriterion("zgl_gold =", value, "zglGold");
			return (Criteria) this;
		}

		public Criteria andZglGoldNotEqualTo(Integer value) {
			addCriterion("zgl_gold <>", value, "zglGold");
			return (Criteria) this;
		}

		public Criteria andZglGoldGreaterThan(Integer value) {
			addCriterion("zgl_gold >", value, "zglGold");
			return (Criteria) this;
		}

		public Criteria andZglGoldGreaterThanOrEqualTo(Integer value) {
			addCriterion("zgl_gold >=", value, "zglGold");
			return (Criteria) this;
		}

		public Criteria andZglGoldLessThan(Integer value) {
			addCriterion("zgl_gold <", value, "zglGold");
			return (Criteria) this;
		}

		public Criteria andZglGoldLessThanOrEqualTo(Integer value) {
			addCriterion("zgl_gold <=", value, "zglGold");
			return (Criteria) this;
		}

		public Criteria andZglGoldIn(List<Integer> values) {
			addCriterion("zgl_gold in", values, "zglGold");
			return (Criteria) this;
		}

		public Criteria andZglGoldNotIn(List<Integer> values) {
			addCriterion("zgl_gold not in", values, "zglGold");
			return (Criteria) this;
		}

		public Criteria andZglGoldBetween(Integer value1, Integer value2) {
			addCriterion("zgl_gold between", value1, value2, "zglGold");
			return (Criteria) this;
		}

		public Criteria andZglGoldNotBetween(Integer value1, Integer value2) {
			addCriterion("zgl_gold not between", value1, value2, "zglGold");
			return (Criteria) this;
		}

		public Criteria andZglGoodsIdIsNull() {
			addCriterion("zgl_goods_id is null");
			return (Criteria) this;
		}

		public Criteria andZglGoodsIdIsNotNull() {
			addCriterion("zgl_goods_id is not null");
			return (Criteria) this;
		}

		public Criteria andZglGoodsIdEqualTo(Long value) {
			addCriterion("zgl_goods_id =", value, "zglGoodsId");
			return (Criteria) this;
		}

		public Criteria andZglGoodsIdNotEqualTo(Long value) {
			addCriterion("zgl_goods_id <>", value, "zglGoodsId");
			return (Criteria) this;
		}

		public Criteria andZglGoodsIdGreaterThan(Long value) {
			addCriterion("zgl_goods_id >", value, "zglGoodsId");
			return (Criteria) this;
		}

		public Criteria andZglGoodsIdGreaterThanOrEqualTo(Long value) {
			addCriterion("zgl_goods_id >=", value, "zglGoodsId");
			return (Criteria) this;
		}

		public Criteria andZglGoodsIdLessThan(Long value) {
			addCriterion("zgl_goods_id <", value, "zglGoodsId");
			return (Criteria) this;
		}

		public Criteria andZglGoodsIdLessThanOrEqualTo(Long value) {
			addCriterion("zgl_goods_id <=", value, "zglGoodsId");
			return (Criteria) this;
		}

		public Criteria andZglGoodsIdIn(List<Long> values) {
			addCriterion("zgl_goods_id in", values, "zglGoodsId");
			return (Criteria) this;
		}

		public Criteria andZglGoodsIdNotIn(List<Long> values) {
			addCriterion("zgl_goods_id not in", values, "zglGoodsId");
			return (Criteria) this;
		}

		public Criteria andZglGoodsIdBetween(Long value1, Long value2) {
			addCriterion("zgl_goods_id between", value1, value2, "zglGoodsId");
			return (Criteria) this;
		}

		public Criteria andZglGoodsIdNotBetween(Long value1, Long value2) {
			addCriterion("zgl_goods_id not between", value1, value2, "zglGoodsId");
			return (Criteria) this;
		}

		public Criteria andZglTypeIsNull() {
			addCriterion("zgl_type is null");
			return (Criteria) this;
		}

		public Criteria andZglTypeIsNotNull() {
			addCriterion("zgl_type is not null");
			return (Criteria) this;
		}

		public Criteria andZglTypeEqualTo(Integer value) {
			addCriterion("zgl_type =", value, "zglType");
			return (Criteria) this;
		}

		public Criteria andZglTypeNotEqualTo(Integer value) {
			addCriterion("zgl_type <>", value, "zglType");
			return (Criteria) this;
		}

		public Criteria andZglTypeGreaterThan(Integer value) {
			addCriterion("zgl_type >", value, "zglType");
			return (Criteria) this;
		}

		public Criteria andZglTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("zgl_type >=", value, "zglType");
			return (Criteria) this;
		}

		public Criteria andZglTypeLessThan(Integer value) {
			addCriterion("zgl_type <", value, "zglType");
			return (Criteria) this;
		}

		public Criteria andZglTypeLessThanOrEqualTo(Integer value) {
			addCriterion("zgl_type <=", value, "zglType");
			return (Criteria) this;
		}

		public Criteria andZglTypeIn(List<Integer> values) {
			addCriterion("zgl_type in", values, "zglType");
			return (Criteria) this;
		}

		public Criteria andZglTypeNotIn(List<Integer> values) {
			addCriterion("zgl_type not in", values, "zglType");
			return (Criteria) this;
		}

		public Criteria andZglTypeBetween(Integer value1, Integer value2) {
			addCriterion("zgl_type between", value1, value2, "zglType");
			return (Criteria) this;
		}

		public Criteria andZglTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("zgl_type not between", value1, value2, "zglType");
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
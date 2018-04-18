package com.sinco.carnation.goods.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsFormatExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public GoodsFormatExample() {
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

		public Criteria andDeleteStatusEqualTo(Integer value) {
			addCriterion("delete_status =", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotEqualTo(Integer value) {
			addCriterion("delete_status <>", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusGreaterThan(Integer value) {
			addCriterion("delete_status >", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("delete_status >=", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusLessThan(Integer value) {
			addCriterion("delete_status <", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusLessThanOrEqualTo(Integer value) {
			addCriterion("delete_status <=", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusIn(List<Integer> values) {
			addCriterion("delete_status in", values, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotIn(List<Integer> values) {
			addCriterion("delete_status not in", values, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusBetween(Integer value1, Integer value2) {
			addCriterion("delete_status between", value1, value2, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("delete_status not between", value1, value2, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andGfCatIsNull() {
			addCriterion("gf_cat is null");
			return (Criteria) this;
		}

		public Criteria andGfCatIsNotNull() {
			addCriterion("gf_cat is not null");
			return (Criteria) this;
		}

		public Criteria andGfCatEqualTo(Integer value) {
			addCriterion("gf_cat =", value, "gfCat");
			return (Criteria) this;
		}

		public Criteria andGfCatNotEqualTo(Integer value) {
			addCriterion("gf_cat <>", value, "gfCat");
			return (Criteria) this;
		}

		public Criteria andGfCatGreaterThan(Integer value) {
			addCriterion("gf_cat >", value, "gfCat");
			return (Criteria) this;
		}

		public Criteria andGfCatGreaterThanOrEqualTo(Integer value) {
			addCriterion("gf_cat >=", value, "gfCat");
			return (Criteria) this;
		}

		public Criteria andGfCatLessThan(Integer value) {
			addCriterion("gf_cat <", value, "gfCat");
			return (Criteria) this;
		}

		public Criteria andGfCatLessThanOrEqualTo(Integer value) {
			addCriterion("gf_cat <=", value, "gfCat");
			return (Criteria) this;
		}

		public Criteria andGfCatIn(List<Integer> values) {
			addCriterion("gf_cat in", values, "gfCat");
			return (Criteria) this;
		}

		public Criteria andGfCatNotIn(List<Integer> values) {
			addCriterion("gf_cat not in", values, "gfCat");
			return (Criteria) this;
		}

		public Criteria andGfCatBetween(Integer value1, Integer value2) {
			addCriterion("gf_cat between", value1, value2, "gfCat");
			return (Criteria) this;
		}

		public Criteria andGfCatNotBetween(Integer value1, Integer value2) {
			addCriterion("gf_cat not between", value1, value2, "gfCat");
			return (Criteria) this;
		}

		public Criteria andGfNameIsNull() {
			addCriterion("gf_name is null");
			return (Criteria) this;
		}

		public Criteria andGfNameIsNotNull() {
			addCriterion("gf_name is not null");
			return (Criteria) this;
		}

		public Criteria andGfNameEqualTo(String value) {
			addCriterion("gf_name =", value, "gfName");
			return (Criteria) this;
		}

		public Criteria andGfNameNotEqualTo(String value) {
			addCriterion("gf_name <>", value, "gfName");
			return (Criteria) this;
		}

		public Criteria andGfNameGreaterThan(String value) {
			addCriterion("gf_name >", value, "gfName");
			return (Criteria) this;
		}

		public Criteria andGfNameGreaterThanOrEqualTo(String value) {
			addCriterion("gf_name >=", value, "gfName");
			return (Criteria) this;
		}

		public Criteria andGfNameLessThan(String value) {
			addCriterion("gf_name <", value, "gfName");
			return (Criteria) this;
		}

		public Criteria andGfNameLessThanOrEqualTo(String value) {
			addCriterion("gf_name <=", value, "gfName");
			return (Criteria) this;
		}

		public Criteria andGfNameLike(String value) {
			addCriterion("gf_name like", value, "gfName");
			return (Criteria) this;
		}

		public Criteria andGfNameNotLike(String value) {
			addCriterion("gf_name not like", value, "gfName");
			return (Criteria) this;
		}

		public Criteria andGfNameIn(List<String> values) {
			addCriterion("gf_name in", values, "gfName");
			return (Criteria) this;
		}

		public Criteria andGfNameNotIn(List<String> values) {
			addCriterion("gf_name not in", values, "gfName");
			return (Criteria) this;
		}

		public Criteria andGfNameBetween(String value1, String value2) {
			addCriterion("gf_name between", value1, value2, "gfName");
			return (Criteria) this;
		}

		public Criteria andGfNameNotBetween(String value1, String value2) {
			addCriterion("gf_name not between", value1, value2, "gfName");
			return (Criteria) this;
		}

		public Criteria andGfStoreIdIsNull() {
			addCriterion("gf_store_id is null");
			return (Criteria) this;
		}

		public Criteria andGfStoreIdIsNotNull() {
			addCriterion("gf_store_id is not null");
			return (Criteria) this;
		}

		public Criteria andGfStoreIdEqualTo(Long value) {
			addCriterion("gf_store_id =", value, "gfStoreId");
			return (Criteria) this;
		}

		public Criteria andGfStoreIdNotEqualTo(Long value) {
			addCriterion("gf_store_id <>", value, "gfStoreId");
			return (Criteria) this;
		}

		public Criteria andGfStoreIdGreaterThan(Long value) {
			addCriterion("gf_store_id >", value, "gfStoreId");
			return (Criteria) this;
		}

		public Criteria andGfStoreIdGreaterThanOrEqualTo(Long value) {
			addCriterion("gf_store_id >=", value, "gfStoreId");
			return (Criteria) this;
		}

		public Criteria andGfStoreIdLessThan(Long value) {
			addCriterion("gf_store_id <", value, "gfStoreId");
			return (Criteria) this;
		}

		public Criteria andGfStoreIdLessThanOrEqualTo(Long value) {
			addCriterion("gf_store_id <=", value, "gfStoreId");
			return (Criteria) this;
		}

		public Criteria andGfStoreIdIn(List<Long> values) {
			addCriterion("gf_store_id in", values, "gfStoreId");
			return (Criteria) this;
		}

		public Criteria andGfStoreIdNotIn(List<Long> values) {
			addCriterion("gf_store_id not in", values, "gfStoreId");
			return (Criteria) this;
		}

		public Criteria andGfStoreIdBetween(Long value1, Long value2) {
			addCriterion("gf_store_id between", value1, value2, "gfStoreId");
			return (Criteria) this;
		}

		public Criteria andGfStoreIdNotBetween(Long value1, Long value2) {
			addCriterion("gf_store_id not between", value1, value2, "gfStoreId");
			return (Criteria) this;
		}

		public Criteria andGfTypeIsNull() {
			addCriterion("gf_type is null");
			return (Criteria) this;
		}

		public Criteria andGfTypeIsNotNull() {
			addCriterion("gf_type is not null");
			return (Criteria) this;
		}

		public Criteria andGfTypeEqualTo(Integer value) {
			addCriterion("gf_type =", value, "gfType");
			return (Criteria) this;
		}

		public Criteria andGfTypeNotEqualTo(Integer value) {
			addCriterion("gf_type <>", value, "gfType");
			return (Criteria) this;
		}

		public Criteria andGfTypeGreaterThan(Integer value) {
			addCriterion("gf_type >", value, "gfType");
			return (Criteria) this;
		}

		public Criteria andGfTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("gf_type >=", value, "gfType");
			return (Criteria) this;
		}

		public Criteria andGfTypeLessThan(Integer value) {
			addCriterion("gf_type <", value, "gfType");
			return (Criteria) this;
		}

		public Criteria andGfTypeLessThanOrEqualTo(Integer value) {
			addCriterion("gf_type <=", value, "gfType");
			return (Criteria) this;
		}

		public Criteria andGfTypeIn(List<Integer> values) {
			addCriterion("gf_type in", values, "gfType");
			return (Criteria) this;
		}

		public Criteria andGfTypeNotIn(List<Integer> values) {
			addCriterion("gf_type not in", values, "gfType");
			return (Criteria) this;
		}

		public Criteria andGfTypeBetween(Integer value1, Integer value2) {
			addCriterion("gf_type between", value1, value2, "gfType");
			return (Criteria) this;
		}

		public Criteria andGfTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("gf_type not between", value1, value2, "gfType");
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
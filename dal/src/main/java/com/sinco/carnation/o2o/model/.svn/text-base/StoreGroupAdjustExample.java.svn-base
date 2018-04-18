package com.sinco.carnation.o2o.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StoreGroupAdjustExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public StoreGroupAdjustExample() {
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

		public Criteria andAdjustGcMainIsNull() {
			addCriterion("adjust_gc_main is null");
			return (Criteria) this;
		}

		public Criteria andAdjustGcMainIsNotNull() {
			addCriterion("adjust_gc_main is not null");
			return (Criteria) this;
		}

		public Criteria andAdjustGcMainEqualTo(String value) {
			addCriterion("adjust_gc_main =", value, "adjustGcMain");
			return (Criteria) this;
		}

		public Criteria andAdjustGcMainNotEqualTo(String value) {
			addCriterion("adjust_gc_main <>", value, "adjustGcMain");
			return (Criteria) this;
		}

		public Criteria andAdjustGcMainGreaterThan(String value) {
			addCriterion("adjust_gc_main >", value, "adjustGcMain");
			return (Criteria) this;
		}

		public Criteria andAdjustGcMainGreaterThanOrEqualTo(String value) {
			addCriterion("adjust_gc_main >=", value, "adjustGcMain");
			return (Criteria) this;
		}

		public Criteria andAdjustGcMainLessThan(String value) {
			addCriterion("adjust_gc_main <", value, "adjustGcMain");
			return (Criteria) this;
		}

		public Criteria andAdjustGcMainLessThanOrEqualTo(String value) {
			addCriterion("adjust_gc_main <=", value, "adjustGcMain");
			return (Criteria) this;
		}

		public Criteria andAdjustGcMainLike(String value) {
			addCriterion("adjust_gc_main like", value, "adjustGcMain");
			return (Criteria) this;
		}

		public Criteria andAdjustGcMainNotLike(String value) {
			addCriterion("adjust_gc_main not like", value, "adjustGcMain");
			return (Criteria) this;
		}

		public Criteria andAdjustGcMainIn(List<String> values) {
			addCriterion("adjust_gc_main in", values, "adjustGcMain");
			return (Criteria) this;
		}

		public Criteria andAdjustGcMainNotIn(List<String> values) {
			addCriterion("adjust_gc_main not in", values, "adjustGcMain");
			return (Criteria) this;
		}

		public Criteria andAdjustGcMainBetween(String value1, String value2) {
			addCriterion("adjust_gc_main between", value1, value2, "adjustGcMain");
			return (Criteria) this;
		}

		public Criteria andAdjustGcMainNotBetween(String value1, String value2) {
			addCriterion("adjust_gc_main not between", value1, value2, "adjustGcMain");
			return (Criteria) this;
		}

		public Criteria andAdjustGcMainIdIsNull() {
			addCriterion("adjust_gc_main_id is null");
			return (Criteria) this;
		}

		public Criteria andAdjustGcMainIdIsNotNull() {
			addCriterion("adjust_gc_main_id is not null");
			return (Criteria) this;
		}

		public Criteria andAdjustGcMainIdEqualTo(Long value) {
			addCriterion("adjust_gc_main_id =", value, "adjustGcMainId");
			return (Criteria) this;
		}

		public Criteria andAdjustGcMainIdNotEqualTo(Long value) {
			addCriterion("adjust_gc_main_id <>", value, "adjustGcMainId");
			return (Criteria) this;
		}

		public Criteria andAdjustGcMainIdGreaterThan(Long value) {
			addCriterion("adjust_gc_main_id >", value, "adjustGcMainId");
			return (Criteria) this;
		}

		public Criteria andAdjustGcMainIdGreaterThanOrEqualTo(Long value) {
			addCriterion("adjust_gc_main_id >=", value, "adjustGcMainId");
			return (Criteria) this;
		}

		public Criteria andAdjustGcMainIdLessThan(Long value) {
			addCriterion("adjust_gc_main_id <", value, "adjustGcMainId");
			return (Criteria) this;
		}

		public Criteria andAdjustGcMainIdLessThanOrEqualTo(Long value) {
			addCriterion("adjust_gc_main_id <=", value, "adjustGcMainId");
			return (Criteria) this;
		}

		public Criteria andAdjustGcMainIdIn(List<Long> values) {
			addCriterion("adjust_gc_main_id in", values, "adjustGcMainId");
			return (Criteria) this;
		}

		public Criteria andAdjustGcMainIdNotIn(List<Long> values) {
			addCriterion("adjust_gc_main_id not in", values, "adjustGcMainId");
			return (Criteria) this;
		}

		public Criteria andAdjustGcMainIdBetween(Long value1, Long value2) {
			addCriterion("adjust_gc_main_id between", value1, value2, "adjustGcMainId");
			return (Criteria) this;
		}

		public Criteria andAdjustGcMainIdNotBetween(Long value1, Long value2) {
			addCriterion("adjust_gc_main_id not between", value1, value2, "adjustGcMainId");
			return (Criteria) this;
		}

		public Criteria andAdjustTypeIsNull() {
			addCriterion("adjust_type is null");
			return (Criteria) this;
		}

		public Criteria andAdjustTypeIsNotNull() {
			addCriterion("adjust_type is not null");
			return (Criteria) this;
		}

		public Criteria andAdjustTypeEqualTo(String value) {
			addCriterion("adjust_type =", value, "adjustType");
			return (Criteria) this;
		}

		public Criteria andAdjustTypeNotEqualTo(String value) {
			addCriterion("adjust_type <>", value, "adjustType");
			return (Criteria) this;
		}

		public Criteria andAdjustTypeGreaterThan(String value) {
			addCriterion("adjust_type >", value, "adjustType");
			return (Criteria) this;
		}

		public Criteria andAdjustTypeGreaterThanOrEqualTo(String value) {
			addCriterion("adjust_type >=", value, "adjustType");
			return (Criteria) this;
		}

		public Criteria andAdjustTypeLessThan(String value) {
			addCriterion("adjust_type <", value, "adjustType");
			return (Criteria) this;
		}

		public Criteria andAdjustTypeLessThanOrEqualTo(String value) {
			addCriterion("adjust_type <=", value, "adjustType");
			return (Criteria) this;
		}

		public Criteria andAdjustTypeLike(String value) {
			addCriterion("adjust_type like", value, "adjustType");
			return (Criteria) this;
		}

		public Criteria andAdjustTypeNotLike(String value) {
			addCriterion("adjust_type not like", value, "adjustType");
			return (Criteria) this;
		}

		public Criteria andAdjustTypeIn(List<String> values) {
			addCriterion("adjust_type in", values, "adjustType");
			return (Criteria) this;
		}

		public Criteria andAdjustTypeNotIn(List<String> values) {
			addCriterion("adjust_type not in", values, "adjustType");
			return (Criteria) this;
		}

		public Criteria andAdjustTypeBetween(String value1, String value2) {
			addCriterion("adjust_type between", value1, value2, "adjustType");
			return (Criteria) this;
		}

		public Criteria andAdjustTypeNotBetween(String value1, String value2) {
			addCriterion("adjust_type not between", value1, value2, "adjustType");
			return (Criteria) this;
		}

		public Criteria andApplyStatusIsNull() {
			addCriterion("apply_status is null");
			return (Criteria) this;
		}

		public Criteria andApplyStatusIsNotNull() {
			addCriterion("apply_status is not null");
			return (Criteria) this;
		}

		public Criteria andApplyStatusEqualTo(Integer value) {
			addCriterion("apply_status =", value, "applyStatus");
			return (Criteria) this;
		}

		public Criteria andApplyStatusNotEqualTo(Integer value) {
			addCriterion("apply_status <>", value, "applyStatus");
			return (Criteria) this;
		}

		public Criteria andApplyStatusGreaterThan(Integer value) {
			addCriterion("apply_status >", value, "applyStatus");
			return (Criteria) this;
		}

		public Criteria andApplyStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("apply_status >=", value, "applyStatus");
			return (Criteria) this;
		}

		public Criteria andApplyStatusLessThan(Integer value) {
			addCriterion("apply_status <", value, "applyStatus");
			return (Criteria) this;
		}

		public Criteria andApplyStatusLessThanOrEqualTo(Integer value) {
			addCriterion("apply_status <=", value, "applyStatus");
			return (Criteria) this;
		}

		public Criteria andApplyStatusIn(List<Integer> values) {
			addCriterion("apply_status in", values, "applyStatus");
			return (Criteria) this;
		}

		public Criteria andApplyStatusNotIn(List<Integer> values) {
			addCriterion("apply_status not in", values, "applyStatus");
			return (Criteria) this;
		}

		public Criteria andApplyStatusBetween(Integer value1, Integer value2) {
			addCriterion("apply_status between", value1, value2, "applyStatus");
			return (Criteria) this;
		}

		public Criteria andApplyStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("apply_status not between", value1, value2, "applyStatus");
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
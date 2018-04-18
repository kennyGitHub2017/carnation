package com.sinco.carnation.store.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StorePointExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public StorePointExample() {
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

		public Criteria andDescriptionEvaluateIsNull() {
			addCriterion("description_evaluate is null");
			return (Criteria) this;
		}

		public Criteria andDescriptionEvaluateIsNotNull() {
			addCriterion("description_evaluate is not null");
			return (Criteria) this;
		}

		public Criteria andDescriptionEvaluateEqualTo(BigDecimal value) {
			addCriterion("description_evaluate =", value, "descriptionEvaluate");
			return (Criteria) this;
		}

		public Criteria andDescriptionEvaluateNotEqualTo(BigDecimal value) {
			addCriterion("description_evaluate <>", value, "descriptionEvaluate");
			return (Criteria) this;
		}

		public Criteria andDescriptionEvaluateGreaterThan(BigDecimal value) {
			addCriterion("description_evaluate >", value, "descriptionEvaluate");
			return (Criteria) this;
		}

		public Criteria andDescriptionEvaluateGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("description_evaluate >=", value, "descriptionEvaluate");
			return (Criteria) this;
		}

		public Criteria andDescriptionEvaluateLessThan(BigDecimal value) {
			addCriterion("description_evaluate <", value, "descriptionEvaluate");
			return (Criteria) this;
		}

		public Criteria andDescriptionEvaluateLessThanOrEqualTo(BigDecimal value) {
			addCriterion("description_evaluate <=", value, "descriptionEvaluate");
			return (Criteria) this;
		}

		public Criteria andDescriptionEvaluateIn(List<BigDecimal> values) {
			addCriterion("description_evaluate in", values, "descriptionEvaluate");
			return (Criteria) this;
		}

		public Criteria andDescriptionEvaluateNotIn(List<BigDecimal> values) {
			addCriterion("description_evaluate not in", values, "descriptionEvaluate");
			return (Criteria) this;
		}

		public Criteria andDescriptionEvaluateBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("description_evaluate between", value1, value2, "descriptionEvaluate");
			return (Criteria) this;
		}

		public Criteria andDescriptionEvaluateNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("description_evaluate not between", value1, value2, "descriptionEvaluate");
			return (Criteria) this;
		}

		public Criteria andServiceEvaluateIsNull() {
			addCriterion("service_evaluate is null");
			return (Criteria) this;
		}

		public Criteria andServiceEvaluateIsNotNull() {
			addCriterion("service_evaluate is not null");
			return (Criteria) this;
		}

		public Criteria andServiceEvaluateEqualTo(BigDecimal value) {
			addCriterion("service_evaluate =", value, "serviceEvaluate");
			return (Criteria) this;
		}

		public Criteria andServiceEvaluateNotEqualTo(BigDecimal value) {
			addCriterion("service_evaluate <>", value, "serviceEvaluate");
			return (Criteria) this;
		}

		public Criteria andServiceEvaluateGreaterThan(BigDecimal value) {
			addCriterion("service_evaluate >", value, "serviceEvaluate");
			return (Criteria) this;
		}

		public Criteria andServiceEvaluateGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("service_evaluate >=", value, "serviceEvaluate");
			return (Criteria) this;
		}

		public Criteria andServiceEvaluateLessThan(BigDecimal value) {
			addCriterion("service_evaluate <", value, "serviceEvaluate");
			return (Criteria) this;
		}

		public Criteria andServiceEvaluateLessThanOrEqualTo(BigDecimal value) {
			addCriterion("service_evaluate <=", value, "serviceEvaluate");
			return (Criteria) this;
		}

		public Criteria andServiceEvaluateIn(List<BigDecimal> values) {
			addCriterion("service_evaluate in", values, "serviceEvaluate");
			return (Criteria) this;
		}

		public Criteria andServiceEvaluateNotIn(List<BigDecimal> values) {
			addCriterion("service_evaluate not in", values, "serviceEvaluate");
			return (Criteria) this;
		}

		public Criteria andServiceEvaluateBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("service_evaluate between", value1, value2, "serviceEvaluate");
			return (Criteria) this;
		}

		public Criteria andServiceEvaluateNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("service_evaluate not between", value1, value2, "serviceEvaluate");
			return (Criteria) this;
		}

		public Criteria andShipEvaluateIsNull() {
			addCriterion("ship_evaluate is null");
			return (Criteria) this;
		}

		public Criteria andShipEvaluateIsNotNull() {
			addCriterion("ship_evaluate is not null");
			return (Criteria) this;
		}

		public Criteria andShipEvaluateEqualTo(BigDecimal value) {
			addCriterion("ship_evaluate =", value, "shipEvaluate");
			return (Criteria) this;
		}

		public Criteria andShipEvaluateNotEqualTo(BigDecimal value) {
			addCriterion("ship_evaluate <>", value, "shipEvaluate");
			return (Criteria) this;
		}

		public Criteria andShipEvaluateGreaterThan(BigDecimal value) {
			addCriterion("ship_evaluate >", value, "shipEvaluate");
			return (Criteria) this;
		}

		public Criteria andShipEvaluateGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("ship_evaluate >=", value, "shipEvaluate");
			return (Criteria) this;
		}

		public Criteria andShipEvaluateLessThan(BigDecimal value) {
			addCriterion("ship_evaluate <", value, "shipEvaluate");
			return (Criteria) this;
		}

		public Criteria andShipEvaluateLessThanOrEqualTo(BigDecimal value) {
			addCriterion("ship_evaluate <=", value, "shipEvaluate");
			return (Criteria) this;
		}

		public Criteria andShipEvaluateIn(List<BigDecimal> values) {
			addCriterion("ship_evaluate in", values, "shipEvaluate");
			return (Criteria) this;
		}

		public Criteria andShipEvaluateNotIn(List<BigDecimal> values) {
			addCriterion("ship_evaluate not in", values, "shipEvaluate");
			return (Criteria) this;
		}

		public Criteria andShipEvaluateBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("ship_evaluate between", value1, value2, "shipEvaluate");
			return (Criteria) this;
		}

		public Criteria andShipEvaluateNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("ship_evaluate not between", value1, value2, "shipEvaluate");
			return (Criteria) this;
		}

		public Criteria andStatTimeIsNull() {
			addCriterion("stat_time is null");
			return (Criteria) this;
		}

		public Criteria andStatTimeIsNotNull() {
			addCriterion("stat_time is not null");
			return (Criteria) this;
		}

		public Criteria andStatTimeEqualTo(Date value) {
			addCriterion("stat_time =", value, "statTime");
			return (Criteria) this;
		}

		public Criteria andStatTimeNotEqualTo(Date value) {
			addCriterion("stat_time <>", value, "statTime");
			return (Criteria) this;
		}

		public Criteria andStatTimeGreaterThan(Date value) {
			addCriterion("stat_time >", value, "statTime");
			return (Criteria) this;
		}

		public Criteria andStatTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("stat_time >=", value, "statTime");
			return (Criteria) this;
		}

		public Criteria andStatTimeLessThan(Date value) {
			addCriterion("stat_time <", value, "statTime");
			return (Criteria) this;
		}

		public Criteria andStatTimeLessThanOrEqualTo(Date value) {
			addCriterion("stat_time <=", value, "statTime");
			return (Criteria) this;
		}

		public Criteria andStatTimeIn(List<Date> values) {
			addCriterion("stat_time in", values, "statTime");
			return (Criteria) this;
		}

		public Criteria andStatTimeNotIn(List<Date> values) {
			addCriterion("stat_time not in", values, "statTime");
			return (Criteria) this;
		}

		public Criteria andStatTimeBetween(Date value1, Date value2) {
			addCriterion("stat_time between", value1, value2, "statTime");
			return (Criteria) this;
		}

		public Criteria andStatTimeNotBetween(Date value1, Date value2) {
			addCriterion("stat_time not between", value1, value2, "statTime");
			return (Criteria) this;
		}

		public Criteria andStoreEvaluateIsNull() {
			addCriterion("store_evaluate is null");
			return (Criteria) this;
		}

		public Criteria andStoreEvaluateIsNotNull() {
			addCriterion("store_evaluate is not null");
			return (Criteria) this;
		}

		public Criteria andStoreEvaluateEqualTo(BigDecimal value) {
			addCriterion("store_evaluate =", value, "storeEvaluate");
			return (Criteria) this;
		}

		public Criteria andStoreEvaluateNotEqualTo(BigDecimal value) {
			addCriterion("store_evaluate <>", value, "storeEvaluate");
			return (Criteria) this;
		}

		public Criteria andStoreEvaluateGreaterThan(BigDecimal value) {
			addCriterion("store_evaluate >", value, "storeEvaluate");
			return (Criteria) this;
		}

		public Criteria andStoreEvaluateGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("store_evaluate >=", value, "storeEvaluate");
			return (Criteria) this;
		}

		public Criteria andStoreEvaluateLessThan(BigDecimal value) {
			addCriterion("store_evaluate <", value, "storeEvaluate");
			return (Criteria) this;
		}

		public Criteria andStoreEvaluateLessThanOrEqualTo(BigDecimal value) {
			addCriterion("store_evaluate <=", value, "storeEvaluate");
			return (Criteria) this;
		}

		public Criteria andStoreEvaluateIn(List<BigDecimal> values) {
			addCriterion("store_evaluate in", values, "storeEvaluate");
			return (Criteria) this;
		}

		public Criteria andStoreEvaluateNotIn(List<BigDecimal> values) {
			addCriterion("store_evaluate not in", values, "storeEvaluate");
			return (Criteria) this;
		}

		public Criteria andStoreEvaluateBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("store_evaluate between", value1, value2, "storeEvaluate");
			return (Criteria) this;
		}

		public Criteria andStoreEvaluateNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("store_evaluate not between", value1, value2, "storeEvaluate");
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
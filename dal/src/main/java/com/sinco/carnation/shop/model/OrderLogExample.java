package com.sinco.carnation.shop.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderLogExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public OrderLogExample() {
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

		public Criteria andLogInfoIsNull() {
			addCriterion("log_info is null");
			return (Criteria) this;
		}

		public Criteria andLogInfoIsNotNull() {
			addCriterion("log_info is not null");
			return (Criteria) this;
		}

		public Criteria andLogInfoEqualTo(String value) {
			addCriterion("log_info =", value, "logInfo");
			return (Criteria) this;
		}

		public Criteria andLogInfoNotEqualTo(String value) {
			addCriterion("log_info <>", value, "logInfo");
			return (Criteria) this;
		}

		public Criteria andLogInfoGreaterThan(String value) {
			addCriterion("log_info >", value, "logInfo");
			return (Criteria) this;
		}

		public Criteria andLogInfoGreaterThanOrEqualTo(String value) {
			addCriterion("log_info >=", value, "logInfo");
			return (Criteria) this;
		}

		public Criteria andLogInfoLessThan(String value) {
			addCriterion("log_info <", value, "logInfo");
			return (Criteria) this;
		}

		public Criteria andLogInfoLessThanOrEqualTo(String value) {
			addCriterion("log_info <=", value, "logInfo");
			return (Criteria) this;
		}

		public Criteria andLogInfoLike(String value) {
			addCriterion("log_info like", value, "logInfo");
			return (Criteria) this;
		}

		public Criteria andLogInfoNotLike(String value) {
			addCriterion("log_info not like", value, "logInfo");
			return (Criteria) this;
		}

		public Criteria andLogInfoIn(List<String> values) {
			addCriterion("log_info in", values, "logInfo");
			return (Criteria) this;
		}

		public Criteria andLogInfoNotIn(List<String> values) {
			addCriterion("log_info not in", values, "logInfo");
			return (Criteria) this;
		}

		public Criteria andLogInfoBetween(String value1, String value2) {
			addCriterion("log_info between", value1, value2, "logInfo");
			return (Criteria) this;
		}

		public Criteria andLogInfoNotBetween(String value1, String value2) {
			addCriterion("log_info not between", value1, value2, "logInfo");
			return (Criteria) this;
		}

		public Criteria andLogUserIdIsNull() {
			addCriterion("log_user_id is null");
			return (Criteria) this;
		}

		public Criteria andLogUserIdIsNotNull() {
			addCriterion("log_user_id is not null");
			return (Criteria) this;
		}

		public Criteria andLogUserIdEqualTo(Long value) {
			addCriterion("log_user_id =", value, "logUserId");
			return (Criteria) this;
		}

		public Criteria andLogUserIdNotEqualTo(Long value) {
			addCriterion("log_user_id <>", value, "logUserId");
			return (Criteria) this;
		}

		public Criteria andLogUserIdGreaterThan(Long value) {
			addCriterion("log_user_id >", value, "logUserId");
			return (Criteria) this;
		}

		public Criteria andLogUserIdGreaterThanOrEqualTo(Long value) {
			addCriterion("log_user_id >=", value, "logUserId");
			return (Criteria) this;
		}

		public Criteria andLogUserIdLessThan(Long value) {
			addCriterion("log_user_id <", value, "logUserId");
			return (Criteria) this;
		}

		public Criteria andLogUserIdLessThanOrEqualTo(Long value) {
			addCriterion("log_user_id <=", value, "logUserId");
			return (Criteria) this;
		}

		public Criteria andLogUserIdIn(List<Long> values) {
			addCriterion("log_user_id in", values, "logUserId");
			return (Criteria) this;
		}

		public Criteria andLogUserIdNotIn(List<Long> values) {
			addCriterion("log_user_id not in", values, "logUserId");
			return (Criteria) this;
		}

		public Criteria andLogUserIdBetween(Long value1, Long value2) {
			addCriterion("log_user_id between", value1, value2, "logUserId");
			return (Criteria) this;
		}

		public Criteria andLogUserIdNotBetween(Long value1, Long value2) {
			addCriterion("log_user_id not between", value1, value2, "logUserId");
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
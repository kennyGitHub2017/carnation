package com.sinco.carnation.user.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UserStepRecordExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public UserStepRecordExample() {
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

		protected void addCriterionForJDBCDate(String condition, Date value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value.getTime()), property);
		}

		protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property + " cannot be null or empty");
			}
			List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
			Iterator<Date> iter = values.iterator();
			while (iter.hasNext()) {
				dateList.add(new java.sql.Date(iter.next().getTime()));
			}
			addCriterion(condition, dateList, property);
		}

		protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()),
					property);
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

		public Criteria andUidIsNull() {
			addCriterion("uid is null");
			return (Criteria) this;
		}

		public Criteria andUidIsNotNull() {
			addCriterion("uid is not null");
			return (Criteria) this;
		}

		public Criteria andUidEqualTo(Long value) {
			addCriterion("uid =", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidNotEqualTo(Long value) {
			addCriterion("uid <>", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidGreaterThan(Long value) {
			addCriterion("uid >", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidGreaterThanOrEqualTo(Long value) {
			addCriterion("uid >=", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidLessThan(Long value) {
			addCriterion("uid <", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidLessThanOrEqualTo(Long value) {
			addCriterion("uid <=", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidIn(List<Long> values) {
			addCriterion("uid in", values, "uid");
			return (Criteria) this;
		}

		public Criteria andUidNotIn(List<Long> values) {
			addCriterion("uid not in", values, "uid");
			return (Criteria) this;
		}

		public Criteria andUidBetween(Long value1, Long value2) {
			addCriterion("uid between", value1, value2, "uid");
			return (Criteria) this;
		}

		public Criteria andUidNotBetween(Long value1, Long value2) {
			addCriterion("uid not between", value1, value2, "uid");
			return (Criteria) this;
		}

		public Criteria andStepNumberIsNull() {
			addCriterion("step_number is null");
			return (Criteria) this;
		}

		public Criteria andStepNumberIsNotNull() {
			addCriterion("step_number is not null");
			return (Criteria) this;
		}

		public Criteria andStepNumberEqualTo(Integer value) {
			addCriterion("step_number =", value, "stepNumber");
			return (Criteria) this;
		}

		public Criteria andStepNumberNotEqualTo(Integer value) {
			addCriterion("step_number <>", value, "stepNumber");
			return (Criteria) this;
		}

		public Criteria andStepNumberGreaterThan(Integer value) {
			addCriterion("step_number >", value, "stepNumber");
			return (Criteria) this;
		}

		public Criteria andStepNumberGreaterThanOrEqualTo(Integer value) {
			addCriterion("step_number >=", value, "stepNumber");
			return (Criteria) this;
		}

		public Criteria andStepNumberLessThan(Integer value) {
			addCriterion("step_number <", value, "stepNumber");
			return (Criteria) this;
		}

		public Criteria andStepNumberLessThanOrEqualTo(Integer value) {
			addCriterion("step_number <=", value, "stepNumber");
			return (Criteria) this;
		}

		public Criteria andStepNumberIn(List<Integer> values) {
			addCriterion("step_number in", values, "stepNumber");
			return (Criteria) this;
		}

		public Criteria andStepNumberNotIn(List<Integer> values) {
			addCriterion("step_number not in", values, "stepNumber");
			return (Criteria) this;
		}

		public Criteria andStepNumberBetween(Integer value1, Integer value2) {
			addCriterion("step_number between", value1, value2, "stepNumber");
			return (Criteria) this;
		}

		public Criteria andStepNumberNotBetween(Integer value1, Integer value2) {
			addCriterion("step_number not between", value1, value2, "stepNumber");
			return (Criteria) this;
		}

		public Criteria andRecordDateIsNull() {
			addCriterion("record_date is null");
			return (Criteria) this;
		}

		public Criteria andRecordDateIsNotNull() {
			addCriterion("record_date is not null");
			return (Criteria) this;
		}

		public Criteria andRecordDateEqualTo(Date value) {
			addCriterionForJDBCDate("record_date =", value, "recordDate");
			return (Criteria) this;
		}

		public Criteria andRecordDateNotEqualTo(Date value) {
			addCriterionForJDBCDate("record_date <>", value, "recordDate");
			return (Criteria) this;
		}

		public Criteria andRecordDateGreaterThan(Date value) {
			addCriterionForJDBCDate("record_date >", value, "recordDate");
			return (Criteria) this;
		}

		public Criteria andRecordDateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("record_date >=", value, "recordDate");
			return (Criteria) this;
		}

		public Criteria andRecordDateLessThan(Date value) {
			addCriterionForJDBCDate("record_date <", value, "recordDate");
			return (Criteria) this;
		}

		public Criteria andRecordDateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("record_date <=", value, "recordDate");
			return (Criteria) this;
		}

		public Criteria andRecordDateIn(List<Date> values) {
			addCriterionForJDBCDate("record_date in", values, "recordDate");
			return (Criteria) this;
		}

		public Criteria andRecordDateNotIn(List<Date> values) {
			addCriterionForJDBCDate("record_date not in", values, "recordDate");
			return (Criteria) this;
		}

		public Criteria andRecordDateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("record_date between", value1, value2, "recordDate");
			return (Criteria) this;
		}

		public Criteria andRecordDateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("record_date not between", value1, value2, "recordDate");
			return (Criteria) this;
		}

		public Criteria andTotalKmIsNull() {
			addCriterion("total_Km is null");
			return (Criteria) this;
		}

		public Criteria andTotalKmIsNotNull() {
			addCriterion("total_Km is not null");
			return (Criteria) this;
		}

		public Criteria andTotalKmEqualTo(Long value) {
			addCriterion("total_Km =", value, "totalKm");
			return (Criteria) this;
		}

		public Criteria andTotalKmNotEqualTo(Long value) {
			addCriterion("total_Km <>", value, "totalKm");
			return (Criteria) this;
		}

		public Criteria andTotalKmGreaterThan(Long value) {
			addCriterion("total_Km >", value, "totalKm");
			return (Criteria) this;
		}

		public Criteria andTotalKmGreaterThanOrEqualTo(Long value) {
			addCriterion("total_Km >=", value, "totalKm");
			return (Criteria) this;
		}

		public Criteria andTotalKmLessThan(Long value) {
			addCriterion("total_Km <", value, "totalKm");
			return (Criteria) this;
		}

		public Criteria andTotalKmLessThanOrEqualTo(Long value) {
			addCriterion("total_Km <=", value, "totalKm");
			return (Criteria) this;
		}

		public Criteria andTotalKmIn(List<Long> values) {
			addCriterion("total_Km in", values, "totalKm");
			return (Criteria) this;
		}

		public Criteria andTotalKmNotIn(List<Long> values) {
			addCriterion("total_Km not in", values, "totalKm");
			return (Criteria) this;
		}

		public Criteria andTotalKmBetween(Long value1, Long value2) {
			addCriterion("total_Km between", value1, value2, "totalKm");
			return (Criteria) this;
		}

		public Criteria andTotalKmNotBetween(Long value1, Long value2) {
			addCriterion("total_Km not between", value1, value2, "totalKm");
			return (Criteria) this;
		}

		public Criteria andCaloriesIsNull() {
			addCriterion("calories is null");
			return (Criteria) this;
		}

		public Criteria andCaloriesIsNotNull() {
			addCriterion("calories is not null");
			return (Criteria) this;
		}

		public Criteria andCaloriesEqualTo(Long value) {
			addCriterion("calories =", value, "calories");
			return (Criteria) this;
		}

		public Criteria andCaloriesNotEqualTo(Long value) {
			addCriterion("calories <>", value, "calories");
			return (Criteria) this;
		}

		public Criteria andCaloriesGreaterThan(Long value) {
			addCriterion("calories >", value, "calories");
			return (Criteria) this;
		}

		public Criteria andCaloriesGreaterThanOrEqualTo(Long value) {
			addCriterion("calories >=", value, "calories");
			return (Criteria) this;
		}

		public Criteria andCaloriesLessThan(Long value) {
			addCriterion("calories <", value, "calories");
			return (Criteria) this;
		}

		public Criteria andCaloriesLessThanOrEqualTo(Long value) {
			addCriterion("calories <=", value, "calories");
			return (Criteria) this;
		}

		public Criteria andCaloriesIn(List<Long> values) {
			addCriterion("calories in", values, "calories");
			return (Criteria) this;
		}

		public Criteria andCaloriesNotIn(List<Long> values) {
			addCriterion("calories not in", values, "calories");
			return (Criteria) this;
		}

		public Criteria andCaloriesBetween(Long value1, Long value2) {
			addCriterion("calories between", value1, value2, "calories");
			return (Criteria) this;
		}

		public Criteria andCaloriesNotBetween(Long value1, Long value2) {
			addCriterion("calories not between", value1, value2, "calories");
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
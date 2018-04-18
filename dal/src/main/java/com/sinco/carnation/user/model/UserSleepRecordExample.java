package com.sinco.carnation.user.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UserSleepRecordExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public UserSleepRecordExample() {
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

		public Criteria andSleepSecondIsNull() {
			addCriterion("sleep_second is null");
			return (Criteria) this;
		}

		public Criteria andSleepSecondIsNotNull() {
			addCriterion("sleep_second is not null");
			return (Criteria) this;
		}

		public Criteria andSleepSecondEqualTo(Long value) {
			addCriterion("sleep_second =", value, "sleepSecond");
			return (Criteria) this;
		}

		public Criteria andSleepSecondNotEqualTo(Long value) {
			addCriterion("sleep_second <>", value, "sleepSecond");
			return (Criteria) this;
		}

		public Criteria andSleepSecondGreaterThan(Long value) {
			addCriterion("sleep_second >", value, "sleepSecond");
			return (Criteria) this;
		}

		public Criteria andSleepSecondGreaterThanOrEqualTo(Long value) {
			addCriterion("sleep_second >=", value, "sleepSecond");
			return (Criteria) this;
		}

		public Criteria andSleepSecondLessThan(Long value) {
			addCriterion("sleep_second <", value, "sleepSecond");
			return (Criteria) this;
		}

		public Criteria andSleepSecondLessThanOrEqualTo(Long value) {
			addCriterion("sleep_second <=", value, "sleepSecond");
			return (Criteria) this;
		}

		public Criteria andSleepSecondIn(List<Long> values) {
			addCriterion("sleep_second in", values, "sleepSecond");
			return (Criteria) this;
		}

		public Criteria andSleepSecondNotIn(List<Long> values) {
			addCriterion("sleep_second not in", values, "sleepSecond");
			return (Criteria) this;
		}

		public Criteria andSleepSecondBetween(Long value1, Long value2) {
			addCriterion("sleep_second between", value1, value2, "sleepSecond");
			return (Criteria) this;
		}

		public Criteria andSleepSecondNotBetween(Long value1, Long value2) {
			addCriterion("sleep_second not between", value1, value2, "sleepSecond");
			return (Criteria) this;
		}

		public Criteria andDeepSleepSecondIsNull() {
			addCriterion("deep_sleep_second is null");
			return (Criteria) this;
		}

		public Criteria andDeepSleepSecondIsNotNull() {
			addCriterion("deep_sleep_second is not null");
			return (Criteria) this;
		}

		public Criteria andDeepSleepSecondEqualTo(Long value) {
			addCriterion("deep_sleep_second =", value, "deepSleepSecond");
			return (Criteria) this;
		}

		public Criteria andDeepSleepSecondNotEqualTo(Long value) {
			addCriterion("deep_sleep_second <>", value, "deepSleepSecond");
			return (Criteria) this;
		}

		public Criteria andDeepSleepSecondGreaterThan(Long value) {
			addCriterion("deep_sleep_second >", value, "deepSleepSecond");
			return (Criteria) this;
		}

		public Criteria andDeepSleepSecondGreaterThanOrEqualTo(Long value) {
			addCriterion("deep_sleep_second >=", value, "deepSleepSecond");
			return (Criteria) this;
		}

		public Criteria andDeepSleepSecondLessThan(Long value) {
			addCriterion("deep_sleep_second <", value, "deepSleepSecond");
			return (Criteria) this;
		}

		public Criteria andDeepSleepSecondLessThanOrEqualTo(Long value) {
			addCriterion("deep_sleep_second <=", value, "deepSleepSecond");
			return (Criteria) this;
		}

		public Criteria andDeepSleepSecondIn(List<Long> values) {
			addCriterion("deep_sleep_second in", values, "deepSleepSecond");
			return (Criteria) this;
		}

		public Criteria andDeepSleepSecondNotIn(List<Long> values) {
			addCriterion("deep_sleep_second not in", values, "deepSleepSecond");
			return (Criteria) this;
		}

		public Criteria andDeepSleepSecondBetween(Long value1, Long value2) {
			addCriterion("deep_sleep_second between", value1, value2, "deepSleepSecond");
			return (Criteria) this;
		}

		public Criteria andDeepSleepSecondNotBetween(Long value1, Long value2) {
			addCriterion("deep_sleep_second not between", value1, value2, "deepSleepSecond");
			return (Criteria) this;
		}

		public Criteria andShallowSleepSecondIsNull() {
			addCriterion("shallow_sleep_second is null");
			return (Criteria) this;
		}

		public Criteria andShallowSleepSecondIsNotNull() {
			addCriterion("shallow_sleep_second is not null");
			return (Criteria) this;
		}

		public Criteria andShallowSleepSecondEqualTo(Long value) {
			addCriterion("shallow_sleep_second =", value, "shallowSleepSecond");
			return (Criteria) this;
		}

		public Criteria andShallowSleepSecondNotEqualTo(Long value) {
			addCriterion("shallow_sleep_second <>", value, "shallowSleepSecond");
			return (Criteria) this;
		}

		public Criteria andShallowSleepSecondGreaterThan(Long value) {
			addCriterion("shallow_sleep_second >", value, "shallowSleepSecond");
			return (Criteria) this;
		}

		public Criteria andShallowSleepSecondGreaterThanOrEqualTo(Long value) {
			addCriterion("shallow_sleep_second >=", value, "shallowSleepSecond");
			return (Criteria) this;
		}

		public Criteria andShallowSleepSecondLessThan(Long value) {
			addCriterion("shallow_sleep_second <", value, "shallowSleepSecond");
			return (Criteria) this;
		}

		public Criteria andShallowSleepSecondLessThanOrEqualTo(Long value) {
			addCriterion("shallow_sleep_second <=", value, "shallowSleepSecond");
			return (Criteria) this;
		}

		public Criteria andShallowSleepSecondIn(List<Long> values) {
			addCriterion("shallow_sleep_second in", values, "shallowSleepSecond");
			return (Criteria) this;
		}

		public Criteria andShallowSleepSecondNotIn(List<Long> values) {
			addCriterion("shallow_sleep_second not in", values, "shallowSleepSecond");
			return (Criteria) this;
		}

		public Criteria andShallowSleepSecondBetween(Long value1, Long value2) {
			addCriterion("shallow_sleep_second between", value1, value2, "shallowSleepSecond");
			return (Criteria) this;
		}

		public Criteria andShallowSleepSecondNotBetween(Long value1, Long value2) {
			addCriterion("shallow_sleep_second not between", value1, value2, "shallowSleepSecond");
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
package com.sinco.carnation.o2o.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GroupEvaluationStoreTotalExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public GroupEvaluationStoreTotalExample() {
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

		public Criteria andOneIsNull() {
			addCriterion("one is null");
			return (Criteria) this;
		}

		public Criteria andOneIsNotNull() {
			addCriterion("one is not null");
			return (Criteria) this;
		}

		public Criteria andOneEqualTo(Integer value) {
			addCriterion("one =", value, "one");
			return (Criteria) this;
		}

		public Criteria andOneNotEqualTo(Integer value) {
			addCriterion("one <>", value, "one");
			return (Criteria) this;
		}

		public Criteria andOneGreaterThan(Integer value) {
			addCriterion("one >", value, "one");
			return (Criteria) this;
		}

		public Criteria andOneGreaterThanOrEqualTo(Integer value) {
			addCriterion("one >=", value, "one");
			return (Criteria) this;
		}

		public Criteria andOneLessThan(Integer value) {
			addCriterion("one <", value, "one");
			return (Criteria) this;
		}

		public Criteria andOneLessThanOrEqualTo(Integer value) {
			addCriterion("one <=", value, "one");
			return (Criteria) this;
		}

		public Criteria andOneIn(List<Integer> values) {
			addCriterion("one in", values, "one");
			return (Criteria) this;
		}

		public Criteria andOneNotIn(List<Integer> values) {
			addCriterion("one not in", values, "one");
			return (Criteria) this;
		}

		public Criteria andOneBetween(Integer value1, Integer value2) {
			addCriterion("one between", value1, value2, "one");
			return (Criteria) this;
		}

		public Criteria andOneNotBetween(Integer value1, Integer value2) {
			addCriterion("one not between", value1, value2, "one");
			return (Criteria) this;
		}

		public Criteria andTwoIsNull() {
			addCriterion("two is null");
			return (Criteria) this;
		}

		public Criteria andTwoIsNotNull() {
			addCriterion("two is not null");
			return (Criteria) this;
		}

		public Criteria andTwoEqualTo(Integer value) {
			addCriterion("two =", value, "two");
			return (Criteria) this;
		}

		public Criteria andTwoNotEqualTo(Integer value) {
			addCriterion("two <>", value, "two");
			return (Criteria) this;
		}

		public Criteria andTwoGreaterThan(Integer value) {
			addCriterion("two >", value, "two");
			return (Criteria) this;
		}

		public Criteria andTwoGreaterThanOrEqualTo(Integer value) {
			addCriterion("two >=", value, "two");
			return (Criteria) this;
		}

		public Criteria andTwoLessThan(Integer value) {
			addCriterion("two <", value, "two");
			return (Criteria) this;
		}

		public Criteria andTwoLessThanOrEqualTo(Integer value) {
			addCriterion("two <=", value, "two");
			return (Criteria) this;
		}

		public Criteria andTwoIn(List<Integer> values) {
			addCriterion("two in", values, "two");
			return (Criteria) this;
		}

		public Criteria andTwoNotIn(List<Integer> values) {
			addCriterion("two not in", values, "two");
			return (Criteria) this;
		}

		public Criteria andTwoBetween(Integer value1, Integer value2) {
			addCriterion("two between", value1, value2, "two");
			return (Criteria) this;
		}

		public Criteria andTwoNotBetween(Integer value1, Integer value2) {
			addCriterion("two not between", value1, value2, "two");
			return (Criteria) this;
		}

		public Criteria andThreeIsNull() {
			addCriterion("three is null");
			return (Criteria) this;
		}

		public Criteria andThreeIsNotNull() {
			addCriterion("three is not null");
			return (Criteria) this;
		}

		public Criteria andThreeEqualTo(Integer value) {
			addCriterion("three =", value, "three");
			return (Criteria) this;
		}

		public Criteria andThreeNotEqualTo(Integer value) {
			addCriterion("three <>", value, "three");
			return (Criteria) this;
		}

		public Criteria andThreeGreaterThan(Integer value) {
			addCriterion("three >", value, "three");
			return (Criteria) this;
		}

		public Criteria andThreeGreaterThanOrEqualTo(Integer value) {
			addCriterion("three >=", value, "three");
			return (Criteria) this;
		}

		public Criteria andThreeLessThan(Integer value) {
			addCriterion("three <", value, "three");
			return (Criteria) this;
		}

		public Criteria andThreeLessThanOrEqualTo(Integer value) {
			addCriterion("three <=", value, "three");
			return (Criteria) this;
		}

		public Criteria andThreeIn(List<Integer> values) {
			addCriterion("three in", values, "three");
			return (Criteria) this;
		}

		public Criteria andThreeNotIn(List<Integer> values) {
			addCriterion("three not in", values, "three");
			return (Criteria) this;
		}

		public Criteria andThreeBetween(Integer value1, Integer value2) {
			addCriterion("three between", value1, value2, "three");
			return (Criteria) this;
		}

		public Criteria andThreeNotBetween(Integer value1, Integer value2) {
			addCriterion("three not between", value1, value2, "three");
			return (Criteria) this;
		}

		public Criteria andFourIsNull() {
			addCriterion("four is null");
			return (Criteria) this;
		}

		public Criteria andFourIsNotNull() {
			addCriterion("four is not null");
			return (Criteria) this;
		}

		public Criteria andFourEqualTo(Integer value) {
			addCriterion("four =", value, "four");
			return (Criteria) this;
		}

		public Criteria andFourNotEqualTo(Integer value) {
			addCriterion("four <>", value, "four");
			return (Criteria) this;
		}

		public Criteria andFourGreaterThan(Integer value) {
			addCriterion("four >", value, "four");
			return (Criteria) this;
		}

		public Criteria andFourGreaterThanOrEqualTo(Integer value) {
			addCriterion("four >=", value, "four");
			return (Criteria) this;
		}

		public Criteria andFourLessThan(Integer value) {
			addCriterion("four <", value, "four");
			return (Criteria) this;
		}

		public Criteria andFourLessThanOrEqualTo(Integer value) {
			addCriterion("four <=", value, "four");
			return (Criteria) this;
		}

		public Criteria andFourIn(List<Integer> values) {
			addCriterion("four in", values, "four");
			return (Criteria) this;
		}

		public Criteria andFourNotIn(List<Integer> values) {
			addCriterion("four not in", values, "four");
			return (Criteria) this;
		}

		public Criteria andFourBetween(Integer value1, Integer value2) {
			addCriterion("four between", value1, value2, "four");
			return (Criteria) this;
		}

		public Criteria andFourNotBetween(Integer value1, Integer value2) {
			addCriterion("four not between", value1, value2, "four");
			return (Criteria) this;
		}

		public Criteria andFiveIsNull() {
			addCriterion("five is null");
			return (Criteria) this;
		}

		public Criteria andFiveIsNotNull() {
			addCriterion("five is not null");
			return (Criteria) this;
		}

		public Criteria andFiveEqualTo(Integer value) {
			addCriterion("five =", value, "five");
			return (Criteria) this;
		}

		public Criteria andFiveNotEqualTo(Integer value) {
			addCriterion("five <>", value, "five");
			return (Criteria) this;
		}

		public Criteria andFiveGreaterThan(Integer value) {
			addCriterion("five >", value, "five");
			return (Criteria) this;
		}

		public Criteria andFiveGreaterThanOrEqualTo(Integer value) {
			addCriterion("five >=", value, "five");
			return (Criteria) this;
		}

		public Criteria andFiveLessThan(Integer value) {
			addCriterion("five <", value, "five");
			return (Criteria) this;
		}

		public Criteria andFiveLessThanOrEqualTo(Integer value) {
			addCriterion("five <=", value, "five");
			return (Criteria) this;
		}

		public Criteria andFiveIn(List<Integer> values) {
			addCriterion("five in", values, "five");
			return (Criteria) this;
		}

		public Criteria andFiveNotIn(List<Integer> values) {
			addCriterion("five not in", values, "five");
			return (Criteria) this;
		}

		public Criteria andFiveBetween(Integer value1, Integer value2) {
			addCriterion("five between", value1, value2, "five");
			return (Criteria) this;
		}

		public Criteria andFiveNotBetween(Integer value1, Integer value2) {
			addCriterion("five not between", value1, value2, "five");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIsNull() {
			addCriterion("update_time is null");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIsNotNull() {
			addCriterion("update_time is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeEqualTo(Date value) {
			addCriterion("update_time =", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotEqualTo(Date value) {
			addCriterion("update_time <>", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThan(Date value) {
			addCriterion("update_time >", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("update_time >=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThan(Date value) {
			addCriterion("update_time <", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
			addCriterion("update_time <=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIn(List<Date> values) {
			addCriterion("update_time in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotIn(List<Date> values) {
			addCriterion("update_time not in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeBetween(Date value1, Date value2) {
			addCriterion("update_time between", value1, value2, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
			addCriterion("update_time not between", value1, value2, "updateTime");
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
package com.sinco.carnation.sns.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OperatorNoticesExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public OperatorNoticesExample() {
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
			addCriterion("add_Time is null");
			return (Criteria) this;
		}

		public Criteria andAddTimeIsNotNull() {
			addCriterion("add_Time is not null");
			return (Criteria) this;
		}

		public Criteria andAddTimeEqualTo(Date value) {
			addCriterion("add_Time =", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeNotEqualTo(Date value) {
			addCriterion("add_Time <>", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeGreaterThan(Date value) {
			addCriterion("add_Time >", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("add_Time >=", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeLessThan(Date value) {
			addCriterion("add_Time <", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeLessThanOrEqualTo(Date value) {
			addCriterion("add_Time <=", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeIn(List<Date> values) {
			addCriterion("add_Time in", values, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeNotIn(List<Date> values) {
			addCriterion("add_Time not in", values, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeBetween(Date value1, Date value2) {
			addCriterion("add_Time between", value1, value2, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeNotBetween(Date value1, Date value2) {
			addCriterion("add_Time not between", value1, value2, "addTime");
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

		public Criteria andNtSortIsNull() {
			addCriterion("nt_sort is null");
			return (Criteria) this;
		}

		public Criteria andNtSortIsNotNull() {
			addCriterion("nt_sort is not null");
			return (Criteria) this;
		}

		public Criteria andNtSortEqualTo(Integer value) {
			addCriterion("nt_sort =", value, "ntSort");
			return (Criteria) this;
		}

		public Criteria andNtSortNotEqualTo(Integer value) {
			addCriterion("nt_sort <>", value, "ntSort");
			return (Criteria) this;
		}

		public Criteria andNtSortGreaterThan(Integer value) {
			addCriterion("nt_sort >", value, "ntSort");
			return (Criteria) this;
		}

		public Criteria andNtSortGreaterThanOrEqualTo(Integer value) {
			addCriterion("nt_sort >=", value, "ntSort");
			return (Criteria) this;
		}

		public Criteria andNtSortLessThan(Integer value) {
			addCriterion("nt_sort <", value, "ntSort");
			return (Criteria) this;
		}

		public Criteria andNtSortLessThanOrEqualTo(Integer value) {
			addCriterion("nt_sort <=", value, "ntSort");
			return (Criteria) this;
		}

		public Criteria andNtSortIn(List<Integer> values) {
			addCriterion("nt_sort in", values, "ntSort");
			return (Criteria) this;
		}

		public Criteria andNtSortNotIn(List<Integer> values) {
			addCriterion("nt_sort not in", values, "ntSort");
			return (Criteria) this;
		}

		public Criteria andNtSortBetween(Integer value1, Integer value2) {
			addCriterion("nt_sort between", value1, value2, "ntSort");
			return (Criteria) this;
		}

		public Criteria andNtSortNotBetween(Integer value1, Integer value2) {
			addCriterion("nt_sort not between", value1, value2, "ntSort");
			return (Criteria) this;
		}

		public Criteria andNtStatusIsNull() {
			addCriterion("nt_status is null");
			return (Criteria) this;
		}

		public Criteria andNtStatusIsNotNull() {
			addCriterion("nt_status is not null");
			return (Criteria) this;
		}

		public Criteria andNtStatusEqualTo(Integer value) {
			addCriterion("nt_status =", value, "ntStatus");
			return (Criteria) this;
		}

		public Criteria andNtStatusNotEqualTo(Integer value) {
			addCriterion("nt_status <>", value, "ntStatus");
			return (Criteria) this;
		}

		public Criteria andNtStatusGreaterThan(Integer value) {
			addCriterion("nt_status >", value, "ntStatus");
			return (Criteria) this;
		}

		public Criteria andNtStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("nt_status >=", value, "ntStatus");
			return (Criteria) this;
		}

		public Criteria andNtStatusLessThan(Integer value) {
			addCriterion("nt_status <", value, "ntStatus");
			return (Criteria) this;
		}

		public Criteria andNtStatusLessThanOrEqualTo(Integer value) {
			addCriterion("nt_status <=", value, "ntStatus");
			return (Criteria) this;
		}

		public Criteria andNtStatusIn(List<Integer> values) {
			addCriterion("nt_status in", values, "ntStatus");
			return (Criteria) this;
		}

		public Criteria andNtStatusNotIn(List<Integer> values) {
			addCriterion("nt_status not in", values, "ntStatus");
			return (Criteria) this;
		}

		public Criteria andNtStatusBetween(Integer value1, Integer value2) {
			addCriterion("nt_status between", value1, value2, "ntStatus");
			return (Criteria) this;
		}

		public Criteria andNtStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("nt_status not between", value1, value2, "ntStatus");
			return (Criteria) this;
		}

		public Criteria andNtTitleIsNull() {
			addCriterion("nt_title is null");
			return (Criteria) this;
		}

		public Criteria andNtTitleIsNotNull() {
			addCriterion("nt_title is not null");
			return (Criteria) this;
		}

		public Criteria andNtTitleEqualTo(String value) {
			addCriterion("nt_title =", value, "ntTitle");
			return (Criteria) this;
		}

		public Criteria andNtTitleNotEqualTo(String value) {
			addCriterion("nt_title <>", value, "ntTitle");
			return (Criteria) this;
		}

		public Criteria andNtTitleGreaterThan(String value) {
			addCriterion("nt_title >", value, "ntTitle");
			return (Criteria) this;
		}

		public Criteria andNtTitleGreaterThanOrEqualTo(String value) {
			addCriterion("nt_title >=", value, "ntTitle");
			return (Criteria) this;
		}

		public Criteria andNtTitleLessThan(String value) {
			addCriterion("nt_title <", value, "ntTitle");
			return (Criteria) this;
		}

		public Criteria andNtTitleLessThanOrEqualTo(String value) {
			addCriterion("nt_title <=", value, "ntTitle");
			return (Criteria) this;
		}

		public Criteria andNtTitleLike(String value) {
			addCriterion("nt_title like", value, "ntTitle");
			return (Criteria) this;
		}

		public Criteria andNtTitleNotLike(String value) {
			addCriterion("nt_title not like", value, "ntTitle");
			return (Criteria) this;
		}

		public Criteria andNtTitleIn(List<String> values) {
			addCriterion("nt_title in", values, "ntTitle");
			return (Criteria) this;
		}

		public Criteria andNtTitleNotIn(List<String> values) {
			addCriterion("nt_title not in", values, "ntTitle");
			return (Criteria) this;
		}

		public Criteria andNtTitleBetween(String value1, String value2) {
			addCriterion("nt_title between", value1, value2, "ntTitle");
			return (Criteria) this;
		}

		public Criteria andNtTitleNotBetween(String value1, String value2) {
			addCriterion("nt_title not between", value1, value2, "ntTitle");
			return (Criteria) this;
		}

		public Criteria andOperatorIdIsNull() {
			addCriterion("operator_id is null");
			return (Criteria) this;
		}

		public Criteria andOperatorIdIsNotNull() {
			addCriterion("operator_id is not null");
			return (Criteria) this;
		}

		public Criteria andOperatorIdEqualTo(Long value) {
			addCriterion("operator_id =", value, "operatorId");
			return (Criteria) this;
		}

		public Criteria andOperatorIdNotEqualTo(Long value) {
			addCriterion("operator_id <>", value, "operatorId");
			return (Criteria) this;
		}

		public Criteria andOperatorIdGreaterThan(Long value) {
			addCriterion("operator_id >", value, "operatorId");
			return (Criteria) this;
		}

		public Criteria andOperatorIdGreaterThanOrEqualTo(Long value) {
			addCriterion("operator_id >=", value, "operatorId");
			return (Criteria) this;
		}

		public Criteria andOperatorIdLessThan(Long value) {
			addCriterion("operator_id <", value, "operatorId");
			return (Criteria) this;
		}

		public Criteria andOperatorIdLessThanOrEqualTo(Long value) {
			addCriterion("operator_id <=", value, "operatorId");
			return (Criteria) this;
		}

		public Criteria andOperatorIdIn(List<Long> values) {
			addCriterion("operator_id in", values, "operatorId");
			return (Criteria) this;
		}

		public Criteria andOperatorIdNotIn(List<Long> values) {
			addCriterion("operator_id not in", values, "operatorId");
			return (Criteria) this;
		}

		public Criteria andOperatorIdBetween(Long value1, Long value2) {
			addCriterion("operator_id between", value1, value2, "operatorId");
			return (Criteria) this;
		}

		public Criteria andOperatorIdNotBetween(Long value1, Long value2) {
			addCriterion("operator_id not between", value1, value2, "operatorId");
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
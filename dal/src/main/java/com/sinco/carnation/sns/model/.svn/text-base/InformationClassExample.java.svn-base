package com.sinco.carnation.sns.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InformationClassExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public InformationClassExample() {
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
			addCriterion("delete_Status is null");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusIsNotNull() {
			addCriterion("delete_Status is not null");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusEqualTo(Integer value) {
			addCriterion("delete_Status =", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotEqualTo(Integer value) {
			addCriterion("delete_Status <>", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusGreaterThan(Integer value) {
			addCriterion("delete_Status >", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("delete_Status >=", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusLessThan(Integer value) {
			addCriterion("delete_Status <", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusLessThanOrEqualTo(Integer value) {
			addCriterion("delete_Status <=", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusIn(List<Integer> values) {
			addCriterion("delete_Status in", values, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotIn(List<Integer> values) {
			addCriterion("delete_Status not in", values, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusBetween(Integer value1, Integer value2) {
			addCriterion("delete_Status between", value1, value2, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("delete_Status not between", value1, value2, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andIcNameIsNull() {
			addCriterion("ic_name is null");
			return (Criteria) this;
		}

		public Criteria andIcNameIsNotNull() {
			addCriterion("ic_name is not null");
			return (Criteria) this;
		}

		public Criteria andIcNameEqualTo(String value) {
			addCriterion("ic_name =", value, "icName");
			return (Criteria) this;
		}

		public Criteria andIcNameNotEqualTo(String value) {
			addCriterion("ic_name <>", value, "icName");
			return (Criteria) this;
		}

		public Criteria andIcNameGreaterThan(String value) {
			addCriterion("ic_name >", value, "icName");
			return (Criteria) this;
		}

		public Criteria andIcNameGreaterThanOrEqualTo(String value) {
			addCriterion("ic_name >=", value, "icName");
			return (Criteria) this;
		}

		public Criteria andIcNameLessThan(String value) {
			addCriterion("ic_name <", value, "icName");
			return (Criteria) this;
		}

		public Criteria andIcNameLessThanOrEqualTo(String value) {
			addCriterion("ic_name <=", value, "icName");
			return (Criteria) this;
		}

		public Criteria andIcNameLike(String value) {
			addCriterion("ic_name like", value, "icName");
			return (Criteria) this;
		}

		public Criteria andIcNameNotLike(String value) {
			addCriterion("ic_name not like", value, "icName");
			return (Criteria) this;
		}

		public Criteria andIcNameIn(List<String> values) {
			addCriterion("ic_name in", values, "icName");
			return (Criteria) this;
		}

		public Criteria andIcNameNotIn(List<String> values) {
			addCriterion("ic_name not in", values, "icName");
			return (Criteria) this;
		}

		public Criteria andIcNameBetween(String value1, String value2) {
			addCriterion("ic_name between", value1, value2, "icName");
			return (Criteria) this;
		}

		public Criteria andIcNameNotBetween(String value1, String value2) {
			addCriterion("ic_name not between", value1, value2, "icName");
			return (Criteria) this;
		}

		public Criteria andIcPidIsNull() {
			addCriterion("ic_pid is null");
			return (Criteria) this;
		}

		public Criteria andIcPidIsNotNull() {
			addCriterion("ic_pid is not null");
			return (Criteria) this;
		}

		public Criteria andIcPidEqualTo(Long value) {
			addCriterion("ic_pid =", value, "icPid");
			return (Criteria) this;
		}

		public Criteria andIcPidNotEqualTo(Long value) {
			addCriterion("ic_pid <>", value, "icPid");
			return (Criteria) this;
		}

		public Criteria andIcPidGreaterThan(Long value) {
			addCriterion("ic_pid >", value, "icPid");
			return (Criteria) this;
		}

		public Criteria andIcPidGreaterThanOrEqualTo(Long value) {
			addCriterion("ic_pid >=", value, "icPid");
			return (Criteria) this;
		}

		public Criteria andIcPidLessThan(Long value) {
			addCriterion("ic_pid <", value, "icPid");
			return (Criteria) this;
		}

		public Criteria andIcPidLessThanOrEqualTo(Long value) {
			addCriterion("ic_pid <=", value, "icPid");
			return (Criteria) this;
		}

		public Criteria andIcPidIn(List<Long> values) {
			addCriterion("ic_pid in", values, "icPid");
			return (Criteria) this;
		}

		public Criteria andIcPidNotIn(List<Long> values) {
			addCriterion("ic_pid not in", values, "icPid");
			return (Criteria) this;
		}

		public Criteria andIcPidBetween(Long value1, Long value2) {
			addCriterion("ic_pid between", value1, value2, "icPid");
			return (Criteria) this;
		}

		public Criteria andIcPidNotBetween(Long value1, Long value2) {
			addCriterion("ic_pid not between", value1, value2, "icPid");
			return (Criteria) this;
		}

		public Criteria andIcSequenceIsNull() {
			addCriterion("ic_sequence is null");
			return (Criteria) this;
		}

		public Criteria andIcSequenceIsNotNull() {
			addCriterion("ic_sequence is not null");
			return (Criteria) this;
		}

		public Criteria andIcSequenceEqualTo(Integer value) {
			addCriterion("ic_sequence =", value, "icSequence");
			return (Criteria) this;
		}

		public Criteria andIcSequenceNotEqualTo(Integer value) {
			addCriterion("ic_sequence <>", value, "icSequence");
			return (Criteria) this;
		}

		public Criteria andIcSequenceGreaterThan(Integer value) {
			addCriterion("ic_sequence >", value, "icSequence");
			return (Criteria) this;
		}

		public Criteria andIcSequenceGreaterThanOrEqualTo(Integer value) {
			addCriterion("ic_sequence >=", value, "icSequence");
			return (Criteria) this;
		}

		public Criteria andIcSequenceLessThan(Integer value) {
			addCriterion("ic_sequence <", value, "icSequence");
			return (Criteria) this;
		}

		public Criteria andIcSequenceLessThanOrEqualTo(Integer value) {
			addCriterion("ic_sequence <=", value, "icSequence");
			return (Criteria) this;
		}

		public Criteria andIcSequenceIn(List<Integer> values) {
			addCriterion("ic_sequence in", values, "icSequence");
			return (Criteria) this;
		}

		public Criteria andIcSequenceNotIn(List<Integer> values) {
			addCriterion("ic_sequence not in", values, "icSequence");
			return (Criteria) this;
		}

		public Criteria andIcSequenceBetween(Integer value1, Integer value2) {
			addCriterion("ic_sequence between", value1, value2, "icSequence");
			return (Criteria) this;
		}

		public Criteria andIcSequenceNotBetween(Integer value1, Integer value2) {
			addCriterion("ic_sequence not between", value1, value2, "icSequence");
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
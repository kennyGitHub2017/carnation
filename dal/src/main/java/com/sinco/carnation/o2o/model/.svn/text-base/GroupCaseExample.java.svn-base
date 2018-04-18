package com.sinco.carnation.o2o.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GroupCaseExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public GroupCaseExample() {
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

		public Criteria andCaseIdIsNull() {
			addCriterion("case_id is null");
			return (Criteria) this;
		}

		public Criteria andCaseIdIsNotNull() {
			addCriterion("case_id is not null");
			return (Criteria) this;
		}

		public Criteria andCaseIdEqualTo(String value) {
			addCriterion("case_id =", value, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdNotEqualTo(String value) {
			addCriterion("case_id <>", value, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdGreaterThan(String value) {
			addCriterion("case_id >", value, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdGreaterThanOrEqualTo(String value) {
			addCriterion("case_id >=", value, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdLessThan(String value) {
			addCriterion("case_id <", value, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdLessThanOrEqualTo(String value) {
			addCriterion("case_id <=", value, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdLike(String value) {
			addCriterion("case_id like", value, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdNotLike(String value) {
			addCriterion("case_id not like", value, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdIn(List<String> values) {
			addCriterion("case_id in", values, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdNotIn(List<String> values) {
			addCriterion("case_id not in", values, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdBetween(String value1, String value2) {
			addCriterion("case_id between", value1, value2, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdNotBetween(String value1, String value2) {
			addCriterion("case_id not between", value1, value2, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseNameIsNull() {
			addCriterion("case_name is null");
			return (Criteria) this;
		}

		public Criteria andCaseNameIsNotNull() {
			addCriterion("case_name is not null");
			return (Criteria) this;
		}

		public Criteria andCaseNameEqualTo(String value) {
			addCriterion("case_name =", value, "caseName");
			return (Criteria) this;
		}

		public Criteria andCaseNameNotEqualTo(String value) {
			addCriterion("case_name <>", value, "caseName");
			return (Criteria) this;
		}

		public Criteria andCaseNameGreaterThan(String value) {
			addCriterion("case_name >", value, "caseName");
			return (Criteria) this;
		}

		public Criteria andCaseNameGreaterThanOrEqualTo(String value) {
			addCriterion("case_name >=", value, "caseName");
			return (Criteria) this;
		}

		public Criteria andCaseNameLessThan(String value) {
			addCriterion("case_name <", value, "caseName");
			return (Criteria) this;
		}

		public Criteria andCaseNameLessThanOrEqualTo(String value) {
			addCriterion("case_name <=", value, "caseName");
			return (Criteria) this;
		}

		public Criteria andCaseNameLike(String value) {
			addCriterion("case_name like", value, "caseName");
			return (Criteria) this;
		}

		public Criteria andCaseNameNotLike(String value) {
			addCriterion("case_name not like", value, "caseName");
			return (Criteria) this;
		}

		public Criteria andCaseNameIn(List<String> values) {
			addCriterion("case_name in", values, "caseName");
			return (Criteria) this;
		}

		public Criteria andCaseNameNotIn(List<String> values) {
			addCriterion("case_name not in", values, "caseName");
			return (Criteria) this;
		}

		public Criteria andCaseNameBetween(String value1, String value2) {
			addCriterion("case_name between", value1, value2, "caseName");
			return (Criteria) this;
		}

		public Criteria andCaseNameNotBetween(String value1, String value2) {
			addCriterion("case_name not between", value1, value2, "caseName");
			return (Criteria) this;
		}

		public Criteria andDisplayIsNull() {
			addCriterion("display is null");
			return (Criteria) this;
		}

		public Criteria andDisplayIsNotNull() {
			addCriterion("display is not null");
			return (Criteria) this;
		}

		public Criteria andDisplayEqualTo(Integer value) {
			addCriterion("display =", value, "display");
			return (Criteria) this;
		}

		public Criteria andDisplayNotEqualTo(Integer value) {
			addCriterion("display <>", value, "display");
			return (Criteria) this;
		}

		public Criteria andDisplayGreaterThan(Integer value) {
			addCriterion("display >", value, "display");
			return (Criteria) this;
		}

		public Criteria andDisplayGreaterThanOrEqualTo(Integer value) {
			addCriterion("display >=", value, "display");
			return (Criteria) this;
		}

		public Criteria andDisplayLessThan(Integer value) {
			addCriterion("display <", value, "display");
			return (Criteria) this;
		}

		public Criteria andDisplayLessThanOrEqualTo(Integer value) {
			addCriterion("display <=", value, "display");
			return (Criteria) this;
		}

		public Criteria andDisplayIn(List<Integer> values) {
			addCriterion("display in", values, "display");
			return (Criteria) this;
		}

		public Criteria andDisplayNotIn(List<Integer> values) {
			addCriterion("display not in", values, "display");
			return (Criteria) this;
		}

		public Criteria andDisplayBetween(Integer value1, Integer value2) {
			addCriterion("display between", value1, value2, "display");
			return (Criteria) this;
		}

		public Criteria andDisplayNotBetween(Integer value1, Integer value2) {
			addCriterion("display not between", value1, value2, "display");
			return (Criteria) this;
		}

		public Criteria andSequenceIsNull() {
			addCriterion("sequence is null");
			return (Criteria) this;
		}

		public Criteria andSequenceIsNotNull() {
			addCriterion("sequence is not null");
			return (Criteria) this;
		}

		public Criteria andSequenceEqualTo(Integer value) {
			addCriterion("sequence =", value, "sequence");
			return (Criteria) this;
		}

		public Criteria andSequenceNotEqualTo(Integer value) {
			addCriterion("sequence <>", value, "sequence");
			return (Criteria) this;
		}

		public Criteria andSequenceGreaterThan(Integer value) {
			addCriterion("sequence >", value, "sequence");
			return (Criteria) this;
		}

		public Criteria andSequenceGreaterThanOrEqualTo(Integer value) {
			addCriterion("sequence >=", value, "sequence");
			return (Criteria) this;
		}

		public Criteria andSequenceLessThan(Integer value) {
			addCriterion("sequence <", value, "sequence");
			return (Criteria) this;
		}

		public Criteria andSequenceLessThanOrEqualTo(Integer value) {
			addCriterion("sequence <=", value, "sequence");
			return (Criteria) this;
		}

		public Criteria andSequenceIn(List<Integer> values) {
			addCriterion("sequence in", values, "sequence");
			return (Criteria) this;
		}

		public Criteria andSequenceNotIn(List<Integer> values) {
			addCriterion("sequence not in", values, "sequence");
			return (Criteria) this;
		}

		public Criteria andSequenceBetween(Integer value1, Integer value2) {
			addCriterion("sequence between", value1, value2, "sequence");
			return (Criteria) this;
		}

		public Criteria andSequenceNotBetween(Integer value1, Integer value2) {
			addCriterion("sequence not between", value1, value2, "sequence");
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
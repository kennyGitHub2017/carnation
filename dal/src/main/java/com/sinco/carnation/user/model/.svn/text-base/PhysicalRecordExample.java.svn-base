package com.sinco.carnation.user.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PhysicalRecordExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public PhysicalRecordExample() {
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

		public Criteria andItemCodeIsNull() {
			addCriterion("item_code is null");
			return (Criteria) this;
		}

		public Criteria andItemCodeIsNotNull() {
			addCriterion("item_code is not null");
			return (Criteria) this;
		}

		public Criteria andItemCodeEqualTo(String value) {
			addCriterion("item_code =", value, "itemCode");
			return (Criteria) this;
		}

		public Criteria andItemCodeNotEqualTo(String value) {
			addCriterion("item_code <>", value, "itemCode");
			return (Criteria) this;
		}

		public Criteria andItemCodeGreaterThan(String value) {
			addCriterion("item_code >", value, "itemCode");
			return (Criteria) this;
		}

		public Criteria andItemCodeGreaterThanOrEqualTo(String value) {
			addCriterion("item_code >=", value, "itemCode");
			return (Criteria) this;
		}

		public Criteria andItemCodeLessThan(String value) {
			addCriterion("item_code <", value, "itemCode");
			return (Criteria) this;
		}

		public Criteria andItemCodeLessThanOrEqualTo(String value) {
			addCriterion("item_code <=", value, "itemCode");
			return (Criteria) this;
		}

		public Criteria andItemCodeLike(String value) {
			addCriterion("item_code like", value, "itemCode");
			return (Criteria) this;
		}

		public Criteria andItemCodeNotLike(String value) {
			addCriterion("item_code not like", value, "itemCode");
			return (Criteria) this;
		}

		public Criteria andItemCodeIn(List<String> values) {
			addCriterion("item_code in", values, "itemCode");
			return (Criteria) this;
		}

		public Criteria andItemCodeNotIn(List<String> values) {
			addCriterion("item_code not in", values, "itemCode");
			return (Criteria) this;
		}

		public Criteria andItemCodeBetween(String value1, String value2) {
			addCriterion("item_code between", value1, value2, "itemCode");
			return (Criteria) this;
		}

		public Criteria andItemCodeNotBetween(String value1, String value2) {
			addCriterion("item_code not between", value1, value2, "itemCode");
			return (Criteria) this;
		}

		public Criteria andResultIdIsNull() {
			addCriterion("result_id is null");
			return (Criteria) this;
		}

		public Criteria andResultIdIsNotNull() {
			addCriterion("result_id is not null");
			return (Criteria) this;
		}

		public Criteria andResultIdEqualTo(Long value) {
			addCriterion("result_id =", value, "resultId");
			return (Criteria) this;
		}

		public Criteria andResultIdNotEqualTo(Long value) {
			addCriterion("result_id <>", value, "resultId");
			return (Criteria) this;
		}

		public Criteria andResultIdGreaterThan(Long value) {
			addCriterion("result_id >", value, "resultId");
			return (Criteria) this;
		}

		public Criteria andResultIdGreaterThanOrEqualTo(Long value) {
			addCriterion("result_id >=", value, "resultId");
			return (Criteria) this;
		}

		public Criteria andResultIdLessThan(Long value) {
			addCriterion("result_id <", value, "resultId");
			return (Criteria) this;
		}

		public Criteria andResultIdLessThanOrEqualTo(Long value) {
			addCriterion("result_id <=", value, "resultId");
			return (Criteria) this;
		}

		public Criteria andResultIdIn(List<Long> values) {
			addCriterion("result_id in", values, "resultId");
			return (Criteria) this;
		}

		public Criteria andResultIdNotIn(List<Long> values) {
			addCriterion("result_id not in", values, "resultId");
			return (Criteria) this;
		}

		public Criteria andResultIdBetween(Long value1, Long value2) {
			addCriterion("result_id between", value1, value2, "resultId");
			return (Criteria) this;
		}

		public Criteria andResultIdNotBetween(Long value1, Long value2) {
			addCriterion("result_id not between", value1, value2, "resultId");
			return (Criteria) this;
		}

		public Criteria andValueMaxIsNull() {
			addCriterion("value_max is null");
			return (Criteria) this;
		}

		public Criteria andValueMaxIsNotNull() {
			addCriterion("value_max is not null");
			return (Criteria) this;
		}

		public Criteria andValueMaxEqualTo(Float value) {
			addCriterion("value_max =", value, "valueMax");
			return (Criteria) this;
		}

		public Criteria andValueMaxNotEqualTo(Float value) {
			addCriterion("value_max <>", value, "valueMax");
			return (Criteria) this;
		}

		public Criteria andValueMaxGreaterThan(Float value) {
			addCriterion("value_max >", value, "valueMax");
			return (Criteria) this;
		}

		public Criteria andValueMaxGreaterThanOrEqualTo(Float value) {
			addCriterion("value_max >=", value, "valueMax");
			return (Criteria) this;
		}

		public Criteria andValueMaxLessThan(Float value) {
			addCriterion("value_max <", value, "valueMax");
			return (Criteria) this;
		}

		public Criteria andValueMaxLessThanOrEqualTo(Float value) {
			addCriterion("value_max <=", value, "valueMax");
			return (Criteria) this;
		}

		public Criteria andValueMaxIn(List<Float> values) {
			addCriterion("value_max in", values, "valueMax");
			return (Criteria) this;
		}

		public Criteria andValueMaxNotIn(List<Float> values) {
			addCriterion("value_max not in", values, "valueMax");
			return (Criteria) this;
		}

		public Criteria andValueMaxBetween(Float value1, Float value2) {
			addCriterion("value_max between", value1, value2, "valueMax");
			return (Criteria) this;
		}

		public Criteria andValueMaxNotBetween(Float value1, Float value2) {
			addCriterion("value_max not between", value1, value2, "valueMax");
			return (Criteria) this;
		}

		public Criteria andValueMinIsNull() {
			addCriterion("value_min is null");
			return (Criteria) this;
		}

		public Criteria andValueMinIsNotNull() {
			addCriterion("value_min is not null");
			return (Criteria) this;
		}

		public Criteria andValueMinEqualTo(Float value) {
			addCriterion("value_min =", value, "valueMin");
			return (Criteria) this;
		}

		public Criteria andValueMinNotEqualTo(Float value) {
			addCriterion("value_min <>", value, "valueMin");
			return (Criteria) this;
		}

		public Criteria andValueMinGreaterThan(Float value) {
			addCriterion("value_min >", value, "valueMin");
			return (Criteria) this;
		}

		public Criteria andValueMinGreaterThanOrEqualTo(Float value) {
			addCriterion("value_min >=", value, "valueMin");
			return (Criteria) this;
		}

		public Criteria andValueMinLessThan(Float value) {
			addCriterion("value_min <", value, "valueMin");
			return (Criteria) this;
		}

		public Criteria andValueMinLessThanOrEqualTo(Float value) {
			addCriterion("value_min <=", value, "valueMin");
			return (Criteria) this;
		}

		public Criteria andValueMinIn(List<Float> values) {
			addCriterion("value_min in", values, "valueMin");
			return (Criteria) this;
		}

		public Criteria andValueMinNotIn(List<Float> values) {
			addCriterion("value_min not in", values, "valueMin");
			return (Criteria) this;
		}

		public Criteria andValueMinBetween(Float value1, Float value2) {
			addCriterion("value_min between", value1, value2, "valueMin");
			return (Criteria) this;
		}

		public Criteria andValueMinNotBetween(Float value1, Float value2) {
			addCriterion("value_min not between", value1, value2, "valueMin");
			return (Criteria) this;
		}

		public Criteria andCheckDateIsNull() {
			addCriterion("check_date is null");
			return (Criteria) this;
		}

		public Criteria andCheckDateIsNotNull() {
			addCriterion("check_date is not null");
			return (Criteria) this;
		}

		public Criteria andCheckDateEqualTo(Date value) {
			addCriterionForJDBCDate("check_date =", value, "checkDate");
			return (Criteria) this;
		}

		public Criteria andCheckDateNotEqualTo(Date value) {
			addCriterionForJDBCDate("check_date <>", value, "checkDate");
			return (Criteria) this;
		}

		public Criteria andCheckDateGreaterThan(Date value) {
			addCriterionForJDBCDate("check_date >", value, "checkDate");
			return (Criteria) this;
		}

		public Criteria andCheckDateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("check_date >=", value, "checkDate");
			return (Criteria) this;
		}

		public Criteria andCheckDateLessThan(Date value) {
			addCriterionForJDBCDate("check_date <", value, "checkDate");
			return (Criteria) this;
		}

		public Criteria andCheckDateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("check_date <=", value, "checkDate");
			return (Criteria) this;
		}

		public Criteria andCheckDateIn(List<Date> values) {
			addCriterionForJDBCDate("check_date in", values, "checkDate");
			return (Criteria) this;
		}

		public Criteria andCheckDateNotIn(List<Date> values) {
			addCriterionForJDBCDate("check_date not in", values, "checkDate");
			return (Criteria) this;
		}

		public Criteria andCheckDateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("check_date between", value1, value2, "checkDate");
			return (Criteria) this;
		}

		public Criteria andCheckDateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("check_date not between", value1, value2, "checkDate");
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
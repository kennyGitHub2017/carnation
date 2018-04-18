package com.sinco.carnation.sns.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CheckResultReplyExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public CheckResultReplyExample() {
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

		public Criteria andResultNameIsNull() {
			addCriterion("result_name is null");
			return (Criteria) this;
		}

		public Criteria andResultNameIsNotNull() {
			addCriterion("result_name is not null");
			return (Criteria) this;
		}

		public Criteria andResultNameEqualTo(String value) {
			addCriterion("result_name =", value, "resultName");
			return (Criteria) this;
		}

		public Criteria andResultNameNotEqualTo(String value) {
			addCriterion("result_name <>", value, "resultName");
			return (Criteria) this;
		}

		public Criteria andResultNameGreaterThan(String value) {
			addCriterion("result_name >", value, "resultName");
			return (Criteria) this;
		}

		public Criteria andResultNameGreaterThanOrEqualTo(String value) {
			addCriterion("result_name >=", value, "resultName");
			return (Criteria) this;
		}

		public Criteria andResultNameLessThan(String value) {
			addCriterion("result_name <", value, "resultName");
			return (Criteria) this;
		}

		public Criteria andResultNameLessThanOrEqualTo(String value) {
			addCriterion("result_name <=", value, "resultName");
			return (Criteria) this;
		}

		public Criteria andResultNameLike(String value) {
			addCriterion("result_name like", value, "resultName");
			return (Criteria) this;
		}

		public Criteria andResultNameNotLike(String value) {
			addCriterion("result_name not like", value, "resultName");
			return (Criteria) this;
		}

		public Criteria andResultNameIn(List<String> values) {
			addCriterion("result_name in", values, "resultName");
			return (Criteria) this;
		}

		public Criteria andResultNameNotIn(List<String> values) {
			addCriterion("result_name not in", values, "resultName");
			return (Criteria) this;
		}

		public Criteria andResultNameBetween(String value1, String value2) {
			addCriterion("result_name between", value1, value2, "resultName");
			return (Criteria) this;
		}

		public Criteria andResultNameNotBetween(String value1, String value2) {
			addCriterion("result_name not between", value1, value2, "resultName");
			return (Criteria) this;
		}

		public Criteria andCreateByIsNull() {
			addCriterion("create_by is null");
			return (Criteria) this;
		}

		public Criteria andCreateByIsNotNull() {
			addCriterion("create_by is not null");
			return (Criteria) this;
		}

		public Criteria andCreateByEqualTo(Long value) {
			addCriterion("create_by =", value, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByNotEqualTo(Long value) {
			addCriterion("create_by <>", value, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByGreaterThan(Long value) {
			addCriterion("create_by >", value, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByGreaterThanOrEqualTo(Long value) {
			addCriterion("create_by >=", value, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByLessThan(Long value) {
			addCriterion("create_by <", value, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByLessThanOrEqualTo(Long value) {
			addCriterion("create_by <=", value, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByIn(List<Long> values) {
			addCriterion("create_by in", values, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByNotIn(List<Long> values) {
			addCriterion("create_by not in", values, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByBetween(Long value1, Long value2) {
			addCriterion("create_by between", value1, value2, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByNotBetween(Long value1, Long value2) {
			addCriterion("create_by not between", value1, value2, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIsNull() {
			addCriterion("create_time is null");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIsNotNull() {
			addCriterion("create_time is not null");
			return (Criteria) this;
		}

		public Criteria andCreateTimeEqualTo(Date value) {
			addCriterionForJDBCDate("create_time =", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotEqualTo(Date value) {
			addCriterionForJDBCDate("create_time <>", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThan(Date value) {
			addCriterionForJDBCDate("create_time >", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("create_time >=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThan(Date value) {
			addCriterionForJDBCDate("create_time <", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("create_time <=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIn(List<Date> values) {
			addCriterionForJDBCDate("create_time in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotIn(List<Date> values) {
			addCriterionForJDBCDate("create_time not in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("create_time between", value1, value2, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("create_time not between", value1, value2, "createTime");
			return (Criteria) this;
		}

		public Criteria andHospitalIsNull() {
			addCriterion("hospital is null");
			return (Criteria) this;
		}

		public Criteria andHospitalIsNotNull() {
			addCriterion("hospital is not null");
			return (Criteria) this;
		}

		public Criteria andHospitalEqualTo(String value) {
			addCriterion("hospital =", value, "hospital");
			return (Criteria) this;
		}

		public Criteria andHospitalNotEqualTo(String value) {
			addCriterion("hospital <>", value, "hospital");
			return (Criteria) this;
		}

		public Criteria andHospitalGreaterThan(String value) {
			addCriterion("hospital >", value, "hospital");
			return (Criteria) this;
		}

		public Criteria andHospitalGreaterThanOrEqualTo(String value) {
			addCriterion("hospital >=", value, "hospital");
			return (Criteria) this;
		}

		public Criteria andHospitalLessThan(String value) {
			addCriterion("hospital <", value, "hospital");
			return (Criteria) this;
		}

		public Criteria andHospitalLessThanOrEqualTo(String value) {
			addCriterion("hospital <=", value, "hospital");
			return (Criteria) this;
		}

		public Criteria andHospitalLike(String value) {
			addCriterion("hospital like", value, "hospital");
			return (Criteria) this;
		}

		public Criteria andHospitalNotLike(String value) {
			addCriterion("hospital not like", value, "hospital");
			return (Criteria) this;
		}

		public Criteria andHospitalIn(List<String> values) {
			addCriterion("hospital in", values, "hospital");
			return (Criteria) this;
		}

		public Criteria andHospitalNotIn(List<String> values) {
			addCriterion("hospital not in", values, "hospital");
			return (Criteria) this;
		}

		public Criteria andHospitalBetween(String value1, String value2) {
			addCriterion("hospital between", value1, value2, "hospital");
			return (Criteria) this;
		}

		public Criteria andHospitalNotBetween(String value1, String value2) {
			addCriterion("hospital not between", value1, value2, "hospital");
			return (Criteria) this;
		}

		public Criteria andStatusIsNull() {
			addCriterion("status is null");
			return (Criteria) this;
		}

		public Criteria andStatusIsNotNull() {
			addCriterion("status is not null");
			return (Criteria) this;
		}

		public Criteria andStatusEqualTo(Integer value) {
			addCriterion("status =", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotEqualTo(Integer value) {
			addCriterion("status <>", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThan(Integer value) {
			addCriterion("status >", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("status >=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThan(Integer value) {
			addCriterion("status <", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThanOrEqualTo(Integer value) {
			addCriterion("status <=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusIn(List<Integer> values) {
			addCriterion("status in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotIn(List<Integer> values) {
			addCriterion("status not in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusBetween(Integer value1, Integer value2) {
			addCriterion("status between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("status not between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andResultIsNull() {
			addCriterion("result is null");
			return (Criteria) this;
		}

		public Criteria andResultIsNotNull() {
			addCriterion("result is not null");
			return (Criteria) this;
		}

		public Criteria andResultEqualTo(String value) {
			addCriterion("result =", value, "result");
			return (Criteria) this;
		}

		public Criteria andResultNotEqualTo(String value) {
			addCriterion("result <>", value, "result");
			return (Criteria) this;
		}

		public Criteria andResultGreaterThan(String value) {
			addCriterion("result >", value, "result");
			return (Criteria) this;
		}

		public Criteria andResultGreaterThanOrEqualTo(String value) {
			addCriterion("result >=", value, "result");
			return (Criteria) this;
		}

		public Criteria andResultLessThan(String value) {
			addCriterion("result <", value, "result");
			return (Criteria) this;
		}

		public Criteria andResultLessThanOrEqualTo(String value) {
			addCriterion("result <=", value, "result");
			return (Criteria) this;
		}

		public Criteria andResultLike(String value) {
			addCriterion("result like", value, "result");
			return (Criteria) this;
		}

		public Criteria andResultNotLike(String value) {
			addCriterion("result not like", value, "result");
			return (Criteria) this;
		}

		public Criteria andResultIn(List<String> values) {
			addCriterion("result in", values, "result");
			return (Criteria) this;
		}

		public Criteria andResultNotIn(List<String> values) {
			addCriterion("result not in", values, "result");
			return (Criteria) this;
		}

		public Criteria andResultBetween(String value1, String value2) {
			addCriterion("result between", value1, value2, "result");
			return (Criteria) this;
		}

		public Criteria andResultNotBetween(String value1, String value2) {
			addCriterion("result not between", value1, value2, "result");
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
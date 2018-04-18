package com.sinco.carnation.user.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AddressExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public AddressExample() {
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
			addCriterion("delete_Status is null");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusIsNotNull() {
			addCriterion("delete_Status is not null");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusEqualTo(Boolean value) {
			addCriterion("delete_Status =", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotEqualTo(Boolean value) {
			addCriterion("delete_Status <>", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusGreaterThan(Boolean value) {
			addCriterion("delete_Status >", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusGreaterThanOrEqualTo(Boolean value) {
			addCriterion("delete_Status >=", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusLessThan(Boolean value) {
			addCriterion("delete_Status <", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusLessThanOrEqualTo(Boolean value) {
			addCriterion("delete_Status <=", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusIn(List<Boolean> values) {
			addCriterion("delete_Status in", values, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotIn(List<Boolean> values) {
			addCriterion("delete_Status not in", values, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusBetween(Boolean value1, Boolean value2) {
			addCriterion("delete_Status between", value1, value2, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotBetween(Boolean value1, Boolean value2) {
			addCriterion("delete_Status not between", value1, value2, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andAreaInfoIsNull() {
			addCriterion("area_info is null");
			return (Criteria) this;
		}

		public Criteria andAreaInfoIsNotNull() {
			addCriterion("area_info is not null");
			return (Criteria) this;
		}

		public Criteria andAreaInfoEqualTo(String value) {
			addCriterion("area_info =", value, "areaInfo");
			return (Criteria) this;
		}

		public Criteria andAreaInfoNotEqualTo(String value) {
			addCriterion("area_info <>", value, "areaInfo");
			return (Criteria) this;
		}

		public Criteria andAreaInfoGreaterThan(String value) {
			addCriterion("area_info >", value, "areaInfo");
			return (Criteria) this;
		}

		public Criteria andAreaInfoGreaterThanOrEqualTo(String value) {
			addCriterion("area_info >=", value, "areaInfo");
			return (Criteria) this;
		}

		public Criteria andAreaInfoLessThan(String value) {
			addCriterion("area_info <", value, "areaInfo");
			return (Criteria) this;
		}

		public Criteria andAreaInfoLessThanOrEqualTo(String value) {
			addCriterion("area_info <=", value, "areaInfo");
			return (Criteria) this;
		}

		public Criteria andAreaInfoLike(String value) {
			addCriterion("area_info like", value, "areaInfo");
			return (Criteria) this;
		}

		public Criteria andAreaInfoNotLike(String value) {
			addCriterion("area_info not like", value, "areaInfo");
			return (Criteria) this;
		}

		public Criteria andAreaInfoIn(List<String> values) {
			addCriterion("area_info in", values, "areaInfo");
			return (Criteria) this;
		}

		public Criteria andAreaInfoNotIn(List<String> values) {
			addCriterion("area_info not in", values, "areaInfo");
			return (Criteria) this;
		}

		public Criteria andAreaInfoBetween(String value1, String value2) {
			addCriterion("area_info between", value1, value2, "areaInfo");
			return (Criteria) this;
		}

		public Criteria andAreaInfoNotBetween(String value1, String value2) {
			addCriterion("area_info not between", value1, value2, "areaInfo");
			return (Criteria) this;
		}

		public Criteria andDefaultValIsNull() {
			addCriterion("default_val is null");
			return (Criteria) this;
		}

		public Criteria andDefaultValIsNotNull() {
			addCriterion("default_val is not null");
			return (Criteria) this;
		}

		public Criteria andDefaultValEqualTo(Boolean value) {
			addCriterion("default_val =", value, "defaultVal");
			return (Criteria) this;
		}

		public Criteria andDefaultValNotEqualTo(Boolean value) {
			addCriterion("default_val <>", value, "defaultVal");
			return (Criteria) this;
		}

		public Criteria andDefaultValGreaterThan(Boolean value) {
			addCriterion("default_val >", value, "defaultVal");
			return (Criteria) this;
		}

		public Criteria andDefaultValGreaterThanOrEqualTo(Boolean value) {
			addCriterion("default_val >=", value, "defaultVal");
			return (Criteria) this;
		}

		public Criteria andDefaultValLessThan(Boolean value) {
			addCriterion("default_val <", value, "defaultVal");
			return (Criteria) this;
		}

		public Criteria andDefaultValLessThanOrEqualTo(Boolean value) {
			addCriterion("default_val <=", value, "defaultVal");
			return (Criteria) this;
		}

		public Criteria andDefaultValIn(List<Boolean> values) {
			addCriterion("default_val in", values, "defaultVal");
			return (Criteria) this;
		}

		public Criteria andDefaultValNotIn(List<Boolean> values) {
			addCriterion("default_val not in", values, "defaultVal");
			return (Criteria) this;
		}

		public Criteria andDefaultValBetween(Boolean value1, Boolean value2) {
			addCriterion("default_val between", value1, value2, "defaultVal");
			return (Criteria) this;
		}

		public Criteria andDefaultValNotBetween(Boolean value1, Boolean value2) {
			addCriterion("default_val not between", value1, value2, "defaultVal");
			return (Criteria) this;
		}

		public Criteria andMobileIsNull() {
			addCriterion("mobile is null");
			return (Criteria) this;
		}

		public Criteria andMobileIsNotNull() {
			addCriterion("mobile is not null");
			return (Criteria) this;
		}

		public Criteria andMobileEqualTo(String value) {
			addCriterion("mobile =", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileNotEqualTo(String value) {
			addCriterion("mobile <>", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileGreaterThan(String value) {
			addCriterion("mobile >", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileGreaterThanOrEqualTo(String value) {
			addCriterion("mobile >=", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileLessThan(String value) {
			addCriterion("mobile <", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileLessThanOrEqualTo(String value) {
			addCriterion("mobile <=", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileLike(String value) {
			addCriterion("mobile like", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileNotLike(String value) {
			addCriterion("mobile not like", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileIn(List<String> values) {
			addCriterion("mobile in", values, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileNotIn(List<String> values) {
			addCriterion("mobile not in", values, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileBetween(String value1, String value2) {
			addCriterion("mobile between", value1, value2, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileNotBetween(String value1, String value2) {
			addCriterion("mobile not between", value1, value2, "mobile");
			return (Criteria) this;
		}

		public Criteria andTelephoneIsNull() {
			addCriterion("telephone is null");
			return (Criteria) this;
		}

		public Criteria andTelephoneIsNotNull() {
			addCriterion("telephone is not null");
			return (Criteria) this;
		}

		public Criteria andTelephoneEqualTo(String value) {
			addCriterion("telephone =", value, "telephone");
			return (Criteria) this;
		}

		public Criteria andTelephoneNotEqualTo(String value) {
			addCriterion("telephone <>", value, "telephone");
			return (Criteria) this;
		}

		public Criteria andTelephoneGreaterThan(String value) {
			addCriterion("telephone >", value, "telephone");
			return (Criteria) this;
		}

		public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
			addCriterion("telephone >=", value, "telephone");
			return (Criteria) this;
		}

		public Criteria andTelephoneLessThan(String value) {
			addCriterion("telephone <", value, "telephone");
			return (Criteria) this;
		}

		public Criteria andTelephoneLessThanOrEqualTo(String value) {
			addCriterion("telephone <=", value, "telephone");
			return (Criteria) this;
		}

		public Criteria andTelephoneLike(String value) {
			addCriterion("telephone like", value, "telephone");
			return (Criteria) this;
		}

		public Criteria andTelephoneNotLike(String value) {
			addCriterion("telephone not like", value, "telephone");
			return (Criteria) this;
		}

		public Criteria andTelephoneIn(List<String> values) {
			addCriterion("telephone in", values, "telephone");
			return (Criteria) this;
		}

		public Criteria andTelephoneNotIn(List<String> values) {
			addCriterion("telephone not in", values, "telephone");
			return (Criteria) this;
		}

		public Criteria andTelephoneBetween(String value1, String value2) {
			addCriterion("telephone between", value1, value2, "telephone");
			return (Criteria) this;
		}

		public Criteria andTelephoneNotBetween(String value1, String value2) {
			addCriterion("telephone not between", value1, value2, "telephone");
			return (Criteria) this;
		}

		public Criteria andTrueNameIsNull() {
			addCriterion("true_Name is null");
			return (Criteria) this;
		}

		public Criteria andTrueNameIsNotNull() {
			addCriterion("true_Name is not null");
			return (Criteria) this;
		}

		public Criteria andTrueNameEqualTo(String value) {
			addCriterion("true_Name =", value, "trueName");
			return (Criteria) this;
		}

		public Criteria andTrueNameNotEqualTo(String value) {
			addCriterion("true_Name <>", value, "trueName");
			return (Criteria) this;
		}

		public Criteria andTrueNameGreaterThan(String value) {
			addCriterion("true_Name >", value, "trueName");
			return (Criteria) this;
		}

		public Criteria andTrueNameGreaterThanOrEqualTo(String value) {
			addCriterion("true_Name >=", value, "trueName");
			return (Criteria) this;
		}

		public Criteria andTrueNameLessThan(String value) {
			addCriterion("true_Name <", value, "trueName");
			return (Criteria) this;
		}

		public Criteria andTrueNameLessThanOrEqualTo(String value) {
			addCriterion("true_Name <=", value, "trueName");
			return (Criteria) this;
		}

		public Criteria andTrueNameLike(String value) {
			addCriterion("true_Name like", value, "trueName");
			return (Criteria) this;
		}

		public Criteria andTrueNameNotLike(String value) {
			addCriterion("true_Name not like", value, "trueName");
			return (Criteria) this;
		}

		public Criteria andTrueNameIn(List<String> values) {
			addCriterion("true_Name in", values, "trueName");
			return (Criteria) this;
		}

		public Criteria andTrueNameNotIn(List<String> values) {
			addCriterion("true_Name not in", values, "trueName");
			return (Criteria) this;
		}

		public Criteria andTrueNameBetween(String value1, String value2) {
			addCriterion("true_Name between", value1, value2, "trueName");
			return (Criteria) this;
		}

		public Criteria andTrueNameNotBetween(String value1, String value2) {
			addCriterion("true_Name not between", value1, value2, "trueName");
			return (Criteria) this;
		}

		public Criteria andZipIsNull() {
			addCriterion("zip is null");
			return (Criteria) this;
		}

		public Criteria andZipIsNotNull() {
			addCriterion("zip is not null");
			return (Criteria) this;
		}

		public Criteria andZipEqualTo(String value) {
			addCriterion("zip =", value, "zip");
			return (Criteria) this;
		}

		public Criteria andZipNotEqualTo(String value) {
			addCriterion("zip <>", value, "zip");
			return (Criteria) this;
		}

		public Criteria andZipGreaterThan(String value) {
			addCriterion("zip >", value, "zip");
			return (Criteria) this;
		}

		public Criteria andZipGreaterThanOrEqualTo(String value) {
			addCriterion("zip >=", value, "zip");
			return (Criteria) this;
		}

		public Criteria andZipLessThan(String value) {
			addCriterion("zip <", value, "zip");
			return (Criteria) this;
		}

		public Criteria andZipLessThanOrEqualTo(String value) {
			addCriterion("zip <=", value, "zip");
			return (Criteria) this;
		}

		public Criteria andZipLike(String value) {
			addCriterion("zip like", value, "zip");
			return (Criteria) this;
		}

		public Criteria andZipNotLike(String value) {
			addCriterion("zip not like", value, "zip");
			return (Criteria) this;
		}

		public Criteria andZipIn(List<String> values) {
			addCriterion("zip in", values, "zip");
			return (Criteria) this;
		}

		public Criteria andZipNotIn(List<String> values) {
			addCriterion("zip not in", values, "zip");
			return (Criteria) this;
		}

		public Criteria andZipBetween(String value1, String value2) {
			addCriterion("zip between", value1, value2, "zip");
			return (Criteria) this;
		}

		public Criteria andZipNotBetween(String value1, String value2) {
			addCriterion("zip not between", value1, value2, "zip");
			return (Criteria) this;
		}

		public Criteria andAreaIdIsNull() {
			addCriterion("area_id is null");
			return (Criteria) this;
		}

		public Criteria andAreaIdIsNotNull() {
			addCriterion("area_id is not null");
			return (Criteria) this;
		}

		public Criteria andAreaIdEqualTo(Long value) {
			addCriterion("area_id =", value, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdNotEqualTo(Long value) {
			addCriterion("area_id <>", value, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdGreaterThan(Long value) {
			addCriterion("area_id >", value, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdGreaterThanOrEqualTo(Long value) {
			addCriterion("area_id >=", value, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdLessThan(Long value) {
			addCriterion("area_id <", value, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdLessThanOrEqualTo(Long value) {
			addCriterion("area_id <=", value, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdIn(List<Long> values) {
			addCriterion("area_id in", values, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdNotIn(List<Long> values) {
			addCriterion("area_id not in", values, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdBetween(Long value1, Long value2) {
			addCriterion("area_id between", value1, value2, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdNotBetween(Long value1, Long value2) {
			addCriterion("area_id not between", value1, value2, "areaId");
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
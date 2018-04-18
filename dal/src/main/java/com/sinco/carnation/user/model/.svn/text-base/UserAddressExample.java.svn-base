package com.sinco.carnation.user.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserAddressExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public UserAddressExample() {
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

		public Criteria andAddtimeIsNull() {
			addCriterion("addTime is null");
			return (Criteria) this;
		}

		public Criteria andAddtimeIsNotNull() {
			addCriterion("addTime is not null");
			return (Criteria) this;
		}

		public Criteria andAddtimeEqualTo(Date value) {
			addCriterion("addTime =", value, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeNotEqualTo(Date value) {
			addCriterion("addTime <>", value, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeGreaterThan(Date value) {
			addCriterion("addTime >", value, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeGreaterThanOrEqualTo(Date value) {
			addCriterion("addTime >=", value, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeLessThan(Date value) {
			addCriterion("addTime <", value, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeLessThanOrEqualTo(Date value) {
			addCriterion("addTime <=", value, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeIn(List<Date> values) {
			addCriterion("addTime in", values, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeNotIn(List<Date> values) {
			addCriterion("addTime not in", values, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeBetween(Date value1, Date value2) {
			addCriterion("addTime between", value1, value2, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeNotBetween(Date value1, Date value2) {
			addCriterion("addTime not between", value1, value2, "addtime");
			return (Criteria) this;
		}

		public Criteria andDeletestatusIsNull() {
			addCriterion("deleteStatus is null");
			return (Criteria) this;
		}

		public Criteria andDeletestatusIsNotNull() {
			addCriterion("deleteStatus is not null");
			return (Criteria) this;
		}

		public Criteria andDeletestatusEqualTo(Integer value) {
			addCriterion("deleteStatus =", value, "deletestatus");
			return (Criteria) this;
		}

		public Criteria andDeletestatusNotEqualTo(Integer value) {
			addCriterion("deleteStatus <>", value, "deletestatus");
			return (Criteria) this;
		}

		public Criteria andDeletestatusGreaterThan(Integer value) {
			addCriterion("deleteStatus >", value, "deletestatus");
			return (Criteria) this;
		}

		public Criteria andDeletestatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("deleteStatus >=", value, "deletestatus");
			return (Criteria) this;
		}

		public Criteria andDeletestatusLessThan(Integer value) {
			addCriterion("deleteStatus <", value, "deletestatus");
			return (Criteria) this;
		}

		public Criteria andDeletestatusLessThanOrEqualTo(Integer value) {
			addCriterion("deleteStatus <=", value, "deletestatus");
			return (Criteria) this;
		}

		public Criteria andDeletestatusIn(List<Integer> values) {
			addCriterion("deleteStatus in", values, "deletestatus");
			return (Criteria) this;
		}

		public Criteria andDeletestatusNotIn(List<Integer> values) {
			addCriterion("deleteStatus not in", values, "deletestatus");
			return (Criteria) this;
		}

		public Criteria andDeletestatusBetween(Integer value1, Integer value2) {
			addCriterion("deleteStatus between", value1, value2, "deletestatus");
			return (Criteria) this;
		}

		public Criteria andDeletestatusNotBetween(Integer value1, Integer value2) {
			addCriterion("deleteStatus not between", value1, value2, "deletestatus");
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

		public Criteria andDefaultValEqualTo(Integer value) {
			addCriterion("default_val =", value, "defaultVal");
			return (Criteria) this;
		}

		public Criteria andDefaultValNotEqualTo(Integer value) {
			addCriterion("default_val <>", value, "defaultVal");
			return (Criteria) this;
		}

		public Criteria andDefaultValGreaterThan(Integer value) {
			addCriterion("default_val >", value, "defaultVal");
			return (Criteria) this;
		}

		public Criteria andDefaultValGreaterThanOrEqualTo(Integer value) {
			addCriterion("default_val >=", value, "defaultVal");
			return (Criteria) this;
		}

		public Criteria andDefaultValLessThan(Integer value) {
			addCriterion("default_val <", value, "defaultVal");
			return (Criteria) this;
		}

		public Criteria andDefaultValLessThanOrEqualTo(Integer value) {
			addCriterion("default_val <=", value, "defaultVal");
			return (Criteria) this;
		}

		public Criteria andDefaultValIn(List<Integer> values) {
			addCriterion("default_val in", values, "defaultVal");
			return (Criteria) this;
		}

		public Criteria andDefaultValNotIn(List<Integer> values) {
			addCriterion("default_val not in", values, "defaultVal");
			return (Criteria) this;
		}

		public Criteria andDefaultValBetween(Integer value1, Integer value2) {
			addCriterion("default_val between", value1, value2, "defaultVal");
			return (Criteria) this;
		}

		public Criteria andDefaultValNotBetween(Integer value1, Integer value2) {
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

		public Criteria andTruenameIsNull() {
			addCriterion("trueName is null");
			return (Criteria) this;
		}

		public Criteria andTruenameIsNotNull() {
			addCriterion("trueName is not null");
			return (Criteria) this;
		}

		public Criteria andTruenameEqualTo(String value) {
			addCriterion("trueName =", value, "truename");
			return (Criteria) this;
		}

		public Criteria andTruenameNotEqualTo(String value) {
			addCriterion("trueName <>", value, "truename");
			return (Criteria) this;
		}

		public Criteria andTruenameGreaterThan(String value) {
			addCriterion("trueName >", value, "truename");
			return (Criteria) this;
		}

		public Criteria andTruenameGreaterThanOrEqualTo(String value) {
			addCriterion("trueName >=", value, "truename");
			return (Criteria) this;
		}

		public Criteria andTruenameLessThan(String value) {
			addCriterion("trueName <", value, "truename");
			return (Criteria) this;
		}

		public Criteria andTruenameLessThanOrEqualTo(String value) {
			addCriterion("trueName <=", value, "truename");
			return (Criteria) this;
		}

		public Criteria andTruenameLike(String value) {
			addCriterion("trueName like", value, "truename");
			return (Criteria) this;
		}

		public Criteria andTruenameNotLike(String value) {
			addCriterion("trueName not like", value, "truename");
			return (Criteria) this;
		}

		public Criteria andTruenameIn(List<String> values) {
			addCriterion("trueName in", values, "truename");
			return (Criteria) this;
		}

		public Criteria andTruenameNotIn(List<String> values) {
			addCriterion("trueName not in", values, "truename");
			return (Criteria) this;
		}

		public Criteria andTruenameBetween(String value1, String value2) {
			addCriterion("trueName between", value1, value2, "truename");
			return (Criteria) this;
		}

		public Criteria andTruenameNotBetween(String value1, String value2) {
			addCriterion("trueName not between", value1, value2, "truename");
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
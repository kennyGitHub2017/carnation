package com.sinco.carnation.sns.model;

import java.util.ArrayList;
import java.util.List;

public class CheckResultDetailsExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public CheckResultDetailsExample() {
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

		public Criteria andPhysicalNameIsNull() {
			addCriterion("physical_name is null");
			return (Criteria) this;
		}

		public Criteria andPhysicalNameIsNotNull() {
			addCriterion("physical_name is not null");
			return (Criteria) this;
		}

		public Criteria andPhysicalNameEqualTo(String value) {
			addCriterion("physical_name =", value, "physicalName");
			return (Criteria) this;
		}

		public Criteria andPhysicalNameNotEqualTo(String value) {
			addCriterion("physical_name <>", value, "physicalName");
			return (Criteria) this;
		}

		public Criteria andPhysicalNameGreaterThan(String value) {
			addCriterion("physical_name >", value, "physicalName");
			return (Criteria) this;
		}

		public Criteria andPhysicalNameGreaterThanOrEqualTo(String value) {
			addCriterion("physical_name >=", value, "physicalName");
			return (Criteria) this;
		}

		public Criteria andPhysicalNameLessThan(String value) {
			addCriterion("physical_name <", value, "physicalName");
			return (Criteria) this;
		}

		public Criteria andPhysicalNameLessThanOrEqualTo(String value) {
			addCriterion("physical_name <=", value, "physicalName");
			return (Criteria) this;
		}

		public Criteria andPhysicalNameLike(String value) {
			addCriterion("physical_name like", value, "physicalName");
			return (Criteria) this;
		}

		public Criteria andPhysicalNameNotLike(String value) {
			addCriterion("physical_name not like", value, "physicalName");
			return (Criteria) this;
		}

		public Criteria andPhysicalNameIn(List<String> values) {
			addCriterion("physical_name in", values, "physicalName");
			return (Criteria) this;
		}

		public Criteria andPhysicalNameNotIn(List<String> values) {
			addCriterion("physical_name not in", values, "physicalName");
			return (Criteria) this;
		}

		public Criteria andPhysicalNameBetween(String value1, String value2) {
			addCriterion("physical_name between", value1, value2, "physicalName");
			return (Criteria) this;
		}

		public Criteria andPhysicalNameNotBetween(String value1, String value2) {
			addCriterion("physical_name not between", value1, value2, "physicalName");
			return (Criteria) this;
		}

		public Criteria andMinValeIsNull() {
			addCriterion("min_vale is null");
			return (Criteria) this;
		}

		public Criteria andMinValeIsNotNull() {
			addCriterion("min_vale is not null");
			return (Criteria) this;
		}

		public Criteria andMinValeEqualTo(String value) {
			addCriterion("min_vale =", value, "minVale");
			return (Criteria) this;
		}

		public Criteria andMinValeNotEqualTo(String value) {
			addCriterion("min_vale <>", value, "minVale");
			return (Criteria) this;
		}

		public Criteria andMinValeGreaterThan(String value) {
			addCriterion("min_vale >", value, "minVale");
			return (Criteria) this;
		}

		public Criteria andMinValeGreaterThanOrEqualTo(String value) {
			addCriterion("min_vale >=", value, "minVale");
			return (Criteria) this;
		}

		public Criteria andMinValeLessThan(String value) {
			addCriterion("min_vale <", value, "minVale");
			return (Criteria) this;
		}

		public Criteria andMinValeLessThanOrEqualTo(String value) {
			addCriterion("min_vale <=", value, "minVale");
			return (Criteria) this;
		}

		public Criteria andMinValeLike(String value) {
			addCriterion("min_vale like", value, "minVale");
			return (Criteria) this;
		}

		public Criteria andMinValeNotLike(String value) {
			addCriterion("min_vale not like", value, "minVale");
			return (Criteria) this;
		}

		public Criteria andMinValeIn(List<String> values) {
			addCriterion("min_vale in", values, "minVale");
			return (Criteria) this;
		}

		public Criteria andMinValeNotIn(List<String> values) {
			addCriterion("min_vale not in", values, "minVale");
			return (Criteria) this;
		}

		public Criteria andMinValeBetween(String value1, String value2) {
			addCriterion("min_vale between", value1, value2, "minVale");
			return (Criteria) this;
		}

		public Criteria andMinValeNotBetween(String value1, String value2) {
			addCriterion("min_vale not between", value1, value2, "minVale");
			return (Criteria) this;
		}

		public Criteria andMaxValueIsNull() {
			addCriterion("max_value is null");
			return (Criteria) this;
		}

		public Criteria andMaxValueIsNotNull() {
			addCriterion("max_value is not null");
			return (Criteria) this;
		}

		public Criteria andMaxValueEqualTo(String value) {
			addCriterion("max_value =", value, "maxValue");
			return (Criteria) this;
		}

		public Criteria andMaxValueNotEqualTo(String value) {
			addCriterion("max_value <>", value, "maxValue");
			return (Criteria) this;
		}

		public Criteria andMaxValueGreaterThan(String value) {
			addCriterion("max_value >", value, "maxValue");
			return (Criteria) this;
		}

		public Criteria andMaxValueGreaterThanOrEqualTo(String value) {
			addCriterion("max_value >=", value, "maxValue");
			return (Criteria) this;
		}

		public Criteria andMaxValueLessThan(String value) {
			addCriterion("max_value <", value, "maxValue");
			return (Criteria) this;
		}

		public Criteria andMaxValueLessThanOrEqualTo(String value) {
			addCriterion("max_value <=", value, "maxValue");
			return (Criteria) this;
		}

		public Criteria andMaxValueLike(String value) {
			addCriterion("max_value like", value, "maxValue");
			return (Criteria) this;
		}

		public Criteria andMaxValueNotLike(String value) {
			addCriterion("max_value not like", value, "maxValue");
			return (Criteria) this;
		}

		public Criteria andMaxValueIn(List<String> values) {
			addCriterion("max_value in", values, "maxValue");
			return (Criteria) this;
		}

		public Criteria andMaxValueNotIn(List<String> values) {
			addCriterion("max_value not in", values, "maxValue");
			return (Criteria) this;
		}

		public Criteria andMaxValueBetween(String value1, String value2) {
			addCriterion("max_value between", value1, value2, "maxValue");
			return (Criteria) this;
		}

		public Criteria andMaxValueNotBetween(String value1, String value2) {
			addCriterion("max_value not between", value1, value2, "maxValue");
			return (Criteria) this;
		}

		public Criteria andReferenceValueIsNull() {
			addCriterion("reference_value is null");
			return (Criteria) this;
		}

		public Criteria andReferenceValueIsNotNull() {
			addCriterion("reference_value is not null");
			return (Criteria) this;
		}

		public Criteria andReferenceValueEqualTo(String value) {
			addCriterion("reference_value =", value, "referenceValue");
			return (Criteria) this;
		}

		public Criteria andReferenceValueNotEqualTo(String value) {
			addCriterion("reference_value <>", value, "referenceValue");
			return (Criteria) this;
		}

		public Criteria andReferenceValueGreaterThan(String value) {
			addCriterion("reference_value >", value, "referenceValue");
			return (Criteria) this;
		}

		public Criteria andReferenceValueGreaterThanOrEqualTo(String value) {
			addCriterion("reference_value >=", value, "referenceValue");
			return (Criteria) this;
		}

		public Criteria andReferenceValueLessThan(String value) {
			addCriterion("reference_value <", value, "referenceValue");
			return (Criteria) this;
		}

		public Criteria andReferenceValueLessThanOrEqualTo(String value) {
			addCriterion("reference_value <=", value, "referenceValue");
			return (Criteria) this;
		}

		public Criteria andReferenceValueLike(String value) {
			addCriterion("reference_value like", value, "referenceValue");
			return (Criteria) this;
		}

		public Criteria andReferenceValueNotLike(String value) {
			addCriterion("reference_value not like", value, "referenceValue");
			return (Criteria) this;
		}

		public Criteria andReferenceValueIn(List<String> values) {
			addCriterion("reference_value in", values, "referenceValue");
			return (Criteria) this;
		}

		public Criteria andReferenceValueNotIn(List<String> values) {
			addCriterion("reference_value not in", values, "referenceValue");
			return (Criteria) this;
		}

		public Criteria andReferenceValueBetween(String value1, String value2) {
			addCriterion("reference_value between", value1, value2, "referenceValue");
			return (Criteria) this;
		}

		public Criteria andReferenceValueNotBetween(String value1, String value2) {
			addCriterion("reference_value not between", value1, value2, "referenceValue");
			return (Criteria) this;
		}

		public Criteria andPositiveIsNull() {
			addCriterion("positive is null");
			return (Criteria) this;
		}

		public Criteria andPositiveIsNotNull() {
			addCriterion("positive is not null");
			return (Criteria) this;
		}

		public Criteria andPositiveEqualTo(String value) {
			addCriterion("positive =", value, "positive");
			return (Criteria) this;
		}

		public Criteria andPositiveNotEqualTo(String value) {
			addCriterion("positive <>", value, "positive");
			return (Criteria) this;
		}

		public Criteria andPositiveGreaterThan(String value) {
			addCriterion("positive >", value, "positive");
			return (Criteria) this;
		}

		public Criteria andPositiveGreaterThanOrEqualTo(String value) {
			addCriterion("positive >=", value, "positive");
			return (Criteria) this;
		}

		public Criteria andPositiveLessThan(String value) {
			addCriterion("positive <", value, "positive");
			return (Criteria) this;
		}

		public Criteria andPositiveLessThanOrEqualTo(String value) {
			addCriterion("positive <=", value, "positive");
			return (Criteria) this;
		}

		public Criteria andPositiveLike(String value) {
			addCriterion("positive like", value, "positive");
			return (Criteria) this;
		}

		public Criteria andPositiveNotLike(String value) {
			addCriterion("positive not like", value, "positive");
			return (Criteria) this;
		}

		public Criteria andPositiveIn(List<String> values) {
			addCriterion("positive in", values, "positive");
			return (Criteria) this;
		}

		public Criteria andPositiveNotIn(List<String> values) {
			addCriterion("positive not in", values, "positive");
			return (Criteria) this;
		}

		public Criteria andPositiveBetween(String value1, String value2) {
			addCriterion("positive between", value1, value2, "positive");
			return (Criteria) this;
		}

		public Criteria andPositiveNotBetween(String value1, String value2) {
			addCriterion("positive not between", value1, value2, "positive");
			return (Criteria) this;
		}

		public Criteria andNegativeIsNull() {
			addCriterion("negative is null");
			return (Criteria) this;
		}

		public Criteria andNegativeIsNotNull() {
			addCriterion("negative is not null");
			return (Criteria) this;
		}

		public Criteria andNegativeEqualTo(String value) {
			addCriterion("negative =", value, "negative");
			return (Criteria) this;
		}

		public Criteria andNegativeNotEqualTo(String value) {
			addCriterion("negative <>", value, "negative");
			return (Criteria) this;
		}

		public Criteria andNegativeGreaterThan(String value) {
			addCriterion("negative >", value, "negative");
			return (Criteria) this;
		}

		public Criteria andNegativeGreaterThanOrEqualTo(String value) {
			addCriterion("negative >=", value, "negative");
			return (Criteria) this;
		}

		public Criteria andNegativeLessThan(String value) {
			addCriterion("negative <", value, "negative");
			return (Criteria) this;
		}

		public Criteria andNegativeLessThanOrEqualTo(String value) {
			addCriterion("negative <=", value, "negative");
			return (Criteria) this;
		}

		public Criteria andNegativeLike(String value) {
			addCriterion("negative like", value, "negative");
			return (Criteria) this;
		}

		public Criteria andNegativeNotLike(String value) {
			addCriterion("negative not like", value, "negative");
			return (Criteria) this;
		}

		public Criteria andNegativeIn(List<String> values) {
			addCriterion("negative in", values, "negative");
			return (Criteria) this;
		}

		public Criteria andNegativeNotIn(List<String> values) {
			addCriterion("negative not in", values, "negative");
			return (Criteria) this;
		}

		public Criteria andNegativeBetween(String value1, String value2) {
			addCriterion("negative between", value1, value2, "negative");
			return (Criteria) this;
		}

		public Criteria andNegativeNotBetween(String value1, String value2) {
			addCriterion("negative not between", value1, value2, "negative");
			return (Criteria) this;
		}

		public Criteria andUnitIsNull() {
			addCriterion("unit is null");
			return (Criteria) this;
		}

		public Criteria andUnitIsNotNull() {
			addCriterion("unit is not null");
			return (Criteria) this;
		}

		public Criteria andUnitEqualTo(String value) {
			addCriterion("unit =", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitNotEqualTo(String value) {
			addCriterion("unit <>", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitGreaterThan(String value) {
			addCriterion("unit >", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitGreaterThanOrEqualTo(String value) {
			addCriterion("unit >=", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitLessThan(String value) {
			addCriterion("unit <", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitLessThanOrEqualTo(String value) {
			addCriterion("unit <=", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitLike(String value) {
			addCriterion("unit like", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitNotLike(String value) {
			addCriterion("unit not like", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitIn(List<String> values) {
			addCriterion("unit in", values, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitNotIn(List<String> values) {
			addCriterion("unit not in", values, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitBetween(String value1, String value2) {
			addCriterion("unit between", value1, value2, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitNotBetween(String value1, String value2) {
			addCriterion("unit not between", value1, value2, "unit");
			return (Criteria) this;
		}

		public Criteria andReplyIdIsNull() {
			addCriterion("reply_id is null");
			return (Criteria) this;
		}

		public Criteria andReplyIdIsNotNull() {
			addCriterion("reply_id is not null");
			return (Criteria) this;
		}

		public Criteria andReplyIdEqualTo(Long value) {
			addCriterion("reply_id =", value, "replyId");
			return (Criteria) this;
		}

		public Criteria andReplyIdNotEqualTo(Long value) {
			addCriterion("reply_id <>", value, "replyId");
			return (Criteria) this;
		}

		public Criteria andReplyIdGreaterThan(Long value) {
			addCriterion("reply_id >", value, "replyId");
			return (Criteria) this;
		}

		public Criteria andReplyIdGreaterThanOrEqualTo(Long value) {
			addCriterion("reply_id >=", value, "replyId");
			return (Criteria) this;
		}

		public Criteria andReplyIdLessThan(Long value) {
			addCriterion("reply_id <", value, "replyId");
			return (Criteria) this;
		}

		public Criteria andReplyIdLessThanOrEqualTo(Long value) {
			addCriterion("reply_id <=", value, "replyId");
			return (Criteria) this;
		}

		public Criteria andReplyIdIn(List<Long> values) {
			addCriterion("reply_id in", values, "replyId");
			return (Criteria) this;
		}

		public Criteria andReplyIdNotIn(List<Long> values) {
			addCriterion("reply_id not in", values, "replyId");
			return (Criteria) this;
		}

		public Criteria andReplyIdBetween(Long value1, Long value2) {
			addCriterion("reply_id between", value1, value2, "replyId");
			return (Criteria) this;
		}

		public Criteria andReplyIdNotBetween(Long value1, Long value2) {
			addCriterion("reply_id not between", value1, value2, "replyId");
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
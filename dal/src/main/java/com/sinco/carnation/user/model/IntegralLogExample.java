package com.sinco.carnation.user.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IntegralLogExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public IntegralLogExample() {
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

		public Criteria andIntegralIsNull() {
			addCriterion("integral is null");
			return (Criteria) this;
		}

		public Criteria andIntegralIsNotNull() {
			addCriterion("integral is not null");
			return (Criteria) this;
		}

		public Criteria andIntegralEqualTo(Integer value) {
			addCriterion("integral =", value, "integral");
			return (Criteria) this;
		}

		public Criteria andIntegralNotEqualTo(Integer value) {
			addCriterion("integral <>", value, "integral");
			return (Criteria) this;
		}

		public Criteria andIntegralGreaterThan(Integer value) {
			addCriterion("integral >", value, "integral");
			return (Criteria) this;
		}

		public Criteria andIntegralGreaterThanOrEqualTo(Integer value) {
			addCriterion("integral >=", value, "integral");
			return (Criteria) this;
		}

		public Criteria andIntegralLessThan(Integer value) {
			addCriterion("integral <", value, "integral");
			return (Criteria) this;
		}

		public Criteria andIntegralLessThanOrEqualTo(Integer value) {
			addCriterion("integral <=", value, "integral");
			return (Criteria) this;
		}

		public Criteria andIntegralIn(List<Integer> values) {
			addCriterion("integral in", values, "integral");
			return (Criteria) this;
		}

		public Criteria andIntegralNotIn(List<Integer> values) {
			addCriterion("integral not in", values, "integral");
			return (Criteria) this;
		}

		public Criteria andIntegralBetween(Integer value1, Integer value2) {
			addCriterion("integral between", value1, value2, "integral");
			return (Criteria) this;
		}

		public Criteria andIntegralNotBetween(Integer value1, Integer value2) {
			addCriterion("integral not between", value1, value2, "integral");
			return (Criteria) this;
		}

		public Criteria andTypeIsNull() {
			addCriterion("type is null");
			return (Criteria) this;
		}

		public Criteria andTypeIsNotNull() {
			addCriterion("type is not null");
			return (Criteria) this;
		}

		public Criteria andTypeEqualTo(String value) {
			addCriterion("type =", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotEqualTo(String value) {
			addCriterion("type <>", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThan(String value) {
			addCriterion("type >", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThanOrEqualTo(String value) {
			addCriterion("type >=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThan(String value) {
			addCriterion("type <", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThanOrEqualTo(String value) {
			addCriterion("type <=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLike(String value) {
			addCriterion("type like", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotLike(String value) {
			addCriterion("type not like", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeIn(List<String> values) {
			addCriterion("type in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotIn(List<String> values) {
			addCriterion("type not in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeBetween(String value1, String value2) {
			addCriterion("type between", value1, value2, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotBetween(String value1, String value2) {
			addCriterion("type not between", value1, value2, "type");
			return (Criteria) this;
		}

		public Criteria andIntegralUserIdIsNull() {
			addCriterion("integral_user_id is null");
			return (Criteria) this;
		}

		public Criteria andIntegralUserIdIsNotNull() {
			addCriterion("integral_user_id is not null");
			return (Criteria) this;
		}

		public Criteria andIntegralUserIdEqualTo(Long value) {
			addCriterion("integral_user_id =", value, "integralUserId");
			return (Criteria) this;
		}

		public Criteria andIntegralUserIdNotEqualTo(Long value) {
			addCriterion("integral_user_id <>", value, "integralUserId");
			return (Criteria) this;
		}

		public Criteria andIntegralUserIdGreaterThan(Long value) {
			addCriterion("integral_user_id >", value, "integralUserId");
			return (Criteria) this;
		}

		public Criteria andIntegralUserIdGreaterThanOrEqualTo(Long value) {
			addCriterion("integral_user_id >=", value, "integralUserId");
			return (Criteria) this;
		}

		public Criteria andIntegralUserIdLessThan(Long value) {
			addCriterion("integral_user_id <", value, "integralUserId");
			return (Criteria) this;
		}

		public Criteria andIntegralUserIdLessThanOrEqualTo(Long value) {
			addCriterion("integral_user_id <=", value, "integralUserId");
			return (Criteria) this;
		}

		public Criteria andIntegralUserIdIn(List<Long> values) {
			addCriterion("integral_user_id in", values, "integralUserId");
			return (Criteria) this;
		}

		public Criteria andIntegralUserIdNotIn(List<Long> values) {
			addCriterion("integral_user_id not in", values, "integralUserId");
			return (Criteria) this;
		}

		public Criteria andIntegralUserIdBetween(Long value1, Long value2) {
			addCriterion("integral_user_id between", value1, value2, "integralUserId");
			return (Criteria) this;
		}

		public Criteria andIntegralUserIdNotBetween(Long value1, Long value2) {
			addCriterion("integral_user_id not between", value1, value2, "integralUserId");
			return (Criteria) this;
		}

		public Criteria andOperateUserIdIsNull() {
			addCriterion("operate_user_id is null");
			return (Criteria) this;
		}

		public Criteria andOperateUserIdIsNotNull() {
			addCriterion("operate_user_id is not null");
			return (Criteria) this;
		}

		public Criteria andOperateUserIdEqualTo(Long value) {
			addCriterion("operate_user_id =", value, "operateUserId");
			return (Criteria) this;
		}

		public Criteria andOperateUserIdNotEqualTo(Long value) {
			addCriterion("operate_user_id <>", value, "operateUserId");
			return (Criteria) this;
		}

		public Criteria andOperateUserIdGreaterThan(Long value) {
			addCriterion("operate_user_id >", value, "operateUserId");
			return (Criteria) this;
		}

		public Criteria andOperateUserIdGreaterThanOrEqualTo(Long value) {
			addCriterion("operate_user_id >=", value, "operateUserId");
			return (Criteria) this;
		}

		public Criteria andOperateUserIdLessThan(Long value) {
			addCriterion("operate_user_id <", value, "operateUserId");
			return (Criteria) this;
		}

		public Criteria andOperateUserIdLessThanOrEqualTo(Long value) {
			addCriterion("operate_user_id <=", value, "operateUserId");
			return (Criteria) this;
		}

		public Criteria andOperateUserIdIn(List<Long> values) {
			addCriterion("operate_user_id in", values, "operateUserId");
			return (Criteria) this;
		}

		public Criteria andOperateUserIdNotIn(List<Long> values) {
			addCriterion("operate_user_id not in", values, "operateUserId");
			return (Criteria) this;
		}

		public Criteria andOperateUserIdBetween(Long value1, Long value2) {
			addCriterion("operate_user_id between", value1, value2, "operateUserId");
			return (Criteria) this;
		}

		public Criteria andOperateUserIdNotBetween(Long value1, Long value2) {
			addCriterion("operate_user_id not between", value1, value2, "operateUserId");
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